package common;

import gcontrol.db.ArchivoDbEntityImpl;
import gcontrol.db.IArchivoDbEntity;
import gcontrol.vos.ArchivoVO;
import ieci.core.db.DbConnection;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

import solicitudes.SolicitudesConstants;
import solicitudes.consultas.vos.ConsultaPO;
import solicitudes.consultas.vos.ConsultaVO;
import solicitudes.prestamos.vos.PrestamoPO;
import solicitudes.prestamos.vos.PrestamoVO;
import transferencias.TransferenciasConstants;
import transferencias.actions.PrevisionPO;
import transferencias.actions.RelacionEntregaPO;
import transferencias.vos.PrevisionVO;
import transferencias.vos.RelacionEntregaVO;

import common.bi.ServiceSession;
import common.db.DBUtils;

/**
 * Paquete de Utilidades generales del Proyecto
 * 
 * @author lucas
 * 
 */
public class CodigoTransferenciaUtils {

	// NOTA Cualquier m�todo que se ponga aqu�, deber� llevar su javadoc.

	static final char CARACTER_SUSTITUCION = '/';

	/**
	 * Concatena los valores de c�digo de Transferencia.
	 * 
	 * @param anio
	 *            A�o de la Trasferencia
	 * @param archivo
	 *            C�digo de Archivo
	 * @param orden
	 *            Orden de la transferencia
	 * @return C�digo de Transferencia Completo
	 */
	public static final String getCodigoTransferencia(String anio,
			String archivo, Integer orden, String formato) {

		// char CARACTER_SEPARADOR = '/';
		char CARACTER_SEPARADOR = ConfigConstants.getInstance()
				.getSeparadorCodigoTransferencia();
		// Si el caracter separador est� presente en el archivo se sustituye por
		// este

		String ordenFormateado = getNumeroFormateado(orden, formato);

		StringBuffer codigoTransferencia = new StringBuffer().append(anio)
				.append(CARACTER_SEPARADOR);

		if (ConfigConstants.getInstance()
				.getPermitirTransferenciasEntreArchivos()
				&& StringUtils.isNotEmpty(archivo)) {
			archivo = archivo.replace(CARACTER_SEPARADOR, CARACTER_SUSTITUCION);

			codigoTransferencia.append(archivo).append(CARACTER_SEPARADOR);
		}
		codigoTransferencia.append(ordenFormateado);

		return codigoTransferencia.toString();

	}

	/**
	 * Obtiene el C�digo de Transferencia formateado y concatenado al a�o y al
	 * archivo
	 * 
	 * @param obj
	 *            Objeto
	 * @return C�digo de Transferencia Completo para mostrar en la JSP
	 */
	public static final String getCodigoTransferenciaFromVO(Object obj,
			ServiceSession ss) {
		String anio = null;
		Integer orden = null;
		String archivo = null;
		String idArchivo = null;
		String formato = TransferenciasConstants.FORMAT_ORDEN;
		if (obj instanceof PrevisionVO) {
			PrevisionVO previsionVO = (PrevisionVO) obj;

			anio = previsionVO.getAno();
			orden = new Integer(previsionVO.getOrden());
			idArchivo = previsionVO.getIdarchivoreceptor();
		} else if (obj instanceof RelacionEntregaVO) {
			RelacionEntregaVO relacionVO = (RelacionEntregaVO) obj;

			anio = relacionVO.getAno();
			orden = new Integer(relacionVO.getOrden());
			idArchivo = relacionVO.getIdarchivoreceptor();
		} else if (obj instanceof PrestamoVO) {
			PrestamoVO prestamoVO = (PrestamoVO) obj;

			anio = prestamoVO.getAno();
			orden = new Integer(prestamoVO.getOrden());
			if (prestamoVO.getArchivo() != null)
				archivo = prestamoVO.getArchivo().getCodigo();
			idArchivo = prestamoVO.getIdarchivo();
			formato = SolicitudesConstants.FORMAT_ID_SOLICITUD;
		} else if (obj instanceof ConsultaVO) {
			ConsultaVO consultaVO = (ConsultaVO) obj;

			anio = consultaVO.getAno();
			orden = new Integer(consultaVO.getOrden());
			if (consultaVO.getArchivo() != null)
				archivo = consultaVO.getArchivo().getCodigo();
			idArchivo = consultaVO.getIdarchivo();
			formato = SolicitudesConstants.FORMAT_ID_SOLICITUD;
		} else
			return null;

		if (archivo == null) {
			// Obtener el registro archivo con ese Id de la BD
			IArchivoDbEntity archivoDBEntity = new ArchivoDbEntityImpl(
					ss.getTransactionManager());
			ArchivoVO archivoVO = archivoDBEntity.getArchivoXId(idArchivo);
			if (archivoVO == null)
				return null;
			archivo = archivoVO.getCodigo();
		}

		return getCodigoTransferencia(anio, archivo, orden, formato);
	}

