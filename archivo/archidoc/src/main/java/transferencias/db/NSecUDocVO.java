package transferencias.db;

/**
 * VO para el n�mero secuencial de Unidad documental
 */
public class NSecUDocVO {

	/**
	 * N�mero secuencial
	 */
	int numsec;

	/**
	 * Constructor
	 */
	public NSecUDocVO(int numsec) {
		this.numsec = numsec;
	}

	/**
	 * Permite obtener el n�mero secuencial
	 * 
	 * @return N�mero secuencial
	 */
	public int getNumsec() {
		return numsec;
	}

	/**
	 * Permite establecer el n�mero secuencial
	 * 
	 * @param numsec
	 *            N�mero secuencial
	 */
	public void setNumsec(int numsec) {
		this.numsec = numsec;
	}

}
