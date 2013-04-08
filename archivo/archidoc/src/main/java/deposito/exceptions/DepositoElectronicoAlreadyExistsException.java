package deposito.exceptions;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando se intenta crear un dep�sito electr�nico con un
 * identificador externo que ya existe.
 */
public class DepositoElectronicoAlreadyExistsException extends
		CheckedArchivoException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoElectronicoAlreadyExistsException() {
		super();
	}
}
