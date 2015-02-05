package descripcion.model.automaticos;

import java.util.Map;

import common.bi.ServiceSession;

/**
 * Interfaz para las clases que realicen los c�lculos autom�ticos de los valores
 * de las fichas.
 */
public interface IADReglaGenDatos {

	/**
	 * Inicializa la clase con unos par�metros.
	 * 
	 * @param parametros
	 *            Par�metros de la clase.
	 */
	public void inicializa(Map parametros);

	/**
	 * Genera los datos autom�ticos.
	 * 
	 * @param session
	 *            Sesi�n de base de datos.
	 * @param id
	 *            Identificador del objeto descrito.
	 * @throws ADReglaGenDatosException
	 *             si ocurre alg�n error.
	 */
	public void generacionDatosAutomaticos(ServiceSession session, String id)
			throws ADReglaGenDatosException;
}
