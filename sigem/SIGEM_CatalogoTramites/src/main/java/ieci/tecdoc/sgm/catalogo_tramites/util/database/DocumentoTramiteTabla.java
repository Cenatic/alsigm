package ieci.tecdoc.sgm.catalogo_tramites.util.database;

import ieci.tecdoc.sgm.base.dbex.DbUtil;

/**
 * Mapea la tabla SGMRTCATALOGO_DOCUMENTOSTRAMITE.
 *
 * @see DocumentoTramiteDatos
 */
public class DocumentoTramiteTabla {
   protected static final String TN = "SGMRTCATALOGO_DOCSTRAMITE";
   protected static final String CN_PROCEDURE_ID = "TRAMITE_ID";
   protected static final String CN_DOCUMENT_ID = "DOCUMENTO_ID";
   protected static final String CN_DOCUMENT_CODE = "CODIGO_DOCUMENTO";
   protected static final String CN_MANDATORY_DOCUMENT = "DOCUMENTO_OBLIGATORIO";

   public DocumentoTramiteTabla() {
   }

   /**
    * Devuelve el nombre completo de la tabla mapeada sin cualificar.
    *
    * @return Cadena de caracteres con el nombre completo de la tabla.
    */
   public String getTableName() {
      return TN;
   }

   /**
    * Devuelve el nombre completo de la columna idntificador de tr�mite.
    *
    * @return El nombre de dicha columna.
    */
   public String getProcedureIdColumnName() {
      return CN_PROCEDURE_ID;
   }

   /**
    * Devuelve el nombre completo de la columna identificador de documento.
    *
    * @return El nombre de dicha columna.
    */
   public String getDocumentIdColumnName() {
      return CN_DOCUMENT_ID;
   }

   /**
    * Devuelve el nombre completo de la columna c�digo de documento.
    *
    * @return El nombre de dicha columna.
    */
   public String getCodeColumnName() {
      return CN_DOCUMENT_CODE;
   }


   /**
    * Devuelve el nombre completo de la columna documento obligatorio para
    * tr�mite.
    *
    * @return El nombre de dicha columna.
    */
   public String getMandatoryDocumentColumnName() {
      return CN_MANDATORY_DOCUMENT;
   }


   /**
    * Devuelve los nombres completos de todas las columnas mapeadas de la tabla,
    * separados por comas.
    *
    * @return Los nombres de las columnas.
    */
   public String getAllColumnNames() {
      String val = CN_PROCEDURE_ID + ", " + CN_DOCUMENT_ID + ", "
               + CN_DOCUMENT_CODE + ", " + CN_MANDATORY_DOCUMENT;
      return val;
   }

   /**
    * Devuelve los nombres completos de todas las columnas actualizables de la tabla,
    * separados por comas.
    *
    * @return Los nombres de las columnas.
    */
   public String getUpdateColumnNames() {
      String val = CN_DOCUMENT_CODE + ", " + CN_MANDATORY_DOCUMENT;
      return val;
   }

   /**
    * Devuelve la cl�usula de consulta con el valor del identificador de tr�mite
    * que se pasa como par�metro.
    *
    * @param procedureId
    *           Identificador de tr�mite.
    * @return La cl�usula.
    */
   public String getByProcedureIdQual(String procedureId) {
      String val = " WHERE " + CN_PROCEDURE_ID + " = '" + DbUtil.replaceQuotes(procedureId) + "'";
      return val;
   }

   /**
    * Devuelve la cl�usula de consulta con los valores de clave primaria que se
    * pasan como par�metros.
    *
    * @param procedureId
    *           Identificador de tr�mite.
    * @param documentId
    *           Identificador de documento.
    * @return La cl�usula.
    */
   public String getByPKQual(String procedureId, String documentId) {
      String val = " WHERE " + CN_PROCEDURE_ID + " = '" + DbUtil.replaceQuotes(procedureId)
               + "' AND " + CN_DOCUMENT_ID + " = '" + DbUtil.replaceQuotes(documentId) + "'";
      return val;
   }

   /**
    * Devuelve la cl�usula de consulta con los valores de clave primaria que se
    * pasan como par�metros.
    *
    * @param procedureId
    *           Identificador de tr�mite.
    * @param documentId
    *           Identificador de documento.
    * @return La cl�usula.
    */
   public String getByPKQual(String procedureId, String documentId, String code) {
      String val = " WHERE " + CN_PROCEDURE_ID + " = '" + DbUtil.replaceQuotes(procedureId)
               + "' AND " + CN_DOCUMENT_ID + " = '" + DbUtil.replaceQuotes(documentId)
               + "' AND " + CN_DOCUMENT_CODE + " = '" + DbUtil.replaceQuotes(code) + "'";
      return val;
   }

   /**
    * Devuelve la cl�usula de consulta con los valores de clave primaria que se
    * pasan como par�metros.
    *
    * @param procedureId
    *           Identificador de tr�mite.
    * @return La cl�usula.
    */
   public String getByPKQual(String procedureId) {
      String val = " WHERE " + CN_PROCEDURE_ID + " = '" + DbUtil.replaceQuotes(procedureId) + "'";
      return val;
   }

   /**
    * Construye una expresi�n de b�squeda para averiguar si un documento est�
    * siendo referenciado por alg�n tr�mite dado de alta en el cat�logo de
    * tr�mites.
    *
    * @param documentId Identificador del documento
    * @return La expresi�n de b�squeda mencionada.
    */
   public String getDocumentReferencedQual(String documentId)
   {
      String qual;

      qual = "WHERE " + CN_DOCUMENT_ID + " = '" + DbUtil.replaceQuotes(documentId) + "'";

      return qual;
   }

   /**
    * Construye la cl�usula de b�squeda por el c�digo de documento que
    * es �nico para la relaci�n documento-tr�mite.
    *
    * @param code C�digo del documento
    * @return La expresi�n de b�squeda mencionada.
    */
   public String getByDocumentCodeQual(String code){
   	   return "WHERE " + CN_DOCUMENT_CODE + " = '" + DbUtil.replaceQuotes(code) + "'";
   }
}