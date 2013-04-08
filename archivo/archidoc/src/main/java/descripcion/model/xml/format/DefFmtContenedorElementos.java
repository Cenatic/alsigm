package descripcion.model.xml.format;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Clase abstracta de la que deben extender todas las clases que contengan
 * elementos.
 */
public abstract class DefFmtContenedorElementos extends DefFmtElemento {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());

	/** Lista de elementos. */
	private List elementos = new LinkedList();

	private Map idsElementosTabla = new HashMap();
	private Map idsElementosCampoDato = new HashMap();

	/**
	 * Constructor.
	 */
	public DefFmtContenedorElementos() {
		super();
	}

	/**
	 * Constructor.
	 */
	public DefFmtContenedorElementos(short tipo) {
		super(tipo);
	}

	/**
	 * A�ade un elemento a la lista.
	 * 
	 * @param elemento
	 *            Elemento.
	 */
	public void addElemento(DefFmtElemento elemento) {
		if (elemento instanceof DefFmtElementoTabla) {
			DefFmtElementoTabla elementoTabla = (DefFmtElementoTabla) elemento;
			idsElementosTabla.put(elementoTabla.getIdCampoTbl(),
					elementoTabla.getIdCampoTbl());
			idsElementosCampoDato.putAll(elementoTabla
					.getIdsElementosCampoDato());
		} else if (elemento instanceof DefFmtElementoEtiquetaDato) {
			DefFmtElementoEtiquetaDato elementoEtiquetaDato = (DefFmtElementoEtiquetaDato) elemento;
			idsElementosCampoDato.put(elementoEtiquetaDato.getCampo().getId(),
					elementoEtiquetaDato.getCampo().getId());
		} else if (elemento instanceof DefFmtElementoCabecera) {
			DefFmtElementoCabecera elementoEtiquetaCabecera = (DefFmtElementoCabecera) elemento;
			idsElementosCampoDato.putAll(elementoEtiquetaCabecera
					.getIdsElementosCampoDato());
			idsElementosTabla.putAll(elementoEtiquetaCabecera
					.getIdsElementosTabla());
		} else {
			logger.debug(elemento.getClass().toString());
		}

		elementos.add(elemento);
	}

	/**
	 * Obtiene un elemento de la secci�n en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del elemento dentro de la lista.
	 * @return Elemento.
	 */
	public DefFmtElemento getElemento(int index) {
		return (DefFmtElemento) elementos.get(index);
	}

	/**
	 * Obtiene la lista de elementos.
	 * 
	 * @return Lista de elementos.
	 */
	public DefFmtElemento[] getElementos() {
		return (DefFmtElemento[]) elementos
				.toArray(new DefFmtElemento[elementos.size()]);
	}

	/**
	 * Obtiene el n�mero de elementos de la lista.
	 * 
	 * @return N�mero de elementos.
	 */
	public int getTotalElementos() {
		return elementos.size();
	}

	/**
	 * Elimina el elemento de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del elemento a eliminar.
	 */
	public void removeElemento(int index) {
		elementos.remove(index);
	}

	/**
	 * Elimina el elemento de la lista.
	 * 
	 * @param elemento
	 *            Elemento a eliminar.
	 */
	public void removeElemento(DefFmtElemento elemento) {
		elementos.remove(elemento);
	}

	/**
	 * Elimina todos los elementos de la lista.
	 */
	public void clearElementos() {
		elementos.clear();
	}

	/**
	 * @return el idsElementosCampoDato
	 */
	public Map getIdsElementosCampoDato() {
		return idsElementosCampoDato;
	}

	/**
	 * @return el idsElementosTabla
	 */
	public Map getIdsElementosTabla() {
		return idsElementosTabla;
	}

}
