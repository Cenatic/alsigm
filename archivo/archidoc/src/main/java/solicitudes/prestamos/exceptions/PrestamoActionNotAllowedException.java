package solicitudes.prestamos.exceptions;

import java.util.Collection;

import common.exceptions.ActionNotAllowedException;

/**
 * Exception lanzada si se produce un intento de realizaci�n de una operaci�n no
 * permitida en el m�dulo de pr�stamos por parte de un usuario de la aplicaci�n.
 */
public class PrestamoActionNotAllowedException extends
		ActionNotAllowedException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** MOTIVOS */
	public final static String XESTADO = "Acci�n no permitida por estado";

	public final static String XDETALLADA_SIN_DETALLE = "Acci�n no permitida por no tener detalle";

	public final static String XDETALLADA_DETALLE_NO_DISPONIBLE = "Acci�n no permitida por no tener detalle disponible";

	public final static String XDETALLADA_SIN_ESTADO = "Acci�n no permitida por no tener estado";

	public final static String XFECHA_RESERVA_NO_VALIDA = "Acci�n no permitida por fecha de reserva no v�lida";

	public final static String XPRORROGA_YA_TRATADA = "Acci�n no permitida por pr�rroga ya tratada";

	public final static String XOTRA_ABIERTA = "Acci�n no permitida por estar otro pr�stamo abierto";

	public final static String XARCHIVO = "Acci�n no permitida por los archivos de custodia del usuario";

	public final static String XUSUARIO = "Acci�n no permitida por usuario";

	public final static String XFECHA = "Acci�n no permitida por fecha";

	public final static String XPRORROGA_SOLICITADA = "Acci�n no permitida por pr�rroga solicitada";

	/** Motivo de que la operaci�n no se permitida */
	private String motivo = null;

	/** Prestamos asociados que impiden la realizacion de la accion */
	private Collection prestamos = null;

	public PrestamoActionNotAllowedException(int codError, String motivo) {
		super(codError);

		this.motivo = motivo;
	}

	/**
	 * Devuelve el motido de que la operaci�n no sea permitida
	 * 
	 * @return Motivo de que la operacion no sea permitida {@see
	 *         PrestamoOperacionNoPermitidaException}
	 */
	public String getMotivo() {
		return this.motivo;
	}

	public Collection getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Collection prestamos) {
		this.prestamos = prestamos;
	}

}
