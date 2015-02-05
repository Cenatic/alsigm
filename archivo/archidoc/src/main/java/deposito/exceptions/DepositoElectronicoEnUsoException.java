package deposito.exceptions;

import common.exceptions.CheckedArchivoException;

/**
 * Excepci�n lanzada cuando se intenta eliminar un dep�sito electr�nico en uso.
 */
public class DepositoElectronicoEnUsoException extends CheckedArchivoException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoElectronicoEnUsoException() {
		super();
	}
}
