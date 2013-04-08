package es.ieci.tecdoc.fwktd.dm.bd.manager;

import java.io.InputStream;
import java.io.OutputStream;

import es.ieci.tecdoc.fwktd.dm.business.config.ContentType;
import es.ieci.tecdoc.fwktd.dm.business.exception.GestionDocumentalException;
import es.ieci.tecdoc.fwktd.dm.business.vo.InfoDocumentoVO;

/**
 * Interfaz del manager de gesti�n documental que
 * almacena los documentos en base de datos.
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface BaseDatosManager {

	/**
	 * Establece la informaci�n del tipo de contenido.
	 * @param contentType Informaci�n del tipo de contenido.
	 */
	public void setContentType(ContentType contentType);

	/**
	 * Comprueba si existe un documento.
	 *
	 * @param idDocumento
	 *            Identificador del documento.
	 * @return true si existe el documento, false en caso contrario.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public boolean existeDocumento(String idDocumento)
			throws GestionDocumentalException;

	/**
	 * Obtiene la informaci�n de un documento.
	 *
	 * @param idDocumento
	 *            Identificador del documento.
	 * @return Informaci�n del documento.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public InfoDocumentoVO getInfoDocumento(String idDocumento)
			throws GestionDocumentalException;

	/**
	 * Obtiene el contenido de un documento.
	 *
	 * @param idDocumento
	 *            Identificador del documento.
	 * @param out
	 *            Stream donde se guardar� el contenido del documento.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public void retrieveDocumento(String idDocumento, OutputStream out)
			throws GestionDocumentalException;

	/**
	 * Crea un documento en el gestor documental.
	 *
	 * @param documento
	 *            Informaci�n del documento.
	 * @param in
	 *            Contenido del documento.
	 * @return Informaci�n del documento creado.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public InfoDocumentoVO createDocumento(InfoDocumentoVO documento, InputStream in)
			throws GestionDocumentalException;

	/**
	 * Modifica la informaci�n y contenido de un documento.
	 *
	 * @param documento
	 *            Informaci�n del documento.
	 * @param in
	 *            Contenido del documento.
	 * @return Informaci�n del documento actualizada.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public InfoDocumentoVO updateDocumento(InfoDocumentoVO documento, InputStream in)
			throws GestionDocumentalException;

	/**
	 * Elimina un documento en el gestor documental.
	 *
	 * @param idDocumento
	 *            Identificador del documento.
	 * @throws GestionDocumentalException
	 *             si ocurre alg�n error.
	 */
	public void deleteDocumento(String idDocumento)
			throws GestionDocumentalException;

//	/**
//	 * Realiza una b�squeda de documentos en base a unos criterios.
//	 *
//	 * @param criteriosBusqueda
//	 *            Criterios de b�squeda de documentos.
//	 * @return Lista de documentos ({@link InfoDocumentoVO} ).
//	 * @throws GestionDocumentalException
//	 *             si ocurre alg�n error.
//	 */
//	public List<InfoDocumentoVO> findDocumentos(CriteriosBusquedaVO criteriosBusqueda)
//			throws GestionDocumentalException;

}
