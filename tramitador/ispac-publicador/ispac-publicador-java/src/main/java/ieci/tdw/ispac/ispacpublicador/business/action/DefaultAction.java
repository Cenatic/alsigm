package ieci.tdw.ispac.ispacpublicador.business.action;


/**
 * Acci�n base para la implementaci�n de acciones.
 * 
 */
public abstract class DefaultAction implements IAction {

    /** Informaci�n sobre el resultado de la acci�n. */
    private String info = null;
    
    /** C�digo de error. */
    private int errorCode = -1;
    
    
    /**
     * Constructor.
     * 
     */
    public DefaultAction() {}
    
    /**
     * Obtiene la informaci�n causante de que la ejecuci�n de la acci�n haya 
     * dado resultado negativo.
     * @return Cadena con informaci�n.
     */
    public String getInfo() {
        return info;
    }

    /**
     * Establece la informaci�n causante de que la ejecuci�n de la acci�n haya 
     * dado resultado negativo.
     * @param Cadena con informaci�n.
     */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
     * Obtiene el c�digo de error. Este c�digo es un entero que indentifica al 
     * causante de que la ejecuci�n de la acci�n de resultado negativo.
     * @return C�digo de error.
     */
    public int getErrorCode() {
        return errorCode;
    }

	/**
     * Establece el c�digo de error. Este c�digo es un entero que indentifica al 
     * causante de que la ejecuci�n de la acci�n de resultado negativo.
     * @param C�digo de error.
     */
    public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}