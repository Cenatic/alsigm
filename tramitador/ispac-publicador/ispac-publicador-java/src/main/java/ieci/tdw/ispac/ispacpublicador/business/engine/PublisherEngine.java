package ieci.tdw.ispac.ispacpublicador.business.engine;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.audit.business.vo.AuditContext;
import ieci.tdw.ispac.audit.context.AuditContextHolder;
import ieci.tdw.ispac.ispaclib.util.ISPACConfiguration;
import ieci.tdw.ispac.ispaclib.utils.CollectionUtils;
import ieci.tdw.ispac.ispaclib.utils.InetUtils;
import ieci.tdw.ispac.ispacpublicador.business.bi.IPublisherBI;
import ieci.tdw.ispac.ispacpublicador.business.config.ConfigurationParams;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.RenderException;
import ieci.tdw.ispac.ispacpublicador.business.milestone.ActiveMilestoneHandler;
import ieci.tdw.ispac.ispacpublicador.business.reader.IReader;
import ieci.tdw.ispac.ispacpublicador.business.reader.ReaderMgr;
import ieci.tdw.ispac.ispacpublicador.business.service.ServiceLocator;
import ieci.tdw.ispac.ispacpublicador.business.vo.ActiveMilestoneVO;
import ieci.tdw.ispac.ispacpublicador.business.vo.MilestoneVO;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * Clase encargada de la Gesti�n de los Hitos.
 *
 */
public class PublisherEngine {

    /** Logger de la clase. */
    protected static final Logger logger =
    	Logger.getLogger(PublisherEngine.class);

    /** Logger para el proceso de hitos. */
    protected static final Logger processMilisteneLogger =
    	Logger.getLogger("MILESTONE_PROCESS");


    public static void execute(){
        try {

			// Auditor�a
			AuditContext auditContext = new AuditContext();
			auditContext.setUserHost(InetUtils.getLocalHostName());
			auditContext.setUserIP(InetUtils.getLocalHostAddress());
			auditContext.setUser("PUBLICADOR");
			auditContext.setUserId("SYSTEM");
			// A�adir en el ThreadLocal el objeto AuditContext
			AuditContextHolder.setAuditContext(auditContext);

            if (processMilisteneLogger.isInfoEnabled()) {
                processMilisteneLogger.info("Inicio procesamiento de hitos");
            }

            //Desbloqueamos aquellos hitos que lleven mas tiempo del permitido
            //bloqueados
            unlockActiveMilestone();

            //Obtenemos los nuevos hitos aparecidos
            getNewMilestones();

            //Procesamos los nuevos Hitos Activos
            processActiveMilestones();

            //Limpiamos los Hitos tratados
            cleanTreatedMilestones();

            if (processMilisteneLogger.isInfoEnabled()) {
                processMilisteneLogger.info("Fin procesamiento de hitos");
            }

        } catch (ISPACException e) {
            RenderException.show(logger, e);
        } catch (Exception e){
            RenderException.show(logger, e);
	    }
    }


    /**
     * Desbloquea aquellos hitos activos que hayan superado el m�ximo tiempo
     * permitido para que una aplicaci�n tenga bloqueado un hito.
     * @throws ISPACException
     */
    private static void unlockActiveMilestone() throws ISPACException {

        //Obtenemos el servicio del Publicador
        IPublisherBI publisherService = ServiceLocator.lookupPublisherBI();

        //Instancia del fichero de configuracion
        ISPACConfiguration config = ISPACConfiguration.getInstance();

        //Nombre de esta aplicaci�n
        String appName = config.get(ConfigurationParams.APPLICATION_NAME);

        //Otenemos los hitos bloqueados por esta aplicacion
        List lockedMilestoneList =
        	publisherService.getLockedActiveMilestones(appName);

        //Obtenemos el timeout del fichero de configuracion
        long timeout = Long.parseLong(config.get(
        		ConfigurationParams.LOCK_TIME_OUT));

        //Recorremos todos los hitos activos bloqueados para desbloquear
        // aquellos que hayan superado el maximo tiempo de bloqueo (timeout)
        int count = 0;

        for (Iterator iter = lockedMilestoneList.iterator(); iter.hasNext();) {
            ActiveMilestoneVO vo = (ActiveMilestoneVO) iter.next();
        	//TODO Confirmar: Hay que tener en cuenta si se puede dar el caso de tener mas de 1 instancia de la aplicacion corriendo en la misma maquina,
        	//entonces no se podria desbloquear hitos activos s�lo por estar bloqueado por 1 aplicacion de la misma maquina
            if (unlockByIP(publisherService, vo)
            		|| unlockByTimeOut(publisherService, vo, timeout)) {
		    	count++;
            }
        }

        if (logger.isInfoEnabled()) {
            logger.info("Hitos desbloqueados: "+count);
        }
    }

    /**
     * @param publisherService Servicio del publicador
     * @param vo Value Object que representa al Hito Activo a desbloquear
     * @param timeout Tiempo m�ximo permitido para que un Hito Activo est� bloqueado
     * @return true si el tipo se ha desbloqueado porque ha superado el tiempo
     * m�ximo permitido para estar bloqueado (<code>'timeout'</code>), false en caso
     * contrario
     * @throws ISPACException
     */
    private static boolean unlockByTimeOut(IPublisherBI publisherService,
    		ActiveMilestoneVO vo, long timeout) throws ISPACException {
        long timeStamp = vo.getTimeStamp().getTime();
		long actual_ms = System.currentTimeMillis();
		long diff = actual_ms - timeStamp;
		if (diff >= timeout) {
		    return (publisherService.unlockActiveMilestone(vo));
		}
        return false;
    }


