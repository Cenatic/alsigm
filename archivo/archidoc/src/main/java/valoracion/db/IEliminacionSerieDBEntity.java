package valoracion.db;

import java.util.Date;
import java.util.List;

import valoracion.vos.BusquedaVO;
import valoracion.vos.EliminacionSerieVO;
import valoracion.vos.UnidadDocumentalEliminacionVO;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;
import common.pagination.PageInfo;

import fondos.vos.TablaTemporalFondosVO;

/**
 * Interface para la tabla de eliminaciones de serie. <br>
 * Entidad: <b>ASGFELIMSERIE</b>
 */
public interface IEliminacionSerieDBEntity extends IDBEntity {
	/**
	 * Obtiene las eliminaciones que cumplen los filtros de busqueda
	 * 
	 * @param busqueda
	 *            Objeto que contiene los elementos del formulario de b�squeda.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public List getEliminaciones(BusquedaVO busqueda)
			throws TooManyResultsException;

	/**
	 * Obtiene las eliminaciones de un gestor que se encuentren en alguno de los
	 * estados indicados
	 * 
	 * @param idGestor
	 *            Identificador del usuario gestor de las eliminaciones. Puede
	 *            ser nulo
	 * @param estado
	 *            Conjunto de estados de eliminaci�n. Puede ser nulo
	 * @return Listado de las eliminaciones {@link EliminacionSerieVO}
	 */
	public abstract List getEliminacionesXGestor(String idGestor, int[] estados);

	/**
	 * Obtiene el n�mero de eliminaciones que se encuentren en alguno de los
	 * estados indicados
	 * 
	 * @param estado
	 *            Conjunto de estados de eliminaci�n. Puede ser nulo
	 * @return N�mero de eliminaciones
	 */
	public int getCountEliminacionesXEstado(int[] estado, String[] idsArchivo);

	/**
	 * Obtiene las eliminaciones que se encuentren en alguno de los estados
	 * indicados
	 * 
	 * @param estado
	 *            Conjunto de estados de eliminaci�n. Puede ser nulo
	 * @return Listado de las eliminaciones {@link EliminacionSerieVO}
	 */
	public List getEliminacionesXEstado(int[] estado, String[] idsArchivo);

	/**
	 * Inserta una eliminacion en la base de datos .
	 * 
	 * @param eliminacion
	 *            Eliminacion que se desea insertar
	 */
	public abstract void insertEliminacion(final EliminacionSerieVO eliminacion);

	/**
	 * Realiza la actualizaci�n de la eliminacion dada en la base de datos
	 * 
	 * @param eliminacion
	 *            Eliminaci�n que deseamos actualizar
	 */
	public abstract void updateEliminacion(EliminacionSerieVO eliminacion);

	/**
	 * Obtiene un listado de las eliminacion de una valoracion dada por su
	 * identificador y cuyo estado de eliminacion se encuentra en unos de los
	 * pasados, o todas las eliminaciones en caso de no venir definidos los
	 * estados.
	 * 
	 * @param codigoValoracion
	 *            Valoracion de la que deseamos obtener las eliminaciones.
	 * @param estados
	 *            Listado de los estado que deben tener las eliminacion o null
	 *            si deseamos obtener todas
	 * @return Listado de eliminaciones de la valoracion
	 */
	public abstract List getEliminaciones(String codigoValoracion, int[] estados);

	/**
	 * Obtiene una eliminacion de una valoraci�n a partir de su identificador en
	 * la base de datos.
	 * 
	 * @param codigo
	 *            Identificador de la eliminacion en la base de datos
	 * @return Objeto {@link EliminacionSerieVO} con los detalles de la
	 *         eliminacion.
	 */
	public abstract EliminacionSerieVO getEliminacion(String codigo);

	/**
	 * Obtiene un listado de las eliminaciones dadas por su identificador de bd.
	 * 
	 * @param ids
	 *            Lsitado de identificadores de las eliminaciones que deseamos
	 *            recuperar.
	 * @return Eliminaciones deseadas
	 */
	public abstract List getEliminaciones(String[] ids);

	/**
	 * Realiza el borrado de una eliminaci�n dada por su identificador.
	 * 
	 * @param idPrestamo
	 *            Identificador de la eliminaci�n.
	 */
	public abstract void deleteEliminacion(String id);

