package se.terceros;

/**
 * Implementaci�n del interfaz para la informaci�n de un elemento dentro de la
 * base de datos de Terceros.
 */
public class InfoTerceroImpl implements InfoTercero {

	/** Identificador �nico del usuario. */
	private String id = null;

	/** Identificaci�n del usuario (NIF, NIE, ...). */
	private String identificacion = null;

	/** Nombre del usuario. */
	private String nombre = null;

	/** Primer apellido del usuario. */
	private String primerApellido = null;

	/** Segundo apellido del usuario. */
	private String segundoApellido = null;

	/** Direcci�n del usuario. */
	private String direccion = null;

	/** E-mail del usuario. */
	private String email = null;

	/**
	 * Constructor.
	 */
	public InfoTerceroImpl() {
	}

	/**
	 * Devuelve la identificaci�n.
	 * 
	 * @return Identificaci�n.
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Devuelve el nombre del usuario.
	 * 
	 * @return Nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el primer apellido del usuario.
	 * 
	 * @return Primer apellido.
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * Devuelve el segundo apellido del usuario.
	 * 
	 * @return Segundo apellido.
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * Devuelve la direcci�n del usuario.
	 * 
	 * @return Direcci�n.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Devuelve el e-mail del usuario.
	 * 
	 * @return E-mail.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Devuelve el identificador �nico del usuario.
	 * 
	 * @return Identificador �nico del usuario.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene la identificaci�n del usuario.
	 * 
	 * @param identificacion
	 *            Identificaci�n del usuario.
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Obtiene el identificador �nico del usuario.
	 * 
	 * @param id
	 *            Identificador �nico del usuario.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @param nombre
	 *            Nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Establece el primer apellido del usuario.
	 * 
	 * @param primerApellido
	 *            Primer apellido del usuario.
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * Establece el segundo apellido del usuario.
	 * 
	 * @param segundoApellido
	 *            Segundo apellido del usuario.
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * Establece la direcci�n del usuario.
	 * 
	 * @param direccion
	 *            Direccion del usuario.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Establece el e-mail del usuario.
	 * 
	 * @param email
	 *            E-mail del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
