package ieci.tdw.ispac.ispaclib.sicres;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.sicres.vo.Annexe;
import ieci.tdw.ispac.ispaclib.sicres.vo.Intray;
import ieci.tdw.ispac.ispaclib.sicres.vo.Organization;
import ieci.tdw.ispac.ispaclib.sicres.vo.Register;
import ieci.tdw.ispac.ispaclib.sicres.vo.RegisterInfo;

import java.io.OutputStream;
import java.util.List;

/**
 * Interfaz del conector con SICRES.
 *
 */
public interface ISicresConnector {
		
	public static final String ORGANIZATION_TYPE = "O";

	/**
	 * Indica si el usuario conectado tiene permisos para registrar.
	 * @param registerType Tipo de registro: @see RegisterType
	 * @return true si el usuario puede registrar.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public boolean canRegister(String registerType) throws ISPACException;

	/**
	 * Obtiene la informaci�n completa de un registro.
	 * @param registerInfo Informaci�n b�sica del registro.
	 * @return Informaci�n completa del registro.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Register readRegister(RegisterInfo registerInfo) throws ISPACException;
	
	/**
	 * Crea un registro.
	 * @param register Informaci�n completa del registro.
	 * @return Informaci�n b�sica del registro.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public RegisterInfo insertRegister(Register register) throws ISPACException;

	/**
	 * Obtiene el n�mero de registros distribuidos asociados al usuario conectado.
	 * @return N�mero de registros distribuidos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public int countIntrais() throws ISPACException;

	/**
	 * Obtiene la lista de registros distribuidos asociados al usuario conectado.
	 * @return Lista de registros distribuidos ({@link Intray}).
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public List getIntrays() throws ISPACException;

	/**
	 * Obtiene la informaci�n del registro distribuido.
	 * @param intrayId Identificador del registro distribuido.
	 * @return Informaci�n del registro distribuido.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Intray getIntray(String intrayId) throws ISPACException;

//	/**
//	 * Asocia un registro de distribuci�n con un identificador de
//	 * proceso.
//	 * @param register identificador del registro de distribuci�n
//	 * @param process identificador del proceso
//	 * @param type tipo de relaci�n:
//	 * 	1: Inicio de expediente.
//	 * 	2: Inclusi�n en expediente.
//	 */
//	public void addToProccess(int register, int process, int type)
//			throws ISPACException;

//	/**
//	 * Distribuye un registro de entrada.
//	 * @param register identificador del registro.
//	 * @param state estado del registro.
//	 * @param responsible responsable a quien se le distribuye.
//	 * @param message mensaje asociado a la acci�n
//	 * @throws ISPACException
//	 */
//	public void distribute(int register, Responsible responsible,
//			String message, boolean archive) throws ISPACException;

	/**
	 * Acepta un registro distribuido.
	 * @param intrayId Identificador del registro distribuido.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void acceptIntray(String intrayId) throws ISPACException;

	/**
	 * Rechaza un registro distribuido.
	 * @param intrayId Identificador del registro distribuido.
	 * @param reason Motivo del rechazo.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void rejectIntray(String intrayId, String reason) throws ISPACException;

	/**
	 * Archiva un registro distribuido.
	 * @param intrayId Identificador del registro distribuido.
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	public void archiveIntray(String intrayId) throws ISPACException;

//	/**
//	 * Cambia el estado de un registro de distribuci�n
//	 * @param register identificador del registro.
//	 * @param state estado actual.
//	 * @param newState nuevo estado.
//	 * @throws ISPACException
//	 */
//	public void changeState(int register, int state)
//			throws ISPACException;

	/**
	 * Obtiene los anexos del registro de entrada.
	 * @param intrayId Identificador del registro distribuido.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Annexe[] getAnnexes(String intrayId) throws ISPACException;

	/**
	 * Descarga un anexo del registro de entrada.
	 * @param intrayId Identificador del registro distribuido.
	 * @param annexe identificador del anexo.
	 * @param out stream de salida.
	 * @throws ISPACException
	 */
	public void getAnnexe(String intrayId, String annexe, OutputStream out)
			throws ISPACException;

	
	/**
	 * Obtiene los anexos de un registro .
	 * @param registerNumber N�mero de registro 
	 * @param registerType Tipo de Registro
	 * @return Conjunto de anexos relacionados con el registro
	 * @throws ISPACException
	 */
	public Annexe[] getAnnexes(String registerNumber, String registerType) throws ISPACException;
	
	/**
	 * Descarga un anexo de un registro
	 * @param annexe Anexo
	 * @param out Contenido del anexo
	 */
	public void getAnnexe(Annexe annexe, OutputStream out) throws ISPACException;
	
	
	
	/**
	 * Vincula un expediente administrativo a un apunte de registro 
	 * @param register Informaci�n del registro
	 * @param numExpedient N� de expediente administrativo
	 * @throws ISPACException
	 */
	public void linkExpedient(RegisterInfo registerInfo, String numExpedient)
			throws ISPACException;

	
	/**
	 * Desvincula un expediente administrativo de un apunte de registro
	 * @param register Informaci�n del registro
	 * @param numExpedient N� de expediente administrativo
	 * @throws ISPACException
	 */	
	public void unlinkExpedient(RegisterInfo registerInfo, String numExpedient)
			throws ISPACException;

	/**
	 * Obtiene los libros de registro por tipo de libro.
	 * @param bookType Tipo de libro (@see IRegisterAPI).
	 * @return Libros de registro.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public List getBooks(int bookType) throws ISPACException;

	/**
	 * Obtiene las oficinas de registro dependientes de un libro.
	 * @param bookId Identificador del libro.
	 * @return Oficinas de registro
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public List getOffices(String bookId) throws ISPACException;

	/**
	 * Obtiene la informaci�n de una organizaci�n a partir de su c�digo.
	 * @param code C�digo de la organizaci�n.
	 * @return Informaci�n de la organizaci�n.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public Organization getOrganizationByCode(String code) throws ISPACException;	
}