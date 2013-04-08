package xml.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;

import se.util.MapUtil;
import xml.XMLObject;

import common.Constants;

import fondos.model.CamposBusquedas;
import fondos.model.TiposAccionBusqueda;
import fondos.vos.AccionVO;

/**
 * Clase que almacena la informaci�n de una b�squeda.
 */
public class Busqueda extends XMLObject {

	public static String CAMPO_TIPO_TEXTO_CORTO = "8";

	public static String CAMPO_TIPO_TEXTO_LARGO = "9";

	public static String CAMPO_TIPO_FECHA = "3";

	public static String CAMPO_TIPO_NUMERICO = "2";

	private int indexCampoNumerico = 0;

	private int indexCampoFecha = 0;

	private int indexCampoTextoLargo = 0;

	private int indexCampoTextoCorto = 0;

	private boolean resultadoSinElementosBloqueados = false; // para los
																// resultados de
																// la busqueda
	private boolean TemporalyConElementosBloqueados = false; // especial para
																// algunas
																// consultas del
																// reemplazo

	private boolean activarNiveles = false;

	private boolean activarEstados = false;

	private boolean activarBloqueos = false;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * B�squeda ascendente
	 */
	public static final String ASC = "ASC";

	/**
	 * B�squeda descendente
	 */
	public static final String DESC = "DESC";

	/**
	 * Versi�n de la b�squeda
	 */
	private String version = null;

	/**
	 * Descripci�n de la b�squeda
	 */
	private String descripcion = null;

	/**
	 * Tipo de la b�squeda
	 */
	private String tipo = null;

	/**
	 * Lista de campos de entrada
	 */
	private Map mapEntrada = new LinkedHashMap();

	/**
	 * Lista de campos de salida
	 */
	private Map mapSalida = new LinkedHashMap();

	/**
	 * Lista de acciones permitidas en la b�squeda
	 */
	private List ltAcciones = new ArrayList();

	/**
	 * Tipo de ordenaci�n de los campos resultado
	 */
	private String tipoOrdenacion = null;

	/**
	 * Lista de campos de ordenaci�n
	 */
	private List camposOrdenacion = new ArrayList();

	/**
	 * Map de restricciones
	 */
	private LinkedHashMap restricciones = new LinkedHashMap();

	/**
	 * Constructor.
	 */
	public Busqueda() {
		super();
	}

	public boolean isTemporalyConElementosBloqueados() {
		return TemporalyConElementosBloqueados;
	}

	public void setTemporalyConElementosBloqueados(
			boolean temporalyConElementosBloqueados) {
		TemporalyConElementosBloqueados = temporalyConElementosBloqueados;
	}

	public boolean isResultadoSinElementosBloqueados() {
		return resultadoSinElementosBloqueados;
	}

	public void setResultadoSinElementosBloqueados(
			boolean resultadoSinElementosBloqueados) {
		this.resultadoSinElementosBloqueados = resultadoSinElementosBloqueados;
	}

	/**
	 * @return el descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            el descripcion a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el mapEntrada
	 */
	public Map getMapEntrada() {
		return mapEntrada;
	}

	/**
	 * @param mapEntrada
	 *            el mapEntrada a establecer
	 */
	public void setMapEntrada(Map mapEntrada) {
		this.mapEntrada = mapEntrada;
	}

	/**
	 * @return el mapSalida
	 */
	public Map getMapSalida() {
		return mapSalida;
	}

	/**
	 * @param mapSalida
	 *            el mapSalida a establecer
	 */
	public void setMapSalida(Map mapSalida) {
		this.mapSalida = mapSalida;
	}

