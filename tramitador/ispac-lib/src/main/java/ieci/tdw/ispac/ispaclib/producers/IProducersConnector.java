package ieci.tdw.ispac.ispaclib.producers;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.producers.vo.Producer;

import java.util.List;

/**
 * Interfaz para el conector de productores.
 *
 */
public interface IProducersConnector {

	/**
	 * Obtiene el productor principal.
	 * @return Informaci�n del productor.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Producer getRootProducer() throws ISPACException;

	/**
	 * Obtiene la informaci�n de un productor.
	 * @param id Identificador del productor
	 * @return Informaci�n del productor.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Producer getProducer(String id) throws ISPACException;

	/**
	 * Obtiene la lista de hijos del productor.
	 * @param id Identificador del productor
	 * @return Lista de productores ({@see Producer}.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public List getProducerChildren(String id) throws ISPACException;
	
	/**
	 * Obtiene la lista de antecesores del productor.
	 * @param id Identificador del productor
	 * @return Lista de productores ({@see Producer}.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public List getProducerAncestors(String id) throws ISPACException;

}
