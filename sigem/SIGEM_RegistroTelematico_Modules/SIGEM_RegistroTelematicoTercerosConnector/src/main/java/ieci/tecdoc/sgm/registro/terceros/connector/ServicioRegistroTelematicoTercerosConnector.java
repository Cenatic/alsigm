package ieci.tecdoc.sgm.registro.terceros.connector;

import ieci.tecdoc.sgm.registro.terceros.connector.vo.TerceroVO;

/**
 * Interfaz para una conexi�n con terceros en registro telem�tico
 * @author iecisa
 *
 */
public interface ServicioRegistroTelematicoTercerosConnector {

	/**
	 * M�todo que busca un tercero y sus direcciones a partir de su <code>identificador</code> en un sistema externo.
	 * @param identificador
	 * @return TerceroVO tercero encontrado o null en caso de no encontrarse. El tercero lleva una lista de direcciones
	 */
	public TerceroVO buscarTercero(String identificador);

	/**
	 * M�todo que busca un tercero y sus direcciones a partir de su <code>identificador</code> en un sistema externo.
	 * @param entidad
	 * @param identificador
	 * @return TerceroVO tercero encontrado o null en caso de no encontrarse. El tercero lleva una lista de direcciones
	 */
	public TerceroVO buscarTerceroPorEntidad(String entidad,String identificador);

}
