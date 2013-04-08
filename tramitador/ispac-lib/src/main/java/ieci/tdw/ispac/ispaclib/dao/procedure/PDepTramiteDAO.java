package ieci.tdw.ispac.ispaclib.dao.procedure;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.dao.CollectionDAO;
import ieci.tdw.ispac.ispaclib.dao.ObjectDAO;
import ieci.tdw.ispac.ispaclib.dao.idsequences.IdSequenceMgr;
import ieci.tdw.ispac.ispaclib.db.DbCnt;


/**
 * DAO para la gesti�n de la tabla de dependencias entre tr�mites de procedimientos.
 *
 */
public class PDepTramiteDAO extends ObjectDAO {

	private static final long serialVersionUID = 2073276285293223402L;

	/**
	 * Nombre de la tabla.
	 */
	static final String TABLENAME = "SPAC_P_DEP_TRAMITES";

	/**
	 * Nombre de la secuencia.
	 */
	static final String IDSEQUENCE = "SPAC_SQ_ID_PDEPTRAMITES";

	/**
	 * Nombre de la columna del identificador �nico.
	 */
	static final String IDKEY = "ID";
	
	public static final String ID = "ID";
	public static final String ID_TRAMITE_PADRE = "ID_TRAMITE_PADRE";
	public static final String ID_TRAMITE_HIJO = "ID_TRAMITE_HIJO";

	/**
	 * Constructor.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public PDepTramiteDAO() throws ISPACException {
		super(null);
	}

	/**
	 * @param cnt
	 * @throws ISPACException
	 */
	public PDepTramiteDAO(DbCnt cnt) throws ISPACException {
		super(cnt, null);
	}
	
	/**
	 * Constructor
	 * @param cnt Conexi�n a la base de datos.
	 * @param id Identificador �nico del tr�mite.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public PDepTramiteDAO(DbCnt cnt, int id) throws ISPACException {
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
	 * Obtiene la lista de dependencias de un tr�mite
	 * @param cnt
	 * @param id
	 * @return
	 * @throws ISPACException
	 */
	public static CollectionDAO getDependenciesByTask(DbCnt cnt, int id)
			throws ISPACException {
		String sql = "WHERE ID_TRAMITE_HIJO = " + id;
		CollectionDAO objlist = new CollectionDAO(PDepTramiteDAO.class);
		objlist.query(cnt, sql);
		return objlist;
	}

	/**
	 * Elimina la dependencia.
	 * @param cnt Conexi�n a la base de datos.
	 * @param id Identificador de la dependencia
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public static void delete(DbCnt cnt, int id) throws ISPACException {
		String sQuery = "DELETE FROM " + TABLENAME + " WHERE id = " + id;
		cnt.directExec(sQuery);
	}

}
