package ieci.tdw.ispac.ispacweb.servlet;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.log.ISPACLogInitializer;
import ieci.tdw.ispac.ispaclib.util.ISPACConfiguration;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispacweb.util.PathUtils;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * Servlet para inicializar la aplicaci�n. Inicializa los siguientes 
 * componentes:
 * <ul>
 * 	<li>Configuraci�n</li>
 *  <li>Logs</li>
 * </ul>
 *
 */
public class ISPACStartupServlet extends HttpServlet {
	
	/** UID de la versi�n. */
	private static final long serialVersionUID = 1L;

    /** Logger de la clase. */
    private final static Logger logger = 
    	Logger.getLogger(ISPACStartupServlet.class);

	
	/**
	 * Constructor.
	 *
	 */
    public ISPACStartupServlet() {
    	super();
    }

    /**
     * Inicia el servlet.
     * @param config Configuraci�n del servlet.
     * @throws ServletException si ocurre alg�n error.
     */
    public void init(ServletConfig config) throws ServletException {
    	
		super.init(config);
		
		// Inicia las variables del sistema 
		initSystemVariables(config);

		// Inicia el m�dulo de logs
		initLoggingModule(config);

		// Inicia el m�dulo de configuraci�n
		initConfigurationModule(config);
		
		// Inicia el contexto
		initContext(config);
    }

    /**
     * Inicia las variables del sistema.
     * @param config Configuraci�n del servlet.
     */
    protected void initSystemVariables(ServletConfig config) {

    	// ContextPath
    	String contextPath = getContextPath();
    	if (StringUtils.isNotBlank(contextPath)) {
    		String realPath = PathUtils.getRealPath(getServletContext(), "/");
        	System.setProperty(contextPath + ".app.path", 
        			realPath.substring(0, realPath.length() - 1));
    	}
    }

    /**
     * Inicia el m�dulo de logs.
     * @param config Configuraci�n del servlet.
     */
    protected void initLoggingModule(ServletConfig config) {
    	String subdir = config.getInitParameter("subdir");
    	String fileName = config.getInitParameter("logFileName");
    	
		ISPACLogInitializer.init(subdir, fileName);
    }

    /**
     * Inicia el m�dulo de configuraci�n.
     * @param config Configuraci�n del servlet.
     * @throws ISPACException 
     */
    protected void initConfigurationModule(ServletConfig config) {
    	try {
    		ISPACConfiguration.getInstance();
    	} catch (ISPACException e) {
    		logger.error("Error al leer el fichero de configuraci�n", e);
    	}
    }

    /**
     * Inicia el contexto.
     * @param config Configuraci�n del servlet.
     * @throws ServletException si ocurre alg�n error.
     */
    protected void initContext(ServletConfig config) throws ServletException {
    	
    	// Contexto de la aplicaci�n
		ServletContext context = config.getServletContext();

		try {
			// Carga la configuraci�n de la aplicaci�n en el contexto
			context.setAttribute("ISPACConfiguration", ISPACConfiguration.getInstance());
		} catch (ISPACException e) {
			logger.warn("No se ha podido cargar la configuraci�n en el contexto de la aplicaci�n", e);
			throw new ServletException(e);
		}

    }
    
    private String getContextPath() {
    	
    	String contextPath = null;
    	
    	// Obtener la ruta completa de la aplicaci�n
    	String realPath = PathUtils.getRealPath(getServletContext(), "/");
    	if (StringUtils.isNotBlank(realPath)) {
    		
    		// Eliminar el �ltimo separador
    		contextPath = realPath.substring(0, realPath.length() - 1);
    		
    		// Obtener solamente el contextPath
    		contextPath = contextPath.substring(
    				contextPath.lastIndexOf(File.separator) + 1);
    		
    		// Eliminar la cadena ".war" del nombre, si lo hay
			int dotWarIx = contextPath.lastIndexOf(".war");
			if (dotWarIx > 0) {
				contextPath = contextPath.substring(0, dotWarIx);
			}
    	}

    	return contextPath;
    }
}
