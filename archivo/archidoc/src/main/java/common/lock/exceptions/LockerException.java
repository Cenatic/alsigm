package common.lock.exceptions;

import common.Constants;
import common.exceptions.CheckedArchivoException;
import common.lock.vos.LockVO;

/**
 * Excepci�n lanzada cuando el objeto est� bloqueado.
 */
public class LockerException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Informaci�n del bloqueo. */
	LockVO lockInfo = null;

	/**
	 * Constructor.
	 * 
	 * @param lockInfo
	 *            Informaci�n del bloqueo.
	 */
	public LockerException(LockVO lockInfo) {
		super();

		this.lockInfo = lockInfo;
	}

	/**
	 * Obtiene la informaci�n del bloqueo.
	 * 
	 * @return Informaci�n del bloqueo.
	 */
	public LockVO getLockVO() {
		return lockInfo;
	}

	/**
	 * Obtiene una representaci�n del objeto.
	 * 
	 * @return Representaci�n del objeto.
	 */
	public String getMessage() {
		return new StringBuffer().append("<LockerException>")
				.append(Constants.NEWLINE)
				.append(lockInfo != null ? lockInfo.toXML(2) : "")
				.append("</LockerException>").append(Constants.NEWLINE)
				.toString();
	}
}
