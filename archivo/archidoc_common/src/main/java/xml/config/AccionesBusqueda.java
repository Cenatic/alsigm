package xml.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import xml.config.AccionBusqueda;

import common.Constants;
import common.util.StringUtils;

/**
 * Clase con la definici�n de las posibles acciones de b�squeda
 */
public class AccionesBusqueda {

    /**
     * Lista de posibles acciones de b�squeda
     */
    private Map mapAccionesBusqueda = new HashMap();
    
	/**
	 * Permite obtener una instancia de la clase
	 * @return ConfigConstants Instancia de la clase
	 */
	public AccionesBusqueda(){
		super();
	}
	
	/**
     * Permite a�adir una nueva acci�n de b�squeda
     * @param accionBusqueda acci�n de b�squeda a a�adir
     */
    public void addAccionBusqueda(AccionBusqueda accionBusqueda) {
		if (accionBusqueda != null){
			this.mapAccionesBusqueda.put(accionBusqueda.getId(),accionBusqueda);
		}
    }
    
	/**
	 * Permite obtener una acci�n de b�squeda espec�fica
	 * @return Objeto {@link AccionBusqueda}}
	 */
	public AccionBusqueda getAccionBusqueda(String key) {
		AccionBusqueda accionBusqueda = null;
		if (mapAccionesBusqueda!=null)
			accionBusqueda = (AccionBusqueda) mapAccionesBusqueda.get(key);
		return accionBusqueda;
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

		xml.append(tabs + "<AccionesBusqueda>");
		xml.append(Constants.NEWLINE);
	    
	    /* Campos de entrada */
	    if ((mapAccionesBusqueda!=null)&&(!mapAccionesBusqueda.isEmpty())){
	    	
	    	AccionBusqueda accionBusqueda  = null;
	    	String key = null;
	    	Iterator it = mapAccionesBusqueda.keySet().iterator();
	    	while (it.hasNext()){
	    		key = (String) it.next();
	    		accionBusqueda = (AccionBusqueda) mapAccionesBusqueda.get(key);
	    		xml.append(accionBusqueda.toXML(1));
	    	}
	    }
	    
	    xml.append("</AccionesBusqueda>");
	    xml.append(Constants.NEWLINE);

		return xml.toString();
	}
	
	public String toString() {
		return this.toXML(0);
	}
	
}

