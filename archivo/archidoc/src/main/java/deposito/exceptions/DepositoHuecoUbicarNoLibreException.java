package deposito.exceptions;

import deposito.model.DepositoException;

/**
 * Excepci�n lanzada cuando se intenta ubicar en un hueco que ya est� utilizado.
 */
public class DepositoHuecoUbicarNoLibreException extends DepositoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoHuecoUbicarNoLibreException() {
		super(DepositoException.NO_SE_PUEDE_UBICAR_A_HUECOS_NO_LIBRES);
	}
}
