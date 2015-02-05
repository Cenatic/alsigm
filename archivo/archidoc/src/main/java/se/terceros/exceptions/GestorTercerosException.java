package se.terceros.exceptions;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en el conector con el Gestor de
 * Terceros.
 */
public class GestorTercerosException extends CheckedArchivoException {

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
	public GestorTercerosException(Throwable e) {
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
	public GestorTercerosException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public GestorTercerosException(String cause) {
		super(cause);
	}
}
