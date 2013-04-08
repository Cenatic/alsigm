package ieci.tdw.ispac.ispaccatalog.action;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Acci�n para mostrar la lista de fases del cat�logo.
 *
 */
public class ShowCTStagesListAction extends BaseAction {

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
				ISecurityAPI.FUNC_INV_STAGES_READ,
				ISecurityAPI.FUNC_INV_STAGES_EDIT });

		IInvesflowAPI invesFlowAPI = session.getAPI();
		ICatalogAPI catalogAPI = invesFlowAPI.getCatalogAPI();

		// Obtiene el nombre de la fase
		String ctStageName = request.getParameter("property(criterio)");

		// Establece la lista de fases del cat�logo
		IItemCollection ctStages = catalogAPI.getCTStages(ctStageName);
		request.setAttribute("CTStagesList", 
				CollectionBean.getBeanList(ctStages));

		request.setAttribute("ctStageName",ctStageName);
		
		// Establece el formateador de las fases del cat�logo
		if (FunctionHelper.userHasFunction(request, session.getClientContext(), ISecurityAPI.FUNC_INV_STAGES_EDIT)) {
			setFormatter(request, "CTStagesListFormatter",
					"/formatters/ctstageslistformatter.xml");
		} else {
			setFormatter(request, "CTStagesListFormatter",
					"/formatters/ctstageslistreadonlyformatter.xml");
		}

		return mapping.findForward("success");
	}
}