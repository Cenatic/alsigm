package se.procedimientos.ispac;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.services.ServicioTramitacionAdapter;
import ieci.tdw.ispac.services.dto.InfoBProcedimiento;
import ieci.tdw.ispac.services.ws.client.TramitacionWebService;
import ieci.tdw.ispac.services.ws.client.TramitacionWebServiceServiceLocator;
import ieci.tdw.ispac.services.ws.client.dto.ListaInfoBProcedimientos;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import se.NotAvailableException;
import se.procedimientos.GestorCatalogo;
import se.procedimientos.InfoBProcedimientoImpl;
import se.procedimientos.OrganoProductorImpl;
import se.procedimientos.IProcedimiento;
import se.procedimientos.ProcedimientoConstants;
import se.procedimientos.ProcedimientoImpl;
import se.procedimientos.exceptions.GestorCatalogoException;

import common.exceptions.SistemaExternoException;

/**
 * Gestor de cat�logo para Ispac
 */
public class GestorCatalogoIspac implements GestorCatalogo {

	/** Logger de la clase. */
	protected static final Logger logger = Logger
			.getLogger(GestorCatalogoIspac.class);

	/** Constante que indica el modo de acceder a los procedimientos (API, WS) **/
	private static final String MODE = "MODE";

	/**
	 * Modo de acceso
	 */
	private String mode = null;

	/** Constante para la localizaci�n del WSDL del Servicio Web. */
	private static final String WSDL_LOCATION = "WSDL_LOCATION";

	/**
	 * Localizaci�n del WDSL
	 */
	private String wsdlLocation = null;

