package fondos.db;

import java.util.Date;
import java.util.List;

import common.db.IDBEntity;

import fondos.vos.UDocEnFraccionSerieVO;

/**
 * M�todos de acceso a datos referentes a unidades documentales en divisiones de
 * fracciones de serie. Entidad: <b>ASGFUDOCENDIVISIONFS</b>
 */
public interface IUDocEnDivisionFSDbEntity extends IDBEntity {

	/**
	 * Recupera las unidades documentales en la divisi�n de fracci�n de serie
	 * cuyo identificador se pasa como par�metro
	 * 
	 * @param qual
	 *            Clausula <i>WHERE</i> de la consulta a ejecutar
	 * @return List de UDocEnFraccionSerie
	 */
	public List getUDocsEnDivisionFSVO(String idFS);

	/**
	 * Recupera el n�mero de unidades documentales en la divisi�n de fracci�n de
	 * serie cuyo identificador se pasa como par�metro
	 * 
	 * @param idFS
	 *            Cadena que identifica el identificador de la fracci�n de
	 *            serie.
	 * @return n�mero de unidades documentales de la fracci�n de serie.
	 */
	public int getCountUDocsEnDivisionFSVO(String idFS);

	/**
	 * Recupera la unidad documental en divisi�n de fracci�n de serie cuyo
	 * identificador es el que se suministra
	 * 
	 * @param idUDoc
	 *            Identificador de la unidad documental
	 * @return Datos de la unidad documental en divisi�n de fracci�n de serie
	 */
	public UDocEnFraccionSerieVO getUDocEnDivisionFSXId(final String idUDoc);

	/**
	 * Inserta una nueva unidad documental en divisi�n de fracci�n de serie en
	 * la base de datos
	 * 
	 * @param UDocEnFraccionSerieVO
	 *            Datos de la unidad documental en divisi�n de fracci�n de serie
	 *            a guardar
	 */
	public void insertUDocEnDivisionFS(
			final UDocEnFraccionSerieVO udocEnFraccionSerieVO);

	/**
	 * Actualiza los datos de la unidad documental en divisi�n de fracciones de
	 * serie que se indica por par�metro
	 * 
	 * @param udocEnFraccionSerieVO
	 *            Datos de la unidad documental en divisi�n de fracci�n de serie
	 *            a actualizar
	 */
	public void updateUDocEnDivisionFS(
			final UDocEnFraccionSerieVO udocEnFraccionSerieVO);

	/**
	 * Elimina la unidad documental en divisi�n de fracci�n de serie indicada de
	 * la tabla de unidades documentales en divisiones de fracci�n de serie
	 * 
	 * @param idUDoc
	 *            : identificador de la unidad documental en fracci�n de serie
	 */
	public void deleteUDocEnDivisionFS(String idUDoc);

	/**
	 * Elimina las unidades documentales en divisi�n de fracci�n de serie
	 * indicadas de la tabla de unidades documentales en divisiones de fracci�n
	 * de serie
	 * 
	 * @param idsUDoc
	 *            : identificadores de las unidad documentales en fracci�n de
	 *            serie a eliminar
	 */
	public void deleteUDocsEnDivisionFS(String[] idsUDoc);

	/**
	 * Elimina las unidades documentales en la divisi�n de fracci�n de serie
	 * indicada de la tabla de unidades documentales en divisiones de fracci�n
	 * de serie
	 * 
	 * @param idFS
	 *            : identificador de la fracci�n de serie
	 */
	public void deleteUDocsEnDivisionFS(String idFS);

	/**
	 * Actualiza el asunto de la unidad documental en divisi�n de fracciones de
	 * serie que se indica por par�metro
	 * 
	 * @param idUDoc
	 *            identificador de la unidad documental en divisi�n de fracci�n
	 *            de serie a actualizar
	 * @param asunto
	 *            nuevo asunto a establecer para la unidad documental en
	 *            divisi�n de fracci�n de serie
	 */
	public void updateAsunto(String idUDoc, String asunto);