	//TODO Confirmar: Hay que tener en cuenta si se puede dar el caso de tener mas de 1 instancia de la aplicacion corriendo en la misma maquina,
	//entonces no se podria desbloquear hitos activos s�lo por estar bloqueado por 1 aplicacion de la misma maquina
    /**
     * @param publisherService Servicio del publicador
     * @param vo Value Object que representa al Hito Activo a desbloquear
     * @return true si el Hito Activo <code>'vo'</code> se ha desbloqueado porque
     * est� bloqueado por una aplicaci�n que se encuentra en la misma IP de esta aplicaci�n.
     * @throws ISPACException
     *
     */
    private static boolean unlockByIP(IPublisherBI publisherService,
    		ActiveMilestoneVO vo) throws ISPACException {

		//IP de la maquina en la que esta corriendo la aplicacion
		String ipMaquina = null;
		try {
		    ipMaquina = InetUtils.getLocalHostAddress();
		} catch (ISPACException e) {
		    RenderException.show(logger, e);
		}

        //Si el Hito Activo esta bloqueado (puede ser porque se cayo la aplicacion cuando lo estaba tratanto) por esta maquina...
		if (vo.getIPMaquina()!= null && vo.getIPMaquina().equals(ipMaquina)){
		    //... se desbloquea para poder volver a tratarlo
		    return (publisherService.unlockActiveMilestone(vo));
		}

		return false;
    }


    /**
     * Obtiene los Hitos Activos nuevos despu�s de llamar a los lectores
     * de sistemas externos dados de alta en la aplicaci�n
     * @throws ISPACException
     *
     */
    private static void getNewMilestones() throws ISPACException{

        //Obtenemos la lista de aplicaciones activas
        IPublisherBI publisherService = ServiceLocator.lookupPublisherBI();
        List activeAppList = publisherService.getActiveApplications();
        if (!CollectionUtils.isEmpty(activeAppList)) {

	        //Lista de instancias de todos los lectores dados de alta en la
	        //aplicaci�n
	        List readers = ReaderMgr.getInstance().getReaders();
	        IReader reader;
	        for (Iterator iter = readers.iterator(); iter.hasNext();) {
	            reader = (IReader) iter.next();
	            getMilestonesReader(reader, activeAppList);
	        }
        }
    }

    /**
     * @param reader Lector a utilizar para obtener nuevos Hitos Activos.
     * @param activeAppList aplicaciones para las que se van a dar de alta los
     * nuevos Hitos Activos obtenidos mediante el lector <code>'reader'</code>.
     * @throws ISPACException
     */
    private static void getMilestonesReader(IReader reader, List activeAppList)
    		throws ISPACException{

        //Obtenemos de todos los hitos a tratar que tenemos el identificador de
    	//hito menor.
        IPublisherBI publisherService = ServiceLocator.lookupPublisherBI();

        //L�mite inferior de los nuevos hitos seg�n el sistema externo obtenido
        //del lector
        int infLimitId = publisherService.getInfLimitMilestoneId(
        				reader.getIdSistemExterno());

        //Obtenemos una lista con los hitos nuevos aparecidos.
        List milestoneList = reader.getMilestoneList(infLimitId);

        //Insertamos nuevos Hitos Activos para las aplicaciones activas,
        //siempre que haya nuevos hitos y aplicacioens activas
        int countInsert = 0;
        if (!CollectionUtils.isEmpty(milestoneList)
        		&& !CollectionUtils.isEmpty(activeAppList)) {
            countInsert = publisherService.insertActiveMilestone(milestoneList,
            		activeAppList, reader.getIdSistemExterno());

            // Actualizar el l�mite inferior
            MilestoneVO lastMilestone =
            	(MilestoneVO) milestoneList.get(milestoneList.size()-1);
            publisherService.updateInfLimit(reader.getIdSistemExterno(),
            		lastMilestone.getIdHito());
        	if (logger.isInfoEnabled()) {
        	    logger.info("Actualizado el valor Limite inferior de hitos activos para el sistema externo: '"
        	    		+ reader.getIdSistemExterno() + "' al valor '"
        	    		+ lastMilestone.getIdHito() + "'");
        	}
        }
        if (logger.isInfoEnabled()) {
            logger.info("Nuevos Hitos Activos Insertados: "+countInsert
            		+", procedentes de '"+reader.getIdSistemExterno()+"'");
        }
    }




    /**
     * Procesa todos los Hitos Activos asociados a la aplicaci�n
     * cuyo nombre se extrae del fichero de configuraci�n correspondiente.
     * @throws ISPACException
     */
    private static void processActiveMilestones()
    		throws ISPACException {

        //Procesamos los Hitos Activos para esta aplicaci�n
        ISPACConfiguration config = ISPACConfiguration.getInstance();
        String appName = config.get(ConfigurationParams.APPLICATION_NAME);
        ActiveMilestoneHandler milestoneHdlr = new ActiveMilestoneHandler();
        milestoneHdlr.processActiveMilestones(appName);
    }



    /**
     * Libera aquellos Hitos Activos que ya han sido tratado
     * por todas las aplicaciones activas.
     * Adem�s actualiza el valor del �ltimo Hito Activo liberado,
     * que servir� de filtro para la b�squeda de nuevos hitos.
     * @throws ISPACException
     */
    private static void cleanTreatedMilestones() throws ISPACException {
        //Servicio del publicador.
        IPublisherBI publisherService = ServiceLocator.lookupPublisherBI();

        //Liberamos los hitos que ya hayan sido tratados por todas las
        //aplicaciones activas
        int res = publisherService.cleanTreatedMilestones();

        if (processMilisteneLogger.isInfoEnabled()) {
            processMilisteneLogger.info(new StringBuffer()
	        	.append("Se han limpiado '")
	        	.append(res)
	        	.append("' registros por haber sido tratados.")
	        	.toString());
        }
    }
}
