package ieci.tdw.ispac.ispaccatalog.action;

import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.impl.SessionAPIFactory;
import ieci.tdw.ispac.audit.business.vo.AuditContext;
import ieci.tdw.ispac.audit.context.AuditContextHolder;
import ieci.tdw.ispac.ispaclib.directory.DirectoryConnectorFactory;
import ieci.tdw.ispac.ispaclib.directory.IDirectoryConnector;
import ieci.tdw.ispac.ispaclib.directory.IDirectoryEntry;
import ieci.tdw.ispac.ispaclib.session.OrganizationUserInfo;
import ieci.tdw.ispac.ispaclib.util.ISPACConfiguration;
import ieci.tdw.ispac.ispaclib.utils.LocaleHelper;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispacweb.security.UserCredentials;
import ieci.tdw.ispac.ispacweb.security.UserCredentialsHelper;
import ieci.tecdoc.sgm.core.admin.web.AutenticacionAdministracion;
import ieci.tecdoc.sgm.core.services.gestion_administracion.ConstantesGestionUsuariosAdministracion;
import ieci.tecdoc.sgm.core.web.locale.LocaleFilterHelper;
import ieci.tecdoc.sgm.sesiones.administrador.ws.client.Sesion;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class EntryAction extends Action {

	private static final Logger LOGGER = Logger.getLogger(EntryAction.class);

	private static String APLICACION;
	static {
		try {
			APLICACION = ISPACConfiguration.getInstance().get(ISPACConfiguration.CTLG_APPLICATION);
		}
		catch (ISPACException e) {
			e.printStackTrace();
		}
	}

	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Entrada en EntryAction");
		}

		// Auntenticar el usuario
		if (AutenticacionAdministracion.autenticarEntidad(request,
				ConstantesGestionUsuariosAdministracion.APLICACION_CATALOGO_PROCEDIMIENTOS)) {

			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("El usuario est� autenticado");
			}

			// Informaci�n de la sesi�n del usuario
			Sesion sesion = AutenticacionAdministracion.obtenerDatosEntidad(request);

			String entityId = sesion.getIdEntidad();
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Entidad: " + entityId);
			}

			HttpSession session = request.getSession();

			//Almacenamos la entidad en sesi�n, �til si queremos realizar personalizaciones de imagenes, css, etc en funci�n
			//de la entidad contra la que se est� trabajando
			session.setAttribute(ConstantesGestionUsuariosAdministracion.PARAMETRO_ID_ENTIDAD, entityId);

			// Obtener el locale seleccionado por el filtro
			Locale locale = LocaleFilterHelper.getCurrentLocale(request);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Locale: " + locale);
			}

			// Almacenamos el idioma seleccionado en sesi�n
			LocaleHelper.setLocale(request, locale);

			String entityName = null;
			String userName = sesion.getUsuario();

			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Usuario conectado: " + userName);
			}

			String remoteHost = request.getRemoteHost();
			if (StringUtils.isBlank(remoteHost)) {
				remoteHost = request.getRemoteAddr();
			}

			try {

				OrganizationUserInfo info = new OrganizationUserInfo();
				info.setOrganizationId(entityId);
				info.setOrganizationName(entityName);
				info.setUserName(userName);

				// Autentificaci�n del usuario
				SessionAPI sessionAPI = SessionAPIFactory.getSessionAPI(request, info);

				IDirectoryConnector directory = DirectoryConnectorFactory.getConnector();
				IDirectoryEntry userEntry = null;

				// Obtener la informaci�n del usuario para tramitaci�n
				if (sesion.getTipoUsuario() == Sesion.TIPO_USUARIO_INTERNO) {
					userEntry = directory.getEntryFromUserName(userName);
				} else { //Sesion.TIPO_USUARIO_ADMINISTRADOR
					userEntry = directory.getEntryFromUserName(
							ISPACConfiguration.getInstance().get(ISPACConfiguration.SUPERUSER));
				}
				info.setUserId(userEntry.getUID());

				// Auditor�a
				AuditContext auditContext = new AuditContext();
				auditContext.setUserHost(request.getRemoteHost());
				auditContext.setUserIP(request.getRemoteAddr());
				auditContext.setUser(userName);
				auditContext.setUserId(userEntry.getUID());
				// A�adir en el ThreadLocal el objeto AuditContext
				AuditContextHolder.setAuditContext(auditContext);

				sessionAPI.login(remoteHost, userName, userEntry, APLICACION, locale);

				// Obtener las funciones del usuario
				UserCredentials userCredentials = UserCredentialsHelper.saveUserCredentials(request, sessionAPI.getClientContext());

				// Autorizaci�n
				if ((sesion.getTipoUsuario() == Sesion.TIPO_USUARIO_INTERNO)
						&& !isAuthorizedUser(userCredentials)) {
					composeReturnError("error.login.authorization", request);
					return mapping.findForward("fail");
				}

				// Generar el ticket que se guarda en una cookie
				String ticket = sessionAPI.getTicket();
				Cookie cookieUser = new Cookie("user", ticket);
				response.addCookie(cookieUser);

				// Almacenar las funciones del usuario
				if (userCredentials.isCatalogAdministrator()
						|| userCredentials.containsAnyFunction(new int[] {
								ISecurityAPI.FUNC_INV_PROCEDURES_READ,
								ISecurityAPI.FUNC_INV_PROCEDURES_EDIT })) {
					return mapping.findForward("proceduresTree");
				} else {
					return mapping.findForward("success");
				}

			} catch (ISPACException e) {
				LOGGER.error("Error en la entrada a la aplicaci�n", e);
				composeReturnError("error.login.incorrecto", request);
				return mapping.findForward("fail");
			} catch (Throwable e) {
				LOGGER.error("Error en la entrada a la aplicaci�n", e);
				composeReturnError("error.login.incorrecto", request);
				return mapping.findForward("fail");
			}
		}

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("El usuario no est� autenticado");
		}

		composeReturnError("error.login.data.invalid", request);

		return mapping.findForward("fail");
	}

	private void composeReturnError(String resourceKey,HttpServletRequest request){
		String url = AutenticacionAdministracion.obtenerUrlLogout(request);
		request.setAttribute("urlLogout", url);
		ActionMessages messages = new ActionMessages();
		messages.add("user",new ActionMessage(resourceKey));
		saveErrors(request,messages);
	}

	private boolean isAuthorizedUser(UserCredentials userCredentials) throws ISPACException {

		boolean authorized = false;

		if (userCredentials.isCatalogAdministrator()
				|| userCredentials
						.containsAnyFunction(ISecurityAPI.CATALOG_ACCESS_FUNCTIONS)) {
			authorized = true;
		}

		return authorized;
	}



}