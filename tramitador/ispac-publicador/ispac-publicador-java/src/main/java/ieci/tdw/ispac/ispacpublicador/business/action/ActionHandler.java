/*
 * Created on 22-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.action;

import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;
import ieci.tdw.ispac.ispacpublicador.business.rule.RuleInfo;
import ieci.tdw.ispac.ispacpublicador.business.rule.RuleMessage;
import ieci.tdw.ispac.ispacpublicador.business.vo.RuleVO;

import org.apache.log4j.Logger;


/**
 * Clase encargada de manejar la ejecuci�n de Acciones.
 * @author Ildefonso Nore�a
 *
 */
public class ActionHandler {

    protected Logger logger = Logger.getLogger(ActionHandler.class);
    
    public boolean execute(IAction action, RuleContext rctx, AttributeContext attCtx, RuleVO vo) throws ActionException{
        if (!action.execute(rctx, attCtx)){
            RuleMessage error = new ActionError(vo.getId(),vo.getIdAccion(), action.getClass().getName(), action.getInfo(), action.getErrorCode());
            if (logger.isInfoEnabled())
                logger.info("La ejecuci�n de la acci�n da resultado negativo, motivos: "+error.toString());
            rctx.addMessage(error);
            return false;
        }else{
            //A�adimos mensaje indicando que la accion se ha ejecutado correctamente
            RuleMessage info = new RuleInfo(vo.getId(),vo.getIdAccion(), action.getClass().getName(), "La Acci�n se ha procesado correctamente.");
            rctx.addMessage(info);
        }
        return true;
    }
}
