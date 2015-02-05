package xml.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;

/**
 * Clase que almacena la informaci�n de una acci�n de una b�squeda.
 */
public class AccionBusqueda extends XMLObject
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
	 * Permisos necesarios para que se muestre la acci�n en la lista de acciones.
	 */
	private String permisos;

	/**
     * Map de tipos permitidos
     */
    private Map mapTiposPermitidos = new HashMap();


    /**
     * Constructor.
     */
    public AccionBusqueda()
    {
    	super();
    }

    /**
     * Devuelve el identificador de la acci�n
	 * @return identificador de la acci�n
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador de la acci�n
	 * @param id identificador de la acci�n
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
     * Permite a�adir un tipo permitido a la acci�n de b�squeda
     * @param tipoAccionBusqueda tipo a a�adir
     */
    public void addTipoPermitido(TipoAccionBusqueda tipoAccionBusqueda) {
		if (tipoAccionBusqueda != null){
			this.mapTiposPermitidos.put(tipoAccionBusqueda.getId(),tipoAccionBusqueda);
		}
    }

	/**
	 * Map con los tipos permitidos para la acci�n actual
	 * @return Map con los tipos permitidos para la acci�n actual
	 */
	public Map getMapTiposPermitidos() {
		return mapTiposPermitidos;
	}

	/**
	 * Devuelve un tipo permitido para una acci�n
	 * @return tipo permitido para una acci�n {@link TipoAccionBusqueda}
	 */
	public TipoAccionBusqueda getTipoPermitido(String id) {
		TipoAccionBusqueda tipoAccionBusqueda = null;
		if ((mapTiposPermitidos!=null)&&(StringUtils.isNotEmpty(id))){
			tipoAccionBusqueda = (TipoAccionBusqueda) mapTiposPermitidos.get(id);
		}
		return tipoAccionBusqueda;
	}

	/**
	 * Establece los tipos permitidos para la acci�n actual
	 * @param mapTiposPermitidos tipos permitidos para la acci�n actual
	 */
	public void setMapTiposPermitidos(Map mapTiposPermitidos) {
		this.mapTiposPermitidos = mapTiposPermitidos;
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

		xml.append(tabs + "<Accion");

		if ((id!=null) && (!"".equals(id))){
			xml.append(" id=\""+id+"\"");
		}

		xml.append(">").append(Constants.NEWLINE);

	    /* Campos de entrada */
	    if ((mapTiposPermitidos!=null)&&(!mapTiposPermitidos.isEmpty())){
	    	xml.append(tabs + "  <Tipos_permitidos>");
	    	xml.append(Constants.NEWLINE);

	    	String key = null;
	    	TipoAccionBusqueda tipoAccionBusqueda = null;
	    	Iterator it = mapTiposPermitidos.keySet().iterator();
	    	while (it.hasNext()){
	    		key = (String) it.next();
	    		tipoAccionBusqueda = (TipoAccionBusqueda) mapTiposPermitidos.get(key);
	    		xml.append(tipoAccionBusqueda.toXML(indent+2));
	    	}
	    	xml.append(tabs + "  </Tipos_permitidos>");
	    	xml.append(Constants.NEWLINE);
	    }

	    xml.append(tabs + "</Accion>");
	    xml.append(Constants.NEWLINE);

		return xml.toString();
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public String getPermisos() {
		return permisos;
	}

}
