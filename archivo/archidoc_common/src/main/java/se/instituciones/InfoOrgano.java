package se.instituciones;

import java.io.Serializable;

/**
 * Interfaz para los contenedores de informaci�n de �rganos.
 */
public interface InfoOrgano extends Serializable {

	/**
	 * Obtiene el identificador del �rgano.
	 *
	 * @return identificador del �rgano.
	 */
	public String getId();

	/**
	 * Obtiene el nombre del �rgano.
	 *
	 * @return nombre del �rgano.
	 */
	public String getNombre();

	/**
	 * Obtiene el c�digo del �rgano.
	 *
	 * @return c�digo del �rgano.
	 */
	public String getCodigo();

	/**
	 * Obtiene el nivel jer�rquico al que pertenece el �rgano.
	 *
	 * @return nivel jer�rquico.
	 */
	public int getNivel();

	/**
	 * Obtiene el identificador del �rgano padre al que pertenece el �rgano.
	 *
	 * @return identificador del �rgano.
	 */
	public String getIdPadre();
}
