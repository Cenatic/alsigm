package ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica;

import java.util.Date;

import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.utils.TypeConverter;
import ieci.tdw.ispac.ispacpublicador.business.action.SigemBaseAction;
import ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.service.ConsultaTelematicaService;
import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;
import ieci.tecdoc.sgm.base.guid.Guid;
import ieci.tecdoc.sgm.core.exception.SigemException;
import ieci.tecdoc.sgm.core.services.ConstantesServicios;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.consulta.FicherosHito;
import ieci.tecdoc.sgm.core.services.consulta.HitoExpediente;
import ieci.tecdoc.sgm.core.services.consulta.ServicioConsultaExpedientes;

import org.apache.log4j.Logger;

/**
 * Acci�n para dar de alta un hito del estado de un expediente 
 * en la Consulta Telem�tica.
 * 
 */
public class EstablecerHitoActualAction extends SigemBaseAction {

	//========================================================================
	// Constantes de los nombres de los par�metros de la regla
	//========================================================================
	private static final String CODIGO 				= "CODIGO";
	private static final String DESCRIPCION 		= "DESCRIPCION";
	private static final String PASO_A_HISTORICO 	= "PASO_A_HISTORICO";
	private static final String ENVIAR_DOCUMENTOS 	= "ENVIAR_DOCUMENTOS";
	//========================================================================
	
	/** Logger de la clase. */
    private static final Logger logger = 
    	Logger.getLogger(EstablecerHitoActualAction.class);

	/** Logger de la clase. */
    private static final Logger CONSULTA_TELEMATICA = 
    	Logger.getLogger("CONSULTA_TELEMATICA");

    
    /**
     * Constructor.
     * 
     */
    public EstablecerHitoActualAction() {
    	super();
    }
    
    /**
     * Ejecuta la acci�n.
     * @param rctx Contexto de ejecuci�n de la regla
     * @param attContext Atributos con informaci�n extra, utilizados dentro de 
     * la ejecuci�n de la regla.
     * @return true si la ejecuci�n termina correctamente, false en caso 
     * contrario.
     * @throws ActionException si ocurre alg�n error.
     */
    public boolean execute(RuleContext rctx, AttributeContext attContext) 
    		throws ActionException {
    	
        if (logger.isInfoEnabled()) {
            logger.info("Acci�n [" + this.getClass().getName() 
            		+ "] en ejecuci�n");
        }

        HitoExpediente hito = new HitoExpediente();
        
        try {

        	// Establecer el hito actual
        	hito = establecerHitoActual(rctx, attContext);

	        // Comprobar si hay que enviar los documentos asociados al hito
	        if ("S".equalsIgnoreCase(
	        		attContext.getAttribute(ENVIAR_DOCUMENTOS))) {
	        	anexarFicheros(rctx, hito);
	        }

	        // Log del hito
	        logOk(hito);

        } catch (Throwable e) {
        	setInfo("Error al establecer hito actual: " + e.toString());
        	logError(hito, e);
            throw new ActionException(e);
        }
        
        return true;
    }
    
    private HitoExpediente establecerHitoActual(RuleContext rctx, 
    		AttributeContext attContext) throws SigemException {
    	
    	// Informaci�n del hito
    	HitoExpediente hito = new HitoExpediente();
		hito.setGuid(new Guid().toString());
		hito.setNumeroExpediente(rctx.getIdObjeto());
		hito.setCodigo(StringUtils.nullToEmpty(attContext.getAttribute(CODIGO)));
		hito.setFecha(TypeConverter.toString(new Date(), ConstantesServicios.DATE_PATTERN));
		hito.setDescripcion(attContext.getAttribute(DESCRIPCION));
		hito.setInformacionAuxiliar("");
		
		// Paso a hist�rico del hito anterior
        boolean pasoAHistorico = "S".equalsIgnoreCase(
        		attContext.getAttribute(PASO_A_HISTORICO));

        // Establece el hito actual en Consulta Telem�tica
		ServicioConsultaExpedientes consulta = 
			LocalizadorServicios.getServicioConsultaExpedientes();
		consulta.establecerHitoActual(hito, new FicherosHito(), pasoAHistorico, getEntidad());
		
		// Devolver la informaci�n del hito creado
		return consulta.obtenerHitoEstado(rctx.getIdObjeto(), getEntidad());
    }
    
