package common.management.mconfig;

import es.archigest.framework.core.management.Manageable;

/**
 * Interfaz del MBean que se encarga de la gesti�n del fichero de configuraci�n.
 */
public interface ConfigurationJMXMBean extends Manageable {

	/**
	 * Recarga el contenido del fichero de configuraci�n.
	 */
	public void reload();
}
