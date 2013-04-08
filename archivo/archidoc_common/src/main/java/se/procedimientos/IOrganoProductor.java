package se.procedimientos;

import java.io.Serializable;
import java.util.Date;

/**
 * Interfaz para la informaci�n de un �rgano productor.
 */
public interface IOrganoProductor extends Serializable {

	/**
	 * Devuelve el identificador del �rgano.
	 *
	 * @return Identificador del �rgano.
	 */
	public String getId();

	/**
	 * Devuelve la fecha desde la que el �rgano es productor.
	 *
	 * @return Fecha.
	 */
	public Date getInicioProduccion();

}
