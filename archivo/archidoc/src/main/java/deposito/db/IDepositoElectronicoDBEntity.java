package deposito.db;

import java.util.List;

import common.db.IDBEntity;

import deposito.vos.DepositoElectronicoVO;

/**
 * Interfaz para el acceso a los dep�sitos electr�nicos. <br>
 * Entidad: <b>ASGDDEPOSITOELECTRONICO</b>
 */
public interface IDepositoElectronicoDBEntity extends IDBEntity {
	/**
	 * Obtiene la lista de dep�sitos electr�nicos.
	 * 
	 * @return Lista de dep�sitos electr�nicos ({@link DepositoElectronicoVO}).
	 */
	public List getDepositosElectronicos();

	/**
	 * Obtiene la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param id
	 *            Identificador del dep�sito electr�nico.
	 * @return Dep�sito electr�nico.
	 */
	public DepositoElectronicoVO getDepositoElectronico(String id);

	/**
	 * Obtiene la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param idExt
	 *            Identificador externo del dep�sito electr�nico.
	 * @return Dep�sito electr�nico.
	 */
	public DepositoElectronicoVO getDepositoElectronicoByIdExt(String idExt);

	/**
	 * Crea un dep�sito electr�nico.
	 * 
	 * @param deposito
	 *            Informaci�n del dep�sito electr�nico.
	 * @return Dep�sito electr�nico creado.
	 */
	public DepositoElectronicoVO insertDepositoElectronico(
			DepositoElectronicoVO deposito);

	/**
	 * Modifica la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param deposito
	 *            Informaci�n del dep�sito electr�nico.
	 */
	public void updateDepositoElectronico(DepositoElectronicoVO deposito);

	/**
	 * Elimina un dep�sito.
	 * 
	 * @param id
	 *            Identificador del dep�sito.
	 */
	public void deleteDepositoElectronico(String id);
}