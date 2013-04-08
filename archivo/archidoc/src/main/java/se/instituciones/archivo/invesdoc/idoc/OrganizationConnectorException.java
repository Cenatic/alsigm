package se.instituciones.archivo.invesdoc.idoc;

import es.archigest.framework.core.exceptions.ArchigestModelException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el sistema de
 * autenticaci�n.
 */
public class OrganizationConnectorException extends ArchigestModelException {
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
	public OrganizationConnectorException(Exception e, String where, String msg) {
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
	public OrganizationConnectorException(Class where, String method,
			String cause) {
		super(where, method, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public OrganizationConnectorException(String cause) {
		super(cause);
	}
}
