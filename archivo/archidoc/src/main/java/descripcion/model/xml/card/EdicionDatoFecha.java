package descripcion.model.xml.card;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;
import common.db.DBUtils;

import descripcion.model.xml.definition.DefTipos;

/**
 * Clase que almacena la informaci�n de edici�n de un dato de tipo fecha.
 */
public class EdicionDatoFecha extends EdicionDato {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Lista de formatos de la fecha. */
	private List formatos = new LinkedList();

	/** Indica si las fechas extremas son editables */
	private boolean isFechasExtremasEditables = true;

	/**
	 * Constructor.
	 */
	public EdicionDatoFecha() {
		super(DefTipos.TIPO_DATO_FECHA);
	}

	/**
	 * A�ade un formato a la lista.
	 * 
	 * @param formato
	 *            Formato.
	 */
	public void addFormato(Formato formato) {
		formatos.add(formato);
	}

	/**
	 * Obtiene un formato de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del formato dentro de la lista.
	 * @return Formato.
	 */
	public Formato getFormato(int index) {
		return (Formato) formatos.get(index);
	}

	/**
	 * Obtiene la lista de formatos.
	 * 
	 * @return Lista de formatos.
	 */
	public Formato[] getFormatos() {
		return (Formato[]) formatos.toArray(new Formato[formatos.size()]);
	}

	/**
	 * Obtiene el n�mero de formatos de la lista.
	 * 
	 * @return N�mero de formatos.
	 */
	public int getTotalFormatos() {
		return formatos.size();
	}

	/**
	 * Elimina el formato de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del formato a eliminar.
	 */
	public void removeFormato(int index) {
		formatos.remove(index);
	}

	/**
	 * Elimina el formato de la lista.
	 * 
	 * @param formato
	 *            Formato a eliminar.
	 */
	public void removeFormato(Formato formato) {
		formatos.remove(formato);
	}

	/**
	 * Elimina todos los formatos de la lista.
	 */
	public void clearformatos() {
		formatos.clear();
	}

	public boolean isFechasExtremasEditables() {
		return isFechasExtremasEditables;
	}

	public void setFechasExtremasEditables(boolean isFechasExtremasEditables) {
		this.isFechasExtremasEditables = isFechasExtremasEditables;
	}

	public Formato getFormato(String cadFormato) {
		Formato formato = null;
		if (formatos != null) {
			Formato busq = new Formato();
			busq.setTipo(cadFormato);
			int index = formatos.indexOf(busq);
			if (index != -1)
				formato = (Formato) formatos.get(index);
		}
		return formato;
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

		if (getTipoPadre() > 0) {
			// Tipo de Padre
			xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_TIPO_PADRE + ">");
			xml.append(getTipoPadre());
			xml.append("</" + TagsFicha.TAG_EDICION_TIPO_PADRE + ">");
			xml.append(Constants.NEWLINE);
		}

		// Fechas extremas editables
		xml.append(tabs + "  <"
				+ TagsFicha.TAG_EDICION_FECHAS_EXTREMAS_EDITABLES + ">");
		xml.append(DBUtils.getStringValue(isFechasExtremasEditables()));
		xml.append("</" + TagsFicha.TAG_EDICION_FECHAS_EXTREMAS_EDITABLES + ">");
		xml.append(Constants.NEWLINE);

		// Obligatorio
		xml.append(tabs + "  <" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(DBUtils.getStringValue(isObligatorio()));
		xml.append("</" + TagsFicha.TAG_EDICION_OBLIGATORIO + ">");
		xml.append(Constants.NEWLINE);

		// Valor inicial
		if (getValorInicial() != null)
			xml.append(getValorInicial().toXML(indent + 2));

		// Formatos
		if (formatos.size() > 0) {
			// Inicio del tag formatos
			xml.append(tabs + "  <" + TagsFicha.TAG_FORMATOS + ">");
			xml.append(Constants.NEWLINE);

			// formatos
			for (int i = 0; i < getTotalFormatos(); i++)
				xml.append(getFormato(i).toXML(indent + 4));

			// Cierre del tag formatos
			xml.append(tabs + "  </" + TagsFicha.TAG_FORMATOS + ">");
			xml.append(Constants.NEWLINE);
		}

		// Tag de cierre
		xml.append(tabs + "</" + TagsFicha.TAG_EDICION + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
