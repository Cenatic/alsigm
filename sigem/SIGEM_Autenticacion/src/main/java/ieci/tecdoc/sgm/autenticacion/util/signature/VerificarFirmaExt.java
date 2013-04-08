
package ieci.tecdoc.sgm.autenticacion.util.signature;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Interfaz de corportamiento de clases para la validaci�n de firmas.
 * 
 * @author IECISA
 *
 */
public interface VerificarFirmaExt {
   
	/**
	 * M�todo de verificaci�n de firma.
	 * @param data Datos a verificar.
	 * @param additionalInfo Informaci�n adicional para la verificaci�n.
	 * @return SignaturesValidationInfo Informaci�n del resultado de la validaci�n.
	 * @throws Exception En caso de producirse alg�n error.
	 */   
   public abstract ValidacionFirmasInfo verifySign(InputStream data, String additionalInfo) throws Exception;

   /**
    * M�todo que obtiene el documento incluido en la firma.
    * @param data Datos de la firma.
    * @param additionalInfo Informaci�n adicional necesaria.
    * @return ByteArrayOutputStream Con los datos del documento.
    * @throws Exception En caso de producirse alg�n error.
    */
   public abstract ByteArrayOutputStream getDocument(InputStream data, String additionalInfo) throws Exception;
   
}
