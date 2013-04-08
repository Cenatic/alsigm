package es.ieci.tecdoc.fwktd.csv.core.vo;


/**
 * Informaci�n de una aplicaci�n externa.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class AplicacionCSV extends AplicacionCSVForm {

	private static final long serialVersionUID = 7002279450867615665L;

	/**
	 * Identificador de la aplicaci�n externa.
	 */
	private String id = null;

	/**
	 * Constructor.
	 */
	public AplicacionCSV() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
