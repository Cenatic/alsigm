package ieci.tdw.ispac.ispaclib.thirdparty;

import ieci.tdw.ispac.api.IThirdPartyAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.util.ISPACConfiguration;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Factor�a para la creaci�n del API de TERCEROS.
 *
 */
public class ThirdPartyConnectorFactory {

	/** 
	 * Logger de la clase. 
	 */
	private static final Logger logger = 
		Logger.getLogger(ThirdPartyConnectorFactory.class);

	/** 
     * Instancia de la clase. 
     */
    private static ThirdPartyConnectorFactory mInstance = null;

    /** 
     * Nombre de la clase que implementa el conector de TERCEROS. 
     */
    private static String className = null;

    
	/**
	 * Constructor.
	 * 
	 * @throws ISPACException si ocurre alg�n error.
	 */
    private ThirdPartyConnectorFactory() throws ISPACException {
		className = ISPACConfiguration.getInstance().get(ISPACConfiguration.THIRDPARTY_API_CLASS);
   	}

	/**
	 * Obtiene una instancia de la factor�a.
	 * 
	 * @return Intancia de la factor�a.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public static synchronized ThirdPartyConnectorFactory getInstance()	throws ISPACException {
		
		if (mInstance == null) {
			mInstance = new ThirdPartyConnectorFactory();
		}
		return mInstance;
	}

	/**
	 * Obtiene el API de TERCEROS.
	 * @return API de TERCEROS.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAPI getThirdPartyAPI() throws ISPACException {
		
		IThirdPartyAPI thirdPartyAPI = null;
		
		// Comprobar que se haya establecido el nombre de la clase 
		if (StringUtils.isBlank(className)) {
			return thirdPartyAPI;
		}

		try {
			// Cargar la clase
			Class clazz = Class.forName(className);
			if (!IThirdPartyAPI.class.isAssignableFrom(clazz)) {
				throw new ISPACException(className + " no extiende la clase IThirdPartyAPI");
			}
			
			// Instanciar la clase
			thirdPartyAPI = (IThirdPartyAPI) clazz.newInstance();

			if (logger.isDebugEnabled()) {
				logger.debug("IThirdPartyAPI creado [" + className + "]");
			}		
		} 
		catch (Exception e) {
			throw new ISPACException(e);
		}

		return thirdPartyAPI;
	}	
}