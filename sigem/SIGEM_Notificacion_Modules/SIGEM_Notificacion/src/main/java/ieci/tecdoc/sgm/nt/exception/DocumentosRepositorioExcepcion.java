/**
 * @author Alvaro Ugarte G�mez
 * 
 * Fecha de Creaci�n: 22-jun-2004
 */

package ieci.tecdoc.sgm.nt.exception;

/**
 * Excepci�n lanzada cuando se produce un error en el Sistema de Archivo
 * Digital rese�able. <br><br>Adem�s de la informaci�n contenida en todos los
 * objetos Exception (message, cause y stack trace), cada instancia de esta
 * clase contiene tambi�n un c�digo de error.
 */

public class DocumentosRepositorioExcepcion extends SgmException {

   /**
    * Construye un objeto de la clase.
    * 
    * @param errorCode
    *           C�digo de error.
    */

   public DocumentosRepositorioExcepcion(long errorCode) {
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

   public DocumentosRepositorioExcepcion(long errorCode, Throwable cause) {
      super(errorCode, cause);
   }

   public String getMessagesFile() {
      return RESOURCE_FILE;
   }

   private static String RESOURCE_FILE = "ieci.tecdoc.sgm.nt.resources.error";
   
}
