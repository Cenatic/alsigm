package xml;

import java.io.Serializable;

import common.Constants;
import common.Globals;
import common.util.StringUtils;


/**
 * Clase abstracta de la que deber�n extender todos los objetos que
 * tengan relaci�n con un fichero XML de configuraci�n.
 */
public abstract class XMLObject implements Serializable, Cloneable 
{

	private static final long serialVersionUID = 1L;

	public static final String TRUE = Constants.TRUE_STRING;
	public static final String FALSE = Constants.FALSE_STRING;
	
	/**
	 * Obtiene una representaci�n del objeto.
	 * @return Representaci�n del objeto.
	 */
	public String toString()
	{
		return toXML(0);
	}


	/**
	 * Obtiene una representaci�n XML del objeto.
	 * @param indent N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public abstract String toXML(int indent);

	public String getCabeceraXML(String tabs){
		if(StringUtils.isEmpty(tabs)){
			tabs = Constants.BLANK;
		}
		
		return tabs + Globals.CABECERA_XML_FILES; 
	}
	
}
