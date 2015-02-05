package ieci.tecdoc.sgm.certificacion.xml.bean;

import java.util.ArrayList;

/**
 * Clase que almacena los datos comunes para la generaci�n del XML
 * @author Jos� Antonio Nogales
 */
public class DatosComunes {
		ArrayList datosComunes;

		/** 
		 * Constructor de la clase
		 * @param datosComunes Objeto que almacena los datos comunes
		 */
		public DatosComunes(ArrayList datosComunes) {
			this.datosComunes = datosComunes;
		}
		
		/**
		 * Constructor de la clase sin par�metros
		 */
		public DatosComunes() {
			this.datosComunes = null;
		}

		/**
		 * M�todos get y set de la clase
		 */
		public int getSize(){
			if (datosComunes != null)
				return datosComunes.size();
			return 0;
		}
		
		public ArrayList getDatosComunes() {
			return datosComunes;
		}

		public void setDatosComunes(ArrayList datosComunes) {
			this.datosComunes = datosComunes;
		}

		public Campo getDatoComun(int index) {
			if (index < datosComunes.size())
				return (Campo)datosComunes.get(index);
			return null;
		}
		
		public void setDatoComun(Campo datoComun) {
			datosComunes.add(datoComun);
		}
}
