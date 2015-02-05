package ieci.tdw.ispac.api;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.bpm.BpmUIDs;
import ieci.tdw.ispac.ispaclib.bpm.IBPMSession;
import ieci.tdw.ispac.ispaclib.bpm.Process;
import ieci.tdw.ispac.ispaclib.bpm.ProcessFlow;
import ieci.tdw.ispac.ispaclib.bpm.ProcessNode;

import java.util.List;

/**
 * Interfaz para el API de BPM.
 *
 */
public interface IBPMAPI {


	/**
	 * Inicio de sesi�n del BPM
	 * @return Sesi�n de BPM
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IBPMSession initBPMSession() throws ISPACException;

	/**
	 * Inicio de sesi�n del BPM autenticando usuario
	 * @param user Usuario 
	 * @param password Clave
	 * @return Sesi�n de BPM
	 * @throws ISPACException
	 */
	public IBPMSession initBPMSession(String user, String password) 
			throws ISPACException;

	/**
	 * Inicio de sesi�n en el BPM seg�n id de usuario conectado
	 * @param userId Identificador de usuario para el BPM
	 * @return Sesi�n de BPM
	 * @throws ISPACException
	 */
	public IBPMSession initBPMSession(String userId) 
		throws ISPACException;

	/**
	 * Finaliza la sesi�n del BPM
	 * @param commit true si finaliza correctamente, false en caso contrario. 
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void closeBPMSession(boolean commit) throws ISPACException;

	/**
	 * Instancia un proceso.
	 * @param processModelId Identificador del Modelo de proceso
	 * @param processRespId Identificador del responsable a establecer en el proceso a instanciar
	 * @param stageRespId Identificador del responsable a establecer en la primera fase del proceso a instanciar
	 * @return Jerarqu�a de UID's de los objetos implicados 
	 * @throws ISPACException
	 */
	public BpmUIDs instanceProcess(String processModelId, String processRespId, String stageRespId) 
			throws ISPACException; 

	/**
	 * Instancia un tr�mtie.
	 * @param taskProcessModelId Identificador del tr�mite para el Modelo de Proceso
	 * @param processModelSubprocessId Identificador del Modelo de Subproceso
	 * @param taskRespId Identificador del responsable a establecer en el tr�mite a instanciar
	 * @param stageTaskRespId Identificador del responsable a establecer en la actividad del tr�mite a instanciar
	 * @param stageId Identificador de la fase instanciada desde la que se invoca a instanciar el tr�mite
	 * @return Jerarqu�a de UID's de los objetos implicados
	 * @throws ISPACException
	 */
	public BpmUIDs instanceTask(String processModelTaskId,
			String processModelSubprocessId, String taskRespId,
			String stageTaskRespId, String stageId)
			throws ISPACException; 

	
	public String getResponsibleProcess(String processId) 
			throws ISPACException;
	public String getResponsibleTask(String taskId) 
			throws ISPACException; 
	public String getResponsibleProcessStage(String stageId) 
			throws ISPACException; 
//	public String getResponsibleTaskActivity(String taskActivyId) 
//			throws ISPACException; 
	

	
	/**
	 * Finaliza una fase de un proceso
	 * @param stageId Identificador de la fase instanciada
	 * @throws ISPACException
	 */
	public void closeProcesssStage(String stageId) 
			throws ISPACException;

	
	/**
	 * Instancia una fase del modelo de proceso
	 * @param pmStageId Identificador de la fase del modelo de proceso a instanciar
	 * @param respId Identificador del responsable a establecer en la fase a instanciar
	 * @param instancedProcessId Identificador de la instancia del proceso.
	 * @return Jerarqu�a de UID's de los objetos implicados
	 * @throws ISPACException
	 */
	public BpmUIDs instanceProcessStage(String pmStageId, String respId, String instancedProcessId)
			throws ISPACException;
	
	
	/**
	 * Obtiene las fases siguientes para el proceso instanciado y la fase indicada
	 * @param processId Identificador del proceso instanciado
	 * @param processStageId Identificador de la fase de partida para obtener las siguientes
	 * @return Lista de identificadores de las siguientes fases del flujo para el proceso instanciado 
	 * @throws ISPACException
	 */
	public List getNextStages(String processId, String processModelStageId)
			throws ISPACException;

	
	/**
	 * Retorna la fase inicial para el Modelo de proceso requerido
	 * @param processModelId Identificador del Modelo de proceso
	 * @return Identificador de la fase inicial del Modelo de proceso
	 * @throws ISPACException
	 */
	public String getInitialStage(String processModelId)
			throws ISPACException;
	
