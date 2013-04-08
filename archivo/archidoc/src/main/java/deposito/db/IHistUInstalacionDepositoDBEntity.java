package deposito.db;

import java.util.List;

import common.db.IDBEntity;

import deposito.vos.BusquedaHistUInstDepositoVO;
import deposito.vos.HistUInstDepositoVO;

/**
 * Entidad: <b>ASGDHISTUINSTALACION</b>
 * 
 * @author IECISA
 * 
 */
public interface IHistUInstalacionDepositoDBEntity extends IDBEntity {
	/**
	 * Inserta un registro en la tabla ASGDHISTUINSTALACION
	 * 
	 * @param histUInstDepositoVO
	 *            Datos de la Unidad de Instalaci�n Historica
	 */
	public void insert(HistUInstDepositoVO histUInstDepositoVO);

	/**
	 * Obtiene las Unidades de Instalaci�n filtrados por los campos del vo
	 * 
	 * @param histUInstDepositoVO
	 *            Filtros de la b�squeda de Unidad de Instalaci�n Historica
	 * @return Lista de {@link HistUInstDepositoVO}
	 */
	public List find(BusquedaHistUInstDepositoVO busquedaHistUInstDepositoVO);

	/**
	 * Obtiene la Unidad de Instalaci�n Instalaci�n por el Identificador
	 * 
	 * @param id
	 *            Identificador de la Unidad de Instalaci�n Hist�rica
	 * @return Unidad de Instalacion Hist�rica
	 */
	public HistUInstDepositoVO getById(String id);
}
