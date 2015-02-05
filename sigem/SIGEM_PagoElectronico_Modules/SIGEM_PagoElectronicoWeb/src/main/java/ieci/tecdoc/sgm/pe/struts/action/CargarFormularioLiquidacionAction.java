package ieci.tecdoc.sgm.pe.struts.action;
/*
 *  $Id: CargarFormularioLiquidacionAction.java,v 1.2.2.1 2008/02/05 13:33:23 jconca Exp $
 */
import ieci.tecdoc.sgm.core.services.pago.Liquidacion;
import ieci.tecdoc.sgm.pe.ConfiguracionComun;
import ieci.tecdoc.sgm.pe.struts.Constantes;
import ieci.tecdoc.sgm.pe.struts.FormCreator;
import ieci.tecdoc.sgm.pe.struts.PagoElectronicoManagerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Acci�n encargada de cargar un formulario de liquidaci�n. 
 */
public class CargarFormularioLiquidacionAction extends PagoElectronicoWebAction {

	private static final Logger logger = Logger.getLogger(CargarFormularioLiquidacionAction.class);
	
	private static final String REFERENCIA_KEY = "referencia";
	private static final String FORMULARIO_KEY = "formulario";
	private static final String ERROR_KEY 	=  "mensajeError";
	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String cNumeroReferencia = (String)request.getParameter(REFERENCIA_KEY);
		if(cNumeroReferencia == null){
			return mapping.findForward(Constantes.ERROR_FORWARD);
		}
		
		String cFormulario = null;
		Liquidacion oLiquidacion = null;
		try {
			oLiquidacion = PagoElectronicoManagerHelper.obtenerDatosLiquidacion(request, cNumeroReferencia);
			String cXMLDatos = PagoElectronicoManagerHelper.obtenerDocumentoPago(request, cNumeroReferencia);
			cFormulario = FormCreator.crearFormularioLiquidacion(oLiquidacion.getTasa(), cXMLDatos, request);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			request.setAttribute(ERROR_KEY, e.getMessage());			
			return mapping.findForward(Constantes.ERROR_FORWARD);		
		}
		request.setAttribute(FORMULARIO_KEY, cFormulario);
		
		if(ConfiguracionComun.usarPasarelaPagoExternaConRedireccion()){
			return mapping.findForward(Constantes.PASARELA_FORWARD);
		}
		return mapping.findForward(Constantes.SUCCESS_FORWARD);
	}
}