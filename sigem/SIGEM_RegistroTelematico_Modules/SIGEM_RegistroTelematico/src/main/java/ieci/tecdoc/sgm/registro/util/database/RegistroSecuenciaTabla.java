/*
 * Created on 8-ago-2005
 * @autor IECI S.A.
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ieci.tecdoc.sgm.registro.util.database;

import ieci.tecdoc.sgm.base.dbex.DbUtil;

/**
 * Mapea la tabla SGMRTREGISTRO_SECUENCIA.
 *
 * @see RegistroSecuenciaDatos
 */
public class RegistroSecuenciaTabla {
	private static final String TN = "SGMRTREGISTRO_SECUENCIA";

	private static final String CN_YEAR = "ANYO";
	private static final String CN_LABEL = "ETIQUETA";
	private static final String CN_SEQUENCE = "SECUENCIA";

	public RegistroSecuenciaTabla()
	{
	}

   /**
    * Devuelve el nombre completo de la tabla mapeada sin cualificar.
	*
    * @return El nombre de la tabla.
    */
   public String getTableName()
   {
      return TN;
   }

   /**
    * Devuelve el nombre completo de la columna a�o.
    *
    * @return El nombre de dicha columna.
    */
   public String getYearColumnName()
   {
   	  return CN_YEAR;
   }

   /**
    * Devuelve el nombre completo de la columna etiqueta.
    *
    * @return El nombre de dicha columna.
    */
   public String getLabelColumnName()
   {
      return CN_LABEL;
   }

   /**
    * Devuelve el nombre completo de la columna secuencia.
    *
    * @return El nombre de dicha columna.
    */
   public String getSequenceColumnName()
   {
   	  return CN_SEQUENCE;
   }

   /**
    * Devuelve los nombres completos de todas las columnas de la tabla
    * mapeada, separados por comas.
    *
    * @return Los nombres de las columnas mencionadas.
    */
   public String getAllColumnsName()
   {
      return CN_YEAR + ", " + CN_LABEL + ", " + CN_SEQUENCE;
   }

   /**
    * Devuelve los nombres completos de todas las columnas para actualizar,
    * separados por comas.
    *
    * @return Los nombres de las columnas mencionadas.
    */
   public String getUpdateSequenceAndYearColumnsName()
   {
      return CN_YEAR + ", " + CN_SEQUENCE;
   }

   /**
    * Devuelve la cl�usula de consulta por el valor de a�o que se pasa
    * como par�metro.
    *
    * @param year A�o.
    * @return La cl�usula.
    */
   public String getByYearQual(String year)
   {
      return  " WHERE " + CN_YEAR  + " = '" + DbUtil.replaceQuotes(year) + "'";
   }


   /**
    * Devuelve la cl�usula de actualizaci�n del n�mero de secuencia
    * (se incremente el valor anterior en uno)
    *
    * @return La cl�usula.
    */
   public String getUpdateSequence()
   {
      String update;

      update = "UPDATE " + getTableName() + " SET " + CN_SEQUENCE + "=" + CN_SEQUENCE + "+1";

      return update;
   }

   /**
    * Devuelve la cl�usula de actualizaci�n del n�mero de secuencia para una oficina
    * (se incremente el valor anterior en uno)
    *
    * @return La cl�usula.
    */
   public String getUpdateSequence(String label)
   {
      String update;

      update = "UPDATE " + getTableName() + " SET " + CN_SEQUENCE + "=" + CN_SEQUENCE + "+1 WHERE " + CN_LABEL + " = '" + DbUtil.replaceQuotes(label) + "'";

      return update;
   }

   /**
    * Devuelve la cl�usula de actualizaci�n del n�mero de secuencia para una oficina
    * (se incremente el valor anterior en uno)
    *
    * @return La cl�usula.
    */
   public String getUpdateSequence(String label, String year)
   {
      String update;

      update = "UPDATE " + getTableName()
      		 + " SET " + CN_SEQUENCE + "=" + CN_SEQUENCE + "+1"
      		 + " WHERE " + CN_LABEL + " = '" + DbUtil.replaceQuotes(label) + "'"
      		 + " AND " + CN_YEAR + " = '" + DbUtil.replaceQuotes(year) + "'";

      return update;
   }

   /**
    * Devuelve la cl�usula de consulta por el label
    * como par�metro.
    *
    * @param label Campo label (oficina).
    * @return La cl�usula.
    */
   public String getByLabelQual(String label)
   {
      return  " WHERE " + CN_LABEL  + " = '" + DbUtil.replaceQuotes(label) + "'";
   }

   /**
    * Devuelve la cl�usula de consulta por el label y el a�o.
    *
    * @param label Campo label (oficina).
    * @param year Campo a�o.
    * @return La cl�usula.
    */
   public String getByLabelQual(String label, String year)
   {
      return " WHERE " + CN_LABEL  + " = '" + DbUtil.replaceQuotes(label) + "' AND " + CN_YEAR  + " = '" + DbUtil.replaceQuotes(year) + "'";
   }

}
