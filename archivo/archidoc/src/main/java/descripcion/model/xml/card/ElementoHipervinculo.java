package descripcion.model.xml.card;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.XmlElement;

/**
 * Clase que almacena la informaci�n de un elemento de tipo hiperv�nculo.
 */
public class ElementoHipervinculo extends Elemento {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Estilo del hiperv�nculo. */
	private String estilo = null;

	/** URL del hiperv�nculo. */
	private String url = null;

	/** Texto del hiperv�nculo. */
	private String texto = null;

	/** Target de la URL. */
	private String target = null;

	/** Parametro del hiperv�nculo */
	private String parameter = null;

	/** Id del campo donde queremos que coja el valor */
	private String idCampo = null;

	/**
	 * Constructor.
	 */
	public ElementoHipervinculo() {
		super(TiposElemento.TIPO_ELEMENTO_HIPERVINCULO);
	}

	/**
	 * Obtiene el Estilo del hiperv�nculo.
	 * 
	 * @return Estilo del hiperv�nculo.
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * Establece el estilo del hiperv�nculo.
	 * 
	 * @param estilo
	 *            Estilo del hiperv�nculo.
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	/**
	 * Obtiene el texto del hiperv�nculo.
	 * 
	 * @return Texto del hiperv�nculo.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Establece el texto del hiperv�nculo.
	 * 
	 * @param texto
	 *            Texto del hiperv�nculo.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Obtiene la URL del hiperv�nculo.
	 * 
	 * @return URL del hiperv�nculo.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establece la URL del hiperv�nculo.
	 * 
	 * @param url
	 *            URL del hiperv�nculo.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Obtiene el target de la URL.
	 * 
	 * @return Target de la URL.
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Establece el target de la URL.
	 * 
	 * @param target
	 *            Target de la URL.
	 */
	public void setTarget(String target) {
		this.target = target;
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
		xml.append(getEtiqueta().toXML(indent + 2));

		// Inicio del tag Dato
		xml.append(tabs + "  <" + TagsFicha.TAG_DATO_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		// URL
		xml.append(tabs + "    <" + TagsFicha.TAG_URL_DATO + ">");
		xml.append(XmlElement.getCDataContent(url));
		xml.append("</" + TagsFicha.TAG_URL_DATO + ">");
		xml.append(Constants.NEWLINE);

		// Texto
		xml.append(tabs + "    <" + TagsFicha.TAG_TEXTO_DATO + ">");
		xml.append(XmlElement.getCDataContent(texto));
		xml.append("</" + TagsFicha.TAG_TEXTO_DATO + ">");
		xml.append(Constants.NEWLINE);

		// Target
		if (StringUtils.isNotBlank(target)) {
			xml.append(tabs + "    <" + TagsFicha.TAG_TARGET_DATO + ">");
			xml.append(target);
			xml.append("</" + TagsFicha.TAG_TARGET_DATO + ">");
			xml.append(Constants.NEWLINE);
		}

		// Estilo
		xml.append(tabs + "    <" + TagsFicha.TAG_ESTILO + ">");
		xml.append(estilo != null ? estilo : "");
		xml.append("</" + TagsFicha.TAG_ESTILO + ">");
		xml.append(Constants.NEWLINE);

		// Parametro
		// Target
		if (StringUtils.isNotBlank(parameter)) {
			xml.append(tabs + "    <" + TagsFicha.TAG_PARAMETRO + ">");
			xml.append(parameter != null ? parameter : "");
			xml.append("</" + TagsFicha.TAG_PARAMETRO + ">");
			xml.append(Constants.NEWLINE);
		}

		// Id Campo valor Parametro
		if (StringUtils.isNotBlank(idCampo)) {
			xml.append(tabs + "    <" + TagsFicha.TAG_VALOR_PARAMETRO + ">");
			xml.append(idCampo != null ? idCampo : "");
			xml.append("</" + TagsFicha.TAG_VALOR_PARAMETRO + ">");
			xml.append(Constants.NEWLINE);
		}

		// Cierre del tag Dato
		xml.append(tabs + "  </" + TagsFicha.TAG_DATO_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		// Tag de cierre
		xml.append(tabs + "</" + TagsFicha.TAG_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

	/**
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * @param parameter
	 *            the parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the idCampo
	 */
	public String getIdCampo() {
		return idCampo;
	}

	/**
	 * @param idCampo
	 *            the idCampo to set
	 */
	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
	}
}
