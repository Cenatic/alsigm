package descripcion.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import xml.config.Busqueda;
import xml.config.ConfiguracionArchivoManager;

import common.Constants;
import common.actions.BaseAction;
import common.exceptions.TooManyResultsException;
import common.pagination.PageInfo;

import descripcion.DescripcionConstants;
import fondos.FondosConstants;
import fondos.forms.BusquedaElementosForm;
import fondos.utils.BusquedasHelper;
import fondos.vos.BusquedaElementosVO;

/**
 * Acci�n para la selecci�n de elementos del cuadro de clasificaci�n.
 */
public class ElementosAction extends BaseAction {

	private Busqueda getCfgBusquedaBandejaElementos(HttpServletRequest request) {
		String key = getKeyCfgBusquedas(request,
				ConfiguracionArchivoManager.ELEMENTOS);
		Busqueda busqueda = getCfgBusqueda(request, key);
		return busqueda;
	}

	/**
	 * Muestra el formulario para realizar b�squedas.
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
	protected void formBusquedaElemExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Obtener la configuraci�n de la b�squeda
		Busqueda busqueda = getCfgBusquedaBandejaElementos(request);
		setInTemporalSession(request, FondosConstants.CFG_BUSQUEDA_KEY,
				busqueda);

		// Recuperar la informaci�n del formulario
		BusquedaElementosForm busquedaElementosForm = (BusquedaElementosForm) form;

		// Cargar las listas necesarias
		BusquedasHelper.loadListasBusqueda(busqueda, busquedaElementosForm,
				request, null);

		setReturnActionFordward(request,
				mapping.findForward("busqueda_elementos_adv"));
	}

	/**
	 * Muestra la lista de elementos del cuadro de clasificaci�n.
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
	protected void busqElemsExecuteLogic(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Recuperar la informaci�n del formulario
		BusquedaElementosForm busquedaElementosForm = (BusquedaElementosForm) form;
		busquedaElementosForm.setPostBack(Constants.TRUE_STRING);

		// Recuperar la informaci�n de la b�squeda
		Busqueda busqueda = (Busqueda) getFromTemporalSession(request,
				FondosConstants.CFG_BUSQUEDA_KEY);

		// Validar el formulario
		ActionErrors errores = BusquedasHelper.validateCampos(mapping, request,
				busqueda, busquedaElementosForm);
		if ((errores == null) || errores.isEmpty()) {
			// Informaci�n de paginaci�n
			PageInfo pageInfo = new PageInfo(request, 10, "codReferencia");
			pageInfo.setDefautMaxNumItems();

			BusquedaElementosVO busquedaElementosVO = BusquedasHelper
					.getBusquedaElementosVO(busqueda, null,
							busquedaElementosForm);
			busquedaElementosVO.setPageInfo(pageInfo);

			try {
				// B�squeda de elementos del cuadro de clasificaci�n
				request.setAttribute(
						DescripcionConstants.ELEMENTOS_KEY,
						getGestionDescripcionBI(request)
								.searchElementosCuadroClasificacion(
										busquedaElementosVO));

				setReturnActionFordward(request,
						mapping.findForward("ver_elementos_adv"));
				return;
			} catch (TooManyResultsException e) {
				// A�adir los errores al request
				obtenerErrores(request, true).add(
						ActionErrors.GLOBAL_MESSAGE,
						new ActionError(Constants.ERROR_TOO_MANY_RESULTS,
								new Object[] { new Integer(e.getCount()),
										new Integer(e.getMaxNumResults()) }));
			}
		} else {
			// A�adir los errores al request
			obtenerErrores(request, true).add(errores);
		}

		BusquedasHelper.loadListasBusqueda(busqueda, busquedaElementosForm,
				request, null);
		setReturnActionFordward(request,
				mapping.findForward("busqueda_elementos_adv"));
	}

	/**
	 * Muestra el formulario para realizar b�squedas.
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
		logger.info("Inicio de formExecuteLogic");

		// Obtener la configuraci�n de la b�squeda
		Busqueda busqueda = getCfgBusquedaBandejaElementos(request);
		setInTemporalSession(request, FondosConstants.CFG_BUSQUEDA_KEY,
				busqueda);

		// Recuperar la informaci�n del formulario
		BusquedaElementosForm busquedaElementosForm = (BusquedaElementosForm) form;

		showFormulario(mapping, busquedaElementosForm, busqueda, request);
	}

	/**
	 * Muestra la lista de elementos del cuadro de clasificaci�n.
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
	protected void busqExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("Inicio de busqExecuteLogic");

		BusquedaElementosForm formulario = (BusquedaElementosForm) form;
		formulario.setPostBack(Constants.TRUE_STRING);

		// Recuperar la informaci�n del formulario
		BusquedaElementosForm busquedaElementosForm = (BusquedaElementosForm) form;

		// Recuperar la informaci�n de la b�squeda
		Busqueda busqueda = (Busqueda) getFromTemporalSession(request,
				FondosConstants.CFG_BUSQUEDA_KEY);

		// Validar el formulario
		ActionErrors errores = BusquedasHelper.validateCampos(mapping, request,
				busqueda, busquedaElementosForm);
		if ((errores == null) || errores.isEmpty()) {
			logger.info("Formulario validado");

			// Informaci�n de paginaci�n
			PageInfo pageInfo = new PageInfo(request, 10, "codReferencia");
			pageInfo.setDefautMaxNumItems();

			BusquedaElementosVO busquedaElementosVO = BusquedasHelper
					.getBusquedaElementosVO(busqueda, null,
							busquedaElementosForm);
			busquedaElementosVO.setPageInfo(pageInfo);

			try {
				// B�squeda de elementos del cuadro de clasificaci�n
				request.setAttribute(
						DescripcionConstants.ELEMENTOS_KEY,
						getGestionDescripcionBI(request)
								.searchElementosCuadroClasificacion(
										busquedaElementosVO));

				setReturnActionFordward(request,
						mapping.findForward("ver_elementos"));
			} catch (TooManyResultsException e) {
				// A�adir los errores al request
				obtenerErrores(request, true).add(
						ActionErrors.GLOBAL_MESSAGE,
						new ActionError(Constants.ERROR_TOO_MANY_RESULTS,
								new Object[] { new Integer(e.getCount()),
										new Integer(e.getMaxNumResults()) }));

				showFormulario(mapping, busquedaElementosForm, busqueda,
						request);
			}
		} else {
			logger.info("Formulario inv\u00E1lido");

			// A�adir los errores al request
			obtenerErrores(request, true).add(errores);

			showFormulario(mapping, busquedaElementosForm, busqueda, request);
		}
	}

	/**
	 * Muestra la pantalla del formulario.
	 * 
	 * @param mapping
	 *            {@link ActionMapping} con los mapeos asociado.
	 * @param request
	 *            {@link HttpServletRequest}
	 */
	private void showFormulario(ActionMapping mapping,
			BusquedaElementosForm form, Busqueda busqueda,
			HttpServletRequest request) {
		// Cargar las listas de objetos
		BusquedasHelper.loadListasBusqueda(busqueda, form, request, null);
		// Retornar a la b�squeda
		setReturnActionFordward(request,
				mapping.findForward("busqueda_elementos"));
	}

	/**
	 * M�todo para las b�squedas de procedimientos desde el formulario de
	 * b�squeda de elementos
	 * 
	 * @param mappings
	 * @param form
	 * @param request
	 * @param response
	 */
	public void buscarProcedimientoExecuteLogic(ActionMapping mappings,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		BusquedasHelper.buscarProcedimientoComunLogic(mappings,
				(BusquedaElementosForm) form, request, response);
		setReturnActionFordward(request,
				mappings.findForward("busqueda_elementos_adv"));
	}
}