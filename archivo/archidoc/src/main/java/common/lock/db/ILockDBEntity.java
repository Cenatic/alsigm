package common.lock.db;

import common.db.IDBEntity;
import common.lock.vos.LockVO;

/**
 * Interfaz para todas las definiciones de los bloqueos, as� como de las
 * operaciones que se pueden realizar sobre ellos. <br>
 * Entidad: <b>AGOBJBLOQUEO</b>
 */
public interface ILockDBEntity extends IDBEntity {

	/**
	 * Obtiene la informaci�n de un bloqueo.
	 * 
	 * @param idObj
	 *            Identificador del objeto.
	 * @param tipoObj
	 *            Tipo de objeto.
	 * @param modulo
	 *            M�dulo donde se ha bloqueado.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return Informaci�n del bloqueo.
	 */
	public LockVO getBloqueo(String idObj, int tipoObj, int modulo,
			String idUsuario);

	/**
	 * Obtiene la informaci�n de un bloqueo y bloquea el registro en base de
	 * datos hasta cerrar la transacci�n.
	 * 
	 * @param idObj
	 *            Identificador del objeto.
	 * @param tipoObj
	 *            Tipo de objeto.
	 * @param modulo
	 *            M�dulo donde se ha bloqueado.
	 * @return Informaci�n del bloqueo.
	 */
	public LockVO getBloqueoForUpdate(String idObj, int tipoObj, int modulo);

	/**
	 * Inserta un nuevo bloqueo en la base de datos
	 * 
	 * @param bloqueo
	 *            Informaci�n del bloqueo.
	 */
	public void insertBloqueo(final LockVO bloqueo);

	/**
	 * Realiza la actualizacion de un bloqueo.
	 * 
	 * @param bloqueo
	 *            Informaci�n del bloqueo.
	 */
	public void updateBloqueo(LockVO bloqueo);

	/**
	 * Elimina un bloqueo en la base de datos.
	 * 
	 * @param idObj
	 *            Identificador del objeto.
	 * @param tipoObj
	 *            Tipo de objeto.
	 * @param modulo
	 *            M�dulo donde se ha bloqueado.
	 * @param idUsuario
	 *            Identificador del usuario que ha realizado el bloqueo.
	 */
	public void deleteBloqueo(String idObj, int tipoObj, int modulo,
			String idUsuario);

	/**
	 * Elimina un bloqueo en la base de datos.
	 * 
	 * @param idObj
	 *            Identificador del objeto.
	 * @param tipoObj
	 *            Tipo de objeto.
	 * @param modulo
	 *            M�dulo donde se ha bloqueado.
	 */
	public void deleteBloqueo(String idObj, int tipoObj, int modulo);

	LockVO getBloqueo(String idObj, int tipoObj, int modulo);
}