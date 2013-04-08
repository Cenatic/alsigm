package docelectronicos.model;

import gcontrol.vos.UsuarioVO;

import java.util.Locale;

import auditoria.ArchivoDetails;
import auditoria.logger.DataLoggingEvent;
import auditoria.logger.LoggingEvent;

import common.bi.GestionControlUsuariosBI;
import common.bi.IServiceBase;
import common.definitions.ArchivoActions;
import common.definitions.ArchivoModules;
import common.definitions.ArchivoObjects;

import docelectronicos.TipoObjeto;
import docelectronicos.vos.DocClasificadorVO;
import docelectronicos.vos.DocDocumentoVO;
import docelectronicos.vos.DocTCapturaVO;

/**
 * Clase para auditar la gesti�n de los documentos electr�nicos.
 */
public class AuditoriaDocumentos {

	/**
	 * Obtiene un evento de auditor�a.
	 * 
	 * @param service
	 *            Servicio a auditar.
	 * @param action
	 *            C�digo de la acci�n a auditar.
	 * @return Evento de auditor�a ({@link LoggingEvent}).
	 */
	public static LoggingEvent getLogginEvent(IServiceBase service, int action) {
		// Crear el evento
		LoggingEvent event = new LoggingEvent(
				ArchivoModules.DOCUMENTOS_ELECTRONICOS_MODULE, action,
				service.getServiceClient(), false);

		// A�adir el evento al logger
		service.getLogger().add(event);

		return event;
	}

