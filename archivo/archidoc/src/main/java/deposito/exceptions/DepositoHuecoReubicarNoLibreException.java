package deposito.exceptions;

import deposito.model.DepositoException;

/**
 * Excepci�n lanzada cuando se intenta ubicar en un hueco que ya est� utilizado.
 */
public class DepositoHuecoReubicarNoLibreException extends DepositoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoHuecoReubicarNoLibreException() {
		super(DepositoException.NO_SE_PUEDE_REUBICAR_A_HUECOS_NO_LIBRES);
	}
}
