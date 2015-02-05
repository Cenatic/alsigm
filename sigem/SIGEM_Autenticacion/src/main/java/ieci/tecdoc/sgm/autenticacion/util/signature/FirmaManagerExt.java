
package ieci.tecdoc.sgm.autenticacion.util.signature;

import java.io.InputStream;

/**
 * Clase con el comportamiento b�sico de un gestor de firmas.
 * 
 * @author IECISA,
 *
 */
public class FirmaManagerExt 
{
   /**
    * M�todo de validaci�n de firma.
    * @param data Datos a validar.
    * @param auxiliaryInformation Informaci�n adicional.
    * @param implementationTarget Conector que implementa la l�gica de encriptaci�n.
    * @return
    */
   public ValidacionFirmasInfo validate(InputStream data, 
               String[] auxiliaryInformation, String implementationTarget) throws Exception
   {
      return null;
   }
}