package valoracion.db;

import java.util.List;

import valoracion.vos.IUnidadDocumentalEliminacionVO;

import common.db.IDBEntity;

/**
 * Interface para la tabla de eliminaciones de serie. <br>
 * Entidad: <b>ASGFELIMSELUDOC</b>
 */
public interface IEliminacionUDOCEliminadaDBEntity extends IDBEntity {
	/**
	 * Obtiene las unidades documentales a conservar de una eliminaci�n
	 * 
	 * @param idEliminacion
	 *            Id de la eliminaci�n de la que se quieren obtener las unidades
	 *            documentales.
	 * @return Lista {@link IUnidadDocumentalEliminacionVO}
	 */
	public List getUdocsAEliminarXId(String idEliminacion);

	/**
	 * Permite insertar una unidad documental a conservar en una eliminaci�n
	 * 
	 * @param eliminacionUDocVO
	 *            Unidad documental a conservar
	 */
	public void insertUdocAEliminar(
			IUnidadDocumentalEliminacionVO unidadDocumentalEliminacionVO);

	/**
	 * Obtiene el numero de unidades de instalaci�n afectadas en una eliminaci�n
	 * 
	 * @param idEliminacion
	 *            Cadena que contiene el identificador de la eliminacion
	 * @return Entero
	 */
	public int getCountNumeroUinstalacion(String idEliminacion);

}