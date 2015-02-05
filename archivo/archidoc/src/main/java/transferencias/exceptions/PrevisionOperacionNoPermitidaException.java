package transferencias.exceptions;

import common.definitions.ArchivoModules;
import common.exceptions.ActionNotAllowedException;

/**
 * Excepci�n que se produce cuando se trata de realizar alguna acci�n sobre
 * presiones de transferencia y dicha acci�n no est� permitida.
 */
public class PrevisionOperacionNoPermitidaException extends
		ActionNotAllowedException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * C�digo que especifica el motivo por el que se produce la excepci�n
	 * 
	 * @see auditoria.ArchivoErrorCodes
	 */
	int motivo;

	public PrevisionOperacionNoPermitidaException(int motivo, String causa) {
		super(causa, motivo, ArchivoModules.TRANSFERENCIAS_MODULE);
	}

	public PrevisionOperacionNoPermitidaException(int motivo) {
		super(null, motivo, ArchivoModules.TRANSFERENCIAS_MODULE);
	}

}