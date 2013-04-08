package ws.transferencias;

/**
 * Interfaz del Servicio Web para operaciones del m�dulo de transferencias
 *
 * @author Iecisa
 * @version $Revision$
 */
public interface WSTransferencias {


	/**
	 * Carga de los datos descriptivos y documentos electr�nicos, de un
	 * expediente electr�nico, perteneciente a un procedimiento y producido por
	 * un productor vigente, en una relaci�n de entrega automatizada en estado
	 * validada y en el cuadro de clasificaci�n. En el caso de que no exista la
	 * serie, previsi�n, detalle y relaci�n de entrega, se crean de forma
	 * din�mica.
	 *
	 * @param autenticacionInfo
	 *            Objeto que contiene los datos referentes a la autenticaci�n:
	 * @param tramitadorInfo Objeto que contiene los datos referentes al sistema tramitador
	 * @param productorInfo Objeto que contiene los datos referentes al productor del expediente
	 * @param expedienteInfo Objeto que contiene la informaci�n del expediente y sus documentos
	 * @return True si el con
	 */
	public boolean transferirExpedienteElectronicoConDocumentos(
			String codigoTramitador, String nombreTramitador,
			int anioExpediente, String codigoProcedimiento,
			byte[] contenidoXml, int verificarUnicidad,
			String usuario, String password,String entidad) throws Exception;
}
