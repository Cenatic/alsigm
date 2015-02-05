package ieci.tecdoc.sgm.autenticacion.util;

import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoAutenticacionX509Info;

import java.security.cert.X509Certificate;

public interface AutenticacionCertificado 
{
   /**
    * Verifica un certificado (validez, revocaci�n). 
    * 
    * @param additionalInfo Informaci�n adicional (en formato xml). Normalmente 
    * se utilizar� si se quiere comprobar pol�ticas.
    * @return La informaci�n necesaria extra�da del certificado y si es v�lido.
    * @throws java.lang.Exception Si se produce alg�n error.
    */
   public CertificadoAutenticacionX509Info verifyCertificate(X509Certificate cert,
                              String additionalInfo)
                              throws Exception; 

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
                              throws Exception; 
}