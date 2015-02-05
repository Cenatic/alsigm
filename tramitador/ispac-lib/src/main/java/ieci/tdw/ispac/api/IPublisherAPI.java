package ieci.tdw.ispac.api;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;

public interface IPublisherAPI {

    /**
     * Valor que representa el estado de una applicaci�n inactiva
     */
    public final static int APPLICATION_STATUS_INACTIVE	= 0;
    /**
     * Valor que representa el estado de una applicaci�n activa
     */
    public final static int APPLICATION_STATUS_ACTIVE  	= 1;

    
    /**
     * Valor que representa el estado inicial de un hito
     */
    public final static int MILESTONE_STATUS_INITIAL   	= 0;
    /**
     * Valor que representa el estado bloqueado de un hito
     */
    public final static int MILESTONE_STATUS_LOCKED 	= 1; 
    /**
     * Valor que representa el estado correcto de un hito
     */
    public final static int MILESTONE_STATUS_OK		  	= 2;
    /**
     * Valor que representa el estado error de un hito
     */
    public final static int MILESTONE_STATUS_ERROR		= 3;    

    
    
	/*
	 * 
	 * M�todos para gestionar las ACCIONES de publicaci�n
	 *  
	 */
	
	/**
	 * Obtiene la informaci�n de las acciones.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getActions() throws ISPACException;

	/**
	 * Obtiene la informaci�n de las acciones.
	 * @param pattern Patr�n con el nombre de la acci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getActions(String pattern) throws ISPACException;

	/**
	 * Obtiene la informaci�n de una acci�n.
	 * @param actionId Identificador de la acci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem getAction(int actionId) throws ISPACException;
	
	/**
	 * Elimina una acci�n.
	 * @param actionId Identificador de la acci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteAction(int actionId) throws ISPACException;

	
	/*
	 * 
	 * M�todos para gestionar las APLICACIONES de publicaci�n
	 *  
	 */
	
	/**
	 * Obtiene la informaci�n de las aplicaciones.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getApplications() throws ISPACException;

	/**
	 * Obtiene la informaci�n de las aplicaciones.
	 * @param pattern Patr�n con el nombre de la aplicaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getApplications(String pattern) throws ISPACException;

	/**
	 * Obtiene la informaci�n de una aplicaci�n.
	 * @param applicationId Identificador de la aplicaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem getApplication(int applicationId) throws ISPACException;

	/**
	 * Elimina una aplicaci�n.
	 * @param applicationId Identificador de la aplicaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteApplication(int applicationId) throws ISPACException;


	/*
	 * 
	 * M�todos para gestionar las CONDICIONES de publicaci�n
	 *  
	 */
	
	/**
	 * Obtiene la informaci�n de las condiciones.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getConditions() throws ISPACException;

	/**
	 * Obtiene la informaci�n de las condiciones.
	 * @param pattern Patr�n con el nombre de la condici�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getConditions(String pattern) throws ISPACException;

	/**
	 * Obtiene la informaci�n de una condici�n.
	 * @param conditionId Identificador de la condici�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem getCondition(int conditionId) throws ISPACException;

	/**
	 * Elimina una condici�n.
	 * @param conditionId Identificador de la condici�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteCondition(int conditionId) throws ISPACException;

	
	/*
	 * 
	 * M�todos para gestionar los ERRORES de publicaci�n
	 *  
	 */

	/**
	 * Obtiene la informaci�n de los errores.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getErrors() throws ISPACException;

	/**
	 * Obtiene la informaci�n del error.
	 * @param milestoneId Identificador del hito.
	 * @param applicationId Identificador de la aplicaci�n.
	 * @param systemId Identificador del sistema.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem getError(int milestoneId, int applicationId, String systemId) 
		throws ISPACException;

	
	/*
	 * 
	 * M�todos para gestionar los HITOS de publicaci�n
	 *  
	 */
	
