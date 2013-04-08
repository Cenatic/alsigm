package se.procedimientos.exceptions;

import common.exceptions.SistemaExternoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el Sistema
 * Gestor de Cat�logo.
 */
public class GestorCatalogoException extends SistemaExternoException {

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
	public GestorCatalogoException(Throwable e) {
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
	public GestorCatalogoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorCatalogoException(String cause) {
		super(cause);
	}
}
