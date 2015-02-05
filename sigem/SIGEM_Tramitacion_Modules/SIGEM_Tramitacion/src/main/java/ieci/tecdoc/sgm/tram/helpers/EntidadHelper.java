package ieci.tecdoc.sgm.tram.helpers;

import ieci.tdw.ispac.ispaclib.session.OrganizationUser;
import ieci.tdw.ispac.ispaclib.session.OrganizationUserInfo;
import ieci.tecdoc.sgm.core.services.dto.Entidad;


/**
 * Utilidad para gestionar la informaci�n de la entidad en el thread local.
 *
 */
public class EntidadHelper {

	/**
	 * Establece la entidad en el thread local.
	 * @param entidad Informaci�n de la entidad.
	 */
	public static void setEntidad(Entidad entidad) {

		OrganizationUserInfo info = null;
		
		if (entidad != null) {
			info = new OrganizationUserInfo();
			info.setOrganizationId(entidad.getIdentificador());
			info.setOrganizationName(entidad.getNombre());
		}

		// Establece la entidad en el thread local
		OrganizationUser.setOrganizationUserInfo(info);
	}
	
	/**
	 * Obtiene la entidad del thread local.
	 * @return Informaci�n de la entidad.
	 */
	public static Entidad getEntidad() {
		Entidad entidad = null;

		// Informaci�n de la entidad en el thread local
		OrganizationUserInfo orgUserInfo = OrganizationUser.getOrganizationUserInfo();
		if (orgUserInfo != null) {
			entidad = new Entidad();
			entidad.setIdentificador(orgUserInfo.getOrganizationId());
			entidad.setNombre(orgUserInfo.getOrganizationName());
		}

		return entidad;
	}
}
