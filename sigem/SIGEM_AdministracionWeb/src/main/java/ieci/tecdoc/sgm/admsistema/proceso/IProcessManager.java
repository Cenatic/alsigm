package ieci.tecdoc.sgm.admsistema.proceso;

import java.util.Map;

/** 
 * @author Iecisa 
 * @version $Revision$ 
 *
 */
public interface IProcessManager {

	/**
	 * Realiza la ejecuci�n de un proceso
	 * @param options Par�metros para el proceso
	 * @return true si el proceso se ha realizado con �xito. 
	 * @throws Exception si ocurre alg�n error.
	 */
	public boolean execute(Map options) throws Exception;
	
}