	/**
	 * Obtiene el C�digo de Transferencia formateado y concatenado al a�o y al
	 * archivo
	 * 
	 * @param obj
	 *            Objeto
	 * @return C�digo de Transferencia Completo para mostrar en la JSP
	 */
	public static final String getCodigoTransferencia(Object obj) {
		String anio = null;
		Integer orden = null;
		String archivo = null;

		if (obj instanceof PrevisionPO) {
			PrevisionPO previsionPO = (PrevisionPO) obj;

			anio = previsionPO.getAno();
			orden = new Integer(previsionPO.getOrden());
			archivo = previsionPO.getCodigoarchivoreceptor();

			return getCodigoTransferencia(anio, archivo, orden,
					TransferenciasConstants.FORMAT_ORDEN);
		} else if (obj instanceof RelacionEntregaPO) {
			RelacionEntregaPO relacionPO = (RelacionEntregaPO) obj;

			anio = relacionPO.getAno();
			orden = new Integer(relacionPO.getOrden());
			archivo = relacionPO.getCodigoArchivoReceptor();

			return getCodigoTransferencia(anio, archivo, orden,
					TransferenciasConstants.FORMAT_ORDEN);
		} else if (obj instanceof PrestamoPO) {
			PrestamoPO prestamoPO = (PrestamoPO) obj;

			anio = prestamoPO.getAno();
			orden = new Integer(prestamoPO.getOrden());
			archivo = prestamoPO.getCodigoarchivo();

			return getCodigoTransferencia(anio, archivo, orden,
					SolicitudesConstants.FORMAT_ID_SOLICITUD);
		} else if (obj instanceof ConsultaPO) {
			ConsultaPO consultaPO = (ConsultaPO) obj;

			anio = consultaPO.getAno();
			orden = new Integer(consultaPO.getOrden());
			archivo = consultaPO.getCodigoarchivo();

			return getCodigoTransferencia(anio, archivo, orden,
					SolicitudesConstants.FORMAT_ID_SOLICITUD);
		}

		return null;
	}

	/**
	 * Formatea el n�mero especificado, con el formato que se le pasa.
	 * 
	 * @param numero
	 *            Numero a Formatear
	 * @param formato
	 *            Formato deseado
	 * @return N�mero formateado.
	 */
	private static final String getNumeroFormateado(Integer numero,
			String formato) {
		DecimalFormat numeroTransferenciaFormater = new DecimalFormat(formato);
		return numeroTransferenciaFormater.format(numero);
	}

	/**
	 * Devuelve el texto sql para busqueda de relaciones de entrega referido al
	 * c�digo de transferencia
	 * 
	 * @param campoAno
	 *            , nombre del campo a�o
	 * @param campoOrden
	 *            , nombre del campoOrden
	 * @param concatSymbol
	 *            , s�mbolo de concatenaci�n
	 * @param connection
	 *            , conexi�n
	 * @return texto sql
	 */
	public static String textSqlCodigoTransferenciaRelacionEntrega(
			String campoAno, String campoOrden, String concatSymbol,
			DbConnection connection) {
		char CARACTER_SEPARADOR = ConfigConstants.getInstance()
				.getSeparadorCodigoTransferencia();
		StringBuffer qual = new StringBuffer().append(campoAno)
				.append(concatSymbol).append("'")
				.append(String.valueOf(CARACTER_SEPARADOR)).append("'")
				.append(concatSymbol);

		// Si se permiten transferencias entre archivos hay que poner el c�digo
		// de archivo
		if (ConfigConstants.getInstance()
				.getPermitirTransferenciasEntreArchivos()) {
			qual.append(ArchivoDbEntityImpl.CODIGO_FIELD.getQualifiedName())
					.append(concatSymbol).append("'")
					.append(String.valueOf(CARACTER_SEPARADOR)).append("'")
					.append(concatSymbol);
		}

		qual.append(DBUtils.getNativeLPadSyntax(connection, campoOrden,
				TransferenciasConstants.FORMAT_ORDEN.length(), "0"));

		return qual.toString();
	}

