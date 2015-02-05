package transferencias.db;

import java.util.List;

import transferencias.vos.MapDescUDocVO;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASGTMAPDESCRUDOC</b>
 *
 * @author IECISA
 *
 */
public interface IMapDescUDocDBEntity extends IDBEntity {

	/**
	 * Obtiene la informaci�n de una ficha.
	 *
	 * @param id
	 *            Identificador de la ficha.
	 * @return Informaci�n de mapeo de las udocs en transferencia a sus campos
	 *         descriptivos
	 */
	public MapDescUDocVO getMapDescUDoc(String idFicha);

	/**
	 * Obtiene la lista de de mapeos de las udocs en transferencias a su
	 * descripci�n
	 *
	 * @return una lista de mapeos de las udocs en transferencias a su
	 *         descripci�n
	 */
	public List getMapsDescUDoc();


	/**
	 * Inserta el mapeo en la tabla
	 * @param mapDescUDocVO Datos del mapeo
	 */
	public void insert(MapDescUDocVO mapDescUDocVO);

	/**
	 * Elimina un mapeo asociado a una ficha
	 * @param idsFichas
	 */
	public void delete(String[] idsFichas);

	/**
	 * Actualiza un mapeo asociado a una ficha
	 * @param mapDescUDocVO
	 */
	public void update(MapDescUDocVO mapDescUDocVO) ;

}
