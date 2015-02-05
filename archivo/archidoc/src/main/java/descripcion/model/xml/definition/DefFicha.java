package descripcion.model.xml.definition;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;

import common.Constants;
import common.util.TypeConverter;

import descripcion.model.eventos.EventoFichaException;
import descripcion.model.eventos.IEventoFicha;
import descripcion.model.xml.XmlElement;
import descripcion.model.xml.card.Ficha;
import descripcion.model.xml.card.UdocFechaFormater;

/**
 * Clase que modeliza la definici�n de una ficha ISAD(G).
 */
public class DefFicha extends XmlElement {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Logger de la clase. */
	private Logger logger = Logger.getLogger(DefFicha.class);

	/** Versi�n de la definici�n por defecto. */
	public static final String DEFAULT_VERSION = "01.00";

	/** Versi�n de la definici�n. */
	private String version = DEFAULT_VERSION;

	/** �reas de la ficha. */
	private List areas = new LinkedList();

	/**
	 * Nombre cualificado de la clase Java que implementa la funcionalidad de
	 * generaci�n de autom�ticos.
	 */
	private String claseGenerarAutomaticos = null;

	/** Eventos de la ficha. */
	private List eventos = new LinkedList();

	/** Identificador de la ficha */
	private String id = null;

	private String separadorFechasDefecto;

	/**
	 * Constructor.
	 */
	public DefFicha(String separadorFechasDefecto) {
		super();
		this.separadorFechasDefecto = separadorFechasDefecto;
	}

	public String getSeparadorDefectoFechasRelacion() {
		return separadorFechasDefecto;
	}

	/**
	 * @param separadorDefecto
	 *            the separadorDefecto to set
	 */
	public void setSeparadorDefecto(String separadorDefecto) {
		this.separadorFechasDefecto = separadorDefecto;
	}

	/**
	 * Obtiene la versi�n de la definici�n.
	 * 
	 * @return Versi�n de la definici�n.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Establece la versi�n de la definici�n.
	 * 
	 * @param version
	 *            Versi�n de la definici�n.
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * A�ade un �rea a la lista.
	 * 
	 * @param area
	 *            �rea.
	 */
	public void addArea(DefArea area) {
		areas.add(area);
	}

	/**
	 * Obtiene un �rea de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del �rea dentro de la lista.
	 * @return �rea.
	 */
	public DefArea getArea(int index) {
		return (DefArea) areas.get(index);
	}

	/**
	 * Obtiene la lista de areas.
	 * 
	 * @return Lista de areas.
	 */
	public DefArea[] getAreas() {
		return (DefArea[]) areas.toArray(new DefArea[areas.size()]);
	}

	/**
	 * Obtiene el n�mero de �reas de la lista.
	 * 
	 * @return N�mero de areas.
	 */
	public int getTotalAreas() {
		return areas.size();
	}

	/**
	 * Elimina el �rea de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del �rea a eliminar.
	 */
	public void removeArea(int index) {
		areas.remove(index);
	}

	/**
	 * Elimina el �rea de la lista.
	 * 
	 * @param area
	 *            �rea a eliminar.
	 */
	public void removeArea(DefArea area) {
		areas.remove(area);
	}

	/**
	 * Elimina todas las �reas de la lista.
	 */
	public void clearAreas() {
		areas.clear();
	}

	/**
	 * Obtiene el nombre cualificado de la clase Java que implementa la
	 * funcionalidad de generaci�n de autom�ticos.
	 * 
	 * @return Nombre cualificado de la clase Java.
	 */
	public String getClaseGenerarAutomaticos() {
		return claseGenerarAutomaticos;
	}

	/**
	 * Establece el nombre cualificado de la clase Java que implementa la
	 * funcionalidad de generaci�n de autom�ticos.
	 * 
	 * @param claseGenerarAutomaticos
	 *            Nombre cualificado de la clase Java.
	 */
	public void setClaseGenerarAutomaticos(String claseGenerarAutomaticos) {
		this.claseGenerarAutomaticos = claseGenerarAutomaticos;
	}

	/**
	 * Permite obtener el identificador de la ficha
	 * 
	 * @return identificador de la ficha
	 */
	public String getId() {
		return id;
	}

	/**
	 * Permite establecer el identificador de la ficha
	 * 
	 * @param id
	 *            identificador de la ficha
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * A�ade un evento a la lista.
	 * 
	 * @param evento
	 *            Evento.
	 */
	public void addEvento(DefEvento evento) {
		eventos.add(evento);
	}

	/**
	 * Obtiene un evento de la lista en funci�n de su posici�n.
	 * 
	 * @param index
	 *            Posici�n del evento dentro de la lista.
	 * @return DefEvento.
	 */
	public DefEvento getEvento(int index) {
		return (DefEvento) eventos.get(index);
	}

