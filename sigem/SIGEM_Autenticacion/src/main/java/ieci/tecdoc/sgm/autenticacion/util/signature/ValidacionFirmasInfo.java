package ieci.tecdoc.sgm.autenticacion.util.signature;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;

import java.util.ArrayList;

/**
 * Clase que encapsula la informaci�n resultante de la validaci�n de una firma digital.
 * 
 * @author IECISA
 *
 */
public class ValidacionFirmasInfo implements Serializable {

   private ArrayList signaturesValidation;
   private boolean valid;

   public ValidacionFirmasInfo() {
      signaturesValidation = new ArrayList();
   }
   
   /**
    * Retorna true si la firma es v�lida.
    * @return boolean
    */   
   public boolean isValid()
   {
      return valid;
   }
   
   /**
    * Establece la validez de una firma
    * @param valid
    */   
   public void setValid(boolean valid)
   {
      this.valid = valid;
   }
   
   /**
    * 
    * @param signatureValidationInfo
    */
   public void add(ValidacionFirmaInfo signatureValidationInfo) 
   {
      signaturesValidation.add(signatureValidationInfo);
   }
   
   /**
    * 
    * @return
    */
   public int count() 
   {
      return signaturesValidation.size();
   }
   
   /**
    * 
    * @param index
    * @return
    */
   public ValidacionFirmaInfo get(int index) 
   {
      return (ValidacionFirmaInfo)signaturesValidation.get(index);
   }
   
   /**
    * M�todo que obtiene un XML con la informaci�n de la clase.
    * @param headline
    * @return String XML con la informaci�n de la clase.
    */
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Signature_Certificates";
      ValidacionFirmaInfo signatureValidationInfo;
    
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      for (int i = 0; i < count(); i++)
      {
         signatureValidationInfo = get(i);
         bdr.addFragment(signatureValidationInfo.toXML(false));
      }

      bdr.addClosingTag(tagName);
    
      return bdr.getText();
    }
   
   /**
    * 
    * @return
    */
   public String toString() 
   {
      return toXML(false);
   }
}