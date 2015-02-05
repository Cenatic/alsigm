package transferencias.db;

import java.util.Collection;
import java.util.List;

import transferencias.vos.DetallePrevisionVO;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASGTDETALLEPREV</b>
 *
 * @author IECISA
 *
 */
public interface IDetallePrevisionDBEntity extends IDBEntity {
	/**
	 * Obtiene de las lineas de detalle de una prevision
	 *
	 * @param codigoPrevision
	 *            Codigo de la prevision cuyos detalles se quieren recuperar
	 * @param conn
	 *            Conexi�n a la base de datos
	 * @return Lista con las lineas de detalle de la prevision
	 * @throws Exception
	 */
	public abstract Collection fetchRowsByCodigoPrevision(String codigoPrevision);

	/**
	 * Incorpora una nueva linea de detalle a una prevision
	 *
	 * @param conn
	 *            Conexion a la base de datos
	 * @param detallePrevision
	 *            Informacion de la linea de detalle a grabar en la base de
	 *            datos
	 * @throws Exception
	 */
	public abstract void insertRow(final DetallePrevisionVO detallePrevision);

	/**
	 * Actualiza la informacion de una linea de detalle
	 *
	 * @param conn
	 *            Conexion a la base de datos
	 * @param detallePrevision
	 *            Informacion de la linea de detalle a actualizar
	 * @throws Exception
	 */
	public abstract void updateRow(final DetallePrevisionVO detallePrevision);

	/**
	 * Obtiene la informacion correspondiente a una linea de detalle de una
	 * prevision
	 *
	 * @param conn
	 *            Conexion a la base de datos
	 * @param prevision
	 *            Identificador de la prevision a la que pertenece la linea de
	 *            detalle
	 * @param numeroDetalle
	 *            Numero de la linea de detalle
	 * @return Informacion de la linea de detalle
	 * @throws Exception
	 */
	public abstract DetallePrevisionVO selectRow(String prevision,
			int numeroDetalle);

	/**
	 * Obtiene la informacion correspondiente a una linea de detalle de una
	 * prevision
	 *
	 * @param conn
	 *            Conexion a la base de datos
	 * @param idDetalle
	 *            Identificador de la linea de detalle
	 * @return Informacion de la linea de detalle
	 * @throws Exception
	 */
	public abstract DetallePrevisionVO selectRow(String idDetalle);

	/**
	 * Borra lineas de detalle de una previsi�n. Caso de indicarse un
	 * identificador de l�nea de detalle �nicamente la l�nea indicada es
	 * eliminada. Si no se indica l�nea de detalle se eliminan todas las l�neas
	 * de detalle de la previsi�n
	 *
	 * @param prevision
	 *            Identificador de previsi�n de transferencia
	 * @param idDetalle
	 *            Identificador de l�nea de detalle. Puede ser nulo
	 */
	public abstract void dropRow(String prevision, String idDetalle);

	/**
	 * Obtiene la linea de detalle con expedientes mas recientes de un
	 * determinado procedimiento
	 *
	 */
	public abstract DetallePrevisionVO selectLastRowByProcedimiento(
			String procedimiento);

	public abstract Collection selectRowsWithoutRelacion(String prevision);

	public abstract Collection selectRowsWithoutRelacionXFormato(
			String prevision, String idFormato);

	public abstract DetallePrevisionVO selectLastRowBySerie(String serie);

	public abstract int numeroDetallesPrevision(final String idPrevision);

	public abstract int incNRelacionesAsociadasADetalle(final String idDetalle);

	public abstract int decNRelacionesAsociadasADetalle(final String idDetalle);

	public abstract boolean checkAllDetallesPrevisionCerrados(
			final String idPrevision);

	public abstract void cerrarDetalle(String idDetalle);

	/**
	 * Obtiene las Unidades de Instalaci�n a las que pertenecen las UDocs.
	 *
	 * @param idsUnidadesDocumentales
	 *            Lista de Strings
	 * @return Lista de UInsDepositoVO
	 */
	public List getUInstXUdoc(List idsUnidadesDocumentales);

	/**
	 * Obtiene las Unidades de Instalaci�n a las que pertenecen las UDocs y
	 * cuyos ids no est�n comprendidos en los ids especificados.
	 *
	 * @param idsUnidadesDocumentales
	 *            Lista de Strings de Unidades Documentales
	 * @param idsUnidadesNotIn
	 *            Lista Strings Ids a excluir
	 * @return Lista de UInsDepositoVO
	 */
	public List getUInstXUdoc(List idsUnidadesDocumentales,
			List idsUnidadesExcluir);

	/**
	 * Obtener detalle del previsi�n por los objetos del VO.
	 * @param detalle
	 * @return
	 */
	public DetallePrevisionVO getDetallePrevisionVO(DetallePrevisionVO detalle);

	/**
    * Obtiene el n�mero de series asociadas al detalle de la previsi�n
    * @param idSerie Cadena que contiene el n�mero d ela
    * @return
    */
	public int getCountDetallesBySerie(String idSerie);

}