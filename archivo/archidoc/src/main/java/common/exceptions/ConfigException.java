package common.exceptions;

import es.archigest.framework.core.exceptions.ArchigestModelException;

/**
 * Excepci�n generada cuando ocurre alg�n error en la configuraci�n.
 */
public class ConfigException extends ArchigestModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5900316406567138894L;

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
	public ConfigException(Exception e, String where, String msg) {
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
	public ConfigException(Class where, String method, String cause) {
		super(where, method, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public ConfigException(String cause) {
		super(cause);
	}
}
