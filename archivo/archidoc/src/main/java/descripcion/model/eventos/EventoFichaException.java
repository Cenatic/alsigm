package descripcion.model.eventos;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando ocurre alg�n error en la ejecuci�n del evento.
 */
public class EventoFichaException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public EventoFichaException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            Excepci�n capturada.
	 */
	public EventoFichaException(Throwable e) {
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
	public EventoFichaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Causa de la excepci�n.
	 */
	public EventoFichaException(String cause) {
		super(cause);
	}

}
