/**
 * @author Javier Septien Arceredillo
 * 
 * Fecha de Creaci�n: 17-may-2007
 */

package ieci.tecdoc.sgm.ct.database.exception;

import ieci.tecdoc.sgm.ct.exception.SgmException;
/**
 * Excepci�n lanzada cuando se produce un error en el Sistema de Archivo
 * Digital rese�able. <br><br>Adem�s de la informaci�n contenida en todos los
 * objetos Exception (message, cause y stack trace), cada instancia de esta
 * clase contiene tambi�n un c�digo de error.
 */

public class DbException extends SgmException {

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error.
    */

   public DbException(long errorCode) {
      super(errorCode);
   }

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error.
    * @param cause
    *           Excepci�n que ha causado �sta.
    */

   public DbException(long errorCode, Throwable cause) {
      super(errorCode, cause);
   }

   public String getMessagesFile() {
      return RESOURCE_FILE;
   }

   private static String RESOURCE_FILE = "ieci.tecdoc.sgm.ct.resources.error";
   
}
