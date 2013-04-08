package ieci.tdw.ispac.ispacpublicador.business.action;

import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;


/**
 * Interfaz que deben implementar todas las Acciones a ejecutar.
 *
 */
public interface IAction {

    /**
     * Ejecuta la acci�n.
     * @param rctx Contexto de ejecuci�n de la regla
     * @param attContext Atributos con informaci�n extra, utilizados dentro de la ejecuci�n de la regla.
     * @return true si la ejecuci�n termina correctamente, false en caso contrario.
     * @throws ActionException
     */
    public boolean execute(RuleContext rctx, AttributeContext attContext)
    	throws ActionException;
    
    /**
     * Obtiene la informaci�n causante de que la ejecuci�n de la acci�n haya 
     * dado resultado negativo.
     * @return Cadena con informaci�n.
     */
    public String getInfo();
    

    /**
     * Obtiene el c�digo de error. Este c�digo es un entero que indentifica al 
     * causante de que la ejecuci�n de la acci�n de resultado negativo.
     * @return C�digo de error.
     */
    public int getErrorCode();
}
