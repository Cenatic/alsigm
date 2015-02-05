package valoracion.db;

import common.db.IDBEntity;

/**
 * Metodos de acceso a datos referentes al numero de version para las
 * valoraciones de series documentales <br>
 * Entidad: <b>ASGFNUMSECVAL</b>
 */
public interface INSecVersionDBEntity extends IDBEntity {

	/**
	 * Obtiene el n�mero de versi�n de la �ltima valoracion realizada sobre la
	 * serie
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @return N�mero de versi�n de la �ltima valoraci�n realizada sobre la
	 *         serie
	 */
	public int getCurrentVersion(String idSerie);

	/**
	 * Incrementa el n�mero de versi�n de las valoraciones de una serie.
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @return Nuevo n�mero de versi�n.
	 */
	public int incrementarNumeroVersion(String idSerie);

	/**
	 * Decrementar el n�mero de versi�n de las valoraciones de una serie.
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @return Nuevo n�mero de versi�n.
	 */
	public int decrementarNumeroVersion(String idSerie);

}