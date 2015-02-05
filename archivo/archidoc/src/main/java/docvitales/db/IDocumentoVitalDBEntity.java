package docvitales.db;

import java.util.List;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;

import docvitales.vos.BusquedaDocumentosVitalesVO;
import docvitales.vos.InfoBDocumentoVitalExtVO;

/**
 * Interfaz para acceder a la tabla de documentos vitales. <br/>
 * Entidad: <b>ADPCDOCUMENTOVIT</b>
 */
public interface IDocumentoVitalDBEntity extends IDBEntity {

	/**
	 * Devuelve el n�mero de documentos vitales en ciertos estados.
	 * 
	 * @param estados
	 *            Estados a buscar
	 * @return N�mero de documentos vitales
	 */
	public int getCountDocumentosVitalesXEstados(int[] estados);

	/**
	 * Realiza la b�squeda de documentos vitales.
	 * 
	 * @param busquedaVO
	 *            Criterios de b�squeda.
	 * @return Lista de documentos vitales ({@link InfoBDocumentoVitalExtVO}).
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getDocumentosVitales(BusquedaDocumentosVitalesVO busquedaVO)
			throws TooManyResultsException;

	/**
	 * Obtiene la lista de documentos vitales vigentes de un tercero.
	 * 
	 * @param idTercero
	 *            Identificador del tercero.
	 * @param idProc
	 *            Identificador de procedimiento. Si es nulo, ignora este
	 *            criterio.
	 * @return Lista de documentos vitales ({@link InfoBDocumentoVitalExtVO}.
	 */
	public List getDocumentosVitalesVigentes(String idTercero, String idProc);

	/**
	 * Obtiene el documento vital.
	 * 
	 * @param id
	 *            Identificador del documento vital.
	 * @return Documento vital.
	 */
	public InfoBDocumentoVitalExtVO getDocumentoVital(String id);

	/**
	 * Obtiene el documento vital.
	 * 
	 * @param idTercero
	 *            Identificador del tercero.
	 * @param idTipoDocVit
	 *            Identificador del tipo de documento vital.
	 * @param estado
	 *            Estado del documento vital.
	 * @return Documento vital.
	 */
	public InfoBDocumentoVitalExtVO getDocumentoVital(String idTercero,
			String idTipoDocVit, int estado);

	/**
	 * Inserta un de documento vital.
	 * 
	 * @param documentoVital
	 *            Documento vital.
	 * @return Identificador del documento vital.
	 */
	public String insertDocumentoVital(InfoBDocumentoVitalExtVO documentoVital);

	/**
	 * Modifica la informaci�n de un documento vital.
	 * 
	 * @param documentoVital
	 *            Documento vital.
	 */
	public void updateDocumentoVital(InfoBDocumentoVitalExtVO documentoVital);

	/**
	 * Modifica el estado de un documento vital.
	 * 
	 * @param idDocVit
	 *            Identificador del documento vital.
	 * @param estado
	 *            Estado del documento vital.
	 */
	public void updateEstadoDocumentoVital(String idDocVit, int estado);

	/**
	 * Modifica el identificador de ficher de un documento vital.
	 * 
	 * @param id
	 *            Identificador del documento vital.
	 * @param idFich
	 *            Identificador del fichero.
	 */
	public void updateIdFichDocumentoVital(String id, String idFich);

	/**
	 * Elimina un documento vital.
	 * 
	 * @param id
	 *            Identificador del documento vital.
	 */
	public void deleteDocumentoVital(String id);

	/**
	 * Obtiene el n�mero de documentos vitales de un tipo en concreto.
	 * 
	 * @param idTipoDocVit
	 *            Identificador del tipo de documento vital.
	 * @return N�mero de documentos vitales.
	 */
	public int getCountDocumentosVitalesByTipo(String idTipoDocVit);

	/**
	 * Pasa a hist�ricos los documentos vigentes de un tercero.
	 * 
	 * @param idTercero
	 *            Identificador del tercero.
	 */
	public void pasaAHistoricoDocsVigentes(String idTercero);

	/**
	 * Obtiene la lista de documentos vitales vigentes que han caducado.
	 * 
	 * @return Lista de documentos vitales.
	 */
	public List getDocumentosVigentesCaducados();

	/**
	 * Obtiene la lista de documentos vitales eliminables, es decir, que han
	 * caducado y no se est�n usando en ning�n expediente.
	 * 
	 * @return Lista de documentos vitales.
	 */
	public List getDocumentosEliminables();

}