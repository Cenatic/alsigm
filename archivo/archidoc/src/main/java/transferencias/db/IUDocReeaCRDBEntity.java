/**
 *
 */
package transferencias.db;

import transferencias.vos.UDocReeaCRVO;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASGTUDOCREEACR</b>
 * 
 * @author IECISA
 * 
 */
public interface IUDocReeaCRDBEntity extends IDBEntity {

	/**
	 * Inserta el registro en la tabla
	 * 
	 * @param udocReeaCRVO
	 */
	public void insert(UDocReeaCRVO udocReeaCRVO);

	/**
	 * Elimina los registros de una relaci�n de entrega
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 */
	public void deleteByIdRelacion(String idRelEntrega);

	/**
	 * Elimina el contenido de una unidad de instalaci�n en dep�sito
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idUIDeposito
	 *            Identificador de la Unidad de Instalaci�n en Dep�sito
	 */
	public void deleteByIdUIDeposito(String idRelEntrega, String idUIDeposito);

	/**
	 * Obtiene el registro por su id
	 * 
	 * @param id
	 *            Identificador de la Unidad Documental
	 * @return {@link UDocReeaCRVO}
	 */
	public UDocReeaCRVO fetchRow(String id);

	/**
	 * Elimina el contenido de las unidades de instalaci�n en deposito
	 * 
	 * @param idRelEntrega
	 *            Identificador de la relaci�n
	 * @param idsUIDeposito
	 *            Identificadores de las unidades de instalaci�n en deposito
	 */
	public void deleteByIdsUIDeposito(String idRelEntrega,
			String[] idsUIDeposito);
}
