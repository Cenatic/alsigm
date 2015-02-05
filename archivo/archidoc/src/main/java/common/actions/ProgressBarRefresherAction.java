package common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.Constants;

/**
 * Controlador para la gesti�n de la navegaci�n a trav�s de la selecci�n de
 * opciones de men�, mediante la miga de pan y a trav�s de los enlaces de acceso
 * r�pido de la bandeja de entrada
 */
public class ProgressBarRefresherAction extends BaseAction {

	public void updateProgressBarExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		setReturnActionFordward(request, mapping.findForward("progressBar"));
	}

	public void cancelGenReportExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		setInTemporalSession(request, Constants.CANCEL_PROGRESSBAR_KEY,
				Boolean.TRUE);
		setReturnActionFordward(request, mapping.findForward("progressBar"));
	}

	public void resetProgressBarExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		setInTemporalSession(request, Constants.PROGRESSBAR_PERCENT_KEY,
				new Integer(0));
		//setInTemporalSession(request, Constants.CANCEL_PROGRESSBAR_KEY,
		//		Boolean.TRUE);
		setReturnActionFordward(request, mapping.findForward("progressBar"));
	}
}