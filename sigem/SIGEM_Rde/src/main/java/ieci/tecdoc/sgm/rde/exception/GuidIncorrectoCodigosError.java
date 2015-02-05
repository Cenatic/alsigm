/**
 * @author Alvaro Ugarte G�mez
 * 
 * Fecha de Creaci�n: 22-jun-2004
 */

package ieci.tecdoc.sgm.rde.exception;

/**
 * C�digos de error de excepciones del Sistema de Archivo Digital.
 */

public final class GuidIncorrectoCodigosError {

   private GuidIncorrectoCodigosError() {

   }

   /**
    * C�digo base para los errores asociados a la exception GuidIncorrecto
    */
   public static final long EC_PREFIX = 10006000;

   /**
    * Error si el Guid no es correcto
    */
   public static final long EC_INCORRECT_GUID = EC_PREFIX + 1;
}