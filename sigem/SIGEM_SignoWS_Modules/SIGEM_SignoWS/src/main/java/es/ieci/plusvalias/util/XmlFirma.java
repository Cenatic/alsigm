package es.ieci.plusvalias.util;

import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Element;

/**
 * @author angel_castro@ieci.es - 18/11/2010
 */
public class XmlFirma {
	public static Logger logger = Logger.getLogger(CalculoPlusvaliaHelper.class);

	public boolean comprobar(Element nodo, String baseURI) throws Exception{
		
		org.apache.xml.security.Init.init();

		boolean valido = false;
		XMLSignature signature  = new XMLSignature(nodo, baseURI);

		KeyInfo keyInfo = signature.getKeyInfo();
		if (keyInfo != null) {
			X509Certificate cert = keyInfo.getX509Certificate();
			if (cert != null) {
				// Validamos la firma usando un certificado X509
				if (signature.checkSignatureValue(cert)){
					logger.debug("V�lido seg�n el certificado");
					valido = true;
				} else {
					logger.debug("Inv�lido seg�n el certificado");
				}
			} else {
				// No encontramos un Certificado intentamos validar por la cl�ve p�blica
				PublicKey pk = keyInfo.getPublicKey();
				if (pk != null) {
					// Validamos usando la clave p�blica
					if (signature.checkSignatureValue(pk)){
						logger.debug("V�lido seg�n la clave p�blica");
						valido = true;
					} else {
						logger.debug("Inv�lido seg�n la clave p�blica");	
					}
				} else {
					logger.debug("No podemos validar, tampoco hay clave p�blica");
				}
			}
		} else {
			logger.debug("No ha sido posible encontrar el KeyInfo");
		}
		return valido;
	}
}

    