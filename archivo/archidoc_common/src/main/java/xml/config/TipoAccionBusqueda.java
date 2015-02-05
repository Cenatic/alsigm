package xml.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;

/**
 * Clase que almacena la informaci�n de un tipo de elemento una acci�n de una b�squeda.
 */
public class TipoAccionBusqueda extends XMLObject
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
	 * Nombre de la acci�n a ejecutar
	 */
	private String forward = null;

    /**
     * Map de restricciones que debe cumplir el tipo de elemento
     */
    private Map mapRestricciones = new HashMap();


    /**
     * Constructor.
     */
    public TipoAccionBusqueda()
    {
    	super();
    }

    /**
     * Devuelve el identificador del tipo sobre el que se aplica la acci�n
	 * @return identificador del tipo sobre el que se aplica la acci�n
	 */
	public String getId() {
		return id;
	}

	/**
     * Establece el identificador del tipo sobre el que se aplica la acci�n
	 * @param id identificador del tipo sobre el que se aplica la acci�n
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Forward a ejecutar para el tipo actual
	 * @return Forward a ejecutar para el tipo actual
	 */
	public String getForward() {
		return forward;
	}

	/**
	 * Establece el forward a ejecutar para el tipo actual
	 * @param method Forward a ejecutar para el tipo actual
	 */
	public void setForward(String forward) {
		this.forward = forward;
	}

	/**
     * Permite a�adir una restricci�n
     * @param restriccion restricci�n a a�adir
     */
    public void addRestriccion(RestriccionTipoAccionBusqueda restriccion) {
		if (restriccion!=null)
			this.mapRestricciones.put(restriccion.getId(), restriccion);
    }

	/**
	 * Devuelve el map de restricciones
	 * @return map de restricciones
	 */
	public Map getMapRestricciones() {
		return mapRestricciones;
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

		xml.append(tabs + "<Tipo");

		if ((id!=null) && (!"".equals(id))){
			xml.append(" id=\""+id+"\"");
		}

		if ((forward!=null) && (!"".equals(forward))){
			xml.append(" forward=\""+forward+"\"");
		}

	    /* Campos de entrada */
	    if ((mapRestricciones!=null)&&(!mapRestricciones.isEmpty())){

	    	xml.append(">").append(Constants.NEWLINE);

	    	Iterator it = mapRestricciones.keySet().iterator();
	    	while (it.hasNext()){
	    		String key = (String) it.next();
	    		RestriccionTipoAccionBusqueda restriccion = (RestriccionTipoAccionBusqueda) mapRestricciones.get(key);
	    		xml.append(restriccion.toXML(indent+1));
	    	}
	    	xml.append(tabs).append("</Tipo>").append(Constants.NEWLINE);
	    } else {
	    	xml.append("/>").append(Constants.NEWLINE);
	    }

		return xml.toString();
	}
}
