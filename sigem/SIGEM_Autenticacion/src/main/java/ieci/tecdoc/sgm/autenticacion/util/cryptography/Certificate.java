package ieci.tecdoc.sgm.autenticacion.util.cryptography;
import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoFirmaX509Info;

/**
 * Interfaz de manejo de certificados.
 */

public interface Certificate 
{

   /**
    * Carga un certificado. 
    * 
    * @param path Ruta del certificado.
    * @param password Contrase�a del certificado.
    * @param moreInfo Informaci�n adicional (normalmente el alias del certificado.)
    * @return La informaci�n del certificado.
    * @throws java.lang.Exception Si se produce alg�n error.
    */
   public CertificadoFirmaX509Info loadCertificateInfo(String path, String password, 
                              String moreInfo) throws Exception; 
}