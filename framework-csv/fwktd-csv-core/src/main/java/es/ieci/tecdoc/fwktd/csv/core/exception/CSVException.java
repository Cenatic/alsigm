package es.ieci.tecdoc.fwktd.csv.core.exception;

import es.ieci.tecdoc.fwktd.core.exception.ApplicationException;

/**
 * Excepci�n base del m�dulo de gesti�n de CSVs.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class CSVException extends ApplicationException {

	private static final long serialVersionUID = 1024111867043660202L;

	/**
	 * Constructor de la clase.
	 *
	 * @param messageId
	 *            clave del mensaje en el fichero de recursos con los mensajes
	 *            internacionalizados para las excepciones
	 * @param params
	 *            par�metros para componer el mensaje con el del fichero de
	 *            recursos
	 * @param defaultMessage
	 *            mensaje a mostrar en caso de que no encuentre la clave del
	 *            mensaje
	 */
	public CSVException(String messageId, String[] params, String defaultMessage) {
		super(messageId, params, defaultMessage);
	}

	/**
	 * Obtiene el id del mensaje por defecto. Se utiliza para indicar la clave,
	 * en un fichero de recursos, de la que obtener el mensaje
	 * internacionalizado de la excepci�n.
	 *
	 * @return el id del mensaje internacionalizado de la excepci�n
	 */
	@Override
	public String getDefaultMessageId() {
		return "error.csv";
	}

}
