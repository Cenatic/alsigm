package es.ieci.tecdoc.fwktd.csv.core.service;

import java.util.List;

import es.ieci.tecdoc.fwktd.csv.core.vo.AplicacionCSV;
import es.ieci.tecdoc.fwktd.csv.core.vo.AplicacionCSVForm;

/**
 * Interfaz del servicio de gesti�n de aplicaciones externas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface ServicioAplicaciones {

	/**
	 * Obtiene el listado de aplicaciones externas.
	 *
	 * @return Listado de aplicaciones.
	 */
	public List<AplicacionCSV> getAplicaciones();

	/**
	 * Obtiene la informaci�n de la aplicaci�n externa.
	 *
	 * @param id
	 *            Identificador de la aplicaci�n externa.
	 * @return Informaci�n de la aplicaci�n externa.
	 */
	public AplicacionCSV getAplicacion(String id);

	/**
	 * Obtiene la informaci�n de la aplicaci�n externa.
	 *
	 * @param codigo
	 *            C�digo de la aplicaci�n externa.
	 * @return Informaci�n de la aplicaci�n externa.
	 */
	public AplicacionCSV getAplicacionByCodigo(String codigo);

	/**
	 * Guarda la informaci�n de una aplicaci�n externa.
	 *
	 * @param aplicacion
	 *            Informaci�n de la nueva aplicaci�n externa.
	 * @return Informaci�n de la aplicaci�n externa creada.
	 */
	public AplicacionCSV saveAplicacion(AplicacionCSVForm aplicacion);

	/**
	 * Actualiza la informaci�n de una aplicaci�n externa existente.
	 *
	 * @param aplicacion
	 *            Informaci�n de la aplicaci�n externa.
	 * @return Informaci�n de la aplicaci�n externa modificada.
	 */
	public AplicacionCSV updateAplicacion(AplicacionCSV aplicacion);

	/**
	 * Elimina la informaci�n de la aplicaci�n externa.
	 *
	 * @param id
	 *            Identificador de la aplicaci�n externa.
	 */
	public void deleteAplicacion(String id);

}
