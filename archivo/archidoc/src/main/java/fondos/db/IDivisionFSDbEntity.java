package fondos.db;

import java.util.List;

import common.db.IDBEntity;

import fondos.vos.DivisionFraccionSerieVO;

/**
 * M�todos de acceso a datos referentes a divisiones de fracciones de serie. <br>
 * Entidad: <b>ASGFDIVISIONFS</b>
 */
public interface IDivisionFSDbEntity extends IDBEntity {

	/**
	 * Recupera la divisi�n de fracci�n de serie cuya fracci�n de serie tiene el
	 * identificador que se suministra
	 * 
	 * @param idFS
	 *            Identificador de la fracci�n de serie
	 * @return Datos de la divisi�n de fracci�n de serie
	 */
	public DivisionFraccionSerieVO getDivisionFSXId(final String idFS);

	/**
	 * Inserta una nueva divisi�n de fracci�n de serie en la base de datos
	 * 
	 * @param DivisionFraccionSerieVO
	 *            Datos de la divisi�n de fracci�n de serie a guardar
	 * @return Datos de la fracci�n de serie insertada
	 */
	public DivisionFraccionSerieVO insertDivisionFS(
			final DivisionFraccionSerieVO divisionFSVO);

	/**
	 * Actualiza los datos de la divisi�n de fracciones de serie que se indica
	 * por par�metro
	 * 
	 * @param divisionFSVO
	 *            Datos de la divisi�n de fracci�n de serie a actualizar
	 */
	public void updateDivisionFS(final DivisionFraccionSerieVO divisionFSVO);

	/**
	 * Elimina la divisi�n de fracci�n de serie indicada de la tabla de
	 * divisiones de fracci�n de serie
	 * 
	 * @param idFS
	 *            : identificador de la fracci�n de serie
	 */
	public void deleteDivisionFS(String idFS);

	/**
	 * Cuenta el n�mero de divisiones de fracci�n de serie del gestor indicado y
	 * en los estados indicados. Si no se indican estados, se presupone que se
	 * buscan en cualquier estado
	 * 
	 * @param idUsrGestor
	 * @param estados
	 * @return n�mero de divisiones de fracci�n de serie en los estados
	 *         indicados
	 */
	public int getCountDivisionFSXUsr(String idUsrGestor, int[] estados);

	/**
	 * Devuelve las divisiones de fracci�n de serie del gestor indicado y en los
	 * estados indicados. Si no se indican estados, se presupone que se buscan
	 * en cualquier estado
	 * 
	 * @param idUsrGestor
	 * @param estados
	 * @return divisiones de fracci�n de serie en los estados indicados y cuyo
	 *         gestor es el indicado
	 */
	public List getDivisionesFSXUsr(String idUsrGestor, int[] estados);

	/**
	 * Recupera las divisiones de fracci�n de serie cuyos identificadores se
	 * pasan como par�metro
	 * 
	 * @param idsFS
	 *            Identificadores de las fracciones de serie
	 * @return Lista de la divisiones de fracci�n de serie
	 */
	public List getDivisionesFSXId(String[] idsFS);

	/**
	 * Obtiene los Ids de las Divisiones que contienen los descriptores
	 * seleccionados.
	 * 
	 * @param idsDescriptores
	 *            Identificadores de los descriptores a buscar
	 * @return Lista de {@link DivisionFraccionSerieVO}
	 */
	public List getUdocsByInfoDescriptor(String[] idsDescriptores);
}