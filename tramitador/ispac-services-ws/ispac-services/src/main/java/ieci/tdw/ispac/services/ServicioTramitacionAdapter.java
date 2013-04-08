package ieci.tdw.ispac.services;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.services.dto.DatosComunesExpediente;
import ieci.tdw.ispac.services.dto.DocumentoExpediente;
import ieci.tdw.ispac.services.dto.Expediente;
import ieci.tdw.ispac.services.dto.InfoBExpediente;
import ieci.tdw.ispac.services.dto.InfoBProcedimiento;
import ieci.tdw.ispac.services.dto.InfoFichero;
import ieci.tdw.ispac.services.dto.InfoOcupacion;
import ieci.tdw.ispac.services.dto.Procedimiento;
import ieci.tdw.ispac.services.mgr.CatalogoManager;
import ieci.tdw.ispac.services.mgr.CustodiaManager;
import ieci.tdw.ispac.services.mgr.TramitacionManager;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Implementaci�n del servicio de Tramitaci�n de SIGEM.
 *
 */
public class ServicioTramitacionAdapter implements ServicioTramitacion {

	/** Logger de la clase. */
	private static final Logger logger = 
		Logger.getLogger(ServicioTramitacionAdapter.class);

	
	/**
	 * Recupera la lista de procedimientos del tipo que se indica en 
	 * tipoProc, con su informaci�n b�sica.
	 * @param tipoProc Tipo de procedimiento.
	 * <p>Valores posibles de tipoProc (@see InfoBProcedimiento):
	 * <li>1 - Todos</li>
	 * <li>2 - Procedimientos  automatizados</li>
	 * <li>3 - Procedimientos no automatizados</li>
	 * </p>
	 * @param nombre Nombre del procedimiento.
	 * @return Lista de informaci�n de procedimientos.
	 */
	public InfoBProcedimiento[] getProcedimientos(int tipoProc, String nombre) 
			throws ISPACException {
		try {
			return CatalogoManager.getInstance()
				.getProcedimientos(tipoProc, nombre);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener los procedimientos [tipoProc="
					+ tipoProc + ", nombre=" + nombre + "]", e);
			throw new ISPACException("Error al obtener los procedimientos", e);
		}
	}

	/**
	 * Recupera la lista de procedimientos cuyos identificadores se 
	 * incluyen en el par�metro idProcs.
	 * @param idProcs Lista de identificadores de procedimientos.
	 * @return Lista de informaci�n de procedimientos.
	 */
	public InfoBProcedimiento[] getProcedimientos(String[] idProcs) 
			throws ISPACException {
		try {
			return CatalogoManager.getInstance().getProcedimientos(idProcs);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener los procedimientos [idProcs="
					+ StringUtils.join(idProcs, ",") + "]", e);
			throw new ISPACException("Error al obtener los procedimientos", e);
		}
	}

	/**
	 * Recupera la informaci�n de un procedimiento cuyo identificador 
	 * �nico es idProc.
	 * @param idProc Identificador de procedimiento.
	 * @return Informaci�n del procedimiento.
	 */
	public Procedimiento getProcedimiento(String idProc) throws ISPACException {
		try {
			return CatalogoManager.getInstance().getProcedimiento(idProc);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener el procedimiento [idProc="
					+ idProc + "]", e);
			throw new ISPACException("Error al obtener el procedimiento", e);
		}
	}

    /**
     * Obtiene el contenido del documento.
     * @param guid GUID del documento
     * @return Contenido del documento.
     * @throws ISPACException si ocurre alg�n error.
     */
    public byte [] getFichero(String guid) throws ISPACException {
		try {
			return CustodiaManager.getInstance().getFichero(guid);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener el contenido del fichero[guid="
					+ guid + "]", e);
			throw new ISPACException("Error al obtener el contenido del fichero", e);
		}
    }

