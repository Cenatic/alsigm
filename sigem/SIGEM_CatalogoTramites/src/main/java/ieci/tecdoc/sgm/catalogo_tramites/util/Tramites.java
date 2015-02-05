package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Colecci�n de procedimientos.
 * 
 * @author IECISA
 *
 */
public class Tramites implements Serializable
{
   private ArrayList procedures;

   public Tramites()
   {
      procedures = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de procedimientos de la colecci�n.
    * @return int N�mero de procedimientos.
    */   
   public int count()
   {
      return procedures.size();
   }
   
   /**
    * Recupera el procedimiento de la posici�n indicada.
    * @param index Posici�n del procedimiento a recuperar.
    * @return Procedure Procedimiento.
    */   
   public Tramite get(int index)
   {
      return (Tramite)procedures.get(index);
   }
   
   /**
    * A�ade un nuevo procedimiento a la colecci�n.
    * @param procedure Nuevo procedimiento a a�adir.
    */   
   public void add(Tramite procedure) 
   {
      procedures.add(procedure);
   }
   
   /**
    * Devuelve una cadena XML con la informaci�n de los procedimientos de la colecci�n.
    * @param headline Indica si el XML debe llevar cabecera.
    * @return String Cadena XML
    */   
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Procedures";
      Tramite procedure;
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         procedure = get(i);

         bdr.addFragment(procedure.toXML(false));
      }

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

   /**
    * Devuelve una cadena con la informaci�n de los procedimientos de la colecci�n.
    * @return String Cadena XML con la informaci�n.
    */
	public String toString()
	{
      return toXML(false);
   }
   
}