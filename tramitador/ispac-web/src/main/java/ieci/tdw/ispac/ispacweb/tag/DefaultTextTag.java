package ieci.tdw.ispac.ispacweb.tag;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.impl.SessionAPIFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.taglib.html.TextTag;

/**
 * Tag base con m�todo reutilibles.
 *
 */
public abstract class DefaultTextTag extends TextTag {

	protected static final Logger logger = Logger.getLogger(DefaultTextTag.class);
	
	
	/**
	 * Obtiene la sesi�n de tramitaci�n.
	 * @return Sesi�n de tramitaci�n
	 */
	protected SessionAPI getSession() {

	  	SessionAPI sessionAPI = null;

	  	try	{
	  		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	  		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
	  		sessionAPI = SessionAPIFactory.getSessionAPI(request, response);
	    } catch( ISPACException e) {
	    	logger.warn("Error al obtener el SessionAPI", e);
	    }

	    return sessionAPI;
	}

	/**
	 * Obtiene el ticket la sesi�n.
	 * @return Ticket de la sesi�n.
	 */
	protected String getTicket() {
	  	
		String ticket = null;
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				ticket = cookies[i].getValue();
				break;
			}
		}

		return ticket;
	}

}
