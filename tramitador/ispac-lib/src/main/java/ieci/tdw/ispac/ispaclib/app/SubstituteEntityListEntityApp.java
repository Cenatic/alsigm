package ieci.tdw.ispac.ispaclib.app;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaclib.bean.BeanPropertyFmt;
import ieci.tdw.ispac.ispaclib.bean.BeanPropertyValidationFmt;
import ieci.tdw.ispac.ispaclib.bean.CacheFormatterFactory;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.dao.join.TableJoinFactoryDAO;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.util.PrefixBuilder;
import ieci.tdw.ispac.ispaclib.utils.CollectionUtils;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;
import ieci.tdw.ispac.ispaclib.worklist.WLCodeTableDef;
import ieci.tdw.ispac.ispaclib.worklist.WLTableDef;
import ieci.tdw.ispac.ispaclib.worklist.app.AppMainEntityDef;
import ieci.tdw.ispac.ispaclib.worklist.app.AppSecondaryEntityDef;
import ieci.tdw.ispac.ispaclib.worklist.app.AppValidationEntityDef;

import java.util.ArrayList;
import java.util.List;

public class SubstituteEntityListEntityApp extends GenericEntityListEntityApp {
	
	private static final long serialVersionUID = -4388852799326434685L;

	public SubstituteEntityListEntityApp(ClientContext context) {
		super(context);
	}
	
	public void initiate() throws ISPACException {
		super.initiate();
		
		// ===================================================================
		// TODO Eliminar este c�digo cuando se elimine el m�todo getItemBeanListToShow
		// ===================================================================
		List itemBeanList = getItemBeanListToShow();
		if (!CollectionUtils.isEmpty(itemBeanList)) {
			mItemBeanList = itemBeanList;
		}
		// ===================================================================
	}
	
	/**
	 * @deprecated Se debe utilizar el m�todo getItemBeanList.
	 */
	public List getItemBeanListToShow() throws ISPACException {
		return new ArrayList();
	}
	
	protected List getItemBeanList(int entityId) throws ISPACException {
		
		StringBuffer sqljoinquery = new StringBuffer();
		TableJoinFactoryDAO joinfactory = new TableJoinFactoryDAO();
		
		// Entidad principal
		AppMainEntityDef appMainEntityDef = new AppMainEntityDef();
		appMainEntityDef.setEntityId(getMainEntity());
		appMainEntityDef.setName(getMainEntityName());
		
		DbCnt cnt = mContext.getConnection();
		try{
		
			// Relaci�n de la entidad principal
			appMainEntityDef.addJoin(cnt, joinfactory);
			sqljoinquery.append(appMainEntityDef.getJoinBind(cnt, msExpedient));
	
			CacheFormatterFactory factory = CacheFormatterFactory.getInstance();
			
			// Relacionar las entidades a partir de los campos a mostrar especificados en el formateador
			beanFormatter = factory.getFormatter(this);
			for (int i = 0; i < beanFormatter.size(); i++) {
				
				BeanPropertyFmt beanPropertyFmt = (BeanPropertyFmt) beanFormatter.get(i);
				String[] sProperty = beanPropertyFmt.getProperty().split(PrefixBuilder.PREFIX_ISPAC);
				
				if (sProperty.length > 1) {
				
					// Entidad secundaria relacionada con la principal
					String entityName = sProperty[0];
					if (!entityName.equals(getMainEntityName())) {
						
						String join = (String) joinListSecondaryEntities.get(entityName);
						if (join != null) {
						
							WLTableDef tableDef = new WLTableDef();
							tableDef.setName(entityName);
							tableDef.setTableName(entityName);
							tableDef.setNumExpField(sProperty[1]);
							
							AppSecondaryEntityDef appSecondaryEntityDef = new AppSecondaryEntityDef();
							appSecondaryEntityDef.setName(getMainEntityName());
							appSecondaryEntityDef.setTable(tableDef);
							appSecondaryEntityDef.setJoin(join);
							
							// Relaci�n de la entidad secundaria
							appSecondaryEntityDef.addJoin(cnt, joinfactory);
							
							// Limpiar la relaci�n
							// para que la entidad secundaria s�lo se agregue una vez la relaci�n SQL
							joinListSecondaryEntities.put(entityName, null);
						}
					}
					
					// Entidad de validaci�n relacionada con la principal o alguna de las secundarias
					if (sProperty.length == 3) {
						
						String primaryTable = sProperty[1];
						BeanPropertyValidationFmt validationFmt = (BeanPropertyValidationFmt) beanPropertyFmt;
						
						// Obtener la relaci�n
						String key = primaryTable + PrefixBuilder.PREFIX_ISPAC + validationFmt.getValidatedField();
						String join = (String) joinListSecondaryEntities.get(key);
						if (join != null) {
							
							// Tabla de validaci�n
							WLCodeTableDef wlCodeTableDef = new WLCodeTableDef(sProperty[0], null, validationFmt.getValidationTable(), sProperty[2]);
							
							// Relaci�n entre la entidad y la tabla de validaci�n
							AppValidationEntityDef appValidationEntityDef = new AppValidationEntityDef(primaryTable, validationFmt.getValidatedField(), wlCodeTableDef, join);
							appValidationEntityDef.addJoin(cnt, joinfactory);
							
							joinListSecondaryEntities.remove(key);
						}
					}
				}
			}
			
			// A�adir filtros
			addFilter(sqljoinquery);
			
			// A�adir el orden
			addOrderBy(sqljoinquery);
			
			// Obtener la lista de entidades con los campos a mostrar
			// para la entidad principal, entidades secundarias y tablas de validaci�n
			IItemCollection collection = joinfactory.queryTableJoin(cnt, " WHERE " + sqljoinquery.toString(),
					getMainEntityName() + PrefixBuilder.PREFIX_ISPAC + mainEntityDef.getKeyField()).disconnect();
			return CollectionBean.getBeanList(collection);

		} finally {
			mContext.releaseConnection(cnt);
		}
	}
	
	protected void addFilter(StringBuffer sqljoinquery) throws ISPACException {
	}
	
	protected void addOrderBy(StringBuffer sqljoinquery) throws ISPACException {
		
		String order = getListOrder();
		if (StringUtils.isNotBlank(order)) {
			sqljoinquery.append(" ORDER BY ").append(order);
		}
	}

}