	/**
	 * @return el version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            el version a establecer
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Permite a�adir un campo de entrada
	 * 
	 * @param campoBusqueda
	 *            descriptor a a�adir
	 */
	public void addCampoEntrada(CampoBusqueda campoBusqueda) {
		// S�lo a�adir el campo si es visible
		if ((campoBusqueda != null) && (campoBusqueda.getMostrar() != null)
				&& (campoBusqueda.getMostrar().equals(TRUE))) {

			if (!mapEntrada.containsKey(campoBusqueda.getNombre())) { // La
																		// clave
																		// est�
																		// duplicada,
																		// no se
																		// a�ade.

				if (Constants.TRUE_STRING.equals(campoBusqueda.getActivos())) {
					if (CamposBusquedas.CAMPO_ENTRADA_BUSQUEDA_NIVELES_DESCRIPCION
							.equals(campoBusqueda.getNombre()))
						this.activarNiveles = true;
					if (CamposBusquedas.CAMPO_ENTRADA_BUSQUEDA_ESTADO
							.equals(campoBusqueda.getNombre()))
						this.activarEstados = true;
					if (CamposBusquedas.CAMPO_ENTRADA_BUSQUEDA_BLOQUEO
							.equals(campoBusqueda.getNombre()))
						this.activarBloqueos = true;
				}

				if (TRUE.equalsIgnoreCase(campoBusqueda.getConfigurable())) {
					if (CAMPO_TIPO_FECHA.equals(campoBusqueda.getTipo())) {
						campoBusqueda.setIndex(indexCampoFecha);
						indexCampoFecha++;
					} else if (CAMPO_TIPO_TEXTO_CORTO.equals(campoBusqueda
							.getTipo())) {
						campoBusqueda.setIndex(indexCampoTextoCorto);
						indexCampoTextoCorto++;
					} else if (CAMPO_TIPO_TEXTO_LARGO.equals(campoBusqueda
							.getTipo())) {
						campoBusqueda.setIndex(indexCampoTextoLargo);
						indexCampoTextoLargo++;
					} else if (CAMPO_TIPO_NUMERICO.equals(campoBusqueda
							.getTipo())) {
						campoBusqueda.setIndex(indexCampoNumerico);
						indexCampoNumerico++;
					}
				}

				this.mapEntrada.put(campoBusqueda.getNombre(), campoBusqueda);

			}
		}
	}

	/**
	 * Permite a�adir un campo de salida
	 * 
	 * @param campoBusqueda
	 *            descriptor a a�adir
	 */
	public void addCampoSalida(CampoBusqueda campoBusqueda) {
		if ((campoBusqueda != null) && (campoBusqueda.getMostrar() != null)
				&& (campoBusqueda.getMostrar().equals(TRUE)))
			this.mapSalida.put(campoBusqueda.getNombre(), campoBusqueda);
	}

	/**
	 * @return el tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            el tipo a establecer
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return el camposOrdenacion
	 */
	public List getCamposOrdenacion() {
		return camposOrdenacion;
	}

	/**
	 * @param camposOrdenacion
	 *            el camposOrdenacion a establecer
	 */
	public void setCamposOrdenacion(List camposOrdenacion) {
		this.camposOrdenacion = camposOrdenacion;
	}

	/**
	 * Permite a�adir un campo de salida
	 * 
	 * @param campoBusqueda
	 *            descriptor a a�adir
	 */
	public void addCampoOrdenacion(String campo) {
		if (campo != null)
			this.camposOrdenacion.add(campo);
	}

	/**
	 * Permite a�adir una acci�n a la lista de acciones
	 * 
	 * @param id
	 *            Identificador de la accion
	 */
	public void addAccion(String id) {
		if (StringUtils.isNotEmpty(id)
				&& (ArrayUtils.contains(
						TiposAccionBusqueda.tiposAccionesBusqueda, id))) {
			AccionVO accion = TiposAccionBusqueda.getVOAccionBusqueda(id);
			if (accion != null) {
				this.getLtAcciones().add(accion);
			}
		}
	}

	/**
	 * Devuelve la lista de acciones posibles para la b�squeda
	 * 
	 * @return lista de acciones
	 */
	public List getLtAcciones() {
		return ltAcciones;
	}

	/**
	 * @return el tipoOrdenacion
	 */
	public String getTipoOrdenacion() {
		return tipoOrdenacion;
	}

	/**
	 * @param tipoOrdenacion
	 *            el tipoOrdenacion a establecer
	 */
	public void setTipoOrdenacion(String tipoOrdenacion) {
		this.tipoOrdenacion = tipoOrdenacion;
	}

	/**
	 * @return the activarNiveles
	 */
	public boolean isActivarNiveles() {
		return activarNiveles;
	}

	/**
	 * @param activarNiveles
	 *            the activarNiveles to set
	 */
	public void setActivarNiveles(boolean activarNiveles) {
		this.activarNiveles = activarNiveles;
	}

	/**
	 * @return the activarEstados
	 */
	public boolean isActivarEstados() {
		return activarEstados;
	}

	/**
	 * @param activarEstados
	 *            the activarEstados to set
	 */
	public void setActivarEstados(boolean activarEstados) {
		this.activarEstados = activarEstados;
	}

	public boolean isActivarBloqueos() {
		return activarBloqueos;
	}

	public void setActivarBloqueos(boolean activarBloqueos) {
		this.activarBloqueos = activarBloqueos;
	}

