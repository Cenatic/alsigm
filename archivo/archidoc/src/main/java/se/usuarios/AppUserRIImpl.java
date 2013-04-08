package se.usuarios;

import ieci.core.db.DbEngine;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import se.usuarios.exceptions.AppUserException;
import util.MultiEntityUtil;
import xml.config.ConfiguracionSistemaArchivoFactory;

import common.ConfigConstants;
import common.authentication.ArchivoIdentifier;
import common.db.DataSourceEngine;
import common.exceptions.ArchivoModelException;
import common.util.StringUtils;

/**
 * Implementaci�n del interfaz remoto de acceso a la gesti�n de usuarios.
 */
public class AppUserRIImpl extends AppUserBaseRImpl {

	/** Logger de la clase. */
	private final static Logger logger = Logger.getLogger(AppUserRIImpl.class);

	/**
	 * Constructor.
	 */
	public AppUserRIImpl() {
	}

	/**
	 * Obtiene la informaci�n del usuario en la aplicaci�n.
	 * 
	 * @param subject
	 *            Informaci�n de la autenticaci�n del usuario.
	 * @return Informaci�n del usuario en la aplicaci�n.
	 * @throws AppUserException
	 *             si ocurre alg�n error en la validaci�n
	 */
	public AppUser getAppUser(Subject subject) throws AppUserException {
		String userAuthId = null;
		String userAuthType = null;
		String userName = null;
		String remoteIpAddress = null;
		String entity = null;
		String sessionAdm = null;

		// Obtener la informaci�n del usuario autenticado
		Object[] identifiers = subject.getPrincipals(ArchivoIdentifier.class)
				.toArray();
		for (int i = 0; i < identifiers.length; i++) {
			ArchivoIdentifier pi = (ArchivoIdentifier) identifiers[i];

			if (ArchivoIdentifier.EXTERNAL_USER_ID.equals(pi.getName()))
				userAuthId = pi.getValue();
			else if (ArchivoIdentifier.USER_TYPE.equals(pi.getName()))
				userAuthType = pi.getValue();
			else if (ArchivoIdentifier.USER_IP_ADDRESS.equals(pi.getName()))
				remoteIpAddress = pi.getValue();
			else if (ArchivoIdentifier.ENTITY.equals(pi.getName()))
				entity = pi.getValue();
			else if (ArchivoIdentifier.SESSION_ADM.equals(pi.getName()))
				sessionAdm = pi.getValue();
			else if (ArchivoIdentifier.USER_LOGIN.equals(pi.getName()))
				userName = pi.getValue();
		}

		return getAppUser(userAuthId, userAuthType, userName, remoteIpAddress,
				entity, sessionAdm);
	}

	/**
	 * Obtiene la informaci�n del usuario en la aplicaci�n.
	 * 
	 * @param userAuthId
	 *            Identificador del usuario en el Sistema Gestor de Usuarios.
	 * @param userAuthType
	 *            Tipo de usuario.
	 * @param userName
	 *            Nombre del usuario
	 * @param remoteIpAddress
	 *            Direcci�n IP del usuario.
	 * @return Informaci�n del usuario en la aplicaci�n.
	 * @throws AppUserException
	 *             si ocurre alg�n error en la validaci�n
	 */
	public AppUser getAppUser(String userAuthId, String userAuthType,
			String userName, String remoteIpAddress, String entity,
			String sessionAdm) throws AppUserException, ArchivoModelException {
		if (logger.isDebugEnabled())
			logger.debug("getAppUser: userAuthId=[" + userAuthId
					+ "], userAuthType=[" + userAuthType
					+ "], remoteIpAddress=[" + remoteIpAddress + "]");

		// Obtener el engine de base de datos
		DbEngine engine = null;
		String dataSourceName = ConfiguracionSistemaArchivoFactory
				.getConfiguracionSistemaArchivo().getConfiguracionGeneral()
				.getDataSourceName();

		String dbFactoryClass = ConfiguracionSistemaArchivoFactory
				.getConfiguracionSistemaArchivo().getConfiguracionGeneral()
				.getDBFactoryClass();

		if (StringUtils.isNotEmpty(entity)) {
			dataSourceName = MultiEntityUtil.composeDsName(dataSourceName,
					entity);
		}

		try {
			if (ConfigConstants.getInstance().getEntidadRequerida()) {
				// Buscar el datasource en el contexto
				if (dataSourceName != null) {
					Context context = new InitialContext();
					if (context != null) {
						DataSource dataSource = (DataSource) context
								.lookup(dataSourceName);
						engine = new DbEngine(dataSource, dbFactoryClass);
					}
				}
			} else {
				engine = DataSourceEngine.getDbEngine(dataSourceName,
						dbFactoryClass);
			}

		} catch (NamingException e) {
			throw new ArchivoModelException(DbEngine.class, "createWithEntity",
					e.getMessage());
		} catch (ArchivoModelException e) {
			throw e;
		}

		// Usuario
		AppUser user = new AppUser();
		user.setExternalUserId(userAuthId);
		user.setUserType(userAuthType);
		user.setIp(remoteIpAddress);

		user.setEngine(engine);
		user.setEntity(entity);

		// Si es un administrador copiar el nombre del usuario
		if (StringUtils.isNotEmpty(sessionAdm)) {
			user.setName(userName);
		}

		// Comprobar la existencia del usuario en el Sistema de Archivo
		checkUser(user, sessionAdm);

		// A�adir los permisos del usuario
		addUserPermissions(user);

		// A�adir los grupos del usuario
		addUserGroups(user);

		// Establecer el nivel de auditor�a
		setLogLevel(user);

		// A�adir la informaci�n de la organizaci�n
		setOrganizationInfo(user, entity);

		// A�adir las listas de control de acceso del usuario
		setAccessControlLists(user);

		return user;
	}
}