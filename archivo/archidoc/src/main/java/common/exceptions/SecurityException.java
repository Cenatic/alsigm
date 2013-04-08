package common.exceptions;

import es.archigest.framework.core.exceptions.ArchigestModelException;

/**
 * Excepci�n generada cuando ocurre alg�n de seguridad en la aplicaci�n.
 */
public class SecurityException extends ArchigestModelException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Listas de permisos que deber�a cumplir para realizar la acci�n */
	private String[][] permission = null;

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
	public SecurityException(Exception e, String where, String msg) {
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
	public SecurityException(Class where, String method, String cause) {
		super(where, method, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public SecurityException(String cause) {
		super(cause);
	}

	public String[][] getPermission() {
		return permission;
	}

	public void setPermission(String[][] permission) {
		this.permission = permission;
	}
}
