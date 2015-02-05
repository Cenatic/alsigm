package descripcion.model.xml.card;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;
import common.db.DBUtils;

import descripcion.model.xml.definition.DefTipos;

/**
 * Clase que almacena la informaci�n de edici�n de un dato num�rico.
 */
public class EdicionDatoNumerico extends EdicionDato {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Tipo num�rico. */
	private short tipoNumerico = DefTipos.TIPO_NUMERICO_DESCONOCIDO;

	/** Tipo de medida. */
	private short tipoMedida = DefTipos.TIPO_MEDIDA_DESCONOCIDO;

	/** Unidad de medida. */
	private String unidadMedida = null;

	/** Rango m�nimo. */
	private Double rangoMinimo = null;

	/** Rango m�ximo. */
	private Double rangoMaximo = null;

	/** Si hay que mostrar el tipo de n�mero. */
	private boolean mostrarTipoNumero = true;

	/** Si hay que mostrar la unidad del n�mero. */
	private boolean mostrarUnidadNumero = true;

	/** Identificador de la tabla de validaci�n. */
	private String idTblVld = null;

	/** Lista de valores posibles del campo. */
	private List opciones = new LinkedList();

	/**
	 * Constructor.
	 */
	public EdicionDatoNumerico() {
		super(DefTipos.TIPO_DATO_NUMERICO);
	}

	/**
	 * Obtiene el rango m�ximo.
    *
	 * @return Rango m�ximo.
	 */
	public Double getRangoMaximo() {
		return rangoMaximo;
	}

	/**
	 * Establece el rango m�ximo.
    *
	 * @param rangoMaximo
	 *            Rango m�ximo.
	 */
	public void setRangoMaximo(Double rangoMaximo) {
		this.rangoMaximo = rangoMaximo;
	}

	/**
	 * Obtiene el rango m�nimo.
    *
	 * @return Rango m�nimo.
	 */
	public Double getRangoMinimo() {
		return rangoMinimo;
	}

	/**
	 * Establece el rango m�nimo.
    *
	 * @param rangoMinimo
	 *            Rango m�nimo.
	 */
	public void setRangoMinimo(Double rangoMinimo) {
		this.rangoMinimo = rangoMinimo;
	}

	/**
	 * Obtiene el tipo de medida.
    *
	 * @return Tipo de medida.
	 */
	public short getTipoMedida() {
		return tipoMedida;
	}

	/**
	 * Establece el tipo de medida.
    *
	 * @param tipoMedida
	 *            Tipo de medida.
	 */
	public void setTipoMedida(short tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	/**
	 * Obtiene el tipo num�rico.
    *
	 * @return Tipo num�rico.
	 */
	public short getTipoNumerico() {
		return tipoNumerico;
	}

	/**
	 * Establece el tipo num�rico.
    *
	 * @param tipoNumerico
	 *            Tipo num�rico.
	 */
	public void setTipoNumerico(short tipoNumerico) {
		this.tipoNumerico = tipoNumerico;
	}

	/**
	 * Obtiene la unidad de medida.
    *
	 * @return Unidad de medida.
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * Establece la unidad de medida.
    *
	 * @param unidadMedida
	 *            Unidad de medida.
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * Indica si hay que mostrar la unidad del n�mero.
    *
	 * @return Si hay que mostrar la unidad del n�mero.
	 */
	public boolean isMostrarTipoNumero() {
		return mostrarTipoNumero;
	}

	/**
	 * Establece si hay que mostrar la unidad del n�mero.
    *
	 * @param mostrarTipoNumero
	 *            Si hay que mostrar la unidad del n�mero.
	 */
	public void setMostrarTipoNumero(boolean mostrarTipoNumero) {
		this.mostrarTipoNumero = mostrarTipoNumero;
	}

	/**
	 * Indica si hay que mostrar el tipo de n�mero.
    *
	 * @return Si hay que mostrar el tipo de n�mero.
	 */
	public boolean isMostrarUnidadNumero() {
		return mostrarUnidadNumero;
	}

	/**
	 * Establece si hay que mostrar el tipo de n�mero.
    *
	 * @param mostrarUnidadNumero
	 *            Si hay que mostrar el tipo de n�mero.
	 */
	public void setMostrarUnidadNumero(boolean mostrarUnidadNumero) {
		this.mostrarUnidadNumero = mostrarUnidadNumero;
	}

	public String getIdTblVld() {
		return idTblVld;
	}

	public void setIdTblVld(String idTblVld) {
		this.idTblVld = StringUtils.trimToEmpty(idTblVld);
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

		// Obligatorio
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(DBUtils.getStringValue(isObligatorio()));
		xml.append("</" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(Constants.NEWLINE);

		// Valor inicial
		if (getValorInicial() != null)
			xml.append(getValorInicial().toXML(indent + 2));

		// Tipo num�rico
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_TIPO_NUMERICO + ">");
		xml.append(tipoNumerico);
		xml.append("</" + TagsFicha.TAG_EDICION_TIPO_NUMERICO + ">");
		xml.append(Constants.NEWLINE);

		// Medida
		if ((tipoMedida != DefTipos.TIPO_MEDIDA_DESCONOCIDO)
				|| (unidadMedida != null)) {
			xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_MEDIDA + " "
					+ TagsFicha.ATTR_EDICION_MEDIDA_TIPO + "=\"");
			if (tipoMedida != DefTipos.TIPO_MEDIDA_DESCONOCIDO)
				xml.append(tipoMedida);

			xml.append("\" " + TagsFicha.ATTR_EDICION_MEDIDA_UNIDAD + "=\"");
			if (unidadMedida != null)
				xml.append(unidadMedida);

			xml.append("\"/>");
			xml.append(Constants.NEWLINE);
		}

		// Rango
		if ((rangoMinimo != null) || (rangoMaximo != null)) {
			xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_RANGO + " "
					+ TagsFicha.ATTR_EDICION_RANGO_MINIMO + "=\"");
			if (rangoMinimo != null)
				xml.append(rangoMinimo);
			xml.append("\" " + TagsFicha.ATTR_EDICION_RANGO_MAXIMO + "=\"");
			if (rangoMaximo != null)
				xml.append(rangoMaximo);
			xml.append("\"/>");
			xml.append(Constants.NEWLINE);
		}

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

		// Mostrar_Tipo_Numero
		if (!mostrarTipoNumero) {
			xml.append(tabs + "  <" + TagsFicha.TAG_MOSTRAR_TIPO_NUMERO + ">");
			xml.append(Constants.FALSE_STRING);
			xml.append("</" + TagsFicha.TAG_MOSTRAR_TIPO_NUMERO + ">");
			xml.append(Constants.NEWLINE);
		}

		// Mostrar_Unidad_Numero
		if (!mostrarUnidadNumero) {
			xml.append(tabs + "  <" + TagsFicha.TAG_MOSTRAR_UNIDAD_NUMERO + ">");
			xml.append(Constants.FALSE_STRING);
			xml.append("</" + TagsFicha.TAG_MOSTRAR_UNIDAD_NUMERO + ">");
			xml.append(Constants.NEWLINE);
		}

		// Tag de cierre
		xml.append(tabs + "</" + TagsFicha.TAG_EDICION + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
