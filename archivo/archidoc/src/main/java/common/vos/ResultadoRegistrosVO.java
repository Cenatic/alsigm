package common.vos;

import org.apache.struts.action.ActionErrors;

/**
 * Value Object que contiene la informaci�n del tratamiento realizado a una
 * lista de registros (inserci�n, modificaci�n o borrado).
 */
public class ResultadoRegistrosVO extends BaseVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** N�mero de registros de la lista. */
	private int numRegistros = 0;

	/** N�mero de registros de la lista que han sido tratados con �xito. */
	private int numRegistrosTratados = 0;

	/** Lista de mensajes de error. */
	private ActionErrors errores = null;

	/**
	 * Constructor.
	 */
	public ResultadoRegistrosVO() {
		super();
		errores = new ActionErrors();
	}

	/**
	 * Devuelve la lista de mensajes de error.
	 * 
	 * @return Lista de mensajes de error.
	 */
	public ActionErrors getErrores() {
		return errores;
	}

	/**
	 * Establece la lista de mensajes de error.
	 * 
	 * @param errores
	 *            Lista de mensajes de error.
	 */
	public void setErrores(ActionErrors errores) {
		this.errores = errores;
	}

	/**
	 * Devuelve el n�mero de registros de la lista.
	 * 
	 * @return N�mero de registros de la lista.
	 */
	public int getNumRegistros() {
		return numRegistros;
	}

	/**
	 * Establece el n�mero de registros de la lista.
	 * 
	 * @param numRegistros
	 *            N�mero de registros de la lista.
	 */
	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}

	/**
	 * Devuelve el n�mero de registros de la lista que han sido tratados con
	 * �xito.
	 * 
	 * @return N�mero de registros de la lista que han sido tratados con �xito.
	 */
	public int getNumRegistrosTratados() {
		return numRegistrosTratados;
	}

	/**
	 * Establece el n�mero de registros de la lista que han sido tratados con
	 * �xito.
	 * 
	 * @param numRegistrosTratados
	 *            N�mero de registros de la lista que han sido tratados con
	 *            �xito.
	 */
	public void setNumRegistrosTratados(int numRegistrosTratados) {
		this.numRegistrosTratados = numRegistrosTratados;
	}
}