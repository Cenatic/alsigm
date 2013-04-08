package xml.config;

import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;


/**
 * Clase que almacena la informaci�n del sistema gestor de cat�logos.
 */
public class SistemaGestorCatalogo extends XMLObject
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String idSistGestorOrg = null;
	private String clase = null;

	/** Par�metros de configuraci�n del sistema. */
	protected Properties parametros = new Properties();


	/**
	 * Constructor.
	 */
	public SistemaGestorCatalogo()
	{
		super();
	}


	/**
	 * @return Returns the clase.
	 */
	public String getClase()
	{
		return clase;
	}
	/**
	 * @param clase The clase to set.
	 */
	public void setClase(String clase)
	{
		this.clase = clase;
	}
	/**
	 * @return Returns the idSistGestorOrg.
	 */
	public String getIdSistGestorOrg()
	{
		return idSistGestorOrg;
	}
	/**
	 * @param idSistGestorOrg The idSistGestorOrg to set.
	 */
	public void setIdSistGestorOrg(String idSistGestorOrg)
	{
		this.idSistGestorOrg = idSistGestorOrg;
	}


	/**
	 * Obtiene los par�metros de configuraci�n del sistema.
	 * @return Par�metros de configuraci�n del sistema.
	 */
	public Properties getParametros()
	{
		return parametros;
	}


	/**
	 * A�ade un par�metro de configuraci�n.
	 * @param nombre Nombre del par�metro.
	 * @param valor Valor del par�metro.
	 */
	public void addParametro(String nombre, String valor)
	{
		parametros.setProperty(nombre, valor);
	}


	/**
	 * Obtiene una representaci�n XML del objeto.
	 * @param indent N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public String toXML(int indent)
	{
		final StringBuffer xml = new StringBuffer();
		final String tabs = StringUtils.repeat(" ", indent);

		// Tag de inicio
		xml.append(tabs + "<Sistema_Gestor_Catalogo>");
		xml.append(Constants.NEWLINE);

		// idSistGestorOrg
		if (StringUtils.isNotBlank(idSistGestorOrg))
		{
			xml.append(tabs + "  <Id_SistGestor_Org>");
		    xml.append(idSistGestorOrg);
		    xml.append("</Id_SistGestor_Org>");
			xml.append(Constants.NEWLINE);
		}

		// Clase
		if (StringUtils.isNotBlank(clase))
		{
			xml.append(tabs + "  <Clase>");
		    xml.append(clase);
		    xml.append("</Clase>");
			xml.append(Constants.NEWLINE);
		}

		// Parametros
		Enumeration keys = parametros.keys();
		String key = null, value = null;
		while (keys.hasMoreElements())
		{
			key = (String) keys.nextElement();
			value = parametros.getProperty(key, "");

			xml.append(tabs + "  <init-param>" + Constants.NEWLINE);
			xml.append(tabs + "    <param-name>");
			xml.append(key);
			xml.append("</param-name>" + Constants.NEWLINE);
			xml.append(tabs + "    <param-value>");
			xml.append(value);
			xml.append("</param-value>" + Constants.NEWLINE);
		    xml.append(tabs + "  </init-param>" + Constants.NEWLINE);
		}

		// Tag de cierre
		xml.append(tabs + "</Sistema_Gestor_Catalogo>");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
