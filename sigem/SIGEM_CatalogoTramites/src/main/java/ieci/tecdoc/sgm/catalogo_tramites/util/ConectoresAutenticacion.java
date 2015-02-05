package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Contenedor de conectores de autenticaci�n.
 * 
 * @author IECISA
 *
 */
public class ConectoresAutenticacion implements Serializable
{
   private ArrayList conectoresAutenticacion;

   public ConectoresAutenticacion()
   {
	   conectoresAutenticacion = new ArrayList();
   }

   /**
    * Devuelve el n�mero de conectores de autenticaci�n de la colecci�n
    * @return
    */
   public int count() {
      return conectoresAutenticacion.size();
   }

   /**
    * Devuelve el conector de autenticaci�n que se encuentra 
    * en la posici�n indicada.
    * @param index Posici�n del conector de autenticaci�n dentro de la colecci�n.
    * @return ConectorAutenticacion Conector de autenticaci�n.
    */
   public ConectorAutenticacion get(int index) {
      return (ConectorAutenticacion) conectoresAutenticacion.get(index);
   }

   /**
    * A�ade un nuevo conector de autenticaci�n a la colecci�n
    * @param document Nuevo conector de autenticaci�n a a�adir.
    */
   public void add(ConectorAutenticacion conectorAutenticacion) {
	   conectoresAutenticacion.add(conectorAutenticacion);
   }
   
   /**
    * Devuelve una cadena XML con la informaci�n de los conectores de 
    * autenticaci�n contenidos en la colecci�n.
    * @param header Establece si el XML debe llevar cabecera.
    * @return String XML con la informaci�n.
    */   
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Catalogo_ConectorAutenticacion";
      ConectorAutenticacion conectorAutenticacion;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++) {
    	 conectorAutenticacion = get(i);
         bdr.addFragment(conectorAutenticacion.toXML(false));
      }

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

   /**
    * Devuelve la informaci�n de los documentos contenidos en la colecci�n.
    * @return String Cadena XML con la informaci�n de los documentos.
    */
   public String toString() {
      return toXML(false);
   }
}