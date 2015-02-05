package ieci.tecdoc.sgm.registro.ws.server;

import ieci.tecdoc.sgm.core.services.ConstantesServicios;
import ieci.tecdoc.sgm.core.services.dto.RetornoServicio;

/**
 * Especializaci�n de un documento para su inclusi�n en un procedimiento.
 * 
 * @author IECISA
 *
 */
public class DocumentoExtendido extends RetornoServicio
{
	/**
	 * Constructor de la clase DocumentoExtendido
	 *
	 */
   public DocumentoExtendido()
   {
	   id = null;
	   description = null;
	   extension = null;
	   signatureHook = null;
	   validationHook = null;
	   code = null;
	   mandatory = ConstantesServicios.LABEL_FALSE;
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
      mandatory = ConstantesServicios.LABEL_FALSE;
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
   public void setMandatory(String mandatory)
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
   public String isMandatory()
   {
      return mandatory;
   }
   
   /**
    * Establece el identificador del documento.
    * @param String Identificador de documento.
    */   
   public void setId(String id)
   {
      this.id = id;
   }
   
   /**
    * Establece la descripci�n del documento.
    * @param description Descripci�n del documento.
    */   
   public void setDescription(String description)
   {
      this.description = description;
   }
   
   /**
    * Establece la extensi�n del documento.
    * @param extension Extensi�n del documento.
    */   
   public void setExtension(String extension)
   {
      this.extension = extension;
   }
   
   /**
    * Conector de firma para el documento.
    * @param signatureHook Identificador del conector para la firma del documento.
    */   
   public void setSignatureHook(String signatureHook)
   {
      this.signatureHook = signatureHook;
   }
   
   /**
    * Establece el conector para la validaci�n del contenido del documento.
    * @param validationHook Identificador del conector de validaci�n de contenido.
    */   
   public void setValidationHook(String validationHook)
   {
      this.validationHook = validationHook;
   }
   
   /**
    * Recupera el identificador del documento.
    * @return String identificador de documento.
    */   
   public String getId()
   {
      return id;
   }
   
   /**
    * Recupera la descripci�n del documento.
    * @return String descripci�n del documento.
    */   
   public String getDescription()
   {
      return description;
   }
   
   /**
    * Recupera la extensi�n del documento.
    * @return String Extensi�n del documento.
    */   
   public String getExtension()
   {
      return extension;
   }
   
   /**
    * Recupera el identificador del conexi�n de firma del documento.
    * @return String Identificador del conector de firma del documento.
    */   
   public String getSignatureHook()
   {
      return signatureHook;
   }

   /**
    * Recupera el identificador del conector de validaci�n de contenido.
    * @retunr String identificdor del conector de validaci�n.
    */
   public String getValidationHook()
   {
      return validationHook;
   }
  
   protected String code;
   protected String mandatory;
   protected String id;
   protected String description;
   protected String extension;
   protected String signatureHook;
   protected String validationHook;
}