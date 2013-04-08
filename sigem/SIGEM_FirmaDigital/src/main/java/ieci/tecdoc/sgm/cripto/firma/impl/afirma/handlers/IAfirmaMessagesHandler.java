package ieci.tecdoc.sgm.cripto.firma.impl.afirma.handlers;

import ieci.tecdoc.sgm.cripto.firma.impl.afirma.SignManagerAFirmaImpl;
import ieci.tecdoc.sgm.cripto.firma.impl.afirma.xml.firmardocumento.FirmarDocumento;
import ieci.tecdoc.sgm.cripto.firma.impl.afirma.xml.registrarFirma.FirmarUsuario;
import ieci.tecdoc.sgm.cripto.firma.impl.afirma.xml.verificarfirma.VerificarFirma;

/**
 * Interfaz para los gestores de mensajes contra los servicios de AFirma.
 * 
 */
public interface IAfirmaMessagesHandler {

	/**
	 * Compone el mensaje de petici�n para almacenar un documento en AFirma.
	 * 
	 * @param af
	 *            Implementaci�n del servicio de firma digital contra AFirma.
	 * @param contentBase64
	 *            Contenido del documento en base64.
	 * @return Mensaje de petici�n.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public String createRequestAlmacenarDocumento(SignManagerAFirmaImpl af,
			String contentBase64) throws Exception;

	/**
	 * Comprueba el mensaje de respuesta de almacenar un documento en AFirma.
	 * 
	 * @param response
	 *            Respuesta del servicio de AFirma.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void checkResponseAlmacenarDocumento(String response)
			throws Exception;

	/**
	 * Compone el mensaje de petici�n para firmar un documento en AFirma.
	 * 
	 * @param af
	 *            Implementaci�n del servicio de firma digital contra AFirma.
	 * @param message
	 *            Mensaje de respuesta de almacenar un documento
	 * @return Mensaje de petici�n.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public String createRequestFirmar(SignManagerAFirmaImpl af, String message)
			throws  Exception;

	/**
	 * Comprueba el mensaje de respuesta de firmar un documento en AFirma.
	 * 
	 * @param fd
	 *            Informaci�n del documento.
	 * @param response
	 *            Respuesta del servicio de AFirma.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void checkResponseFirmar(FirmarDocumento fd, String response)
			throws Exception;

	/**
	 * Compone el mensaje de petici�n para registrar una firma en AFirma.
	 * 
	 * @param af
	 *            Implementaci�n del servicio de firma digital contra AFirma.
	 * @param firmaUsuario
	 *            Firma del usuario en base64.
	 * @param certFirmante
	 *            Certificado del firmate en base64.
	 * @param hash
	 *            Hash del documento firmato.
	 * @return Mensaje de petici�n.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public String createRequestFirmarUsuario(SignManagerAFirmaImpl af,
			String firmaUsuario, String certFirmante, String hash) throws Exception;

	/**
	 * Comprueba el mensaje de respuesta de registrar la firma de un documento en AFirma.
	 * 
	 * @param fu
	 *            Informaci�n del registro de la firma.
	 * @param response
	 *            Respuesta del servicio de AFirma.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void checkResponseFirmaUsuario(FirmarUsuario fu, String response)
			throws Exception;

	/**
	 * Compone el mensaje de petici�n para verificar una firma en AFirma.
	 * 
	 * @param af
	 *            Implementaci�n del servicio de firma digital contra AFirma.
	 * @param firma
	 *            Firma en base64
	 * @return Mensaje de petici�n.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public String createRequestVerificar(SignManagerAFirmaImpl af, String firma) throws Exception;

	/**
	 * Comprueba el mensaje de respuesta para verificar la firma de un documento en AFirma.
	 * 
	 * @param vf
	 *            Informaci�n de la firma.
	 * @param response
	 *            Respuesta del servicio de AFirma.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void checkResponseVerificar(VerificarFirma vf, String response)
			throws Exception;

}