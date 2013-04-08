package ieci.tecdoc.sgm.ct.database.datatypes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de interesados asociados a un expediente.
 * 
 * @author Javier Septi�n Arceredillo
 *
 * Fecha de Creaci�n: 14-may-2007
 */
public class Interesados implements Serializable {
	
	private ArrayList interesados;
	
	/**
	 * Constructor de clase
	 */
	public Interesados() {
		interesados = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return interesados.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Expediente get(int index) {
		return (Expediente) interesados.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param interesado Nuevo interesado a a�adir.
	 */
	public void add(Interesado interesado) {
		interesados.add(interesado);
	}

}
