package common.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import util.ErrorsTag;

/**
 * Utilidad para gestionar el locale de la sesi�n.
 */
public class LocaleHelper {

	/**
	 * Establece el idioma de la aplicaci�n.
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param locale
	 *            Informaci�n del idioma.
	 */
	public static void setLocale(HttpServletRequest request, Locale locale) {
		HttpSession session = request.getSession();

		// Configuraci�n para Struts
		session.setAttribute(ErrorsTag.KEY_LOCALE, locale);

		// Configuraci�n para JSTL
		Config.set(session, Config.FMT_LOCALE, locale);
	}

}
