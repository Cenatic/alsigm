package es.ieci.tecdoc.fwktd.csv.core.vo;

import es.ieci.tecdoc.fwktd.core.model.BaseValueObject;

/**
 * Informaci�n de una aplicaci�n externa.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class AplicacionCSVForm extends BaseValueObject {

	private static final long serialVersionUID = 7002279450867615665L;

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
	public AplicacionCSVForm() {
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
