package docelectronicos.vos;

/**
 * Informaci�n de una ficha de clasificadores documentales.
 */
public class FichaClfVO extends InfoBFichaClfVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Definici�n de la ficha. */
	private String definicion = null;

	/**
	 * Constructor.
	 */
	public FichaClfVO() {
		super();
	}

	/**
	 * @return Returns the definicion.
	 */
	public String getDefinicion() {
		return definicion;
	}

	/**
	 * @param definicion
	 *            The definicion to set.
	 */
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
}
