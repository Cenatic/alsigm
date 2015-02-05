package ieci.tdw.ispac.ispaclib.sicres.vo;

/**
 * Informaci�n sobre un asunto.
 */
public class Subject {
	
	/* C�digo del asunto.
     */
	private String code;
	
	/* Descripci�n o nombre del asunto.
     */
    private String name;

    public Subject() {
    }

    public Subject(String code,
    					  String name) {
    	
        this.code = code;
        this.name = name;
    }

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
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
    
}