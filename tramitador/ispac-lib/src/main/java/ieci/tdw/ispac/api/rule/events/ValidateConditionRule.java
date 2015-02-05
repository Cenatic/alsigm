package ieci.tdw.ispac.api.rule.events;

import java.sql.SQLException;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.rule.IRule;
import ieci.tdw.ispac.api.rule.IRuleContext;
import ieci.tdw.ispac.ispaclib.context.IClientContext;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.db.DbResultSet;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.utils.XmlFacade;

import org.apache.log4j.Logger;

/**
 * Regla para evaluar una condici�n SQL.
 *
 */
public class ValidateConditionRule implements IRule {
	
	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = Logger.getLogger(ValidateConditionRule.class);
	
	/**
	 * Informaci�n del evento que desencadena la validaci�n de la condici�n.
	 */
	private IItem event = null;
	
	
	/**
	 * Constructor.
	 * @param event Informaci�n del evento.
	 */
	public ValidateConditionRule(IItem event) {
		this.event = event;
	}
	
	public boolean init(IRuleContext rulectx) throws ISPACRuleException {
		return true;
	}

	public boolean validate(IRuleContext rulectx) throws ISPACRuleException {
		try {
			
			// Informaci�n de la condici�n
			String condition = event.getString("CONDICION");
			if (StringUtils.isNotBlank(condition)) {
				
				// Parsear el XML de la condici�n
				XmlFacade xml = new XmlFacade(condition);
				
				// Sentencia SQL 
				String sql = xml.get("/condition/sql/text()");
				if (logger.isDebugEnabled()) {
					logger.debug("SQL de la condici�n: " + sql);
				}
				
				if (StringUtils.isNotBlank(sql)) {
					
					// Sustituir par�metros
					sql = substituteParams(sql, rulectx);
					if (logger.isDebugEnabled()) {
						logger.debug("SQL final de la condici�n: " + sql);
					}
					
					return (count(rulectx, sql) > 0);
				}
			}
		} catch (ISPACException e) {
			logger.error("Error al validar la condici�n", e);
			throw new ISPACRuleException(e); 
		}

		return true;
	}
	
	private String substituteParams(String sql, IRuleContext rulectx) throws ISPACRuleException {
		
		sql = StringUtils.replace(sql, "${PROCEDURE_ID}", String.valueOf(rulectx.getProcedureId()));
		sql = StringUtils.replace(sql, "${PCD_STAGE_ID}", String.valueOf(rulectx.getStageProcedureId()));
		sql = StringUtils.replace(sql, "${PCD_TASK_ID}", String.valueOf(rulectx.getTaskProcedureId()));
		sql = StringUtils.replace(sql, "${STAGE_ID}", String.valueOf(rulectx.getStageId()));
		sql = StringUtils.replace(sql, "${TASK_ID}", String.valueOf(rulectx.getTaskId()));
		sql = StringUtils.replace(sql, "${PROCESS_ID}", String.valueOf(rulectx.getProcessId()));
		sql = StringUtils.replace(sql, "${NUMEXP}", String.valueOf(rulectx.getNumExp()));
		
		return sql;
	}

	private int count(IRuleContext rulectx, String sql) throws ISPACException {
		
		IClientContext ctx = rulectx.getClientContext();
		DbCnt cnt = ctx.getConnection();
		int count = 0;
		DbResultSet dbrs = null;
		
		try {
			
			dbrs = cnt.executeQuery(sql);
			if (dbrs.getResultSet().next()) {
				 count = dbrs.getResultSet().getInt(1);
			}

		} catch(SQLException e) {
			logger.error("Error al evaluar la condici�n", e);
			throw new ISPACException(e);
		} finally {
			try {
				if (dbrs != null) {
					dbrs.close();
				}
			} catch (ISPACException e) {}
			ctx.releaseConnection(cnt);
		}

		return count;
	}
	
	public Object execute(IRuleContext rulectx) throws ISPACRuleException {
		return null;
	}

	public void cancel(IRuleContext rulectx) throws ISPACRuleException {}
}


