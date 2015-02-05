package descripcion.db;

import java.util.List;

import common.db.IDBEntity;

import descripcion.vos.TextoTablaValidacionVO;

/**
 * Interfaz de comportamiento para la entidad de acceso a las listas de
 * validaci�n. <br>
 * Entidad: <b>ADTEXTTBLVLD</b>
 */
public interface IValidacionDBEntity extends IDBEntity {
	/**
	 * Obtiene la lista de valores de una tabla de validaci�n.
	 * 
	 * @param idTblVld
	 *            Identificador de la tabla de validaci�n.
	 * @return Lista de valores.
	 */
	public abstract List getValoresTablaValidacion(String idTblVld);

	/**
	 * Obtiene el valor de la tabla de validaci�n.
	 * 
	 * @param id
	 *            Identificador del valor de la tabla de validaci�n.
	 * @return Valor de la tabla de validaci�n.
	 */
	public TextoTablaValidacionVO getValorTablaValidacion(String id);

	/**
	 * Obtiene un valor de la tabla de la validaci�n por su nombre y por su id
	 * de la tabla de validaci�n
	 * 
	 * @param valor
	 * @param idTblvld
	 * @return
	 */
	public TextoTablaValidacionVO getValorTablaValidacionByValor(String valor,
			String idTblvld);

	/**
	 * Crea un valor de la tabla de validaci�n.
	 * 
	 * @param valor
	 *            Valor de la tabla de validaci�n.
	 * @return Valor insertado.
	 */
	public TextoTablaValidacionVO insert(final TextoTablaValidacionVO valor);

	/**
	 * Modifica el valor de la tabla de validaci�n.
	 * 
	 * @param valor
	 *            Valor de la tabla de validaci�n.
	 */
	public void update(TextoTablaValidacionVO valor);

	/**
	 * Elimina un valor de una tabla de validaci�n.
	 * 
	 * @param id
	 *            Identificador del valor de una tabla de validaci�n.
	 */
	public void delete(String id);

	/**
	 * Elimina los valores de una tabla de validaci�n.
	 * 
	 * @param listaIds
	 *            Lista de identificadores de valores de una tabla de
	 *            validaci�n.
	 */
	public void delete(String[] listaIds);

	/**
	 * Elimina los valores de una tabla de validaci�n.
	 * 
	 * @param listaIds
	 *            Lista de identificadores de tablas de validaci�n.
	 */
	public void deleteByVldTblIds(String[] listaIds);

	/**
	 * Elimina los valores de una tabla de validaci�n.
	 * 
	 * @param idTblVld
	 *            Identificador de la tabla de validaci�n.
	 */
	public void deleteByVldTblId(String idTblVld);

}