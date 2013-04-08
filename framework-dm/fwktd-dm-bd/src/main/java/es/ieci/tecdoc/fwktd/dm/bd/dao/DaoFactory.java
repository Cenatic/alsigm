package es.ieci.tecdoc.fwktd.dm.bd.dao;

import es.ieci.tecdoc.fwktd.dm.business.config.ContentType;

/**
 * Interfaz para la factor�a para la creaci�n de DAOs.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface DaoFactory {


	/**
	 * Obtiene el DAO para la gesti�n de documentos.
	 *
	 * @param contentType
	 *            Informaci�n del tipo de contenido.
	 * @return DAO para la gesti�n de documentos.
	 */
	public DocumentoDao getDocumentoDao(ContentType contentType);

}
