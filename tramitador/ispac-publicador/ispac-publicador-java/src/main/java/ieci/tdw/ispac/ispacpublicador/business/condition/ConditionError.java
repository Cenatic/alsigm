/*
 * Created on 14-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.condition;

import ieci.tdw.ispac.ispacpublicador.business.exceptions.ErrorCode;
import ieci.tdw.ispac.ispacpublicador.business.rule.RuleError;

/**
 * Clase que almacenar� informaci�n que describen los datos 
 * que han producido un error en la evaluaci�n de una condici�n
 * al procesar una regla.
 * @author Ildefonso Nore�a
 *
 */
public class ConditionError extends RuleError {

    /**
     * Construye un ConditionError inicializando sus atributos.
     */
    public ConditionError(){
        this(-1,-1,null,null, ErrorCode.ERROR_DESCONOCIDO);
    }

    /**
     * Construye un ConditionError inicializando sus atributos.
     */
    public ConditionError(int idRule, int id, String name, String message, int errorCode){
        setIdRule(idRule);
        setId(id);
        setName(name);
        setMessage(message);
        setCodigoError(errorCode);
    }
    
}
