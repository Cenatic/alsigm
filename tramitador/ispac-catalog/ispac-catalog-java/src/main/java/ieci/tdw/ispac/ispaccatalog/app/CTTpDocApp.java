package ieci.tdw.ispac.ispaccatalog.app;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaclib.app.SimpleEntityApp;
import ieci.tdw.ispac.ispaclib.bean.ValidationError;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.utils.DBUtil;
import ieci.tdw.ispac.ispaclib.utils.DateUtil;

/**
 * EntityApp para la informaci�n de un tipo de documento del cat�logo de tipos de documento.
 *
 */
public class CTTpDocApp extends SimpleEntityApp {

	/**
	 * Constructor
	 * @param context Contexto del cliente.
	 */
	public CTTpDocApp(ClientContext context) {
		super(context);
	}

	/**
	 * Inicializa los valores del formulario.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void initiate() throws ISPACException {

		super.initiate();
		
		if (getString("ID")==null){
			setProperty("AUTOR", mContext.getUser().getName());
			setProperty("FECHA", DateUtil.getToday());
		}
	}

	/**
	 * Valida la informaci�n del formulario.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public boolean validate() throws ISPACException {
		
		boolean ret = super.validate();
		
		if (ret) {
			
			IInvesflowAPI invesFlowAPI = mContext.getAPI();
			ICatalogAPI catalogAPI = invesFlowAPI.getCatalogAPI();
			
			// Bloqueo de la tabla
			catalogAPI.setCTEntitiesForUpdate(ICatalogAPI.ENTITY_CT_TYPEDOC, "");
			
			// Nombre �nico de tipo de documento
			String nombre = getString("NOMBRE");
			IItemCollection itemcol = catalogAPI.queryCTEntities(ICatalogAPI.ENTITY_CT_TYPEDOC, " WHERE NOMBRE = '" + DBUtil.replaceQuotes(nombre) + "' AND ID != " + getString("ID"));
			if (itemcol.next()) {
				
				addError(new ValidationError("property(NOMBRE)", "error.tpdoc.nameDuplicated", new String[] {nombre}));
				return false;
			}
			
			return true;
		}
		else {
			return false;
		}
	}

}