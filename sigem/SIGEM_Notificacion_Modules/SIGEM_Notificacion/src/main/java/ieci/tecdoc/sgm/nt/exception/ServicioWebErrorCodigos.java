/**
 * @author Alvaro Ugarte G�mez
 * 
 * Fecha de Creaci�n: 22-jun-2004
 */

package ieci.tecdoc.sgm.nt.exception;

/**
 * C�digos de error de excepciones del Sistema de Archivo Digital.
 */

public final class ServicioWebErrorCodigos {

   private ServicioWebErrorCodigos() {

   }

   public static final long EC_PREFIX = 10002000;

   public static final long EC_SERVICE_FAILD = EC_PREFIX + 1;
   public static final long EC_CONNECT_FAILD = EC_PREFIX + 2;
   public static final long EC_UNKNOW_ERROR = EC_PREFIX + 3;
   public static final long EC_INVALID_DATA = EC_PREFIX + 4;
}
