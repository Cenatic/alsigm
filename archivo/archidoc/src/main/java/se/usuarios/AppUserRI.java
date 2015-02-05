package se.usuarios;

import javax.security.auth.Subject;

import se.usuarios.exceptions.AppUserException;

import common.exceptions.ArchivoModelException;

/**
 * Interfaz con el comportamiento de todos los interfaces remotos para la
 * gesti�n de usuarios de la aplicaci�n.
 */
public interface AppUserRI {

	/**
	 * Obtiene la informaci�n del usuario en la aplicaci�n.
	 * 
	 * @param subject
	 *            Informaci�n de la autenticaci�n del usuario.
	 * @return Informaci�n del usuario en la aplicaci�n.
	 * @throws AppUserException
	 *             si ocurre alg�n error en la validaci�n
	 */
	public AppUser getAppUser(Subject subject) throws AppUserException;

	/**
	 * Obtiene la informaci�n del usuario en la aplicaci�n.
	 * 
	 * @param userAuthId
	 *            Identificador del usuario en el Sistema Gestor de Usuarios.
	 * @param userAuthType
	 *            Tipo de usuario.
	 * @param userName
	 *            Nombre del usuario.
	 * @param remoteIpAddress
	 *            Direcci�n IP del usuario.
	 * @param entity
	 *            Entidad para multientidad
	 * @param sessionAdm
	 *            Sesi�n de administracion
	 * @return Informaci�n del usuario en la aplicaci�n.
	 * @throws AppUserException
	 *             si ocurre alg�n error en la validaci�n
	 */
	public AppUser getAppUser(String userAuthId, String userAuthType,
			String userName, String remoteIpAddress, String entity,
			String sessionAdm) throws AppUserException, ArchivoModelException;

}
