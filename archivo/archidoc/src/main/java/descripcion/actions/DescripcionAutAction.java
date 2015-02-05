package descripcion.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.Constants;
import common.actions.BaseAction;
import common.exceptions.ColumnNotIndexedException;
import common.exceptions.SintaxErrorException;
import common.exceptions.TooManyResultsException;
import common.exceptions.WordOmittedException;
import common.navigation.ClientInvocation;
import common.navigation.KeysClientsInvocations;
import common.pagination.PageInfo;

import descripcion.DescripcionConstants;
import descripcion.forms.BusquedaGeneralAutForm;
import descripcion.model.IdentificadoresFichas;
import descripcion.model.TipoDescriptor;
import descripcion.vos.BusquedaGeneralAutVO;

/**
 * Acci�n para la gesti�n de las b�squedas sobre la descripci�n de las
 * autoridades.
 */
public class DescripcionAutAction extends BaseAction {

	/**
	 * Muestra el formulario para realizar b�squedas de autoridades.
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
	protected void formBusqExecuteLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Guardar el enlace a la p�gina
		ClientInvocation invocation = saveCurrentInvocation(
				KeysClientsInvocations.DESCRIPCION_FORM_BUSQ_AUT, request);
		invocation.setAsReturnPoint(true);

		// Listas descriptoras de las autoridades
		request.setAttribute(
				DescripcionConstants.LISTAS_DESCRIPTORAS_KEY,
				getGestionDescripcionBI(request)
						.getListasDescrByTipoDescrOFicha(
								TipoDescriptor.ENTIDAD,
								IdentificadoresFichas.ID_FICHA_ISAAR));

		setReturnActionFordward(request,
				mapping.findForward("formulario_busqueda_aut"));
	}

	/**
	 * Realiza la b�squeda general de autoridades.
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
		Boolean usarCache = (Boolean) getFromTemporalSession(request,
				"usarCache");
		if (usarCache != null && usarCache.booleanValue()) {
			removeInTemporalSession(request, "usarCache");

			// Guardar el enlace a la p�gina
			saveCurrentInvocation(KeysClientsInvocations.DESCRIPCION_BUSQ_AUT,
					request);
			setReturnActionFordward(request,
					mapping.findForward("listado_busqueda_aut"));
		} else {
			// A�adir los par�metros del formulario al enlace
			ClientInvocation cli = getInvocationStack(request)
					.getLastClientInvocation();
			cli.addParameters(((BusquedaGeneralAutForm) form).getMap());

			// Validar el formulario
			ActionErrors errores = form.validate(mapping, request);
			if ((errores == null) || errores.isEmpty()) {
				// Guardar el enlace a la p�gina
				ClientInvocation invocation = saveCurrentInvocation(
						KeysClientsInvocations.DESCRIPCION_BUSQ_AUT, request);
				invocation.setAsReturnPoint(true);

				// Informaci�n de paginaci�n
				PageInfo pageInfo = new PageInfo(request, "nombre");
				pageInfo.setDefautMaxNumItems();

				// Recuperar la informaci�n del formulario
				BusquedaGeneralAutVO busquedaGeneralAutVO = new BusquedaGeneralAutVO();
				((BusquedaGeneralAutForm) form).populate(busquedaGeneralAutVO);
				busquedaGeneralAutVO.setPageInfo(pageInfo);

				try {
					// B�squeda de autoridades
					request.setAttribute(
							DescripcionConstants.AUTORIDADES_KEY,
							getGestionDescripcionBI(request).searchAutoridades(
									busquedaGeneralAutVO));

					setReturnActionFordward(request,
							mapping.findForward("listado_busqueda_aut"));
				} catch (TooManyResultsException e) {
					// A�adir los errores al request
					obtenerErrores(request, true)
							.add(ActionErrors.GLOBAL_MESSAGE,
									new ActionError(
											Constants.ERROR_TOO_MANY_RESULTS,
											new Object[] {
													new Integer(e.getCount()),
													new Integer(e
															.getMaxNumResults()) }));

					goBackExecuteLogic(mapping, form, request, response);
				} catch (ColumnNotIndexedException e) {
					// A�adir los errores al request
					obtenerErrores(request, true)
							.add(ActionErrors.GLOBAL_MESSAGE,
									new ActionError(
											Constants.ERROR_COLUMNA_NO_INDEXADA));

					goBackExecuteLogic(mapping, form, request, response);
				} catch (WordOmittedException e) {
					// A�adir los errores al request
					obtenerErrores(request, true).add(
							ActionErrors.GLOBAL_MESSAGE,
							new ActionError(Constants.ERROR_PALABRA_OMITIDA));

					goBackExecuteLogic(mapping, form, request, response);
				} catch (SintaxErrorException e) {
					// A�adir los errores al request
					obtenerErrores(request, true)
							.add(ActionErrors.GLOBAL_MESSAGE,
									new ActionError(
											Constants.ERROR_SINTAXIS_INCORRECTA));

					goBackExecuteLogic(mapping, form, request, response);
				}
			} else {
				// A�adir los errores al request
				obtenerErrores(request, true).add(errores);

				goLastClientExecuteLogic(mapping, form, request, response);
			}
		}
	}

}
