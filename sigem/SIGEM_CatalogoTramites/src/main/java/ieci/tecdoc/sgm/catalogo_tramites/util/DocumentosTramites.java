package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de documentos asociados a un tr�mite.
 * 
 * @author IECISA
 *
 */
public class DocumentosTramites implements Serializable {
   private ArrayList documents;

   public DocumentosTramites() {
      documents = new ArrayList();
   }

   /**
    * Devuelve el n�mero de procedimientos de la colecci�n.
    * @return int N�mero de procedimientos.
    */
   public int count() {
      return documents.size();
   }

   /**
    * Recupera el procedimiento de la posici�n indicada.
    * @param index Posici�n dentro de la colecci�n.
    * @return ProcedureDocumento Documento de procedimiento.
    */
   public DocumentoTramite get(int index) {
      return (DocumentoTramite) documents.get(index);
   }

   /**
    * A�ade un nuevo documento a la colecci�n.
    * @param document Nuevo documento a a�adir.
    */
   public void add(DocumentoTramite document) {
      documents.add(document);
   }

   /**
    * Devuelve una cadena XML con la informaci�n de los documentos de la colecci�n.
    * @param header Establece si el XMl debe llevar cabecera.
    * @return String Cadena XMl con la informaci�n.
    */
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Procedure_Documents";
      DocumentoTramite document;

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
    * Devuelve una cadena con la informaci�n de los documentos de la colecci�n.
    * @return String Cadena XML con la informaci�n.
    */
   public String toString() {
      return toXML(false);
   }

}