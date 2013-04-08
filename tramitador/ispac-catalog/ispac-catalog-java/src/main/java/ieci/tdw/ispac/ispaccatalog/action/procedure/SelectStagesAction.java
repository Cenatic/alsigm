package ieci.tdw.ispac.ispaccatalog.action.procedure;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.action.form.BatchForm;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.bean.ItemBean;
import ieci.tdw.ispac.ispaclib.utils.ArrayUtils;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.utils.TypeConverter;
import ieci.tdw.ispac.ispacweb.wizard.ItemSelectionHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Acci�n para seleccionar las fases del procedimiento.
 * 
 */
public class SelectStagesAction extends BaseAction {
	
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

		BatchForm batchForm = (BatchForm) form;
		String[] selStagesIds = batchForm.getMultibox();

		ItemSelectionHelper itemSelHelper = new ItemSelectionHelper(
				request.getSession());

		// Establecer el retorno
		String forward = request.getParameter("forward");
		
		// Obtener las fases del cat�logo
		List ctStages = getCTStages(session);
		
		request.setAttribute("ItemsList", ctStages);

		String pAdd = request.getParameter("add");
		String pDel = request.getParameter("del");
		String pModOrder = request.getParameter("modOrder");
		
		if (StringUtils.isNotBlank(pAdd)) {

			if (!ArrayUtils.isEmpty(selStagesIds)) {
				for (int i = 0; i < selStagesIds.length; i++) {
					String ctStageId = selStagesIds[i].split("-")[1];
					itemSelHelper.addItemBean(ICatalogAPI.ENTITY_CT_STAGE,
							null, getCTStageName(ctStages, ctStageId), 
							ctStageId);
				}
			}
			
			batchForm.setMultibox(null);
		}
		else if (StringUtils.isNotBlank(pDel)) {

			if (!ArrayUtils.isEmpty(selStagesIds)) {
				for (int i = 0; i < selStagesIds.length; i++) {
					String [] ids = selStagesIds[i].split("-");
					if (StringUtils.isNumeric(ids[0])){
						itemSelHelper.removeItemBean(
								ICatalogAPI.ENTITY_CT_STAGE,
								TypeConverter.parseInt(ids[0], 0));
					}
				}
			}
			
			batchForm.setMultibox(null);
		}
		else if (StringUtils.isNotBlank(pModOrder)) {
			
			if (!ArrayUtils.isEmpty(selStagesIds)) {
				if ("INC".equalsIgnoreCase(pModOrder)) {
					int prevItemId = 0;
					for (int i = 0; i < selStagesIds.length; i++) {
						String [] ids = selStagesIds[i].split("-");
						if (StringUtils.isNumeric(ids[0])){
							int itemId = TypeConverter.parseInt(ids[0], 0);
							itemSelHelper.moveItemBean(
									ICatalogAPI.ENTITY_CT_STAGE,
									itemId,
									prevItemId,
									pModOrder);
							
							prevItemId = itemId;
						}
					}
				} else if ("DEC".equalsIgnoreCase(pModOrder)) {
					int prevItemId = 0;
					for (int i = selStagesIds.length-1; i >= 0; i--) {
						String [] ids = selStagesIds[i].split("-");
						if (StringUtils.isNumeric(ids[0])){
							int itemId = TypeConverter.parseInt(ids[0], 0);
							itemSelHelper.moveItemBean(
									ICatalogAPI.ENTITY_CT_STAGE,
									itemId,
									prevItemId,
									pModOrder);
							
							prevItemId = itemId;
						}
					}
				}
			}
		}

		// Establecer la lista de fases seleccionadas
		List selectedStages = itemSelHelper.getItemBeanList(
				ICatalogAPI.ENTITY_CT_STAGE); 
		request.setAttribute("SelItemsList", selectedStages);

		// Establecer el formateador para la lista de fases seleccionadas
		setFormatter(request, "SelItemsListFormatter", 
				"/formatters/procedure/selstagesformatter.xml");
		
		//batchForm.setMultibox(new String[ctStages.size()]);
		removeSelected(ctStages, selectedStages, itemSelHelper);

		// Establecer el formateador de la lista de fases del cat�logo
		setFormatter(request, "ItemsListFormatter", 
				"/formatters/procedure/stagesformatter.xml");

		return mapping.findForward(StringUtils.defaultIfEmpty(
				forward, "success"));
	}
	
	/**
	 * Se encarga de borrar de la lista de fases aquellas que ya han sido seleccionadas.
	 * @param ctStages
	 * @param selectedStages
	 * @param itemSelHelper
	 * @throws ISPACException
	 */
	private void removeSelected(List ctStages, List selectedStages, ItemSelectionHelper itemSelHelper) throws ISPACException {
		List aux=new ArrayList();		
		for(Iterator i=ctStages.iterator(); i.hasNext();){
			ItemBean item = (ItemBean)i.next();
			if(itemSelHelper.containsItemBean(selectedStages, item.getString("NOMBRE")))
				aux.add(item);			
		}
		ctStages.removeAll(aux);
	}
	

	/**
	 * Obtiene la lista de fases del cat�logo.
	 * @param session Informaci�n de la sesi�n del usuario.
	 * @return Lista de fases del cat�logo.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	protected List getCTStages(SessionAPI session) throws ISPACException {

		ICatalogAPI catalogAPI = session.getAPI().getCatalogAPI();
		IItemCollection itemcol = catalogAPI.getCTStages();
		
		List stages = CollectionBean.getBeanList(itemcol);
        for (Iterator iter = stages.iterator(); iter.hasNext();) {
			ItemBean element = (ItemBean) iter.next();
			//element.setProperty("ADD_ID", "add-" + element.getProperty("ID"));
			element.setProperty("ADD_ID", element.getProperty("ID") + "-" + element.getProperty("ID"));
        }
        
        return stages;
	}
	
	/**
	 * Obtiene el nombre de la fase en el cat�logo.
	 * @param ctStages Lista de fases en el cat�logo.
	 * @param ctStageId Identificador de la fase en el cat�logo.
	 * @return Nombre de la fase.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	protected String getCTStageName(List ctStages, String ctStageId) 
			throws ISPACException {
		if ((ctStages != null) && StringUtils.isNotBlank(ctStageId)) {
			for (int i = 0; i < ctStages.size(); i++) {
				ItemBean stage = (ItemBean) ctStages.get(i);
				if (ctStageId.equals(stage.getString("ID"))) {
					return stage.getString("NOMBRE");
				}
			}
		}
		
		return "";
	}
}