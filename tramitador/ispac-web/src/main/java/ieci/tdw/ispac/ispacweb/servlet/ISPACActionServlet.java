package ieci.tdw.ispac.ispacweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;

public class ISPACActionServlet extends ActionServlet {
	
	/** UID de la versi�n. */
	private static final long serialVersionUID = 1L;
    
	
	/**
	 * Constructor.
	 *
	 */
    public ISPACActionServlet() {
    	super();
    }

    /**
     * Inicia el servlet.
     * @param config Configuraci�n del servlet.
     * @throws ServletException si ocurre alg�n error.
     */
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
    }
    
}
