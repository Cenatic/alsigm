package se.procedimientos;

import java.io.Serializable;

/**
 * Interfaz para la informaci�n b�sica de un procedimiento.
 */
public interface InfoBProcedimiento extends Serializable {

	/**
	 * Devuelve el identificador del procedimiento.
	 * 
	 * @return Identificador del procedimiento.
	 */
	public String getId();

	/**
	 * Devuelve el c�digo del procedimiento.
	 * 
	 * @return C�digo del procedimiento.
	 */
	public String getCodigo();

	/**
	 * Devuelve el nombre del procedimiento.
	 * 
	 * @return Nombre del procedimiento.
	 */
	public String getNombre();

	/**
	 * Devuelve el c�digo del sistema productor. Si el procedimiento no es
	 * automatizado este valor ser� nulo.
	 * 
	 * @return C�digo del sistema productor.
	 */
	public String getCodSistProductor();

	/**
	 * Devuelve el nombre del sistema productor. Si el procedimiento no es
	 * automatizado este valor ser� nulo.
	 * 
	 * @return Nombre del sistema productor.
	 */
	public String getNombreSistProductor();

}
