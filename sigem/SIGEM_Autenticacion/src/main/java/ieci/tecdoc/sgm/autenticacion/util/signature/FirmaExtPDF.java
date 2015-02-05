package ieci.tecdoc.sgm.autenticacion.util.signature;

import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoFirmaX509Info;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Interfaz con el corportamiento de una firma de documento PDF.
 * 
 * @author IECISA
 *
 */
public interface FirmaExtPDF 
{
	/**
	 * M�todo para realizar la firma.
	 * @param data Datos a firmar.
	 * @param request Solicitud.
	 * @param additionalInfo Informaci�n adicional para la firma.
	 * @param certificate Certificado a utilizara para la firma.
	 * @return ByteArrayOutputStream Datos firmados.
	 * @throws Exception En caso de producirse alg�n error.
	 */
   public abstract ByteArrayOutputStream sign(InputStream data, String request, String additionalInfo, CertificadoFirmaX509Info certificate) throws Exception;

}