package ieci.tecdoc.sgm.catalogo_tramites.util.database;

import ieci.tecdoc.sgm.base.dbex.DbConnection;
import ieci.tecdoc.sgm.base.dbex.DbDeleteFns;
import ieci.tecdoc.sgm.base.dbex.DbInputStatement;
import ieci.tecdoc.sgm.base.dbex.DbOutputStatement;
import ieci.tecdoc.sgm.base.dbex.DbSelectFns;
import ieci.tecdoc.sgm.base.dbex.DynamicFns;
import ieci.tecdoc.sgm.base.dbex.DynamicRow;
import ieci.tecdoc.sgm.base.dbex.DynamicRows;
import ieci.tecdoc.sgm.base.dbex.DynamicTable;
import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesCodigosError;
import ieci.tecdoc.sgm.catalogo_tramites.exception.CatalogoTramitesExcepcion;
import ieci.tecdoc.sgm.catalogo_tramites.util.DocumentoTramite;
import ieci.tecdoc.sgm.catalogo_tramites.util.DocumentoTramiteImpl;
//import ieci.tecdoc.sgm.catalogo_tramites.Configuracion;
import java.io.Serializable;
import org.apache.log4j.Logger;

/**
 * Modela una fila de la tabla de documentos asociados a un tr�mite.
 * @see DocumentoTramiteTable
 * @see DocumentoTramite
 * @see DocumentoTramiteImpl
 * @see DocumentosTramites
 */
public class DocumentoTramiteDatos extends DocumentoTramiteImpl implements Serializable {
   private static final Logger logger = Logger.getLogger(DocumentoTramiteDatos.class);
   private static final boolean isDebugeable = true;
  
   public DocumentoTramiteDatos() {
   }
   
