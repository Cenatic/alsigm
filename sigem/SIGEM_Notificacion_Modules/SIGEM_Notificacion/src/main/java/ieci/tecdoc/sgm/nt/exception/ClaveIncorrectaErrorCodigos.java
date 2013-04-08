/**
 * @author Alvaro Ugarte G�mez
 * 
 * Fecha de Creaci�n: 22-jun-2004
 */

package ieci.tecdoc.sgm.nt.exception;

/**
 * C�digos de error de excepciones del Sistema de Archivo Digital.
 */

public final class ClaveIncorrectaErrorCodigos {

   private ClaveIncorrectaErrorCodigos() {

   }

   public static final long EC_PREFIX = 10006000;

   public static final long EC_INCORRECT_GUID = EC_PREFIX + 1;
}
