package se.instituciones.archivo.invesdoc.vo;

import se.instituciones.InfoOrgano;

import common.Constants;

/**
 * Informaci�n de un �rgano.
 */
public class OrganoVO implements InfoOrgano
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Identificador del �rgano. */
	public String id = null;

	/** Nombre del �rgano. */
	public String nombre = null;

	/** C�digo del �rgano. */
	public String codigo = null;

	/** Nivel jer�rquico al que pertenece el �rgano. */
	public int nivel = 0;

	/** Identificador del �rgano padre. */
	public String idPadre = null;

	/** Es institucion */
	private String institucion = null;

	/**
	 * Constructor.
	 */
	public OrganoVO() {
		super();
	}

	/**
	 * Obtiene el identificador del �rgano.
	 *
	 * @return Identificador del �rgano.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene el nombre del �rgano.
	 *
	 * @return Nombre del �rgano.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el c�digo del �rgano.
	 *
	 * @return C�digo del �rgano.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Obtiene el nivel jer�rquico al que pertenece el �rgano.
	 *
	 * @return Nivel jer�rquico.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Obtiene el identificador del �rgano padre al que pertenece el �rgano.
	 *
	 * @return Identificador del �rgano padre.
	 */
	public String getIdPadre() {
		return idPadre;
	}

	/**
	 * Establece el c�digo del �rgano.
	 *
	 * @param codigo
	 *            C�digo del �rgano.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Establece el identificador del �rgano.
	 *
	 * @param id
	 *            Identificador del �rgano.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Establece el identificador del �rgano padre.
	 *
	 * @param idPadre
	 *            Identificador del �rgano padre.
	 */
	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}

	/**
	 * Establece el nivel jer�rquico al que pertenece el �rgano.
	 *
	 * @param nivel
	 *            Nivel jer�rquico al que pertenece el �rgano.
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setNivel(String nivel){
		this.nivel = Integer.parseInt(nivel);
	}


	/**
	 * Establece el nombre del �rgano.
	 *
	 * @param nombre
	 *            Nombre del �rgano.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene una representaci�n XML del objeto.
	 *
	 * @return Representaci�n del objeto.
	 */
	public String toXML() {
		final StringBuffer xml = new StringBuffer();

		// Tag de inicio
		xml.append("<OrganoVO>");
		xml.append(Constants.NEWLINE);

		// Id
		xml.append("  <Id>");
		xml.append(id != null ? id : "");
		xml.append("</Id>");
		xml.append(Constants.NEWLINE);

		// Nombre
		xml.append("  <Nombre>");
		xml.append(nombre != null ? nombre : "");
		xml.append("</Nombre>");
		xml.append(Constants.NEWLINE);

		// Codigo
		xml.append("  <Codigo>");
		xml.append(codigo != null ? codigo : "");
		xml.append("</Codigo>");
		xml.append(Constants.NEWLINE);

		// Nivel
		xml.append("  <Nivel>");
		xml.append(nivel);
		xml.append("</Nivel>");
		xml.append(Constants.NEWLINE);

		// IdPadre
		xml.append("  <IdPadre>");
		xml.append(idPadre != null ? idPadre : "");
		xml.append("</IdPadre>");
		xml.append(Constants.NEWLINE);

		// Tag de cierre
		xml.append("</OrganoVO>");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

	/**
	 * Obtiene una representaci�n del objeto.
	 *
	 * @return Representaci�n del objeto.
	 */
	public String toString() {
		return toXML();
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getInstitucion() {
		return institucion;
	}

}
