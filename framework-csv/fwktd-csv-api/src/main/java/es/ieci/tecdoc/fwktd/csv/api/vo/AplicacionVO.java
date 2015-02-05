package es.ieci.tecdoc.fwktd.csv.api.vo;

import es.ieci.tecdoc.fwktd.core.model.Entity;

/**
 * Informaci�n de una aplicaci�n externa.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class AplicacionVO extends Entity {

	private static final long serialVersionUID = -5597206823018518331L;

	/**
	 * C�digo �nico de la aplicaci�n externa.
	 */
	private String codigo = null;

	/**
	 * Nombre de la aplicaci�n externa.
	 */
	private String nombre = null;

	/**
	 * Informaci�n de la conexi�n con la aplicaci�n externa.
	 */
	private String infoConexion = null;

	/**
	 * Constructor.
	 */
	public AplicacionVO() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInfoConexion() {
		return infoConexion;
	}

	public void setInfoConexion(String infoConexion) {
		this.infoConexion = infoConexion;
	}
}
