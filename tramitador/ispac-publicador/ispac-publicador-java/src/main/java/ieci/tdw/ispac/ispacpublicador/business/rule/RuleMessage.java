/*
 * Created on 14-nov-2005
 *
 */
package ieci.tdw.ispac.ispacpublicador.business.rule;

/**
 * Clase que almacenar� informaci�n que describen los datos 
 * que han producido el resultado de una operaci�n.
 * @author Ildefonso Nore�a
 *
 */
public abstract class RuleMessage {

    /**
     * Identificador de la regla en la que se origin� el mensaje. 
     */
    private int idRule;
    /**
     * Identificador del objeto (Condici�n o Acci�) en la que se origin� el mensaje.
     */
    private int id;
    /**
     * Nombre de la clase,que implementar�n IAction � ICondition, en la que se origin� el mensaje.
     */
    private String name;
    /**
     * Mensaje de informaci�n.
     */
    private String message;
    
    
    /**
     * @return Returns the idRule.
     */
    public int getIdRule() {
        return idRule;
    }
    /**
     * @param idRule The idRule to set.
     */
    public void setIdRule(int idRule) {
        this.idRule = idRule;
    }    
    /**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return "message="+getMessage()+",[idRegla="+getIdRule()+",id="+getId()+", name="+getName()+"]";
    }

}
