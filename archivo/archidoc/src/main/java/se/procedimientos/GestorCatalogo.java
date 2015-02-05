package se.procedimientos;

import java.util.List;

import se.NotAvailableException;
import se.Parametrizable;
import se.procedimientos.exceptions.GestorCatalogoException;

/**
 * Interfaz para los conectores con el Sistemas Gestor del Cat�logo.
 */
public interface GestorCatalogo extends Parametrizable {

	/**
	 * Recupera la lista de procedimientos del tipo que se indica en tipoProc,
	 * con su informaci�n b�sica.
	 *
	 * @param tipoProc
	 *            Tipo de procedimiento.
	 *            <p>
	 *            Valores posibles de tipoProc:
	 *            <li>1 - Todos</li>
	 *            <li>2 - Procedimientos automatizados</li>
	 *            <li>3 - Procedimientos no automatizados</li>
	 *            </p>
	 * @param nombre
	 *            Nombre del procedimiento.
	 * @return Lista de informaci�n de procedimientos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoBProcedimiento}.
	 *         </p>
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarInfoBProcedimientos(int tipoProc, String nombre)
			throws GestorCatalogoException, NotAvailableException;

	/**
	 * Recupera la lista de procedimientos cuyos identificadores se incluyen en
	 * el par�metro idProcs.
	 *
	 * @param idProcs
	 *            Lista de identificadores de procedimientos.
	 * @return Lista de informaci�n de procedimientos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoBProcedimiento}.
	 *         </p>
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarInfoBProcedimientos(String[] idProcs)
			throws GestorCatalogoException, NotAvailableException;

	/**
	 * Recupera la informaci�n de un procedimiento cuyo identificador �nico es
	 * idProc.
	 *
	 * @param idProc
	 *            Identificador de procedimiento.
	 * @return Informaci�n del procedimiento.
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public IProcedimiento recuperarProcedimiento(String idProc)
			throws GestorCatalogoException, NotAvailableException;
}
