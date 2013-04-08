package ieci.tdw.ispac.ispaclib.thirdparty;

/**
 * Adaptador para contener la informaci�n de la direcci�n electr�nica
 * de un tercero.
 *
 */
public class ElectronicAddressAdapter implements IElectronicAddressAdapter {

	/**
	 * Identificador de la direcci�n electr�nica.
	 */
	private String id;
	
	/**
	 * Tipo de direcci�n electr�nica:
	 * @see IElectronicAddressAdapter
	 */
	private int tipo;
	
	/**
	 * Direcci�n electr�nica.
	 */
	private String direccion;

	
	/**
	 * Constructor.
	 */
	public ElectronicAddressAdapter() {
		super();
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
