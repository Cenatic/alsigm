package se.tramites.archigest;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import se.NotAvailableException;
import se.tramites.Expediente;
import se.tramites.ExpedienteImpl;
import se.tramites.InfoBExpediente;
import se.tramites.SistemaTramitador;
import se.tramites.archigest.stub.ExpedienteVO;
import se.tramites.archigest.stub.WSTramitador;
import se.tramites.archigest.stub.WSTramitadorServiceLocator;
import se.tramites.exceptions.SistemaTramitadorException;
import util.CollectionUtils;

import common.exceptions.SistemaExternoException;

/**
 * Conector con el Sistema Tramitador
 */
public class SistemaTramitadorArchigest implements SistemaTramitador {

	/** Logger de la clase. */
	protected static final Logger logger = Logger
			.getLogger(SistemaTramitadorArchigest.class);

	/** Stub del servicio web de tr�mites. */
	protected WSTramitador wsTramitador = null;

	/** Constante para la localizaci�n del WSDL del Servicio Web. */
	private static final String WSDL_LOCATION = "WSDL_LOCATION";

	/**
	 * Constructor.
	 */
	public SistemaTramitadorArchigest() {
	}

	/**
	 * Inicializa con los par�metros de configuraci�n.
	 * 
	 * @param params
	 *            Par�metros de configuraci�n.
	 * @throws SistemaExternoException
	 *             si ocurre alg�n error.
	 */
	public void initialize(Properties params) throws SistemaExternoException {
		try {
			String wsdlLocation = params.getProperty(WSDL_LOCATION);
			wsTramitador = WSTramitadorServiceLocator
					.getTramitadorService(wsdlLocation);
		} catch (Exception e) {
			logger.error("Error en la creaci\u00F3n del proxy del Tramitador",
					e);
			throw new SistemaTramitadorException(e);
		}
	}

	/**
	 * Recupera los identificadores de los expedientes, del procedimiento
	 * identificado por idProc, que hayan finalizado en el rango de fechas
	 * comprendido entre fechaIni y fechaFin ordenados por lo que indique el
	 * par�metro tipoOrd.
	 * 
	 * @param idProc
	 *            Identificador del procedimiento.
	 * @param fechaIni
	 *            Fecha de inicio.
	 * @param fechaFin
	 *            Fecha de fin.
	 * @param tipoOrd
	 *            Tipo de ordenaci�n.
	 *            <p>
	 *            Valores posibles:
	 *            <li>1 - N�mero de expediente</li>
	 *            <li>2 - Fecha finalizaci�n</li>
	 *            </p>
	 * @return Lista de identificadores de expedientes.
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 */
	public List recuperarIdsExpedientes(String idProc, Date fechaIni,
			Date fechaFin, int tipoOrd) throws SistemaTramitadorException {
		try {
			return CollectionUtils.createList(wsTramitador
					.recuperarIdsExpedientes(idProc, fechaIni, fechaFin,
							tipoOrd));
		} catch (Exception e) {
			logger.error("Error en la llamada al servicio web del Tramitador",
					e);
			throw new SistemaTramitadorException(e);
		}
	}

	/**
	 * Recupera la lista de expedientes cuyos identificadores se incluyen en el
	 * par�metro idExps.
	 * 
	 * @param idExps
	 *            Identificadores de expedientes.
	 * @return Lista de expedientes.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link InfoBExpediente}.
	 *         </p>
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public List recuperarInfoBExpedientes(String[] idExps)
			throws SistemaTramitadorException {
		try {
			return CollectionUtils.createList(wsTramitador
					.recuperarInfoBExpedientes(idExps));
		} catch (Exception e) {
			logger.error("Error en la llamada al servicio web del Tramitador",
					e);
			throw new SistemaTramitadorException(e);
		}
	}

	/**
	 * Recupera la informaci�n de un expediente cuyo identificador �nico es
	 * idExp.
	 * 
	 * @param idExp
	 *            Identificador del expediente.
	 * @return Informaci�n de un expediente.
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public Expediente recuperarExpediente(String idExp)
			throws SistemaTramitadorException {
		ExpedienteImpl expediente = null;

		try {
			ExpedienteVO exp = wsTramitador.recuperarExpediente(idExp);
			if (exp != null) {
				expediente = new ExpedienteImpl();
				expediente.setInformacionBasica(exp.getInformacionBasica());
				expediente.setFechaInicio(exp.getFechaInicio());
				expediente.setFechaFin(exp.getFechaFinalizacion());
				expediente.setAsunto(exp.getAsunto());
				expediente.setOrganoProductor(exp.getIdOrgProductor(),
						exp.getNombreOrgProductor());
				expediente.setDocumentosFisicos(CollectionUtils.createList(exp
						.getDocumentosFisicos()));
				expediente.setDocumentosElectronicos(CollectionUtils
						.createList(exp.getDocumentosElectronicos()));
				expediente.setInteresados(CollectionUtils.createList(exp
						.getInteresados()));
				expediente.setEmplazamientos(CollectionUtils.createList(exp
						.getEmplazamientos()));
			}
		} catch (Exception e) {
			logger.error("Error en la llamada al servicio web del Tramitador",
					e);
			throw new SistemaTramitadorException(e);
		}

		return expediente;
	}

	/**
	 * Modifica el estado de los expedientes recibidos como par�metro a estado
	 * archivado
	 * 
	 * @param idExps
	 *            Array de String con los expedientes que se quieren pasar al
	 *            estado archivado
	 * @throws SistemaTramitadorException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public void archivarExpedientes(String[] idExps)
			throws SistemaTramitadorException, NotAvailableException {

	}
}
