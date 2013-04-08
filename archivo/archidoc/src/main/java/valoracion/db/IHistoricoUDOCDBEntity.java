package valoracion.db;

import java.util.List;

import valoracion.vos.HistoricoUDOCVO;

import common.db.IDBEntity;

/**
 * Interface para la tabla de historicos de udoc <br>
 * Entidad: <b>ASGFHISTUDOC</b>
 */
public interface IHistoricoUDOCDBEntity extends IDBEntity {
	/**
	 * Inserta un historico de unidad documental en la base de datos.
	 * 
	 * @param historico
	 *            Historico a insertar.
	 */
	public void insertHistoricoUdoc(final HistoricoUDOCVO historico);

	/**
	 * Obtiene la lista de unidades documentales en hist�rico procesadas en una
	 * eliminaci�n.
	 * 
	 * @param idEliminacion
	 *            Identificador de la eliminaci�n.
	 * @return Lista de unidades documentales ({@link HistoricoUDOCVO}).
	 */
	public List getUdocsByIdEliminacion(String idEliminacion);
}