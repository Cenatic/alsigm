package es.ieci.tecdoc.fwktd.dm.bd.manager;

import es.ieci.tecdoc.fwktd.dm.business.config.ContentType;

/**
 * Intefaz para la factor�a que obtiene el manager de gesti�n documental
 * en base de datos configurado para un tipo documental.
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface BaseDatosManagerFactory {

	/**
	 * Obtiene el gestor a partir de la configuraci�n del
	 * tipo de contenido.
	 * @param contentType Tipo de contenido.
	 * @return Gestor.
	 */
	public BaseDatosManager getBaseDatosManager(ContentType contentType);

}
