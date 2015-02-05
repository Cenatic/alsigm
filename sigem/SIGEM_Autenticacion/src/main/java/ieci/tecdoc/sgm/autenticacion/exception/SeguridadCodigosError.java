
package ieci.tecdoc.sgm.autenticacion.exception;

public class SeguridadCodigosError 
{
    /**
     * C�digo de error base.
     */
    private static final long EC_PREFIX = 1101000;

    /**
     * Error en la base de datos de sesiones.
     */
    public static final long EC_ERR_DB = EC_PREFIX + 1;
    
    
    /**
     * Error al crear la sesi�n.
     */
    public static final long EC_ADD_SESSION_INFO = EC_PREFIX + 2;
    
    /**
     * Error al eliminar la sesi�n.
     */
    public static final long EC_DELETE_SESSION_INFO = EC_PREFIX + 3;
    
    /**
     * Error al recuperar informaci�n de la sesi�n.
     */
    public static final long EC_GET_SESSION_INFO = EC_PREFIX + 4;
    
    /**
     * Error al generar el hash.
     */
    public static final long EC_HASH = EC_PREFIX + 5;
    
    /**
     * Error al firmar.
     */
    public static final long EC_SIGN = EC_PREFIX + 6;
    
    /**
     * La sesi�n no existe.
     */
    public static final long EC_BAD_SESSION = EC_PREFIX + 7;

    /**
     * No se ha podido leer el certificado.
     */
    public static final long EC_GET_CERTIFICATE = EC_PREFIX + 8;

    /**
     * Error al cifrar datos.
     */
    public static final long EC_ENCRYPT = EC_PREFIX + 9;

    /**
     * Error al descifrar datos.
     */
    public static final long EC_DECRYPT = EC_PREFIX + 10;

    /**
     * No se ha podido obtener la informaci�n de autenticaci�n.
     */
    public static final long EC_GET_AUTH_INFO = EC_PREFIX + 11;

    /**
     * No se ha podido acceder al sistema.
     */
    public static final long EC_BAD_LOGIN = EC_PREFIX + 12;

    /**
     * Las credenciales de acceso no son v�lidas.
     */
    public static final long EC_INVALID_CREDENTIALS = EC_PREFIX + 13;

    /**
     * No se ha podido desconectar del sistema.
     */
    public static final long EC_BAD_LOGOUT = EC_PREFIX + 14;

    /**
     * No se puede recuperar la informaci�n de autenticaci�n del usuario en esta sesi�n.
     */
    public static final long EC_GET_HOOK_INFO = EC_PREFIX + 15;

    /**
     * Error de configuraci�n.
     */
    public static final long EC_CONFIG = EC_PREFIX + 16;

    /**
     * Error en el registro de acci�n en el log.
     */
    public static final long EC_LOG = EC_PREFIX + 17;

    /**
     * Error al verificar firma.
     */
    public static final long EC_VERIFY_SIGN = EC_PREFIX + 18;
    
    /**
     * Error al verificar documento.
     */
    public static final long EC_VALIDATE_DOC = EC_PREFIX + 19;
    
    /**
     * No se puede acceder al componente de autenticaci�n y firma.
     */
    public static final long EC_CREATE_AUTH = EC_PREFIX + 20;
    
    /**
     * No se puede acceder al componente de sesi�n.
     */
    public static final long EC_CREATE_SESSION = EC_PREFIX + 21;

    /**
     * No se puede acceder al componente de criptograf�a.
     */
    public static final long EC_CREATE_CRYPTO = EC_PREFIX + 22;

    /**
     * No se puede recuperar el documento sin la firma.
     */
    public static final long EC_GET_DOCUMENT_SIGN = EC_PREFIX + 23;

    /**
     * Error en el servicio de validaci�n de CATCert.
     */
    public static final long EC_CATCERT = EC_PREFIX + 24;

    /**
     * Error del sistema de validaci�n (InternalError,UnrecognizedToken).
     */
    public static final long EC_CATCERT_VALIDATION = EC_PREFIX + 25;

    /**
     * Error en el formato de la petici�n (RequestError).
     */
    public static final long EC_CATCERT_REQUEST = EC_PREFIX + 26;
   
}    