	/**
	 * Obtiene la lista de eventos.
	 * 
	 * @return Lista de eventos.
	 */
	public DefEvento[] getEventos() {
		return (DefEvento[]) eventos.toArray(new DefEvento[eventos.size()]);
	}

	/**
	 * Obtiene el n�mero de eventos de la lista.
	 * 
	 * @return N�mero de eventos.
	 */
	public int getTotalEventos() {
		return eventos.size();
	}

	/**
	 * Elimina el evento de la posici�n determinada.
	 * 
	 * @param index
	 *            Posici�n del evento a eliminar.
	 */
	public void removeEvento(int index) {
		eventos.remove(index);
	}

	/**
	 * Elimina el evento de la lista.
	 * 
	 * @param evento
	 *            Evento a eliminar.
	 */
	public void removeEvento(DefEvento evento) {
		eventos.remove(evento);
	}

	/**
	 * Elimina todas las eventos de la lista.
	 */
	public void clearEventos() {
		eventos.clear();
	}

	public DefCampoEspecial getDatoEspecial(String idCampoDato) {

		DefCampoEspecial campo = null;
		boolean encont = false;

		for (int contAreas = 0; !encont && (contAreas < getTotalAreas()); contAreas++) {
			DefArea defArea = getArea(contAreas);
			for (int contCampos = 0; !encont
					&& (contCampos < defArea.getTotalCampos()); contCampos++) {
				DefCampo defCampo = defArea.getCampo(contCampos);
				if (defCampo.getId().equals(idCampoDato)) {
					campo = (DefCampoEspecial) defCampo;
					encont = true;
				}
			}
		}

		return campo;
	}

	/**
	 * Obtiene un campo de tipo dato por su identificador.
	 * 
	 * @param idCampoDato
	 *            Identificador del dato.
	 * @return Dato.
	 */
	public DefCampoDato getDato(String idCampoDato) {
		DefCampoDato campo = null;
		boolean encont = false;

		for (int contAreas = 0; !encont && (contAreas < getTotalAreas()); contAreas++) {
			DefArea defArea = getArea(contAreas);
			for (int contCampos = 0; !encont
					&& (contCampos < defArea.getTotalCampos()); contCampos++) {
				DefCampo defCampo = defArea.getCampo(contCampos);
				switch (defCampo.getTipo()) {
				case DefTipos.TIPO_CAMPO_DATO:
					if (defCampo.getId().equals(idCampoDato)) {
						campo = (DefCampoDato) defCampo;
						encont = true;
					}
					break;

				case DefTipos.TIPO_CAMPO_TABLA:
					for (int contCamposTabla = 0; !encont
							&& (contCamposTabla < ((DefCampoTabla) defCampo)
									.getTotalCampos()); contCamposTabla++) {
						DefCampo defCampoTabla = ((DefCampoTabla) defCampo)
								.getCampo(contCamposTabla);
						if (defCampoTabla.getId().equals(idCampoDato)) {
							campo = (DefCampoDato) defCampoTabla;
							encont = true;
						}
					}
					break;
				}
			}
		}

		return campo;
	}

	/**
	 * Obtiene un campo de tipo tabla por su identificador.
	 * 
	 * @param idCampoTabla
	 *            Identificador de la tabla.
	 * @return Tabla.
	 */
	public DefCampoTabla getTabla(String idCampoTabla) {
		DefCampoTabla campo = null;
		boolean encont = false;

		for (int contAreas = 0; !encont && (contAreas < getTotalAreas()); contAreas++) {
			DefArea defArea = getArea(contAreas);
			for (int contCampos = 0; !encont
					&& (contCampos < defArea.getTotalCampos()); contCampos++) {
				DefCampo defCampo = defArea.getCampo(contCampos);
				if ((defCampo.getTipo() == DefTipos.TIPO_CAMPO_TABLA)
						&& defCampo.getId().equals(idCampoTabla)) {
					campo = (DefCampoTabla) defCampo;
					encont = true;
				}
			}
		}

		return campo;
	}

	/**
	 * Ejecuta el evento seleccionado de la ficha.
	 * 
	 * @param tipoEvento
	 *            Tipo de evento lanzado.
	 * @param ficha
	 *            Ficha de descripci�n.
	 * @throws EventoFichaException
	 *             si ocurre alg�n error en el evento.
	 */
	public ActionErrors ejecutarEvento(int tipoEvento, Ficha ficha,
			Locale locale) throws EventoFichaException {
		ActionErrors errores = new ActionErrors();

		for (int i = 0; i < eventos.size(); i++) {
			DefEvento evento = (DefEvento) eventos.get(i);

			if ((tipoEvento == TypeConverter.toInt(evento.getTipo(), -1))
					&& StringUtils.isNotBlank(evento.getClase())) {
				if (logger.isInfoEnabled())
					logger.info("Evento tipo " + tipoEvento + ": "
							+ evento.getClase());

				try {
					IEventoFicha evnt = (IEventoFicha) Class.forName(
							evento.getClase()).newInstance();
					ActionErrors eventErrors = evnt.executeEvent(tipoEvento,
							ficha, locale);

					errores.add(eventErrors);
				} catch (ClassNotFoundException e) {
					throw new EventoFichaException(e);
				} catch (IllegalAccessException e) {
					throw new EventoFichaException(e);
				} catch (InstantiationException e) {
					throw new EventoFichaException(e);
				}
			}
		}

		return errores;
	}