	/**
	 * Constructor.
	 */
	public GestorCatalogoIspac() {
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
			mode = params.getProperty(MODE);
			if (mode == null)
				mode = ProcedimientoConstants.API;
			if (ProcedimientoConstants.WS.equalsIgnoreCase(mode))
				wsdlLocation = params.getProperty(WSDL_LOCATION);
		} catch (Exception e) {
			logger.error("Error en la creaci\u00F3n del proxy del Catalogo", e);
			throw new GestorCatalogoException(e);
		}
	}

	/**
	 * Transforma un objeto con informaci�n b�sica del procedimiento en otro que
	 * implemementan el interfaz de informaci�n b�sica de procedimiento
	 * 
	 * @param
	 * @return
	 */
	public se.procedimientos.InfoBProcedimiento transformInfoB(Object infoBproc) {
		InfoBProcedimientoImpl info = null;
		if (infoBproc != null) {
			if (infoBproc instanceof se.procedimientos.InfoBProcedimiento)
				return (se.procedimientos.InfoBProcedimiento) infoBproc;
			else if (infoBproc instanceof ieci.tdw.ispac.services.dto.InfoBProcedimiento) {
				ieci.tdw.ispac.services.dto.InfoBProcedimiento infoBProcedimiento = (ieci.tdw.ispac.services.dto.InfoBProcedimiento) infoBproc;
				info = new InfoBProcedimientoImpl();
				info.setCodigo(infoBProcedimiento.getCodigo());
				info.setCodSistProductor(infoBProcedimiento
						.getCodSistProductor());
				info.setId(infoBProcedimiento.getId());
				info.setNombre(infoBProcedimiento.getNombre());
				info.setNombreSistProductor(infoBProcedimiento
						.getNombreSistProductor());
			} else if (infoBproc instanceof ieci.tdw.ispac.services.ws.client.dto.InfoBProcedimiento) {
				ieci.tdw.ispac.services.ws.client.dto.InfoBProcedimiento infoBProcedimiento = (ieci.tdw.ispac.services.ws.client.dto.InfoBProcedimiento) infoBproc;
				info = new InfoBProcedimientoImpl();
				info.setCodigo(infoBProcedimiento.getCodigo());
				info.setCodSistProductor(infoBProcedimiento
						.getCodSistProductor());
				info.setId(infoBProcedimiento.getId());
				info.setNombre(infoBProcedimiento.getNombre());
				info.setNombreSistProductor(infoBProcedimiento
						.getNombreSistProductor());
			}
		}
		return info;
	}

	/**
	 * Transforma una lista de organos productores procedentes del API en una
	 * lista de objetos que implemementan el interfaz de organos productores
	 * 
	 * @param organosProductores
	 *            Organos productores procedentes del API
	 * @return Lista de organos productores que implementan el interfaz
	 */
	public List transform(Object[] organosProductores) {
		List ltOrganosProductores = new ArrayList();
		if (organosProductores != null) {
			for (int i = 0; i < organosProductores.length; i++) {
				if (organosProductores[i] instanceof ieci.tdw.ispac.services.dto.OrganoProductor) {
					ieci.tdw.ispac.services.dto.OrganoProductor organoProductor = (ieci.tdw.ispac.services.dto.OrganoProductor) organosProductores[i];
					OrganoProductorImpl organoProductorImpl = new OrganoProductorImpl();
					organoProductorImpl.setId(organoProductor.getId());
					organoProductorImpl.setInicioProduccion(organoProductor
							.getInicioProduccion());
					ltOrganosProductores.add(organoProductorImpl);
				} else if (organosProductores[i] instanceof ieci.tdw.ispac.services.ws.client.dto.OrganoProductor) {
					ieci.tdw.ispac.services.ws.client.dto.OrganoProductor organoProductor = (ieci.tdw.ispac.services.ws.client.dto.OrganoProductor) organosProductores[i];
					OrganoProductorImpl organoProductorImpl = new OrganoProductorImpl();
					organoProductorImpl.setId(organoProductor.getId());
					organoProductorImpl.setInicioProduccion(organoProductor
							.getInicioProduccion());
					ltOrganosProductores.add(organoProductorImpl);
				}
			}
		}
		return ltOrganosProductores;
	}

	/**
	 * Transforma una lista de informaci�n b�sica de procedimientos procedentes
	 * del WS o del API en una lista de objetos que implemementan el interfaz de
	 * informaci�n b�sica de procedimientos
	 * 
	 * @param list
	 *            Lista de informaci�n b�sica de procedimientos procedentes del
	 *            WS o del API
	 * @return lista de informaci�n b�sica de procedimientos que implemementan
	 *         el interfaz de informaci�n b�sica de procedimientos
	 */
	public List transformInfoB(Object[] arrayObj) {
		List result = new ArrayList();
		if (arrayObj != null) {
			for (int i = 0; i < arrayObj.length; i++) {
				Object infoBProcedimiento = arrayObj[i];
				// InfoBProcedimiento infoBProcedimiento=(InfoBProcedimiento)
				// obj;
				result.add(transformInfoB(infoBProcedimiento));
			}
		}
		return result;
	}

	/**
	 * Recupera la lista de procedimientos del tipo que se indica en tipoProc,
	 * con su informaci�n b�sica.
	 * 
	 * @param tipoProc
	 *            Tipo de procedimiento.
	 *            <p>
	 *            Valores posibles de tipoProc:
	 *            <li>1 - Todos</li>
	 *            <li>2 - Procedimientos automatizados</li>
	 *            <li>3 - Procedimientos no automatizados</li>
	 *            </p>
	 * @param nombre
	 *            Nombre del procedimiento.
	 * @return Lista de informaci�n de procedimientos.
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 */
	public List recuperarInfoBProcedimientos(int tipoProc, String nombre)
			throws GestorCatalogoException {
		List list = new ArrayList();
		try {
			if (ProcedimientoConstants.API.equalsIgnoreCase(mode)) {
				ServicioTramitacionAdapter servicio = new ServicioTramitacionAdapter();
				Object[] infoBProcs = servicio.getProcedimientos(tipoProc,
						nombre);
				if ((infoBProcs != null) && (infoBProcs.length > 0))
					list = transformInfoB(infoBProcs);
			} else {
				TramitacionWebServiceServiceLocator twsServiceLocator = new TramitacionWebServiceServiceLocator();
				twsServiceLocator
						.setTramitacionWebServiceEndpointAddress(wsdlLocation);
				TramitacionWebService service = twsServiceLocator
						.getTramitacionWebService();
				ListaInfoBProcedimientos listaProcedimientos = service
						.getProcedimientosPorTipo(tipoProc, nombre);
				if (listaProcedimientos != null) {
					Object[] infoBProcs = listaProcedimientos
							.getProcedimientos();
					if ((infoBProcs != null) && (infoBProcs.length > 0))
						list = transformInfoB(infoBProcs);
				}
			}
		} catch (ISPACException e) {
			throw new GestorCatalogoException(e);
		} catch (Exception e) {
			throw new GestorCatalogoException(e);
		}
		return list;
	}

	/**
	 * Recupera la lista de procedimientos cuyos identificadores se incluyen en
	 * el par�metro idProcs.
	 * 
	 * @param idProcs
	 *            Lista de identificadores de procedimientos.
	 * @return Lista de informaci�n de procedimientos.
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 */
	public List recuperarInfoBProcedimientos(String[] idProcs)
			throws GestorCatalogoException {
		List list = new ArrayList();
		try {
			if (ProcedimientoConstants.API.equalsIgnoreCase(mode)) {
				ServicioTramitacionAdapter servicio = new ServicioTramitacionAdapter();
				InfoBProcedimiento[] infoBProcs = servicio
						.getProcedimientos(idProcs);
				if ((infoBProcs != null) && (infoBProcs.length > 0))
					list = transformInfoB(infoBProcs);
			} else {
				TramitacionWebServiceServiceLocator twsServiceLocator = new TramitacionWebServiceServiceLocator();
				twsServiceLocator
						.setTramitacionWebServiceEndpointAddress(wsdlLocation);
				TramitacionWebService service = twsServiceLocator
						.getTramitacionWebService();
				ListaInfoBProcedimientos listaProcedimientos = service
						.getProcedimientos(idProcs);
				if (listaProcedimientos != null) {
					Object[] infoBProcs = listaProcedimientos
							.getProcedimientos();
					if ((infoBProcs != null) && (infoBProcs.length > 0))
						list = transformInfoB(infoBProcs);
				}
			}
		} catch (ISPACException e) {
			throw new GestorCatalogoException(e);
		} catch (Exception e) {
			throw new GestorCatalogoException(e);
		}

		return list;
	}

	/**
	 * Recupera la informaci�n de un procedimiento cuyo identificador �nico es
	 * idProc.
	 * 
	 * @param idProc
	 *            Identificador de procedimiento.
	 * @return Informaci�n del procedimiento.
	 * @throws GestorCatalogoException
	 *             si ocurre alg�n error.
	 * @throws NotAvailableException
	 *             si la funcionalidad no es aplicable.
	 */
	public IProcedimiento recuperarProcedimiento(String idProc)
			throws GestorCatalogoException {

		ProcedimientoImpl procedimiento = null;
		try {
			if (ProcedimientoConstants.API.equalsIgnoreCase(mode)) {
				ServicioTramitacionAdapter servicio = new ServicioTramitacionAdapter();
				ieci.tdw.ispac.services.dto.Procedimiento proc = servicio
						.getProcedimiento(idProc);

				if (proc != null) {
					procedimiento = new ProcedimientoImpl();

					procedimiento.setInformacionBasica(transformInfoB(proc
							.getInformacionBasica()));
					procedimiento.setObjeto(proc.getObjeto());
					procedimiento.setTramites(proc.getTramites());
					procedimiento.setNormativa(proc.getNormativa());
					procedimiento.setDocumentosBasicos(proc
							.getDocumentosBasicos());
					procedimiento.setOrganosProductores(transform(proc
							.getOrganosProductores()));
				}
			} else {
				TramitacionWebServiceServiceLocator twsServiceLocator = new TramitacionWebServiceServiceLocator();
				twsServiceLocator
						.setTramitacionWebServiceEndpointAddress(wsdlLocation);
				TramitacionWebService service = twsServiceLocator
						.getTramitacionWebService();
				ieci.tdw.ispac.services.ws.client.dto.Procedimiento proc = service
						.getProcedimiento(idProc);

				if (proc != null) {
					procedimiento = new ProcedimientoImpl();
					procedimiento.setInformacionBasica(transformInfoB(proc
							.getInformacionBasica()));
					procedimiento.setObjeto(proc.getObjeto());
					procedimiento.setTramites(proc.getTramites());
					procedimiento.setNormativa(proc.getNormativa());
					procedimiento.setDocumentosBasicos(proc
							.getDocumentosBasicos());
					procedimiento.setOrganosProductores(transform(proc
							.getOrganosProductores()));
				}
			}
		} catch (ISPACException e) {
			throw new GestorCatalogoException(e);
		} catch (Exception e) {
			throw new GestorCatalogoException(e);
		}

		return procedimiento;
	}
}
