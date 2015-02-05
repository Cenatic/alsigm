/*
 * Created on 19-may-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package ieci.tdw.ispac.ispaclib.dao.wl;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IProcess;
import ieci.tdw.ispac.ispaclib.dao.CollectionDAO;
import ieci.tdw.ispac.ispaclib.dao.ObjectDAO;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.utils.DBUtil;

/**
 * @author IECISA
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Generation - Code and Comments
 */
@SuppressWarnings("serial")
public class WLProcessInTrashDAO extends ObjectDAO  {
	
	public static final String TABLENAME = "SPAC_WL_PROC_TRASH";
	public static final String IDKEY 		= "ID";


	
	public WLProcessInTrashDAO() throws ISPACException {
		super();

	}
	
	public WLProcessInTrashDAO(DbCnt cnt, String numexp) throws ISPACException	{
		super(cnt, null);
		loadProcessByNumexp(cnt,numexp);
	}
	/**
	 * 
	 * @param cnt
	 * @param id
	 * @throws ISPACException
	 */
	public WLProcessInTrashDAO(DbCnt cnt, int id) throws ISPACException {
		super(cnt, id,null);
	}

	/**
	 * 
	 * @param cnt
	 * @throws ISPACException
	 */
	public WLProcessInTrashDAO(DbCnt cnt) throws ISPACException {
		super(cnt, null);
	}



	public String getTableName() {
		return TABLENAME;
	}

	protected String getDefaultSQL(int nActionDAO) throws ISPACException {
		return " WHERE " + IDKEY + " = " + getInt(IDKEY);
	}

	protected void newObject(DbCnt cnt) throws ISPACException {
		throw new ISPACException("WLProcessDAO: No se tiene secuencia");
	}

	public String getKeyName() throws ISPACException {
		return IDKEY;
	}


	public static CollectionDAO getWorkItems(DbCnt cnt, String resp,
			int idProcess) throws ISPACException {
		StringBuffer sql = new StringBuffer();

		sql.append(" WHERE ID = ").append(idProcess);
		CollectionDAO objlist = new CollectionDAO(WLProcessInTrashDAO.class);
		objlist.query(cnt, sql.toString());

		return objlist;
	}
	
	/**
	 * m�todo que devuelve el expediente seg�n su n�mero de expediente
	 * @param cnt clase DbCnt
	 * @param numexp n�mero del expediente
	 * @return un objeto expediente
	 */
	// este m�todo no es correcto
	public void loadProcessByNumexp(DbCnt cnt, String numexp)
	throws ISPACException
	{
		String sql="WHERE NUMEXP = '" + DBUtil.replaceQuotes(numexp) +"' AND TIPO = " + IProcess.PROCESS_TYPE;
		this.load(cnt, sql);
	}

	
	/**
	 * 
	 * @param cnt
	 * @param numexps
	 * @return
	 * @throws ISPACException
	 */
	public CollectionDAO loadProcessByNumExps(DbCnt cnt, String[] numexps)
	throws ISPACException
	{
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < numexps.length; i++) {
			if (str.length()>0) str.append(", ");
			str.append("'").append(DBUtil.replaceQuotes(numexps[i])).append("'");
			
		}
		String sql="WHERE NUMEXP IN (" + str.toString() + ") AND TIPO = " + IProcess.PROCESS_TYPE ;
		CollectionDAO objlist=new CollectionDAO(WLProcessInTrashDAO.class);
		objlist.query(cnt,sql);
		return objlist;
	}

	/**
	 * m�todo que devuelve una colecci�n de expedientes de una fase
	 * en funci�n de la responsabilidad
	 * 
	 * @param cnt clase DbCnt
	 * @param resp responsable
	 * @param idStagePcd identificador de la fase
	 * @return colecci�n de expedientes
	 */
	public static CollectionDAO getExps(DbCnt cnt, String resp, int idStagePcd)
	throws ISPACException
	{
		StringBuffer sql = new StringBuffer();

		sql.append(" WHERE ID_STAGEPCD = ")
		   .append(idStagePcd);

		CollectionDAO objlist = new CollectionDAO(WLProcessInTrashDAO.class);
		objlist.query(cnt, sql.toString());

		return objlist;
	}

}