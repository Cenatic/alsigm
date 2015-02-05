package es.ieci.tecdoc.fwktd.csv.api.manager;

import es.ieci.tecdoc.fwktd.csv.api.vo.AplicacionVO;
import es.ieci.tecdoc.fwktd.server.manager.BaseManager;

/**
 * Interfaz para los managers de aplicaciones.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AplicacionManager extends BaseManager<AplicacionVO, String> {

	/**
	 * Obtiene la informaci�n de la aplicaci�n a partir del c�digo.
	 *
	 * @param codigo
	 *            C�digo de la aplicaci�n.
	 * @return Informaci�n de la aplicaci�n.
	 */
	public AplicacionVO getAplicacionByCodigo(String codigo);

	/**
	 * Elimina la informaci�n de la aplicaci�n a partir del c�digo.
	 *
	 * @param codigo
	 *            C�digo de la aplicaci�n.
	 */
	public void deleteAplicacionByCodigo(String codigo);
}
