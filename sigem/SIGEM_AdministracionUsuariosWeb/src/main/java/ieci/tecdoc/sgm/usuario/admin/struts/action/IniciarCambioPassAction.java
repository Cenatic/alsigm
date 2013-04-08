package ieci.tecdoc.sgm.usuario.admin.struts.action;

import ieci.tecdoc.sgm.core.services.autenticacion.DatosUsuario;
import ieci.tecdoc.sgm.usuario.admin.struts.Constants;
import ieci.tecdoc.sgm.usuario.admin.struts.UserAdminHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * Acci�n encargada de la b�squeda de tipos de liquidaciones. 
 *
 */
public class IniciarCambioPassAction extends AdminUsuariosWebAction {

	private static final Logger logger = Logger.getLogger(IniciarCambioPassAction.class);
	
	private static final String SUCCESS_FORWARD =		"success";
	private static final String USER_KEY =				"usuario";	
	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaValidatorForm oForm = (DynaValidatorForm) form;
		DatosUsuario oUser = new DatosUsuario();
		oUser.setUser((String)oForm.get(Constants.USUARIO_USUARIO_FIELD));
		request.setAttribute(USER_KEY, oUser);
		
		return mapping.findForward(SUCCESS_FORWARD);
	}
}