	/**
	 * Devuelve el texto sql para busqueda de previsiones referido al c�digo de
	 * transferencia
	 * 
	 * @param campoAno
	 *            , nombre del campo a�o
	 * @param campoOrden
	 *            , nombre del campoOrden
	 * @param connection
	 *            , conexi�n
	 * @return texto sql
	 */
	public static String textSqlCodigoTransferenciaPrevision(String campoAno,
			String campoOrden, DbConnection connection) {

		char CARACTER_SEPARADOR = ConfigConstants.getInstance()
				.getSeparadorCodigoTransferencia();
		StringBuffer qual = new StringBuffer().append(campoAno)
				.append(DBUtils.getNativeConcatSyntax(connection)).append("'")
				.append(String.valueOf(CARACTER_SEPARADOR)).append("'")
				.append(DBUtils.getNativeConcatSyntax(connection));

		// Si se permiten transferencias entre archivos hay que poner el c�digo
		// de archivo
		if (ConfigConstants.getInstance()
				.getPermitirTransferenciasEntreArchivos()) {
			qual.append(ArchivoDbEntityImpl.CODIGO_FIELD.getQualifiedName())
					.append(DBUtils.getNativeConcatSyntax(connection))
					.append("'").append(String.valueOf(CARACTER_SEPARADOR))
					.append("'")
					.append(DBUtils.getNativeConcatSyntax(connection));
		}

		qual.append(DBUtils.getNativeLPadSyntax(connection, campoOrden,
				TransferenciasConstants.FORMAT_ORDEN.length(), "0"));
		return qual.toString();
	}

	/**
	 * Devuelve el texto sql para busqueda de prestamos referido al c�digo de
	 * transferencia
	 * 
	 * @param campoAno
	 *            , nombre del campo a�o
	 * @param campoOrden
	 *            , nombre del campoOrden
	 * @param connection
	 *            , conexi�n
	 * @return texto sql
	 */
	public static String textSqlCodigoTransferenciaPrestamo(String campoAno,
			String campoOrden, DbConnection connection) {
		char CARACTER_SEPARADOR = ConfigConstants.getInstance()
				.getSeparadorCodigoTransferencia();

		StringBuffer qual = new StringBuffer().append(campoAno)
				.append(DBUtils.getNativeConcatSyntax(connection)).append("'")
				.append(String.valueOf(CARACTER_SEPARADOR)).append("'")
				.append(DBUtils.getNativeConcatSyntax(connection));

		// Si se permiten transferencias entre archivos hay que poner el c�digo
		// de archivo
		if (ConfigConstants.getInstance()
				.getPermitirTransferenciasEntreArchivos()) {
			qual.append(ArchivoDbEntityImpl.CODIGO_FIELD.getQualifiedName())
					.append(DBUtils.getNativeConcatSyntax(connection))
					.append("'").append(String.valueOf(CARACTER_SEPARADOR))
					.append("'")
					.append(DBUtils.getNativeConcatSyntax(connection));
		}

		qual.append(DBUtils.getNativeLPadSyntax(connection, campoOrden,
				SolicitudesConstants.FORMAT_ID_SOLICITUD.length(), "0"));

		return qual.toString();
	}

	/**
	 * Devuelve el texto sql para busqueda de consultas referido al c�digo de
	 * transferencia
	 * 
	 * @param campoAno
	 *            , nombre del campo a�o
	 * @param campoOrden
	 *            , nombre del campoOrden
	 * @param connection
	 *            , conexi�n
	 * @return texto sql
	 */
	public static String textSqlCodigoTransferenciaConsulta(String campoAno,
			String campoOrden, DbConnection connection) {
		char CARACTER_SEPARADOR = ConfigConstants.getInstance()
				.getSeparadorCodigoTransferencia();

		StringBuffer qual = new StringBuffer()

		.append(campoAno).append(DBUtils.getNativeConcatSyntax(connection))
				.append("'").append(String.valueOf(CARACTER_SEPARADOR))
				.append("'").append(DBUtils.getNativeConcatSyntax(connection));

		// Si se permiten transferencias entre archivos hay que poner el c�digo
		// de archivo
		if (ConfigConstants.getInstance()
				.getPermitirTransferenciasEntreArchivos()) {
			qual.append(ArchivoDbEntityImpl.CODIGO_FIELD.getQualifiedName())
					.append(DBUtils.getNativeConcatSyntax(connection))
					.append("'").append(String.valueOf(CARACTER_SEPARADOR))
					.append("'")
					.append(DBUtils.getNativeConcatSyntax(connection));
		}

		qual.append(DBUtils.getNativeLPadSyntax(connection, campoOrden,
				SolicitudesConstants.FORMAT_ID_SOLICITUD.length(), "0"));

		return qual.toString();
	}

	public static String getParteUnidadDocumental(int numParte, int totalPartes) {
		String parteExp = Constants.STRING_EMPTY;
		if (totalPartes > 1) {
			parteExp = new StringBuffer(Constants.STRING_SPACE)
					.append(Constants.ABRIR_PARENTESIS).append(numParte)
					.append(Constants.SLASH).append(totalPartes)
					.append(Constants.CERRAR_PARENTESIS).toString();
		}

		return parteExp;
	}

	public static String getRegistroEntrada(String anioActual, int nsecreg) {
		return anioActual + Constants.SEPARADOR_COD_REGISTRO
				+ Integer.toString(nsecreg);
	}

}