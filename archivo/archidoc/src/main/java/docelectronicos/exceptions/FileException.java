package docelectronicos.exceptions;

import common.exceptions.UncheckedArchivoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error con los ficheros.
 */
public class FileException extends UncheckedArchivoException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            Excepci�n capturada.
	 */
	public FileException(Throwable e) {
		super(e);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            Causa de la excepci�n.
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public FileException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public FileException(String cause) {
		super(cause);
	}
}
