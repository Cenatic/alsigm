package ieci.tdw.ispac.ispacweb.components;

import java.util.Map;

import ieci.tdw.ispac.api.ISessionAPI;
import ieci.tdw.ispac.api.errors.ISPACException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Interfaz para los componentes web.
 *
 */
public interface IWebComponent {

	/**
	 * Obtiene el identificador del componente.
	 * @return Identificador del componente.
	 */
	public String getId();

	/**
	 * Establece el identificador del componente.
	 * @param id Identificador del componente.
	 */
	public void setId(String id);

	/**
	 * Obtiene el t�tulo del componente.
	 * @return T�tulo del componente.
	 */
	public String getTitle();

	/**
	 * Obtiene el contenido del componente.
	 * @return Contenido del componente.
	 */
	public String getContent();
	
	/**
	 * Obtiene los par�metros del componente.
	 * @return Par�metros del componente.
	 */
	public Map getParameters();

	/**
	 * Obtiene el valor de un par�metro del componente.
	 * @param key Clave del par�metro.
	 * @return Valor del par�metro.
	 */
	public Object getParameter(Object key);

	/**
	 * Esteblece el valor de un par�metro del componente.
	 * @param key Clave del par�metro.
	 * @param value Valor del par�metro.
	 */
	public void putParameter(Object key, Object value);

	
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
    		throws ISPACException; 
	
}
