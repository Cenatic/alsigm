package xml.config;

/**
 * Informaci�n referente a un sistema tramitador obtenida de la
 * configuraci�n del sistema
 */
public class SistemaTramitador extends Sistema {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String idSistGestorOrg = null;

    public SistemaTramitador() {
        super();
    }

    public String getIdSistGestorOrg() {
        return idSistGestorOrg;
    }
    public void setIdSistGestorOrg(String idSistGestorOrg) {
        this.idSistGestorOrg = idSistGestorOrg;
    }
}