package xml.config;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;


/**
 * Clase que almacena la configuraci�n de la auditor�a.
 */
public class ConfiguracionAuditoria extends XMLObject
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Plantilla XSL de transformaci�n. */
	private String plantillaXSL = null;


	/**
	 * Constructor.
	 */
	public ConfiguracionAuditoria()
	{
		super();
	}


	/**
	 * Obtiene la plantilla XSL de transformaci�n.
	 * @return Plantilla XSL de transformaci�n.
	 */
	public String getPlantillaXSL()
	{
		return plantillaXSL;
	}


	/**
	 * Establece la plantilla XSL de transformaci�n.
	 * @param plantillaXSL Plantilla XSL de transformaci�n.
	 */
	public void setPlantillaXSL(String plantillaXSL)
	{
		this.plantillaXSL = plantillaXSL;
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
		xml.append(tabs + "<Configuracion_Auditoria>");
		xml.append(Constants.NEWLINE);

		// Plantilla_XSL
		xml.append(tabs + "  <Plantilla_XSL>");
		xml.append(plantillaXSL != null ? plantillaXSL : "");
		xml.append("</Plantilla_XSL>");
		xml.append(Constants.NEWLINE);

		// Tag de cierre
		xml.append(tabs + "</Configuracion_Auditoria>");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

}
