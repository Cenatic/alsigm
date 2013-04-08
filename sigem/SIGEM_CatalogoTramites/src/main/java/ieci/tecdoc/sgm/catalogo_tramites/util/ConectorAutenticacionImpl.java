package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;


// import org.apache.log4j.Logger;
/**
 * Clase que almacena informaci�n que relacionada un tr�mite con un conector.
 */
public class ConectorAutenticacionImpl implements ConectorAutenticacion, Serializable {

   protected String tramiteId;
   protected String conectorId;

   /*
    * Constructor de la clase.
    */
   public ConectorAutenticacionImpl() {

   }

   /**
    * Obtienen el identificador de tr�mite
    * @return String Identificador de tr�mite.
    */
   public String getTramiteId() {
      return this.tramiteId;
   }

   /**
    * Obtienen el identificador del conector
    * @return String Identificador de conector.
    */
   public String getConectorId() {
      return this.conectorId;
   }

   /**
    * Establece el identificador del tr�mite
    * @param sessionId Identificador de tr�mite.
    */
   public void setTramiteId(String tramiteId) {
      this.tramiteId = tramiteId;
   }

   /**
    * Establece el identificador del conector
    * @param hookId Identificador de conector.
    */
   public void setConectorId(String conectorId) {
      this.conectorId = conectorId;
   }

   /**
    * Recoge los valores de la instancia en una cadena xml
    * @param header Si se incluye la cabecera
    * @return los datos en formato xml
    */
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Log de operaci�n";

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      bdr.addSimpleElement("Id_tr�mite", tramiteId);
      bdr.addSimpleElement("Id_Conector", conectorId);

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }


   /**
    * Devuelve los valores de la instancia en una cadena de caracteres.
    * @return String Valores de la instancia
    */
   public String toString() {
      return toXML(false);
   }

}