package es.ieci.tecdoc.fwktd.csv.api.dao;

import es.ieci.tecdoc.fwktd.csv.api.vo.AplicacionVO;
import es.ieci.tecdoc.fwktd.server.dao.BaseDao;

/**
 * Interfaz de los DAOs de aplicaciones.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AplicacionDao extends BaseDao<AplicacionVO, String> {

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
