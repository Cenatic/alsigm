package deposito.exceptions;

import deposito.model.DepositoException;

/**
 * Excepci�n lanzada cuando se intenta ubicar en un hueco que ya est� utilizado.
 */
public class DepositoHuecoCompactarNoLibreException extends DepositoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DepositoHuecoCompactarNoLibreException() {
		super(DepositoException.COMPACTAR_HUECO_OCUPADO_PROCESO_COMPACTACION);
	}
}
