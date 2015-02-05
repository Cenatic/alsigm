package es.ieci.tecdoc.fwktd.dm.business.service.impl;

import es.ieci.tecdoc.fwktd.dm.business.config.ContentType;
import es.ieci.tecdoc.fwktd.dm.business.service.GestionDocumentalService;


/**
 * Implementaci�n abstracta del servicio de gesti�n documental.
 * @author Iecisa
 * @version $Revision$
 *
 */
public abstract class DefaultGestionDocumentalServiceImpl implements GestionDocumentalService {

	/**
	 * Informaci�n del tipo documental.
	 */
	private ContentType contentType = null;


	/**
	 * Constructor.
	 */
	public DefaultGestionDocumentalServiceImpl() {
		super();
	}

	/**
	 * Constructor.
	 * @param contentType Informaci�n del tipo documental.
	 */
	public DefaultGestionDocumentalServiceImpl(ContentType contentType) {
		super();
		setContentType(contentType);
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

}
