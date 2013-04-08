package ieci.tecdoc.sgm.consolidacion.mgr;

import ieci.tecdoc.sgm.core.exception.SigemException;

/**
 * Interfaz para los managers de consolidaci�n.
 *
 */
public interface ConsolidacionManager {

	/**
	 * Realiza el proceso de consolidaci�n sobre una entidad. 
	 * @param idEntidad Identificador de la entidad.
	 * @throws SigemException si ocurre alg�n error.
	 */
	public abstract void consolidaEntidad(String idEntidad)
			throws SigemException;

}