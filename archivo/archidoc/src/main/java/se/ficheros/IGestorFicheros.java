package se.ficheros;

import java.util.List;
import java.util.Properties;

import se.ficheros.exceptions.GestorFicherosException;
import docelectronicos.vos.DocDocumentoExtVO;

/**
 * Interface para el sistema gestor de ficheros
 */
public interface IGestorFicheros {

	/**
	 * Inicializa con los par�metros de configuraci�n.
	 * 
	 * @param params
	 *            Par�metros de configuraci�n.
	 * @throws GestorFicherosException
	 *             si ocurre alg�n error.
	 */
	public void initialize(Properties params);

	/**
	 * Permite obtener un fichero
	 * 
	 * @param id
	 *            Id del fichero
	 * @return array de bytes con el contenido
	 * @throws Exception
	 *             Si se produce alg�n error
	 */
	public byte[] retrieveFile(String id) throws Exception;

	/**
	 * Permite almacenar un fichero
	 * 
	 * @param idLista
	 *            Id de la lista en la que se quiere almacenar el fichero
	 * @param ext
	 *            Extensi�n del fichero
	 * @param contenido
	 *            Contenido del fichero
	 * @return Id del fichero
	 * @throws Exception
	 *             Si se produce alg�n error
	 */
	public String storeFile(DocDocumentoExtVO documentoExtVO) throws Exception;

	/**
	 * Permite eliminar un fichero
	 * 
	 * @param idFichero
	 *            Id del fichero
	 * @throws Exception
	 *             Si se produce alg�n error
	 */
	public void deleteFile(String idFichero) throws Exception;

	/**
	 * Obtiene la lista de identificadores de fichero en el sistema de
	 * almacenamiento que contienen la cadena pasada como par�metro y cuyo id
	 * est� en la lista de identificadores de documentos pasados como par�metro
	 * 
	 * @return Lista de Ids de fichero
	 * @throws Exception
	 */
	public List<String> findFileByContent(String searchString, List docsIds)
			throws Exception;
}
