
package ieci.tecdoc.sgm.autenticacion.util.document;

import java.io.InputStream;

/**
 * Interfaz para documentos.
 * 
 * @author IECISA
 *
 */
public interface DocumentoExt {
   
   	/**
	 * M�todo que implementa la validaci�n del documento.
	 * @param data Datos a validar.
	 * @param additionalInfo Informaci�n adicional necesaria para la validaci�n.
	 * @return String Con el resultado de la validaci�n.
	 * @throws Exception En caso de producirse alg�n error.
	 */
   public abstract String validate(InputStream data, String additionalInfo) throws Exception;
   
}
