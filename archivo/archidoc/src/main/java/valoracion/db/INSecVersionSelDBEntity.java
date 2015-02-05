package valoracion.db;

import common.db.IDBEntity;

/**
 * Metodos de acceso a datos referentes al numero de version para las
 * selecciones de series documentales. <br>
 * Entidad: <b>ASGFNUMSECSEL</b>
 */
public interface INSecVersionSelDBEntity extends IDBEntity {

	/**
	 * Obtiene el n�mero de versi�n de la �ltima selecci�n realizada sobre la
	 * serie.
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @return N�mero de versi�n de la �ltima selecci�n realizada sobre la
	 *         serie.
	 */
	public int getCurrentVersion(String idSerie);

	/**
	 * Incrementa el n�mero de versi�n de las selecciones de una serie.
	 * 
	 * @param idSerie
	 *            Identificador de serie
	 * @return Nuevo n�mero de versi�n.
	 */
	public int incrementarNumeroVersion(String idSerie);

}