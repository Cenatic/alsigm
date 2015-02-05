package se.tramites;

import java.io.Serializable;

/**
 * Interfaz para la informaci�n de un documento electr�nico.
 */
public interface DocElectronico extends Serializable {

	/**
	 * Devuelve el tipo de documento.
	 * 
	 * @return Tipo de documento.
	 */
	public String getTipoDocumento();

	/**
	 * Devuelve el asunto.
	 * 
	 * @return Asunto.
	 */
	public String getAsunto();

	/**
	 * Devuelve el repositorio.
	 * 
	 * @return Repositorio.
	 */
	public String getRepositorio();

	/**
	 * Devuelve el localizador para recuperar de forma �nica el documento.
	 * 
	 * @return Localizador.
	 */
	public String getLocalizador();

	/**
	 * Devuelve la extensi�n del fichero.
	 * 
	 * @return Extensi�n del fichero.
	 */
	public String getExtension();
}
