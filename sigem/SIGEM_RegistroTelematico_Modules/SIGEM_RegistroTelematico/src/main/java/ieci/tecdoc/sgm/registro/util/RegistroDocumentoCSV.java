/**
 * 
 */
package ieci.tecdoc.sgm.registro.util;

/**
 * @author IECISA
 * 
 *         Interfaz de una asociaci�n entre el c�digo GUID de un documento y el
 *         c�digo CSV
 * 
 * 
 */
public interface RegistroDocumentoCSV {

	public void setGuid(String guid);

	public String getGuid();

	public void setCsv(String csv);

	public String getCsv();

	/**
	 * Recoge los valores de la instancia en una cadena xml
	 * 
	 * @param header
	 *            Si se incluye la cabecera
	 * @return los datos en formato xml
	 */
	public abstract String toXML(boolean header);

	/**
	 * Devuelve los valores de la instancia en una cadena de caracteres.
	 */
	public abstract String toString();

}
