package descripcion.model.xml.card;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.XmlElement;

/**
 * Clase que almacena la informaci�n de una opci�n de un campo.
 */
public class Opcion extends XmlElement {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Etiqueta de la opci�n. */
	private String titulo = null;

	/** Indica si es el valor por defecto. */
	private boolean valorPorDefecto = false;

	/**
	 * Constructor.
	 */
	public Opcion() {
		this(null, false);
	}

	/**
	 * Constructor.
	 */
	public Opcion(String titulo) {
		this(titulo, false);
	}

	/**
	 * Constructor.
	 */
	public Opcion(String titulo, boolean esValorPorDefecto) {
		super();

		setTitulo(titulo);
		setValorPorDefecto(esValorPorDefecto);
	}

	/**
	 * Indica si es el valor por defecto.
	 * 
	 * @return Si es el valor por defecto.
	 */
	public boolean isValorPorDefecto() {
		return valorPorDefecto;
	}

	/**
	 * Establece si es el valor por defecto.
	 * 
	 * @param valorPorDefecto
	 *            Si es el valor por defecto.
	 */
	public void setValorPorDefecto(boolean valorPorDefecto) {
		this.valorPorDefecto = valorPorDefecto;
	}

	/**
	 * Obtiene el t�tulo de la opci�n.
	 * 
	 * @return T�tulo de la opci�n.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el t�tulo de la opci�n.
	 * 
	 * @param titulo
	 *            T�tulo de la opci�n.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene una representaci�n XML del objeto.
	 * 
	 * @param indent
	 *            N�mero de espacios de tabulaci�n.
	 * @return Representaci�n del objeto.
	 */
	public String toXML(int indent) {
		final StringBuffer xml = new StringBuffer();
		final String tabs = StringUtils.repeat(" ", indent);

		// Opci�n
		xml.append(tabs + "<" + TagsFicha.TAG_OPCION);

		// T�tulo
		xml.append(" " + TagsFicha.TAG_TITULO_OPCION + "=\"");
		if (titulo != null)
			xml.append(titulo);

		// Valor por defecto
		if (valorPorDefecto)
			xml.append("\" " + TagsFicha.TAG_VALOR_POR_DEFECTO + "=\"true\" />");
		else
			xml.append("\"/>");

		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
