package descripcion.model.xml.card;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;
import common.db.DBUtils;

import descripcion.model.xml.definition.DefTipos;

/**
 * Clase que almacena la informaci�n de edici�n de un texto corto.
 */
public class EdicionDatoTextoCorto extends EdicionDato {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Identificador de la tabla de validaci�n. */
	private String idTblVld = null;

	/** Lista de valores posibles del campo. */
	private List opciones = new LinkedList();

	/**
	 * Constructor.
	 */
	public EdicionDatoTextoCorto() {
		super(DefTipos.TIPO_DATO_TEXTO_CORTO);
	}

	/**
	 * Obtiene el identificador de la tabla de validaci�n.
	 * 
	 * @return Identificador de la tabla de validaci�n.
	 */
	public String getIdTblVld() {
		return idTblVld;
	}

	/**
	 * Establece el identificador de la tabla de validaci�n.
	 * 
	 * @param idTblVld
	 *            Identificador de la tabla de validaci�n.
	 */
	public void setIdTblVld(String idTblVld) {
		this.idTblVld = idTblVld;
	}

	/**
	 * A�ade una opci�n a la lista.
	 * 
	 * @param opcion
	 *            Opci�n.
	 */
	public void addOpcion(Opcion opcion) {
		opciones.add(opcion);
	}

	/**
	 * Obtiene una opci�n de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n de la opci�n dentro de la lista.
	 * @return Opci�n.
	 */
	public Opcion getOpcion(int index) {
		return (Opcion) opciones.get(index);
	}

	/**
	 * Obtiene la lista de opciones.
	 * 
	 * @return Lista de opciones.
	 */
	public Opcion[] getOpciones() {
		return (Opcion[]) opciones.toArray(new Opcion[opciones.size()]);
	}

	/**
	 * Obtiene el n�mero de opciones de la lista.
	 * 
	 * @return N�mero de opciones.
	 */
	public int getTotalOpciones() {
		return opciones.size();
	}

	/**
	 * Elimina la opci�n de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n de la opci�n a eliminar.
	 */
	public void removeOpcion(int index) {
		opciones.remove(index);
	}

	/**
	 * Elimina la opci�n de la lista.
	 * 
	 * @param opcion
	 *            Opci�n a eliminar.
	 */
	public void removeOpcion(Opcion opcion) {
		opciones.remove(opcion);
	}

	/**
	 * Elimina todas las opciones de la lista.
	 */
	public void clearOpciones() {
		opciones.clear();
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
		xml.append(tabs + "<" + TagsFicha.TAG_EDICION + ">");
		xml.append(Constants.NEWLINE);

		// Id
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_ID + ">");
		if (getId() != null)
			xml.append(getId());
		xml.append("</" + TagsFicha.TAG_EDICION_ID + ">");
		xml.append(Constants.NEWLINE);

		// Tipo
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_TIPO + ">");
		xml.append(getTipo());
		xml.append("</" + TagsFicha.TAG_EDICION_TIPO + ">");
		xml.append(Constants.NEWLINE);

		// Multivalor
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_MULTIVALOR + ">");
		xml.append(DBUtils.getStringValue(isMultivalor()));
		xml.append("</" + TagsFicha.TAG_EDICION_MULTIVALOR + ">");
		xml.append(Constants.NEWLINE);

		// Editable
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_EDITABLE + ">");
		xml.append(DBUtils.getStringValue(isEditable()));
		xml.append("</" + TagsFicha.TAG_EDICION_EDITABLE + ">");
		xml.append(Constants.NEWLINE);

		// Padre Editable
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_PADRE_EDITABLE + ">");
		xml.append(DBUtils.getStringValue(isPadreEditable()));
		xml.append("</" + TagsFicha.TAG_EDICION_PADRE_EDITABLE + ">");
		xml.append(Constants.NEWLINE);

		// Tipo de Padre
		if (getTipoPadre() > 0) {
			xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_TIPO_PADRE + ">");
			xml.append(getTipoPadre());
			xml.append("</" + TagsFicha.TAG_EDICION_TIPO_PADRE + ">");
			xml.append(Constants.NEWLINE);
		}

		// Multilinea
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_MULTILINEA + ">");
		xml.append(DBUtils.getStringValue(isMultilinea()));
		xml.append("</" + TagsFicha.TAG_EDICION_MULTILINEA + ">");
		xml.append(Constants.NEWLINE);

		// Obligatorio
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(DBUtils.getStringValue(isObligatorio()));
		xml.append("</" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(Constants.NEWLINE);

		// Valor inicial
		if (getValorInicial() != null)
			xml.append(getValorInicial().toXML(indent + 2));

		// Id_TblVld
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_ID_TBLVLD + ">");
		if (idTblVld != null)
			xml.append(idTblVld);
		xml.append("</" + TagsFicha.TAG_EDICION_ID_TBLVLD + ">");
		xml.append(Constants.NEWLINE);

		// Opciones
		if (opciones.size() > 0) {
			// Inicio del tag Opciones
			xml.append(tabs + "  <" + TagsFicha.TAG_OPCIONES + ">");
			xml.append(Constants.NEWLINE);

			// Opciones
			for (int i = 0; i < getTotalOpciones(); i++)
				xml.append(getOpcion(i).toXML(indent + 4));

			// Cierre del tag Opciones
			xml.append(tabs + "  </" + TagsFicha.TAG_OPCIONES + ">");
			xml.append(Constants.NEWLINE);
		}

		// Tag de cierre
		xml.append(tabs + "</" + TagsFicha.TAG_EDICION + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
