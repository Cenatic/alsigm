/*
 * Created on 17-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.rule;

/**
 * @author Ildefonso Nore�a
 *
 */
public abstract class RuleError extends RuleMessage {

    /**
     * C�digo del error producido, que describe en cierta medida el error.
     */
    private int codigoError;
    
    public String toString(){
        return "[ERROR]->"+super.toString();
    }

    /**
     * @return Returns the codigoError.
     */
    public int getCodigoError() {
        return codigoError;
    }
    /**
     * @param codigoError The codigoError to set.
     */
    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }
}
