/*
 * Creado el 20-jun-2006
 *
*/
package ieci.tecdoc.sgm.registro.exception;

import ieci.tecdoc.sgm.registro.exception.RegistroExcepcion;



/**
 * Excepci�n espec�fica de la validaci�n de documentos en el
 * proceso de registro.
 */
public class ValidacionDocumentoExcepcion extends RegistroExcepcion {

	private String codDoc;
	/**
	 * Constructor de excepci�n de registro.
	 * @param codDoc C�dgo del documento.
	 * @param errorCode C�digo de error.
	 * @param msg Mensaje de error.
	 */	
   public ValidacionDocumentoExcepcion(String codDoc, String errorCode, String msg)
   {
      super(errorCode);   
      this.codDoc = codDoc;
   }

   /**
    * Constructor de excepci�n de registro.
    * @param errorCode C�digo de error.
    * @param msg mensaje de error.
    * @param cause Cause del error.
    */
   public ValidacionDocumentoExcepcion(String codDoc, String errorCode, String msg, Exception cause)
   {
      super(msg, cause);
      this.codDoc = codDoc;
   }
   
    /** 
     * Devuelve el c�digo de documento cuya validaci�n produjo la excepci�n.
     * @return String C�digo de documento.
     */
	public String getCodDoc() {
		return codDoc;
	}
}
