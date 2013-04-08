package deposito.model;

import common.exceptions.CheckedArchivoException;

/**
 * Excepcion que se produce cuando se intenta ocupar en mas espacio del
 * disponible en alg�n elemento del dep�sito f�sico
 */
public class NoAvailableSpaceException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NoAvailableSpaceException() {
	}
}
