package se.tramites;

import java.util.Date;
import java.util.List;

import se.NotAvailableException;
import se.Parametrizable;
import se.tramites.exceptions.SistemaTramitadorException;

/**
 * Interfaz para los Sistemas Tramitadores.
 */
public interface SistemaTramitador extends Parametrizable {
	public static final int ORDER_BY_NUM_EXP = 1;
	public static final int ORDER_BY_END_DATE = 2;

	/**
	 * Recupera los identificadores de los expedientes, del procedimiento
	 * identificado por idProc, que hayan finalizado en el rango de fechas
	 * comprendido entre fechaIni y fechaFin ordenados por lo que indique el
	 * par�metro tipoOrd.
	 * 
	 * @param idProc
	 *            Identificador del procedimiento.
	 * @param fechaIni
	 *            Fecha de inicio.
	 * @param fechaFin
	 *            Fecha de fin.
	 * @param tipoOrd
	 *            Tipo de ordenaci�n.
	 *            <p>
	 *            Valores posibles:
	 *            <li>1 - N�mero de expediente</li>
	 *            <li>2 - Fecha finalizaci�n</li>
	 *            </p>
	 * @return Lista de identificadores de expedientes.
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarIdsExpedientes(String idProc, Date fechaIni,
			Date fechaFin, int tipoOrd) throws SistemaTramitadorException,
			NotAvailableException;

	/**
	 * Recupera la lista de expedientes cuyos identificadores se incluyen en el
	 * par�metro idExps.
	 * 
	 * @param idExps
	 *            Identificadores de expedientes.
	 * @return Lista de expedientes.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoBExpediente}.
	 *         </p>
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarInfoBExpedientes(String[] idExps)
			throws SistemaTramitadorException, NotAvailableException;

	/**
	 * Recupera la informaci�n de un expediente cuyo identificador �nico es
	 * idExp.
	 * 
	 * @param idExp
	 *            Identificador del expediente.
	 * @return Informaci�n de un expediente.
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public Expediente recuperarExpediente(String idExp)
			throws SistemaTramitadorException, NotAvailableException;

	/**
	 * Modifica el estado de los expedientes recibidos como par�metro a estado
	 * archivado
	 * 
	 * @param idExps
	 *            Array de String con los expedientes que se quieren pasar al
	 *            estado archivado
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public void archivarExpedientes(String[] idExps)
			throws SistemaTramitadorException, NotAvailableException;
}
