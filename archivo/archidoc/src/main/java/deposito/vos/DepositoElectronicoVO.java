package deposito.vos;

import common.Constants;
import common.util.CryptoHelper;
import common.util.StringUtils;
import common.util.TypeConverter;
import common.util.XmlFacade;
import common.vos.BaseVO;

import deposito.ClaseAccesoDepositoElectronico;

/**
 * Value Object para los dep�sitos electr�nicos.
 */
public class DepositoElectronicoVO extends BaseVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Identificador del dep�sito electr�nico en la aplicaci�n. */
	private String id = null;

	/** Identificador externo del dep�sito electr�nico. */
	private String idExt = null;

	/** Nombre del dep�sito electr�nico. */
	private String nombre = null;

	/** Descripci�n del dep�sito electr�nico. */
	private String descripcion = null;

	/** Flag que indica si los documentos est�n firmados. */
	private String usoFirma = null;

	/** Clase de acceso. */
	private int claseAcceso = ClaseAccesoDepositoElectronico.WSDL_CON_CLAVE;

	/** URI del WSDL del servicio web. */
	private String uri = null;

	/** Usuario del servicio web. */
	private String usuario = null;

	/** Clave del usuario del servicio web. */
	private String clave = null;

	/** Utilidad de encriptaci�n. */
	private static final CryptoHelper cryptoHelper = CryptoHelper.getHelper();

	/**
	 * Constructor.
	 */
	public DepositoElectronicoVO() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdExt() {
		return idExt;
	}

	public void setIdExt(String idExt) {
		this.idExt = idExt;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsoFirma() {
		return usoFirma;
	}

	public void setUsoFirma(String usoFirma) {
		this.usoFirma = usoFirma;
	}

	/**
	 * Obtiene la localizaci�n del servicio web del dep�sito electr�nico.
	 * 
	 * @return XML de localizaci�n.
	 */
	public String getLocalizacion() {
		StringBuffer xml = new StringBuffer();

		xml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>")
				.append(Constants.NEWLINE).append("<localizacion type=\"")
				.append(claseAcceso).append("\">").append(Constants.NEWLINE);

		if (claseAcceso == ClaseAccesoDepositoElectronico.WSDL_CON_CLAVE) {
			// URI
			xml.append("  <uri>").append(uri != null ? uri : "")
					.append("</uri>").append(Constants.NEWLINE);

			// Usuario
			xml.append("  <usuario>").append(usuario != null ? usuario : "")
					.append("</usuario>").append(Constants.NEWLINE);

			// Clave
			xml.append("  <clave>")
					.append(clave != null ? cryptoHelper.encrypt(clave) : "")
					.append("</clave>").append(Constants.NEWLINE);
		}

		xml.append("</localizacion>");

		return xml.toString();
	}

	/**
	 * Establece la localizaci�n del servicio web del dep�sito electr�nico.
	 * 
	 * @param XML
	 *            de localizaci�n.
	 */
	public void setLocalizacion(String localizacion) {
		if (StringUtils.isNotBlank(localizacion)) {
			XmlFacade xml = new XmlFacade(localizacion);

			setClaseAcceso(TypeConverter.toInt(xml.get("/localizacion/@type"),
					ClaseAccesoDepositoElectronico.WSDL_CON_CLAVE));

			if (claseAcceso == ClaseAccesoDepositoElectronico.WSDL_CON_CLAVE) {
				setUri(xml.get("/localizacion/uri/text()"));
				setUsuario(xml.get("/localizacion/usuario/text()"));

				String clave = xml.get("/localizacion/clave/text()");
				if (StringUtils.isNotBlank(clave))
					setClave(cryptoHelper.decrypt(clave));
			}
		}
	}

	public int getClaseAcceso() {
		return claseAcceso;
	}

	public void setClaseAcceso(int claseAcceso) {
		this.claseAcceso = claseAcceso;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
