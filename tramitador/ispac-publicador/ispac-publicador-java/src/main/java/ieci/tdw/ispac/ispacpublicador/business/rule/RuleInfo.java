/*
 * Created on 17-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.rule;

/**
 * Clase que contiene informaci�n descriptiva de una operaci�n.
 * @author Ildefonso Nore�a
 *
 */
public class RuleInfo extends RuleMessage {

    
    /**
     * Construye un RuleInfo inicializando sus atributos. 
     */
    public RuleInfo() {
        this(-1, -1,null,null);
    }
    
    /**
     * Construye un RuleInfor inicializando sus atributos con los par�metros pasados.
     * @param idRule
     * @param id
     * @param name
     * @param message
     */
    public RuleInfo(int idRule, int id, String name, String message){
        setIdRule(idRule);
        setId(id);
        setName(name);
        setMessage(message);
    }    
    
    public String toString(){
       return "[INFO]->"+super.toString();
    }
}
