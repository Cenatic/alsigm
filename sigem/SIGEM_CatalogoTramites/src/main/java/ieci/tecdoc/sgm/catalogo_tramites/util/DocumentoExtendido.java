package ieci.tecdoc.sgm.catalogo_tramites.util;
import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

/**
 * Especializaci�n de un documento para su inclusi�n en un procedimiento.
 * 
 * @author IECISA
 *
 */
public class DocumentoExtendido extends DocumentoImpl 
{
	/**
	 * Constructor de la clase DocumentoExtendido
	 *
	 */
   public DocumentoExtendido()
   {
      code = null;
      mandatory = false;
   }
   
   /**
    * Constructor de la clase DocumentoExtendido a partir de un objeto Documento
    * @param document Datos de inicializaci�n
    */
   public DocumentoExtendido(Documento document) {
      this.setId(document.getId());
      this.setDescription(document.getDescription());
      this.setExtension(document.getExtension());
      this.setSignatureHook(document.getSignatureHook());
      this.setValidationHook(document.getValidationHook());
      code = null;
      mandatory = false;
   }
   
   /**
    * Establece el c�digo del documento.
    * @param code C�digo del documento.
    */   
   public void setCode(String code)
   {
      this.code = code;
   }
   
   /**
    * Establece la obligatoriedad del documento.
    * @param mandatory Obligatoriedad.
    */   
   public void setMandatory(boolean mandatory)
   {
      this.mandatory = mandatory;
   }

   /**
    * Recupera el c�digo del documento.
    * @return String C�digo de documento.
    */
   public String getCode()
   {
      return code;      
   }
   
   /**
    * Indica la obligatoriedad de un documento.
    * @return boolean Obligatoriedad.
    */   
   public boolean isMandatory()
   {
      return mandatory;
   }

    /**
    * M�todo que devuelve una cadena XML con la informaci�n del documento.
    * @param header Indica si el XML debe llevar cabecera.
    * @return String Cadena XML con la informaci�n del documento.
    */
    public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Catalogo_DocumentoExt";
      String tmp;

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);
      bdr.addFragment(super.toXML(header));
      if (mandatory)
         tmp = "1";
      else
         tmp = "0";
      bdr.addSimpleElement("Code", code);
      bdr.addSimpleElement("Mandatory", tmp);
      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

    /**
     * Devuelve una cadena con la informaci�n del documento.
     * @return String Cadena XML con la informaci�n del documento.
     */
   public String toString() {
      return toXML(false);
   }
  
   protected String code;
   protected boolean mandatory;
}