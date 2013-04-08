package common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.navigation.KeysClientsInvocations;

/**
 * Controlador para la gesti�n de la navegaci�n a trav�s de la selecci�n de
 * opciones de men�, mediante la miga de pan y a trav�s de los enlaces de acceso
 * r�pido de la bandeja de entrada
 */
public class MultilineaErrorAction extends BaseAction {
	public void showExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		saveCurrentInvocation(KeysClientsInvocations.ERROR_MULTILINEA, request);

		setReturnActionFordward(request,
				mapping.findForward("show_multilinea_error"));
	}

	public void backAndShowExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		popLastInvocation(request);
		saveCurrentInvocation(KeysClientsInvocations.ERROR_MULTILINEA, request);
		setReturnActionFordward(request,
				mapping.findForward("show_multilinea_error"));
	}
}