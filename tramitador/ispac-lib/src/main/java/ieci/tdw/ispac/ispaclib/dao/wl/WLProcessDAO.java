/*
 * Created on 19-may-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package ieci.tdw.ispac.ispaclib.dao.wl;

import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IProcess;
import ieci.tdw.ispac.ispaclib.dao.CollectionDAO;
import ieci.tdw.ispac.ispaclib.dao.ObjectDAO;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.resp.Responsible;
import ieci.tdw.ispac.ispaclib.utils.DBUtil;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

/**
 * @author marisa
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class WLProcessDAO extends ObjectDAO {
	public static final String TABLENAME 	= "SPAC_WL_PROC";
	//static final String IDSEQUENCE
	public static final String IDKEY 		= "ID";

	/**
	 * 
	 * @throws ISPACException
	 */
	public WLProcessDAO() throws ISPACException {
		super(null);
	}

	/**
	 * 
	 * @param cnt
	 * @throws ISPACException
	 */
	public WLProcessDAO(DbCnt cnt) throws ISPACException {
		super(cnt, null);
	}

	/**
	 * 
	 * @param cnt
	 * @param id
	 * @throws ISPACException
	 */
	public WLProcessDAO(DbCnt cnt, int id) throws ISPACException {
		super(cnt, id, null);
	}

	/**
	 * 
	 * @param cnt
	 * @param numexp
	 * @throws ISPACException
	 */
	public WLProcessDAO(DbCnt cnt, String numexp) throws ISPACException	{
		super(cnt, null);
		loadProcessByNumexp(cnt,numexp);
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
		   .append(idStagePcd)
		   .append(addAndInResponsibleOrExistPermissionCondition(resp));

		CollectionDAO objlist = new CollectionDAO(WLProcessDAO.class);
		objlist.query(cnt, sql.toString());

		return objlist;
	}

	/**
	 * m�todo que devuelve una colecci�n de fases activas para un expediente
	 * en funci�n de la responsabilidad
	 * 
	 * @param cnt clase DbCnt
	 * @param resp responsable
	 * @param idProcess identificador del expediente
	 * return colecci�n de expedientes
	 */
	public static CollectionDAO getWorkItems(DbCnt cnt, String resp, int idProcess)
	throws ISPACException
	{
		StringBuffer sql = new StringBuffer();

		sql.append(" WHERE ID = ")
		   .append(idProcess)
		   .append(addAndInResponsibleOrExistPermissionCondition(resp));

		CollectionDAO objlist = new CollectionDAO(WLProcessDAO.class);
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
		CollectionDAO objlist=new CollectionDAO(WLProcessDAO.class);
		objlist.query(cnt,sql);
		return objlist;
	}

	public static String addInResponsibleOrExistPermissionCondition(String inResponsibleCondition, String inPermResponsibleCondition)
	throws ISPACException
	{
		StringBuffer sql = new StringBuffer();

		if (StringUtils.isNotBlank(inResponsibleCondition)) {

			// A�adir la responsabilidad
			// y consultar los permisos asignados
			sql.append(getSqlInResponsibleOrExistPermissionCondition(inResponsibleCondition, inPermResponsibleCondition));
		}

		return sql.toString();
	}

	public static String addInResponsibleOrExistPermissionCondition(String resp)
	throws ISPACException
	{
		String sql = " ";

		// Obtener la condici�n SQL de responsabilidad y de permisos
		// siempre que la responsabilidad no sea de Supervisor
		if (StringUtils.isNotBlank(resp) && !Responsible.SUPERVISOR.equalsIgnoreCase(resp)) {

			String sqlResponsibles = DBUtil.addInResponsibleCondition("RESP", resp);

			// A�adir la responsabilidad y consultar los permisos asignados
			sql = getSqlInResponsibleOrExistPermissionCondition(sqlResponsibles, DBUtil.addInResponsibleCondition("SPC_PERMS.ID_RESP", resp));
		}

		return sql;
	}

	protected static String getSqlInResponsibleOrExistPermissionCondition(String inResponsibleCondition, String inPermResponsibleCondition)
	throws ISPACException
	{
		StringBuffer sql = new StringBuffer();

		sql.append(" ( ")
		   .append(inResponsibleCondition)
		   .append(" OR ( ")
		   .append("SELECT COUNT(*) FROM SPAC_PERMISOS SPC_PERMS WHERE ( ")
		   // Procedimiento
		   .append("(SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_PROCEDURE)
		   .append(" AND SPC_PERMS.ID_OBJ = ID_PCD)  ")
		   /*// Proceso
		   .append(" OR (SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_PROCESS)
		   .append(" AND SPC_PERMS.ID_OBJ = ID) OR ")
		   // Fase
		   .append("(SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_STAGE)
		   .append(" AND SPC_PERMS.ID_OBJ = ID_STAGE) OR ")
		   // Fase con tramites
		   .append("(SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_STAGE_TASKS)
		   .append(" AND SPC_PERMS.ID_OBJ = ID_STAGE) OR ")
		   // Fase en el procedimiento
		   .append("(SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_STAGE_PCD)
		   .append(" AND SPC_PERMS.ID_OBJ = ID_STAGEPCD) OR ")
		   // Fase en el procedimiento con tramites
		   .append("(SPC_PERMS.TP_OBJ = ").append(ISecurityAPI.PERMISSION_TPOBJ_STAGE_PCD_TASKS)
		   .append(" AND SPC_PERMS.ID_OBJ = ID_STAGEPCD) ")*/
		   .append(") AND ")
		   .append(inPermResponsibleCondition)
		   .append(") > 0 ) ");

		return sql.toString();
	}

	public static String addAndInResponsibleOrExistPermissionCondition(String resp)
	throws ISPACException
	{
		String sql = addInResponsibleOrExistPermissionCondition(resp);

		if (StringUtils.isNotBlank(sql)) {
			sql = " AND " + sql;
		}

		return sql;
	}
}