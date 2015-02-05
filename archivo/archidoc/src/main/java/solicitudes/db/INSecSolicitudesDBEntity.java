package solicitudes.db;

import common.db.IDBEntity;

/**
 * Entidad: <b>ASGFSNSEC</b> <br>
 * Entidad: <b>ASGPSNSEC</b> <br>
 * Entidad: <b>ASGTSNSEC</b>
 * 
 * @author IECISA
 * 
 */
public interface INSecSolicitudesDBEntity extends IDBEntity {
	/**
	 * Incrementa el numero de secuencia para la tabla de prestamos.
	 * 
	 * @param ano
	 *            A�o de creaci�n del numero de secuencia
	 * @return Nuevo numero de la secuencia.
	 */
	public abstract int incrementarNumeroSecConsulta(String ano);

	/**
	 * Incrementa el numero de secuencia para la tabla de consultas.
	 * 
	 * @param ano
	 *            A�o de creaci�n del numero de secuencia
	 * @return Nuevo numero de la secuencia.
	 */
	public abstract int incrementarNumeroSecPrestamo(String ano);
}