	/**
	 * Obtiene la fase previa para el proceso instanciado y la fase indicada
	 * @param processId Identificador del proceso instanciado
	 * @param processStageId Identificador de la fase de partida para obtener la anterior
	 * @return Identificador de la fase previa en el flujo para el proceso instanciado
	 * @throws ISPACException
	 */
	public String getPreviousStage(String processId, String processModelStageId)
		throws ISPACException;
	
	/**
	 * Finaliza una actividad de un subproceso
	 * @param activityId Identificador de una actividad instanciada 
	 * @throws ISPACException
	 */
//	public void closeTaskActivity(String activityId)
//			throws ISPACException;

	
	/**
	 * Instancia una actividad para un subproceso
	 * @param subprocessId Identificador del subproceso instaciado
	 * @param pmActivityId Identificador de la actividad a instanciar
	 * @param respId Identificador del responsable a establecer en la actividad a instaciar
	 * @return Jerarqu�a de UID's de los objetos implicados
	 * @throws ISPACException
	 */
//	public BpmUIDs instanceTaskActivity(String subprocessId, String pmActivityId, String respId)
//			throws ISPACException;

	
	/**
	 * Obtiene las actividades siguientes para el subproceso instanciado
	 * @param taskId Identificador del subproceso instanciado
	 * @return Lista de identificadores de las siguientes actividades del flujo para el subproceso instanciado 
	 * @throws ISPACException
	 */
//	public List getNextActivities(String subprocessId)
//			throws ISPACException;

	/**
	 * Obtiene la actividad previa para el subproceso instanciado
	 * @param subprocessId Identificador del subproceso instanciado
	 * @return Identificador de la actividad previa en el flujo para el subproceso instanciado
	 * @throws ISPACException
	 */	
//	public String getPreviousActivity(String subprocessId)
//			throws ISPACException;
	
	
	/**
	 * Finaliza un tr�mite
	 * @param taskId Identificador de un tr�mite instanciado
	 * @throws ISPACException
	 */
	public void endTask(String taskId) throws ISPACException;

	/**
	 * Finaliza un conjunto de tr�mites de una fase de un proceso
	 * @param processId Identificador del proceso instanciado
	 * @param stageId Identificador de fase instanciada de un proceso
	 * @throws ISPACException
	 */
	public void endTasks(String processId, String stageId)
			throws ISPACException;

	/**
	 * Finaliza un conjunto de tr�mites
	 * @param taskIds Lista de identificadores de tr�mites a finalizar
	 * @throws ISPACException
	 */
	public void endTasks(List taskIds)
			throws ISPACException;
	
	/**
	 * Delega un proceso.
	 * @param processId Identificador de un proceso.
	 * @param respId Identificador de responsable.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void delegateProcess(String processId, 
			String respId) throws ISPACException;

	/**
	 * Delega una fase.
	 * @param stageId Identificador de una fase.
	 * @param respId Identificador de responsable.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void delegateStage(String stageId, String respId)
			throws ISPACException;

	/**
	 * Delega un tr�mite.
	 * @param taskId Identificador de un tr�mite. 
	 * @param respId Identificador de responsable.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void delegateTask(String taskId, String respId)
			throws ISPACException;

	/**
	 * Delega una actividad
	 * @param stageId Identificador de una fase instanciada
	 * @param respId Identificador de responsable
	 * @throws ISPACException
	 */
//	public void delegateTaskActiviy(String stageId, String respId)
//		throws ISPACException;
	
	/**
	 * Elimina un tr�mite.
	 * @param taskId Identificador de un tr�mite. 
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteTask(String taskId) 
		throws ISPACException;

	/**
	 * Adquiere una fase de un proceso por parte de un usuario.
	 * @param stageId Identificador de la fase instanciada a adquirir
	 * @param respId Identificador del responsable que va a adquirir la fase
	 * @return true si se ha adquirido la fase correctamente, false en caso de que se deba capturar
	 * @throws ISPACException
	 */
	public boolean acquireStage(String stageId, String respId)
			throws ISPACException;

	
	/**
	 * @param stageId Identificador de la fase instancia del expediente a adquirir
	 * @param respId Identificador del responsable que va a capturar la fase/expediente
	 * @throws ISPACException
	 */
	public void captureStage(String stageId, String respId)
			throws ISPACException;	
	
	/**
	 * Adquiere una actividad de un tr�mite por parte de un usuario.
	 * @param activityId Identificador de la actividad instanciada a adquirir 
	 * @param respId Identificador del responsable que va a adquirir la actividad
	 * @throws ISPACException
	 */
//	public void acquireTaskActivity(String activityId, String respId)
//			throws ISPACException;
	
