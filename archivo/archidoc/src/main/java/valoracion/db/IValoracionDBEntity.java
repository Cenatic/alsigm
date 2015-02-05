package valoracion.db;

import java.util.List;

import valoracion.vos.BusquedaVO;
import valoracion.vos.SerieSeleccionableVO;
import valoracion.vos.ValoracionSerieVO;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;
import common.pagination.PageInfo;

/**
 * Interface con los metodos de acceso a bd para la tabla de
 * Valoracion(ASGFVALSERIE)
 */
public interface IValoracionDBEntity extends IDBEntity {
	/**
	 * Obtiene las valoraciones que cumplen los filtros de busqueda
	 * 
	 * @param busqueda
	 *            Objeto que contiene los elementos del formulario de b�squeda.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public List getValoraciones(BusquedaVO busqueda)
			throws TooManyResultsException;

	/**
	 * Obtiene el n�mero de valoraciones de serie cuyo usuario gestor(de la
	 * series) sea el dado por el identificador pasado.
	 * 
	 * @param idGestor
	 *            Identificador del gestor de la serie
	 * @param estados
	 *            Conjunto de estados de valoraci�n de serie. Puede ser null.
	 * @return N�mero de valoraciones.
	 */
	public int getCountValoracionesXGestor(String idGestor, int[] estados);

	/**
	 * Obtiene un listado de las valoraciones de serie cuyo usuario gestor(de la
	 * series) sea el dado por el identificador pasado.
	 * 
	 * @param idGestor
	 *            Identificador del gestor de la serie
	 * @param estados
	 *            Conjunto de estados de valoraci�n de serie. Puede ser null.
	 * @return Listado de {@link ValoracionSerieVO} con los detalles de la
	 *         valoraci�n.
	 */
	public abstract List getValoracionesXGestor(String idGestor, int[] estados);

	/**
	 * Obtiene una valoraci�n de una serie a partir de su identificador en la
	 * base de datos.
	 * 
	 * @param codigo
	 *            Identificador de la valoraci�n en la base de datos
	 * @return Objeto {@link ValoracionSerieVO} con los detalles de la
	 *         valoraci�n.
	 */
	public abstract ValoracionSerieVO getValoracion(String codigo);

	/**
	 * Obtiene un listado de las valoraciones de una serie dada por su
	 * identificador y cuyo estado de valoracion se encuentra en unos de los
	 * pasados, o todas las valoraciones de la series en caso de no venir
	 * definidos los estados.
	 * 
	 * @param codigoSerie
	 *            Serie de la que deseamos obtener las valoraciones. Puede ser
	 *            null.
	 * @param estados
	 *            Listado de los estado que deben tener las valoraciones o null
	 *            si deseamos obtener todas
	 * @return Listado de valoraciones de la serie
	 */
	public List getValoracionesSerie(String codigoSerie, int[] estados);

	/**
	 * Obtiene los identificadores de las valoraciones de una serie cuyo estado
	 * de valoracion es alguno de los que se indican
	 * 
	 * @param idSerie
	 *            Identificador de serie documental. Puede ser null.
	 * @param estados
	 *            Conjunto de posibles estados de valoraci�on
	 * @return Lista con los identificadores de las valoraciones que verifican
	 *         los criterios suministrados
	 */
	// TODO SUSTITUIR POR API DE CONSULTA
	public List getIDsValoracionSerie(String id, int[] estadosValoracion);

	/**
	 * Obtiene un listado de las valoraciones dadas por su identificador de bd.
	 * 
	 * @param ids
	 *            Lsitado de identificadores de las valoraciones que deseamos
	 *            recuperar.
	 * @return Valoraciones deseadas
	 */
	public abstract List getValoraciones(String[] ids);

	/**
	 * Realiza la actualizaci�n de la valoracion dada en la base de datos
	 * 
	 * @param valoracion
	 *            Valoraci�n que deseamos actualizar
	 */
	public abstract void updateValoracionSerie(ValoracionSerieVO valoracion);

	/**
	 * Inserta una valoracion en la base de datos creado por el usuario del
	 * servicio.
	 * 
	 * @param valoracion
	 *            Valoracion insertar en la base de datos.
	 */
	public abstract void insertValoracion(final ValoracionSerieVO valoracion);

	/**
	 * Realiza el borrado de una valoracion dado por su identificador.
	 * 
	 * @param idPrestamo
	 *            Identificador de la valoracion.
	 */
	public abstract void deleteValoracion(String id);

	/**
	 * Actualiza el gestor de un conjunto de valoraciones
	 * 
	 * @param valoraciones
	 *            Conjunto de identificadores de valoracion
	 * @param idGestor
	 *            Identificador de usuario
	 */
	public void updateGestorValoracion(String[] valoraciones, String idGestor);

	/**
	 * Obtiene las series con un n�mero m�nimo de unidades documentales
	 * seleccionables.
	 * 
	 * @param idFondo
	 *            Identificador del fondo.
	 * @param minNumUdocs
	 *            N�mero m�nimo de unidades documentales.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Series seleccionables ({@link SerieSeleccionableVO}).
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getSeriesSeleccionables(String idFondo, int minNumUdocs,
			PageInfo pageInfo) throws TooManyResultsException;

	/**
	 * Recupera la valoraci�n m�s reciente de una serie de entre las que se
	 * encuentran en alguno de los estados que se indican
	 * 
	 * @param idSerie
	 *            Identificador de serie documental
	 * @param estados
	 *            Conjunto de posibles estados de valoraci�n
	 * @return Datos de valoraci�n
	 */
	public ValoracionSerieVO getValoracionMasReciente(String idSerie,
			int[] estados);

	/**
	 * Recupera el numero de valoraciones de una serie que se encuentran en
	 * alguno de los estados que se indican
	 * 
	 * @param idSerie
	 *            Identificador de serie documental
	 * @param estados
	 *            Conjunto de posibles estados de valoraci�n
	 * @return N�mero de valoraciones que satisfacen los criterios indicados
	 */
	public int getNumValoraciones(String idSerie, int[] estados);

	/**
	 * Obtiene el n�mero valoraciones que se encuentran en alguno de los estados
	 * que se indican
	 * 
	 * @param estados
	 *            Conjunto de posibles estados de valoraci�n
	 * @return N�mero de valoraciones
	 */
	public int getCountValoraciones(int[] estados);

	/**
	 * Obtiene las valoraciones que se encuentran en alguno de los estados que
	 * se indican
	 * 
	 * @param estados
	 *            Conjunto de posibles estados de valoraci�n
	 * @return Lista de valoraciones {@link ValoracionSerieVO }
	 */
	public List getValoraciones(int[] estados);

}