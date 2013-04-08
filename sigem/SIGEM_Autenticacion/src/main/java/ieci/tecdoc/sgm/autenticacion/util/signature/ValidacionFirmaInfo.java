package ieci.tecdoc.sgm.autenticacion.util.signature;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.security.cert.X509Certificate;

/**
 * Clase que encapsula la informaci�n asociada al resultado de la validaci�n de una firma.
 * 
 * @author IECISA
 *
 */
public class ValidacionFirmaInfo implements Serializable {

   private X509Certificate certificate;

   /**
    * M�todo que establece el certificado de la firma.
    * 
    * @param certificate
    */
   public void setCertificate(X509Certificate certificate)
   {
      this.certificate = certificate;
   }
   
   /** 
    * M�todo que obtiene el certificado de una firma.
    * @return X509Certificate
    */
   public X509Certificate getCertificate()
   {
      return certificate;
   }
   
   /**
    * M�todo que obtiene una cadena XML con la informaci�n de la validaci�n.
    * @param header Establece si el XML deber� llevar cabecera.
    * @return String XML con la informaci�n.
    */   
   public String toXML(boolean header) 
   {
      XmlTextBuilder bdr;
      String tagName = "Certificate";

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addSimpleElement(tagName, "<![CDATA[" + certificate.toString() + "]]>");

      return bdr.getText();
   }
   
   /**
    * 
    * @return
    */
   public String toString() 
   {
      return null;
   }
   
}

