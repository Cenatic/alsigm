package se.tramites;

import java.io.Serializable;

/**
 * Interfaz para la informaci�n del emplazamiento.
 */
public interface Emplazamiento extends Serializable {

	/**
	 * Devuelve si el emplazamiento est� validado.
	 * 
	 * @return
	 */
	public String getValidado();

	/**
	 * Devuelve el pa�s.
	 * 
	 * @return Pa�s.
	 */
	public String getPais();

	/**
	 * Devuelve la comunidad
	 * 
	 * @return Comunidad.
	 */
	public String getComunidad();

	/**
	 * Devuelve la poblaci�n.
	 * 
	 * @return Poblaci�n.
	 */
	public String getPoblacion();

	/**
	 * Devuelve la localizaci�n.
	 * 
	 * @return Localizaci�n.
	 */
	public String getLocalizacion();

	/**
	 * Devuelve el municipio.
	 * 
	 * @return Municipio.
	 */
	public String getConcejo();
}
