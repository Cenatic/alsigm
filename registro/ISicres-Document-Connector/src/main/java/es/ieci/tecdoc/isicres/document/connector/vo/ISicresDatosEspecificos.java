package es.ieci.tecdoc.isicres.document.connector.vo;
/** 
 * @author Iecisa 
 * @version $$Revision$$ 
 * 
 * ${tags} 
 */ 


/**
 *Intefaz que servir� para almacenar datos especificos necesarios a usar en la implementaci�n concreta del gestor documental
 *
 */
public interface ISicresDatosEspecificos {
	
	public String toXml();
	public void fromXml(String xml);

}