   /**
    * Constructor de la clase ProcedureDocumentData
    * @param procedureDocum Objeto que contiene los datos del procedieminto-documetno
    */
   public DocumentoTramiteDatos(DocumentoTramite procedureDocum) {
      this.setProcedureId(procedureDocum.getProcedureId());
      this.setDocumentId(procedureDocum.getDocumentId());
      this.setCode(procedureDocum.getCode());
      this.setMandatory(procedureDocum.isMandatory());
   }
   
   
   /**
    * Recupera todos los valores de los par�metros de la sentencia de consulta
    * que se pasa como par�metro.
    * @param statement Sentencia sql precompilada.
    * @param idx Indice de posici�n del primer par�metro que se recoge de la
    *  consulta.
    * @return Indice de posici�n del �ltimo par�metro recogido
    * @throws Exception Si se produce alg�n error.
    */
   public Integer loadAllValues(DbOutputStatement statement, Integer idx)
   throws Exception {
      int index = idx.intValue();

      procedureId = statement.getShortText(index++);
      documentId = statement.getShortText(index++);
      code = statement.getShortText(index++);
      if (statement.getShortText(index++).equals("1")) {
         mandatory = true;
      } else {
         mandatory = false;
      }
      
      return new Integer(index);
   }
   
   
   /**
    * Recupera todos los valores de los par�metros de la sentencia de consulta
    * que se pasa como par�metro.
    * @param statement Sentencia sql precompilada.
    * @param idx Indice de posici�n del primer par�metro que se recoge de la
    *  consulta.
    * @return Indice de posici�n del �ltimo par�metro recogido
    * @throws Exception Si se produce alg�n error.
    */
   public Integer loadMandatoryAndCodeValues(DbOutputStatement statement, Integer idx)
   throws Exception {
      int index = idx.intValue();

      code = statement.getShortText(index++);
      if (statement.getShortText(index++).equals("1")) {
         mandatory = true;
      } else {
         mandatory = false;
      }
      
      return new Integer(index);
   }
   
   
   /**
    * Genera la sentencia de inserci�n de un registro.
    * @param statement Sentencia sql precompilada.
    * @param idx Indice de posici�n del primer par�metro en la sentencia.
    * @return Indice de posici�n del �ltimo par�metro en la sentencia.
    * @throws Exception Si se produce alg�n error.
    */
   public Integer insert(DbInputStatement statement, Integer idx)
   throws Exception {
      int index = idx.intValue();

      statement.setShortText(index++, procedureId);
      statement.setShortText(index++, documentId);
      statement.setShortText(index++, code);
      if (mandatory) {
         statement.setShortText(index++, "1");
      } else {
         statement.setShortText(index++, "0");
      }
      return new Integer(index);
   }
   
   
   /**
    * Genera la sentencia de actualizaci�n de un registro.
    * @param statement Sentencia sql precompilada.
    * @param idx Indice de posici�n del primer par�metro en la sentencia.
    * @return Indice de posici�n del �ltimo par�metro en la sentencia.
    * @throws Exception Si se produce alg�n error.
    */
   public Integer update(DbInputStatement statement, Integer idx)
   throws Exception {
      int index = idx.intValue();

      statement.setShortText(index++, procedureId);
      statement.setShortText(index++, documentId);
      statement.setShortText(index++, code);
      if (mandatory) {
         statement.setShortText(index++, "1");
      } else {
         statement.setShortText(index++, "0");
      }
      return new Integer(index);
   }
   
   
   /**
    * Recupera un registro con el identificador de tr�mite que se pasa como
    * par�metro.
    * @param procId Identificador de tr�mite.
    * @throws Exception Si se produce alg�n error.
    */
   public void load(String procId, String docId, String code, String entidad) throws Exception {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      boolean load = true;
      
      logger.debug("Load Procedure Document <-- Procedure ID: " + procId + " Document ID: " + docId);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         tableInfo.setTableObject(table);
         tableInfo.setClassName(DocumentoTramiteTabla.class.getName());
         tableInfo.setTablesMethod("getTableName");
         tableInfo.setColumnsMethod("getAllColumnNames");
         
         rowInfo.addRow(this);
         rowInfo.setClassName(DocumentoTramiteDatos.class.getName());
         rowInfo.setValuesMethod("loadAllValues");
         rowsInfo.add(rowInfo);
         
         String qual = "";
         if (code == null || "".equals(code))
        	 qual = table.getByPKQual(procId, docId);
         else 
        	 qual = table.getByPKQual(procId, docId, code);
         
         if (!DynamicFns.select(dbConn, qual, tableInfo, rowsInfo)) {
            load = false;
         }
         
         logger.debug("Load Procedure Document --> Proedure Document: " + this.toString());
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_BAD_PROCEDUREID_OR_DOCUMENTID);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
    	  if (dbConn.existConnection())
	           dbConn.close();
         if(!load)
            throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_BAD_PROCEDUREID_OR_DOCUMENTID);
      }
   }
   
   
   /**
    * Inserta un registro.  
    * @throws Exception Si se produce alg�n error.
    */
   public void insert(String entidad) throws Exception {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      
      logger.debug("Insert Procedure Document <-- Procedure Document: " + this.toString());
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         tableInfo.setTableObject(table);
         tableInfo.setClassName(DocumentoTramiteTabla.class.getName());
         tableInfo.setTablesMethod("getTableName");
         tableInfo.setColumnsMethod("getAllColumnNames");
         
         rowInfo.addRow(this);
         rowInfo.setClassName(DocumentoTramiteDatos.class.getName());
         rowInfo.setValuesMethod("insert");
         rowsInfo.add(rowInfo);
         
         DynamicFns.insert(dbConn, tableInfo, rowsInfo);
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ADD_PROCEDUREDOCUMENT);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
         if (dbConn.existConnection())
	           dbConn.close();
      }
   }
   
   
   /**
    * Actualiza la obligatoriedad de el documento para un tr�mite que se pasan
    * como par�metros.
    * @throws Exception Si se produce alg�n error.
    */
   public void updateIsMadatory(String entidad) throws Exception {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      
      if(isDebugeable)
        logger.debug("Update Is Madatory <-- Procedure ID: " + procedureId + " Document ID: " + documentId);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         tableInfo.setTableObject(table);
         tableInfo.setClassName(DocumentoTramiteTabla.class.getName());
         tableInfo.setTablesMethod("getTableName");
         tableInfo.setColumnsMethod("getMandatoryDocumentColumnName");
         
         rowInfo.addRow(this);
         rowInfo.setClassName(DocumentoTramiteDatos.class.getName());
         rowInfo.setValuesMethod("update");
         rowsInfo.add(rowInfo);
         
         DynamicFns.update(dbConn, table.getByPKQual(procedureId, documentId), tableInfo, rowsInfo);
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDUREDOCUMENT);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
         if (dbConn.existConnection())
	           dbConn.close();
      }
   }
   
   
   /**
    * Elimina el registro de asociaci�n de un documento a un tr�mite.
    * @throws Exception Si se produce alg�n error.
    */
   public void delete(String entidad) throws Exception {
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      
      logger.debug("Delete Procedure Document <-- Procedure ID: " + procedureId + " Document ID: " + documentId);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         if(documentId!=null && !documentId.equals(""))
           DbDeleteFns.delete(dbConn, table.getTableName(), table.getByPKQual(procedureId, documentId));
         else DbDeleteFns.delete(dbConn, table.getTableName(), table.getByPKQual(procedureId));
         
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_PROCEDUREDOCUMENT);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
    	  if (dbConn.existConnection())
	           dbConn.close();
      }
   }
   
   
   /**
    * Actualiza el registro cuyo identificador de tr�mite-documento se pasa como
    * par�metro.
    * @throws Exception Si se produce alg�n error.
    */
   public void update(String entidad) throws Exception {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      
      logger.debug("Update Procedure Document <-- Procedure ID: " + procedureId + " Document ID: " + documentId);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         tableInfo.setTableObject(table);
         tableInfo.setClassName(DocumentoTramiteTabla.class.getName());
         tableInfo.setTablesMethod("getTableName");
         tableInfo.setColumnsMethod("getUpdateColumnNames");
         
         rowInfo.addRow(this);
         rowInfo.setClassName(DocumentoTramiteDatos.class.getName());
         rowInfo.setValuesMethod("updateAll");
         rowsInfo.add(rowInfo);
         
         DynamicFns.update(dbConn, table.getByPKQual(procedureId, documentId), tableInfo, rowsInfo);
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_UPDATE_PROCEDURE);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
         if (dbConn.existConnection())
	           dbConn.close();
      }
   }
   
   
   /**
    * Elimina el registro de asociaci�n de documentos a tr�mite.
    * @param id Identificador de tr�mite.
    * @throws Exception Si se produce alg�n error.
    */
   public static void delete(String id, String entidad) throws Exception {
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      
      logger.debug("Delete Procedure Documents <-- Procedure ID: " + id);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         DbDeleteFns.delete(dbConn, table.getTableName(), table.getByProcedureIdQual(id));
         
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_DELETE_PROCEDUREDOCUMENT);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
    	  if (dbConn.existConnection())
	           dbConn.close();
      }
   }
   
   
   /**
    * Consulta el cat�logo de tr�mites para averiguar si un documento est�
    * referenciado en un tr�mite.
    * @return boolean Si el documento est� referenciado.
    * @throws Exception Si se produce alg�n error.
    */
   public boolean isDocumentReferenced(String entidad) throws Exception {
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      boolean isReferenced = false;
      
      logger.debug("Is Document Referenced <-- Procedure ID: " + procedureId + " Document ID: " + documentId);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         isReferenced = DbSelectFns.rowExists(dbConn, table.getTableName(), table.getDocumentReferencedQual(documentId));
         
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_GET_PROCEDUREDOCUMENT);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
    	  if (dbConn.existConnection())
	           dbConn.close();
      }
      
      return isReferenced;
   }
   
   
   /**
    * Consulta el cat�logo y obtiene informaci�n a partir del c�digo de documento
    * @param code Codigo de documento
    * @throws Exception Si se produce alg�n error
    */
   public void getDocumentInfo(String code, String entidad) throws Exception {
      DynamicTable tableInfo = new DynamicTable();
      DynamicRows rowsInfo = new DynamicRows();
      DynamicRow rowInfo = new DynamicRow();
      DocumentoTramiteTabla table = new DocumentoTramiteTabla();
      DbConnection dbConn = new DbConnection();
      boolean load = true;
      
      logger.debug("Get Procedure Document Info <-- Document Code: " + code);
      
      try {
       	 //dbConn.open(Configuracion.getDatabaseConnection());
         dbConn.open(DBSessionManager.getSession(entidad));
         
         tableInfo.setTableObject(table);
         tableInfo.setClassName(DocumentoTramiteTabla.class.getName());
         tableInfo.setTablesMethod("getTableName");
         tableInfo.setColumnsMethod("getAllColumnNames");
         
         rowInfo.addRow(this);
         rowInfo.setClassName(DocumentoTramiteDatos.class.getName());
         rowInfo.setValuesMethod("loadAllValues");
         rowsInfo.add(rowInfo);
         
         if (!DynamicFns.select(dbConn, table.getByDocumentCodeQual(code), tableInfo, rowsInfo)) {
            load = false;
         }
         
         logger.debug("Get Procedure Document Info --> Procedure Document: " + this.toString());
      } catch (CatalogoTramitesExcepcion e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_BAD_PROCEDUREID_OR_DOCUMENTID);
      } catch (Exception e) {
         throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_ERR_DB);
      } finally {
    	  if (dbConn.existConnection())
	           dbConn.close();
         if (!load)
            throw new CatalogoTramitesExcepcion(CatalogoTramitesCodigosError.EC_BAD_PROCEDUREID_OR_DOCUMENTID);
      }
   }
   
   
   /**
    * Genera la sentencia de actualizaci�n de un registro.
    * @param statement Sentencia SQL precompilada.
    * @param idx Indice de posici�n del primer par�metro en la sentencia.
    * @return Indice de posici�n del �ltimo par�metro en la sentencia.
    * @throws Exception Si se produce alg�n error.
    */
   public Integer updateAll(DbInputStatement statement, Integer idx)
   throws Exception {
      int index = idx.intValue();

      statement.setShortText(index++, code);
      if (mandatory) {
        statement.setShortText(index++, "1");
     } else {
        statement.setShortText(index++, "0");
     }
      return new Integer(index);
      
   }
}