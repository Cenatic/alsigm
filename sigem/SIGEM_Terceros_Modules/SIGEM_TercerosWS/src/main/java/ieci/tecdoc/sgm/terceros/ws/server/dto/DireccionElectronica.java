package ieci.tecdoc.sgm.terceros.ws.server.dto;

import java.io.Serializable;

/**
 * Informaci�n de la direcci�n electr�nica de un tercero.
 *
 */
public class DireccionElectronica implements Serializable {

	/**
	 * Identificador de la direcci�n electr�nica.
	 */
	private String id;
	
	/**
	 * Tipo de direcci�n electr�nica:
	 */
	private int tipo;
	
	/**
	 * Direcci�n electr�nica.
	 */
	private String direccion;

	
	/**
	 * Constructor.
	 */
	public DireccionElectronica() {
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
