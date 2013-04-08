package docvitales.db;

import common.db.IDBEntity;

import docvitales.vos.UsoDocumentoVitalVO;

/**
 * Interfaz para acceder a la tabla que relaciona los documentos vitales con los
 * expedientes. <br>
 * Entidad: <b>ADPCUSODOCVIT</b>
 */
public interface IUsoDocumentoVitalDBEntity extends IDBEntity {

	/**
	 * Comprueba si un expediente est� referenciando el documento vital.
	 * 
	 * @param idDocVit
	 *            Identificador del documento vital.
	 * @param idExp
	 *            Identificador del expediente de backoffice.
	 * @param idSist
	 *            Identificador del sistema de backoffice.
	 * @return true si el expediente utiliza en documento vital.
	 */
	public boolean existeUso(String idDocVit, String idExp, String idSist);

	/**
	 * Inserta la informaci�n de uso de un documento vital.
	 * 
	 * @param uso
	 *            Informaci�n de uso.
	 */
	public void insertUsoDocumentoVital(UsoDocumentoVitalVO uso);

	/**
	 * Elimina la informaci�n de uso de documentos vitales.
	 * 
	 * @param idExp
	 *            Identificador del expediente de backoffice.
	 * @param idSist
	 *            Identificador del sistema de backoffice.
	 */
	public void deleteUsos(String idExp, String idSist);
}