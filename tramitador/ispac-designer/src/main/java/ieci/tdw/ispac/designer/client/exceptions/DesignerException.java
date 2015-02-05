package ieci.tdw.ispac.designer.client.exceptions;

import com.google.gwt.user.client.rpc.SerializableException;

/**
 * Excepci�n lanzada si ocurre alg�n error en el dise�ador gr�fico.
 *
 */
public class DesignerException extends SerializableException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor.
	 */
	public DesignerException() {
		super();
	}
	
	/**
	 * Constructor.
	 * @param message Mensaje de la excepci�n.
	 */
	public DesignerException(String message) {
		super(message);
	}
	
}