	/**
	 * Audita la inserci�n de un clasificador de documentos electr�nicos.
	 * 
	 * @param event
	 *            Evento de auditor�a.
	 * @param clasificador
	 *            Clasificador de documentos electr�nicos.
	 */
	public static void auditaInsercionClasificador(Locale locale,
			LoggingEvent event, DocClasificadorVO clasificador) {
		// Detalle de la auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_CLASIFICADOR, clasificador.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_CLASIFICADOR,
				clasificador.getNombre());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_CLF_PADRE,
				clasificador.getIdClfPadre());
		data.addDetalle(
				locale,
				clasificador.getTipoObjeto() == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				clasificador.getIdObjeto());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_MARCAS,
				new Integer(clasificador.getMarcas()).toString());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ESTADO,
				new Integer(clasificador.getEstado()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_DESCRIPCION,
				clasificador.getDescripcion());
	}

	/**
	 * Audita la modificaci�n de un clasificador de documentos electr�nicos.
	 * 
	 * @param service
	 *            Servicio a auditar.
	 * @param clasificador
	 *            Clasificador de documentos electr�nicos.
	 */
	public static void auditaModificacionClasificador(Locale locale,
			IServiceBase service, DocClasificadorVO clasificador) {
		// Evento de auditor�a
		LoggingEvent event = getLogginEvent(
				service,
				ArchivoActions.DOCUMENTOS_ELECTRONICOS_MODULE_MODIFICACION_CLASIFICADOR);

		// Detalle de auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_CLASIFICADOR, clasificador.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_CLASIFICADOR,
				clasificador.getNombre());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_CLF_PADRE,
				clasificador.getIdClfPadre());
		data.addDetalle(
				locale,
				clasificador.getTipoObjeto() == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				clasificador.getIdObjeto());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_MARCAS,
				new Integer(clasificador.getMarcas()).toString());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ESTADO,
				new Integer(clasificador.getEstado()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_DESCRIPCION,
				clasificador.getDescripcion());
	}

	/**
	 * Audita la eliminaci�n de un clasificador de documentos electr�nicos.
	 * 
	 * @param service
	 *            Servicio a auditar.
	 * @param id
	 *            Identificador del clasificador.
	 * @param nombre
	 *            Nombre del clasificador
	 */
	public static void auditaEliminacionClasificador(Locale locale,
			IServiceBase service, String id, String nombre) {
		// Evento de auditor�a
		LoggingEvent event = getLogginEvent(service,
				ArchivoActions.DOCUMENTOS_ELECTRONICOS_MODULE_BAJA_CLASIFICADOR);

		// Detalle de auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_CLASIFICADOR, id);

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_CLASIFICADOR,
				nombre);
	}

	/**
	 * Audita la inserci�n de un documento electr�nico.
	 * 
	 * @param event
	 *            Evento de auditor�a.
	 * @param documento
	 *            Documento electr�nico.
	 */
	public static void auditaInsercionDocumento(Locale locale,
			LoggingEvent event, DocDocumentoVO documento) {
		// Detalle de la auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_DOCUMENTO, documento.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_DOCUMENTO,
				documento.getNombre());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_CLF_PADRE,
				documento.getIdClfPadre());
		data.addDetalle(
				locale,
				documento.getTipoObjeto() == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				documento.getIdObjeto());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TAMANO_FICHERO,
				new Double(documento.getTamanoFich()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_ORIGINAL_FICHERO,
				documento.getNombreOrgFich());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_EXTENSION_FICHERO,
				documento.getExtFich());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_FICHERO,
				documento.getIdFich());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ESTADO,
				new Integer(documento.getEstado()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_DESCRIPCION,
				documento.getDescripcion());
	}

	/**
	 * Audita la modificaci�n de un documento electr�nico.
	 * 
	 * @param service
	 *            Servicio a auditar.
	 * @param documento
	 *            Documento electr�nico.
	 */
	public static void auditaModificacionDocumento(Locale locale,
			IServiceBase service, DocDocumentoVO documento) {
		// Evento de auditor�a
		LoggingEvent event = getLogginEvent(
				service,
				ArchivoActions.DOCUMENTOS_ELECTRONICOS_MODULE_MODIFICACION_DOCUMENTO);

		// Detalle de auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_DOCUMENTO, documento.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_DOCUMENTO,
				documento.getNombre());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_CLF_PADRE,
				documento.getIdClfPadre());
		data.addDetalle(
				locale,
				documento.getTipoObjeto() == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				documento.getIdObjeto());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TAMANO_FICHERO,
				new Double(documento.getTamanoFich()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_ORIGINAL_FICHERO,
				documento.getNombreOrgFich());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_EXTENSION_FICHERO,
				documento.getExtFich());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_FICHERO,
				documento.getIdFich());
		data.addDetalle(locale, ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ESTADO,
				new Integer(documento.getEstado()).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_DESCRIPCION,
				documento.getDescripcion());
	}

	/**
	 * Audita la eliminaci�n de un documento electr�nico.
	 * 
	 * @param service
	 *            Servicio a auditar.
	 * @param id
	 *            Identificador del documento electr�nico.
	 * @param nombre
	 *            Nombre del documento electr�nico.
	 * @param idFich
	 *            Identificador del fichero en el repositorio.
	 */
	public static void auditaEliminacionDocumento(Locale locale,
			IServiceBase service, String id, String nombre, String idFich) {
		// Evento de auditor�a
		LoggingEvent event = getLogginEvent(service,
				ArchivoActions.DOCUMENTOS_ELECTRONICOS_MODULE_BAJA_DOCUMENTO);

		// Detalle de auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_DOCUMENTO, id);

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NOMBRE_DOCUMENTO, nombre);
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_FICHERO, idFich);
	}

	// public static void auditaInsercionTarea(LoggingEvent event, DocTCapturaVO
	// tarea)
	// {
	// // Detalle de la auditor�a
	// DataLoggingEvent data = event.getDataLoggingEvent(
	// ArchivoObjects.OBJECT_TAREA, tarea.getId());
	//
	// data.addDetalle(ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TITULO_OBJETO,
	// tarea.getTituloObj());
	// data.addDetalle(
	// TipoObjeto.valueOf(tarea.getTipoObj()) == TipoObjeto.ELEMENTO_CF
	// ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
	// : ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
	// tarea.getIdObj());
	// data.addDetalle(ArchivoDetails.DOCUMENTOS_ELECTRONICOS_USUARIO_CAPTURA,
	// new
	// StringBuffer(tarea.getNombreUsuario()).append(tarea.getApellidosUsuario()).toString());
	// }

	public static void auditaDetalleCambioEstadoTarea(Locale locale,
			LoggingEvent event, DocTCapturaVO tarea, int oldEstado,
			int newEstado) {
		// Detalle de la auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_TAREA, tarea.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ESTADO_ANTERIOR,
				new Integer(oldEstado).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_NUEVO_ESTADO,
				new Integer(newEstado).toString());
		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TITULO_OBJETO,
				tarea.getTituloObj());
		data.addDetalle(
				locale,
				TipoObjeto.valueOf(tarea.getTipoObj()) == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				tarea.getIdObj());
		data.addDetalle(
				locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_USUARIO_CAPTURA,
				new StringBuffer(tarea.getNombreUsuario()).append(
						tarea.getApellidosUsuario()).toString());
	}

	// public static void auditaEliminarTarea(LoggingEvent event, DocTCapturaVO
	// tarea)
	// {
	// // Detalle de la auditor�a
	// DataLoggingEvent data = event.getDataLoggingEvent(
	// ArchivoObjects.OBJECT_TAREA, tarea.getId());
	//
	// data.addDetalle(ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TITULO_OBJETO,
	// tarea.getTituloObj());
	// data.addDetalle(
	// TipoObjeto.valueOf(tarea.getTipoObj()) == TipoObjeto.ELEMENTO_CF
	// ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
	// : ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
	// tarea.getIdObj());
	// data.addDetalle(ArchivoDetails.DOCUMENTOS_ELECTRONICOS_USUARIO_CAPTURA,
	// new
	// StringBuffer(tarea.getNombreUsuario()).append(tarea.getApellidosUsuario()).toString());
	// }

	public static void auditaDetalleInfoTarea(Locale locale,
			LoggingEvent event, DocTCapturaVO tarea,
			GestionControlUsuariosBI usuarioService) {
		// Detalle de la auditor�a
		DataLoggingEvent data = event.getDataLoggingEvent(
				ArchivoObjects.OBJECT_TAREA, tarea.getId());

		data.addDetalle(locale,
				ArchivoDetails.DOCUMENTOS_ELECTRONICOS_TITULO_OBJETO,
				tarea.getTituloObj());
		data.addDetalle(
				locale,
				TipoObjeto.valueOf(tarea.getTipoObj()) == TipoObjeto.ELEMENTO_CF ? ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_ELEMENTO_CF
						: ArchivoDetails.DOCUMENTOS_ELECTRONICOS_ID_DESCRIPTOR,
				tarea.getIdObj());

		UsuarioVO usuario = usuarioService.getUsuario(tarea.getIdUsrCaptura());
		if (usuario != null) {
			data.addDetalle(locale,
					ArchivoDetails.DOCUMENTOS_ELECTRONICOS_USUARIO_CAPTURA,
					usuario.getNombreCompleto());
		}
	}

}
