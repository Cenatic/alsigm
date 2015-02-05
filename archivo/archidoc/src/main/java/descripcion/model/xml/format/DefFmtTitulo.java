package descripcion.model.xml.format;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.XmlElement;

/**
 * Clase que almacena la informaci�n de un t�tulo de etiqueta.
 */
public class DefFmtTitulo extends XmlElement {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** T�tulo predeterminado. */
	private String predeterminado = null;

	/**
	 * Constructor.
	 */
	public DefFmtTitulo() {
	}

	/**
	 * Obtiene el t�tulo predeterminado.
	 * 
	 * @return T�tulo predeterminado.
	 */
	public String getPredeterminado() {
		return predeterminado;
	}

	/**
	 * Establece el t�tulo predeterminado.
	 * 
	 * @param predeterminado
	 *            T�tulo predeterminado.
	 */
	public void setPredeterminado(String predeterminado) {
		this.predeterminado = predeterminado;
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

		// Tag de inicio
		xml.append(tabs + "<" + DefFmtTags.TAG_TITULO + " "
				+ DefFmtTags.ATTR_TITULO_PREDETERMINADO + "=\"");
		xml.append(predeterminado != null ? predeterminado : "");
		xml.append("\"></" + DefFmtTags.TAG_TITULO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