	/**
	 * Obtiene la informaci�n de origen e integridad del documento.
	 * @param guid GUID del documento.
	 * @return Informaci�n del documento.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public InfoFichero getInfoFichero(String guid) 
			throws ISPACException {
		try {
			return CustodiaManager.getInstance().getInfoFichero(guid);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener la informaci�n del fichero[guid="
					+ guid + "]", e);
			throw new ISPACException("Error al obtener la informaci�n del fichero", e);
		}
	}

	/**
	 * Obtiene la informaci�n de ocupaci�n del repositorio.
	 * @return Informaci�n de ocupaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public InfoOcupacion getInfoOcupacion() throws ISPACException {
		try {
			return CustodiaManager.getInstance().getInfoOcupacion();
		} catch (Throwable e){
			logger.error("Error inesperado al obtener la informaci�n de ocupaci�n", e);
			throw new ISPACException("Error al obtener la informaci�n de ocupaci�n", e);
		}
	}

	/**
	 * Elimina los documentos determinados por los GUIDs.
	 * @param guids Lista de GUIDs de los documentos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void eliminaFicheros(String[] guids) throws ISPACException {
		try {
			CustodiaManager.getInstance().eliminaFicheros(guids);
		} catch (Throwable e){
			logger.error("Error inesperado al eliminar los ficheros [guids="
					+ StringUtils.join(guids, ",") + "]", e);
			throw new ISPACException("Error al eliminar los ficheros", e);
		}
	}

	/**
	 * Recupera los identificadores de los expedientes,  del procedimiento identificado 
	 * por idProc, que hayan finalizado en el rango de fechas comprendido entre fechaIni
	 * y fechaFin ordenados por lo que indique el par�metro tipoOrd.
	 * @param idProc Identificador del procedimiento.
	 * @param fechaIni Fecha de inicio.
	 * @param fechaFin Fecha de fin.
	 * @param tipoOrd Tipo de ordenaci�n.
	 * <p>Valores posibles:
	 * <li>1 - N�mero de expediente</li>
	 * <li>2 - Fecha finalizaci�n</li>
	 * </p>
	 * @return Lista de identificadores de expedientes.
	 */
	public String[] getIdsExpedientes(String idProc, Date fechaIni,
			Date fechaFin, int tipoOrd) throws ISPACException {
		try {
			return TramitacionManager.getInstance().getIdsExpedientes(idProc, 
					fechaIni, fechaFin, tipoOrd);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener los identificadores de expedientes [idProc="
					+ idProc + ", fechaIni=" + fechaIni + ", fechaFin=" 
					+ fechaFin + ", tipoOrd=" + tipoOrd + "]", e);
			throw new ISPACException("Error al obtener los identificadores de expedientes", e);
		}
	}

	/**
	 * Recupera la lista de expedientes cuyos identificadores se incluyen en 
	 * el par�metro idExps.
	 * @param idExps Identificadores de expedientes.
	 * @return Lista de expedientes.
	 */
	public InfoBExpediente[] getExpedientes(String[] idExps) 
			throws ISPACException {
		try {
			return TramitacionManager.getInstance().getExpedientes(idExps);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener los expedientes [idExps="
					+ StringUtils.join(idExps, ",") + "]", e);
			throw new ISPACException("Error al obtener los expedientes", e);
		}
	}

	/**
	 * Recupera la informaci�n de un expediente cuyo identificador �nico es idExp.
	 * @param idExp Identificador del expediente.
	 * @return Informaci�n de un expediente.
	 */
	public Expediente getExpediente(String idExp) throws ISPACException {
		try {
			return TramitacionManager.getInstance().getExpediente(idExp);
		} catch (Throwable e){
			logger.error("Error inesperado al obtener el expediente [idExp="
					+ idExp + "]", e);
			throw new ISPACException("Error al obtener el expediente", e);
		}
	}
	
	/**
	 * Modifica el estado de los expedientes recibidos como par�metro a estado archivado
	 * @param idExps  Array de String con los expedientes que se quieren pasar al estado archivado
	 * @throws ISPACException
	 */
	public void archivarExpedientes(String[] idExps) throws ISPACException {
		
		try {
			TramitacionManager.getInstance().archivarExpedientes(idExps);
		} catch (Throwable e){
			logger.error("Error inesperado al archivar los expedientes[idExps="
					+ StringUtils.join(idExps, ",") + "]", e);
			throw new ISPACException("Error archivar los expedientes", e);
		}
	}
	
