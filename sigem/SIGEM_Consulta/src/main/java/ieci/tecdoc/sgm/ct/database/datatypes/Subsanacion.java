package ieci.tecdoc.sgm.ct.database.datatypes;

/**
 * Interfaz de comportamiento de un objeto representativo 
 * de la Subsanaci�n.
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public interface Subsanacion {
	
	public abstract String toXML(boolean header);

	/**
	 * Devuelve los valores de la instancia en una cadena de caracteres.
	 */
	
	
	public abstract String toString();

}