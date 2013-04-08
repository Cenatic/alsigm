/*
 * Created on 10-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.condition;

import ieci.tdw.ispac.ispacpublicador.business.context.MilestoneContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ConditionException;

/**
 * Interface de una Condici�n.
 * @author Ildefonso Nore�a
 *
 */
public interface ICondition {
    
    /**
     * @return true si el contexto de la regla unifica con el contexto del Hito Activo, false en caso contrario
     * @param ctx Contexto del Hito Activo
     * @param rctx Contexto de la Regla
     * @throws ConditionException
     */
    public boolean matchContext(MilestoneContext ctx, MilestoneContext rctx)throws ConditionException;

    /**
     * @param rctx Contexto de ejecuci�n de la regla 
     * @return true si la evaluaci�n de la regla es correcta, falso en caso contrario
     * @throws ConditionException
     */
    public boolean evaluate(RuleContext rctx)throws ConditionException;

}
