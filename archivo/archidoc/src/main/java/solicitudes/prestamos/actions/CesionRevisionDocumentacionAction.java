package solicitudes.prestamos.actions;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import solicitudes.prestamos.EstadoRevDoc;
import solicitudes.prestamos.PrestamosConstants;
import solicitudes.prestamos.forms.CesionPrestamosForm;
import solicitudes.prestamos.forms.CesionRevisionDocumentacionForm;
import solicitudes.prestamos.vos.RevisionDocumentacionToPO;
import solicitudes.prestamos.vos.RevisionDocumentacionVO;

import common.Constants;
import common.actions.BaseAction;
import common.bi.GestionPrestamosBI;
import common.bi.ServiceRepository;
import common.exceptions.ActionNotAllowedException;
import common.exceptions.TooManyResultsException;
import common.navigation.ClientInvocation;
import common.navigation.KeysClientsInvocations;

/**
 * Clase que encapsula todas las acciones relacionadas con la cesi�n de
 * prestamos por parte de un usuario de la aplicaci�n a otro usuario. Se
 * establece un wizard donde se selecciona un prestamo bien de los existentes
 * para el usuario o de un usuario seleccionado, para posteriormente seleccionar
 * el usuario destino de dicho pr�stamo.
 */
public class CesionRevisionDocumentacionAction extends BaseAction {

