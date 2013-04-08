package transferencias.model;

import java.util.Locale;

import transferencias.vos.PrevisionVO;
import transferencias.vos.RelacionEntregaVO;
import transferencias.vos.UnidadDocumentalVO;
import transferencias.vos.UnidadInstalacionVO;

public interface IAuditoriaTransferencias {

	/**
	 * Audita la creaci�n de una relaci�n
	 * 
	 * @param relacionVO
	 *            Relaci�n de entrega
	 */
	public void auditaCreacionRelacion(Locale locale,
			RelacionEntregaVO relacionVO);

	/**
	 * A�ade un detalle basico para una relaci�n de entrega
	 * 
	 * @param relacionVO
	 *            Relaci�n de entrega
	 * @param propertyTipoEdicion
	 *            Property de Edici�n
	 */
	public void addDetalleBasico(Locale locale, RelacionEntregaVO relacionVO,
			String propertyTipoEdicion);

	public void addDetalleBasico(Locale locale, RelacionEntregaVO relacionVO);

	/**
	 * Audita el alta de una nueva unidad documental con signatura
	 * 
	 * @param udoc
	 *            Unidad documental a auditar
	 */
	public void auditaNuevaUnidadDocumentalConSignatura(Locale locale,
			UnidadDocumentalVO udoc);

	/**
	 * Audita la modificaci�n de una unidad documental
	 * 
	 * @param udoc
	 *            Unidad documental a auditar
	 */
	public void auditaModificacionUnidadDocumental(Locale locale,
			UnidadDocumentalVO udoc);

	public void addNewDetalleBasico(Locale locale, RelacionEntregaVO relacionVO);

	public void auditaEliminarUnidadDocumental(Locale locale,
			String udocsBorradas);

	public void auditaBloquearUnidadDocumental(Locale locale,
			String udocsBorradas);

	public void auditaDesbloquearUnidadDocumental(Locale locale,
			String udocsBorradas);

	public void auditaModificacionDestinoRelacion(Locale locale,
			String nombreDeposito);

	public void auditaEnviarRelacion(Locale locale, PrevisionVO prevision,
			String nExpedientes);

	public void auditaEnviarRelacionEA(Locale locale,
			RelacionEntregaVO relacionEntregaVO, String numUInst,
			String numUdocsElectronicos);

	void auditaUnidadInstalacion(Locale locale, UnidadInstalacionVO uinst);

	void auditaUnidadInstalacion(Locale locale, String id);

	void auditaUInstValidacionRelacion(Locale locale, String uInstValidadas);

	void auditaElectronicosValidacionRelacion(Locale locale,
			String idsUDocsElectronicos);
}
