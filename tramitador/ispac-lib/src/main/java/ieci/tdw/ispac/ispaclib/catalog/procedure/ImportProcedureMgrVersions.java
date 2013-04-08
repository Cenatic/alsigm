package ieci.tdw.ispac.ispaclib.catalog.procedure;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.app.EntityAppConstants;
import ieci.tdw.ispac.ispaclib.app.EntityParameterDef;
import ieci.tdw.ispac.ispaclib.app.ParametersDef;
import ieci.tdw.ispac.ispaclib.dao.cat.CTApplicationDAO;
import ieci.tdw.ispac.ispaclib.dao.cat.CTEntityDAO;
import ieci.tdw.ispac.ispaclib.entity.def.EntityDef;
import ieci.tdw.ispac.ispaclib.entity.def.EntityValidation;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ImportProcedureMgrVersions {
	
	// Actualizaciones en la versi�n 5.2.7
	public static final String VERSION_5_2_7 			= "5.2.7";
	// En los par�metros del formulario sustituir el tag <id></id> por <table></table> y el atributo primaryId por primaryTable
	public static final String XML_TAG_ID_OPEN 			= "<id>";
	public static final String XML_TAG_ID_CLOSE 		= "</id>";
	public static final String XML_TAG_TABLE_OPEN 		= "<" + EntityAppConstants.NODE_TABLE + ">";
	public static final String XML_TAG_TABLE_CLOSE 		= "</" + EntityAppConstants.NODE_TABLE + ">";
	public static final String XML_ATTRIBUTE_PRIMARY_ID = "primaryId";
	// Cadena a buscar en el formulario JSP para sustituir en el action de las lupas entity=Id por entity=Nombre
	public static final String ENTITY_IN_FORM_JSP 		= "entity=";
	
	// Actualizaciones en la versi�n 5.3
	public static final String VERSION_5_3 				= "5.3";
	// Eliminaci�n de la regla asociada a los procedimientos:
	// ID: 4 -> 'Inicializa Valores Expediente' -> ieci.tdw.ispac.api.rule.processes.InicializarValoresExpedienteRule
	// y eliminaci�n de la regla asociada a los tr�mites:
	// ID: 7 -> 'AsignarTipoRegistro' -> ieci.tdw.ispac.api.rule.docs.SetRegistryTypeRule
	// cuyos Executes han pasado al c�digo fuente
	public static final int ID_RULE_INICIALIZAR_VALORES_EXPEDIENTE 	= 4;
	public static final int ID_RULE_SET_REGISTRY_TYPE 				= 7;
	
	// Actualizaciones en la versi�n 5.4
	public static final String VERSION_5_4 				= "5.4";
	// En las entidades y tablas de validaci�n el campo ID se establece como no nulo

	// Actualizaciones en la versi�n 5.5.1
	public static final String VERSION_5_5_1 				= "5.5.1";
	// En las tablas de validaci�n se ha a�adido el campo ORDEN

	/**
	 * 
	 * @param exportVersion
	 * @param version
	 * @return
	 * @throws ISPACException
	 */
	public static boolean isPreviousVersion(String exportVersion, 
		   								   String version) throws ISPACException {
	     
	   String[] sExportVersion = exportVersion.split("\\.");
	   String[] sVersion = version.split("\\.");
	   
	   for(int i = 0; i < sExportVersion.length; i++) {
		   
		   // La versi�n de exportaci�n tiene m�s numeraci�n
		   // luego es una versi�n superior
		   if (sVersion.length <= i) {
			   return false;
		   }

		   int iExportVersion = Integer.parseInt(sExportVersion[i]);
		   int iVersion = Integer.parseInt(sVersion[i]);
		   
		   if (iVersion > iExportVersion) {
			   // La versi�n de exportaci�n es inferior
			   return true;
		   }
		   else if (iVersion < iExportVersion) {
			   // La versi�n de exportaci�n es superior
			   return false;
		   }
	   }
	   
	   // Versiones iguales
	   return false;
	}
   
	/**
	 * 
	 * @param ctEntityDAO
	 * @param ctEntityDAOs
	 * @throws ISPACException
	 */
	public static void updateCatalogEntity_5_2_7(CTEntityDAO ctEntityDAO,
												 Map ctEntityDAOs) throws ISPACException {
		
		// En las validaciones de la definici�n de la entidad
		// sustituir el Id de tabla por el nombre de la tabla
		String xmlEntityDefinition = ctEntityDAO.getDefinition();
		if (StringUtils.isNotBlank(xmlEntityDefinition)) {
			
			EntityDef entityDefinition = EntityDef.parseEntityDef(xmlEntityDefinition);

			// Validaciones
			List validations = entityDefinition.getValidations();
			Iterator it = validations.iterator();
			while (it.hasNext()) {

				EntityValidation entityValidation = (EntityValidation) it.next();

				// Validaci�n con tabla?
				String table = entityValidation.getTable();
				if (StringUtils.isNotBlank(table)) {

					// Id en la tabla?
					Integer tableId = null;
					try {
						tableId = new Integer(table);
					}
					catch (NumberFormatException nfe) {}

					if (tableId != null) {

						// Obtener el nombre de la tabla a partir del Id
						CTEntityDAO ctEntityInValidation = (CTEntityDAO) ctEntityDAOs.get(tableId);
						if (ctEntityInValidation != null) {
							table = ctEntityInValidation.getName();
						}
						else {
							table = "";
						}
						
						entityValidation.setTable(table);
					}
				}
			}
			
			// Actualizar la definici�n de la entidad
			ctEntityDAO.set("DEFINICION", entityDefinition.getXmlValues());
			
        	// En el formulario JSP de la entidad
        	// sustituir en el action de las lupas entity=Id por entity=Nombre
        	String frmJsp = ctEntityDAO.getString("FRM_JSP");
        	if (StringUtils.isNotBlank(frmJsp)) {
        		
        		String[] frmJspSplit = frmJsp.split(ENTITY_IN_FORM_JSP);
        		if (frmJspSplit.length > 1) {
        			
        			// Procesar el formulario JSP de la entidad
        			StringBuffer newFrmJsp = new StringBuffer(frmJspSplit[0]);
        			updateFrmJsp(newFrmJsp, frmJspSplit, ctEntityDAOs);
        				
       				// Actualizar el formulario JSP de la entidad
        			ctEntityDAO.set("FRM_JSP", newFrmJsp.toString());
        		}
        	}
		}
	}
	
	/**
	 * 
	 * @param ctApplicationDAO
	 * @param ctEntityDAOs
	 * @throws ISPACException
	 */
	public static void updateForm_5_2_7(CTApplicationDAO ctApplicationDAO,
			 							Map ctEntityDAOs) throws ISPACException {

		// En los par�metros del formulario
		// sustituir
		// el tag id por table
		// el atributo primaryId por primaryTable
		// y el Id de tabla por el nombre de la tabla
    	String xmlFormParameters = ctApplicationDAO.getParameters();
    	if (StringUtils.isNotBlank(xmlFormParameters)) {
    		
    		// Reemplazar <id> por <table>
    		xmlFormParameters = StringUtils.replace(xmlFormParameters, XML_TAG_ID_OPEN, XML_TAG_TABLE_OPEN);
    		// Reemplazar </id> por </table>
    		xmlFormParameters = StringUtils.replace(xmlFormParameters, XML_TAG_ID_CLOSE, XML_TAG_TABLE_CLOSE);
    		
    		// Reemplazar primaryId por primaryTable (en COMPOSITE)
    		xmlFormParameters = StringUtils.replace(xmlFormParameters, XML_ATTRIBUTE_PRIMARY_ID, EntityAppConstants.ATTRIBUTE_PRIMARY_TABLE);

    		ParametersDef parametersDefinition = ParametersDef.parseParametersDef(xmlFormParameters);
    		
    		// Entidades del formulario
    		List entities = parametersDefinition.getEntities();
    		Iterator it = entities.iterator();
    		while (it.hasNext()) {
    			
    			EntityParameterDef entityParameterDefinition = (EntityParameterDef) it.next();
    			
    			// Validaci�n con tabla primaria?
    			String table = entityParameterDefinition.getPrimaryTable();
    			if (StringUtils.isNotBlank(table)) {
    			
        			// Id en la tabla?
        			Integer tableId = null;
        			try {
        				tableId = new Integer(table);
        			}
        			catch (NumberFormatException nfe) {}
        			
        			if (tableId != null) {
        				
        				// Obtener el nombre de la tabla a partir del Id
        				CTEntityDAO ctEntityInParameter = (CTEntityDAO) ctEntityDAOs.get(tableId);
        				if (ctEntityInParameter != null) {
        					table = ctEntityInParameter.getString("NOMBRE");
        				}
        				else {
        					table = "";
        				}
        				
        				entityParameterDefinition.setPrimaryTable(table);
        			}
    			}
    			
    			// Par�metro con tabla?
    			table = entityParameterDefinition.getTable();
    			if (StringUtils.isNotBlank(table)) {
    			
        			// Id en la tabla?
        			Integer tableId = null;
        			try {
        				tableId = new Integer(table);
        			}
        			catch (NumberFormatException nfe) {}
        			
        			if (tableId != null) {
        				
        				// Obtener el nombre de la tabla a partir del Id
        				CTEntityDAO ctEntityInParameter = (CTEntityDAO) ctEntityDAOs.get(tableId);
        				if (ctEntityInParameter != null) {
        					table = ctEntityInParameter.getString("NOMBRE");
        				}
        				else {
        					table = "";
        				}
        				
        				entityParameterDefinition.setTable(table);
        			}
    			}
    		}
    			
			// Actualizar los par�metros del formulario
    		ctApplicationDAO.set("PARAMETROS", parametersDefinition.toXml());	
    	}
    	
    	// En el formulario JSP
    	// sustituir en el action de las lupas entity=Id por entity=Nombre
    	String frmJsp = ctApplicationDAO.getFrmJsp();
    	if (StringUtils.isNotBlank(frmJsp)) {
    		
    		String[] frmJspSplit = frmJsp.split(ENTITY_IN_FORM_JSP);
    		if (frmJspSplit.length > 1) {
        			
    			// Procesar el formulario JSP de la entidad
    			StringBuffer newFrmJsp = new StringBuffer(frmJspSplit[0]);
    			updateFrmJsp(newFrmJsp, frmJspSplit, ctEntityDAOs);
    				
   				// Actualizar el formulario JSP
    			ctApplicationDAO.set("FRM_JSP", newFrmJsp.toString());
    		}
    	}
	}

	/**
	 * 
	 * @param newFrmJsp
	 * @param frmJspSplit
	 * @param ctEntityDAOs
	 * @throws ISPACException
	 */
	private static void updateFrmJsp(StringBuffer newFrmJsp,
		    						 String[] frmJspSplit,
		    						 Map ctEntityDAOs) throws ISPACException {

		int i = 1;
		while (i < frmJspSplit.length) {

			String nextPart = frmJspSplit[i++];
			int quoteIndex = nextPart.indexOf("\"");

			String table = nextPart.substring(0, quoteIndex);

			// Id en la tabla?
			Integer tableId = null;
			try {
				tableId = new Integer(table);
			}
			catch (NumberFormatException nfe) {}

			if (tableId != null) {

				// Obtener el nombre de la tabla a partir del Id
				CTEntityDAO ctEntityInForm = (CTEntityDAO) ctEntityDAOs.get(tableId);
				if (ctEntityInForm != null) {
					table = ctEntityInForm.getName();
				}
				else {
					table = "";
				}
			}
			
			newFrmJsp.append(ENTITY_IN_FORM_JSP)
			 		 .append(table)
			 		 .append(nextPart.substring(quoteIndex, nextPart.length()));
		}
	}
	
}