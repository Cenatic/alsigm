/*
 * Created on 11-ago-2005
 * @autor IECI S.A.
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ieci.tecdoc.sgm.catalogo_tramites.exception;

/**
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CatalogoTramitesCodigosError
{

   /**
	* C�digo de error base.
	*/
   public static final long EC_PREFIX = 4001000;

   /**
    * Error en la base de datos de cat�logo de tr�mites.
    */
   public static final long EC_ERR_DB = EC_PREFIX + 1;

   /**
    * El identificador de tr�mite no es v�lido.
    */
   public static final long EC_BAD_PROCEDUREID = EC_PREFIX + 2;

   /**
    * El identificador de documento no es v�lido.
    */
   public static final long EC_BAD_DOCUMENTID = EC_PREFIX + 3;

    /**
     * Error al crear el documento.
     */
    public static final long EC_ADD_DOCUMENT = EC_PREFIX + 4;

    /**
     * Error al eliminar el documento.
     */
    public static final long EC_DELETE_DOCUMENT = EC_PREFIX + 5;

    /**
     * Error al recuperar la informaci�n del documento.
     */
    public static final long EC_GET_DOCUMENT = EC_PREFIX + 6;

    /**
     * Error al actualizar la informaci�n del documento.
     */
    public static final long EC_UPDATE_DOCUMENT = EC_PREFIX + 7;

    /**
     * Error al crear el tr�mite.
     */
    public static final long EC_ADD_PROCEDURE = EC_PREFIX + 8;

    /**
     * Error al eliminar el tr�mite.
     */
    public static final long EC_DELETE_PROCEDURE = EC_PREFIX + 9;

    /**
     * Error al recuperar la informaci�n del tr�mite.
     */
    public static final long EC_GET_PROCEDURE = EC_PREFIX + 10;

    /**
     * Error al actualizar la informaci�n del tr�mite.
     */
    public static final long EC_UPDATE_PROCEDURE = EC_PREFIX + 11;

    /**
     * El documento est� siendo utilizado en alg�n tr�mite. Debe eliminarlo en primer lugar de dicho tr�mite.
     */
    public static final long EC_DOCUMENT_USED = EC_PREFIX + 12;

    /**
     * Error al recuperar la lista de tr�mites.
     */
    public static final long EC_GET_PROCEDURES = EC_PREFIX + 13;

    /**
     * Error al recuperar la lista de tr�mites.
     */
    public static final long EC_GET_DOCUMENTS = EC_PREFIX + 14;

    /**
     * Error al recuperar un documento asociado a un tr�mite
     */
    public static final long EC_GET_PROCEDUREDOCUMENT = EC_PREFIX + 15;

    /**
     * Error, el identificador de tr�mite o el de documento no es v�lido
     */
    public static final long EC_BAD_PROCEDUREID_OR_DOCUMENTID = EC_PREFIX + 16;

    /**
     * Error al a�adir un documento asociado a un tr�mite
     */
    public static final long EC_ADD_PROCEDUREDOCUMENT = EC_PREFIX + 17;

    /**
     * Error al eliminar un documento asociado a un tr�mite
     */
    public static final long EC_DELETE_PROCEDUREDOCUMENT = EC_PREFIX + 18;

    /**
     * Error al actualizar un documento asociado a un tr�mite
     */
    public static final long EC_UPDATE_PROCEDUREDOCUMENT = EC_PREFIX + 19;

    /**
     * Error al obtener un �rganoi destinatario
     */
    public static final long EC_GET_ADDRESSEE = EC_PREFIX + 20;

    /**
     * Error, identificador de �rgano destinatario no v�lido
     */
    public static final long EC_BAD_ADDRESSEEID = EC_PREFIX + 21;

    /**
     * Error al a�adir un nuevo �rgano destinatario
     */
    public static final long EC_ADD_ADDRESSEE = EC_PREFIX + 22;

    /**
     * Error al actualizar un �rgano destinatario
     */
    public static final long EC_UPDATE_ADDRESSEE = EC_PREFIX + 23;

    /**
     * Error al obtener el listado de �rganos destinarios
     */
    public static final long EC_GET_ADDRESSEES = EC_PREFIX + 24;

    /**
     * Error, �rgano destinatario en uso
     */
    public static final long EC_ADDRESSEE_USED = EC_PREFIX + 25;

    /**
     * Error al eliminar un �rgano destinatario
     */
    public static final long EC_DELETE_ADDRESSEE = EC_PREFIX + 26;

    /**
     * Error al obtener un conector
     */
    public static final long EC_GET_HOOK = EC_PREFIX + 27;

    /**
     * Error, el identificador del conector no es v�lido
     */
    public static final long EC_BAD_HOOKID = EC_PREFIX + 28;

    /**
     * Error al a�adir un nuevo conector
     */
    public static final long EC_ADD_HOOK = EC_PREFIX + 29;

    /**
     * Error al actualizar un conector
     */
    public static final long EC_UPDATE_HOOK = EC_PREFIX + 30;

    /**
     * Error al eliminar un conector
     */
    public static final long EC_DELETE_HOOK = EC_PREFIX + 31;

    /**
     * Error al obtener listado de conectores
     */
    public static final long EC_GET_HOOKS = EC_PREFIX + 32;

    /**
     * Error al obtener un tipo de conector
     */
    public static final long EC_GET_HOOKTYPE = EC_PREFIX + 33;

    /**
     * Error, el identificador de tipo de conector no es v�lido
     */
    public static final long EC_BAD_HOOKTYPEID = EC_PREFIX + 34;

    /**
     * Error al a�adir un nuevo tipo de conector
     */
    public static final long EC_ADD_HOOKTYPE = EC_PREFIX + 35;

    /**
     * Error al actualizar un tipo de conector
     */
    public static final long EC_UPDATE_HOOKTYPE = EC_PREFIX + 36;

    /**
     * Error al eliminar un tipo de conector
     */
    public static final long EC_DELETE_HOOKTYPE = EC_PREFIX + 37;

    /**
     * Error al obtener el listado de tipos de conector
     */
    public static final long EC_GET_HOOKTYPES = EC_PREFIX + 38;

    /**
     * Error al a�adir un nuevo conector de autenticaci�n
     */
    public static final long EC_ADD_AUTENTICATION_HOOK = EC_PREFIX + 39;

    /**
     * Error, el identificador de tr�mite o de conector no es v�lido
     */
    public static final long EC_BAD_PROCEDUREID_OR_HOOKID = EC_PREFIX + 40;

    /**
     * Error al actualizar un conector de autenticaci�n
     */
    public static final long EC_UPDATE_AUTENTICATION_HOOK = EC_PREFIX + 41;

    /**
     * Error al eliminar un conector de autenticaci�n
     */
    public static final long EC_DELETE_AUTENTICATION_HOOK = EC_PREFIX + 42;

    /**
     * Error al obtener el listado de conectores de autenticaci�n
     */
    public static final long EC_GET_AUTENTICATION_HOOKS = EC_PREFIX + 43;

    /**
     * Error al obtener un conectores de autenticaci�n
     */
    public static final long EC_GET_AUTENTICATION_HOOK = EC_PREFIX + 44;

    /**
     * No existe ning�n procedimiento que coincida con los par�metros de la
     * b�squeda
     */
    public static final long EC_NO_PROCEDURE =  EC_PREFIX + 45;

    /**
     * El c�digo de oficina asignado al tr�mite no est� asociado al usuario
     * configurado para realizar la consolidaci�n en registro presencial
     */
    public static final long EC_OFFICE_CODE_NOT_ASSIGNED_CONSOLIDATION_USER_RP =  EC_PREFIX + 46;

    /**
     * El c�digo del asunto no existe en registro presencial como un tipo
     * de asunto asociado al c�digo de oficina asignado al tr�mite
     */
    public static final long EC_TOPIC_CODE_NOT_ASSIGNED_OFFICE_CODE_RP =  EC_PREFIX + 47;

}
