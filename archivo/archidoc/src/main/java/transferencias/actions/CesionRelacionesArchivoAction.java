package transferencias.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import se.usuarios.AppPermissions;
import transferencias.TransferenciasConstants;
import transferencias.forms.CesionPrevisionesForm;
import transferencias.forms.CesionRelacionesForm;
import transferencias.model.EstadoREntrega;
import transferencias.vos.BusquedaRelacionesVO;
import transferencias.vos.RelacionEntregaVO;
import util.CollectionUtils;

import common.Constants;
import common.actions.BaseAction;
import common.bi.GestionControlUsuariosBI;
import common.bi.GestionRelacionesEntregaBI;
import common.exceptions.ActionNotAllowedException;
import common.exceptions.TooManyResultsException;
import common.navigation.ClientInvocation;
import common.navigation.KeysClientsInvocations;

/**
 * Clase que encapsula todas las acciones relacionadas con la cesi�n de
 * relaciones de entrega en archivo por parte de un usuario de la aplicaci�n a
 * otro usuario. Se establece un wizard donde se selecciona una relaci�n bien de
 * las existentes para el usuario o de un usuario seleccionado, para
 * posteriormente seleccionar el usuario destino de dicha relaci�n.
 */
public class CesionRelacionesArchivoAction extends BaseAction {

	/**
	 * Prepara la p�gina para seleccionar la relaci�n de entrega en archivo de
	 * la que se va ceder el control.
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
	public void verBuscadorExecuteLogic(ActionMapping mappings,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Establecemos el punto actual de navegacion
		/* ClientInvocation invocation = */saveCurrentInvocation(
				KeysClientsInvocations.TRANSFERENCIAS_SELECT_RELACION_CEDER,
				request);

		// Establecer el tipo de b�squeda
		CesionRelacionesForm cesionForm = (CesionRelacionesForm) form;
		cesionForm
				.setTipoBusqueda(CesionPrevisionesForm.TIPO_BUSQUEDA_POR_PREVISION);

		// Establecer el tipo de relaciones
		setInTemporalSession(request,
				TransferenciasConstants.TIPO_RELACION_KEY,
				TransferenciasConstants.RELACION_EN_ARCHIVO);