	/**
	 * Actualiza el n�mero de expediente de la unidad documental en divisi�n de
	 * fracciones de serie que se indica por par�metro
	 * 
	 * @param idUDoc
	 *            identificador de la unidad documental en divisi�n de fracci�n
	 *            de serie a actualizar
	 * @param n�mero
	 *            de expediente nuevo n�mero de expediente a establecer para la
	 *            unidad documental en divisi�n de fracci�n de serie
	 */
	public void updateNumeroExpediente(String idUDoc, String numExp);

	/**
	 * Actualiza el campo info de la unidad documental en divisi�n de fracciones
	 * de serie que se indica por par�metro
	 * 
	 * @param idUDoc
	 *            identificador de la unidad documental en divisi�n de fracci�n
	 *            de serie a actualizar
	 * @param xmlInfo
	 *            nueva informaci�n para la unidad documental en divisi�n de
	 *            fracci�n de serie
	 */
	public void updateXmlInfo(String idUDoc, String xmlInfo);

	/**
	 * Actualiza el estado de validacion de las unidades documentales de una
	 * divisi�n de fracci�n de serie
	 * 
	 * @param idFS
	 *            Identificador de la divisi�n de fracci�n de serie
	 * @param validada
	 *            <b>true</b> en caso de que se quieran marcar las unidades
	 *            documentales como validadas y <b>false</b> para marcarlas como
	 *            no validadas
	 */
	public void setEstadoValidacion(String idFS, boolean validada);

	/**
	 * Actualiza la fecha extrema inicial de la unidad documental en divisi�n de
	 * fracci�n de serie como par�metro
	 * 
	 * @param idUdocFS
	 * @param fechaExtIni
	 */
	public void updateFechaExtIni(String idUdocFS, Date fechaExtIni);

	/**
	 * Actualiza la fecha extrema final de la unidad documental en divisi�n de
	 * fracci�n de serie como par�metro
	 * 
	 * @param idUdocFS
	 * @param fechaExtIni
	 */
	public void updateFechaExtFin(String idUdocFS, Date fechaExtFin);

	/**
	 * Obtiene la lista de rangos de una fracci�n de serie en divisi�n de
	 * fracci�n de serie
	 * 
	 * @param idUDoc
	 *            Identificador de la fracci�n de serie en la divisi�n de
	 *            fracci�n de serie
	 * @param idCampoInicial
	 *            Identificador del campo rango inicial
	 * @param idCampoFinal
	 *            Identificador del campo rango final
	 * @return Lista de rangos.
	 */
	public List getRangosUDoc(String idUDoc, String idCampoInicial,
			String idCampoFinal);

	/**
	 * Obtiene los Ids de las Unidades Documentales que contienen los
	 * descriptores seleccionados.
	 * 
	 * @param idsDescriptores
	 *            Identificadores de los descriptores a buscar
	 * @return Lista de {@link UDocEnFraccionSerieVO}
	 */
	public List getUdocsByInfoDescriptor(String[] idsDescriptores);

	/**
	 * Permite obtener el siguiente orden a uno pasado dentro de la division de
	 * fraccion de serie
	 * 
	 * @param idDivFs
	 *            Identificador de la division de fraccion de serie
	 * @param orden
	 *            Orden de la unidad documental en la division de fraccion de
	 *            serie
	 * @return orden del siguiente elemento en la division de fraccion de serie
	 */
	public int getNextOrdenUdocInDivisionFs(String idDivFs, int orden);

	/**
	 * Permite obtener el anterior orden a uno pasado dentro de la division de
	 * fraccion de serie
	 * 
	 * @param idDivFs
	 *            Identificador de la division de fraccion de serie
	 * @param orden
	 *            Orden de la unidad documental en la division de fraccion de
	 *            serie
	 * @return orden del anterior elemento en la division de fraccion de serie
	 */
	public int getPrevOrdenUdocInDivisionFs(String idDivFs, int orden);

	/**
	 * Permite obtener una unidad documental de una division de fraccion de
	 * serie
	 * 
	 * @param idDivFs
	 *            Identificador de la division de fraccion de serie
	 * @param orden
	 *            Orden de la unidad documental en la division de fraccion de
	 *            serie
	 * @return {@link UDocEnFraccionSerieVO}
	 */
	public UDocEnFraccionSerieVO getUdocInDivisionFsByOrden(String idDivFs,
			int orden);

}