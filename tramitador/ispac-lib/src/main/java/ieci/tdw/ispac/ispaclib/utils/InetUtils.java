package ieci.tdw.ispac.ispaclib.utils;

import ieci.tdw.ispac.api.errors.ISPACException;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class InetUtils {

	/** 
	 * Logger de la clase. 
	 */
    protected static final Logger logger = Logger.getLogger(InetUtils.class);
    
    /** 
     * Informaci�n de la direcci�n de red de la m�quina. 
     */
    private static InetAddress addr;
    
    static{
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            if (logger.isDebugEnabled()) {
                logger.warn("Error al obtener la informaci�n de red", e);
            }
        }
    }
    
    /**
     * Obtiene la direcci�n IP del equipo.
     * @return Cadena que representa la direcci�n IP del equipo.
     * @throws ISPACException si ocurre alg�n error.
     */
    public static String getLocalHostAddress() throws ISPACException {
        if (addr == null) {
            throw new ISPACException("Error al obtener la direcci�n local");
        }
        return addr.getHostAddress();
    }
    
    /**
     * Obtiene el nombre del equipo
     * @return Cadena que representa el nombre del equipo.
     * @throws ISPACException si ocurre alg�n error.
     */
    public static String getLocalHostName() throws ISPACException {
        if (addr == null) {
            throw new ISPACException("Error al obtener el nombre del equipo");
        }
        return addr.getHostName();
    }

}
