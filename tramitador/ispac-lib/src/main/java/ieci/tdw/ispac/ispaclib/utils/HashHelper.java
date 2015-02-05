package ieci.tdw.ispac.ispaclib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.naming.ConfigurationException;

import org.bouncycastle.util.encoders.Base64;


/**
 * Utilidad para la codificaci�n hash.
 */
public class HashHelper {

	/** Algoritmo para generar el c�digo hash. */
	private static final String ALGORITMO_HASH = "SHA-1";
	
	
	/**
	 * Genera un c�digo hash en base-64 para una cadena determinada.
	 * @param cadena Cadena a codificar.
	 * @return C�digo hash en base-64.
	 * @throws ConfigurationException si ocurre alg�n error al generar el 
	 * c�digo hash.
	 */
	public static String generateHashCode(String cadena) 
			throws NoSuchAlgorithmException {
		
		// Crea un digest con el algoritmo SHA-1
        MessageDigest md = MessageDigest.getInstance(ALGORITMO_HASH);

        // Genera el c�digo hash de la cadena
        byte[] hash = md.digest(cadena.getBytes());
        
        // Convertir el array de bytes a un String
        return new String(Base64.encode(hash));
	}
	
	/**
	 * Genera un c�digo hash en base-64 para un binario determinado.
	 * @param content Binario.
	 * @return C�digo hash en base-64.
	 * @throws ConfigurationException si ocurre alg�n error al generar el 
	 * c�digo hash.
	 */
	public static String generateHashCode(byte[] content) 
			throws NoSuchAlgorithmException {
		String contentBase64 = new String(Base64.encode(content));
		return generateHashCode(contentBase64);
	}
}
