package deposito.actions.deposito;

import java.util.Properties;

import org.apache.log4j.Logger;

import se.repositorios.GestorRepositorioFactory;
import se.repositorios.IGestorRepositorio;
import se.repositorios.archigest.InfoOcupacionVO;
import se.usuarios.ServiceClient;

import common.MultiEntityConstants;
import common.bi.ServiceRepository;
import common.util.StringUtils;

import deposito.vos.DepositoElectronicoVO;

/**
 * Informaci�n de presentacion de los dep�sitos electr�nicos.
 * 
 * @see DepositoElectronicoVO
 */
public class DepositoElectronicoPO extends DepositoElectronicoVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(DepositoElectronicoPO.class);

	/** Informaci�n de ocupaci�n del dep�sito electr�nico. */
	private InfoOcupacionVO infoOcupacion = null;

	/** Repositorio de servicios */
	ServiceRepository services = null;

	/**
	 * Constructor.
	 * 
	 * @param services
	 *            Repositorio de servicios
	 */
	public DepositoElectronicoPO(ServiceRepository services) {
		super();
		this.services = services;
	}

	/**
	 * Obtiene el espacio total del dep�sito electr�nico.
	 * 
	 * @return Espacio total.
	 */
	public Long getEspacioTotal() {
		if (infoOcupacion == null)
			loadInfoOcupacion();

		return infoOcupacion.getEspacioTotal();
	}

	/**
	 * Obtiene el espacio ocupado del dep�sito electr�nico.
	 * 
	 * @return Espacio ocupado.
	 */
	public Long getEspacioOcupado() {
		if (infoOcupacion == null)
			loadInfoOcupacion();

		return infoOcupacion.getEspacioOcupado();
	}

	/**
	 * Obtiene el n�mero de ficheros del dep�sito electr�nico.
	 * 
	 * @return N�mero de ficheros.
	 */
	public Long getNumeroFicheros() {
		if (infoOcupacion == null)
			loadInfoOcupacion();

		return infoOcupacion.getNumeroFicheros();
	}

	/**
	 * Carga la informaci�n de ocupaci�n del dep�sito electr�nico.
	 */
	protected void loadInfoOcupacion() {
		infoOcupacion = new InfoOcupacionVO();

		try {
			if (StringUtils.isNotBlank(getUri())) {

				// Obtener informaci�n de la entidad
				ServiceClient serviceClient = services.getServiceClient();

				// Obtener la entidad para el usuario conectado
				Properties params = null;

				if ((serviceClient != null)
						&& (StringUtils.isNotEmpty(serviceClient.getEntity()))) {
					params = new Properties();
					params.put(MultiEntityConstants.ENTITY_PARAM,
							serviceClient.getEntity());
				}

				IGestorRepositorio gestorRepositorio = GestorRepositorioFactory
						.getConnector(params);
				gestorRepositorio.setWsdlLocation(getUri());
				gestorRepositorio.setUser(getUsuario());
				gestorRepositorio.setPassword(getClave());
				infoOcupacion = gestorRepositorio.getInfoOcupacion();

				/*
				 * if(TipoRepositorio.getTipoRepositorio(ArchigestAction.class).
				 * equalsIgnoreCase("prin")) { WSRepositorioProxy proxy = new
				 * WSRepositorioProxy(getUri());
				 * proxy.setUsername(getUsuario());
				 * proxy.setPassword(getClave()); InfoOcupacionVO aux =
				 * proxy.getInfoOcupacion(); if (aux != null) {
				 * infoOcupacion.setEspacioOcupado(aux.getEspacioOcupado());
				 * infoOcupacion.setEspacioTotal(aux.getEspacioTotal());
				 * infoOcupacion.setNumeroFicheros(aux.getNumeroFicheros()); } }
				 * else { se.repositorios.InfoOcupacionVO
				 * aux=WSCustodiaServiceLocator
				 * .getCustodiaService(getUri()).getInfoOcupacion();
				 * 
				 * if (aux != null) { infoOcupacion.setEspacioOcupado(new
				 * Long(aux.getEspacioOcupado()));
				 * infoOcupacion.setEspacioTotal(new
				 * Long(aux.getEspacioTotal()));
				 * infoOcupacion.setNumeroFicheros(new
				 * Long(aux.getNumeroFicheros())); }
				 * 
				 * }
				 */

			}
		} catch (Exception e) {
			logger.error("Error al leer la informaci�n de ocupaci�n del repositorio: "
					+ getUri());
		}
	}
}
