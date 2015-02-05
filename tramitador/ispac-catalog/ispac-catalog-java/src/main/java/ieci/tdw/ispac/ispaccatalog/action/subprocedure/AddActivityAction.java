package ieci.tdw.ispac.ispaccatalog.action.subprocedure;

import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.IProcedureAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.action.procedure.ManageVistaCuadroProcedimientoAction;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.bean.TreeView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action para a�adir una actividad a un subproceso.
 *
 */
public class AddActivityAction extends BaseAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            SessionAPI session) throws Exception {

    	// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, session.getClientContext(), new int[] {
				ISecurityAPI.FUNC_INV_SUBPROCESS_EDIT });

		IInvesflowAPI invesFlowAPI = session.getAPI();
		IProcedureAPI procedureAPI= invesFlowAPI.getProcedureAPI();

		int pcdid = Integer.parseInt(request.getParameter("pcdId"));

		// Obtener el nombre de la actividad
		String ctstagename = request.getParameter("textvalue");
				
		// Asociar la actividad al subproceso
		procedureAPI.addStage(pcdid, -1, ctstagename);

		// Actualizar el �rbol del procedimiento
		TreeView tree = (TreeView)request.getSession().getAttribute(
				ManageVistaCuadroProcedimientoAction.CUADRO_PROCEDIMIENTO);
		if (tree!=null) {
			tree.getSelectedNode().refresh();
		}
		
		// Refrescar la pantalla principal
		request.setAttribute("Refresh", "true");
		
		return mapping.findForward("success");
    }
}
