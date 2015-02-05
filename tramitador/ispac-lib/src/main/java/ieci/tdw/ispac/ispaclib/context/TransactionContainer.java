package ieci.tdw.ispac.ispaclib.context;

import ieci.tdw.ispac.api.IBPMAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.db.DbCnt;

/**
 * Contenedor de transaccciones.
 */
public class TransactionContainer {
	
    private IClientContext context = null;
    private boolean previoustx = false;
    
    private IBPMAPI bpmAPI = null;
    private boolean error = false;

    
    /**
     * Constructor
     * @param context Contexto de cliente.
     */
    public TransactionContainer(IClientContext context) {
        this.context=context;
        this.previoustx=false;

		try {
			//Se obtiene el API del BPM el cual iniciara la sesion
			this.bpmAPI = context.getAPI().getBPMAPI();
		} catch (ISPACException e) {
			this.bpmAPI = null;
		}
    }
    
    /**
     * Inicia una transacci�n
     * @throws ISPACException si ocurre alg�n error.
     */
    public void begin() throws ISPACException {
		try {
			previoustx = context.ongoingTX();
			if (!previoustx) {
				context.beginTX();
			}
			if (bpmAPI != null) {
				bpmAPI.initBPMSession();
			}
		} catch (ISPACException e) {
			throw e;
		} catch (Exception e) {
			throw new ISPACException("Error en TransactionContainer.begin() ",
					e);
		}
	}

    /**
	 * Obtiene una conexi�n con la base de datos.
	 * @return Conexi�n con la base de datos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
    public DbCnt getConnection() throws ISPACException {
		return context.getConnection();
	}

    /**
	 * Realiza un commit de la transacci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
    public void commit() throws ISPACException {
		try {
			if (bpmAPI != null) {
				bpmAPI.closeBPMSession(true);
			}
			if (!previoustx) {
				context.endTX(true);
			}
		} catch (ISPACException e) {
			throw e;
		} catch (Exception e) {
			throw new ISPACException("Error en TransactionContainer.commit()",
					e);
		}
	}

    /**
     * Libera la transacci�n
     * @throws ISPACException si ocurre alg�n error.
     */
    public void release() throws ISPACException {
		try {
			if (!previoustx) {
				context.releaseTX();
			}
			if (error && (bpmAPI != null)) {
				bpmAPI.closeBPMSession(false);
			}
		} catch (ISPACException e) {
			throw e;
		} catch (Exception e) {
			throw new ISPACException(
					"Error en TransactionContainer.release() ", e);
		}
	}

    /**
     * Obtiene el API de BPM.
     * @return API de BPM.
     */
	public IBPMAPI getBPMAPI() {
		return bpmAPI;
	}

	/**
	 * Establece si hay error en la transacci�n.
	 * @param error true si hay un error en la transacci�n.
	 */
	public void setError(boolean error) {
		this.error = error;
	}
}
