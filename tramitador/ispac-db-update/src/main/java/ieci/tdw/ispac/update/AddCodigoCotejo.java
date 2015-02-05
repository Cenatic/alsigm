package ieci.tdw.ispac.update;

import ieci.tdw.ispac.ScriptBase;
import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IEntitiesAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.db.InternalDataType;
import ieci.tdw.ispac.ispaclib.entity.def.EntityDef;
import ieci.tdw.ispac.ispaclib.entity.def.EntityField;

import org.apache.log4j.Logger;

/**
 * Clase para a�adir el campo "C�digo de cotejo" a la entidad de documentos.
 *
 */
public class AddCodigoCotejo extends ScriptBase {
	
	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = Logger.getLogger(AddCodigoCotejo.class); 
	
	
	public static void main(String[] args) throws Exception {
		
		checkArguments(args);

		ClientContext context = getClientContext(args);
		
		try {
			
			context.beginTX();
			
			// A�adir el campo cod_cotejo
			addCodigoCotejo(context);

			// Commit de la transacci�n
			context.endTX(true);

			logger.info("Proceso de actualizaci�n finalizado con �xito.");
		
		} catch (Throwable t) {
        	
			logger.error("Error en el proceso de actualizaci�n", t);

			// Rollback de la transacci�n
			context.endTX(false);
			
		} finally {
			context.releaseTX();
		}
	}

	/**
	 * A�ade la columna cod_cotejo a la entidad de documentos.
	 * @param context Contexto de cliente.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	protected static void addCodigoCotejo(ClientContext context) throws ISPACException {
		
		try {
			
			IInvesflowAPI invesFlowAPI = context.getAPI();
			IEntitiesAPI entitiesAPI = invesFlowAPI.getEntitiesAPI();
			ICatalogAPI catalogAPI = invesFlowAPI.getCatalogAPI();
			
			// Informaci�n de la tabla Documentos del Expediente
			IItem entity = entitiesAPI.getCatalogEntity("SPAC_DT_DOCUMENTOS");
			EntityDef entidadDef = EntityDef.parseEntityDef(entity.getString("DEFINICION"));
	
			if (!entidadDef.containsFieldByName("cod_cotejo")) {
				
				// A�adir el campo a la entidad
				EntityField codCotejoField = new EntityField();
				codCotejoField.setId(entidadDef.getMaxId() + 1);
				codCotejoField.setPhysicalName("cod_cotejo");
				codCotejoField.setLogicalName("C�digo de cotejo");
				codCotejoField.setDescripcion("C�digo de cotejo");
				codCotejoField.setType(InternalDataType.SHORT_TEXT);
				codCotejoField.setSize(50);
	
				catalogAPI.addField(entity.getInt("ID"), codCotejoField, true);
				logger.info("Campo COD_COTEJO a�adido a la entidad de documentos (SPAC_DT_DOCUMENTOS)");
			} else {
				logger.info("El campo COD_COTEJO ya existe en la entidad de documentos (SPAC_DT_DOCUMENTOS)");
			}
			
		} catch (ISPACException e) {
			logger.error("Error al a�adir el campo cod_cotejo a la tabla spac_dt_documentos", e);
			throw e;
		} catch (Throwable e) {
			logger.error("Error al a�adir el campo cod_cotejo a la tabla spac_dt_documentos", e);
			throw new ISPACException(e);
		}
	}
}