package common.util.terceros;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando un n�mero de identificaci�n no es v�lido.
 */
public class IFNotValidException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** N�mero de identificaci�n. */
	private String ifNumber = null;

	/**
	 * Constructor.
	 */
	public IFNotValidException(String ifNumber) {
		super(ifNumber);
		this.ifNumber = ifNumber;
	}

	/**
	 * Obtiene el n�mero de identificaci�n.
	 * 
	 * @return N�mero de identificaci�n.
	 */
	public String getIfNumber() {
		return ifNumber;
	}
}
