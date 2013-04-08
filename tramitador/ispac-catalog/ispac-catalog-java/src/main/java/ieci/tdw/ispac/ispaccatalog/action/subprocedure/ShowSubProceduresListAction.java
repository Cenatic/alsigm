package ieci.tdw.ispac.ispaccatalog.action.subprocedure;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.bean.CollectionBean;
import ieci.tdw.ispac.ispaclib.utils.DBUtil;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Acci�n para mostrar la lista de subprocesos del cat�logo.
 *
 */
public class ShowSubProceduresListAction extends BaseAction {

	/**
	 * Ejecuta la l�gica de la acci�n.
	 * @param mapping El ActionMapping utilizado para seleccionar esta instancia
	 * @param form El ActionForm bean (opcional) para esta petici�n
	 * @param request La petici�n HTTP que se est� procesando
	 * @param response La respuesta HTTP que se est� creando
	 * @param session Informaci�n de la sesi�n del usuario
	 * @return La redirecci�n a la que se va a transferir el control.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			SessionAPI session) throws Exception {

 		// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, session.getClientContext(), new int[] {
				ISecurityAPI.FUNC_INV_SUBPROCESS_READ,
				ISecurityAPI.FUNC_INV_SUBPROCESS_EDIT });

		// Establecer el formateador
		setFormatter(request, "SubProceduresListFormatter", 
				"/formatters/subprocedure/subprocedureslistformatter.xml");

		// Lista de subprocesos
		request.setAttribute("SubProceduresList", 
				getSubProceduresList(request, session));

		return mapping.findForward("success");
	}
	
	/**
	 * Obtiene la lista de subprocesos.
	 * @param request Petici�n del usuario.
	 * @param session Informaci�n de la sesi�n de ISPAC.
	 * @return Lista de subprocesos.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	protected List getSubProceduresList(HttpServletRequest request, 
			SessionAPI session) throws ISPACException {

		// API del cat�logo
		ICatalogAPI catalogAPI = session.getAPI().getCatalogAPI();

		// Seleccionar la �ltima versi�n de cada subproceso.
		StringBuffer sql = new StringBuffer()
			.append(" WHERE TIPO=2")
			.append(" AND ID IN (SELECT MAX(ID) FROM SPAC_P_PROCEDIMIENTOS WHERE TIPO=2 GROUP BY ID_GROUP)");

		// Criterio de b�squeda
		String criterio = request.getParameter("property(criterio)");
		if (StringUtils.isNotBlank(criterio)) {
			sql.append(" AND NOMBRE LIKE '%" + DBUtil.replaceQuotes(criterio) + "%'");
		}
		
		sql.append(" ORDER BY NOMBRE");

		//Asginado identificador de indentidad incorrecto
		IItemCollection itemcol = catalogAPI.queryCTEntities(
				ICatalogAPI.ENTITY_P_SUBPROCEDURE, sql.toString());
		
		return CollectionBean.getBeanList(itemcol);
	}
}