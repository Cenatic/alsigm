package descripcion.db;

import java.util.List;

import common.db.IDBEntity;

import descripcion.vos.TablaValidacionVO;

/**
 * Entidad: <b>ADCTLGTBLVLD</b>
 * 
 * @author IECISA
 * 
 */
public interface ITablaValidacionDBEntity extends IDBEntity {

	/**
	 * Obtiene la lista de tablas de validaci�n.
	 * 
	 * @return Lista de tablas de validaci�n.
	 */
	public abstract List getTablasValidacion();

	/**
	 * Obtiene la tabla de validaci�n.
	 * 
	 * @param id
	 *            Identificador de la tabla de validaci�n.
	 * @return Tabla de validaci�n.
	 */
	public TablaValidacionVO getTablaValidacion(String id);

	TablaValidacionVO getTablaValidacionByNombre(String nombre);

	/**
	 * Crea una tabla de validaci�n.
	 * 
	 * @param tablaValidacion
	 *            Tabla de validaci�n.
	 * @return Tabla de validaci�n insertada.
	 */
	public TablaValidacionVO insert(TablaValidacionVO tablaValidacion);

	/**
	 * Modifica la tabla de validaci�n.
	 * 
	 * @param tablaValidacion
	 *            Tabla de validaci�n.
	 */
	public void update(TablaValidacionVO tablaValidacion);

	/**
	 * Elimina las tablas de validaci�n.
	 * 
	 * @param listaIds
	 *            Lista de identificadores de tablas de validaci�n.
	 */
	public void delete(String[] listaIds);

	/**
	 * Elimina la tabla de validaci�n.
	 * 
	 * @param id
	 *            Identificador de la tabla de validaci�n.
	 */
	public void delete(String id);

}