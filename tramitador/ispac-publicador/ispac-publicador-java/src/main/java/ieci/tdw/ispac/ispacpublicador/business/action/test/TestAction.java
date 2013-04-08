package ieci.tdw.ispac.ispacpublicador.business.action.test;

import ieci.tdw.ispac.ispacpublicador.business.action.DefaultAction;
import ieci.tdw.ispac.ispacpublicador.business.attribute.AttributeContext;
import ieci.tdw.ispac.ispacpublicador.business.context.RuleContext;
import ieci.tdw.ispac.ispacpublicador.business.exceptions.ActionException;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Acci�n de pruebas.
 * 
 */
public class TestAction extends DefaultAction {

	/** Logger de la clase. */
    private static final Logger logger = Logger.getLogger(TestAction.class);

    
    /**
     * Constructor.
     * 
     */
    public TestAction() {
    	super();
    }

    /**
     * Ejecuta la acci�n.
     * @param rctx Contexto de ejecuci�n de la regla
     * @param attContext Atributos con informaci�n extra, utilizados dentro de la ejecuci�n de la regla.
     * @return true si la ejecuci�n termina correctamente, false en caso contrario.
     * @throws ActionException
     */
    public boolean execute(RuleContext rctx, AttributeContext attContext) 
    		throws ActionException {
    	
        if (logger.isInfoEnabled()) {
            logger.info("Acci�n [" + this.getClass().getName() + "] ejecutada");
        }

        if (logger.isDebugEnabled()){
            Map pps = rctx.getProperties();
            logger.info("-----------Propiedades----------------------");
            Map.Entry entrada;
	        for (Iterator iter = pps.entrySet().iterator(); iter.hasNext();) {
	            entrada =  (Map.Entry) iter.next();
	            logger.debug(entrada.getKey() + ": " + entrada.getValue());
	        }

	        Map atts = attContext.getProperties();
            logger.info("-----------Atributos------------------------");
            logger.info("at01: "+attContext.getAttribute("at01"));
            for (Iterator iter = atts.entrySet().iterator(); iter.hasNext();) {
	            entrada = (Map.Entry) iter.next();
	                logger.info(entrada.getKey()+":"+entrada.getValue());
	        }
        }
        
        return true;
    }
}