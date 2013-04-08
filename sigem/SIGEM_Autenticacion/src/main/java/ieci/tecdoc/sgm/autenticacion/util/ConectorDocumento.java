
package ieci.tecdoc.sgm.autenticacion.util;

import java.io.InputStream;

import ieci.tecdoc.sgm.base.miscelanea.ClassLoader;

import java.lang.reflect.Method;


/**
 * Conector para la validaci�n de documentos.
 * 
 * @author IECISA
 *
 */
public class ConectorDocumento {
   
   public ConectorDocumento() {
   }

   /*
   public static boolean validate(String className, InputStream data) throws Exception {
   
      Class[] parameterTypes = new Class[] {InputStream.class};
      Method validate;
      Object[] arguments = new Object[] {data};
      Class objectClass;
      String output = null;
      boolean valid;
   
      objectClass = ClassLoader.getClass(className);

      validate = objectClass.getMethod("validate", parameterTypes);
      output = (String)validate.invoke(objectClass.newInstance(), arguments);
      if (output.compareTo("1") == 0)
         valid = true;
      else
         valid = false;

      return valid;
   }
    */
   
   /**
    * Valida un documento utilizando la clase que implementa la validaci�n. 
    * El nombre de la clase junto con el documento llegan como par�metro.
    * 
    * @param sessionId Identificador de sesi�n del usuario en el sistema.
    * @param className Clase que implementa la validaci�n.
    * @param data InputStream con el documento.
    * @param additionalInfo Informaci�n adicional.
    * @return Valor booleano que indica si la operaci�n se ha efectuado con �xito.
    * @throws java.lang.Exception Si se produce alg�n error.
    */   
   public static boolean validate(String sessionId, String className, InputStream data, String additionalInfo) throws Exception 
   {
      Class[] parameterTypes = new Class[] {InputStream.class, String.class};
      Method validate;
      Object[] arguments = new Object[] {data, additionalInfo};
      Class objectClass;
      String output = null;
      boolean valid;
      String res = "1";
   
      try
      {
         objectClass = ClassLoader.getClass(className);

         validate = objectClass.getMethod("validate", parameterTypes);
         output = (String)validate.invoke(objectClass.newInstance(), arguments);
         if (output.compareTo("1") == 0)
            valid = true;
         else
            valid = false;
      }
      catch(Exception exc)
      {
         res = "0";
         throw exc;
      }
      finally
      {
         //Log.setVerifyDocumentContent(sessionId, res, additionalInfo);
      }

      return valid;
   }
   
}
