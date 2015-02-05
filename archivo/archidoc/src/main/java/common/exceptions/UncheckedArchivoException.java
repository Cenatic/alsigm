package common.exceptions;

/**
 * Padre de las excepciones de archivo no chequeadas.
 */
public class UncheckedArchivoException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public UncheckedArchivoException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            Excepci�n capturada.
	 */
	public UncheckedArchivoException(Throwable e) {
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
	public UncheckedArchivoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public UncheckedArchivoException(String cause) {
		super(cause);
	}
}
