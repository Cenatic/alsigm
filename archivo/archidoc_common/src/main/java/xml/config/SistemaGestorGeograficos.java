package xml.config;

/**
 * Clase que almacena la informaci�n de un
 * Sistema Gestor de Geogr�ficos.
 */
public class SistemaGestorGeograficos extends Sistema
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor.
	 */
	public SistemaGestorGeograficos()
	{
		super();
	}


	/**
	 * Obtiene una representaci�n XML del objeto.
	 * @param indent N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public String toXML(int indent)
	{
		return toXML(indent, "Sistema_Gestor_Geograficos");
	}
}
