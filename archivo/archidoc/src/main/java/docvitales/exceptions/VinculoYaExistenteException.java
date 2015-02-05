package docvitales.exceptions;

import common.exceptions.UncheckedArchivoException;

/**
 * Excepci�n lanzada cuando se intenta crear un v�nculo ya existente entre un
 * documento vital y un expediente.
 */
public class VinculoYaExistenteException extends UncheckedArchivoException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public VinculoYaExistenteException() {
		super("Ya existe un v�nculo entre el documento vital y el expediente");
	}
}
