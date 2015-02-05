package se.tramites;

public class InfoBExpedienteImpl implements InfoBExpediente {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String id = null;
	String numExp = null;
	String datosIdentificativos = null;

	/**
	 * Constructor.
	 */
	public InfoBExpedienteImpl() {
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            Identificador del expediente
	 * @param numExp
	 *            Numero de expediente
	 * @param datosIdentificativos
	 *            Datos identificativos del expediente
	 */
	protected InfoBExpedienteImpl(String id, String numExp,
			String datosIdentificativos) {
		super();
		this.id = id;
		this.numExp = numExp;
		this.datosIdentificativos = datosIdentificativos;
	}

	/**
	 * Devuelve el identificador �nico.
	 * 
	 * @return Identificador �nico.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador �nico.
	 * 
	 * @param id
	 *            Identificador �nico.
	 */
	public void setId(String id) {
		this.id = id;
		;
	}

	/**
	 * Devuelve el n�mero de expediente.
	 * 
	 * @return N�mero de expediente.
	 */
	public String getNumExp() {
		return numExp;
	}

	/**
	 * Establece el n�mero de expediente.
	 * 
	 * @return numExp N�mero de expediente.
	 */
	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}

	/**
	 * Devuelve los datos que identifican al expediente.
	 * 
	 * @return Datos que identifican al expediente.
	 */
	public String getDatosIdentificativos() {
		return datosIdentificativos;
	}

	/**
	 * Establece los datos que identifican al expediente.
	 * 
	 * @return datos Datos que identifican al expediente.
	 */
	public void setDatosIdentificativos(String datos) {
		this.datosIdentificativos = datos;
	}

}
