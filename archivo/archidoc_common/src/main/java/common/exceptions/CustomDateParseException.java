package common.exceptions;


/**
 * Excepci�n generada cuando ocurre alg�n error en el an�lisis sint�ctico de una fecha.
 */
public class CustomDateParseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public CustomDateParseException(){
		super();
	}

	/**
	 * Constructor.
	 * @param cause Causa de la excepci�n.
	 */
	public CustomDateParseException(String cause){
		super(cause);
	}

	/**
	 * Constructor.
	 * @param cause Causa de la excepci�n.
	 * @param exception Excepcion que se lanza.
	 */
	public CustomDateParseException(String cause, Exception exception)
	{
		super(cause, exception);
	}
}
