package fondos.db;

import java.util.List;

import common.db.IDBEntity;
import common.util.CustomDateRange;

import fondos.vos.FondoVO;

/**
 * M�todos de acceso a datos referentes a fondos documentales. <br>
 * Entidad: <b>ASGFFONDO</b>
 */
public interface IFondoDbEntity extends IDBEntity {

	public List getFondosXEntidadProductora(String idEntidadProductora,
			String codArchivo);

	public List getFondosXEntidadProductoraExcludeFondo(
			String idEntidadProductora, String idFondo);

	/**
	 * Recupera los fondos que se encuentran en alguno de los estados indicados
	 * 
	 * @param estados
	 *            Conjunto de estados de fondo
	 * @return Lista de fondos {@link FondoVO}
	 */
	public List getFondosXEstados(int[] estados);

	/**
	 * Recupera todos los fondos que contiene el cuadro de clasificaci�n de
	 * fondos documentales
	 * 
	 * @return Lista de fondos {@link FondoVO}
	 */
	public List getFondos();

	/**
	 * Recupera el fondo que tiene el identificador que se suministra
	 * 
	 * @param idFondo
	 *            Identificador de fondo
	 * @return Datos del fondo
	 */
	public FondoVO getFondoXId(String idFondo);

	/**
	 * Inserta un nuevo fondo en la tabla de fondos
	 * 
	 * @param fondoVO
	 *            Datos del fondo a guardar
	 * @return Datos del fondo insertado
	 */
	public FondoVO insertFondo(FondoVO fondo);

	/**
	 * Actualiza los datos del fondo que se suministra en la tabla de fondos
	 * 
	 * @param fondo
	 *            Datos del fondo a actualizar
	 */
	public void updateFondo(FondoVO fondo);

	/**
	 * Elimina el fondo indicado de la tabla de fondos
	 * 
	 * @param idFondo
	 */
	public void deleteFondo(String idFondo);

	/**
	 * Obtiene el n�mero de referencias a una entidad productora.
	 * 
	 * @param idEntProductora
	 *            Identificador de la entidad productora.
	 * @return N�mero de referencias.
	 */
	public int countReferencesEntProd(String idEntProductora);

	/**
	 * Obtiene el n�mero de referencias a entidades productoras de una lista
	 * descriptora.
	 * 
	 * @param idListaDescriptora
	 *            Identificador de la lista descriptora.
	 * @return N�mero de referencias.
	 */
	public int countReferencesEntProdInList(String idListaDescriptora);

	/**
	 * Obtener el fondo de una valoraci�n de serie.
	 * 
	 * @param idValoracion
	 *            Identificador de la valoraci�n de serie.
	 * @return Fondo.
	 */
	public FondoVO getFondoXIdValoracion(String idValoracion);

	/**
	 * Obtiene las fechas extremas de un fondo.
	 * 
	 * @param idFondo
	 *            Identificador del fondo.
	 * @return Fechas extremas.
	 */
	public CustomDateRange getFechasExtremas(String idFondo);

	/**
	 * Obtiene la lista de vol�menes de las series de un fondo.
	 * 
	 * @param idFondo
	 *            Identificador de un fondo.
	 * @return Lista de vol�menes de las series de un fondo.
	 */
	public List getVolumenesSeriesFondo(String idFondo);

	/**
	 * Obtiene los Fondos que pertencen a un archivo pas�ndole el c�digo
	 * 
	 * @param codArchivo
	 *            C�digo de Archivo
	 * @return Lista de Fondos de archivo
	 */
	public List getFondosXCodArchivo(String codArchivo);

	/**
	 * Actualiza la entidad productora al realizarse la unificaci�nn de
	 * descriptores.
	 * 
	 * @param idDescriptor
	 * @param idsAReemplazar
	 */
	public void unificarDescriptor(String idDescriptor, String[] idsAReemplazar);

	/**
	 * Obtiene el fondo Asociado a una entidad productora y un archivo
	 * 
	 * @param codArchivo
	 *            C�digo de Archivo
	 * @param idEntidadProductora
	 *            Identificador de la Entidad Productora
	 * @return Fondo asociado al a entidad productora y archivo.
	 */
	public FondoVO getFondosXCodArchivoYEntidadProductora(String codArchivo,
			String idEntidadProductora);
}