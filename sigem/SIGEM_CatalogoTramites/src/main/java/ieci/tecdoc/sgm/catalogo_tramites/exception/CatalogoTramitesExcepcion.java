package ieci.tecdoc.sgm.catalogo_tramites.exception;


/**
 * Excepci�n espec�fica del cat�logo de tr�mites.
 * 
 * @author IECISA
 */
public class CatalogoTramitesExcepcion extends SgmExcepcion {
    
  /**
   * Construye un objeto de la clase.
   * 
   * @param errorCode
   *           C�digo de error.
   */

  public CatalogoTramitesExcepcion(long errorCode) {
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

  public CatalogoTramitesExcepcion(long errorCode, Throwable cause) {
     super(errorCode, cause);
  }

  /**
   * Devuelve la ruta del fichero de mensajes de error
   * @return Ruta del fichero de mensajes de error 
   */
  public String getMessagesFile() {
     return RESOURCE_FILE;
  }

  private static String RESOURCE_FILE = "ieci.tecdoc.sgm.catalogo_tramites.resources.error";
  
}
