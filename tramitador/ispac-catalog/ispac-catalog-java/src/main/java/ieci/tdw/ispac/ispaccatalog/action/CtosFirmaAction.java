package ieci.tdw.ispac.ispaccatalog.action;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CtosFirmaAction extends BaseDispatchAction {

	/**
	 * A�ade el circuito de firma al procedimiento.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws ISPACException {

		ClientContext cct = session.getClientContext();
		
 		// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, cct, new int[] {
				ISecurityAPI.FUNC_INV_PROCEDURES_EDIT });

        IInvesflowAPI invesFlowAPI = cct.getAPI();
		ICatalogAPI catalogAPI= invesFlowAPI.getCatalogAPI();
		
		String sPcdId = request.getParameter("pcdId");
		String ctofirmasId = request.getParameter("ctofirmasId");
		
		if (StringUtils.isNotBlank(sPcdId)) {
			
			int pcdId = Integer.parseInt(sPcdId);

			request.setAttribute("Refresh","true");
	
			catalogAPI.addCtoFirmas(pcdId, Integer.parseInt(ctofirmasId));
		}

		return mapping.findForward("closeIFrame");
	}
	
	/**
	 * Elimina el circuito de firmas seleccionado del procedimiento.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws ISPACException {

        ClientContext cct = session.getClientContext();

 		// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, cct, new int[] {
				ISecurityAPI.FUNC_INV_PROCEDURES_EDIT });

        IInvesflowAPI invesFlowAPI = cct.getAPI();
		ICatalogAPI catalogAPI= invesFlowAPI.getCatalogAPI();

		int pcdId = Integer.parseInt(request.getParameter("regId"));
		String delId = request.getParameter("delId");
		
		if (delId != null) 
			catalogAPI.dropCtoFirmas(pcdId, Integer.parseInt(delId));
		    		
		return new ActionForward(new StringBuffer()
   	 			.append("/showProcedureEntity.do?method=ctosfirma&entityId=")
   	 			.append(request.getParameter("entityId"))
   	 			.append("&regId=")
   	 			.append(request.getParameter("regId"))
   	 			.toString(), true);
    }
}
