package se.usuarios.exceptions;

import common.Constants;
import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error de validaci�n del usuario.
 */
public class AppUserException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// ========================================================================
	// C�DIGOS DE ERROR
	// ========================================================================
	public static final short NO_ERROR = 0;
	public static final short USER_NOT_FOUND = 1;
	public static final short USER_NOT_ACTIVATED = 2;
	public static final short USER_EXPIRED = 3;
	public static final short USER_WITH_NO_PERMISSIONS = 4;
	public static final short USER_ORGANIZATION_ERROR = 5;
	public static final short USER_TYPE_NOT_FOUND = 6;
	// ========================================================================

	// ========================================================================
	// MENSAJES DE ERROR
	// ========================================================================
	public static final String[] MESSAGES = new String[] { "",
			Constants.LOGIN_APPLICATION_NOT_FOUND,
			Constants.LOGIN_APPLICATION_NOT_ACTIVATED,
			Constants.LOGIN_APPLICATION_EXPIRED,
			Constants.LOGIN_APPLICATION_NO_PERMISSIONS,
			Constants.LOGIN_APPLICATION_ORGANIZATION_ERROR,
			Constants.LOGIN_USER_TYPE_NOT_FOUND };
	// ========================================================================

	/** C�digo de error. */
	private short errorCode = NO_ERROR;

	/** Par�metros del error. */
	private Object[] parameters = null;

	/**
	 * Constructor.
	 */
	public AppUserException() {
		super("");
	}

	/**
	 * Constructor.
	 * 
	 * @param error
	 *            Error.
	 */
	public AppUserException(short errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Constructor.
	 * 
	 * @param error
	 *            Error.
	 * @param parameters
	 *            Par�metros del error.
	 */
	public AppUserException(short errorCode, Object[] parameters) {
		this.errorCode = errorCode;
		this.parameters = parameters;
	}

	/**
	 * Obtiene el c�digo del error.
	 * 
	 * @return C�digo del error.
	 */
	public short getErrorCode() {
		return errorCode;
	}

	/**
	 * Establece el c�digo del error.
	 * 
	 * @param errorCode
	 *            C�digo del error.
	 */
	public void setErrorCode(short errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Obtiene los par�metros del error.
	 * 
	 * @return Par�metros del error.
	 */
	public Object[] getParameters() {
		return parameters;
	}

	/**
	 * Establece los par�metros del error.
	 * 
	 * @param parameters
	 *            Par�metros del error.
	 */
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

}
