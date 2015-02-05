package ieci.tecdoc.sgm.registro.util;
import ieci.tecdoc.sgm.registro.exception.RegistroExcepcion;

public class RegistroWSManagerImpl implements RegistroWSManager
{
   public RegistroWSManagerImpl()
   {
   }
   
	/**
	 * Funci�n que comienza el proceso de registro y genera
	 * y devuelve el identificador global �nico de registro
	 * 
	 * @return Identificador �nico global.
	 * @throws Exception Si se produce alg�n error.
	 */
	public String newRegistry() throws RegistroExcepcion
	{
		String registryNumber = null;
		return registryNumber;
	}
	
	/**
	 * Funci�n que recoge y persiste los datos del asiento
	 * de registro
	 * 
	 * @param guid Identificador �nico que relaciona el nuevo registro que se est� creando
	 * @param procedureId Identificador de tr�mite
	 * @param addressee Destinatario
	 * @param folderId N�mero de expediente
	 * @param specificData Datos de la solicitud
	 * @throws Exception Cuando se produce alg�n error.
	 */
	public void setRegistryData(String guid, String procedureId, 
	 							String addressee, String folderId, String phone, 
								String specificData) throws Exception
								
	{
	}

   /**
    * 
    * @param guid Identificador del nuevo registro.
    * @param code C�digo del documento.
    * @return El identificador del documento. Se utiliza para a�adir los datos
    * del documento.
    * @throws ieci.tecdoc.sgm.registro.ejb.exception.RegistroTelematicoException Si se
    * produce alg�n error.
    */
   public String newDocument(String guid, String code) throws RegistroExcepcion
   {
      String documentGuid = "";
      
      return documentGuid;
   }
	
	/**
	 * A�ade un trozo de un nuevo documento asociado al registro abierto.
	 * 
	 * @param documentGuid Identificador �nico que relaciona el nuevo documento
    * que se est� a�adiendo.
	 * @param chunk Trozo de documento.
	 * @throws Exception Si se produce alg�n error
	 */
	public void addRegistryDocumentChunk(String documentGuid, String chunk) throws RegistroExcepcion
	{
	}
	
	/**
	 * Crea la solicitud de registro
	 * 
	 * @param guid Identificador �nico que relaciona el nuevo registro que se est� creando
	 * @return Documento xml con la solicitud de registro
	 * @throws Exception Si se produce alg�n error
	 */
	public String createRegistryRequest(String guid) throws RegistroExcepcion
	{
	  String registryRequest = null;
	  return registryRequest;
	}
	
	
	/**
��� * Recupera un justificante de registro.
��� * 
��� * @param registryNumber N�mero de registro.
��� * @return El justificante de registro.
��� * @throws java.lang.Exception Si se produce alg�n error.
��� */
	public String getRegistryReceipt(String registryNumber) throws RegistroExcepcion
	{
		String receipt = null;
	    return receipt;
	}
	
	/**
	 * Devuelve el n�mero de trozos en los que se 
	 * divide el documento que se pasa como par�metro
	 * 
	 * @param registryNumber N�mero de registro.
	 * @param code C�digo del documento
	 * @return Indice del trozo del documento pedido.
	 * @throws Exception
	 */
	public int getDocumentChunks(String registryNumber, String code) throws RegistroExcepcion
	{
		int number = 0;
		return number;
	}
	
	/**
	 * Recupera el trozo del contenido i-�simo del documento 
	 * del asiento de registro que se pasa como par�metro.
	 * 
	 * @param registryNumber N�mero de registro
	 * @param code C�digo del documento
	 * @param index �ndice del trozo del documento pedido.
	 * @return El trozo del documento codificado en base64.
	 * @throws Exception
	 */
	public String getDocumentContentChunk(String registryNumber, String code, int index) throws RegistroExcepcion
	{
		String chunk = null;
		return chunk;
	}
	
   
}