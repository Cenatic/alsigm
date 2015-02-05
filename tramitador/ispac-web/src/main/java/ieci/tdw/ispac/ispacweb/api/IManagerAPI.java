/*
 * Created on 16-feb-2005
 *
 */
package ieci.tdw.ispac.ispacweb.api;

import ieci.tdw.ispac.api.errors.ISPACException;

import java.util.Map;

/**
 * @author juanin
 *
 * Gestiona los estados de tramitaci�n y proporciona acceso al resto de interfaces.
 * Todos los interfaces de tramitaci�n incluido IManagerAPI intentan obtener toda la
 * informaci�n posible a partir del estado {@link ieci.tdw.ispac.ispacweb.api.IState}
 * en que se encuentre.
 *
 */
public interface IManagerAPI
{
	/**
	 * Obtiene el esquema de tramitaci�n de un expediente.
	 * @return IScheme el esquema
	 */
	public abstract IScheme getSchemeAPI();

	/**
	 * Obtiene las posibles acciones a realizar en la tramitaci�n de un expediente.
	 * @return Actions Acciones a realizar
	 */
	public IActions getActionsAPI();


	/**
	 * Obtiene la lista de trabajo dependiendo del estado de tramitaci�n.
	 * @return IScheme el esquema
	 */
	public IWorklist getWorklistAPI();

	/**
	 * Transiciona a un nuevo estado de tramitaci�n.
	 * @param stateticket ticket del estado actual
	 * @param newstateID identificador del nuevo estado
	 * @param params par�metros necesarios para la creaci�n del estado
	 * @return IState
	 * @throws ISPACException
	 */
	public IState enterState(String stateticket, int newstateID, Map params) throws ISPACException;

	/**
	 * Transiciona a un nuevo estado de tramitaci�n.
	 * @param stateticket ticket del estado actual
	 * @param newstateID identificador del nuevo estado
	 * @param params par�metros necesarios para la creaci�n del estado
	 * @return IState
	 * @throws ISPACException
	 */
	//public IState enterState(IState currentState, int newstateID, Map params) throws ISPACException;

	/**
	 * Obtiene el estado en el que se encuentra la tramitaci�n.
	 * @param stateticket ticket del estado
	 * @return IState
	 * @throws ISPACException
	 */
	public IState currentState(String stateticket) throws ISPACException;

	/**
	 * Crea un nuevo estado de tramitaci�n pero no entra en el mismo ya que no llama al m�todo
	 * IState.enter()
	 * @param stateticket ticket del estado actual
	 * @param newstateID identificador del nuevo estado
	 * @param params par�metros necesarios para la creaci�n del estado
	 * @return IState
	 * @throws ISPACException
	 */
	public IState newState(int newstateID, Map params) throws ISPACException;

}