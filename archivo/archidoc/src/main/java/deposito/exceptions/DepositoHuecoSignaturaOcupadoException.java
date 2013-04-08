package deposito.exceptions;

import deposito.model.DepositoException;

/**
 * Excepci�n lanzada cuando se intenta ubicar en un hueco que ya est� utilizado.
 */
public class DepositoHuecoSignaturaOcupadoException extends DepositoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoHuecoSignaturaOcupadoException() {
		super(DepositoException.SIGNATURA_HUECO_OCUPADA);
	}
}
