package ieci.tecdoc.sgm.core.admin.web;

import java.util.Date;

import ieci.tecdoc.sgm.core.exception.SigemException;
import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.dto.Entidad;
import ieci.tecdoc.sgm.core.services.sesionadmin.ServicioSesionAdministracion;
import ieci.tecdoc.sgm.core.services.sesionadmin.ServicioSesionAdministracionException;
import ieci.tecdoc.sgm.core.services.sesionadmin.SesionAdministracion;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class SesionAdminHelper {

	private static final Logger logger = Logger.getLogger(SesionAdminHelper.class);
	
	public static boolean autenticarUsuario(HttpServletRequest request){
		//TODO Parche para saltarse la validaci�n
		SesionAdministracion oSesionDummy = new SesionAdministracion();
		oSesionDummy.setFechaLogin(new Date());
		oSesionDummy.setFechaActualizacion(new Date());
		oSesionDummy.setIdEntidad("00001");
		oSesionDummy.setIdUsuario("sigem");
		oSesionDummy.setIdSesion("DUMMYID");
		guardarSesionAdminitracion(request, oSesionDummy);
		if(true)
			return true;
		//Fin parche para saltarse la validaci�n
		
		if( (request.getSession().getAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION) != null)
				&&(!"".equals(request.getSession().getAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION)))
		){
			// Ya existe una sesi�n de administraci�n iniciada.
			if( (obtenerIdentificadorEntidad(request) == null) || ("".equals(obtenerIdentificadorEntidad(request)))){
				return false;
			}
			return true;
		}else if(	( (request.getParameter(ConstantesSesionAdmin.ID_SESION_PARAMETRO) != null)
						&&(!"".equals(request.getParameter(ConstantesSesionAdmin.ID_SESION_PARAMETRO)))
					) || ( (request.getAttribute(ConstantesSesionAdmin.ID_SESION_PARAMETRO) != null)
					&&(!"".equals((String)request.getAttribute(ConstantesSesionAdmin.ID_SESION_PARAMETRO)))
					)
			){
				// Nos llega el identificador de sesi�n como par�metro en la petici�n.
				String sesionAdmin = request.getParameter(ConstantesSesionAdmin.ID_SESION_PARAMETRO);
				if(sesionAdmin == null){
					sesionAdmin = (String)request.getAttribute(ConstantesSesionAdmin.ID_SESION_PARAMETRO);
				}
				
				ServicioSesionAdministracion oServicio = null;
				try {
					oServicio = LocalizadorServicios.getServicioSesionAdministracion();
				} catch (SigemException e) {
					logger.fatal("Error obteniendo el servicio de sesi�n de administraci�n.");
					return false;
				}
				SesionAdministracion oSesion = null;				
				try {
					oSesion = oServicio.obtenerSesion(sesionAdmin);
				} catch (ServicioSesionAdministracionException e) {
					StringBuffer sbError = new StringBuffer("Error obteniendo sesi�n de administraci�n. ID:");
					sbError.append(sesionAdmin);
					logger.error(sbError.toString());
					return false;					
				}
				// Ya existe una sesi�n de administraci�n iniciada.
				if( (oSesion == null) || (oSesion.getIdEntidad() == null) || ("".equals(oSesion.getIdEntidad()))){
					return false;
				}
				guardarSesionAdminitracion(request, oSesion);
				return true;
		}
		return false;
	}
	
	public static void guardarSesionAdminitracion(HttpServletRequest request, SesionAdministracion poSesion){
		request.getSession().setAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION, poSesion);
	}
	
	public static SesionAdministracion obtenerSesionAdminitracion(HttpServletRequest request){
		return (SesionAdministracion)request.getSession().getAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION);
	}
	
	public static String obtenerIdentificadorEntidad(HttpServletRequest request){
		SesionAdministracion oSesion = (SesionAdministracion)request.getSession().getAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION);
		return oSesion.getIdEntidad();
	}

	public static Entidad obtenerEntidad(HttpServletRequest request){
		SesionAdministracion oSesion = (SesionAdministracion)request.getSession().getAttribute(ConstantesSesionAdmin.ID_SESION_ADMINISTRACION);
		Entidad entidad = new Entidad();
		entidad.setIdentificador(oSesion.getIdEntidad());
		return entidad;
	}
}
