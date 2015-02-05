package ieci.tecdoc.sgm.autenticacion.util.signature;

import ieci.tecdoc.sgm.autenticacion.util.hook.cert.CertificadoFirmaX509Info;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Interfaz de comportamiento de una firma.
 * 
 * @author IECISA
 *
 */
public interface FirmaExt 
{
	/**
	 * M�todo que realiza la firma digital.
	 * @param data Datos a firmar.
	 * @param additionalInfo Informaci�n adicional necesaria para la firma.
	 * @param certificate Certificado a utilizar para la firma.
	 * @return ByteArrayOutputStream Datos firmados.
	 * @throws Exception En caso de producirse alg�n error.
	 */
   public abstract ByteArrayOutputStream sign(InputStream data, String additionalInfo, CertificadoFirmaX509Info certificate) throws Exception;

}