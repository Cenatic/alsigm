/*
 * Documentos.java
 *
 * Created on 23 de mayo de 2007, 15:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ieci.tecdoc.sgm.nt.database.datatypes;

/**
 *
 * @author Usuario
 */
public class Documentos  implements java.io.Serializable {
	
	private java.util.ArrayList documentos;

	public Documentos() {
		documentos = new java.util.ArrayList();
	}

	/**
	 * Devuelve el n�mero de notificaciones de la colecci�n.
	 * @return int N�mero de notificaciones de la colecci�n.
	 */
	public int count() {
		return documentos.size();
	}

	/**
	 * Devuelve la notificacion de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n la notificacion a recuperar.
	 * @return Expediente asociado a registro.
	 */
	public Documento get(int index) {
		return (Documento) documentos.get(index);
	}

	/**
	 * A�ade una nueva notificacion a la colecci�n.
	 * @param expediente Nueva notificacion a a�adir.
	 */
	public void add(Documento nuevoValor_) {
		documentos.add(nuevoValor_);
	}
}
