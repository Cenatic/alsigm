/*
 * Notificaciones.java
 *
 * Created on 18 de mayo de 2007, 12:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ieci.tecdoc.sgm.nt.database.datatypes;

/**
 *
 * Contenedor / Manejador de una coleccion de Notificacion 
 */
public class Notificaciones implements java.io.Serializable {
	
	private java.util.ArrayList notificaciones;

	public Notificaciones() {
		notificaciones = new java.util.ArrayList();
	}

	/**
	 * Devuelve el n�mero de notificaciones de la colecci�n.
	 * @return int N�mero de notificaciones de la colecci�n.
	 */
	public int count() {
		return notificaciones.size();
	}

	/**
	 * Devuelve la notificacion de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n la notificacion a recuperar.
	 * @return Expediente asociado a registro.
	 */
	public Notificacion get(int index) {
		return (Notificacion) notificaciones.get(index);
	}

	/**
	 * A�ade una nueva notificacion a la colecci�n.
	 * @param expediente Nueva notificacion a a�adir.
	 */
	public void add(Notificacion nuevoValor_) {
		notificaciones.add(nuevoValor_);
	}
	
	public void addAll(Notificaciones notificaciones){
		this.notificaciones.addAll(notificaciones.notificaciones);
	}

}