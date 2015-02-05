package transferencias.db;

import java.util.List;

import transferencias.vos.UDocElectronicaVO;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASGTUDOCSDF</b>
 * 
 * @author IECISA
 * 
 */
public interface IUdocElectronicaDBEntity extends IDBEntity {

	/**
	 * Comprueba si hay unidades documentales Electr�nicas con errores
	 * 
	 * @param idRelacion
	 *            Identificador de la Relaci�n
	 * @return true si existen unidades documental electr�nicas con Errores.
	 */
	public boolean checkUdocsElectronicasConErrores(final String idRelacion);

	/**
	 * Obtiene las Unidades Documentales Electr�nicas que tiene la relaci�n.
	 * 
	 * @param idRelacion
	 *            Identificador de la Relaci�n.
	 * @return Lista de Objetos {@link UDocElectronicaVO}
	 */
	public List fetchRowsByIdRelacion(final String idRelacion);

	/**
	 * Obtiene las Unidades Documentales Electr�nicas que tiene la relaci�n
	 * entre archivos.
	 * 
	 * @param idRelacion
	 *            Identificador de la Relaci�n.
	 * @return Lista de Objetos {@link UDocElectronicaVO}
	 */
	public List fetchRowsByIdRelacionEntreArchivos(final String idRelacion);

	/**
	 * Elimina todas las Unidades Documentales Electr�nicas de la Relaci�n de
	 * Entrega.
	 * 
	 * @param idRelacionEntrega
	 *            Identificador de la Relaci�n de Entrega.
	 */
	public void deleteXIdRelacion(final String idRelacionEntrega);

	/**
	 * Elimina la Unidad Documental Electr�nica
	 * 
	 * @param id
	 *            Identificador de la Unidad Documental.
	 */
	public void deleteXId(final String id);

	/**
	 * Elimina la Unidad Documental Electr�nica
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n de entrega
	 * @param ids
	 *            Identificadores de la Unidad Documental.
	 */
	public void deleteXIds(final String idRelacion, final String[] ids);

	/**
	 * A�ade una Unidad Documental
	 * 
	 * @param uDocElectronicaVO
	 *            Datos de la Unidad Electr�nica.
	 */
	public void insertRow(final UDocElectronicaVO uDocElectronicaVO);

	/**
	 * Actualiza el Campo Estado de Cotejo y notas de Cotejo
	 * 
	 * @param idUDocElectronica
	 *            Identificiador dela Unidad Documental Electr�nica
	 * @param estado
	 */
	public void updateFieldEstadoYNotas(String idUDocElectronica, int estado,
			String notas);

	/**
	 * Actualiza el Campo Estado de Cotejo y notas de Cotejo
	 * 
	 * @param idUDocElectronica
	 *            Identificiador dela Unidad Documental Electr�nica
	 * @param estado
	 */
	public void updateFieldEstado(String idRelacion,
			String[] idsUDocElectronica, int estado);

	/**
	 * Cuenta el numero de unidades documentales electr�nicas de una relacion de
	 * entrega que cuyo estado de cotejo sea alguno de los solicitados. El
	 * conjunto de estados de cotejo puede ser nulo en cuyo caso se devuelve el
	 * numero total de unidades documentales de la relacion
	 * 
	 * @param idRelacion
	 *            Identificador de relacion de entrega
	 * @param estadoCotejo
	 *            Conjunto de estados de cotejo
	 * @return numero de unidades documentales
	 */
	public int countUdocsElectronicasConEstado(String id, int[] estadoCotejo);

	/**
	 * Obtiene la unidad documental electr�nica por su id
	 * 
	 * @param id
	 *            Identificador de la unidad documental
	 * @return UDocElectronicaVO
	 */
	public UDocElectronicaVO fetchRowById(String id);

	/**
	 * Cuenta las unidades electr�nicas de la relaci�nd de entrega.
	 * 
	 * @param idRelacion
	 *            Idetificador del C�digo de Relaci�n
	 * @return N�mero de unidades electr�nicas de la relaci�n de entrega.
	 */
	public int countUdocsElectronicasByRelacion(String idRelacion);

	/**
	 * Actualiza la posicion de las unidades documentales electronicas
	 * pertenecientes a la relacion de entrega
	 * 
	 * @param idRelacionEntrega
	 * @param posicion
	 */
	public void incrementPosUdocSDF(String idRelacionEntrega, int posicion,
			int incremento);
}
