package ieci.tdw.ispac.ispacmgr.action;

import ieci.tdw.ispac.api.IEntitiesAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.entities.SpacEntities;
import ieci.tdw.ispac.api.errors.ISPACInfo;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaclib.app.EntityApp;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispacmgr.mgr.SchemeMgr;
import ieci.tdw.ispac.ispacweb.api.IManagerAPI;
import ieci.tdw.ispac.ispacweb.api.IScheme;
import ieci.tdw.ispac.ispacweb.api.IState;
import ieci.tdw.ispac.ispacweb.api.ManagerAPIFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DeleteTaskAction extends BaseAction {

    public ActionForward executeAction(ActionMapping mapping, 
    								   ActionForm form, 
    								   HttpServletRequest request, 
    								   HttpServletResponse response, 
    								   SessionAPI session) throws Exception {
    	
    	ClientContext cct = session.getClientContext();
    	
		IInvesflowAPI invesflowAPI = session.getAPI();
    	IEntitiesAPI entitiesAPI = invesflowAPI.getEntitiesAPI();
    	
    	// Estado del contexto de tramitaci�n
    	IManagerAPI managerAPI = ManagerAPIFactory.getInstance().getManagerAPI(cct);
    	IState currentState = managerAPI.currentState(getStateticket(request));
    	
    	// Identificador del tr�mite a eliminar
    	String taskid = request.getParameter("idsTask");
    	int ntaskid = Integer.parseInt(taskid);
    	    	
    	// No se puede eliminar un tr�mite cuando
    	// tenga documentos que han generado registro de salida o que han iniciado notificaci�n telem�tica (documento con bloqueo total)
    	if (entitiesAPI.undeleteTask(ntaskid)) {

    		//throw new ISPACInfo(getResources(request).getMessage("exception.exception.deletetask"));    		
    		ISPACInfo info=null;
    		info=new ISPACInfo(getResources(request).getMessage("exception.exception.deletetask"));
    		request.getSession().setAttribute("infoAlert", info);
    		
    	} else {
    		
//    		// Eliminar el tr�mite
//    		entitiesAPI.deleteTask(ntaskid);
    		
    		// Establecer el tr�mite como entidad principal en el contexto
    		currentState.setEntityId(SpacEntities.SPAC_DT_TRAMITES);
    		currentState.setEntityRegId(entitiesAPI.getTask(ntaskid).getKeyInt());
    		
            // Cargamos los datos del esquema
    		IScheme scheme = SchemeMgr.loadScheme(mapping, request, session, currentState);
    		
    		// Obtener la aplicaci�n que gestiona el formulario del tr�mite
			EntityApp entityapp = scheme.getDefaultEntityApp(currentState, null, false);
			
			// Ejecuci�n en un contexto transaccional
			boolean bCommit = false;
			
			try {
				// Iniciar transacci�n
				cct.beginTX();	
			
	    		// Eliminar el tr�mite
	    		entitiesAPI.deleteTask(ntaskid);
	    		
	    		// Eliminar las posibles entidades agregadas al tr�mite
	    		entityapp.delete(cct);
    		
				// Si todo ha sido correcto se hace commit de la transacci�n
				bCommit = true;
				
			} finally {
				cct.endTX(bCommit);
			}
    		
    	}

    	// Ir al expediente en la fase
    	ActionForward showexp =mapping.findForward("showexp");		
		return new ActionForward(showexp.getName(), showexp.getPath() + "?stageId=" + currentState.getStageId(), true);    	
	}
    
}