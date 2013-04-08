package se.repositorios.exceptions;

import common.exceptions.SistemaExternoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el Sistema
 * Gestor de Repositorio.
 */
public class GestorRepositorioException extends SistemaExternoException {

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
	public GestorRepositorioException(Throwable e) {
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
	public GestorRepositorioException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorRepositorioException(String cause) {
		super(cause);
	}
}
