package se.geograficos;

/**
 * Informaci�n de un pa�s.
 */
public class Pais implements NodoGeografico {

	/** C�digo del nodo geogr�fico. */
	private String codigo = null;

	/** Nombre del nodo geogr�fico. */
	private String nombre = null;

	/**
	 * Constructor.
	 */
	public Pais() {
	}

	/**
	 * Constructor.
	 * 
	 * @param codigo
	 *            C�digo del pa�s.
	 * @param nombre
	 *            Nombre del pa�s.
	 */
	public Pais(String codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}

	/**
	 * Devuelve el c�digo. Si no tiene c�digo asociado se devuelve nulo.
	 * 
	 * @return C�digo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Devuelve el nombre del nodo.
	 * 
	 * @return Nombre del nodo.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el c�digo del nodo geogr�fico.
	 * 
	 * @param codigo
	 *            C�digo del nodo geogr�fico.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Establece el nombre del nodo geogr�fico.
	 * 
	 * @param nombre
	 *            Nombre del nodo geogr�fico.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
