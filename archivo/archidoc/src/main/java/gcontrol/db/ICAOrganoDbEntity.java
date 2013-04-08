package gcontrol.db;

import gcontrol.vos.CAOrganoVO;

import java.util.List;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASCAORGANO</b>
 * 
 * @author IECISA
 * 
 */
public interface ICAOrganoDbEntity extends IDBEntity {
	/**
	 * Obtiene la lista de �rganos productores.
	 * 
	 * @param vigente
	 *            Indica si los �rganos deben ser vigentes o no vigentes. Si es
	 *            nulo, se devolver�n todos los �rganos productores.
	 * @return Lista de �rganos productores.
	 */
	public List getCAOrgProductoresVOList(Boolean vigente);

	/**
	 * Obtiene la informaci�n de un �rgano.
	 * 
	 * @param idOrgano
	 *            Identificador del �rgano.
	 * @return Informaci�n de un �rgano.
	 */
	public CAOrganoVO getCAOrgProductorVOXId(String idOrgano);

	/**
	 * Recupera de la base de datos la informacion correspondiente a un conjunto
	 * de organos
	 * 
	 * @param idOrgano
	 *            Lista de identificadores de organo. Puede ser null
	 * @return Lista de organos {@link CAOrganoVO}
	 */
	public List getCAOrgProductorVOXId(String[] idOrgano);

	/**
	 * Obtiene la informaci�n de un �rgano.
	 * 
	 * @param sistExtGestor
	 *            Sistema Gestor de Organismos externo.
	 * @param idEnSistExt
	 *            Identificador del organismo en el Sistema Gestor de Organismos
	 *            externo.
	 * @return Informaci�n de un �rgano.
	 */
	public abstract CAOrganoVO getCAOrgProductorVOXSistExtGestorYIdOrgsExtGestor(
			final String sistExtGestor, final String idEnSistExt);

	public abstract List getCAOrgProductorVOXSistExtGestorYVigencia(
			final String sistExtGestor, final boolean vigente);

	public CAOrganoVO getCAOrgProductorVOXSistExtGestorYIdOrgsExtGestorYVigencia(
			final String sistExtGestor, final String idEnSistExt,
			final boolean vigente);

	/**
	 * Obtiene la lista de �rganos a partir del Sistema Gestor Externo y una
	 * lista de identificadores en ese sistema.
	 * 
	 * @param sistExtGestor
	 *            Sistema Gestor de Organismos Externo.
	 * @param idsEnSistExt
	 *            Lista de identificadores en el Sistema Gestor de Organismos
	 *            Externo.
	 * @return Lista de �rganos.
	 */
	public List getCAOrgProductorVOListXSistExtGestorYIdOrgsExtGestor(
			final String sistExtGestor, final Object idsEnSistExt);

	/**
	 * Inserta en la base de datos la informacion correspondiente a un nuevo
	 * organo
	 * 
	 * @param caOrganoVO
	 *            datos del organo a insertar
	 * @return Organo insertado
	 */
	public CAOrganoVO insertCAOrgVO(CAOrganoVO caOrganoVO);

	/**
	 * Actualiza la informacion de un organo
	 * 
	 * @param organo
	 *            Datos del organo a modificar
	 */
	public void updateCAOrgVO(CAOrganoVO organo);

	/**
	 * Eliminar un organo de la tabla de organos
	 * 
	 * @param idOrgano
	 *            Identificador del organo a eliminar
	 */
	public void eliminarOrgano(String idOrgano);

	/**
	 * Recupera los �rganos por c�digo y/o nombre.
	 * 
	 * @param code
	 *            C�digo del �rgano.
	 * @param name
	 *            Nombre del �rgano.
	 * @param vigente
	 *            Indicador de vigente
	 * @return Lista de �rganos {@link CAOrganoVO}.
	 */
	public List findByCodeAndName(String code, String name, String vigente);

	/**
	 * Recupera los �rganos cuyo nombre contiene la cadena suministrada
	 * 
	 * @param query
	 *            Patr�n de b�squeda a localizar en el nombre del �rgano
	 * @param externalSystem
	 *            Identificador del sistema externo del que se ha importado el
	 *            �rgano. Puede ser nulo
	 * @return Lista de �rganos cuyo nombre contiene el patr�n indicado
	 *         {@link CAOrganoVO}
	 */
	public List findByName(String query, String externalSystem);

	/**
	 * Obtiene la informaci�n de un �rgano por su nombre largo
	 * 
	 * @param nombreLargo
	 *            Cadena que contiene el nombre largo del �rgano
	 * @return Informaci�n de un �rgano.
	 */
	public CAOrganoVO getCAOrgProductorVOByNombreLargo(String nombreLargo);
}