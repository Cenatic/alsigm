package common.exceptions;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en la conexi�n con Sistemas
 * Externos.
 */
public class RequiredEntityException extends CheckedArchivoException {

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
	public RequiredEntityException(Throwable e) {
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
	public RequiredEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public RequiredEntityException(String cause) {
		super(cause);
	}
}
