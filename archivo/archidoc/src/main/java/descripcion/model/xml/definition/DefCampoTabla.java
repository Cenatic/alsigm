package descripcion.model.xml.definition;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.card.TagsFicha;

/**
 * Clase que almacena la informaci�n de un campo de tipo tabla de la definici�n
 * de la ficha ISAD(G).
 */
public class DefCampoTabla extends DefCampo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Si es editable. */
	private boolean editable = false;

	/** Lista de campos de la tabla. */
	private List campos = new LinkedList();

	/** Sistema externo */
	private String sistemaExterno;

	/**
	 * Constructor.
	 */
	public DefCampoTabla() {
		super(DefTipos.TIPO_CAMPO_TABLA);
	}

	/**
	 * Indica si es editable.
	 * 
	 * @return Si es editable.
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Establece si es editable.
	 * 
	 * @param editable
	 *            Si es editable.
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * A�ade un campo a la lista.
	 * 
	 * @param campo
	 *            Campo.
	 */
	public void addCampo(DefCampoDato campo) {
		campos.add(campo);
	}

	/**
	 * Obtiene un campo de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del campo dentro de la lista.
	 * @return Campo.
	 */
	public DefCampoDato getCampo(int index) {
		return (DefCampoDato) campos.get(index);
	}

	/**
	 * Obtiene la lista de campos.
	 * 
	 * @return Lista de campos.
	 */
	public DefCampoDato[] getCampos() {
		return (DefCampoDato[]) campos.toArray(new DefCampoDato[campos.size()]);
	}

	/**
	 * Obtiene el n�mero de campos de la lista.
	 * 
	 * @return N�mero de campos.
	 */
	public int getTotalCampos() {
		return campos.size();
	}

	/**
	 * Elimina el campo de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del campo a eliminar.
	 */
	public void removeCampo(int index) {
		campos.remove(index);
	}

	/**
	 * Elimina el campo de la lista.
	 * 
	 * @param campo
	 *            Campo a eliminar.
	 */
	public void removeCampo(DefCampoDato campo) {
		campos.remove(campo);
	}

	/**
	 * Elimina todos las campos de la lista.
	 */
	public void clearCampos() {
		campos.clear();
	}

	public String getSistemaExterno() {
		return sistemaExterno;
	}

	public void setSistemaExterno(String sistemaExterno) {
		this.sistemaExterno = sistemaExterno;
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

		// Campo
		xml.append(tabs + "<" + DefTags.TAG_CAMPO + " "
				+ DefTags.ATTR_TIPO_CAMPO + "=\"" + getNombreTipoCampo()
				+ "\">");
		xml.append(Constants.NEWLINE);

		// Identificador
		xml.append(tabs + "  <" + DefTags.TAG_ID_CAMPO + ">");
		xml.append(id != null ? id : "");
		xml.append("</" + DefTags.TAG_ID_CAMPO + ">");
		xml.append(Constants.NEWLINE);

		// Editable
		xml.append(tabs + "  <" + DefTags.TAG_EDITABLE_CAMPO_DATO + ">");
		xml.append(editable ? Constants.TRUE_STRING : Constants.FALSE_STRING);
		xml.append("</" + DefTags.TAG_EDITABLE_CAMPO_DATO + ">");
		xml.append(Constants.NEWLINE);

		// Validacion
		xml.append(tabs + "  <" + TagsFicha.TAG_VALIDACION_EDICION + ">");
		xml.append(Constants.NEWLINE);
		// Sistema Externo
		if (!common.util.StringUtils.isEmpty(sistemaExterno)) {
			xml.append(tabs + "    <" + TagsFicha.TAG_SISTEMA_EXTERNO_EDICION
					+ ">");
			xml.append(sistemaExterno);
			xml.append("</" + TagsFicha.TAG_SISTEMA_EXTERNO_EDICION + ">");
			xml.append(Constants.NEWLINE);
		}

		xml.append(tabs + "  </" + TagsFicha.TAG_VALIDACION_EDICION + ">");
		xml.append(Constants.NEWLINE);

		// Campos de la tabla
		if (campos.size() > 0) {
			xml.append(tabs + "  <" + DefTags.TAG_COLUMNAS_CAMPO_TABLA + ">");
			xml.append(Constants.NEWLINE);

			for (int i = 0; i < campos.size(); i++)
				xml.append(getCampo(i).toXML(indent + 4));

			xml.append(tabs + "  </" + DefTags.TAG_COLUMNAS_CAMPO_TABLA + ">");
			xml.append(Constants.NEWLINE);
		}

		// Descripci�n
		xml.append(tabs + "  <" + DefTags.TAG_DESCRIPCION_CAMPO + ">");
		xml.append(descripcion != null ? descripcion : "");
		xml.append("</" + DefTags.TAG_DESCRIPCION_CAMPO + ">");
		xml.append(Constants.NEWLINE);

		xml.append(tabs + "</" + DefTags.TAG_CAMPO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
