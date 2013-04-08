package ieci.tecdoc.sgm.certificacion.datatype;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de elementos mime.
 * 
 * @author IECISA
 *
 */
public class Certificaciones implements Serializable
{
   private ArrayList certificaciones;

   public Certificaciones()
   {
	   certificaciones = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de certificaciones de la colecci�n.
    * @return int N�mero de certificaciones de la colecci�n.
    */   
   public int count()
   {
      return certificaciones.size();
   }
   
   /**
    * Devuelve la certificacion de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n de la certificacion a recuperar.
    * @return Certificacion Certificacion de la posicion indicada.
    */   
   public Certificacion get(int index)
   {
      return (Certificacion)certificaciones.get(index);
   }
   /**
    * A�ade una nueva certificacion a la colecci�n.
    * @param certificacion Nueva certificacion a a�adir.
    */   
   public void add(Certificacion certificacion) 
   {
	   certificaciones.add(certificacion);
   }
   
   /**
    * Devuelve una cadena XML con los datos de las certificaciones de la colecci�n.
    * @param headline Indica si el XML debe llevar cabecera.
    * @return String Cadena XML con los datos de los mime types.
    */   
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Certificaciones";
      Certificacion certificacion;
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
    	  certificacion = get(i);

         bdr.addFragment(certificacion.toXML(false));
      }

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

   /**
    * Devuelve una cadena con los datos de las certificaciones asociados a registro de la colecci�n.
    * @return String Cadena XML con los datos de las certificaciones.
    */
    public String toString()
    {
      return toXML(false);
   }
    
}