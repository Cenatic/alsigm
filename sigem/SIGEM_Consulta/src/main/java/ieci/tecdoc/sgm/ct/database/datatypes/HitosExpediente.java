package ieci.tecdoc.sgm.ct.database.datatypes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de Hitos de uno o mas expedientes.
 * 
 * @author IECISA
 *
 */
public class HitosExpediente extends ArrayList implements Serializable {
	
	/**
	 * Constructor de clase
	 */

	public HitosExpediente() {
		
	}

	/**
	 * Devuelve el n�mero de hitos de la colecci�n.
	 * @return int N�mero de hitos de la colecci�n.
	 */
	public int count() {
		return super.size();
	}

	/**
	 * Devuelve el hito de la posici�n indicada dentro de la colecci�n
	 * @param index Posici�n del hito a recuperar.
	 * @return Hito asociado a registro.
	 */
	public Object get(int index) {
		return (HitoExpediente)super.get(index);
	}

	/**
	 * A�ade un nuevo hito a la colecci�n.
	 * @param hito Nuevo expediente a a�adir.
	 */
	public void add(HitoExpediente hito) {
		super.add(hito);
	}

}
