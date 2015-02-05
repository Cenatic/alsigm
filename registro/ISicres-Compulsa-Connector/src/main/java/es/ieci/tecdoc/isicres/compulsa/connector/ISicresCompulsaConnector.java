package es.ieci.tecdoc.isicres.compulsa.connector;

import es.ieci.tecdoc.isicres.compulsa.connector.vo.ISicresAbstractCompulsaVO;

/**
 * @author Iecisa
 * @version $Revision$
 *
 */

public interface ISicresCompulsaConnector {

	/**
	 * M�todo para compulsar documentos
	 *
	 * @param iSicresAbstractCompulsaVO
	 * @return
	 */
	public ISicresAbstractCompulsaVO compulsar(
			ISicresAbstractCompulsaVO iSicresAbstractCompulsaVO);

	/**
	 * M�todo para generar el localizador del documento
	 *
	 * @param compulsaVO
	 * @return
	 */
	public ISicresAbstractCompulsaVO generateLocator(
			ISicresAbstractCompulsaVO compulsaVO);

	/**
	 * M�todo para generar el fichero .xades necesario para la compulsa
	 *
	 * @param compulsaVO
	 */
	public void generateXadesDocument(ISicresAbstractCompulsaVO compulsaVO);

}
