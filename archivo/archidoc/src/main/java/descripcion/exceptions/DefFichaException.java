package descripcion.exceptions;

import common.exceptions.ArchivoModelException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en la definici�n de la ficha.
 */
public class DefFichaException extends ArchivoModelException {

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
	public DefFichaException(Exception e, String where, String msg) {
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
	public DefFichaException(Class where, String method, String cause) {
		super(where, method, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public DefFichaException(String cause) {
		super(cause);
	}
}
