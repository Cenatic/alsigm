package ieci.tecdoc.sgm.mensajes_cortos.mgr;

import ieci.tecdoc.sgm.core.services.mensajes_cortos.MensajesCortosException;
import ieci.tecdoc.sgm.core.services.mensajes_cortos.dto.Attachment;

/**
 * Interfaz para los gestores de env�o de correos electr�nicos.
 *
 */
public interface EmailManager {

	
	/**
	 * Env�a un correo electr�nico.
	 * 
	 * @param from
	 *            Direcci�n de correo elentr�nico del remitente.
	 * @param to
	 *            Direcci�n de correo electr�nico del destinatario.
	 * @param cc
	 *            Direcci�n de correo electr�nico de destinatarios en copia.
	 * @param bcc
	 *            Direcci�n de correo electr�nico de destinatarios en copia
	 *            oculta.
	 * @param subject
	 *            Asunto del mensaje.
	 * @param content
	 *            Contenido del mensaje.
	 * @param attachments
	 *            Array de objetos Attachment con el nombre del fichero adjunto
	 *            y el contenido en binario.
	 * @throws MensajesCortosException
	 *             si ocurre alg�n error.
	 */
	public void sendMail(String from, String[] to, String[] cc, String[] bcc, String subject,
			String content, Attachment[] attachments) throws MensajesCortosException;

}
