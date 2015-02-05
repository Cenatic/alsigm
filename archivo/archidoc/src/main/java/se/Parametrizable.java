package se;

import java.util.Properties;

import common.exceptions.SistemaExternoException;

/**
 * Interfaz para los contectores que sean parametrizables.
 */
public interface Parametrizable {

	/**
	 * Inicializa con los par�metros de configuraci�n.
	 * 
	 * @param params
	 *            Par�metros de configuraci�n.
	 * @throws SistemaExternoException
	 *             si ocurre alg�n error.
	 */
	public void initialize(Properties params) throws SistemaExternoException;

}