		setReturnActionFordward(request,
				mappings.findForward("seleccion_relaciones"));
	}

	/**
	 * Prepara la p�gina para seleccionar la relaci�n de entrega de la que se va
	 * ceder el control a partir de un gestor.
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
	public void verBuscadorGestorExecuteLogic(ActionMapping mappings,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Establecemos el punto actual de navegacion
		saveCurrentInvocation(
				KeysClientsInvocations.TRANSFERENCIAS_SELECT_RELACION_CEDER,
				request);

		// Establecer el tipo de b�squeda
		CesionRelacionesForm cesionForm = (CesionRelacionesForm) form;
		cesionForm
				.setTipoBusqueda(CesionRelacionesForm.TIPO_BUSQUEDA_POR_GESTOR);

		// Obtener los gestores
		setInTemporalSession(request,
				TransferenciasConstants.LISTA_GESTORES_KEY,
				getGestionRelacionesBI(request)
						.getGestoresArchivoConRelaciones());

		setReturnActionFordward(request,
				mappings.findForward("seleccion_relaciones"));
	}

	/**
	 * Realiza la b�squeda de relaciones de entrega para su selecci�n.
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
	public void buscarExecuteLogic(ActionMapping mappings, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CesionRelacionesForm cesionForm = (CesionRelacionesForm) form;

		// Establecemos el punto actual de navegacion
		ClientInvocation invocation = saveCurrentInvocation(
				KeysClientsInvocations.TRANSFERENCIAS_SELECT_RELACION_CEDER,
				request);
		invocation.addParameters(cesionForm.getMap());

		// Validar el formulario
		ActionErrors errores = form.validate(mappings, request);
		if (errores.isEmpty()) {
			BusquedaRelacionesVO busquedaVO = new BusquedaRelacionesVO();

			// Estados
			busquedaVO.setEstados(new String[] {
					"" + EstadoREntrega.RECIBIDA.getIdentificador(),
					"" + EstadoREntrega.SIGNATURIZADA.getIdentificador(),
					// ""+EstadoREntrega.VALIDADA.getIdentificador(),
					"" + EstadoREntrega.CON_ERRORES_COTEJO.getIdentificador(),
					"" + EstadoREntrega.CORREGIDA_ERRORES.getIdentificador() });

			if (cesionForm.getTipoBusqueda() == CesionRelacionesForm.TIPO_BUSQUEDA_POR_RELACION) {
				busquedaVO.setOrgano(cesionForm.getOrgano());
				busquedaVO.setCodigo(cesionForm.getCodigo());
			} else {
				busquedaVO.setIdGestorArchivo(cesionForm.getGestor());
			}

			try {
				removeInTemporalSession(request,
						TransferenciasConstants.LISTA_RELACIONES_KEY);
				List relaciones = getGestionRelacionesBI(request)
						.getRelacionesCedibles(busquedaVO);
				CollectionUtils
						.transform(relaciones, RelacionToPO
								.getInstance(getServiceRepository(request)));

				// Obtiene las relaciones de entrega
				setInTemporalSession(request,
						TransferenciasConstants.LISTA_RELACIONES_KEY,
						relaciones);

				cesionForm.setResultado(true);
			} catch (TooManyResultsException e) {
				// A�adir los errores al request
				obtenerErrores(request, true).add(
						ActionErrors.GLOBAL_MESSAGE,
						new ActionError(Constants.ERROR_TOO_MANY_RESULTS,
								new Object[] { new Integer(e.getCount()),
										new Integer(e.getMaxNumResults()) }));
			}
		} else
			obtenerErrores(request, true).add(errores);

		setReturnActionFordward(request,
				mappings.findForward("seleccion_relaciones"));
	}

	/**
	 * Obtiene la relaci�n de entrega que vamos a ceder as� como los posibles
	 * gestores para dicha relaci�n.
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
	public void seleccionarExecuteLogic(ActionMapping mappings,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Establecemos el punto actual de navegacion
		saveCurrentInvocation(
				KeysClientsInvocations.TRANSFERENCIAS_SELECT_USUARIO_CEDER,
				request);

		// Valores del formulario
		CesionRelacionesForm cesionForm = (CesionRelacionesForm) form;

		// Validar el formulario
		ActionErrors errores = cesionForm.validateSeleccion(mappings, request);
		if (errores.isEmpty()) {
			// Informaci�n de las relaciones de entrega seleccionadas
			Collection relaciones = getGestionRelacionesBI(request)
					.getRelacionesXIds(cesionForm.getRelacionesSeleccionadas());
			CollectionUtils.transform(relaciones,
					RelacionToPO.getInstance(getServiceRepository(request)));
			setInTemporalSession(request,
					TransferenciasConstants.LISTA_RELACIONES_KEY, relaciones);

			// Informaci�n de la primera relaci�n de entrega seleccionada
			RelacionEntregaVO relacion = (RelacionEntregaVO) relaciones
					.iterator().next();

			// Obtenemos los posibles usuarios de la previsi�n
			GestionControlUsuariosBI controlUsuariosBI = getGestionControlUsuarios(request);
			List gestores = controlUsuariosBI.getGestoresTransferencia(relacion
					.getIdarchivoreceptor());

			String[] permisosSuperUser = { AppPermissions.ADMINISTRACION_TOTAL_SISTEMA };
			if (gestores == null)
				gestores = new ArrayList();
			CollectionUtils
					.addList(gestores, controlUsuariosBI
							.getUsuariosConPermisos(permisosSuperUser));

			setInTemporalSession(request,
					TransferenciasConstants.LISTA_GESTORES_KEY, gestores);

			setReturnActionFordward(request,
					mappings.findForward("seleccion_gestor_relaciones"));
		} else {
			obtenerErrores(request, true).add(errores);

			setReturnActionFordward(request,
					mappings.findForward("seleccion_relaciones"));
		}
	}

	/**
	 * Realiza la asignacion de la relaci�n de entrega al nuevo gestor
	 * seleccionado, estableciendo los campos necesarios.
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
	public void asignarGestorExecuteLogic(ActionMapping mappings,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CesionRelacionesForm cesionForm = (CesionRelacionesForm) form;

		// Validar el formulario
		ActionErrors errores = cesionForm.validateSeleccionGestor(mappings,
				request);
		if (errores.isEmpty()) {
			try {
				GestionRelacionesEntregaBI relacionesBI = getGestionRelacionesBI(request);

				// Asignamos el usuario a la/s previsi�n/es seleccionada/s
				request.setAttribute(TransferenciasConstants.GESTOR_KEY,
						relacionesBI.asignarRelacionesAGestorArchivo(
								cesionForm.getRelacionesSeleccionadas(),
								cesionForm.getGestor()));

				// Informaci�n de las relaciones de entrega seleccionadas
				Collection relaciones = relacionesBI
						.getRelacionesXIds(cesionForm
								.getRelacionesSeleccionadas());
				CollectionUtils
						.transform(relaciones, RelacionToPO
								.getInstance(getServiceRepository(request)));
				setInTemporalSession(request,
						TransferenciasConstants.LISTA_RELACIONES_KEY,
						relaciones);

				setReturnActionFordward(request,
						mappings.findForward("resultado_asignacion_relaciones"));
			} catch (ActionNotAllowedException anae) {
				guardarError(request, anae);
				setReturnActionFordward(request,
						mappings.findForward("seleccion_gestor_relaciones"));
			}
		} else {
			obtenerErrores(request, true).add(errores);

			setReturnActionFordward(request,
					mappings.findForward("seleccion_gestor_relaciones"));
		}
	}

}
