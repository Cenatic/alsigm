package ieci.tecdoc.sgm.publicador.ws.client;

import ieci.tecdoc.sgm.publicador.ws.client.dto.Booleano;
import ieci.tecdoc.sgm.publicador.ws.client.dto.Error;
import ieci.tecdoc.sgm.publicador.ws.client.dto.Hito;
import ieci.tecdoc.sgm.publicador.ws.client.dto.ListaErrores;
import ieci.tecdoc.sgm.publicador.ws.client.dto.ListaHitos;
import ieci.tecdoc.sgm.publicador.ws.client.dto.ListaReglas;
import ieci.tecdoc.sgm.publicador.ws.client.dto.Regla;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PublicadorWebService extends Remote {

	/**
	 * Obtiene la lista de hitos de la entidad que recibe como par�metro
	 * @param idEntidad: Identificador de la entidad
	 * @return Lista de todos los hitos
	 * @throws RemoteException
	 */
    public ListaHitos getListaHitos(String idEntidad) throws RemoteException;
    
	/**
	 * Obtiene el hito que se correponde con el idHito que recibe como par�metro en 
	 * la entidad contra la que estamos trabajando (par�metro idEntidad)
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param idHito : Identificador del hito a obtener
	 * @param idAplicacion: Identificador de la aplicacion 
	 * @param idSystem : Identificador del sistema
	 * @return Un objeto Hito con la informaci�n del hito
	 * @throws RemoteException 
	 */
    public Hito getHito(String idEntidad, int idHito, int idAplicacion, String idSystem) throws RemoteException;
   
    /**
	 * A�ade el hito que recibe como par�metro sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param hito : Objeto de tipo Hito con la informaci�n a guardar en bbdd
	 * @return Un objeto Hito con la informaci�n del hito
	 * @throws RemoteException 
	 */
    public Hito addHito(String idEntidad, Hito hito) throws RemoteException;
    
    /**
	 * Actualiza el hito que recibe como par�metro sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param hito : Objeto de tipo Hito que se sobre-escribir� al existente
	 * @return Un objeto Hito con la informaci�n del hito
	 * @throws RemoteException 
	 */
    public Hito updateHito(String idEntidad, Hito hito) throws RemoteException;
   
    /**
	 * Borra el hito cuyo identificador se corresponde con el par�metro idHito, sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param idHito : Identificador del hito a borrar
	 * @param idAplicacion: Identificador de la aplicacion 
	 * @param idSystem : Identificador del sistema
	 * @return cierto si tuvo �xito , falso en caso contrario
	 * @throws RemoteException
	 */
    public Booleano deleteHito(String idEntidad, int idHito, int applicationId, String systemId) throws RemoteException;
   
    /**
	 * Reactiva el hito  err�neo eliminando su error
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param idHito : Identificador del hito a borrar
	 * @param idAplicacion: Identificador de la aplicacion 
	 * @param idSystem : Identificador del sistema
	 * @return Un objeto Hito con la informaci�n del hito
	 * @throws RemoteException
	 */
    public Hito reactivateHito(String idEntidad, int idHito, int applicationId, String systemId) throws RemoteException;
  
    /**
	 * Obtiene la lista de reglas de la entidad que recibe como par�metro
	 * @param idEntidad: Identificador de la entidad
	 * @return Lista de todas las reglas
	 * @throws RemoteException
	 */
    public ListaReglas getListaReglas(String idEntidad) throws RemoteException;
    
    /**
	 * Obtiene la informaci�n de la regla cuyo identificador se corresponde con idRegla sobre la entidad cuyo identificador sea idEntidad
	 * @param idEntidad : Identificador de la entidad contra la que estamos trabajando
	 * @param idRegla: Identificador de la regla
	 * @return Un objeto de tipo Regla con la informaci�n de la regla
	 * @throws RemoteException
	 */
      public Regla getRegla(String idEntidad, int idRegla) throws RemoteException;
   
    /**
	 * A�ade la regla que recibe como par�metro sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad : Identificador de la entidad contra la que estamos trabajando
	 * @param regla: Objeto de tipo Regla con la informaci�n a guardar en bbdd
	 * @return Un objeto de tipo Regla con la informaci�n de la regla
	 * @throws RemoteException 
	 */
    public Regla addRegla(String idEntidad, Regla regla) throws RemoteException;
   
    /**
	 * Actualiza la regla que recibe como par�metro sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad : Identificador de la entidad contra la que estamos trabajando
	 * @param regla: Objeto de tipo Regla con la informaci�n a guardar en bbdd
	 * @return Un objeto de tipo Regla con la informaci�n de la regla
	 * @throws RemoteException 
	 */
    public Regla updateRegla(String idEntidad, Regla regla) throws RemoteException;
   
    /**
	 * Borra la regla cuyo identificador se corresponde con el par�metro idRegla, sobre la entidad cuyo identificador sea 
	 * idEntidad
	 * @param idEntidad: Identificador de la entidad contra la que estamos trabajando
	 * @param idHito : Identificador del hito a borrar
	 * @return cierto si tuvo �xito , falso en caso contrario
	 * @throws RemoteException 
	 */
    public Booleano deleteRegla(String idEntidad, int idRegla) throws RemoteException;
    
    /**
	 * Obtiene la lista de errores de la entidad que recibe como par�metro
	 * @param idEntidad: Identificador de la entidad
	 * @return Lista de todos los errores 
	 * @throws RemoteException 
	 */
    public ListaErrores getListaErrores(String idEntidad) throws RemoteException;

    /**
	 * Obtiene la informaci�n del error cuyo identificador se corresponde con idError sobre la entidad cuyo identificador sea idEntidad
	 * @param idEntidad : Identificador de la entidad contra la que estamos trabajando
	 * @param idHito : Identificador del hito
	 * @param applicationId: Identificador de la aplicacion
	 * @param systemId : Identificador del sistema
	 * @return
	 * @throws RemoteException
	 */
    public Error getError(String idEntidad, int idHito, int applicationId, String systemId) throws RemoteException;

}
