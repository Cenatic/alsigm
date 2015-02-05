package ieci.tdw.ispac.ispaccatalog.action.procedure;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.IProcedureAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaccatalog.managers.NewProcedureMgr;
import ieci.tdw.ispac.ispaclib.bean.ItemBean;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispacweb.wizard.ItemSelectionHelper;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action para mostrar un resumen de las fases y tr�mites seleccionados.
 *
 */
public class OverviewCreateProcedureAction extends BaseAction {
	
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
				ISecurityAPI.FUNC_INV_PROCEDURES_EDIT });

		String forward = request.getParameter("forward");

		NewProcedureMgr pcdmgr = new NewProcedureMgr(
				session.getClientContext(), request.getSession());
		pcdmgr.getContext();

		
		// Al crear un nuevo procedimiento o clonar uno ya existente
		// comprobar nombre de procedimiento no repetido
		if ((pcdmgr.checkType(NewProcedureMgr.MODE_NEW)) ||
			(pcdmgr.checkType(NewProcedureMgr.MODE_CLONE))) {
			
			IInvesflowAPI invesFlowAPI = session.getAPI();
			IProcedureAPI pcdAPI= invesFlowAPI.getProcedureAPI();
			ICatalogAPI catalog = invesFlowAPI.getCatalogAPI();
			
			// Bloquear los procedimientos
			catalog.setCTEntitiesForUpdate(ICatalogAPI.ENTITY_CT_PROCEDURE, "");
			
			IItemCollection collection = pcdAPI.getProcedureByName(pcdmgr.getName());
			if (collection.next()) {	
				
				ActionForward action = mapping.findForward("duplicateProced");
				String path = action.getPath();
		   		path = path + "&" + "proced=duplicated";	   		
				return new ActionForward(action.getName(), path, false);	
			}
		}
		
		if ("prev".equals(forward)) {

			if (pcdmgr.isBlank()) {
				forward = "begin";
			}

		} else {

			ItemSelectionHelper helper = new ItemSelectionHelper(
					request.getSession());
			
			// Listado de fases seleccionadas
			List stagelist = helper.getItemBeanList(ICatalogAPI.ENTITY_CT_STAGE);

			Iterator it = stagelist.iterator();
			while (it.hasNext()) {
				ItemBean stage = (ItemBean) it.next();
				List cttasklist = helper.getItemBeanList(
						ICatalogAPI.ENTITY_CT_TASK, 
						stage.getString("AUX_ID"));
				
				// Se a�ade a cada fase la lista de sus tr�mites seleccionados.
				stage.setProperty("TRAMITES_LIST", cttasklist);
			}

			// Establecer la lista de fases seleccionadas 
			request.setAttribute("StageList", stagelist);

			// Establecer el formateador para las fases
			setFormatter(request, "StageListFormatter", 
					"/formatters/procedure/overviewstageformatter.xml");

			// Establecer el formateador para los tr�mites
			setFormatter(request, "TaskListFormatter", 
					"/formatters/procedure/overviewstagetaskformatter.xml");

			// Indicar si se va a crear un procedimiento en blanco 
			request.setAttribute("BlankPcd", new Boolean(pcdmgr.isBlank()));
			if (StringUtils.isBlank(forward)) {
				forward = "success";
			}
		}

		return mapping.findForward(forward);
	}
}