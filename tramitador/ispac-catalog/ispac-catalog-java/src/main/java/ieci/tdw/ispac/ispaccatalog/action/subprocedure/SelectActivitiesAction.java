package ieci.tdw.ispac.ispaccatalog.action.subprocedure;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.action.form.BatchForm;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.utils.ArrayUtils;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.utils.TypeConverter;
import ieci.tdw.ispac.ispacweb.wizard.ItemSelectionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * Acci�n para seleccionar las actividades de un subproceso.
 *
 */
public class SelectActivitiesAction extends BaseAction {
	
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

		BatchForm batchForm = (BatchForm) form;
		
		String forward = request.getParameter("forward");

		ItemSelectionHelper itemSelHelper = new ItemSelectionHelper(
				request.getSession());

		String pAdd = request.getParameter("add");
		String pDel = request.getParameter("del");
		String pModOrder = request.getParameter("modOrder");
		
		if (StringUtils.isNotBlank(pAdd)) {

			String activityName = request.getParameter("activityName");
			if (StringUtils.isNotBlank(activityName)) {
				itemSelHelper.addItemBean(ICatalogAPI.ENTITY_P_ACTIVITIES, null, 
						activityName);
			} else {
				ActionMessages msgs = new ActionMessages();
				msgs.add("", new ActionMessage(
						"subprocedure.wizard.create.activityName.required"));
				forward = "success";
				saveErrors(request, msgs);
			}
			
			batchForm.setMultibox(null);
		}
		else if (StringUtils.isNotBlank(pDel)) {

			String[] selIds = batchForm.getMultibox();
			if (!ArrayUtils.isEmpty(selIds)) {
				for (int i = 0; i < selIds.length; i++) {
					itemSelHelper.removeItemBean(
							ICatalogAPI.ENTITY_P_ACTIVITIES,
							TypeConverter.parseInt(selIds[i], -1));
				}
			}
		
			batchForm.setMultibox(null);
		}
		else if (StringUtils.isNotBlank(pModOrder)) {

			String[] selIds = batchForm.getMultibox();
			if (!ArrayUtils.isEmpty(selIds)) {
				if ("INC".equalsIgnoreCase(pModOrder)) {
					int prevItemId = 0;
					for (int i = 0; i < selIds.length; i++) {
						int itemId = TypeConverter.parseInt(selIds[i], -1);
						itemSelHelper.moveItemBean(
								ICatalogAPI.ENTITY_P_ACTIVITIES,
								itemId,
								prevItemId,
								pModOrder);
						
						prevItemId = itemId;
					}
				} else if ("DEC".equalsIgnoreCase(pModOrder)) {
					int prevItemId = 0;
					for (int i = selIds.length-1; i >= 0; i--) {
						int itemId = TypeConverter.parseInt(selIds[i], -1);
						itemSelHelper.moveItemBean(
								ICatalogAPI.ENTITY_P_ACTIVITIES,
								itemId,
								prevItemId,
								pModOrder);
						
						prevItemId = itemId;
					}
				}
			}
		}
		
		// Establecer la lista de actividades seleccionadas
		request.setAttribute("ActivitiesList", 
				itemSelHelper.getItemBeanList(ICatalogAPI.ENTITY_P_ACTIVITIES));

 		// Establecer el formateador de las actividades seleccionadas
		setFormatter(request, "ActivitiesListFormatter", 
				"/formatters/subprocedure/selactivitiesformatter.xml");

		return mapping.findForward(StringUtils.defaultIfEmpty(
				forward, "success"));
	}
}