    /**
     * Iniciar un expediente.
     * 
     * @param datosComunes Datos comunes para todos los expedientes.
     * @param datosEspecificos XML con los datos espec�ficos del expediente.
     * @param documentos Lista de documentos asociados al expediente.
     * @return Cierto si el expediente se ha iniciado correctamente.
     * @throws ISPACException Si se produce alg�n error al iniciar el expediente.
     */
    public boolean iniciarExpediente(DatosComunesExpediente datosComunes, 
    			String datosEspecificos, DocumentoExpediente[] documentos) 
    		throws ISPACException {
		try {
			return TramitacionManager.getInstance().iniciarExpediente(
					datosComunes, datosEspecificos, documentos);
		} catch (Throwable e){
			logger.error("Error inesperado al iniciar el expediente [datosComunes="
					+ datosComunes + ", datosEspecificos=" + datosEspecificos 
					+ ", documentos=" + documentos + "]", e);
			throw new ISPACException("Error al iniciar el expediente", e);
		}
    }

    
    /**
     * Iniciar un expediente.
     * 
     * @param datosComunes Datos comunes para todos los expedientes.
     * @param datosEspecificos XML con los datos espec�ficos del expediente.
     * @param documentos Lista de documentos asociados al expediente.
     * @param initSytem Sistema externo desdel el que se inicia el expediente
     * @return Numero de expediente creado
     * @throws ISPACException Si se produce alg�n error al iniciar el expediente.
     */
    public String iniciarExpediente(DatosComunesExpediente datosComunes, 
    			String datosEspecificos, DocumentoExpediente[] documentos, String initSystem) 
    		throws ISPACException {
		try {
			return TramitacionManager.getInstance().iniciarExpediente(
					datosComunes, datosEspecificos, documentos, initSystem);
		} catch (Throwable e){
			logger.error("Error inesperado al iniciar el expediente [datosComunes="
					+ datosComunes + ", datosEspecificos=" + datosEspecificos 
					+ ", documentos=" + documentos + "]", e);
			throw new ISPACException("Error al iniciar el expediente", e);
		}
    }    
    
    
    
    
    /**
     * A�ade documentos al tr�mite de un expediente.
     * @param numExp N�mero de expediente.
     * @param numReg N�mero de registro de entrada.
     * @param fechaReg Fecha de registro de entrada.
     * @param documentos Lista de documentos asociados al expediente.
     * @return Cierto si los documentos se han creado correctamente.
     * @throws ISPACException Si se produce alg�n error.
     */
    public boolean anexarDocsExpediente(String numExp, String numReg, 
    			Date fechaReg, DocumentoExpediente[] documentos) 
    		throws ISPACException {
		try {
			return TramitacionManager.getInstance().anexarDocsExpediente(
					numExp, numReg, fechaReg, documentos);
		} catch (Throwable e){
			logger.error("Error inesperado al anexar documentos al expediente [numExp="
					+ numExp + ", numReg=" + numReg + ", fechaReg=" + fechaReg 
					+ ", documentos=" + documentos + "]", e);
			throw new ISPACException("Error al anexar documentos al expediente", e);
		}
    	
    }
    /**
     * Cambia el estado administrativo de un expediente
     * @param numExp N�mero de expediente.
     * @param estadoAdm Nuevo estado administrativo
     * @return Cierto si la operaci�n se ha realizado con �xito, falso en caso contrario
     * @throws ISPACException 
     */
	public boolean cambiarEstadoAdministrativo(String numExp, String estadoAdm)
			throws ISPACException {
		try {
			return TramitacionManager.getInstance().cambiarEstadoAdministrativo(numExp, estadoAdm);
		} catch (Throwable e){
			logger.error("Error inesperado al cambiar estado administrativo del expediente '" + numExp + "'", e);
			throw new ISPACException("Error al cambiar estado administrativo del expediente '" + numExp + "'", e);
		}
    }
    /**
     * Mueve un expedinete a una fase seg�n el identificador de la misma en el cat�logo. 
     * @param numExp N�mero de expediente.
     * @param idFaseCatalogo Identificador de la fase en el cat�logo
     * @return Cierto si la operaci�n se ha realizado con �xito, falso en caso contrario
     * @throws ISPACException
     */
	public boolean moverExpedienteAFase(String numExp, String idFaseCatalogo)
			throws ISPACException {
		try {
			return TramitacionManager.getInstance().moverExpedienteAFase(numExp, idFaseCatalogo);
		} catch (Throwable e){
			logger.error("Error al mover el expediente '"+numExp+" a la fase cuyo identificador en el cat�logo es '" + idFaseCatalogo + "'", e);
			throw new ISPACException("Error al mover el expediente '"+numExp+" a la fase cuyo identificador en el cat�logo es '" + idFaseCatalogo + "'", e);
		}
	}

