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
public class FicherosHito extends ArrayList implements Serializable {
	
//	private ArrayList ficheros;

	/**
	 * Constructor de clase
	 *
	 */
	public FicherosHito() {
//		ficheros = new ArrayList();
	}

	/**
	 * Devuelve el n�mero de interesados de la colecci�n.
	 * @return int N�mero de interesados de la colecci�n.
	 */
	public int count() {
		return super.size();
	}

	/**
	 * Devuelve el interesado de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del interesado a recuperar.
	 * @return Interesado asociado a registro.
	 */
	public Object get(int index) {
		return (FicheroHito) super.get(index);
	}

	/**
	 * A�ade un nuevo interesado a la colecci�n.
	 * @param fichero Nuevo interesado a a�adir.
	 */
	public void add(FicheroHito fichero) {
		super.add(fichero);
	}

}
