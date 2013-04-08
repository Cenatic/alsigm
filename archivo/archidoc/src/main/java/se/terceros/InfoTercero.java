package se.terceros;

/**
 * Interfaz para la informaci�n de un elemento dentro de la base de datos de
 * Terceros.
 */
public interface InfoTercero {

	/**
	 * Devuelve el identificador �nico del usuario.
	 * 
	 * @return Identificador �nico del usuario.
	 */
	public String getId();

	/**
	 * Devuelve la identificaci�n.
	 * 
	 * @return Identificaci�n.
	 */
	public String getIdentificacion();

	/**
	 * Devuelve el nombre del tercero.
	 * 
	 * @return Nombre.
	 */
	public String getNombre();

	/**
	 * Devuelve el primer apellido del tercero.
	 * 
	 * @return Primer apellido.
	 */
	public String getPrimerApellido();

	/**
	 * Devuelve el segundo apellido del tercero.
	 * 
	 * @return Segundo apellido.
	 */
	public String getSegundoApellido();

	/**
	 * Devuelve la direcci�n del tercero.
	 * 
	 * @return Direcci�n.
	 */
	public String getDireccion();

	/**
	 * Devuelve el e-mail del tercero.
	 * 
	 * @return E-mail.
	 */
	public String getEmail();
}
