package se.ficheros.exceptions;

import es.archigest.framework.core.exceptions.ArchigestModelException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error el sistema gestor de ficheros
 */
public class GestorFicherosException extends ArchigestModelException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 * @param e
	 *            Excepci�n capturada.
	 * @param where
	 *            Lugar donde se ha lanzado la excepci�n.
	 * @param msg
	 *            Texto del mensaje.
	 */
	public GestorFicherosException(Exception e, String where, String msg) {
		super(e, where, msg);
	}

	/**
	 * Constructor.
	 *
	 * @param where
	 *            Lugar donde se ha lanzado la excepci�n.
	 * @param method
	 *            M�todo que lanza la excepci�n.
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorFicherosException(Class where, String method, String cause) {
		super(where, method, cause);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorFicherosException(String cause) {
		super(cause);
	}
}
