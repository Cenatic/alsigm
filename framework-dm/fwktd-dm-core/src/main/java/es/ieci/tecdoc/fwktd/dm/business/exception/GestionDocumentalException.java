package es.ieci.tecdoc.fwktd.dm.business.exception;

/**
 * Excepci�n base del m�dulo de gesti�n documental.
 * @author Iecisa
 * @version $Revision$
 *
 */
public class GestionDocumentalException extends Exception {

	/**
	 * UID de versi�n.
	 */
	private static final long serialVersionUID = -5733720301390437612L;


	/**
	 * Constructor.
	 */
	public GestionDocumentalException() {
		super();
	}

	/**
	 * Constructor.
	 */
	public GestionDocumentalException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Constructor.
	 */
	public GestionDocumentalException(Throwable causa) {
		super(causa);
	}

	/**
	 * Constructor.
	 */
	public GestionDocumentalException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
