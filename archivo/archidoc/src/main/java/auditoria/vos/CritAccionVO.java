package auditoria.vos;

import common.vos.BaseVO;

/**
 * VO que encapsula los datos de la criticidad de una accion de la aplicacion
 */
public class CritAccionVO extends BaseVO {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** Identificador del m�dulo al que pertenece la acci�n */
	private int modulo = 0;
	/** Identificador de la acci�n */
	private int accion = 0;
	/** Identificador del nivel de criticidad de la acci�n */
	private int nivel = 0;

	public int getAccion() {
		return accion;
	}

	public void setAccion(int idAccion) {
		this.accion = idAccion;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int idModulo) {
		this.modulo = idModulo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int idNivel) {
		this.nivel = idNivel;
	}
}
