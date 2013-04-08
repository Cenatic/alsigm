package ieci.tecdoc.sgm.autenticacion.util;


import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoFirmaX509Info;
import ieci.tecdoc.sgm.autenticacion.util.signature.ValidacionFirmasInfo;
import ieci.tecdoc.sgm.autenticacion.vo.ReceiptVO;
import ieci.tecdoc.sgm.base.miscelanea.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Conector para el manejo de firmas.
 * 
 * @author IECISA
 *
 */
public class ConectorFirma 
{
   public ConectorFirma()
   {
   }

   /**
    * M�todo de firma. Recibe como par�metro un inputStream con los datos y utiliza la clase
    * que le llega como par�metro para firmar usando el ceritificado y, si es necesaria, la informaci�n
    * adicional.
    * @param sessionId Identificador de sessi�n. Utilizado para el log de la operaci�n.
    * @param className Nombre de la clase que implementa la l�gica de la firma.
    * @param data Datos a firmar.
    * @param additionalInfo Informaci�n adicional necesaria para la firma.
    * @param certificate Certicado que se usar� para la firma.
    * @return ByteArrayOutputStream Con los datos firmados.
    * @throws Exception Si se produce alg�n error.
    */
   public static ByteArrayOutputStream sign(String sessionId, String className, InputStream data, 
                  String additionalInfo, CertificadoFirmaX509Info certificate) throws Exception {
   
      Class[] parameterTypes = new Class[] {InputStream.class, String.class, CertificadoFirmaX509Info.class};
      Method sign;
      Object[] arguments = new Object[] {data, additionalInfo, certificate};
      Class objectClass;
      ByteArrayOutputStream output = null;
      String res = "1";

      try
      {
         objectClass = ClassLoader.getClass(className);

         sign = objectClass.getMethod("sign", parameterTypes);
         output = (ByteArrayOutputStream)sign.invoke(objectClass.newInstance(), arguments);
      }
      catch(Exception exc)
      {
         res = "0";
         throw exc;
      }
      finally
      {
         //Log.setSign(sessionId, res, additionalInfo, certificate.getCertificate());
      }
      
      return output;
   }

   /**
    * M�todo para la firma de un recibo de registro.
    * 
    * @param sessionId Identificador de sesi�n.
    * @param className Nombre de la clase que realizar� la firma.
    * @param data Datos del recibo a firmar.
    * @param request Cadena con la petici�n.
    * @param additionalInfo Informaci�n adicional que puede ser necesaria para la firma.
    * @param certificate Certicado que se utilizar� para la firma.
    * @return ByteArrayOutputStream Con el recibo firmado.
    * @throws Exception Si se produce alg�n error.
    */
   public static ReceiptVO signReceipt(String sessionId, String className, InputStream data, 
                  String request, String additionalInfo, CertificadoFirmaX509Info certificate) throws Exception {
   
      Class[] parameterTypes = new Class[] {InputStream.class, String.class, String.class, CertificadoFirmaX509Info.class};
      Method sign;
      Object[] arguments = new Object[] {data, request, additionalInfo, certificate};
      Class objectClass;
      ByteArrayOutputStream output = null;
      ReceiptVO receiptVO = null;
      String res = "1";

      try
      {
         objectClass = ClassLoader.getClass(className);

         sign = objectClass.getMethod("sign", parameterTypes);
         receiptVO = (ReceiptVO)sign.invoke(objectClass.newInstance(), arguments);
      }
      catch(Exception exc)
      {
         res = "0";
         throw exc;
      }
      finally
      {
         //Log.setSign(sessionId, res, additionalInfo, certificate.getCertificate());
      }
      
      return receiptVO;
   }

   /**
    * M�todo para la verificaci�n de una firma.
    * 
    * @param sessionId Identificador de sesi�n. 
    * @param className Nombre de la clase que realizar� la verificaci�n.
    * @param data Datos a verificar.
    * @param additionalInfo Informaci�n adicional que puede ser necesaria para la verificaci�n.
    * @return SignatruesValidationInfor Con la informaci�n resultante de la validaci�n.
    * @throws Exception En caso de producirse alg�n error.
    */
   public static ValidacionFirmasInfo verifySign(String sessionId, String className, InputStream data, 
                  String additionalInfo) throws Exception {
   
      Class[] parameterTypes = new Class[] {InputStream.class, String.class};
      Method verifySign;
      Object[] arguments = new Object[] {data, additionalInfo};
      Class objectClass;
      ValidacionFirmasInfo output = null;
      String res = "1";
   
      try
      {
         objectClass = ClassLoader.getClass(className);

         verifySign = objectClass.getMethod("verifySign", parameterTypes);
         output = (ValidacionFirmasInfo)verifySign.invoke(objectClass.newInstance(), arguments);
      }
      catch(Exception exc)
      {
         res = "0";
         throw exc;
      }
      finally
      {
         //Log.setVerifySignature(sessionId, res, additionalInfo);
      }

      return output;
   }

   /**
    * Obtiene el documento alojado dentro de un archivo de firma.
    * @param className Nombre de la clase encargada de obtener el documento.
    * @param data Datos del archivo de firma.
    * @param additionalInfo Informaci�n adicional que puede ser necesaria para la obtenci�n del documento.
    * @return ByteArrayOutputStream Con los datos del documento.
    * @throws Exception En caso de producirse alg�n error.
    */
   public static ByteArrayOutputStream getDocument(String className, InputStream data, String additionalInfo) throws Exception
   {
      Class[] parameterTypes = new Class[] {InputStream.class, String.class};
      Method getDocument;
      Object[] arguments = new Object[] {data, additionalInfo};
      Class objectClass;
      ByteArrayOutputStream output = null;
     
      objectClass = ClassLoader.getClass(className);

      getDocument = objectClass.getMethod("getDocument", parameterTypes);
      output = (ByteArrayOutputStream)getDocument.invoke(objectClass.newInstance(), arguments);
      
      return output;
   }

}