package es.ieci.tecdoc.fwktd.csv.core.vo;

import java.util.Date;

/**
 * Informaci�n de un documento con su CSV generado.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class InfoDocumentoCSV extends InfoDocumentoCSVForm {

	private static final long serialVersionUID = 2089217516716819621L;

	/**
	 * Identificador del documento.
	 */
	private String id = null;

	/**
	 * C�digo Seguro de Verificaci�n del documento.
	 */
	private String csv = null;

	/**
	 * Fecha de generaci�n del CSV.
	 */
	private Date fechaCSV = null;

	/**
	 * Nombre de la aplicaci�n que almacena el documento.
	 */
	private String nombreAplicacion = null;

	/**
	 * Constructor.
	 */
	public InfoDocumentoCSV() {
		super();
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public Date getFechaCSV() {
		return fechaCSV;
	}

	public void setFechaCSV(Date fechaCSV) {
		this.fechaCSV = fechaCSV;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