	/**
	 * Obtiene la informaci�n de los hitos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getMilestones() throws ISPACException;

	/**
	 * Obtiene la informaci�n de los hitos.
	 * @param status Estado de los hitos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getMilestones(int status) throws ISPACException;

	public IItem getMilestone(int milestoneId, int applicationId, String systemId) 
			throws ISPACException;
	
	public IItem addMilestone(int milestoneId, int pcdId, int stageId, int taskId, 
			int docType, String objectId, int eventId, int infoId, String infoAux,  
			int applicationId, String systemId) throws ISPACException;
	
	public IItem updateMilestone(int milestoneId, int pcdId, int stageId, int taskId, 
			int docType, String objectId, int eventId, int infoId, String infoAux,  
			int applicationId, String systemId, int id_status) throws ISPACException;
	
	
	/**
	 * Reactiva un hito err�neo eliminando su error
	 * 
	 * @param milestoneId Identificador del hito
	 * @param applicationId Identificador de la aplicaci�n
	 * @param systemId Identificador del sistema
	 * @throws ISPACException
	 */
	public IItem reactivateMilestone(int milestoneId, int applicationId, String systemId) 
		throws ISPACException;
	
	public void deleteMilestone(int milestoneId, int applicationId, String systemId) 
		throws ISPACException;

	
	/*
	 * 
	 * M�todos para gestionar las REGLAS de publicaci�n
	 *  
	 */

	/**
	 * Obtiene la informaci�n de las reglas.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getRules() throws ISPACException;

	/**
	 * Obtiene la informaci�n de las reglas.
	 * @param pcdId Identificador del procedimiento.
	 * @param stageId Identificador de la fase.
	 * @param taskId Identificador del tr�mite.
	 * @param docTypeId Identificador del tipo de documento.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getRules(int pcdId, int stageId, int taskId, int docTypeId) 
		throws ISPACException;

	/**
	 * Obtiene la informaci�n de las reglas.
	 * @param pcdId Identificador del procedimiento.
	 * @param stageId Identificador de la fase.
	 * @param taskId Identificador del tr�mite.
	 * @param docTypeId Identificador del tipo de documento.
	 * @param eventId Identificador del evento.
	 * @param infoId Identificador de la informaci�n
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItemCollection getRules(int pcdId, int stageId, int taskId, int docTypeId, 
			int eventId, int infoId) throws ISPACException;

	/**
	 * Obtiene la informaci�n de una regla.
	 * @param ruleId Identificador de la regla.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem getRule(int ruleId) throws ISPACException;
	
	/**
	 * A�ade una regla al publicador
	 * @return Regla creada.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IItem addRule(int idPcd, int idFase, int idTramite, int tipoDoc,
			int idEvento, int idAccion, int idCondicion, String atributos,
			int orden, int idAplicacion, int idInfo) throws ISPACException;
	
	public IItem updateRegla(int idRegla, int idPcd, int idFase, int idTramite, int tipoDoc,
			int idEvento, int idAccion, int idCondicion, String atributos,
			int orden, int idAplicacion, int idInfo) throws ISPACException;
	
	/**
	 * Elimina una regla.
	 * @param ruleId Identificador de la regla.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteRule(int ruleId) throws ISPACException;

	/**
     * Incrementa el orden de una regla del publicador al siguiente orden existente y decrementa 
     * al sustituido
     *
     * @param id Identificador de la regla
     * @param pcdId Identificador del procedimiento
     * @param stageId Identificador de la fase
     * @param taskId Identificador del tr�mite
     * @param typeDoc Identificador del tipo de documento
     * @param eventId Identificador del evento
     * @param infoId Identificador de info
     * @param order Orden de la regla
     * @throws ISPACException si ocurre alg�n error.
     */
	public void incRuleOrder(int id, int pcdId, int stageId, int taskId,
			int typeDoc, int eventId, int infoId, int order) throws ISPACException;

	/**
     * Decrementa el orden de una regla del publicador al siguiente orden existente e incrementa 
     * al sustituido
     *
     * @param id Identificador de la regla
     * @param pcdId Identificador del procedimiento
     * @param stageId Identificador de la fase
     * @param taskId Identificador del tr�mite
     * @param typeDoc Identificador del tipo de documento
     * @param eventId Identificador del evento
     * @param infoId Identificador de info
     * @param order Orden de la regla
     * @throws ISPACException si ocurre alg�n error.
     */
	public void decRuleOrder(int id, int pcdId, int stageId, int taskId,
			int typeDoc, int eventId, int infoId, int order) throws ISPACException;


	/*
	 * 
	 * M�todos para gestionar el ULTIMO HITO TRATADO
	 *  
	 */

	/**
	 * Actualizar el �ltimo hito tratado en un sistema.
	 * @param systemId Identificador del sistema.
	 * @param milestoneId Identificador del hito tratado.
	 * @throws ISPACException si ocurre alg�n error.
	 */
    public boolean updateLastMilestoneTreated(String systemId, int milestoneId) throws ISPACException;
    
}
