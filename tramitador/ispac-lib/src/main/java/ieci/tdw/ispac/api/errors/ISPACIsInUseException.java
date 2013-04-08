package ieci.tdw.ispac.api.errors;

/**
 * Excepci�n lanzada cuando se intenta eliminar un objeto que est� en uso.
 *
 */
public class ISPACIsInUseException extends ISPACException {

    /**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -7658325449537738997L;

	
	/**
     * Constructor
     */
	public ISPACIsInUseException() {
	    super(false);
	}

}
