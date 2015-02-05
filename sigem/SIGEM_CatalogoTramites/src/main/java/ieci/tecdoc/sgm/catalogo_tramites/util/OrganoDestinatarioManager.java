package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesCodigosError;
import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesExcepcion;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.OrganoDestinatarioDatos;

import org.apache.log4j.Logger;

/**
 * Gestor que implementa la funcionalidad para los �rganos destinatarios 
 * (recuperaci�n, almacenaje, eliminaci�n y actualizaci�n de �rganos destinatarios)
 *
 */
public class OrganoDestinatarioManager {
  
	private static final Logger logger = Logger.getLogger(OrganoDestinatarioManager.class);
	
  private static final boolean isDebugeable = true;
 
  protected OrganoDestinatarioManager() {
  }

  /**
   * Recupera la informaci�n de un �rgano destinatario.
   * @param addresseeId Identificador del �rgano destinatario.
   * @return Addressee El �rgano destinatario.
   * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
   */
  public static OrganoDestinatario get(String addresseeId, String entidad) throws CatalogoTramitesExcepcion {
     OrganoDestinatarioDatos addressee = new OrganoDestinatarioDatos();

     try {
    	 addressee.load(addresseeId, entidad);
     } catch (CatalogoTramitesExcepcion exc) {
    	 logger.error("Error al obtener organo destinatario [get][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_ADDRESSEE);
     } catch (Exception exc) {
    	 logger.error("Error al obtener organo destinatario [get][Excepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_ADDRESSEE);
     }
     
     return addressee;
  }


  /**
   * A�ade un nuevo �rgano destinatario al cat�logo. 
   * @param adressee Informaci�n del �rgano destinatario.
   * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
   */
  public static void add(OrganoDestinatario addressee, String entidad) throws CatalogoTramitesExcepcion {
     OrganoDestinatarioDatos data = new OrganoDestinatarioDatos(addressee);

     try {
    	 data.insert(entidad);
     } catch (CatalogoTramitesExcepcion exc) {
    	 logger.error("Error al a�adir organo destinatario [add][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_ADDRESSEE);
     } catch (Exception exc) {
    	 logger.error("Error al a�adir organo destinatario [add][Excepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_ADDRESSEE);
     }
  }

  
  /**
   * Elimina un �rgano destinatario.
   * @param addresseeId Identificador del �rgano destinatario.
   * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
   */
  public static void delete(String addresseeId, String entidad) throws CatalogoTramitesExcepcion {
     OrganoDestinatarioDatos addressee = new OrganoDestinatarioDatos();

     try{
    	 //TODO Comprobar si el documento esta refenciado
        /*if (ProcedureManager.isDocumentReferenced(addresseeId)) {
          throw new ProcedureCatalogException(ProcedureCatalogErrorCodes.EC_ADDRESSEE_USED);
        }*/
        addressee.setId(addresseeId);
        addressee.delete(entidad);
     } catch (CatalogoTramitesExcepcion exc) {
    	 logger.error("Error al eliminar organo destinatario [delete][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_ADDRESSEE);
     } catch (Exception exc) {
    	 logger.error("Error al eliminar organo destinatario [delete][Excepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_ADDRESSEE);
     }
  }

  
  /**
   * Actualiza el �rgano destinatario que se pasa como par�metro. 
   * @param addressee Organo destinatario con los nuevos datos.
   * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
   */
  public static void update(OrganoDestinatario addressee, String entidad) throws CatalogoTramitesExcepcion {
     OrganoDestinatarioDatos data = new OrganoDestinatarioDatos(addressee);

     try {
    	 data.update(entidad);
     } catch (CatalogoTramitesExcepcion exc) {
    	 logger.error("Error al actualizar organo destinatario [delete][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_ADDRESSEE);
     } catch (Exception exc) {
    	 logger.error("Error al actualizar organo destinatario [delete][Excepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_ADDRESSEE);
     }
  }

  
  /**
   * Recupera la lista de �rganos destinatarios. 
   * @return La lista mencionada.
   * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
   */
  public static OrganosDestinatarios getAddressees(String entidad) throws CatalogoTramitesExcepcion {
    OrganosDestinatarios addressees = null;

     try {
    	 addressees = OrganoDestinatarioDatos.getAddressees(entidad);
     } catch (CatalogoTramitesExcepcion exc) {
    	 logger.error("Error al obtener organos destinatarios [getAddressees][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_ADDRESSEES);
     } catch (Exception exc) {
    	 logger.error("Error al obtener organos destinatarios [getAddressees][Excepcion]", exc.fillInStackTrace());
    	 throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_ADDRESSEES);
     }
     
     return addressees;
  }
}
