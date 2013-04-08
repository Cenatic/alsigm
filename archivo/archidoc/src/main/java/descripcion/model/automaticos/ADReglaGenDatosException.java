package descripcion.model.automaticos;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en la generaci�n de datos
 * autom�ticos.
 */
public class ADReglaGenDatosException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public ADReglaGenDatosException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            Excepci�n capturada.
	 */
	public ADReglaGenDatosException(Throwable e) {
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
	public ADReglaGenDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public ADReglaGenDatosException(String cause) {
		super(cause);
	}

}
