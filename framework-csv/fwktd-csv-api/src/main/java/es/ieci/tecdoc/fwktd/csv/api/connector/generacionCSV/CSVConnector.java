package es.ieci.tecdoc.fwktd.csv.api.connector.generacionCSV;

import es.ieci.tecdoc.fwktd.csv.api.connector.Connector;
import es.ieci.tecdoc.fwktd.csv.core.vo.InfoDocumentoCSVForm;

/**
 * Interfaz para los conectores de generaci�n de C�digos Seguros de Verificaci�n
 * (CSV).
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public interface CSVConnector extends Connector {

	/**
	 * Genera el CSV para un documento.
	 *
	 * @param infoDocumentoForm
	 *            Informaci�n del documento.
	 * @return C�digo Seguro de Verificaci�n (CSV)
	 */
	public String generarCSV(InfoDocumentoCSVForm infoDocumentoForm);

}
