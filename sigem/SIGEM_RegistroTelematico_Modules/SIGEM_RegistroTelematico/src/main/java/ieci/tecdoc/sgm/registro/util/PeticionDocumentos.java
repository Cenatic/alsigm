package ieci.tecdoc.sgm.registro.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de documentos adjuntos a la solicitud de registro.
 * 
 * @author IECISA
 *
 */
public class PeticionDocumentos implements Serializable 
{
   private ArrayList documents;

   public PeticionDocumentos()
   {
      documents = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos contenidos en la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return documents.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada.
    * @param index Posici�n del documento dentro de la colecci�n.
    * @return RequestDocument Documento solicitado.
    */   
   public PeticionDocumento get(int index)
   {
      return (PeticionDocumento)documents.get(index);
   }
   
   /**
    * A�ade un nuevo documento adjunto a la solicitud de registro a la colecci�n.
    * @param document Nuevo documento a a�adir a la colecci�n.
    */   
   public void add(PeticionDocumento document) 
   {
      documents.add(document);
   }
   
   /**
    * Devuelve una cadena XMl con los datos de los documentos adjuntos a la solicitud de
    * registro contenidos en la colecci�n.
    * @param headline Indica si el XMl debe lleva cabecera.
    * @return String Cadena XML con los datos de los documentos.
    */   
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Documentos_Solicitud";
      String tagName1 = "Documento";
      PeticionDocumento document;
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         document = get(i);

         bdr.addOpeningTag(tagName1);
         bdr.addFragment(document.toXML(false));
         bdr.addClosingTag(tagName1);
      }

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

   /**
    * Devuelve una cadena con los datos de los documentos de la colecci�n.
    * @return String Cadena XML con los datos de los documentos de la colecci�n.
    */
	public String toString()
	{
      return toXML(false);
   }
    
}