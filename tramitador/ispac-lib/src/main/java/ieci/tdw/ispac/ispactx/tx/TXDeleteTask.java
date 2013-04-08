package ieci.tdw.ispac.ispactx.tx;

import java.util.Map;

import ieci.tdw.ispac.api.IBPMAPI;
import ieci.tdw.ispac.api.ITXTransaction;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.rule.EventManager;
import ieci.tdw.ispac.api.rule.EventsDefines;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.dao.tx.TXTramiteDAO;
import ieci.tdw.ispac.ispaclib.notices.Notices;
import ieci.tdw.ispac.ispactx.ITXAction;
import ieci.tdw.ispac.ispactx.TXConstants;
import ieci.tdw.ispac.ispactx.TXTransactionDataContainer;

/**
 * Acci�n para eliminar un tr�mite.
 */
public class TXDeleteTask implements ITXAction {
	
	/** Identificador del tr�mite instanciado. */
	private final int mnIdTask;
	
	/**
	 * Par�metros para el contexto de las reglas.
	 */
	private final Map mparams;

	/**
	 * Constructor.
	 * @param nIdTask Identificador del tr�mite instanciado. 
	 */
	public TXDeleteTask(int nIdTask) {
		this(nIdTask, null);
	}

	/**
	 * Constructor.
	 * @param nIdTask Identificador del tr�mite instanciado. 
	 */
	public TXDeleteTask(int nIdTask, Map params) {
		super();
		mnIdTask=nIdTask;
		mparams=params;
	}

	/**
	 * Ejecuta la acci�n.
	 * @param cs Contexto de cliente.
	 * @param dtc Contenedor de los datos de la transacci�n.
	 * @param itx Transacci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void run(ClientContext cs, TXTransactionDataContainer dtc,
			ITXTransaction itx) throws ISPACException {
		
		// Informaci�n del tr�mite
		TXTramiteDAO task = dtc.getTask(mnIdTask);
		int nIdPCDTask = task.getInt("ID_TRAMITE");
		int nIdProc = task.getInt("ID_EXP");
		int nIdPCDStage = task.getInt("ID_FASE_PCD");

		String bpmTaskId = task.getString("ID_TRAMITE_BPM");

		// Obtener el API de BPM
		IBPMAPI bpmAPI = dtc.getBPMAPI();

		// Eliminar el tr�mite en el BPM
		bpmAPI.deleteTask( bpmTaskId);

		//Se elimina el tramite 
		dtc.deleteTask(mnIdTask);
		
		//Se anota en la entidad del tr�mite la finalizaci�n del mismo.
		dtc.deleteTaskEntity(mnIdTask);
		
		EventManager eventmgr = new EventManager(cs, mparams);

		// Se construye el contexto de ejecuci�n de scripts.
		eventmgr.getRuleContextBuilder().addContext(task);
		
		//Ejecutar eventos al borrar el tr�mite.
		eventmgr.processEvents(	EventsDefines.EVENT_OBJ_TASK, nIdPCDTask, EventsDefines.EVENT_EXEC_DELETE);
		
		// Marcar el hito
		dtc.newMilestone(nIdProc, nIdPCDStage, nIdPCDTask, TXConstants.MILESTONE_TASK_DELETE);
		
		//Si existe un aviso electronico que indica que el tramite a eliminar ha sido delegado, se archiva
		Notices notices = new Notices(cs);
		notices.archiveDelegateTaskNotice(task.getInt("ID_FASE_EXP") , task.getKeyInt());
	}

	/**
	 * Bloquea el objeto de la acci�n.
	 * @param cs Contexto de cliente.
	 * @param dtc Contenedor de los datos de la transacci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void lock(ClientContext cs, TXTransactionDataContainer dtc)
			throws ISPACException {
		
		TXTramiteDAO task = dtc.getTask(mnIdTask);
		dtc.getLockManager().lockProcess(task.getInt("ID_EXP"));
		dtc.getLockManager().lockTask(mnIdTask);
	}

	/**
	 * Obtiene el resultado de la acci�n.
	 * @param nameResult Nombre del resultado.
	 * @return Resultado de la acci�n.
	 */
	public Object getResult(String nameResult) {
		return null;
	}
}
