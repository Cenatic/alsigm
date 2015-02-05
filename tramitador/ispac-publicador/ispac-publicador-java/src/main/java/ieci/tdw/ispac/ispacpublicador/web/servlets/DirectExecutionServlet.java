package ieci.tdw.ispac.ispacpublicador.web.servlets;

import ieci.tdw.ispac.ispacpublicador.business.engine.PublisherEngine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet para la ejecuci�n puntual del agente de publicaci�n.
 *
 */
public class DirectExecutionServlet extends HttpServlet {

	/**
	 * Gestiona las peticiones GET.
	 * @param req Objeto que contiene la petici�n del cliente.
	 * @param resp Objeto que contiene la respuesta al cliente.
	 * @throws ServletException si la petici�n GET no se puede tratar.
	 * @throws IOException si ocurre alg�n error de E/S.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	doLogic(req, resp);
	}

	/**
	 * Gestiona las peticiones POST.
	 * @param req Objeto que contiene la petici�n del cliente.
	 * @param resp Objeto que contiene la respuesta al cliente.
	 * @throws ServletException si la petici�n POST no se puede tratar.
	 * @throws IOException si ocurre alg�n error de E/S.
	 */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doLogic(req, resp);
	}

    /**
     * Realiza la l�gica del servlet.
	 * @param req Objeto que contiene la petici�n del cliente.
	 * @param resp Objeto que contiene la respuesta al cliente.
	 * @throws ServletException si la petici�n POST no se puede tratar.
	 * @throws IOException si ocurre alg�n error de E/S.
     */
    private void doLogic(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	// Ejecutar el motor de publicaci�n
    	PublisherEngine.execute();
    	
    	// Redirigir a la p�gina de inicio
    	resp.sendRedirect(req.getContextPath() + "/ispac/index.jsp");
    }
}
