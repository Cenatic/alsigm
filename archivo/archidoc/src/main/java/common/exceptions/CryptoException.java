package common.exceptions;

/**
 * Excepci�n generada cuando ocurre alg�n error en la encriptaci�n o
 * desencriptaci�n.
 */
public class CryptoException extends UncheckedArchivoException {
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
	public CryptoException(Throwable e) {
		super(e.getMessage());
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            Causa de la excepci�n.
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public CryptoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public CryptoException(String cause) {
		super(cause);
	}
}
