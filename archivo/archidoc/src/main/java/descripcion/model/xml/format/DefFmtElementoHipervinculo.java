package descripcion.model.xml.format;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.card.TagsFicha;

/**
 * Clase que almacena la informaci�n de un elemento de tipo hiperv�nculo.
 */
public class DefFmtElementoHipervinculo extends DefFmtElemento {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** V�nculo. */
	private DefFmtVinculo vinculo;

	/**
	 * Constructor.
	 */
	public DefFmtElementoHipervinculo() {
		super(DefFmtTiposElemento.TIPO_ELEMENTO_HIPERVINCULO);
		vinculo = new DefFmtVinculo();
	}

	/**
	 * Obtiene el v�nculo.
	 * 
	 * @return V�nculo.
	 */
	public DefFmtVinculo getVinculo() {
		return vinculo;
	}

	/**
	 * Establece el v�nculo.
	 * 
	 * @param url
	 *            V�nculo.
	 */
	public void setVinculo(DefFmtVinculo vinculo) {
		this.vinculo = vinculo;
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
		xml.append(tabs + "<" + TagsFicha.TAG_ELEMENTO + " "
				+ TagsFicha.ATTR_TIPO_ELEMENTO + "=\""
				+ getNombreTipoElemento() + "\">");
		xml.append(Constants.NEWLINE);

		// Etiqueta
		xml.append(etiqueta.toXML(indent + 2));

		// V�nculo
		xml.append(vinculo.toXML(indent + 2));

		// Tag de cierre
		xml.append(tabs + "</" + DefFmtTags.TAG_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
