package se.tramites.exceptions;

import common.exceptions.SistemaExternoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el Sistema
 * Tramitador.
 */
public class SistemaTramitadorException extends SistemaExternoException {
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
	public SistemaTramitadorException(Throwable e) {
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
	public SistemaTramitadorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public SistemaTramitadorException(String cause) {
		super(cause);
	}
}