    private void anexarFicheros(RuleContext rctx, HitoExpediente hito) 
    		throws Exception {
    	
        ConsultaTelematicaService service = new ConsultaTelematicaService();
        FicherosHito ficheros = null;

        // Obtener el identificador del tr�mite
    	int idTramite = TypeConverter.parseInt((String) rctx.getProperties().get("id_tramite"), -1);
    	int idFase = TypeConverter.parseInt((String) rctx.getProperties().get("id_fase"), -1);

        try {

			// Llamada al API de Consulta Telem�tica
			ServicioConsultaExpedientes consulta = 
				LocalizadorServicios.getServicioConsultaExpedientes();

	        // Obtener los ficheros asociados al hito en tramitaci�n
	        if (idTramite > 0) {
		        ficheros = service.getFicherosTramite(hito.getGuid(), rctx.getIdObjeto(), idTramite);
	        } else if (idFase > 0) {
		        ficheros = service.getFicherosFase(hito.getGuid(), rctx.getIdObjeto(), idFase);
	        } else {
	        	logger.warn("No se ha encontrado ning�n identificador de fase o tr�mite");
	        }

	        // Anexar los ficheros al hito actual en CT
	        if ((ficheros != null) && ficheros.count() > 0) {
	        	consulta.anexarFicherosHitoActual(ficheros, getEntidad());
	        }

        } catch (Exception e) {
        	logger.error("Error al anexar ficheros al hito: " 
        			+ hito.getGuid(), e);
        	
        	try {
	        	// Eliminar los ficheros anexados
	    		service.deleteFicherosHito(ficheros);
        	} catch (Throwable t) {
        		logger.warn("No se han podido eliminar los ficheros en RDE", e);
        	}
        	
            throw e;
        }
    }
    
    /**
     * Muestra un log del hito.
     * @param hito Datos del hito.
     */
    private static void logOk(HitoExpediente hito) {
    	
    	if (CONSULTA_TELEMATICA.isInfoEnabled()) {
    		
	        // Informaci�n del hito
	        StringBuffer hitoInfo = new StringBuffer()
	        	.append("- HITO ESTADO: ")
	        	.append(toString(hito));
	        
	        // Log del resultado de la acci�n
	        CONSULTA_TELEMATICA.info("Alta de hito actual:\n" 
	        		+ hitoInfo.toString());
    	}
    }

    /**
     * Muestra un log de error.
     * @param hito Datos del hito.
     */
    private static void logError(HitoExpediente hito, Throwable e) {
    	
        // Informaci�n del hito
        StringBuffer hitoInfo = new StringBuffer()
        	.append("- HITO ESTADO: ")
        	.append(toString(hito));
        
        // Log del error
        CONSULTA_TELEMATICA.error("Error en la acci�n " 
        		+ EstablecerHitoActualAction.class.getName() + ":\n" 
        		+ hitoInfo.toString(), e);
    }
    
    /**
     * Obtiene una cadena con la informaci�n del hito.
     * @param hito Informaci�n del hito.
     * @return Cadena con la informaci�n del hito.
     */
    private static String toString(HitoExpediente hito) {
    	if (hito != null) {
	    	return new StringBuffer()
	    		.append("guid=[").append(hito.getGuid()).append("]")
	    		.append(", numeroExpediente=[").append(hito.getNumeroExpediente())
	    		.append("]")
	    		.append(", codigo=[").append(hito.getCodigo()).append("]")
	    		.append(", fecha=[").append(hito.getFecha()).append("]")
	    		.append(", descripcion=[").append(hito.getDescripcion()).append("]")
	    		.append(", informacionAuxiliar=[")
	    		.append(hito.getInformacionAuxiliar()).append("]")
	    		.toString();
    	} else {
    		return null;
    	}
    }
}