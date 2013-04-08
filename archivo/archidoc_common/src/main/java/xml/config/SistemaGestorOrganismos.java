package xml.config;

/**
 * Clase que almacena la informaci�n de un Sistema
 * Gestor de Organismos.
 */
public class SistemaGestorOrganismos extends Sistema
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Indica si el sistema gestor es interno. */
	private boolean interno = false;


	/**
	 * Constructor.
	 */
	public SistemaGestorOrganismos()
	{
		super();
	}


	/**
	 * Indica si el sistema gestor es interno.
	 * @return Si el sistema gestor es interno.
	 */
	public boolean isInterno()
	{
		return interno;
	}


	/**
	 * Establece si el sistema gestor es interno.
	 * @param interno Si el sistema gestor es interno.
	 */
	public void setInterno(boolean interno)
	{
		this.interno = interno;
	}


	/**
	 * Obtiene una representaci�n XML del objeto.
	 * @param indent N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public String toXML(int indent)
	{
		return toXML(indent, (interno ? "Sistema_Interno" : "Sistema"));
	}
}
