package ieci.tdw.ispac.ispacmgr.action;

import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.IWorklistAPI;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.api.item.util.ListCollection;
import ieci.tdw.ispac.ispaclib.bean.BeanFormatter;
import ieci.tdw.ispac.ispaclib.bean.CacheFormatterFactory;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.dao.wl.WLTaskDAO;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.utils.TypeConverter;
import ieci.tdw.ispac.ispacmgr.menus.MenuFactory;
import ieci.tdw.ispac.ispacmgr.mgr.SchemeMgr;
import ieci.tdw.ispac.ispacweb.api.IManagerAPI;
import ieci.tdw.ispac.ispacweb.api.IState;
import ieci.tdw.ispac.ispacweb.api.ManagerAPIFactory;
import ieci.tdw.ispac.ispacweb.api.ManagerState;
import ieci.tdw.ispac.ispacweb.manager.TaskListFormatFactory;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowTasksListAction extends BaseAction {
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws Exception {

		ClientContext cct = session.getClientContext();
		
		IInvesflowAPI invesFlowAPI = session.getAPI();
		DbCnt cnt = null;
		BeanFormatter formatter = null;
		
		try {
			IWorklistAPI workListAPI = invesFlowAPI.getWorkListAPI();
			IManagerAPI managerAPI=ManagerAPIFactory.getInstance().getManagerAPI(cct);
	
			//Se establece el estado
			Map params = request.getParameterMap();
			IState newState = managerAPI.enterState(getStateticket(request),ManagerState.TASKSLIST,params);
			storeStateticket(newState,response);
	
			//Identificador del tramite en el catalogo
			int taskCtlId = newState.getTaskCtlId();
			//Identificador del tramite para el procedimiento
			int taksPcdId = newState.getTaskPcdId();
	
	        // Cargar el contexto de la cabecera (miga de pan)
	        SchemeMgr.loadContextHeader(newState, request, getResources(request), session);
	        
	        // Men�s
		    request.setAttribute("menus", MenuFactory.getTasksListMenu(cct, 
		    		newState, getResources(request)));
	
		    
			// obtenemos la lista de los datos de tr�mites
			IItemCollection itcTask = null;
	
			//Se obtiene la lista de tramites en funcion del estado y parametros.
			
			//Si se han recibido una lista de identificadores de tramites...
			if (request.getParameter("taskIds")!=null){
				
			    //...se muestran unicamente estos tramites
			    cnt = cct.getConnection();
			    itcTask = new ListCollection(WLTaskDAO.getTasks(cnt, 
			    		request.getParameterValues("taskIds")).toList());
			
			} else if (taskCtlId != 0) { //Si existe el identificador del tr�mite en el cat�logo...
			    
				//...se obtienen todos los tramites abiertos de cualquier tipo 
				//de procedimiento segun este identificador 
				
				// Obtener el formateador a partir del c�digo del tr�mite
				IItem ctTask = invesFlowAPI.getCatalogAPI().getCTTask(taskCtlId);
				String taskCode = ctTask.getString("COD_TRAM");
				
				TaskListFormatFactory tasklistfactory = new TaskListFormatFactory(getISPACPath());
				formatter = tasklistfactory.getBeanFormatter(taskCode);
				
				// Identificador del procedimiento
				String pcdId = request.getParameter("pcdId");
				if (StringUtils.isNotBlank(pcdId)) {
					itcTask = workListAPI.getTasksCTL(taskCtlId, TypeConverter.parseInt(pcdId, -1));
				} else {				
					itcTask = workListAPI.getTasksCTL(taskCtlId);
				}
				
			} else if (taksPcdId != 0) { //Si existe el identificador del tr�mite para el procedimiento...
			    
				//...se obtienen todos los tramites abiertos para un tipo de 
				//procedimiento que segun este identificador
			    itcTask = workListAPI.getTasksPCD(newState.getTaskPcdId());
			}
			
			//Introducimos la lista de tramites en la peticion
			List expTaskList = CollectionBean.getBeanList(itcTask);
			request.setAttribute("ExpTaskList",expTaskList);
	
			if (formatter == null) {
				CacheFormatterFactory factory = CacheFormatterFactory.getInstance();
				formatter = factory.getFormatter(getISPACPath("/digester/taskprocessformatter.xml"));
			}
			
			request.setAttribute("Formatter", formatter);
	
			return mapping.findForward("success");
			
		} finally{
		    cct.releaseConnection(cnt);
		}
	}
}
