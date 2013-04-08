package solicitudes.db;

import java.util.List;

import solicitudes.prestamos.vos.RevisionDocumentacionVO;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;

/**
 * Entidad: <b>ASGPREVDOCUDOC</b>
 * 
 * @author IECISA
 * 
 */
public interface IRevisionDocumentacionDBEntity extends IDBEntity {

	/**
	 * Inserta la revisi�n de la Documentaci�n
	 * 
	 * @param revDocVO
	 */
	public void insertRevisionDocumentacion(RevisionDocumentacionVO revDocVO);

	/**
	 * Obtiene todas revisiones de documentaci�n existentes.
	 * 
	 * @return Lista de {@link RevisionDocumentacionVO}
	 */
	public List getAllRevisionDocumentacion();

	/**
	 * Obtiene todas revisiones de documentaci�n que tengan el estado pasado por
	 * parametro.
	 * 
	 * @param idUserGestor
	 *            String
	 * @param estado
	 *            int
	 * @return Lista de {@link RevisionDocumentacionVO}
	 */
	public List getRevisionDocumentacionByEstado(String idUserGestor, int estado);

	/**
	 * Obtiene la revisi�n cuyo id coincide con el que se le pasa
	 * 
	 * @param idRevDoc
	 *            Identificador de la revisi�n de la documentaci�n
	 * @return {@link RevisionDocumentacionVO}
	 */
	public RevisionDocumentacionVO getRevisionDocumentacionById(String idRevDoc);

	/**
	 * Obtiene la revisi�n cuyo idAlta concide con el que se le pasa
	 * 
	 * @param idAlta
	 *            Identificador del alta de unidad documental
	 * @return {@link RevisionDocumentacionVO}
	 */
	public RevisionDocumentacionVO getRevisionDocumentacionByIdAlta(
			String idAlta);

	/**
	 * Obtiene las revisiones cuyo idUdoc concide con el que se le pasa y que
	 * est�n en cierto estado
	 * 
	 * @param idUdoc
	 *            Identificador de la unidad documental
	 * @param estados
	 *            Estados de revisiones
	 * @return Lista de {@link RevisionDocumentacionVO}
	 */
	public List getRevisionesDocumentacionByIdUdocYEstado(String idUdoc,
			int[] estados);

	/**
	 * Actualiza el registro
	 * 
	 * @param revDocVO
	 *            Objeto con los valores para actualizar
	 */
	public void update(RevisionDocumentacionVO revDocVO);

	/**
	 * Actualiza el Identificador del Alta al con el que est� relacionado.
	 * 
	 * @param idRevDoc
	 *            Identificador de la Revisi�n de Documentaci�n
	 * @param idAlta
	 *            Identficador del Alta de Unidades Documentales.
	 */
	public void updateIdAlta(String idRevDoc, String idAlta);

	/**
	 * Establece a Null el valor de IdAlta.
	 * 
	 * @param idAlta
	 *            Identificador del Alta.
	 */
	public void removeIdAlta(String idAlta);

	/**
	 * Devuelve el n�mero de documentacion a revisar en unos estados
	 * determinados.
	 * 
	 * @param idUser
	 *            String
	 * @param estados
	 *            int[]
	 * @return N�mero de documentacion en revision en estados determinados
	 */
	public int getCountRevisionDocXEstados(String idUser, int[] estados);

	List getGestoresConRevisionesDocumentacion();

	List getRevisionesDocumentacion(RevisionDocumentacionVO revDocVo)
			throws TooManyResultsException;
}