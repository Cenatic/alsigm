package se.tramites;

import java.io.Serializable;

/**
 * Interfaz para la informaci�n b�sica de un expediente.
 */
public interface InfoBExpediente extends Serializable {

	/**
	 * Devuelve el identificador �nico.
	 * 
	 * @return Identificador �nico.
	 */
	public String getId();

	/**
	 * Devuelve el n�mero de expediente.
	 * 
	 * @return N�mero de expediente.
	 */
	public String getNumExp();

	/**
	 * Devuelve los datos que identifican al expediente.
	 * 
	 * @return Datos que identifican al expediente.
	 */
	public String getDatosIdentificativos();

}
