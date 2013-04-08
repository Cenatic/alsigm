package ieci.tecdoc.sgm.registro.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

/**
 * Bean con las propiedades de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroDocumentoImpl implements RegistroDocumento 
{
   public RegistroDocumentoImpl()
   {
     registryNumber = null;
     code = null;
     guid = null;
   }
   
   /**
     * Devuelve el identificador �nico de documento.
     * @return String Identificador �nico de documento.
     */
   public String getGuid(){
     return guid;
   }
  
   /**
     * Establece identificador �nico de documento.
     * @param guid Identificador �nico de documento.
     */   
   public void setGuid(String guid){
     this.guid = guid;
   }
  
   /**
    * Devuelve el n�mero del registro al que pertenece el documento.
    * @return String Identificador �nico de documento.
    */
    public String getRegistryNumber(){
      return registryNumber;
    }
   
    /**
      * Establece el n�mero del registro al que pertenece el documento.
      * @param registryNumber Identificador �nico del registro.
      */   
    public void setRegistryNumber(String registryNumber){
      this.registryNumber = registryNumber;
    } 

    /**
     * Devuelve c�digo de documento.
     * @return String Identificador �nico de documento.
     */
   public String getCode(){
     return code;
   }
  
   /**
     * Establece c�digo de documento.
     * @param code Identificador �nico de documento.
     */   
   public void setCode(String code){
     this.code = code;
   }

   /**
    * Recoge los valores de la instancia en una cadena xml
    * @param header Si se incluye la cabecera
    * @return los datos en formato xml
    */   
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Document";

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);
      
      bdr.addSimpleElement("RegistryNumber", registryNumber);
      bdr.addSimpleElement("Code", code);
      bdr.addSimpleElement("Guid", guid);
      
      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

   /**
    * Devuelve los valores de la instancia en una cadena de caracteres.
    */
   public String toString() {
      return toXML(false);
   }

   protected String guid;
   protected String registryNumber;
   protected String code;

   
}