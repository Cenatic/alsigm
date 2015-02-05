package common.exceptions;

import common.Constants;

/**
 * Excepcion lanzada cuando se encuentran demasiados resultados.
 */
public class TooManyResultsException extends CheckedArchivoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** N�mero de resultados. */
	private int count = 0;

	/** N�mero m�ximo de resultados. */
	private int maxNumResults = 0;

	/**
	 * Constructor.
	 * 
	 * @param count
	 *            N�mero de resultados.
	 */
	public TooManyResultsException(int count, int maxNumResults) {
		super(Constants.ERROR_TOO_MANY_RESULTS + ": " + count + "["
				+ maxNumResults + "]");
		this.count = count;
		this.maxNumResults = maxNumResults;
	}

	/**
	 * Obtiene el n�mero de resultados.
	 * 
	 * @return N�mero de resultados.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Obtiene el n�mero m�ximo de resultados.
	 * 
	 * @return N�mero m�ximo de resultados.
	 */
	public int getMaxNumResults() {
		return maxNumResults;
	}

}
