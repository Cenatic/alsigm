package ieci.tecdoc.sgm.localizador.hadler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Properties;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.SOAPPart;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.soap.MessageFactoryImpl;
import org.apache.log4j.Logger;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecSignature;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Clase encargada de securizar los mensajes SOAP de petici�n realizados desde un cliente.
 * @author SEPAOT
 *
 */

public class HandlerLocalizador extends BasicHandler {
	
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(HandlerLocalizador.class);
    
    // Opciones de seguridad
    // Seguridad UserNameToken
    public static final String USERNAMEOPTION = WSConstants.USERNAME_TOKEN_LN;
    // Seguridad BinarySecurityToken
    public static final String CERTIFICATEOPTION = WSConstants.BINARY_TOKEN_LN;
    // Sin seguridad
    public static final String NONEOPTION = "None";

    // Opci�n de seguridad del objeto actual
    private String securityOption = null;
    // Usuario para el token de seguridad UserNameToken.
    private String userTokenUserName = null;
    // Password para el token de seguridad UserNameToken
    private String userTokenUserPassword = null;
    // Tipo de password para el UserNameTokenPassword
    private String userTokenUserPasswordType = null;
    // Localizaci�n del keystore con certificado y clave privada de usuario
    private String keystoreLocation = null;
    // Tipo de keystore
    private String keystoreType = null;
    // Clave del keystore
    private String keystorePassword = null;
    // Alias del certificado usado para firmar el tag soapBody de la petici�n y que ser� alojado en el token BinarySecurityToken
    private String keystoreCertAlias = null;
    // Password del certificado usado para firmar el tag soapBody de la petici�n y que ser� alojado en el token BinarySecurityToken
    private String keystoreCertPassword = null;

    
    /**
     * Constructor que inicializa el atributo securityOption
     *
     * @param securityOption opci�n de seguridad.
     * @throws Exception
     */
	public HandlerLocalizador(String mode, String user, String pass,
			String passType) {
		
		securityOption = mode;
		userTokenUserName = user;
		userTokenUserPassword = pass;
		
		if ("PasswordText".equals(passType)) {
			userTokenUserPasswordType = WSConstants.PASSWORD_TEXT;
		} else if ("PasswordDigest".equals(passType)) {
			userTokenUserPasswordType = WSConstants.PASSWORD_DIGEST;
		}

		if (!securityOption.equals(USERNAMEOPTION)
				&& !securityOption.equals(CERTIFICATEOPTION)
				&& !securityOption.equals(NONEOPTION)) {
			logger.error("Opcion de seguridad no valida: " + securityOption);
		}
	}
    
	public void invoke(MessageContext msgContext) throws AxisFault {
		
		SOAPMessage msg, secMsg;
		Document doc = null;
		secMsg = null;
		
		try {
			
			// Obtenci�n del documento XML que representa la petici�n SOAP
			msg = msgContext.getCurrentMessage();
			doc = ((org.apache.axis.message.SOAPEnvelope) msg.getSOAPPart()
					.getEnvelope()).getAsDocument();
			
			// Securizaci�n de la petici�n SOAP seg�n la opcion de seguridad
			// configurada
			if (this.securityOption.equals(USERNAMEOPTION)) {
				secMsg = this.createUserNameToken(doc);
			} else if (this.securityOption.equals(CERTIFICATEOPTION)) {
				secMsg = this.createBinarySecurityToken(doc);
			} else {
				secMsg = msg;
			}
			
			// Modificaci�n de la petici�n SOAP
			((SOAPPart) msgContext.getRequestMessage().getSOAPPart())
					.setCurrentMessage(secMsg.getSOAPPart().getEnvelope(),
							SOAPPart.FORM_SOAPENVELOPE);
			
		} catch (AxisFault e) {
			logger.error("Error al invocar al servicio", e);
			throw e;
		} catch (Throwable t) {
			logger.error("Error al invocar al servicio", t);
			throw new AxisFault(t.getMessage(), t);
		}
	}

