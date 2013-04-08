package ieci.tdw.ispac.ispaccatalog.action.subprocedure;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IProcedureAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaccatalog.managers.NewProcedureMgr;
import ieci.tdw.ispac.ispaclib.bean.ItemBean;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispacweb.wizard.ItemSelectionHelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Acci�n para crear un subproceso.
 *
 */
public class CreateSubProcedureAction extends BaseAction {

	/**
	 * Ejecuta la l�gica de la acci�n.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws Exception {
		
 		// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, session.getClientContext(), new int[] {
				ISecurityAPI.FUNC_INV_SUBPROCESS_EDIT });

		NewProcedureMgr pcdmgr = new NewProcedureMgr(
				session.getClientContext(), request.getSession());
		pcdmgr.getContext();
		
		int newpcdId = 0;
		
		try {
			
			// API de procedimientos
			IProcedureAPI pcdAPI = session.getAPI().getProcedureAPI();

			// Obtener los nombres de las actividades
			List activities = getActivityNames(request);

			// Crear el subproceso
			if (pcdmgr.checkType(NewProcedureMgr.MODE_DRAFT)) {
				newpcdId = pcdAPI.createSubProcedureDraft(pcdmgr.getIntPcdId(), 
						pcdmgr.getName(), activities);
			} else if (pcdmgr.checkType(NewProcedureMgr.MODE_CLONE)) {
				newpcdId = pcdAPI.cloneSubProcedure(pcdmgr.getIntPcdId(), 
						pcdmgr.getName(), activities, pcdmgr.getIntParent());
			} else if (pcdmgr.checkType(NewProcedureMgr.MODE_MODIFY)) {
				newpcdId = pcdAPI.modifySubProcedure(pcdmgr.getIntPcdId(), 
						pcdmgr.getName(), activities);
			} else if (pcdmgr.checkType(NewProcedureMgr.MODE_NEW)) {
				newpcdId = pcdAPI.createSubProcedure(pcdmgr.getName(), 
						activities);
			}
			
			request.setAttribute("Message", "subprocedure.wizard.create");

		} catch (ISPACException e) {
			request.setAttribute("Message", "subprocedure.wizard.create.error");
			request.setAttribute("ErrorMessage", e.getMessage());
		} finally {
			pcdmgr.clearContext();
		}

		ActionForward fwd = mapping.findForward("shownewsubpcd");
		String path = new StringBuffer(fwd.getPath()).append(
				fwd.getPath().indexOf("?") > 0 ? "&" : "?").append("entityId=")
				.append(ICatalogAPI.ENTITY_P_SUBPROCEDURE).append("&regId=")
				.append(newpcdId).toString();
		request.setAttribute("NewSubPcdURL", path);

		return mapping.findForward("success");
	}
	
	private List getActivityNames(HttpServletRequest request) 
			throws ISPACException {
		
		List names = new ArrayList();

		ItemSelectionHelper itemSelHelper = new ItemSelectionHelper(
				request.getSession());
		List activities = itemSelHelper.getItemBeanList(
				ICatalogAPI.ENTITY_P_ACTIVITIES);
		for (int i = 0; i < activities.size(); i++) {
			ItemBean activity = (ItemBean) activities.get(i);
			String activityName = activity.getString("NOMBRE");
			if (StringUtils.isNotBlank(activityName)) {
				names.add(activityName);
			}
		}

		return names;
	}
}