package se.repositorios;

import java.rmi.RemoteException;

import se.NotAvailableException;
import se.Parametrizable;
import se.repositorios.archigest.InfoFicheroVO;
import se.repositorios.archigest.InfoOcupacionVO;
import se.repositorios.exceptions.GestorRepositorioException;

/**
 * Interfaz para los conectores con el Sistemas Gestor del Repositorio.
 */
public interface IGestorRepositorio extends Parametrizable {

	/**
	 * Obtiene la informaci�n del fichero.
	 * 
	 * @param id
	 *            Identificador del fichero.
	 * @return Informaci�n del fichero.
	 * @throws RemoteException
	 *             si ocurre alg�n error.
	 */
	public InfoFicheroVO getInfoFichero(String id)
			throws GestorRepositorioException, NotAvailableException;

	/**
	 * Obtiene el contenido de un fichero.
	 * 
	 * @param localizador
	 *            Localizador del fichero.
	 * @return Contenido del fichero.
	 * @throws RemoteException
	 *             si ocurre alg�n error.
	 */
	public byte[] getFichero(String localizador)
			throws GestorRepositorioException, NotAvailableException;

	/**
	 * Elimina los ficheros del repositorio.
	 * 
	 * @param localizadores
	 *            Localizadores de los ficheros.
	 * @throws RemoteException
	 *             si ocurre alg�n error.
	 */
	public void eliminaFicheros(String[] localizadores)
			throws GestorRepositorioException, NotAvailableException;

	/**
	 * Obtiene la informaci�n de ocupaci�n del repositorio.
	 * 
	 * @return Informaci�n de ocupaci�n.
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public InfoOcupacionVO getInfoOcupacion()
			throws GestorRepositorioException, NotAvailableException;

	/**
	 * Establece la url a la que llamar
	 * 
	 * @param wsdlLocation
	 *            URL a la que llamar
	 */
	public void setWsdlLocation(String wsdlLocation);

	/**
	 * Establece el usuario de llamada a servicios web
	 * 
	 * @param user
	 *            usuario de llamada a servicios web
	 */
	public void setUser(String user);

	/**
	 * Establece la contrase�a del usuario de llamada a servicios web
	 * 
	 * @param user
	 *            contrase�a del usuario de llamada a servicios web
	 */
	public void setPassword(String password);
}
