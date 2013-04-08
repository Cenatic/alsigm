package ieci.tecdoc.sgm.usuario.datatypes;

/**
 * Interfaz de comportamiento de un elemento mime.
 * 
 * @author IECISA
 *
 */
public interface Usuario 
{

	/**
	 * Devuelve el usuario de acceso.
	 * @return String Usuario.
	 */
	public abstract String getUsuario();
	
	/**
	 * Devuelve la contrase�a de acceso.
	 * @return String Contrase�a.
	 */
	public abstract String getPassword();
	
	/**
	 * Devuelve el correo electr�nicodel usuario.
	 * @return String Correo electr�nico.
	 */
	public abstract String getEmail();
	
	/**
	 * Devuelve el documento de identidad del usuario.
	 * @return String Documento de identidad.
	 */
	public abstract String getId();
	
	/**
	 * Devuelve el nombre del usuario.
	 * @return String Nombre del usuario.
	 */
	public abstract String getNombre();
	
	/**
	 * Devuelve los apellidos del usuario.
	 * @return String Apellidos del usuario.
	 */
	public abstract String getApellidos();
	
	/**
	 * Estable el usuario de acceso.
	 * @param usuario Usuario.
	 */
	public abstract void setUsuario(String usuario);
	
	/**
	 * Estable la contrase�a de acceso.
	 * @param password Contrase�a.
	 */
	public abstract void setPassword(String password);
	
	/**
	 * Estable el correo electr�nico del usuario.
	 * @param email Correo electr�nico.
	 */
	public abstract void setEmail(String email);
	
	/**
	 * Estable el documento de identidad.
	 * @param id Documento de identidad.
	 */
	public abstract void setId(String id);
	
	/**
	 * Estable el nombre del usuario.
	 * @param nombre Nombre del usuario.
	 */
	public abstract void setNombre(String nombre);
	
	/**
	 * Estable los apellidos del usuario.
	 * @param apellidos Apellidos del usuario.
	 */
	public abstract void setApellidos(String apellidos);
	
    /**
     * Recoge los valores de la instancia en una cadena xml
     * @param header Si se incluye la cabecera
     * @return los datos en formato xml
     */
	public abstract String toXML(boolean header);

	/**
     * Devuelve los valores de la instancia en una cadena de caracteres.
     */
	public abstract String toString();

}