package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Contendor de documentos.
 * 
 * @author IECISA
 *
 */
public class Documentos implements Serializable
{
   private ArrayList documents;

   public Documentos()
   {
      documents = new ArrayList();
   }

   /**
    * Devuelve el n�mero de docuentos de la colecci�n
    * @return
    */
   public int count() {
      return documents.size();
   }

   /**
    * Devuelve el documento que se encuentra en la posici�n indicada.
    * @param index Posici�n del documento dentro de la colecci�n.
    * @return DocumentExt Documento.
    */
   public DocumentoExtendido get(int index) {
      return (DocumentoExtendido) documents.get(index);
   }

   /**
    * A�ade un nuevo documento a la colecci�n
    * @param document Nuevo documento a a�adir.
    */
   public void add(DocumentoExtendido document) {
      documents.add(document);
   }
   
   /**
    * Devuelve una cadena XML con la informaci�n de los documentos contenidos en la colecci�n.
    * @param header Establece si el XML debe llevar cabecera.
    * @return String XML con la informaci�n.
    */   
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Catalogo_Documentos";
      DocumentoExtendido document;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++) {
         document = get(i);
         bdr.addFragment(document.toXML(false));
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