	/**
	 * Prepara la p�gina con el buscador de revisiones de documentacion por
	 * campos titulo, signatura, expediente y observaciones.
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
		saveCurrentInvocation(
				KeysClientsInvocations.SOLICITUDES_SELECT_REV_DOCUMENTACION_CEDER,
				request);

		// Establecer el tipo de b�squeda
		CesionRevisionDocumentacionForm cesionForm = (CesionRevisionDocumentacionForm) form;
		cesionForm
				.setTipoBusqueda(CesionRevisionDocumentacionForm.TIPO_BUSQUEDA_POR_REVISION);

		setReturnActionFordward(request,
				mappings.findForward("seleccion_rev_documentacion"));
	}

	/**
	 * Prepara la p�gina para seleccionar el pr�stamo del que se va ceder
	 * buscando por gestor el control a partir de un gestor.
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
		CesionRevisionDocumentacionForm cesionForm = (CesionRevisionDocumentacionForm) form;

		// Establecemos el punto actual de navegacion
		ClientInvocation invocation = saveCurrentInvocation(
				KeysClientsInvocations.SOLICITUDES_SELECT_REV_DOCUMENTACION_CEDER,
				request);
		invocation.addParameters(cesionForm.getMap());

		// Establecer el tipo de b�squeda
		cesionForm
				.setTipoBusqueda(CesionPrestamosForm.TIPO_BUSQUEDA_POR_GESTOR);

		// Obtener los gestores
		setInTemporalSession(request, PrestamosConstants.LISTA_GESTORES_KEY,
				getGestionPrestamosBI(request)
						.getGestoresConRevisionesDocumentacion());

		setReturnActionFordward(request,
				mappings.findForward("seleccion_rev_documentacion"));
	}

	/**
	 * Realiza la b�squeda de pr�stamos para su selecci�n.
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
		// ServiceRepository services = getServiceRepository(request);
		// Establecemos el punto actual de navegacion
		saveCurrentInvocation(
				KeysClientsInvocations.SOLICITUDES_SELECT_REV_DOCUMENTACION_CEDER,
				request);

		// Validar el formulario
		ActionErrors errores = form.validate(mappings, request);
		if (errores.isEmpty()) {
			CesionRevisionDocumentacionForm cesionForm = (CesionRevisionDocumentacionForm) form;
			RevisionDocumentacionVO revDocVO = new RevisionDocumentacionVO();
			revDocVO.setEstado(EstadoRevDoc.ABIERTA.getIdentificador());

			if (cesionForm.getTipoBusqueda() == CesionPrestamosForm.TIPO_BUSQUEDA_POR_PRESTAMO) {
				revDocVO.setExpedienteUdoc(cesionForm.getExpediente());
				revDocVO.setSignaturaUdoc(cesionForm.getSignatura());
				revDocVO.setTitulo(cesionForm.getTitulo());
				revDocVO.setObservaciones(cesionForm.getObservaciones());
			} else {
				revDocVO.setIdUsrGestor(cesionForm.getGestor());
			}

			try {
				// Obtiene la lista de pr�stamos
				Collection listaRevisionesDoc = getGestionPrestamosBI(request)
						.getRevisionesDocumentacion(revDocVO);
				// CollectionUtils.transform(listaPrestamos,
				// PrestamoToPO.getInstance(request.getLocale(),services));
				request.setAttribute(
						PrestamosConstants.LISTA_REVISIONES_DOC_KEY,
						listaRevisionesDoc);

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
				mappings.findForward("seleccion_rev_documentacion"));
	}

	/**
	 * Obtiene el prestamo que vamos a ceder as� como los posibles gestores de
	 * dicho pr�stamo.
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
		ServiceRepository services = getServiceRepository(request);
		// Establecemos el punto actual de navegacion
		saveCurrentInvocation(
				KeysClientsInvocations.SOLICITUDES_SELECT_USUARIO_CEDER,
				request);

		// Informaci�n del formulario
		CesionRevisionDocumentacionForm cesionForm = (CesionRevisionDocumentacionForm) form;

		// Validar el formulario
		ActionErrors errores = cesionForm.validateSeleccion(mappings, request);
		if (errores.isEmpty()) {
			GestionPrestamosBI prestamosBI = getGestionPrestamosBI(request);

			// Informaci�n del pr�stamo seleccionado
			RevisionDocumentacionVO revDocVO = prestamosBI
					.getRevisionDocumentacionById(cesionForm
							.getRevDocSeleccionada());
			RevisionDocumentacionToPO transformer = RevisionDocumentacionToPO
					.getInstance(request.getLocale(), services);

			setInTemporalSession(request, PrestamosConstants.REVISION_DOC_KEY,
					transformer.transform(revDocVO));

			// Obtenemos los posibles usuarios de la previsi�n
			setInTemporalSession(
					request,
					PrestamosConstants.LISTA_GESTORES_KEY,
					prestamosBI.getUsuariosGestoresRevDocPosibles(getAppUser(
							request).getCustodyArchiveList()));

			setReturnActionFordward(request,
					mappings.findForward("seleccion_gestor"));
		} else {
			obtenerErrores(request, true).add(errores);

			setReturnActionFordward(request,
					mappings.findForward("seleccion_rev_documentacion"));
		}
	}

	/**
	 * Realiza la asignacion del pr�stamo al nuevo gestor seleccionado,
	 * estableciendo los campos necesarios.
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
		try {
			// Informaci�n del formulario
			CesionRevisionDocumentacionForm cesionForm = (CesionRevisionDocumentacionForm) form;

			// Validar el formulario
			ActionErrors errores = cesionForm.validateSeleccionGestor(mappings,
					request);
			if (errores.isEmpty()) {
				// Informaci�n del pr�stamo seleccionado
				RevisionDocumentacionVO revDocVO = (RevisionDocumentacionVO) getFromTemporalSession(
						request, PrestamosConstants.REVISION_DOC_KEY);

				GestionPrestamosBI prestamosBI = getGestionPrestamosBI(request);

				// Asignamos el usuario a la/s previsi�n/es seleccionada/s
				request.setAttribute(PrestamosConstants.GESTOR_KEY, prestamosBI
						.asignarRevisionDocAGestor(revDocVO,
								cesionForm.getGestor()));

				// Actualizar la informaci�n del pr�stamo
				revDocVO = prestamosBI.getRevisionDocumentacionById(revDocVO
						.getIdRevDoc());
				ServiceRepository services = getServiceRepository(request);

				RevisionDocumentacionToPO transformer = RevisionDocumentacionToPO
						.getInstance(request.getLocale(), services);

				setInTemporalSession(request,
						PrestamosConstants.REVISION_DOC_KEY,
						transformer.transform(revDocVO));

				setReturnActionFordward(request,
						mappings.findForward("resultado_asignacion"));
			} else {
				obtenerErrores(request, true).add(errores);

				setReturnActionFordward(request,
						mappings.findForward("seleccion_gestor"));
			}
		} catch (ActionNotAllowedException e) {
			guardarError(request, e);
			// cleanTemporalSessionValues(request);
			goLastClientExecuteLogic(mappings, form, request, response);
		}
	}
}
