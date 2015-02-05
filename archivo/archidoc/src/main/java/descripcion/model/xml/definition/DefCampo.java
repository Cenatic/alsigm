package descripcion.model.xml.definition;

import descripcion.model.xml.XmlElement;

/**
 * Clase abstracta que almacena la informaci�n de un campo de la definici�n de
 * la ficha ISAD(G).
 */
public abstract class DefCampo extends XmlElement {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Tipo de elemento. */
	protected short tipo;

	/** Identificador del campo. */
	protected String id = null;

	/** Descripci�n del elemento. */
	protected String descripcion = null;

	/**
	 * Constructor.
	 */
	public DefCampo() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param tipo
	 *            Tipo de campo.
	 */
	public DefCampo(short tipo) {
		super();
		setTipo(tipo);
	}

	/**
	 * Obtiene el identificador del campo.
	 * 
	 * @return Identificador del campo.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del campo.
	 * 
	 * @param id
	 *            Identificador del campo.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene la descripci�n del campo.
	 * 
	 * @return Descripci�n del campo.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripci�n del campo.
	 * 
	 * @param descripcion
	 *            Descripci�n del campo.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el tipo de campo.
	 * 
	 * @return Tipo de campo.
	 */
	public short getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de campo.
	 * 
	 * @param tipo
	 *            Tipo de campo.
	 */
	public void setTipo(short tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el nombre del tipo de campo.
	 * 
	 * @return Nombre del tipo de campo.
	 */
	public String getNombreTipoCampo() {
		return DefTipos.getNombreTipoCampo(tipo);
	}

}
