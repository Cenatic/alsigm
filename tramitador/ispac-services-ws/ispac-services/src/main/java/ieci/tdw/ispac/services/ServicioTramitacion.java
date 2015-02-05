package ieci.tdw.ispac.services;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.services.dto.DatosComunesExpediente;
import ieci.tdw.ispac.services.dto.DocumentoExpediente;
import ieci.tdw.ispac.services.dto.Expediente;
import ieci.tdw.ispac.services.dto.InfoBExpediente;
import ieci.tdw.ispac.services.dto.InfoBProcedimiento;
import ieci.tdw.ispac.services.dto.InfoFichero;
import ieci.tdw.ispac.services.dto.InfoOcupacion;
import ieci.tdw.ispac.services.dto.Procedimiento;

import java.util.Date;


/**
 * Interfaz para el servicio de Tramitaci�n.  
 * 
 */
public interface ServicioTramitacion {

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
		throws ISPACException;

	/**
	 * Recupera la lista de procedimientos cuyos identificadores se 
	 * incluyen en el par�metro idProcs.
	 * @param idProcs Lista de identificadores de procedimientos.
	 * @return Lista de informaci�n de procedimientos.
	 */
	public InfoBProcedimiento[] getProcedimientos(String[] idProcs) 
		throws ISPACException;

	/**
	 * Recupera la informaci�n de un procedimiento cuyo identificador 
	 * �nico es idProc.
	 * @param idProc Identificador de procedimiento.
	 * @return Informaci�n del procedimiento.
	 */
	public Procedimiento getProcedimiento(String idProc) 
		throws ISPACException;

    /**
     * Obtiene el contenido del documento.
     * @param guid GUID del documento
     * @return Contenido del documento.
     * @throws ISPACException si ocurre alg�n error.
     */
    public byte [] getFichero(String guid) throws ISPACException;

	/**
	 * Obtiene la informaci�n de origen e integridad del documento.
	 * @param guid GUID del documento.
	 * @return Informaci�n del documento.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public InfoFichero getInfoFichero(String guid) 
		throws ISPACException;

	/**
	 * Obtiene la informaci�n de ocupaci�n del repositorio.
	 * @return Informaci�n de ocupaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public InfoOcupacion getInfoOcupacion() throws ISPACException;

	/**
	 * Elimina los documentos determinados por los GUIDs.
	 * @param guids Lista de GUIDs de los documentos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void eliminaFicheros(String[] guids) throws ISPACException;

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
			Date fechaFin, int tipoOrd) throws ISPACException;

	/**
	 * Recupera la lista de expedientes cuyos identificadores se incluyen en 
	 * el par�metro idExps.
	 * @param idExps Identificadores de expedientes.
	 * @return Lista de expedientes.
	 */
	public InfoBExpediente[] getExpedientes(String[] idExps) 
		throws ISPACException;

	/**
	 * Recupera la informaci�n de un expediente cuyo identificador �nico es idExp.
	 * @param idExp Identificador del expediente.
	 * @return Informaci�n de un expediente.
	 */
	public Expediente getExpediente(String idExp) throws ISPACException;
		
	/**
	 * Modifica el estado de los expedientes recibidos como par�metro a estado archivado
	 * @param idExps  Array de String con los expedientes que se quieren pasar al estado archivado
	 * @throws ISPACException
	 */
	public void archivarExpedientes(String []idExps )throws ISPACException;
	
	
    /**
     * Crear un expediente.
     * @param datosComunes Datos comunes para todos los expedientes.
     * @param datosEspecificos XML con los datos espec�ficos del expediente.
     * @param documentos Lista de documentos asociados al expediente.
     * @return Cierto si el expediente se ha creado correctamente.
     * @throws ISPACException si se produce alg�n error.
     */
    public boolean iniciarExpediente(DatosComunesExpediente datosComunes, 
    		String datosEspecificos, DocumentoExpediente[] documentos) 
    	throws ISPACException;

    /**
     * Crear un expediente.
     * @param datosComunes Datos comunes para todos los expedientes.
     * @param datosEspecificos XML con los datos espec�ficos del expediente.
     * @param documentos Lista de documentos asociados al expediente.
     * @param initSytem Sistema externo desdel el que se inicia el expediente
     * @return Numero de expediente creado
     * @throws ISPACException si se produce alg�n error.
     */
    public String iniciarExpediente(DatosComunesExpediente datosComunes, 
    		String datosEspecificos, DocumentoExpediente[] documentos, String initSystem) 
    	throws ISPACException;    
    
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
    	throws ISPACException;


    /**
     * Cambia el estado administrativo de un expediente
     * @param numExp N�mero de expediente.
     * @param estadoAdm Nuevo estado administrativo
     * @return Cierto si la operaci�n se ha realizado con �xito, falso en caso contrario
     * @throws ISPACException
     */
    public boolean cambiarEstadoAdministrativo(String numExp, String estadoAdm) 
    	throws ISPACException;
    
    
    /**
     * Mueve un expedinete a una fase seg�n el identificador de la misma en el cat�logo. 
     * @param numExp N�mero de expediente.
     * @param idFaseCatalogo Identificador de la fase en el cat�logo
     * @return Cierto si la operaci�n se ha realizado con �xito, falso en caso contrario
     * @throws ISPACException
     */
    public boolean moverExpedienteAFase(String numExp, String idFaseCatalogo)
    	throws ISPACException;
    
    
    /**
     * Busqueda avanzada sobre expedientes
     * @param groupName Nombre de grupo
     * @param searchFormName Nombre del formulario de busqueda a utilizar
     * @param searchXML XML con los criterios de busqueda
     * @param domain dominio de busqueda (en funcion de la responsabilidad)
     * @return Resultado de la busqueda
     * @throws ISPACException
     */
    public String busquedaAvanzada(String nombreGrupo, String nombreFrmBusqueda, String xmlBusqueda, int dominio)throws ISPACException;
    
    /**
     * Inserta o actualiza los datos de un registro de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param xmlDatosEspecificos Datos especificos para completar los campos del registro a crear
     * @return identificador del registro creado
     * @throws ISPACException
     */
    public int establecerDatosRegistroEntidad(String nombreEntidad, String numExp, String xmlDatosEspecificos)throws ISPACException;
    
    /**
     * Obtiene los datos de un registro de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param idRegistro Identificdaor del registro
     * @return Informaci�n del registro obtenido
     * @throws ISPACException
     */
    public String obtenerRegistroEntidad(String nombreEntidad, String numExp, int idRegistro)throws ISPACException;
    
    /**
     * Obtiene los datos de todos los registros de una entidad para un expediente
     * @param nombreEntidad Nombre de entidad
     * @param numExp N�mero de expediente
     * @param idRegistro Identificdaor del registro
     * @return Informaci�n del registro obtenido
     * @throws ISPACException
     */
    public String obtenerRegistrosEntidad(String nombreEntidad, String numExp)throws ISPACException;

}
