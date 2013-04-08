package transferencias.model;

import common.exceptions.CheckedArchivoException;

/**
 * Lanzada cuando se intenta determinar el tipo de operacion de una
 * transferencia a partir de un tipo de transferencia y de un tipo de prevision.
 * Las posiblilidades v�lidas son:
 * <ul>
 * <li>Tipo de transferencia: TRANSFERENCIA ORDINARIA y Tipo previsi�n:
 * PREVISI�N DETALLADA</li>
 * <li>Tipo de transferencia: TRANSFERENCIA EXTRAORDINARIA NO SIGNATURADA y Tipo
 * previsi�n: PREVISI�N DETALLADA</li>
 * <li>Tipo de transferencia: TRANSFERENCIA EXTRAORDINARIA NO SIGNATURADA y Tipo
 * previsi�n: PREVISI�N NO DETALLADA</li>
 * <li>Tipo de transferencia: TRANSFERENCIA EXTRAORDINARIA SIGNATURADA y Tipo
 * previsi�n: PREVISI�N NO DETALLADA</li>
 * </ul>
 */
public class InvalidTipoTransferenciaException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTipoTransferenciaException(String cause) {
		super(cause);
	}
}