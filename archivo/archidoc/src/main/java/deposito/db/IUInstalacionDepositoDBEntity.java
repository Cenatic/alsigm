package deposito.db;

import java.util.List;
import java.util.Map;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;
import common.util.CustomDateRange;
import common.vos.ConsultaConnectBy;

import deposito.vos.UInsDepositoVO;
import fondos.vos.BusquedaElementosVO;
import fondos.vos.TablaTemporalFondosVO;

/**
 * Entidad: <b>ASGDUINSTALACION</b>
 * 
 * @author IECISA
 * 
 */
public interface IUInstalacionDepositoDBEntity extends IDBEntity {

	public UInsDepositoVO getUInstDepositoVOXIdEnDeposito(
			final String idUInstaEnDeposito);

	public abstract void insertUInstDepositoVO(
			final UInsDepositoVO uinsDepositoVO);

	/**
	 * Realiza el borrado de una unidad de instalacion por su identificador.
	 * 
	 * @param idUInstaEnDeposito
	 *            Identificador de la unidad.
	 */
	public abstract void deleteUInstDeposito(final String idUInstaEnDeposito);

	/**
	 * Actualiza la Marca de la unidad de Instalaci�n
	 */
	public void updateMarcaUnidadInstalacion(String id, int marcas);

	/**
	 * Actualiza los campos de la unidad de instalaci�n en el dep�sito
	 */
	public abstract void updateFieldsUInstDeposito(String idUInst,
			final Map columnsToUpdate);

	/**
	 * Actualiza los campos de la unidad de instalaci�n en el dep�sito que es
	 * necesario modificar durante la validaci�n
	 */
	public abstract void updateFieldsUInstDepositoVREA(UInsDepositoVO uInst);

	List getUnidsInstalacion(List listaIds,
			BusquedaElementosVO busquedaElementosVO);

	// List getIdsUnidsInstalacion(List listaAsignables,String like_sig, String
	// signatura,String idFondo,int numMaxResults) throws
	// TooManyResultsException;
	List getIdsUnidsInstalacion(String idUbicacion, String like_sig,
			String signatura, String idFondo, String idFormato,
			int numMaxResults, CustomDateRange rangoFechas)
			throws TooManyResultsException;

	List getIdsUnidsInstalacion(String idUbicacion, List idsCodsOrdenAmbitos,
			String like_sig, String signatura, String idFondo,
			String idFormato, int numMaxResults, CustomDateRange rangoFechas)
			throws TooManyResultsException;

	void updateIdentificacion(List idsElementosAMover, String codRefFondo);

	public void updateIdentificacionUnidadesInstalacion(String codRefFondo,
			TablaTemporalFondosVO tablaTemporalFondosVO);

	/**
	 * Realiza el borrado de las unidades de instalacion.
	 * 
	 * @param idsUIDeposito
	 *            Identificador de las unidades de instalacion.
	 */
	public void deleteUIsDeposito(final String[] idsUIDeposito);

	/**
	 * Obtiene el n�mero de unidades de instalaci�n para una determinada
	 * consulta
	 * 
	 * @param consultaConnectBy
	 * @return
	 */
	public int getCountUnidadesInstalacion(ConsultaConnectBy consultaConnectBy);
}