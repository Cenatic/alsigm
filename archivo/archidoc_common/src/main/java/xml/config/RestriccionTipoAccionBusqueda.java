package xml.config;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;

/**
 * Clase que almacena la informaci�n de una restricci�n de un tipo de elemento de una acci�n de una b�squeda.
 */
public class RestriccionTipoAccionBusqueda extends XMLObject
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador de la acci�n
	 */
	private String id = null;

	/**
	 * Indica si se permite a no la restriccion
	 */
	private String permitido = null;

    /**
     * Constructor.
     */
    public RestriccionTipoAccionBusqueda()
    {
    	super();
    }

    /**
     * Devuelve el identificador de la restricci�n
	 * @return identificador de la restricci�n
	 */
	public String getId() {
		return id;
	}

	/**
     * Establece el identificador de la restricci�n
	 * @param id identificador de la restricci�n
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve si se permite la restriccion
	 * @return si se permite la restriccion
	 */
	public String getPermitido() {
		return permitido;
	}

	/**
	 * Establece si se permite la restriccion
	 * @param permitido si se permite la restriccion
	 */
	public void setPermitido(String permitido) {
		this.permitido = permitido;
	}

	/**
	 * Devuelve si se permite la restriccion
	 * @return si se permite la restriccion
	 */
	public boolean isRestriccionPermitida() {
		return ((permitido!=null) && (Constants.TRUE_STRING.equalsIgnoreCase(permitido)));
	}

	/**
	 * Obtiene una representaci�n XML del objeto.
	 * @param indent N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public String toXML(int indent)
	{
		final StringBuffer xml = new StringBuffer();
		final String tabs = StringUtils.repeat("  ", indent);

		xml.append(tabs + "<Restriccion");

		if ((id!=null) && (!"".equals(id))){
			xml.append(" id=\""+id+"\"");
		}

		xml.append(" permitido=\""+permitido+"\"");

		xml.append("/>").append(Constants.NEWLINE);

		return xml.toString();
	}
}