	/**
	 * Finaliza un proceso
	 * @param processId Identificador del proceso a finalizar
	 * @throws ISPACException
	 */
	public void endProcess(String processId)
			throws ISPACException;
	
	
	/**
	 * Finaliza un subproceso
	 * @param subProcessId Identificador del subproceso
	 * @throws ISPACException
	 */
	public void endSubprocess(String subProcessId)
			throws ISPACException;


	/**
	 * @param nodeUID Identificador de nodo de sincronizaci�n
	 * @return Lista de UIDs de fases a activar
	 * @throws ISPACException
	 */
	public List processSyncNode(String nodeUID)
			throws ISPACException;

	
	/* 
	 * =========================================================================
	 * =========================================================================
	 * 
	 * 						CAT�LOGO DE PROCEDIMIENTOS
	 * 
	 * =========================================================================
	 * =========================================================================
	 */

	
	/* 
	 * =========================================================================
	 * M�todos para gestionar el proceso
	 * =========================================================================
	 */
	
	/**
	 * Crea el proceso.
	 * @param process Informaci�n del proceso.
	 * @return Identificador del proceso creado.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public String createProcess(Process process) throws ISPACException;

	
	/**
	 * Cambia el estado de un proceso a vigente realizando las validaciones correspondientes.
	 * @param processId Identificador del proceso
	 * @throws ISPACException si ocurre alg�n error
	 */
	public void installProcess(String processId) throws ISPACException;
	
	/**
	 * Crea el tr�mite/subproceso.
	 * @param taskModel Informaci�n del subproceso.
	 * @return Identificador del subproceso creado.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public String createTask(Process taskModel) throws ISPACException;	
	
	
	/**
	 * Actualiza el responsable del proceso.
	 * @param processId Identificador del proceso.
	 * @param respId Identificador del responsable.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void updateProcessResponsible(String processId, String respId) 
		throws ISPACException;

	/**
	 * Elimina el proceso.
	 * @param processId Identificador del proceso.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void deleteProcess(String processId) throws ISPACException;

	
	/**
	 * Actualiza el responsable del tr�mite.
	 * @param taskId Identificador del tr�mite.
	 * @param respId Identificador del responsable.
	 * @throws ISPACException
	 */
	public void updateTaskResponsible(String taskId, String respId) throws ISPACException;
	
	/* 
	 * =========================================================================
	 * M�todos para gestionar los nodos del proceso
	 * =========================================================================
	 */

	/**
	 * Crea un nodo en el proceso.
	 * @param processId Identificador del proceso.
	 * @param node Informaci�n del nodo.
	 * @return Identificador del nodo creado.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public String createNode(String processId, ProcessNode node) 
		throws ISPACException;

	/**
	 * Actualiza el responsable del nodo del proceso.
	 * @param nodeId Identificador del nodo.
	 * @param respId Identificador del responsable.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void updateNodeResponsible(String nodeId, String respId) 
		throws ISPACException;
	
	/**
	 * Asocia un subproceso a un nodo del proceso.
	 * @param nodeId Identificador del nodo.
	 * @param subProcessId Identificador del subproceso.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void addNodeSubProcess(String nodeId, String subProcessId) 
		throws ISPACException;

	/**
	 * Elimina la relaci�n entre un subproceso y un nodo.
	 * @param nodeId Identificador del nodo.
	 * @param subProcessId Identificador del subproceso.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void removeNodeSubProcess(String nodeId, String subProcessId) 
		throws ISPACException;

	/**
	 * Elimina la relaci�n de los procesos de un nodo.
	 * @param nodeId Identificador del nodo.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void removeNodeSubProcess(String nodeId) throws ISPACException;

	/**
	 * Elimina la informaci�n de un nodo.
	 * @param processId Identificador del proceso.
	 * @param nodeId Identificador del nodo.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void deleteNode(String processId, String nodeId) throws ISPACException;
	

	/* 
	 * =========================================================================
	 * M�todos para gestionar los flujos del proceso
	 * =========================================================================
	 */

	/**
	 * Crea un flujo.
	 * @param processId Identificador del proceso.
	 * @param flow Informaci�n del flujo.
	 * @return Identificador del flujo creado.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public String createFlow(String processId, ProcessFlow flow) 
		throws ISPACException;

	/**
	 * Elimina la informaci�n de un flujo.
	 * @param processId Identificador del proceso.
	 * @param flowId Identificador del flujo.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void deleteFlow(String processId, String flowId) throws ISPACException;

}