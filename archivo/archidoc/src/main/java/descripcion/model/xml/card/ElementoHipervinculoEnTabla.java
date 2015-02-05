package descripcion.model.xml.card;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import common.Constants;

/**
 * Clase que almacena la informaci�n de un elemento de tipo hiperv�nculo de una
 * tabla.
 */
public class ElementoHipervinculoEnTabla extends ElementoHipervinculo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Lista de valores del elemento. */
	private List valores = new LinkedList();

	/**
	 * Constructor.
	 */
	public ElementoHipervinculoEnTabla() {

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

		// Inicio del tag Valores
		xml.append(tabs + "    <" + TagsFicha.TAG_VALORES_DATO + ">");
		xml.append(Constants.NEWLINE);

		// Valores
		for (int i = 0; i < getTotalValores(); i++)
			xml.append(getValor(i).toXML(indent + 6));

		// Cierre del tag Valores
		xml.append(tabs + "    </" + TagsFicha.TAG_VALORES_DATO + ">");
		xml.append(Constants.NEWLINE);

		// Cierre del tag Dato
		xml.append(tabs + "  </" + TagsFicha.TAG_DATO_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		// Tag de cierre
		xml.append(tabs + "</" + TagsFicha.TAG_ELEMENTO + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

	/**
	 * @return the valores
	 */
	public List getValores() {
		return valores;
	}

	/**
	 * @param valores
	 *            the valores to set
	 */
	public void setValores(List valores) {
		this.valores = valores;
	}

	/**
	 * Obtiene un valor de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del valor dentro de la lista.
	 * @return Valor.
	 */
	public Valor getValor(int index) {
		return (Valor) valores.get(index);
	}

	/**
	 * Obtiene el n�mero de valores de la lista.
	 * 
	 * @return N�mero de valores.
	 */
	public int getTotalValores() {
		return valores.size();
	}

	/**
	 * A�ade un valor a la lista.
	 * 
	 * @param valor
	 *            Valor.
	 */
	public void addValor(Valor valor) {
		valores.add(valor);
	}

	/**
	 * Elimina el valor de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del valor a eliminar.
	 */
	public void removeValor(int index) {
		valores.remove(index);
	}

	/**
	 * Elimina todos las valores de la lista.
	 */
	public void clearValores() {
		valores.clear();
	}

	/**
	 * Devuelve la lista de �rdenes de los valores del elemento.
	 * 
	 * @return Lista de �rdenes de valores.
	 */
	public List getOrdenes() {
		List ordenes = new LinkedList();
		for (int i = 0; i < getTotalValores(); i++)
			ordenes.add(new Integer(getValor(i).getOrden()));

		return ordenes;
	}
}