	public String[] getIDsUdocsAConservar(EliminacionSerieVO seleccion,
			String subqueryIdsUdocConservar);

	public String[] getIDsUdocsAEliminar(EliminacionSerieVO seleccion,
			String subqueryIdsUdocConservar);

	public String getSubConsultaIDsUdocsAEliminar(EliminacionSerieVO seleccion,
			String subqueryIdsUdocConservar);

	public String[] getIDsUdocsRelAEliminar(EliminacionSerieVO seleccion,
			String subqueryIdsUdocConservar);

	public List getListaUdocsAEliminar(EliminacionSerieVO seleccion,
			String idArchivo, String subqueryIdsUdocConservar, PageInfo pageInfo);

	public List getListaIdsUdocsAEliminar(EliminacionSerieVO seleccion,
			String idArchivo, String subqueryIdsUdocConservar);

	public List getListaUdocsAConservar(EliminacionSerieVO seleccion,
			String idArchivo, String subqueryIdsUdocConservar, PageInfo pageInfo)
			throws TooManyResultsException;

	/**
	 * Permite obtener las unidades documentales relacionadas a las que se
	 * eliminan en la selecci�n
	 * 
	 * @param seleccion
	 *            Selecci�n de unidades documentales
	 * @param subqueryIdsUdocConservar
	 *            Subquery de las unidades documentales a conservar en la
	 *            eliminaci�n
	 * @param pageInfo
	 *            Informaci�n de paginaci�n
	 * @return Lista de unidades documentales
	 *         {@link UnidadDocumentalEliminacionVO}
	 * @throws TooManyResultsException
	 */
	public List getListaUdocsRelAEliminar(EliminacionSerieVO seleccion,
			String subqueryIdsUdocConservar, PageInfo pageInfo)
			throws TooManyResultsException;

	/**
	 * Obtiene las unidades documentales seleccionables de una serie.
	 * 
	 * @param idSerie
	 *            Identificador de la serie.
	 * @param fechaEjecucion
	 *            Fecha de ejecuci�n de la selecci�n.
	 * @param anosVigencia
	 *            A�os de vigencia.
	 * @param xmlCondicionesConservacion
	 *            Condiciones de conservaci�n.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Lista de unidades documentales (
	 *         {@link UnidadDocumentalEliminacionVO}).
	 * @throws TooManyResultsException
	 *             si se excede el n�mero m�ximo de resultados.
	 */
	public List getListaUdocsSeleccionables(String idSerie,
			Date fechaEjecucion, int anosVigencia,
			String xmlCondicionesConservacion, PageInfo pageInfo)
			throws TooManyResultsException;

	// public List getUnidadesAEliminar(String idSerie, Date fechaEjecucion, int
	// anosVigencia,
	// String xmlCondicionesConservacion, PageInfo pageInfo);
	//
	// public List getUnidadesAConservar(String idSerie, Date fechaEjecucion,
	// int anosVigencia,
	// String xmlCondicionesConservacion);

	// public List getUnidadesEliminacion(String idSerie, Date fechaEjecucion,
	// int anosVigencia,
	// String xmlCondicionesConservacion, PageInfo pageInfo);
	/**
	 * Recupera las eliminaciones existentes sobre una serie que se encuentran
	 * en alguno de los estados indicados
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @param estadosEliminacion
	 *            Conjundo de posibles estados de eliminaci�n. Puede ser nulo
	 * @return Lista de eliminaciones {@link EliminacionSerieVO}
	 */
	public List getEliminacionesSerie(String idSerie, int[] estadosEliminacion);

	/**
	 * Actualiza el valor del campo estado
	 * 
	 * @param idEliminacion
	 *            Identificador de eliminaci�n
	 * @param estado
	 *            Valor a establacer en el campo estado
	 */
	public void updateEstado(String idEliminacion, int estado);

	/**
	 * Obtiene el n�mero de eliminaciones que contienen las unidades
	 * documentales que est�n en la tabla temporal, ya sea como a conservar como
	 * para eliminar
	 * 
	 * @param tablaTemporalUDocs
	 *            Tabla temporal de unidades documentales
	 * @param estadosExcluir
	 *            Estados de las eliminaciones que se excluir�n
	 * @return
	 */
	public int getCountEliminacionesConUdocsSeleccionadas(
			TablaTemporalFondosVO tablaTemporalUDocs, int[] estadosExcluir);
}