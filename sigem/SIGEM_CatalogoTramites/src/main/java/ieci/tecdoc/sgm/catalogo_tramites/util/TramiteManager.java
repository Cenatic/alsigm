package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.dbex.DynamicRow;
import ieci.tecdoc.sgm.catalogo_tramites.Configuracion;
import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesCodigosError;
import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesExcepcion;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.DocumentoDatos;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.DocumentoTramiteDatos;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.TramiteDatos;

import org.apache.log4j.Logger;

/**
 * Gestor de implementa la funcionalidad para los tr�mites (alamacenaje, recuperaci�n,
 * almacenaje, actualizaci�n de tr�mites)
 *
 */
public class TramiteManager {
	
   private static final Logger logger = Logger.getLogger(TramiteManager.class);
   
   protected static boolean isDebugeable = true;
  
   /**
    * Constructor de la clase TramiteManager
    *
    */
   protected TramiteManager(){
     isDebugeable = Configuracion.getIsDebugeable();
   }
   
   
   /**
    * A�ade un nuevo tr�mite al cat�logo.
    * @param procedure Informaci�n del tr�mite.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static void add(Tramite procedure, String entidad) 
     throws CatalogoTramitesExcepcion {
      TramiteDatos data = new TramiteDatos(procedure);

      try{
    	  data.insert(entidad);
      }catch (CatalogoTramitesExcepcion exc){
    	  logger.error("Error al a�adir un tramite al catalogo [add][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_PROCEDURE);
      }catch (Exception exc){
    	  logger.error("Error al a�adir un tramite al catalogo [add][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_PROCEDURE);
      }
   }

   
   /**
    * Recupera la informaci�n de un tr�mite del cat�logo de tr�mites. 
    * @param procedureId Identificador del tr�mite.
    * @param loadDocuments Si hay que cargar la informaci�n de los documentos.
    * @return La informaci�n del tr�mite.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static Tramite get(String procedureId, boolean loadDocuments, String entidad) 
     throws CatalogoTramitesExcepcion{
      TramiteDatos procedure = new TramiteDatos();

      try{
         procedure.load(procedureId, entidad);
         if (loadDocuments)
            procedure.setDocuments(DocumentoDatos.getDocuments(procedureId, entidad));
      }catch (CatalogoTramitesExcepcion exc){
    	  logger.error("Error al recuperar un tramite del catalogo [get][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
          throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      }catch (Exception exc){
    	  logger.error("Error al recuperar un tramite del catalogo [get][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      }
      
      return procedure;
   }


   /**
    * Recupera un conjunto de tr�mites del cat�logo de tr�mites a partir de 
    * unos valores de b�squeda. 
    * @param query Informaci�n con los valores de b�squeda.
    * @return La lista de tr�mites que cumplen los criterios de b�squeda.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static Tramites query(TramiteConsulta query, String entidad)
     throws CatalogoTramitesExcepcion {
      
      TramiteDatos tramiteData = new TramiteDatos();
      Tramites procedures = new Tramites();
      
      try {
         
         DynamicRow rowInfo = tramiteData.query(query, entidad);
         for (int i = 1; i < rowInfo.getRowCount() ; i++) {
        	TramiteImpl tramite = new TramiteImpl();
        	tramiteData = (TramiteDatos)rowInfo.getRow(i);
        	tramite.setId(tramiteData.getId());
        	tramite.setTopic(tramiteData.getTopic());
        	tramite.setDescription(tramiteData.getDescription());
        	tramite.setAddressee(tramiteData.getAddressee());
        	tramite.setLimitDocs(tramiteData.getLimitDocs());
        	tramite.setFirma(tramiteData.getFirma());
        	tramite.setDocuments(tramiteData.getDocuments());
        	tramite.setIdProcedimiento(tramiteData.getIdProcedimiento());
            
        	procedures.add(tramite);
         }      
         //Log.setQuery(sessionId, query);
      } catch (Exception e) {
    	  logger.error("Error al obtener resultados de busqueda [query][Excepcion]", e.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_NO_PROCEDURE);
      }

      return procedures;
   }

   
   /**
    * Elimina un tr�mite del cat�logo de tr�mites. 
    * @param procedureId Identificador del tr�mite.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static void delete(String procedureId, String entidad) 
     throws CatalogoTramitesExcepcion {
      TramiteDatos procedure = new TramiteDatos();
      DocumentoTramite procedureDocument = new DocumentoTramiteImpl();

      try {
    	  procedureDocument.setProcedureId(procedureId);
    	  deleteDocument(procedureDocument, entidad);
    	  procedure.setId(procedureId);
    	  procedure.delete(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al eliminar un tramite del catalogo [delete][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_PROCEDURE);
      } catch (Exception exc) {
    	  logger.error("Error al eliminar un tramite del catalogo [delete][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_PROCEDURE);
      }
   }
   
   
   /**
    * Actualiza el obejto tr�mite que se pasa como par�mtro. 
    * @param procedure Tr�mite con los nuevos datos.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error. 
    */
   public static void update(Tramite procedure, String entidad) 
     throws CatalogoTramitesExcepcion {
      TramiteDatos data = new TramiteDatos(procedure);

      try {
    	  data.update(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al actualizar un tramite del catalogo [update][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDURE);
      } catch (Exception exc) {
    	  logger.error("Error al actualizar un tramite del catalogo [update][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDURE);
      }
   }
   
   
   /**
    * Actualiza el obejto tr�mite-documento que se pasa como par�mtro. 
    * @param procedureDocument Tr�mite-Documento con los nuevos datos.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error. 
    */
   public static void update(DocumentoTramite procedureDocument, String entidad) 
     throws CatalogoTramitesExcepcion {
      DocumentoTramiteDatos data = new DocumentoTramiteDatos(procedureDocument);

      try {
    	  data.update(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al actualizar un documento de tramite del catalogo [update][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDUREDOCUMENT);
      } catch (Exception exc) {
    	  logger.error("Error al actualizar un documento de tramite del catalogo [update][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDUREDOCUMENT);
      }
   }

   
   /**
    * Indica si un documento est� siendo referenciado por alg�n tr�mite
    * definido en el cat�logo de tr�mites. 
    * @param documentId Identificador del documento.
    * @return Si el documento est� referenciado.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static boolean isDocumentReferenced(String documentId, String entidad) 
     throws CatalogoTramitesExcepcion {
      boolean isReferenced = false;
      DocumentoTramiteDatos procedure = new DocumentoTramiteDatos();

      try {
         procedure.setDocumentId(documentId);
         isReferenced = procedure.isDocumentReferenced(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al comprobar referencia de documento en tramites [isDocumentReference][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      } catch (Exception exc) {
    	  logger.error("Error al comprobar referencia de documento en tramites [isDocumentReference][Excepcion]", exc.fillInStackTrace());
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      }
      
      return isReferenced;
   }


   /**
    * Recupera una colecci�n con los procedimientos almacenados en el sistema.
    * @return Procedures Colecci�n de procedimientos.
    * @throws CatalogoTramitesExcepcion En caso de producirse alg�n error.
    */   
   public static Tramites getProcedures(String entidad) 
     throws CatalogoTramitesExcepcion {
      Tramites procedures = null;

      try {
    	  procedures = TramiteDatos.getProcedures(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al obtener tramites [getProcedures][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURES);
      } catch (Exception exc) {
    	  logger.error("Error al obtener tramites [getProcedures][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURES);
      }
      
      return procedures;
   }
   
   
   /**
    * Devuelve una colecci�n con los documentos asociados a un determinado procedimientos.
    * @param procedureId Identificador del procedimiento del que se quieren recuperar los documentos.
    * @return Documents Colecci�n de documentos.
    * @throws CatalogoTramitesExcepcion En caso de producirse alg�n error.
    */   
   public static Documentos getDocuments(String procedureId, String entidad) 
     throws CatalogoTramitesExcepcion {
      Documentos documents = null;

      try {
    	  documents = DocumentoDatos.getDocuments(procedureId, entidad);
      }catch (CatalogoTramitesExcepcion exc){
    	  logger.error("Error al obtener tipos de documentos [getDocuments][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      }catch (Exception exc){
    	  logger.error("Error al obtener tipos de documentos [getDocuments][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDURE);
      }
      
      return documents;
   }

   
   /**
    * Asocia un documento a un tr�mite. 
    * @param procedureDocument Relaci�n de asociaci�n entre el documento y el tr�mite
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static void addDocument(DocumentoTramite procedureDocument, String entidad) 
     throws CatalogoTramitesExcepcion {

      DocumentoTramiteDatos data = new DocumentoTramiteDatos(procedureDocument);

      try{
    	  data.insert(entidad);
      }catch (CatalogoTramitesExcepcion exc){
    	  logger.error("Error al a�adir tipo de documento [addDocument][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      }catch (Exception exc){
    	  logger.error("Error al a�adir tipo de documento [addDocument][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      }
   }

   
   /**
    * Recupera la informaci�n de un documento asociado a un tr�mite. 
    * @param procedureId Identificador del tr�mite.
    * @param documentID Identificador del documento.
    * @return El documento asociado al tr�mite.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static DocumentoTramite getDocument(String procedureId, String documentId, String entidad) 
     throws CatalogoTramitesExcepcion {

      DocumentoTramiteDatos data = new DocumentoTramiteDatos();

      try {
    	  data.load(procedureId, documentId, null, entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al obtener tipo de documento [getDocument][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      } catch (Exception exc) {
    	  logger.error("Error al obtener tipo de documento [getDocument][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      }
      
      return data;
   }
   
   /**
    * Recupera la informaci�n de un documento asociado a un tr�mite. 
    * @param procedureId Identificador del tr�mite.
    * @param documentID Identificador del documento.
    * @return El documento asociado al tr�mite.
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static DocumentoTramite getDocument(String procedureId, String documentId, String code, String entidad) 
     throws CatalogoTramitesExcepcion {

      DocumentoTramiteDatos data = new DocumentoTramiteDatos();

      try {
    	  data.load(procedureId, documentId, code, entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al obtener tipo de documento [getDocument][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      } catch (Exception exc) {
    	  logger.error("Error al obtener tipo de documento [getDocument][Excepcion]", exc.fillInStackTrace());
    	  throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_DOCUMENT);
      }
      
      return data;
   }

   /**
    * Elimina una asociaci�n de documento a un tr�mite. 
    * @param procedureDocument Relaci�n de asociaci�n entre el documento y el tr�mite
    * @throws CatalogoTramitesExcepcion Si se produce alg�n error.
    */
   public static void deleteDocument(DocumentoTramite procedureDocument, String entidad) 
     throws CatalogoTramitesExcepcion {

      DocumentoTramiteDatos data = new DocumentoTramiteDatos(procedureDocument);

      try {
         data.delete(entidad);
      } catch (CatalogoTramitesExcepcion exc) {
    	  logger.error("Error al eliminar tipo de documento [deleteDocument][CatalogoTramitesExcepcion]", exc.fillInStackTrace());
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_DOCUMENT);
      } catch (Exception exc) {
    	  logger.error("Error al eliminar tipo de documento [deleteDocument][Excepcion]", exc.fillInStackTrace());
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_DOCUMENT);
      }
   }
}