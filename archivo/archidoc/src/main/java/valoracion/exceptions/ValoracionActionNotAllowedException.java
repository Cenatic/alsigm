package valoracion.exceptions;

import common.definitions.ArchivoModules;
import common.exceptions.ActionNotAllowedException;

/**
 * Exception lanzada si se produce un intento de realizaci�n de una operaci�n no
 * permitida en el m�dulo de valoracion por parte de un usuario de la
 * aplicaci�n.
 */
public class ValoracionActionNotAllowedException extends
		ActionNotAllowedException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ValoracionActionNotAllowedException(int codError) {
		super(codError);
		setModule(ArchivoModules.FONDOS_MODULE);
	}
}
