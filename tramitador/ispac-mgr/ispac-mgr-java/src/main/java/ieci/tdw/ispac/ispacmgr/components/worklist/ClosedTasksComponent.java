package ieci.tdw.ispac.ispacmgr.components.worklist;

import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.ISessionAPI;
import ieci.tdw.ispac.api.IWorklistAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispacweb.components.DefaultWebComponent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Muestra la informaci�n de los tr�mites cerrados bajo la responsabilidad del usuario.
 *
 */
public class ClosedTasksComponent extends DefaultWebComponent { 

	/**
	 * Constructor.
	 */
	public ClosedTasksComponent() {
		super();
		setId("closedTasks");
	}

	/**
	 * Renderiza el componente.
	 * @param context Contexto de servlets.
	 * @param request Petici�n del cliente.
	 * @param sessionAPI API de sesi�n.
	 * @param params Par�metros de configuraci�n.
	 * @return C�digo HTML para mostrar en pantalla.
	 * @throws ISPACException si ocurre alg�n error.
	 */
    public void render(ServletContext context, HttpServletRequest request, ISessionAPI sessionAPI) 
    		throws ISPACException { 
		
    	String html = "";

    	// Contexto del cliente
    	ClientContext ctx = sessionAPI.getClientContext();

		// T�tulo
    	setTitle(getMessage(ctx.getLocale(), "closed.tasks.titulo"));

		// Responsabilidades del usuario conectado
		IInvesflowAPI invesflowAPI = ctx.getAPI();
		IWorklistAPI workListAPI = invesflowAPI.getWorkListAPI();
		String resp = workListAPI.getRespString();
		
		// Obtenemos el listado de los tr�mites
		IItemCollection itcTask = workListAPI.getProcedureClosedTasks(resp);
		if (itcTask.next()) {

			html += "<ul>";

			while (itcTask.next()) {
				
				IItem task = (IItem) itcTask.value();
				
					html += "<li style=\"list-style-image: url("
						+ rewriteHref(context, request, "img/tramiteestado3.gif")
						+ ");\">";

					html += "<a href=\"" + request.getContextPath() + "/showClosedTasksList.do?taskCtlId=" + task.getInt("ID_CTTASK") + "\" class=\"menu\">"
						+ task.getString("NAME") + "&nbsp;(" + task.getInt("COUNT") + ")"
						+ "</a>";
					
					html += "</li>";

			}
			
			html += "</ul>";
		}
    	
    	setContent(html);
    }
}
