package common.vos;

/**
 * Clase que encapsula la informaci�n de un tipo.
 */
public class TypeDescVO {

	/** Identificador del tipo. */
	private int id = 0;

	/** Descripci�n del tipo. */
	private String description = null;

	/**
	 * Constructor.
	 */
	public TypeDescVO() {
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            Identificador del tipo.
	 * @param description
	 *            Descripci�n del tipo.
	 */
	public TypeDescVO(int id, String description) {
		setId(id);
		setDescription(description);
	}

	/**
	 * Obtiene el identificador del tipo.
	 * 
	 * @return Identificador del tipo.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del tipo.
	 * 
	 * @param id
	 *            Identificador del tipo.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la descripci�n del tipo.
	 * 
	 * @return Descripci�n del tipo.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripci�n del tipo.
	 * 
	 * @param description
	 *            Descripci�n del tipo.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}