    /**
     * Securiza, mediante el tag userNameToken, una petici�n SOAP no securizada.
     *
     * @param soapRequest Documento xml que representa la petici�n SOAP sin securizar.
     * @return Un mensaje SOAP que contiene la petici�n SOAP de entrada securizada
     * mediante el tag userNameToken.
     * @throws Exception 
     */
	private SOAPMessage createUserNameToken(Document soapEnvelopeRequest)
			throws Exception {
		
		ByteArrayOutputStream baos;
		Document secSOAPReqDoc;
		DOMSource source;
		Element element;
		StreamResult streamResult;
		String secSOAPReq;
		WSSecUsernameToken wsSecUsernameToken;
		WSSecHeader wsSecHeader;
		
		try {
			// Inserci�n del tag wsse:Security y userNameToken
			wsSecHeader = new WSSecHeader(null, false);
			wsSecUsernameToken = new WSSecUsernameToken();
			wsSecUsernameToken.setPasswordType(this.userTokenUserPasswordType);
			wsSecUsernameToken.setUserInfo(this.userTokenUserName,
					this.userTokenUserPassword);
			wsSecHeader.insertSecurityHeader(soapEnvelopeRequest);
			wsSecUsernameToken.prepare(soapEnvelopeRequest);
			
			
			// A�adimos una marca de tiempo inidicando la fecha de creaci�n del
			// tag
			wsSecUsernameToken.addCreated();
			wsSecUsernameToken.addNonce();
			
			// Modificaci�n de la petici�n
			secSOAPReqDoc = wsSecUsernameToken.build(soapEnvelopeRequest,
					wsSecHeader);
			element = secSOAPReqDoc.getDocumentElement();
			
			// Transformaci�n del elemento DOM a String
			source = new DOMSource(element);
			baos = new ByteArrayOutputStream();
			streamResult = new StreamResult(baos);
			TransformerFactory.newInstance().newTransformer()
					.transform(source, streamResult);
			secSOAPReq = new String(baos.toByteArray());
			
			// Creaci�n de un nuevo mensaje SOAP a partir del mensaje SOAP
			// securizado formado
//			res = MessageFactory.newInstance().createMessage(null,
//					new ByteArrayInputStream(secSOAPReq.getBytes()));
			// Correcci�n para Java6 al no retornar la MessageFactoryImpl de
			// Axis 1.x, as� que se crea directamente
			return new MessageFactoryImpl().createMessage(null,
					new ByteArrayInputStream(secSOAPReq.getBytes()));
			
		} catch (Exception e) {
		    logger.error("Error al crear el UserNameToken", e);
		    throw e;
		}
	}

    /**
     * Securiza, mediante el tag BinarySecurityToken y firma una petici�n SOAP no securizada.
     *
     * @param soapEnvelopeRequest Documento xml que representa la petici�n SOAP sin securizar.
     * @return Un mensaje SOAP que contiene la petici�n SOAP de entrada securizada
     * mediante el tag BinarySecurityToken.
     * @throws Exception 
     */
	private SOAPMessage createBinarySecurityToken(Document soapEnvelopeRequest)
			throws Exception {
		
		ByteArrayOutputStream baos;
		Crypto crypto;
		Document secSOAPReqDoc;
		DOMSource source;
		Element element;
		StreamResult streamResult;
		String secSOAPReq;
		WSSecSignature wsSecSignature;
		WSSecHeader wsSecHeader;
		
		try {
			// Inserci�n del tag wsse:Security y BinarySecurityToken
			wsSecHeader = new WSSecHeader(null, false);
			wsSecSignature = new WSSecSignature();
			crypto = CryptoFactory.getInstance(
					"org.apache.ws.security.components.crypto.Merlin",
					this.initializateCryptoProperties());
			
			// Indicaci�n para que inserte el tag BinarySecurityToken
			wsSecSignature
					.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
			
			// wsSecSignature.setKeyIdentifierType(WSConstants.ISSUER_SERIAL);
			wsSecSignature.setUserInfo(this.keystoreCertAlias,
					this.keystoreCertPassword);
			wsSecHeader.insertSecurityHeader(soapEnvelopeRequest);
			wsSecSignature.prepare(soapEnvelopeRequest, crypto, wsSecHeader);
			
			// Modificaci�n y firma de la petici�n
			secSOAPReqDoc = wsSecSignature.build(soapEnvelopeRequest, crypto,
					wsSecHeader);
			element = secSOAPReqDoc.getDocumentElement();
			
			// Transformaci�n del elemento DOM a String
			source = new DOMSource(element);
			baos = new ByteArrayOutputStream();
			streamResult = new StreamResult(baos);
			TransformerFactory.newInstance().newTransformer()
					.transform(source, streamResult);
			secSOAPReq = new String(baos.toByteArray());
			
			// Creaci�n de un nuevo mensaje SOAP a partir del mensaje SOAP
			// securizado formado
//			res = MessageFactory.newInstance().createMessage(null,
//					new ByteArrayInputStream(secSOAPReq.getBytes()));
			// Correcci�n para Java6 al no retornar la MessageFactoryImpl de
			// Axis 1.x, as� que se crea directamente
			return new MessageFactoryImpl().createMessage(null,
					new ByteArrayInputStream(secSOAPReq.getBytes()));

		} catch (Exception e) {
		    logger.error("Error al crear el BinarySecurityToken", e);
		    throw e;
		}
	}

    /**
     * Establece el conjunto de propiedades con el que ser� inicializado el gestor criptogr�fico de WSS4J.
     * @return Devuelve el conjunto de propiedades con el que ser� inicializado el gestor criptogr�fico de
     WSS4J.
    */
	@SuppressWarnings("rawtypes")
	private Map initializateCryptoProperties() {
		Properties res = new Properties();
		res.setProperty("org.apache.ws.security.crypto.provider",
				"org.apache.ws.security.components.crypto.Merlin");
		res.setProperty("org.apache.ws.security.crypto.merlin.keystore.type",
				this.keystoreType);
		res.setProperty(
				"org.apache.ws.security.crypto.merlin.keystore.password",
				this.keystorePassword);
		res.setProperty("org.apache.ws.security.crypto.merlin.keystore.alias",
				this.keystoreCertAlias);
		res.setProperty("org.apache.ws.security.crypto.merlin.alias.password",
				this.keystoreCertPassword);
		res.setProperty("org.apache.ws.security.crypto.merlin.file",
				this.keystoreLocation);

		return res;
	}
}
