package es.ieci.tecdoc.fwktd.audit.integration.business.manager;

import es.ieci.tecdoc.fwktd.audit.core.vo.AppAuditoriaVO;
import es.ieci.tecdoc.fwktd.audit.core.vo.TrazaAuditoriaVO;
import es.ieci.tecdoc.fwktd.audit.integration.business.manager.impl.AuditoriaAplicationManagerImpl;
import es.ieci.tecdoc.fwktd.audit.integration.business.vo.AuditEventVO;

/**
 * Interface de integraci�n en las aplicaciones del sistema de auditoria Se
 * encargar� de realizar las auditorias correspondientes. Cada aplicaci�n tendr�
 * su propia jerarqu�a de objetos de tipo {@link AuditEventVO}
 * 
 * Un evento producido en una aplicaci�n puede generar varias trazas de
 * auditoria {@link TrazaAuditoriaVO} 
 * 
 * Ejemplo: Un evento de creaci�n de un
 * registro puede generar: 1 Traza de creaci�nn de registro, n Trazas de creacion
 * de campos de registro
 * 
 * 
 * @author IECISA
 * 
 *         Implementaci�n abstracta disponible para usar en las aplicaciones:
 * 
 * @see {@link AuditoriaAplicationManagerImpl}
 */
public interface AuditoriaAplicationManager {

	/**
	 * Audita el evento producido por la aplicacion
	 * 
	 * @param evento
	 */
	public void audit(AuditEventVO evento);
	
	/**
	 * Obtiene las aplicaciones registradas en la tabla de auditor�as a partir de su descripci�n.
	 * 
	 * Las aplicaciones registradas tienen que tener una descripci�n y un identificador �nico
	 * @param descripcion
	 * @return
	 */
	public AppAuditoriaVO getAppAuditoria(String descripcion);

}
