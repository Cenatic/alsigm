package ieci.tecdoc.sgm.rde.datatypes;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de documentos temporales asociados a un registro.
 * 
 * @author IECISA
 *
 */
public class DocumentosTemporales implements Serializable
{
   private ArrayList documentTmps;

   public DocumentosTemporales()
   {
     documentTmps = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos de la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return documentTmps.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada dentro de la colecci�n
    * @param index Posici�n del documento a recuperar.
    * @return Document Documento asociado a registro.
    */   
   public DocumentoTemporal get(int index)
   {
      return (DocumentoTemporal)documentTmps.get(index);
   }
   /**
    * A�ade un nuevo documento a la colecci�n.
    * @param document Nuevo documento a a�adir.
    */   
   public void add(DocumentoTemporal documentTmp) 
   {
     documentTmps.add(documentTmp);
   }
   
   /**
    * Devuelve una cadena XML con los datos de los documentos de la colecci�n.
    * @param headline Indica si el XML debe llevar cabecera.
    * @return String Cadena XML con los datos de los documentos.
    */   
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "DocumentTmps";
      DocumentoTemporal documentTmp;
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         documentTmp = get(i);

         bdr.addFragment(documentTmp.toXML(false));
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
    
