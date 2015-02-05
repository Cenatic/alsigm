package es.ieci.tecdoc.fwktd.csv.ws.delegate;

import java.util.List;

import es.ieci.tecdoc.fwktd.csv.ws.service.AplicacionCSV;
import es.ieci.tecdoc.fwktd.csv.ws.service.AplicacionCSVForm;

/**
 * Interfaz del delegate para gestionar aplicaciones externas.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface AplicacionesDelegate {

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
	 * @param aplicacionForm
	 *            Informaci�n de la nueva aplicaci�n externa.
	 * @return Informaci�n de la aplicaci�n externa creada.
	 */
	public AplicacionCSV saveAplicacion(AplicacionCSVForm aplicacionForm);

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
