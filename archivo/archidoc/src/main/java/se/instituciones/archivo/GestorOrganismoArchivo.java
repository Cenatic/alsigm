package se.instituciones.archivo;

import gcontrol.vos.CAOrganoVO;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import se.NotAvailableException;
import se.instituciones.GestorOrganismos;
import se.instituciones.InfoOrgano;
import se.instituciones.InfoOrganoImpl;
import se.instituciones.TipoAtributo;
import se.instituciones.exceptions.GestorOrganismosException;
import se.usuarios.ServiceClient;

import common.MultiEntityConstants;
import common.bi.GestionControlUsuariosBI;
import common.bi.ServiceRepository;
import common.exceptions.SistemaExternoException;

/**
 * Conector con el Sistemas Gestor de Organizaci�n de Archivo.
 */
public class GestorOrganismoArchivo implements GestorOrganismos {

	/** Logger de la clase. */
	protected static final Logger logger = Logger
			.getLogger(GestorOrganismoArchivo.class);

	/** Par�metros de configuraci�n del conector. */
	protected Properties parametros = new Properties();

	/**
	 * Inicializa con los par�metros de configuraci�n.
    *
	 * @param params
	 *            Par�metros de configuraci�n.
	 * @throws SistemaExternoException
	 *             si ocurre alg�n error.
	 */
	public void initialize(Properties params) {
		this.parametros.putAll(new HashMap(params));
	}

	/**
	 * Recupera la lista de �rganos que son hijos del �rgano cuyo identificador
	 * es idOrgPadre. Para los �rganos que no tienen padre se pasa null.
    *
	 * @param idOrgPadre
	 *            Identificador del �rgano padre.
	 * @return Lista de �rganos.
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarHijosDeOrgano(String idOrgPadre)
			throws GestorOrganismosException, NotAvailableException {
		return null;
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
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganosDependientes(String idOrg, int numNiveles)
			throws GestorOrganismosException, NotAvailableException {
		return null;
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
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganosAntecesores(String idOrg, int numNiveles)
			throws GestorOrganismosException, NotAvailableException {
		return null;
	}

	/**
	 * Recupera la lista de �rganos que tienen el valor de param como subtexto
	 * dentro de su nombre.
    *
	 * @param param
	 *            Texto en el nombre del �rgano.
	 * @return Lista de �rganos.
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganos(String param)
			throws GestorOrganismosException, NotAvailableException {
		InfoOrganoImpl info = null;

		String entity = null;

		if (parametros != null)
			entity = parametros.getProperty(MultiEntityConstants.ENTITY_PARAM);

		ServiceClient serviceClient = ServiceClient.createWithEntity(entity);

		ServiceRepository services = ServiceRepository
				.getInstance(serviceClient);
		GestionControlUsuariosBI gcu = services
				.lookupGestionControlUsuariosBI();
		// CAOrganoVO organo = gcu.getOrganoUsuarioValido(idUsr);
		List organos = gcu.findOrganosByName(param,true);

		return organos;
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
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public InfoOrgano recuperarOrgano(short tipoAtrib, String valorAtrib)
			throws GestorOrganismosException, NotAvailableException {
		String entity = null;

		if (parametros != null)
			entity = parametros.getProperty(MultiEntityConstants.ENTITY_PARAM);

		ServiceClient serviceClient = ServiceClient.createWithEntity(entity);

		ServiceRepository services = ServiceRepository
				.getInstance(serviceClient);
		GestionControlUsuariosBI gcu = services
				.lookupGestionControlUsuariosBI();
		CAOrganoVO organo =  null;

		if(tipoAtrib == TipoAtributo.IDENTIFICADOR_ORGANO){
			organo = gcu.getCAOrgProductorVOXId(valorAtrib);
		}
		else if(tipoAtrib == TipoAtributo.CODIGO_ORGANO){
			organo = gcu.getCAOrgProductorVOByCodigo(valorAtrib);
		}
		return organo;
	}

	/**
	 * Recupera la informaci�n b�sica del �rgano al que pertenece un usuario
	 * cuyo identificador es idUsr.
    *
	 * @param idUsr
	 *            Identificador de usuario.
	 * @return Informaci�n b�sica de un �rgano.
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public InfoOrgano recuperarOrganodeUsuario(String idUsr)
			throws GestorOrganismosException, NotAvailableException {
		InfoOrganoImpl info = null;

		String entity = null;

		if (parametros != null)
			entity = parametros.getProperty(MultiEntityConstants.ENTITY_PARAM);

		ServiceClient serviceClient = ServiceClient.createWithEntity(entity);

		ServiceRepository services = ServiceRepository
				.getInstance(serviceClient);
		GestionControlUsuariosBI gcu = services
				.lookupGestionControlUsuariosBI();
		// CAOrganoVO organo = gcu.getOrganoUsuarioValido(idUsr);
		CAOrganoVO organo = gcu.getOrganoUsuarioEnArchivo(idUsr);
		if (organo != null)
			info = new InfoOrganoImpl(organo.getIdOrg(), organo.getCodigo(),
					organo.getNombre());

		return info;
	}

	/**
	 * Recupera una lista de identificadores de usuarios que pertenecen a los
	 * �rganos cuyos identificadores se pasan en el par�metro idOrgs.
    *
	 * @param idOrgs
	 *            Lista de identificadores de �rganos.
	 * @return Lista de identificadores de usuarios.
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarUsuariosDeOrganos(List idOrgs)
			throws GestorOrganismosException, NotAvailableException {
		String entity = null;

		if (parametros != null)
			entity = parametros.getProperty(MultiEntityConstants.ENTITY_PARAM);

		ServiceClient serviceClient = ServiceClient.createWithEntity(entity);

		ServiceRepository services = ServiceRepository
				.getInstance(serviceClient);
		GestionControlUsuariosBI gcu = services
				.lookupGestionControlUsuariosBI();
		return gcu.getUsuariosOrganos(idOrgs);
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
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarInstitucionesProductoras()
			throws GestorOrganismosException, NotAvailableException {
		return null;
	}

}
