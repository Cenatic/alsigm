/**
 * @author Alvaro Ugarte G�mez
 * 
 * Fecha de Creaci�n: 22-jun-2004
 */

package ieci.tecdoc.sgm.rde.database.exception;

/**
 * C�digos de error de excepciones del Sistema de Archivo Digital.
 */

public final class DbCodigosError {

   private DbCodigosError() {

   }

   /**
    * C�digo base para los errores contenidos para DBExcepcion
    */
   public static final long EC_PREFIX = 10004000;
   /**
    * Error al obtener valores
    */
   public static final long EC_GET_ALL_VALUES = EC_PREFIX + 1;
   /**
    * Error al obtener los valores v�lidos de extensiones
    */
   public static final long EC_GET_EXTENSION_VALUES = EC_PREFIX + 2;
   /**
    * Error al insertar valores
    */
   public static final long EC_INSERT_ALL_VALUES = EC_PREFIX + 3;
   /**
    * Error, el tipo mime no se ha encontrado
    */
   public static final long EC_SELECT_BY_MIME_TYPE_NOT_FOUND = EC_PREFIX + 4;
   /**
    * Error al seleccionar datos por tipo mime
    */
   public static final long EC_SELECT_BY_MIME_TYPE_EXCEPTION = EC_PREFIX + 5;
   /**
    * Error al cargar datos porque la extensi�n no existe
    */
   public static final long EC_LOAD_MIME_TYPES_BY_EXTENSION_NOT_FOUND = EC_PREFIX + 6;
   /**
    * Error en la carga de tipo mime a partir de la extensi�n
    */
   public static final long EC_LOAD_MIME_TYPES_BY_EXTENSION_EXCEPTION = EC_PREFIX + 7;
   /**
    * Error al a�adir un nuevo valor
    */
   public static final long EC_ADD_VALUE = EC_PREFIX + 8;
   /**
    * Error al borrar valores
    */
   public static final long EC_DELETE_ALL_VALUES = EC_PREFIX + 9;
   /**
    * Error, guid no encontrado
    */
   public static final long EC_SELECT_BY_GUID_NOT_FOUND = EC_PREFIX + 10;
   /**
    * Error al consultar por Guid
    */
   public static final long EC_SELECT_BY_GUID_EXCEPTION = EC_PREFIX + 11;
   /**
    * Error al cerrar conexi�n
    */
   public static final long EC_CLOSE_CONNECTION = EC_PREFIX + 12;
   /**
    * Guid incorrecto
    */
   public static final long EC_INCORRECT_GUID = EC_PREFIX + 13;
   /**
    * Error al obtener un documento almacenado
    */
   public static final long EC_RETRIEVE_DOCUMENT = EC_PREFIX + 14;
}