	/**
	 * Obtiene la lista de datos obligatorios.
	 * 
	 * @return Lista de datos ({@link DefCampoDato}).
	 */
	public List getDatosObligatorios() {
		List obligatorios = new ArrayList();

		DefArea defArea;
		DefCampo defCampo;
		DefCampoDato defCampoDato;

		for (int contAreas = 0; contAreas < getTotalAreas(); contAreas++) {
			defArea = getArea(contAreas);
			for (int contCampos = 0; contCampos < defArea.getTotalCampos(); contCampos++) {
				defCampo = defArea.getCampo(contCampos);
				switch (defCampo.getTipo()) {
				case DefTipos.TIPO_CAMPO_DATO:
					if (((DefCampoDato) defCampo).isObligatorio())
						obligatorios.add(defCampo);
					break;

				case DefTipos.TIPO_CAMPO_TABLA:
					for (int contCamposTabla = 0; contCamposTabla < ((DefCampoTabla) defCampo)
							.getTotalCampos(); contCamposTabla++) {
						defCampoDato = (DefCampoDato) ((DefCampoTabla) defCampo)
								.getCampo(contCamposTabla);
						if (defCampoDato.isObligatorio())
							obligatorios.add(defCampoDato);
					}
					break;
				}
			}
		}

		return obligatorios;
	}

	public UdocFechaFormater getSeparadoresFechas(String idCampo, String tipo,
			Date fecha) {
		UdocFechaFormater udocFechaFormater = new UdocFechaFormater(tipo,
				fecha, separadorFechasDefecto);

		String idCampoDato = idCampo;
		DefCampoDato campoDato = getDato(idCampoDato);
		String separador = getSeparador(campoDato, tipo);

		if (StringUtils.isNotBlank(separador)) {
			udocFechaFormater.setSeparador(separador);
		}

		return udocFechaFormater;
	}

	private String getSeparador(DefCampoDato defCampoDato, String tipo) {
		String separador = null;

		if (defCampoDato != null) {
			DefInformacionEspecifica defInformacionEspecifica = defCampoDato
					.getInformacionEspecifica();

			if (defInformacionEspecifica != null) {
				separador = defInformacionEspecifica.getSeparadorTipo(tipo);
			}
		}

		if (separador == null) {
			separador = getSeparadorDefectoFechasRelacion();
		}

		return separador;
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

		// XML
		xml.append(tabs + "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		xml.append(Constants.NEWLINE);

		// Definici�n_Ficha
		xml.append(tabs + "<" + DefTags.TAG_DEFINITION + " "
				+ DefTags.ATTR_VERSION + "=\"");
		xml.append(version != null ? version : DEFAULT_VERSION);
		xml.append("\">");
		xml.append(Constants.NEWLINE);

		// Informaci�n campos
		if (areas.size() > 0) {
			xml.append(tabs + "  <" + DefTags.TAG_INFORMACION_CAMPOS + ">");
			xml.append(Constants.NEWLINE);

			for (int i = 0; i < areas.size(); i++)
				xml.append(getArea(i).toXML(indent + 4));

			xml.append(tabs + "  </" + DefTags.TAG_INFORMACION_CAMPOS + ">");
			xml.append(Constants.NEWLINE);
		}

		// Clase generaci�n autom�ticos
		if ((claseGenerarAutomaticos != null)
				&& (claseGenerarAutomaticos.length() > 0)) {
			xml.append(tabs + "  <" + DefTags.TAG_CLASE_GENERAR_AUTOMATICOS
					+ ">");
			xml.append(claseGenerarAutomaticos);
			xml.append("</" + DefTags.TAG_CLASE_GENERAR_AUTOMATICOS + ">");
			xml.append(Constants.NEWLINE);
		}

		// Eventos
		if (eventos.size() > 0) {
			xml.append(tabs + "  <" + DefTags.TAG_EVENTOS + ">");
			xml.append(Constants.NEWLINE);

			for (int i = 0; i < eventos.size(); i++)
				xml.append(getEvento(i).toXML(indent + 4));

			xml.append(tabs + "  </" + DefTags.TAG_EVENTOS + ">");
			xml.append(Constants.NEWLINE);
		}

		xml.append(tabs + "</" + DefTags.TAG_DEFINITION + ">");
		xml.append(Constants.NEWLINE);

		return xml.toString();
	}
}
