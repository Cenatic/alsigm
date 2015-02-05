package se.instituciones;

import java.util.List;

import se.NotAvailableException;
import se.Parametrizable;
import se.instituciones.exceptions.GestorOrganismosException;

/**
 * Interfaz para los conectores con Sistemas Gestores de Organizaci�n.
 */
public interface GestorOrganismos extends Parametrizable {

	/**
	 * Recupera la lista de �rganos que son hijos del �rgano cuyo identificador
	 * es idOrgPadre. Para los �rganos que no tienen padre se pasa null.
	 * 
	 * @param idOrgPadre
	 *            Identificador del �rgano padre.
	 * @return Lista de �rganos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoOrgano}.
	 *         </p>
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarHijosDeOrgano(String idOrgPadre)
			throws GestorOrganismosException, NotAvailableException;

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
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoOrgano}.
	 *         </p>
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganosDependientes(String idOrg, int numNiveles)
			throws GestorOrganismosException, NotAvailableException;

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
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoOrgano}.
	 *         </p>
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganosAntecesores(String idOrg, int numNiveles)
			throws GestorOrganismosException, NotAvailableException;

	/**
	 * Recupera la lista de �rganos que tienen el valor de param como subtexto
	 * dentro de su nombre.
	 * 
	 * @param param
	 *            Texto en el nombre del �rgano.
	 * @return Lista de �rganos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoOrgano}.
	 *         </p>
	 * @throws GestorOrganismosException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarOrganos(String param)
			throws GestorOrganismosException, NotAvailableException;

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
			throws GestorOrganismosException, NotAvailableException;

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
			throws GestorOrganismosException, NotAvailableException;

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
			throws GestorOrganismosException, NotAvailableException;

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
			throws GestorOrganismosException, NotAvailableException;

}
