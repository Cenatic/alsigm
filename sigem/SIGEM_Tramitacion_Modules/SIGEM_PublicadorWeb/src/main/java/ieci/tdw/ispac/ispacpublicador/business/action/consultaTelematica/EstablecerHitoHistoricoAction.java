package ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica;

import java.util.Date;

import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.utils.TypeConverter;
import ieci.tdw.ispac.ispacpublicador.business.action.SigemBaseAction;
import ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.vo.HitoVO;
import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;
import ieci.tecdoc.sgm.base.guid.Guid;
import ieci.tecdoc.sgm.core.services.ConstantesServicios;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.consulta.HitoExpediente;
import ieci.tecdoc.sgm.core.services.consulta.ServicioConsultaExpedientes;

import org.apache.log4j.Logger;

/**
 * Acci�n para dar de alta un hito hist�rico de un expediente 
 * en la Consulta Telem�tica.
 * 
 */
public class EstablecerHitoHistoricoAction extends SigemBaseAction {

	/** Logger de la clase. */
    private static final Logger logger = 
    	Logger.getLogger(EstablecerHitoHistoricoAction.class);

	/** Logger de la clase. */
    private static final Logger CONSULTA_TELEMATICA = 
    	Logger.getLogger("CONSULTA_TELEMATICA");


    /**
     * Constructor.
     * 
     */
    public EstablecerHitoHistoricoAction() {
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
            logger.info("Acci�n [" + this.getClass().getName() + "] en ejecuci�n");
        }

        HitoVO hito = null;
        
        try {
	        
        	// Informaci�n del hito
	        hito = new HitoVO();
	        hito.setCnumexp(rctx.getIdObjeto());
	        hito.setCguid(String.valueOf(rctx.getIdHito()));
	        hito.setCcod(attContext.getAttribute("CODIGO"));
	        hito.setCfecha(new Date());
	        hito.setCdescr(attContext.getAttribute("DESCRIPCION"));
	        hito.setCinfoaux("");
	        
	        // Establece el hito hist�rico en Consulta Telem�tica
	        establecerHitoHistorico(hito);

	        // Log del hito
	        logOk(hito);

        } catch (Throwable e) {
        	setInfo("Error al establecer hito hist�rico: " + e.toString());
        	logError(hito, e);
            throw new ActionException(e);
        }
        
        return true;
    }

    /**
     * Muestra un log del hito.
     * @param hito Datos del hito.
     */
    private void logOk(HitoVO hito) {
    	
    	if (CONSULTA_TELEMATICA.isInfoEnabled()) {
    		
	        // Informaci�n del hito
	        StringBuffer hitoInfo = new StringBuffer()
	        	.append("- HITO HIST�RICO: ")
	        	.append(hito);
	        
	        // Log del resultado de la acci�n
	        CONSULTA_TELEMATICA.info("Alta de hito hist�rico:\n" 
	        		+ hitoInfo.toString());
    	}
    }

    /**
     * Muestra un log de error.
     * @param hito Datos del hito.
     */
    private static void logError(HitoVO hito, Throwable e) {
    	
        // Informaci�n del hito
        StringBuffer hitoInfo = new StringBuffer()
        	.append("- HITO HIST�RICO: ")
        	.append(hito);
        
        // Log del error
        CONSULTA_TELEMATICA.error("Error en la acci�n " 
        		+ EstablecerHitoHistoricoAction.class.getName() + ":\n" 
        		+ hitoInfo.toString(), e);
    }

    /**
     * Establece el hito hist�rico en Consulta Telem�tica
     * @param hito Datos del hito.
     * @throws Exception si ocurre alg�n error.
     */
    private void establecerHitoHistorico(HitoVO hito) throws Exception {

    	HitoExpediente cthito = new HitoExpediente();

    	// Informaci�n del hito
		cthito.setNumeroExpediente(hito.getCnumexp());
		cthito.setCodigo(StringUtils.nullToEmpty(hito.getCcod()));
		cthito.setGuid(new Guid().toString());
		cthito.setFecha(TypeConverter.toString(hito.getCfecha(), ConstantesServicios.DATE_PATTERN));
		cthito.setDescripcion(hito.getCdescr());
		cthito.setInformacionAuxiliar(
				StringUtils.nullToEmpty(hito.getCinfoaux()));

		// Llamada al API de Consulta Telem�tica
		ServicioConsultaExpedientes consulta = 
			LocalizadorServicios.getServicioConsultaExpedientes();
		consulta.nuevoHitoHistorico(cthito, getEntidad());
    }

}