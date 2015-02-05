package ieci.tdw.ispac.designer.client.service;

import ieci.tdw.ispac.designer.client.exceptions.DesignerException;
import ieci.tdw.ispac.designer.client.objetos.Condition;
import ieci.tdw.ispac.designer.client.objetos.DrawObject;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtIServiceAsync {
	
	/**
	 * Obtiene la informaci�n del procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void getProcedure(int pcdId, AsyncCallback callback);

	/**
	 * Obtiene la lista de fases del cat�logo que no pertenecen al procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void getCtStages(int pcdId, AsyncCallback callback);

	/**
	 * A�ade una fase del cat�logo al procedimiento.
	 * @param pcdId Identificador de la fase.
	 * @param ctStageId Identificador de la fase en el cat�logo.
	 * @param x Coordenada x de la fase.
	 * @param y Coordenada y de la fase.
	 * @param callback Callback del m�todo.
	 */
	public void addStage(int pcdId, int ctStageId, int x, int y, AsyncCallback callback);

	/**
	 * A�ade una fase espec�fica al procedimiento.
	 * @param pcdId Identificador de la fase.
	 * @param stageName Nombre de la fase.
	 * @param x Coordenada x de la fase.
	 * @param y Coordenada y de la fase.
	 * @param callback Callback del m�todo.
	 */
	public void addStage(int pcdId, String stageName, int x, int y, AsyncCallback callback);

	/**
	 * Elimina una fase del procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param stageId Identificador de la fase en el procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void removeStage(int pcdId, int stageId, AsyncCallback callback);

	/**
	 * A�ade un nodo de sincronizaci�n al procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param type Tipo de nodo de sincronizaci�n ({@link }).
	 * @param x Coordenada x del nodo de sincronizaci�n.
	 * @param y Coordenada y del nodo de sincronizaci�n.
	 * @param callback Callback del m�todo.
	 */
	public void addSyncNode(int pcdId, int type, int x, int y, AsyncCallback callback);

	/**
	 * Elimina el nodo de sincronizaci�n del procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param syncNodeId Identificador del nodo de sincronizaci�n en el procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void removeSyncNode(int pcdId, int syncNodeId, AsyncCallback callback);

	/**
	 * A�ade una transici�n al procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param startNodeId Identificador del nodo origen de la transici�n.
	 * @param endNodeId Identificador del nodo destino de la transici�n.
	 * @param callback Callback del m�todo.
	 */
	public void addFlow(int pcdId, int startNodeId, int endNodeId, AsyncCallback callback);

	/**
	 * Elimina la transici�n del procedimiento.
	 * @param pcdId Identificador del procedimiento.
	 * @param flowId Identificador de la transici�n en el procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void removeFlow(int pcdId, int flowId, AsyncCallback callback);

	/**
	 * Obtiene los tr�mites asociados a la fase.
	 * @param stageId Identificador de la fase en el procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void getTasks(int stageId, AsyncCallback callback);

	/**
	 * A�ade un tr�mite a la fase del procedimiento.
	 * @param stageId Identificador de la fase en el procedimiento.
	 * @param ctTaskId Identificador del tr�mite en el cat�logo de tr�mites.
	 * @param callback Callback del m�todo.
	 */
	public void addTask(int stageId, int ctTaskId, AsyncCallback callback);

	/**
	 * Elimina el tr�mite del procedimiento.
	 * @param taskId Identificador del tr�mite en el procedimiento.
	 * @param callback Callback del m�todo.
	 */
	public void removeTask(int taskId, AsyncCallback callback);

	/**
	 * Actualiza las posiciones de las fases y nodos.
	 * @param drawObjects Lista de objetos ({@link DrawObject}).
	 * @param callback Callback del m�todo.
	 
	public void updatePositions(List drawObjects, AsyncCallback callback);*/
	
	/**
	 * 
	 * @param drawObject Objeto a actualizar
	 * @param callback Callback dell metodo
	 */
	public void updatePosition(DrawObject drawObject, AsyncCallback callback);

 /**
 * 
 * @param pcdId Procedimiento del que se quiere obtener las fases
 * @param callback
 * @return
 */
	public void getPStages(int pcdId, AsyncCallback callback);
	
	/**
	 * 
	 * @param callback
	 * 
	 */
	public void getEntorno(AsyncCallback callback);
	
	
	/**
	 * Obtiene el procedimiento del expediente y los estados de cada una de las
	 * fases y tramites
	 * @param stageId : Identificador de la fase activa del expediente
	 * @param callback
	 */
	public void getProcedureByStageId(int stageId, AsyncCallback callback);
	
	/**
	 * 
	 * @param pcdId , Identificador del subproceso
	 * @param callback

	 */
	public void getSubProcByPcdId(int pcdId,int instance,  AsyncCallback callback);
	
	/**
	 * 
	 * @param orden de los tramites asociados a la fase
	 * @throws DesignerException
	 */
	public void reorderTasks(int [] orden, AsyncCallback callback) ;
	
	/**
	 * Obtiene la lista de entidades relacionadas con el procedimiento.
	 * @param pcdId Identificador del procedimiento
	 * @param callback
	 * @return 
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void getEntities(int pcdId, AsyncCallback callback) throws DesignerException;

	/**
	 * 
	 * @param nIdProc, Cuando un expediente ha sido finalizado la unica manera de obtener informacion es a trav�s de numExp o nIdProc , 
	 * utilizamos el segundo por se un entero
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void getProcedureBynIdProc(int nIdProc, AsyncCallback callback);
	/**
	 * Obtiene la lista de reglas del cat�logo.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void getCTRules(AsyncCallback callback) throws DesignerException;

	/**
	 * Obtiene las reglas del cat�logo que no est�n asociadas al evento del objeto.
	 * @param objType Tipo de objeto.
	 * @param objId Identificador del objeto.
	 * @param eventCode C�digo de evento.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void getAvailableCTRules(int objType, int objId, int eventCode,
			AsyncCallback callback) throws DesignerException;

	/**
	 * Obtiene la lista de reglas de un objeto.
	 * @param objType Tipo de objeto.
	 * @param objId Identificador del objeto.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void getEventRules(int objType, int objId, AsyncCallback callback) 
		throws DesignerException;

	/**
	 * A�ade una regla asociada al evento de un objeto.
	 * @param objType Tipo de objeto.
	 * @param objId Identificador del objeto.
	 * @param eventCode C�digo de evento.
	 * @param rulesId Lista de Identificadores de la regla.
	 * @param condition Informaci�n de la condici�n.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void addEventRule(int objType, int objId, int eventCode, List rulesId, 
			Condition condition, AsyncCallback callback) throws DesignerException;
	
	/**
	 * Modifica la condici�n asociada al evento de un objeto.
	 * @param eventRuleId Identificador de la regla del evento.
	 * @param condition Condici�n.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void updateEventRuleCondition(String eventRuleId, Condition condition, 
			AsyncCallback callback) throws DesignerException;

	/**
	 * Elimina un listado de reglas, cada una asociado a un evento
	 * @param eventRuleId Lista de identificadores de la regla del evento.
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void removeEventsRules(List eventRuleIds, AsyncCallback callback) throws DesignerException;

	/**
	 * Incrementa el orden de las reglas asociadas a eventos de un objeto.
	 * @param eventRuleIds Identificadores de los eventos.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void incOrderEventRules(String[] eventRuleIds, AsyncCallback callback) 
		throws DesignerException;

	/**
	 * Decrementa el orden de las reglas asociadas a eventos de un objeto.
	 * @param eventRuleIds Identificadores de los eventos.
	 * @param callback
	 * @throws DesignerException si ocurre alg�n error.
	 */
	public void decOrderEventRules(String[] eventRuleIds, AsyncCallback callback) 
		throws DesignerException;
	
	/**
	 * Obtiene los eventos asignables a un tipo de objeto.
	 * @param objType Tipo de objeto.
	 * @throws DesignerException si ocurre alg�n error.
	 */
	 public void getEvents(int objType, AsyncCallback callback) throws DesignerException ;
	 
	 /**
	  * Elimina todas las condiciones de un flujo
	  * @param objType Tipo de objeto
	  * @param objId Identificador del objeto.
	  */
	 public void removeEventRules(int objType, int objId,  AsyncCallback callback) throws DesignerException;

	
}
