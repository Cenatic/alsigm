package solicitudes.consultas.exceptions;

import java.util.Collection;

import common.exceptions.ActionNotAllowedException;

/**
 * Clase que encapsula los datos de l�s errores sobre las operaciones no
 * permitidas sobre consultas.
 */
public class ConsultaActionNotAllowedException extends
		ActionNotAllowedException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** MOTIVOS */

	public final static String XFECHA_RESERVA_NO_VALIDA = "errors.solicitudes.consultas.envioNoPermitidoXfechaReservaNoValida";
	public final static String XESTADO = "errors.solicitudes.consultas.accionNoPermitidaXEstadoNoValido";
	public final static String XDETALLADA_SIN_DETALLE = "errors.solicitudes.consultas.accionNoPermitidaSinDetalle";
	public final static String XUSUARIO = "errors.solicitudes.consultas.accionNoPermitidaXUsuario";
	public final static String XOTRA_ABIERTA = "errors.solicitudes.consultas.accionNoPermitidaXOtraAbierta";
	public final static String XFECHA = "Acci�n no permitida por fecha";

	// public final static String XFECHA_RESERVA_NO_VALIDA =
	// "Acci�n no permitida por fecha de reserva no v�lida";
	// public final static String XESTADO = "Acci�n no permitida por estado";
	// public final static String XDETALLADA_SIN_DETALLE =
	// "Acci�n no permitida por no tener detalle";
	// public final static String XUSUARIO = "Acci�n no permitida por usuario";

	// No se estaban usando
	// public final static String XDETALLADA_SIN_ESTADO =
	// "Acci�n no permitida por no tener estado";
	// public final static String XOTRA_ABIERTA =
	// "Acci�n no permitida por estar otra consulta abierta";
	// public final static String XARCHIVO =
	// "Acci�n no permitida por los archivos de custodia del usuario";

	/** Motivo de que la accion sea no permitida */
	private String motivo = null;
	/** Consultas que impiden la realizacion de la accion */
	private Collection consultasVO = null;

	public ConsultaActionNotAllowedException(int codError, String motivo) {
		super(codError);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public Collection getConsultasVO() {
		return consultasVO;
	}

	public void setConsultasVO(Collection consultasVO) {
		this.consultasVO = consultasVO;
	}

}
