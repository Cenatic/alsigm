package se.instituciones.exceptions;

import common.exceptions.SistemaExternoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el Sistema
 * Gestor de Organizaci�n.
 */
public class GestorOrganismosException extends SistemaExternoException {

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
	public GestorOrganismosException(Throwable e) {
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
	public GestorOrganismosException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorOrganismosException(String cause) {
		super(cause);
	}
}
