package ieci.tdw.ispac.ispaccatalog.action;

import ieci.tdw.ispac.api.IRespManagerAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.api.item.IResponsible;
import ieci.tdw.ispac.ispaccatalog.action.form.SelectObjForm;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.bean.ItemBean;
import ieci.tdw.ispac.ispaclib.resp.Responsible;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SelectOrgUnitAction extends BaseDispatchAction {

	/** Logger de la clase. */
	protected static final Logger logger = 
		Logger.getLogger(SelectOrgUnitAction.class);

	
	/**
	 * Muestra la lista de �rganos.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws ISPACException {
		
		SelectObjForm substform = (SelectObjForm) form;

		// T�tulo de la pantalla
		String caption = substform.getCaption();
		if (StringUtils.isBlank(caption)) {
			caption = "catalog.selectobj.caption.default";
		}
		request.setAttribute("CaptionKey", caption);

		// API de responsables
        IRespManagerAPI respAPI = session.getAPI().getRespManagerAPI();

        // Obtener el �rgano actual
        IResponsible responsible = getResponsible(respAPI, 
        		request.getParameter("selectcode"));

		// Obtener los antecesores del �rgano actual
		request.setAttribute("ancestors", 
				getAncestors(respAPI, responsible.getUID()));

		// Obtener los hijos del �rgano actual
		request.setAttribute("responsibles", getResponsibles(responsible));

		return mapping.findForward("show");
	}

	/**
	 * Selecciona el �rgano marcado.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward set(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws ISPACException {
		
        //SelectObjForm substform = (SelectObjForm)form;

//        /*
//         * Nombre de la variable de sesi�n que mantiene los par�metros
//         * del tag de b�squeda.
//         */
//        String parameters=substform.getParameters();
//
//        // Obtiene los par�metros del tag de b�squeda y los salva en el request
//		String sParameters = session.getClientContext().getSsVariable( parameters);
//		if (sParameters != null) {
//			request.setAttribute(parameters, ActionFrameTag.toMap( sParameters));
//		}

		// C�digo del sustituto
		String selectcode = request.getParameter("selectcode");
		if (StringUtils.isNotBlank(selectcode)) {
			request.setAttribute("Substitute", new ItemBean(getResponsible(
					session.getAPI().getRespManagerAPI(), selectcode)));
		}

		return mapping.findForward("set");
	}

	private IResponsible getResponsible(IRespManagerAPI respAPI, String uid)
			throws ISPACException {
		IResponsible responsible = null;
		if (uid == null) {
			responsible = respAPI.getRootResp();
		} else {
			responsible = respAPI.getResp(uid);
		}
		return responsible;
	}

	private List getAncestors(IRespManagerAPI respAPI, String uid) 
			throws ISPACException {
		IItemCollection ancestors = respAPI.getAncestors(uid);
		return CollectionBean.getBeanList(ancestors);
	}
	
	private List getResponsibles(IResponsible responsible) 
			throws ISPACException {
		IItemCollection units = responsible.getRespOrgUnits();
		List unitList = CollectionBean.getBeanList(units);
		Collections.sort(unitList, Responsible.getRespComparator());
		return unitList;
	}
	
}