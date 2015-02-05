package transferencias.db;

import java.util.List;

import transferencias.vos.UnidadInstalacionReeaVO;

import common.db.IDBEntity;
import common.util.IntervalOptions;

/**
 * Entidad: <b>ASGTUINSTALACIONREEA</b>
 * 
 * @author IECISA
 * 
 */
public interface IUnidadInstalacionReeaDBEntity extends IDBEntity {
	/**
	 * Inserta una nueva fila en la tabla de unidades de instalacion en REA
	 * 
	 * @param unidadInstalacion
	 *            Datos de la unidad de instalacion a insertar
	 */
	public void insertRow(final UnidadInstalacionReeaVO unidadInstalacion);

	/**
	 * Elimina los registros seleccionados
	 * 
	 * @param ids
	 *            Identificador de la unidad de instalaci�n a eliminar
	 */
	public void deleteRow(final String idUnidadInstalacion);

	/**
	 * Obtiene las unidades de instalaci�n de una relaci�n entre archivos
	 * 
	 * @param idRelacion
	 *            Identificador de la Relacion
	 * @return Lista de {@link UnidadInstalacionReeaVO}
	 */
	public List getUnidadesInstalacionXIdRelacionEntreArchivos(String idRelacion);

	/**
	 * Obtiene las unidades de instalaci�n de una relaci�n entre archivos
	 * 
	 * @param idRelacion
	 *            Identificador de la Relacion
	 * @return Lista de {@link UnidadInstalacionReeaVO}
	 */
	public List getUnidadesInstalacionXIdRelacionEntreArchivosByIds(
			String idRelacion, String[] idsUIs);

	/**
	 * Cuenta las unidades de instalaci�n de una relacci�n de entrega
	 * 
	 * @param idRelacion
	 * @return numero de unidades de instalaci�n
	 */
	public int countUIsRelacion(String idRelacion);

	/**
	 * Cuenta el numero de unidades de instalacion de una relacion de entrega
	 * que cuyo estado de cotejo sea alguno de los solicitados. El conjunto de
	 * estados de cotejo puede ser nulo en cuyo caso se devuelve el numero total
	 * de unidades documentales de la relacion
	 * 
	 * @param idRelacion
	 *            Identificador de relacion de entrega
	 * @param estadoCotejo
	 *            Conjunto de estados de cotejo
	 * @return numero de unidades documentales
	 */
	public int countUinstConEstado(String idRelacion, int[] estadosCotejo);

	/**
	 * Obtiene una relaci�n de entrega a trav�s de su identificador
	 * 
	 * @param idRelacion
	 * @return Lista de {@link UnidadInstalacionReeaVO}
	 */
	public List fetchRowsByIdRelacion(String idRelacion);

	/**
	 * Obtiene una relaci�n de entrega a trav�s de su identificador
	 * 
	 * @param idRelacion
	 * @return Lista de {@link UnidadInstalacionReeaVO}
	 */
	public List fetchRowsByIdRelacion(String idRelacionEntrega,
			IntervalOptions ordenes);

	/**
	 * Actualiza el estado y flag de devoluci�n de un conjunto de unidades de
	 * instalaci�n.
	 * 
	 * @param idsUInstalacion
	 *            Lista de identificadores de unidad de instalacion
	 * @param estado
	 *            Nuevo estado al que se pasan la unidades de instalacion
	 * @param devuelta
	 *            Indica si las unidades de instalaci�n est�n devueltas.
	 */
	public void updateFieldEstado(String[] idsUInstalacion, int estado,
			boolean devuelta);

	/**
	 * Obtiene la unidad de instalaci�n correspondiente al id pasado por
	 * par�metro
	 * 
	 * @param idUinstalacion
	 * @return UnidadInstalacionReeaVO
	 */
	public UnidadInstalacionReeaVO fetchRowById(String idUinstalacion);

	/**
	 * Acutaliza una unidad de instalaci�n con los valores pasados por par�metro
	 * 
	 * @param idUInstalacion
	 * @param estado
	 * @param devolver
	 * @param notasCotejo
	 */
	public void updateFieldEstadoYDevolverYNotasCotejo(String idUInstalacion,
			int estado, String devolver, String notasCotejo);

	/**
	 * Permite eliminar las unidades de instalaci�n
	 * 
	 * @param idRelacion
	 *            Id de relaci�n de la que se quiere eliminar las unidades de
	 *            instalaci�n
	 */
	public void deleteXIdRelacion(final String idRelacion);

	/**
	 * Permite obtener la Unidad de instalaci�n entre archivos con la signatura
	 * indicada.
	 * 
	 * @param signatura
	 *            Signatura que se busca
	 * @return UnidadInstalacionReeaVO
	 */
	public UnidadInstalacionReeaVO fetchRowBySignatura(String signatura);

	/**
	 * Permite obtener una unidad de instalaci�n entre archivos a partir de su
	 * signatura y el id de archivo en la relaci�n de entrega
	 * 
	 * @param signatura
	 *            Signatura a Buscar
	 * @param idArchivo
	 *            Archivo de la unidad de instalaci�n a buscar
	 * @return UnidadInstalacionReeaVO
	 */
	public UnidadInstalacionReeaVO fetchRowBySignaturaYArchivo(
			String signatura, String idArchivo);

	/**
	 * Permite obtener una unidad de instalaci�n entre archivos a partir de su
	 * signatura y el id de archivo en la relaci�n de entrega en una relaci�n de
	 * entrega no validada
	 * 
	 * @param signatura
	 *            Signatura a Buscar
	 * @param idArchivo
	 *            Archivo de la unidad de instalaci�n a buscar
	 * @return UnidadInstalacionReeaVO
	 */
	public UnidadInstalacionReeaVO fetchRowBySignaturaYArchivoEnRENoValidada(
			String signatura, String idArchivo);

	/**
	 * Actualiza la Signatura de la Unidad de Instalaci�n
	 * 
	 * @param idUInstalacion
	 *            Identificador de la Unidad de Instalaci�n
	 * @param signatura
	 *            Signatura de la Unidad de Instalaci�n
	 */
	public void updateFieldSignatura(String idUInstalacion, String signatura);

	/**
	 * Actualiza el orden de la caja en la relaci�n
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n
	 * @param idUInstalacion
	 *            Identificador de la unidad documental
	 * @param orden
	 *            Orden de la caja
	 */
	public void updateFieldOrden(String idRelacion, String idUInstalacion,
			int orden);

	/**
	 * Devuelve el id del asignable padre de una unidad instalacion en relacion
	 * de entrega. Se utiliza para poder acceder despu�s a ese asignable y poder
	 * calcular la longitud ocupada por un hueco con formato irregular.
	 * 
	 * @param idRelacionEntrega
	 * @return idelemapadrehuecoorigen
	 */
	public String getIdAsignablePadreXRelacionEntrega(String idRelacionEntrega);

	/**
	 * Actualiza el path de las unidades de instalacion en la relaci�n entre
	 * archivos
	 * 
	 * @param idNoAsignable
	 * @param pathAntiguo
	 * @param pathNuevo
	 */
	public void updatePathUInstalacionReea(final String idNoAsignable,
			final String pathAntiguo, final String pathNuevo);

	public UnidadInstalacionReeaVO fetchRowBySignaturaYArchivoEnRENoValidadaOtraRelacion(
			String signatura, String idArchivoReceptor, String idRelacion);
}
