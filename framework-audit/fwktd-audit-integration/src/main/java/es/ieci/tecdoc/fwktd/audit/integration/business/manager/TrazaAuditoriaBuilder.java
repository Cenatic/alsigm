package es.ieci.tecdoc.fwktd.audit.integration.business.manager;

import java.util.List;

import es.ieci.tecdoc.fwktd.audit.core.vo.TrazaAuditoriaVO;
import es.ieci.tecdoc.fwktd.audit.integration.business.vo.AuditEventVO;

/**
 * Interface encargado de generar una lista de trazas de auditor�a a partir de
 * un evento de auditoria generado en una aplicaci�n
 * 
 * Cada aplicaci�n tendr� su propia jerarqu�a de objetos de tipo
 * {@link AuditEventVO} y tendr� que implementar este inteface
 * TrazaAuditoriaBuilder, ya que las aplicaciones son las que conocen el numero
 * y tipo de trazas a generar por un evento generado en ellas. Un evento
 * producido en una aplicaci�n puede generar varias trazas de auditoria.
 * Ejemplo: Un evento de creaci�n de un registro puede generar: 1 Traza de
 * creaci�nn de registro, n Trazas de creacion de campos de registro
 * 
 * @author Iecisa
 * 
 */
public interface TrazaAuditoriaBuilder {

	/**
	 * Metodo encargado de generar una lista de trazas de auditor�a a partir de
	 * un evento de auditoria generado en una aplicaci�n
	 * 
	 * @param eventoAuditar
	 * @return
	 */
	public List<TrazaAuditoriaVO> buildTrazas(AuditEventVO eventoAuditar);
}