	/**
	 * Permite obtener la ordenaci�n de los resultados
	 * 
	 * @return ordenaci�n de los resultados
	 */
	public SortOrderEnum getTipoOrdenacionEnum() {
		if ((tipoOrdenacion != null) && (tipoOrdenacion.equals(DESC)))
			return SortOrderEnum.DESCENDING;
		else
			return SortOrderEnum.ASCENDING;
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
		final String tabs = StringUtils.repeat("  ", indent);

		xml.append(tabs + "<Busqueda");
		xml.append(version != null ? " version=\"" + version + "\"" : "");
		xml.append(descripcion != null ? " descripcion=\"" + descripcion + "\""
				: "");
		xml.append(tipo != null ? " tipo=\"" + tipo + "\"" : "");
		xml.append(">");
		xml.append(Constants.NEWLINE);

		/* Campos de entrada */
		if ((mapEntrada != null) && (!mapEntrada.isEmpty())) {
			xml.append(tabs + "  <entrada>");
			xml.append(Constants.NEWLINE);
			Iterator it = mapEntrada.entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				CampoBusqueda campoBusqueda = (CampoBusqueda) entry.getValue();
				xml.append(tabs + campoBusqueda.toXML(2));
			}
			xml.append(tabs + "  </entrada>");
			xml.append(Constants.NEWLINE);
		}

		/* Campos de salida */
		if ((mapSalida != null) && (!mapSalida.isEmpty())) {
			xml.append(tabs + "  <salida>");
			xml.append(Constants.NEWLINE);
			Iterator it = mapSalida.entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				CampoBusqueda campoBusqueda = (CampoBusqueda) entry.getValue();
				xml.append(tabs + campoBusqueda.toXML(2));
			}
			xml.append(tabs + "  </salida>");
			xml.append(Constants.NEWLINE);
		}

		/* Ordenacion */
		if ((camposOrdenacion != null) && (!camposOrdenacion.isEmpty())) {
			xml.append(tabs + "  <ordenacion");
			xml.append(tipoOrdenacion != null ? " tipo=\"" + tipoOrdenacion
					+ "\"" : "");

			if (!camposOrdenacion.isEmpty()) {
				xml.append(">");

				xml.append(Constants.NEWLINE);
				Iterator it = camposOrdenacion.iterator();
				while (it.hasNext()) {
					String orden = (String) it.next();
					xml.append(tabs + "    <orden>" + orden + "</orden>");
					xml.append(Constants.NEWLINE);
				}

				xml.append(tabs + "  </ordenacion>");
				xml.append(Constants.NEWLINE);
			} else {
				xml.append("/>");
				xml.append(Constants.NEWLINE);
			}
		}

		/* Acciones */
		if ((getLtAcciones() != null) && (!getLtAcciones().isEmpty())) {
			xml.append(tabs + "  <acciones>");
			xml.append(Constants.NEWLINE);
			Iterator it = getLtAcciones().iterator();
			while (it.hasNext()) {
				AccionVO accion = (AccionVO) it.next();
				xml.append(tabs + "    <accion>" + accion.getValue()
						+ "</accion>");
				xml.append(Constants.NEWLINE);
			}

			xml.append(tabs + "  </acciones>");
			xml.append(Constants.NEWLINE);
		}

		/* Restricciones */
		if ((restricciones != null) && (!restricciones.isEmpty())) {
			Iterator it = restricciones.entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				RestriccionCampoBusqueda restriccion = (RestriccionCampoBusqueda) entry
						.getValue();
				xml.append(tabs + restriccion.toXML(2));
			}
			xml.append(Constants.NEWLINE);
		}

		xml.append("</Busqueda>");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

	public List getListaCamposEntrada() {
		return MapUtil.toList(mapEntrada);
	}

	public LinkedHashMap getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(LinkedHashMap restricciones) {
		this.restricciones = restricciones;
	}

	public void addRestriccion(RestriccionCampoBusqueda restriccion) {
		this.restricciones.put(restriccion.getId(), restriccion);
	}

	/**
	 * @return la restricci�n solicitada
	 */
	public RestriccionCampoBusqueda getRestriccion(String key) {
		RestriccionCampoBusqueda restriccion = null;
		if (restricciones != null)
			return (RestriccionCampoBusqueda) restricciones.get(key);
		return restriccion;
	}

	public void setLtAcciones(List ltAcciones) {
		this.ltAcciones = ltAcciones;
	}
}
