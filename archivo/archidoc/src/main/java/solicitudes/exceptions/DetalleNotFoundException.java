package solicitudes.exceptions;

import common.exceptions.CheckedArchivoException;

/**
 * Clase que envuelve los detalles que no se han encontrado durante una busqueda
 * en la base de datos.
 */
public class DetalleNotFoundException extends CheckedArchivoException {

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
	public DetalleNotFoundException(Exception e) {
		super(e);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            Excepci�n capturada.
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public DetalleNotFoundException(String cause, Exception e) {
		super(cause, e);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public DetalleNotFoundException(String cause) {
		super(cause);
	}
}