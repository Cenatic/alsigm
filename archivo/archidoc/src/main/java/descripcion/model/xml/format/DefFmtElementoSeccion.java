package descripcion.model.xml.format;

import org.apache.commons.lang.StringUtils;

import common.Constants;

/**
 * Clase que almacena la informaci�n de un elemento de tipo secci�n.
 */
public class DefFmtElementoSeccion extends DefFmtContenedorElementos {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Indica si la secci�n aparecer� desplegada. */
	private String desplegada = null;

	/**
	 * Constructor.
	 */
	public DefFmtElementoSeccion() {
		super(DefFmtTiposElemento.TIPO_ELEMENTO_SECCION);
	}

	/**
	 * Indica si la secci�n aparecer� desplegada.
	 * 
	 * @return Si la secci�n aparecer� desplegada.
	 */
	public String getDesplegada() {
		return desplegada;
	}

	/**
	 * Establece si la secci�n aparecer� desplegada.
	 * 
	 * @param desplegada
	 *            Si la secci�n aparecer� desplegada.
	 */
	public void setDesplegada(String desplegada) {
		this.desplegada = desplegada;
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
		xml.append(tabs + "<" + DefFmtTags.TAG_ELEMENTO + " "
				+ DefFmtTags.ATTR_TIPO_ELEMENTO + "=\""
				+ getNombreTipoElemento() + "\">");
		xml.append(Constants.NEWLINE);

		// Desplegada
		if (Constants.TRUE_STRING.equals(desplegada)) {
			xml.append(tabs + "  <" + DefFmtTags.TAG_DESPLEGADA + ">");
			xml.append(desplegada);
			xml.append("</" + DefFmtTags.TAG_DESPLEGADA + ">");
			xml.append(Constants.NEWLINE);
		}

		// Etiqueta
		xml.append(etiqueta.toXML(indent + 2));

		// Inicio del tag Elementos
		xml.append(tabs + "  <" + DefFmtTags.TAG_ELEMENTOS_SECCION + ">");
		xml.append(Constants.NEWLINE);

		// Elementos
		for (int i = 0; i < getTotalElementos(); i++)
			xml.append(getElemento(i).toXML(indent + 4));

		// Fin del tag Elementos
		xml.append(tabs + "  </" + DefFmtTags.TAG_ELEMENTOS_SECCION + ">");
		xml.append(Constants.NEWLINE);

		// Tag de cierre
		xml.append(tabs + "</" + DefFmtTags.TAG_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
