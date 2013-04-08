package ieci.tecdoc.sgm.certificacion.xml.bean;

import java.util.ArrayList;

/**
 * Clase que almacena los datos espec�ficos para la generaci�n del XML
 * @author Jos� Antonio Nogales
 */
public class DatosEspecificos {
	ArrayList datosEspecificos;

	/**
	 * Constructor de la clase
	 * @param datosEspecificos Objeto que almacena los datos espec�ficos
	 */
	public DatosEspecificos(ArrayList datosEspecificos) {
		this.datosEspecificos = datosEspecificos;
	}
	
	/**
	 * Constructor de la clase sin par�metros
	 */
	public DatosEspecificos() {
		this.datosEspecificos = null;
	}

	/**
	 * M�todos get y set de la clase
	 */
	public int getSize(){
		if (datosEspecificos != null)
			return datosEspecificos.size();
		return 0;
	}
	
	public ArrayList getDatosEspecificos() {
		return datosEspecificos;
	}

	public void setDatosEspecificos(ArrayList datosEspecificos) {
		this.datosEspecificos = datosEspecificos;
	}

	public Campo getDatoEspecifico(int index) {
		if (index < datosEspecificos.size())
			return (Campo)datosEspecificos.get(index);
		return null;
	}
	
	public void setDatoEspecifico(Campo datoEspecifico) {
		datosEspecificos.add(datoEspecifico);
	}
}
