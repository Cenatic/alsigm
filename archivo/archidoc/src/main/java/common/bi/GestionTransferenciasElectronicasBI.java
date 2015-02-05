package common.bi;

import transferencias.vos.TransferenciaElectronicaInfo;

import common.exceptions.TransferenciaElectronicaException;


/**
 * Gesti�n de Transferencias Electr�nicas
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface GestionTransferenciasElectronicasBI {

	public boolean transferirExpedienteElectronicoConDocumentos(TransferenciaElectronicaInfo transferenciaElectronicaInfo) throws TransferenciaElectronicaException;
}
