package ieci.tecdoc.sgm.autenticacion.util.hook;

import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoAutenticacionX509Info;
import ieci.tecdoc.sgm.base.miscelanea.Goodies;

import java.security.cert.X509Certificate;

public class FNMTCertificate
{
   public FNMTCertificate()
   {
   }
   
   /**
    * Verifica un certificado (validez, revocaci�n). 
    * 
    * @param additionalInfo Informaci�n adicional (en formato xml). Normalmente 
    * se utilizar� si se quiere comprobar pol�ticas.
    * @return La informaci�n necesaria extra�da del certificado y si es v�lido.
    * @throws java.lang.Exception Si se produce alg�n error.
    */
   public CertificadoAutenticacionX509Info verifyCertificate(X509Certificate cert)
                              throws Exception
   {
      CertificadoAutenticacionX509Info certInfo = new CertificadoAutenticacionX509Info();
      String issuer, subject;
      int pos, pos1, pos2;
      
      issuer = cert.getIssuerDN().getName();
      if (issuer.compareTo(ISSUER) == 0)
      {
         certInfo.setValid(true);

         subject = cert.getSubjectDN().getName();
         
         pos = subject.indexOf("- NIF");
         pos1 = subject.indexOf(", OU=");
         String name = subject.substring(10, pos-1);
         pos2 = name.lastIndexOf(" ");
         certInfo.setName(name.substring(pos2, name.length()) + " " + name.substring(0, pos2));
         //certInfo.setSurName(name.substring(0, pos2));
         certInfo.setNIF(subject.substring(pos+6, pos1));
         certInfo.setCIF(subject.substring(pos+6, pos1));
         certInfo.setSerialNumber(Goodies.certGuion(cert.getSerialNumber().toString(16).toUpperCase()));
         certInfo.setIssuer(issuer.replaceAll("ST=", "S="));
      }
      
      return certInfo;
   }
   
   
   /**
    * Verifica un certificado (validez, revocaci�n). 
    * 
    * @param info Informaci�n asociada a un conector (en formato xml). Esta
    * informaci�n se utiliza siempre que est� implicado este conector.
    * @param additionalInfo Informaci�n adicional (en formato xml). Normalmente 
    * se utilizar� si se quiere comprobar pol�ticas. Esta informaci�n est�
    * asociada a una autenticaci�n concreta.
    * @return La informaci�n necesaria extra�da del certificado y si es v�lido.
    * @throws java.lang.Exception Si se produce alg�n error.
    */
   public CertificadoAutenticacionX509Info verifyCertificate(X509Certificate cert,
                              String info, String additionalInfo)
                              throws Exception
   {
     return null;//verifyCertificate(cert, info);
   }
   
   private static final String ISSUER = "OU=FNMT Clase 2 CA, O=FNMT, C=ES";
}