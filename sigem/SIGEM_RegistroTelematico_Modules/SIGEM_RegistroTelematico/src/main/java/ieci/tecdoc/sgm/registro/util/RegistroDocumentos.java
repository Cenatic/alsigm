package ieci.tecdoc.sgm.registro.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de documentos asociados a un registro.
 * 
 * @author IECISA
 *
 */
public class RegistroDocumentos implements Serializable
{
   private ArrayList registryDocuments;

   /**
    * Constructor de la clase RegistoDocumentos
    *
    */
   public RegistroDocumentos()
   {
     registryDocuments = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos de la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return registryDocuments.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n del documento a recuperar.
    * @return Document Documento asociado a registro.
    */   
   public RegistroDocumento get(int index)
   {
      return (RegistroDocumento)registryDocuments.get(index);
   }
   /**
    * A�ade un nuevo documento a la colecci�n.
    * @param document Nuevo documento a a�adir.
    */   
   public void add(RegistroDocumento document) 
   {
     registryDocuments.add(document);
   }
   
   /**
    * Devuelve una cadena XML con los datos de los documentos de la colecci�n.
    * @param headline Indica si el XML debe llevar cabecera.
    * @return String Cadena XML con los datos de los documentos.
    */   
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Documentss";
      RegistroDocumento document;
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         document = get(i);

         bdr.addFragment(document.toXML(false));
      }

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

   /**
    * Devuelve una cadena con los datos de los documentos asociados a registro de la colecci�n.
    * @return String Cadena XML con los datos de los documentos.
    */
    public String toString()
    {
      return toXML(false);
    }
    
}
    
