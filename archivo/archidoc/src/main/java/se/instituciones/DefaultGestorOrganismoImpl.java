package se.instituciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Node;

import se.instituciones.exceptions.GestorOrganismosException;
import xml.config.ConfiguracionArchivoManager;

import common.Constants;
import common.exceptions.SistemaExternoException;
import common.util.StringUtils;
import common.util.TypeConverter;

/**
 * Conector con el Sistemas Gestor de Organizaci�n de Archivo.
 */
public class DefaultGestorOrganismoImpl implements GestorOrganismos {

	/** Logger de la clase. */
	protected static final Logger logger = Logger
			.getLogger(DefaultGestorOrganismoImpl.class);

	/** Mapa de relaciones de usuarios con �rganos. */
	private Map userOrganization = new HashMap();

	/** Mapa de �rganos. */
	private Map organos = new HashMap();

	/** Lista de instituciones productoras. */
	private List instituciones = new ArrayList();

	/**
	 * Constructor.
	 */
	public DefaultGestorOrganismoImpl() {
	}

	/**
	 * Inicializa con los par�metros de configuraci�n.
	 * 
	 * @param params
	 *            Par�metros de configuraci�n.
	 * @throws SistemaExternoException
	 *             si ocurre alg�n error.
	 */
	public void initialize(Properties params) throws SistemaExternoException {
		try {
			if (organos.isEmpty()) {
				// SAXReader saxReader = new SAXReader();
				// Document sisOrganizacionDOM = saxReader.read(getClass()
				// .getClassLoader().getResource("test/sistema_gestor_organizacion.xml"));

				Document sisOrganizacionDOM = ConfiguracionArchivoManager
						.getInstance().getDefaultSistemaGestorOrganismo();

				Node node;

				if (sisOrganizacionDOM != null) {
					// Carga de �rganos
					List listaOrganos = sisOrganizacionDOM
							.selectNodes("/sistema_organizacion/organo");
					InfoOrgano unOrgano;
					for (Iterator i = listaOrganos.iterator(); i.hasNext();) {
						node = (Node) i.next();
						unOrgano = new InfoOrganoImpl(
								node.valueOf(Constants.ID),
								node.valueOf("codigo"), node.valueOf("nombre"),
								TypeConverter.toInt(node.valueOf("nivel"), 0),
								node.valueOf("id_padre"));

						organos.put(unOrgano.getId(), unOrgano);

						// si el organo es una institucion lo a�adimos a la list
						// de instituciones
						if (node.valueOf("institucion").equalsIgnoreCase("si"))
							instituciones.add(unOrgano);
					}

					List userOrganoMap = sisOrganizacionDOM
							.selectNodes("/sistema_organizacion/organo_usuario");
					for (Iterator i = userOrganoMap.iterator(); i.hasNext();) {
						node = (Node) i.next();
						userOrganization.put(node.valueOf("usuario"),
								organos.get(node.valueOf("organo")));
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error al leer el fichero de datos de organizaci�n", e);
			throw new GestorOrganismosException(e);
		}
	}

	/**
	 * Recupera la lista de �rganos que son hijos del �rgano cuyo identificador
	 * es idOrgPadre. Para los �rganos que no tienen padre se pasa null.
	 * 
	 * @param idOrgPadre
	 *            Identificador del �rgano padre.
	 * @return Lista de �rganos.
	 */
	public List recuperarHijosDeOrgano(String idOrgPadre) {
		List hijos = new ArrayList();

		Iterator itOrg = organos.values().iterator();
		InfoOrgano organo;
		while (itOrg.hasNext()) {
			organo = (InfoOrgano) itOrg.next();
			if (StringUtils.equalsNullEmpty(idOrgPadre, organo.getIdPadre()))
				hijos.add(organo);
		}

		return hijos;
	}

	/**
	 * Recupera la lista de �rganos que dependen del �rgano, hasta el nivel
	 * jer�rquico especificado en numNiveles; si numNiveles tiene el valor 0, se
	 * recuperan todos los �rganos dependientes hasta el �ltimo nivel.
	 * 
	 * @param idOrg
	 *            Identificador del �rgano.
	 * @param numNiveles
	 *            N�mero de niveles.
	 * @return Lista de �rganos.
	 */
	public List recuperarOrganosDependientes(String idOrg, int numNiveles) {
		List dependientes = new ArrayList();

		if (numNiveles == 0)
			numNiveles = Integer.MAX_VALUE;

		dependientes.addAll(recuperarOrganosDependientesRec(idOrg, numNiveles));

		return dependientes;
	}

	private List recuperarOrganosDependientesRec(String idOrg, int numNiveles) {
		List dependientes = new ArrayList();

		if (numNiveles > 0) {
			List hijos = recuperarHijosDeOrgano(idOrg);
			InfoOrgano organo;
			for (int i = 0; i < hijos.size(); i++) {
				organo = (InfoOrgano) hijos.get(i);
				dependientes.add(organo);
				dependientes.addAll(recuperarOrganosDependientesRec(
						organo.getId(), numNiveles - 1));
			}
		}

		return dependientes;
	}

	/**
	 * Recupera la lista de �rganos antecesores al �rgano, hasta el nivel
	 * jer�rquico especificado en numNiveles; si numNiveles tiene el valor 0, se
	 * recuperan todos los �rganos antecesores hasta el primer nivel.
	 * 
	 * @param idOrg
	 *            Identificador del �rgano.
	 * @param numNiveles
	 *            N�mero de niveles.
	 * @return Lista de �rganos.
	 */
	public List recuperarOrganosAntecesores(String idOrg, int numNiveles) {
		List antecesores = new ArrayList();

		if (numNiveles == 0)
			numNiveles = Integer.MAX_VALUE;

		InfoOrgano organo = (InfoOrgano) organos.get(idOrg);
		while ((organo != null) && StringUtils.isNotEmpty(organo.getIdPadre())
				&& (numNiveles > 0)) {
			organo = (InfoOrgano) organos.get(organo.getIdPadre());
			if (organo != null)
				antecesores.add(0, organo);
			numNiveles--;
		}

		return antecesores;
	}

	/**
	 * Recupera la lista de �rganos que tienen el valor de param como subtexto
	 * dentro de su nombre.
	 * 
	 * @param param
	 *            Texto en el nombre del �rgano.
	 * @return Lista de �rganos.
	 */
	public List recuperarOrganos(String param) {
		List lista = new ArrayList();

		if (StringUtils.isNotBlank(param)) {
			Iterator itOrg = organos.values().iterator();
			InfoOrgano organo;
			while (itOrg.hasNext()) {
				organo = (InfoOrgano) itOrg.next();
				if (organo.getNombre().toUpperCase()
						.indexOf(param.toUpperCase()) >= 0)
					lista.add(organo);
			}
		}

		return lista;
	}

	/**
	 * Recupera la informaci�n b�sica de un �rgano para el atributo cuyo tipo se
	 * pasa en tipoAtrib.
	 * 
	 * @param tipoAtrib
	 *            Tipo de atributo ({@link TipoAtributo}).
	 * @param valorAtrib
	 *            Valor del atributo.
	 * @return Informaci�n b�sica de un �rgano.
	 */
	public InfoOrgano recuperarOrgano(short tipoAtrib, String valorAtrib) {
		if (StringUtils.isNotBlank(valorAtrib)) {
			Iterator itOrg = organos.values().iterator();
			InfoOrgano aux;
			while (itOrg.hasNext()) {
				aux = (InfoOrgano) itOrg.next();

				if (((tipoAtrib == TipoAtributo.IDENTIFICADOR_ORGANO) && valorAtrib
						.equals(aux.getId()))
						|| ((tipoAtrib == TipoAtributo.CODIGO_ORGANO) && valorAtrib
								.equals(aux.getCodigo())))
					return aux;
			}
		}

		return null;
	}

	/**
	 * Recupera la informaci�n b�sica del �rgano al que pertenece un usuario
	 * cuyo identificador es idUsr.
	 * 
	 * @param idUsr
	 *            Identificador de usuario.
	 * @return Informaci�n b�sica de un �rgano.
	 */
	public InfoOrgano recuperarOrganodeUsuario(String idUsr) {
		return (InfoOrgano) userOrganization.get(idUsr);
	}

	/**
	 * Recupera una lista de identificadores de usuarios que pertenecen a los
	 * �rganos cuyos identificadores se pasan en el par�metro idOrgs.
	 * 
	 * @param idOrgs
	 *            Lista de identificadores de �rganos.
	 * @return Lista de identificadores de usuarios.
	 */
	public List recuperarUsuariosDeOrganos(List idOrgs) {
		List usuarios = new ArrayList();

		if (!util.CollectionUtils.isEmpty(idOrgs)) {
			Iterator itUsr = userOrganization.keySet().iterator();
			String idUsuario;
			InfoOrgano organo;
			while (itUsr.hasNext()) {
				idUsuario = (String) itUsr.next();
				organo = (InfoOrgano) userOrganization.get(idUsuario);

				if ((organo != null) && idOrgs.contains(organo.getId()))
					usuarios.add(idUsuario);
			}
		}

		return usuarios;
	}

	/**
	 * Recupera la lista de instituciones con su informaci�n b�sica.
	 * 
	 * @return Lista de instituciones.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link se.instituciones.InfoOrgano}.
	 *         </p>
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 */
	public List recuperarInstitucionesProductoras() {
		return instituciones;
	}
}
