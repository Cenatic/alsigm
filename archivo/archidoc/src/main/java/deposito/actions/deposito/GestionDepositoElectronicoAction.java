package deposito.actions.deposito;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.actions.BaseAction;
import common.bi.ServiceRepository;
import common.navigation.ClientInvocation;
import common.navigation.KeysClientsInvocations;
import common.util.StringUtils;
import common.vos.ResultadoRegistrosVO;

import deposito.DepositoConstants;
import deposito.actions.ErrorKeys;
import deposito.exceptions.DepositoElectronicoAlreadyExistsException;
import deposito.exceptions.DepositoElectronicoEnUsoException;
import deposito.forms.DepositoElectronicoForm;
import deposito.vos.DepositoElectronicoVO;

public class GestionDepositoElectronicoAction extends BaseAction {

	/**
	 * Muestra la lista de dep�sitos electr�nicos.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void homeExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Guardar el enlace a la p�gina
		saveCurrentInvocation(KeysClientsInvocations.DEPOSITO_ELECTRONICO_HOME,
				request);

		// Obtener el repositorio de servicios
		ServiceRepository services = getServiceRepository(request);

		// Lista de dep�sitos
		List depositos = services.lookupGestorEstructuraDepositoBI()
				.getDepositosElectronicos();

		CollectionUtils.transform(depositos,
				DepositoElectronicoToPO.getInstance(services));
		request.setAttribute(DepositoConstants.LISTA_DEPOSITOS_KEY, depositos);

		setReturnActionFordward(request, mapping.findForward("ver_depositos"));
	}

	/**
	 * Muestra el formulario del dep�sito electr�nico.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void formExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DepositoElectronicoForm frm = (DepositoElectronicoForm) form;

		if (StringUtils.isNotBlank(frm.getId())) {
			// Guardar el enlace a la p�gina
			saveCurrentInvocation(
					KeysClientsInvocations.DEPOSITO_ELECTRONICO_EDITAR_DEPOSITO,
					request);

			// Informaci�n del dep�sito electr�nico
			DepositoElectronicoVO deposito = (DepositoElectronicoVO) getFromTemporalSession(
					request, DepositoConstants.DEPOSITO_KEY);

			// Guardar la informaci�n del tipo de documento vital
			frm.set(deposito);
		} else {
			// Guardar el enlace a la p�gina
			saveCurrentInvocation(
					KeysClientsInvocations.DEPOSITO_ELECTRONICO_CREAR_DEPOSITO,
					request);
		}

		setReturnActionFordward(request, mapping.findForward("editar_deposito"));
	}

	/**
	 * Muestra la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void retrieveExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Guardar el enlace a la p�gina
		ClientInvocation invocation = saveCurrentInvocation(
				KeysClientsInvocations.DEPOSITO_ELECTRONICO_VER_DEPOSITO,
				request);
		invocation.setAsReturnPoint(true);

		// Formulario
		DepositoElectronicoForm frm = (DepositoElectronicoForm) form;

		// Obtener el repositorio de servicios
		ServiceRepository services = getServiceRepository(request);

		// Informaci�n del dep�sito electr�nico
		removeInTemporalSession(request, DepositoConstants.DEPOSITO_KEY);
		DepositoElectronicoVO deposito = services
				.lookupGestorEstructuraDepositoBI().getDepositoElectronico(
						frm.getId());
		deposito = (DepositoElectronicoPO) DepositoElectronicoToPO.getInstance(
				services).transform(deposito);
		setInTemporalSession(request, DepositoConstants.DEPOSITO_KEY, deposito);

		setReturnActionFordward(request, mapping.findForward("ver_deposito"));
	}

	/**
	 * Guarda el dep�sito electr�nico.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void saveExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Validar el formulario
		ActionErrors errores = form.validate(mapping, request);
		if (errores.isEmpty()) {
			// Recoger la informaci�n del tipo de documento vital
			DepositoElectronicoForm frm = (DepositoElectronicoForm) form;
			DepositoElectronicoVO deposito = new DepositoElectronicoVO();
			frm.populate(deposito);

			try {
				if (StringUtils.isBlank(deposito.getId())) {
					// Crear el tipo de documento vital
					deposito = getGestorEstructuraDepositoBI(request)
							.insertDepositoElectronico(deposito);

					// Eliminar el enlace de creaci�n
					popLastInvocation(request);
				} else {
					// Modificar el tipo de documento vital
					getGestorEstructuraDepositoBI(request)
							.updateDepositoElectronico(deposito);
				}

				setReturnActionFordward(
						request,
						redirectForwardMethod(request, "method", "retrieve&id="
								+ deposito.getId()));
			} catch (DepositoElectronicoAlreadyExistsException e) {
				// A�adir los errores al request
				obtenerErrores(request, true)
						.add(ActionErrors.GLOBAL_MESSAGE,
								new ActionError(
										ErrorKeys.DEPOSITO_ELECTRONICO_CREATE_ERROR_EXIST,
										new Object[] { deposito.getIdExt() }));
				// goLastClientExecuteLogic(mapping, form, request, response);
				setReturnActionFordward(request,
						mapping.findForward("editar_deposito"));
			}
		} else {
			// A�adir los errores al request
			obtenerErrores(request, true).add(errores);
			// goLastClientExecuteLogic(mapping, form, request, response);
			setReturnActionFordward(request,
					mapping.findForward("editar_deposito"));
		}
	}

	/**
	 * Elimina los dep�sitos electr�nicos seleccionados.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void removeExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DepositoElectronicoForm frm = (DepositoElectronicoForm) form;

		// Eliminar los dep�sitos electr�nicos seleccionados
		ResultadoRegistrosVO res = getGestorEstructuraDepositoBI(request)
				.deleteDepositosElectronicos(frm.getDepositosSeleccionados());

		// Comprobar que no haya errores
		if (!res.getErrores().isEmpty())
			obtenerErrores(request, true).add(res.getErrores());

		goLastClientExecuteLogic(mapping, form, request, response);
	}

	/**
	 * Elimina el dep�sito electr�nico actual.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param form
	 *            {@link ActionForm} asociado al action.
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param response
	 *            {@link HttpServletResponse}
	 */
	protected void removeDepositoExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		DepositoElectronicoForm frm = (DepositoElectronicoForm) form;

		// Informaci�n del dep�sito electr�nico
		DepositoElectronicoVO deposito = (DepositoElectronicoVO) getFromTemporalSession(
				request, DepositoConstants.DEPOSITO_KEY);

		try {
			// Eliminar el dep�sito electr�nico actual
			getGestorEstructuraDepositoBI(request).deleteDepositoElectronico(
					frm.getId());

			goBackExecuteLogic(mapping, form, request, response);
		} catch (DepositoElectronicoEnUsoException e) {
			obtenerErrores(request, true).add(
					ActionErrors.GLOBAL_MESSAGE,
					new ActionError(
							ErrorKeys.DEPOSITO_ELECTRONICO_DELETE_ERROR_ENUSO,
							new Object[] { deposito.getNombre() }));
			goLastClientExecuteLogic(mapping, form, request, response);
		}
	}

}
