package ieci.tdw.ispac.ispaclib.dao.cat;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.dao.ObjectDAO;
import ieci.tdw.ispac.ispaclib.dao.idsequences.IdSequenceMgr;
import ieci.tdw.ispac.ispaclib.db.DbCnt;

/**
 * DAO para la gesti�n de la tabla del cat�logo de tr�mites.
 *
 */
public class CTTaskDAO extends ObjectDAO {

	/**
	 * Nombre de la tabla.
	 */
	static final String TABLENAME = "SPAC_CT_TRAMITES";

	/**
	 * Nombre de la secuencia.
	 */
	static final String IDSEQUENCE = "SPAC_SQ_ID_CTTRAMITES";

	/**
	 * Nombre de la columna del identificador �nico.
	 */
	static final String IDKEY = "ID";
	
	/**
	 * Constructor.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public CTTaskDAO() throws ISPACException {
		super(null);
	}
	
	/**
	 * @param cnt
	 * @throws ISPACException
	 */
	public CTTaskDAO(DbCnt cnt) throws ISPACException {
		super(cnt, null);
	}
	
	/**
	 * Constructor
	 * @param cnt Conexi�n a la base de datos.
	 * @param id Identificador �nico del tr�mite.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public CTTaskDAO(DbCnt cnt, int id) throws ISPACException {
		super(cnt, id, null);
	}

	/**
	 * Obtiene el nombre de la tabla.
	 * @return Nombre de la tabla.
	 */
	public String getTableName() {
		return TABLENAME;
	}

	/**
	 * Construye un nuevo registro.
	 * @param cnt Conexi�n a la base de datos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	protected void newObject(DbCnt cnt) throws ISPACException {
		set(IDKEY, IdSequenceMgr.getIdSequence(cnt, IDSEQUENCE));
	}

	/**
	 * Obtiene la sentencia SQL por defecto.
	 * @param nActionDAO C�digo de de acci�n.
	 * @return Sentencia SQL. 
	 * @throws ISPACException si ocurre alg�n error. 
	 */
	protected String getDefaultSQL(int nActionDAO) throws ISPACException {
		return " WHERE " + IDKEY + " = " + getInt(IDKEY);
	}

	/**
	 * Obtiene el nombre de la columna del identificador �nico.
	 * @return Nombre de la columna del identificador �nico.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public String getKeyName() throws ISPACException {
		return IDKEY;
	}

	/**
	 * Actualiza el identificador del subproceso de los tr�mites.
	 * @param cnt Conexi�n a la base de datos.
	 * @param oldSubPcdId Identificador anterior del subproceso.
	 * @param newSubPcdId Nuevo identificador del subproceso.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public static void updateSubProcedureId(DbCnt cnt, int oldSubPcdId, 
			int newSubPcdId) throws ISPACException {
		
		String sql = new StringBuffer()
			.append("UPDATE ")
			.append(TABLENAME)
			.append(" SET ID_SUBPROCESO=")
			.append(newSubPcdId)
			.append(" WHERE ID_SUBPROCESO=")
			.append(oldSubPcdId)
			.toString();
		
		cnt.directExec(sql);
	}

}
