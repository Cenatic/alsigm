package se.tramites;

import java.io.Serializable;

/**
 * Interfaz para la informaci�n de un documento f�sico.
 */
public interface DocFisico extends Serializable {

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

}
