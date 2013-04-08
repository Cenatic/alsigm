package ieci.tdw.applets.ispacdocapplet.config;

/**
 * Factor�a para obtener la configuraci�n.
 *
 */
public class ConfigFactory {

	/**
	 * Configuraci�n local.
	 */
	private static LocalConfig localConfig = null;
	
	/**
	 * Obtiene una instancia de la configuraci�n local.
	 * @return Configuraci�n local.
	 */
	public static synchronized LocalConfig getLocalConfig() {
	
		if (localConfig == null) {
			localConfig = new LocalConfig();
		}
		
		return localConfig;
	}
}
