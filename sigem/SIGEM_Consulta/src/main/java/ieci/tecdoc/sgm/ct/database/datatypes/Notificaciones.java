package ieci.tecdoc.sgm.ct.database.datatypes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de interesados asociados a un expediente.
 * 
 * @author Jose Antonio Nogales
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Notificaciones extends ArrayList implements Serializable {
	
	private ArrayList notificaciones;

	/**
	 * Constructor de clase
	 *
	 */
	public Notificaciones() {
		notificaciones = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return notificaciones.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Object get(int index) {
		return (Notificacion) notificaciones.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(Notificacion fichero) {
		notificaciones.add(fichero);
	}

}
