package docelectronicos.db;

import java.util.List;
import java.util.Map;

import common.db.IDBEntity;

import docelectronicos.vos.DocDocumentoVO;

/**
 * Entidad: <b>ADOCDOCUMENTOCF</b>
 *
 * @author IECISA
 *
 */
public interface IDocDocumentoCFDBEntity extends IDBEntity {
	/**
	 * Obtiene la lista de documentos electr�nicos de un elemento del cuadro de
	 * clasificaci�n.
	 *
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param idClfPadre
	 *            Identificador del clasificador padre.
	 * @param estados
	 *            Lista de estados de los documentos.
	 * @return Listas de documentos electr�nicos.
	 */

	public List getDocumentos(String idElementoCF, String idClfPadre,
			int[] estados);

	public List getDocumentos(String idElementoCF, int[] estados);

	/**
	 * Cuenta el n�mero de documentos asociados a un elemento del cuadro de
	 * clasificaci�n
	 *
	 * @param idElementoCF
	 *            Identificador de elemento del cuadro de clasificaci�n
	 * @return N�mero de documentos asociados al elemento
	 */
	public int countNumDocumentos(String idElementoCF);

	/**
	 * Obtiene la lista de documentos electr�nicos de un elemento del cuadro de
	 * clasificaci�n.
	 *
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @return Listas de documentos electr�nicos.
	 */
	public List getDocumentos(String idElementoCF);

	/**
	 * Obtiene el documento electr�nico.
	 *
	 * @param id
	 *            Identificador del documento electr�nico.
	 * @return Documento electr�nico.
	 */
	public DocDocumentoVO getDocumento(String id);

	/**
	 * Crea un documento electr�nico.
	 *
	 * @param documento
	 *            Documento electr�nico.
	 * @return Documento.
	 */
	public DocDocumentoVO insertDocumento(DocDocumentoVO documento);

	/**
	 * Modifica un documento electr�nico.
	 *
	 * @param documento
	 *            Documento electr�nico.
	 */
	public void updateDocumento(DocDocumentoVO documento);

	/**
	 * Elimina un documento electr�nico.
	 *
	 * @param id
	 *            Identificador del documento electr�nico.
	 */
	public void deleteDocumento(String id);

	/**
	 * Elimina los documentos de un elemento del cuadro de clasificaci�n.
	 *
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 */
	public void deleteDocumentos(String idElementoCF);

	/**
	 *
	 * @param idObj
	 * @param estadosAActualizar
	 * @param nuevoEstado
	 */
	public void update(String idObj, int[] estadosAActualizar, int nuevoEstado);

	/**
	 * Obtiene el n�mero de documentos almacenados en un dep�sito electr�nico.
	 *
	 * @param idExtDeposito
	 *            Identificador externo del dep�sito electr�nico.
	 * @return N�mero de documentos.
	 */
	public int getCountDocumentosByIdExtDeposito(String idExtDeposito);

	/**
	 * Obtiene la lista de documentos electr�nicos de un elemento del cuadro de
	 * clasificaci�n.
	 *
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param idClfPadre
	 *            Identificador del clasificador padre.
	 * @return Listas de documentos electr�nicos.
	 */
	public int getCountDocumentosByIdClfPadre(String idElementoCF,
			String idClfPadre);

	/**
	 * Obtiene un Map cuyas claves son los ids de elementos del cuadro y sus
	 * valores la lista de identificadores de documentos electr�nicos asociados
	 * a una lista de elementos del cuadro de clasificaci�n.
	 *
	 * @param idsElementosCF
	 *            Identificador de la lista de ids de elementos del cuadro de
	 *            clasificaci�n.
	 * @return Listas de identificadores de documentos electr�nicos.
	 */
	public Map getDocumentos(List idsElementosCF);

	/**
	 * Obtiene el documento electr�nico.
	 *
	 * @param id
	 *            Identificador interno del documento
	 * @return Documento electr�nico.
	 */
	public DocDocumentoVO getDocumentoByIdInterno(String idInterno);

	public void updateIdElementocf(String idElementocfAntiguo,
			String idElementoCfNuevo, String[] idsInternosDocumentos);
}