    /**
     * Busqueda avanzada sobre expedientes
     * @param groupName Nombre de grupo
     * @param searchFormName Nombre del formulario de busqueda a utilizar
     * @param searchXML XML con los criterios de busqueda
     * @param domain dominio de busqueda (en funcion de la responsabilidad)
     * @return Resultado de la busqueda
     * @throws ISPACException
     */
    public String busquedaAvanzada(String nombreGrupo, String nombreFrmBusqueda, String xmlBusqueda, int dominio) throws ISPACException {
		try {
			return TramitacionManager.getInstance().busquedaAvanzada(nombreGrupo, nombreFrmBusqueda, xmlBusqueda, dominio);
		} catch (Throwable e){
			logger.error("Error al realizar busqueda avanzada", e);
			throw new ISPACException("Error al realizar busqueda avanzada", e);
		}
	}

    /**
     * Inserta o actualiza los datos de un registro de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param xmlDatosEspecificos Datos especificos para completar los campos del registro a crear
     * @return identificador del registro creado
     * @throws ISPACException
     */	
	public int establecerDatosRegistroEntidad(String nombreEntidad,
			String numExp, String xmlDatosEspecificos) throws ISPACException {
		try {
			return TramitacionManager.getInstance().establecerDatosRegistroEntidad(nombreEntidad, numExp, xmlDatosEspecificos);
		} catch (Throwable e){
			logger.error("Error al establecer datos de un registro en la entidad '" + nombreEntidad + "'", e);
			throw new ISPACException("Error al al establecer datos de un registro en la entidad '" + nombreEntidad + "'", e);
		}	
	}

    /**
     * Obtiene los datos de un registro de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param idRegistro Identificdaor del registro
     * @return Informaci�n del registro obtenido
     * @throws ISPACException
     */
	public String obtenerRegistroEntidad(String nombreEntidad, String numExp,
			int idRegistro) throws ISPACException {
		try {
			return TramitacionManager.getInstance().obtenerRegistroEntidad(nombreEntidad, numExp, idRegistro);
		} catch (Throwable e){
			logger.error("Error al obtener datos de un registro en la entidad '" + nombreEntidad + "'", e);
			throw new ISPACException("Error al obtener datos de un registro en la entidad '" + nombreEntidad + "'", e);
		}
	}


    /**
     * Obtiene los datos de todos los registros de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param idRegistro Identificdaor del registro
     * @return Informaci�n del registro obtenido
     * @throws ISPACException
     */
	public String obtenerRegistrosEntidad(String nombreEntidad, String numExp)
			throws ISPACException {
		try {
			return TramitacionManager.getInstance().obtenerRegistrosEntidad(nombreEntidad, numExp);
		} catch (Throwable e){
			logger.error("Error al obtener todos los registros de la entidad '" + nombreEntidad + "'", e);
			throw new ISPACException("Error al obtener todos los registros de la entidad '" + nombreEntidad + "'", e);
		}
	}
}