package ieci.tdw.ispac.ispacmgr.action;

import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispacmgr.common.constants.ActionsConstants;
import ieci.tdw.ispac.ispacmgr.menus.MenuFactory;
import ieci.tdw.ispac.ispacmgr.mgr.SchemeMgr;
import ieci.tdw.ispac.ispacweb.api.IManagerAPI;
import ieci.tdw.ispac.ispacweb.api.IState;
import ieci.tdw.ispac.ispacweb.api.IWorklist;
import ieci.tdw.ispac.ispacweb.api.ManagerAPIFactory;
import ieci.tdw.ispac.ispacweb.api.ManagerState;
import ieci.tdw.ispac.ispacweb.manager.SubProcessListFormatFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowSubProcessListAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws Exception {

	 	ClientContext cct = session.getClientContext();

		///////////////////////////////////////////////
		// Cambio del estado de tramitaci�n
		IManagerAPI managerAPI=ManagerAPIFactory.getInstance().getManagerAPI(cct);
		Map params = request.getParameterMap();
		IState state = managerAPI.enterState(getStateticket(request),ManagerState.SUBPROCESSESLIST,params);
		storeStateticket(state,response);

       /////////////////////////////////////////////////
		// Lista de subprocesos
		// Obtenci�n del formato de la lista de subprocesos
		// Como los subprocesos y las actividades no tienen c�digo asignado
		// la localizaci�n del formateador se hace en funci�n de sus identificadores
		SubProcessListFormatFactory proclistfactory=new SubProcessListFormatFactory(getISPACPath());
		InputStream istream=proclistfactory.getProcessListFormat(state.getSubPcdId(),state.getActivityPcdId());

		IWorklist managerwl=managerAPI.getWorklistAPI();
		IItemCollection itc = managerwl.getSubProcesses(state,istream);

		// Lista de subprocesos en la peticion
	    List subProcessActivityList = CollectionBean.getBeanList(itc);
	    request.setAttribute(ActionsConstants.SUBPROCESS_ACTIVITY_LIST, subProcessActivityList);

	    // Cargar el contexto de la cabecera (miga de pan)
	    SchemeMgr.loadContextHeader(state, request, getResources(request), session);

	    // Establecer el menu
		request.setAttribute("menus", MenuFactory.getWorkListMenu(cct, state, getResources(request)));

	    ///////////////////////////////////////////////
	    // Formateador
		istream.reset();
		// Propiedades del formateador para la vista
		request.setAttribute("Formatter", proclistfactory.getBeanFormatter(istream));

		return mapping.findForward("success");
	}

}
