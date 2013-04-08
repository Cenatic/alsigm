package ieci.tecdoc.sgm.pe;
/*
 * $Id: ConfiguracionOld.java,v 1.1.2.2 2008/03/14 11:22:22 jnogales Exp $
 */
import ieci.tecdoc.sgm.base.dbex.DbConnectionConfig;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.StringTokenizer;


public class ConfiguracionOld {
	
	/**
	 * Constantes
	 */
	private static final String MULTIPLE_KEYS_SEPARATOR =	",";
	private static final String PE_RESOURCES = 				"ieci.tecdoc.sgm.pe.resources.PagoElectronico";
	private static final String KEY_DATABASE = 				"database";
	private static final String KEY_USER = 					"user";
	private static final String KEY_PASS = 					"password";
	private static final String KEY_DRIVER = 				"driver";
	private static final String KEY_DEBUG = 				"debug";
	private static final String KEY_TIMEOUT = 				"timeout";
	private static final String KEY_PAGOS_PERMITIDOS =		"ieci.tec.doc.sgm.pe.PagoElectronicoManager.pagosPermitidos";
	private static final String KEY_SPE_IMPLEMENTACION =	"ieci.tec.doc.sgm.pe.SistemaPagoElectronicoFactory.implementacion";

	public static final String KEY_CUADERNO60_M1_IDENT1 =  "ieci.tec.doc.sgm.pe.PagoElectronicoManager.Cuaderno60.Modalidad1.ident1";
    
	private static HashMap config = new HashMap();
	
	private static HashMap pagosPermitidos = new HashMap(); 
	
	static{
		ResourceBundle application = ResourceBundle.getBundle(PE_RESOURCES);
		
		// Par�metros de configuraci�n de base de datos
		config.put(KEY_DATABASE, application.getString(KEY_DATABASE));
		config.put(KEY_USER, application.getString(KEY_USER));
		config.put(KEY_PASS, application.getString(KEY_PASS));
		config.put(KEY_DRIVER, application.getString(KEY_DRIVER));
		
		// Par�metros de configuraci�n generales
		String cPagosPermitidos = application.getString(KEY_PAGOS_PERMITIDOS);
		StringTokenizer stPagosPermitidos = new StringTokenizer(cPagosPermitidos, MULTIPLE_KEYS_SEPARATOR);
		String cToken = null;
		while(stPagosPermitidos.hasMoreTokens()){
			cToken = stPagosPermitidos.nextToken();
			pagosPermitidos.put(cToken, cToken);
		}
		
		config.put(KEY_SPE_IMPLEMENTACION, application.getString(KEY_SPE_IMPLEMENTACION));
		config.put(KEY_CUADERNO60_M1_IDENT1, application.getString(KEY_CUADERNO60_M1_IDENT1));
		
		
	}
	/**
	 * M�todo que devuelve la configuraci�n de la conexi�n a la base de datos.
	 * @return DbConnectionConfig
	 */
    public static DbConnectionConfig getDatabaseConnection(){
        return new DbConnectionConfig(
        		(String)config.get(KEY_DRIVER), 
        		(String)config.get(KEY_DATABASE), 
        		(String)config.get(KEY_USER), 
        		(String)config.get(KEY_PASS));
    }
    
    /**
     * M�todo que indica si la aplicaci�n tiene habilitado el debug.
     * @return boolean
     */
    public static boolean getIsDebugeable(){
        String sDebug = (String)config.get(KEY_DEBUG);
        if (sDebug!=null && sDebug.equals("true"))
          return true;
        else return false;
    }
    
    /**
     * M�todo que devuelve el timeout
     * @return int
     */
    public static int getTimeout(){
      String sTimeout = (String)config.get(KEY_TIMEOUT);
      return new Integer(sTimeout).intValue();
    }
    
    /**
     * M�todo que comprueba si un tipo de tasa est� soportada por el sistema de pago telem�tico
     * @param pcTipoTasa Nombre del tipo de tasa.
     * @return True si el tipo de tasa est� permitodo.
     */
    public static boolean pagoPermitido(String pcTipoTasa){
    	if((pcTipoTasa != null) && (!"".equals(pcTipoTasa))){
        	String cClave = (String)pagosPermitidos.get(pcTipoTasa);    
        	if((cClave != null)){
        		return true;
        	}
    	}
    	return false;
    }
    
    /**
     * M�todo que devuelve el valor de una propiedad de configuraci�n.
     * @param pcClave Nombre de la propiedad
     * @return String Valor de la propiedad.
     */
    public static String obtenerPropiedad(String pcClave){
    	String cRetorno = null;
    	if((pcClave != null) && (!"".equals(pcClave))){
        	cRetorno = (String)config.get(pcClave);
    	}    	
    	return cRetorno;
    }
}
