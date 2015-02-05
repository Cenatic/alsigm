package ieci.tdw.ispac.ispacpublicador.business.action.mensajesCortos;
import ieci.tdw.ispac.api.impl.InvesflowAPI;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispacpublicador.business.action.mensajesCortos.vo.DestinatarioVO;
import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;
import ieci.tecdoc.sgm.core.exception.SigemException;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.mensajes_cortos.ServicioMensajesCortos;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * 
 * Clase que ejecuta la accion de enviar sms. La regla que tenga asociada esta acci�n en el campo xml de attributos deber� tener un xml
 * semejante al que se indica a continuaci�n
 * 
 * <?xml version='1.0' encoding='ISO-8859-1'?>
	<attributes>
		<attribute name='USUARIO'>ieci1@madrid</attribute>
		<attribute name='PWD'>ieci1</attribute>
		<attribute name='DESTINATARIOS'>
			<addressees>
				<addressee>+34600000000</addressee>
					<roles>	
						<!-- para indicar todos los roles <role>*</role>
						<role>INT</role>
						<role>LIC</role>
					</roles>
			</addressees>
		</attribute>
		<attribute name="MENSAJE">
			<labels default='es'>
				<label locale='es'>
				[ES]Estimado ${var:NOMBRE} Se ha comprobado la documentaci�n del procedimiento  ${var:NOMBRE_PROCEDIMIENTO} aportada en el expediente N� ${var: NUM_EXP} siendo la fecha de inicio de plazo: ${xpath:/EXPEDIENTE/SPAC_EXPEDIENTES/REGISTROS/FINICIOPLAZO } 
				</label>
				<label locale='eu'>
				[EU] Estimado ${var:NOMBRE} Se ha comprobado la documentaci�n del procedimiento  ${var:NOMBRE_PROCEDIMIENTO} aportada en el expediente N� ${var: NUM_EXP} siendo la fecha de inicio de plazo: ${xpath:/EXPEDIENTE/SPAC_EXPEDIENTES/REGISTROS/FINICIOPLAZO } 
				</label>
				
				<label locale='ca' Estimado ${var:NOMBRE} Se ha comprobado la documentaci�n del procedimiento  ${var:NOMBRE_PROCEDIMIENTO} aportada en el expediente N� ${var: NUM_EXP} siendo la fecha de inicio de plazo: ${xpath:/EXPEDIENTE/SPAC_EXPEDIENTES/REGISTROS/FINICIOPLAZO } 
				</label>
				<label locale='gl'>[GL] Estimado ${var:NOMBRE} Se ha comprobado la documentaci�n del procedimiento  ${var:NOMBRE_PROCEDIMIENTO} aportada en el expediente N� ${var: NUM_EXP} siendo la fecha de inicio de plazo: ${xpath:/EXPEDIENTE/SPAC_EXPEDIENTES/REGISTROS/FINICIOPLAZO } 
				</label>
			
			</labels>
		</attribute>
		<attribute name="EMISOR">+34600000000</attribute>
</attributes>

 *
 */
public class EnvioSmsAction  extends MensajesCortosAction{

	
	/** Logger de la clase. */
    private static final Logger logger = 
    	Logger.getLogger(EnvioSmsAction.class);
    
    private static final String ATR_USUARIO	="USUARIO";
    private static final String ATR_PWD		="PWD";
	 /**
     * 
     * Constructor.
     * 
     */
    public EnvioSmsAction() {
    	super();
    	clientContext = new ClientContext();
    	clientContext.setAPI(new InvesflowAPI(clientContext));
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
	public boolean execute(RuleContext rctx, AttributeContext actx)
			throws ActionException {
		
		
		  if (logger.isInfoEnabled()) {
	            logger.info("Acci�n [" + this.getClass().getName() + "] en ejecuci�n");
	        }
		  
		  
		try {
			String xmlExpediente=getXmlExpediente(rctx.getIdObjeto());
			componerEnviarSms(xmlExpediente, actx, ENVIO_SMS);
			
		 } catch (ActionException e) {
	        	setInfo("Error en el envio de sms sin certificado para el expediente "
	        			+ rctx.getIdObjeto() + ": " + e.toString());
	            throw e;
	        } catch (Throwable e) {
	        	setInfo("Error en el envio de sms sin certificado para el expediente "
	        			+ rctx.getIdObjeto() + ": " + e.toString());
	            throw new ActionException(e);
	        }
	        
	        
	        return true;
	}


    /**
     * Realiza el envio de los emails
     */
	public void realizarEnvio(AttributeContext actx, List destinatariosVo) throws SigemException {
		String texts[]= new String[destinatariosVo.size()];
		String phones[] = new String[destinatariosVo.size()];
		
		String emisor=actx.getAttribute(ATR_EMISOR);
		String user=actx.getAttribute(ATR_USUARIO);
		String pwd=actx.getAttribute(ATR_PWD);
		for(int i=0; i<destinatariosVo.size(); i++){
			DestinatarioVO dest= (DestinatarioVO) destinatariosVo.get(i);
			texts[i]=dest.getTexto();
			phones[i]=dest.getMovil();
			
		}
		
		ServicioMensajesCortos servicio = LocalizadorServicios.getServicioMensajesCortos();	
		for(int i=0; i<texts.length; i++){
			servicio.sendSMS(user, pwd, emisor, phones[i], texts[i]);
		}
		
		
		
	}
    
   
}
