package descripcion.model.xml.definition;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;

import descripcion.model.xml.XmlElement;

/**
 * Clase que almacena la informaci�n de un �rea de la definici�n de la ficha
 * ISAD(G).
 */
public class DefArea extends XmlElement {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Identificador del �rea asociada. */
	private String idAreaAsociada = null;

	/** Lista de campos del �rea. */
	private List campos = new LinkedList();

	/**
	 * Constructor.
	 */
	public DefArea() {
		super();
	}

	/**
	 * Obtiene el identificador del �rea asociada.
	 * 
	 * @return Identificador del �rea asociada.
	 */
	public String getIdAreaAsociada() {
		return idAreaAsociada;
	}

	/**
	 * Establece el identificador del �rea asociada.
	 * 
	 * @param idAreaAsociada
	 *            Identificador del �rea asociada.
	 */
	public void setIdAreaAsociada(String idAreaAsociada) {
		this.idAreaAsociada = idAreaAsociada;
	}

	/**
	 * A�ade un campo a la lista.
	 * 
	 * @param campo
	 *            Campo.
	 */
	public void addCampo(DefCampo campo) {
		campos.add(campo);
	}

	/**
	 * Obtiene un campo de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del campo dentro de la lista.
	 * @return DefCampo.
	 */
	public DefCampo getCampo(int index) {
		return (DefCampo) campos.get(index);
	}

	/**
	 * Obtiene la lista de campos.
	 * 
	 * @return Lista de campos.
	 */
	public DefCampo[] getCampos() {
		return (DefCampo[]) campos.toArray(new DefCampo[campos.size()]);
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
	public void removeCampo(DefCampo campo) {
		campos.remove(campo);
	}

	/**
	 * Elimina todos las campos de la lista.
	 */
	public void clearCampos() {
		campos.clear();
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

		// �rea
		xml.append(tabs + "<" + DefTags.TAG_AREA + ">");
		xml.append(Constants.NEWLINE);

		// Id_Area_Asociada
		xml.append(tabs + "  <" + DefTags.TAG_ID_AREA_ASOCIADA + ">");
		xml.append(idAreaAsociada != null ? idAreaAsociada : "");
		xml.append("</" + DefTags.TAG_ID_AREA_ASOCIADA + ">");
		xml.append(Constants.NEWLINE);

		// Campos
		if (campos.size() > 0) {
			xml.append(tabs + "  <" + DefTags.TAG_CAMPOS + ">");
			xml.append(Constants.NEWLINE);

			for (int i = 0; i < campos.size(); i++)
				xml.append(getCampo(i).toXML(indent + 4));

			xml.append(tabs + "  </" + DefTags.TAG_CAMPOS + ">");
			xml.append(Constants.NEWLINE);
		}

		xml.append(tabs + "</" + DefTags.TAG_AREA + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
