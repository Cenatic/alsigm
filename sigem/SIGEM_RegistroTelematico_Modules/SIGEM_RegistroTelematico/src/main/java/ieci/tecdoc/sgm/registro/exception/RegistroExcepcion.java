package ieci.tecdoc.sgm.registro.exception;

/**
 * Excepci�n espec�fica de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroExcepcion extends SgmExcepcion
{
	
	/**
	 * Constructor de excepci�n de registro.
	 * @param errorCode C�digo de error.
	 */	
   public RegistroExcepcion(String errorCode)
   {
      super(errorCode);   
   }

   /**
     * Constructor de excepci�n de registro.
     * @param errorCode C�digo de error.
     */ 
  public RegistroExcepcion(long errorCode)
  {
     super(errorCode);   
  }
   
   /**
    * Constructor de excepci�n de registro.
    * @param msg mensaje de error.
    * @param cause Cause del error.
    */
   public RegistroExcepcion(String msg, Exception cause)
   {
      super(msg, cause);
   }
   
   /**
    * Devuelve la localizaci�n del fichero de mensajes de error
    * @return String Fichero de mensajes de error
    */
   public String getMessagesFile() {

     return RESOURCE_FILE;
  }

  private static String RESOURCE_FILE = "ieci.tecdoc.sgm.registro.resources.error";
}
