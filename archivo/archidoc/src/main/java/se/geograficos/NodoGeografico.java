package se.geograficos;

/**
 * Interfaz para la informaci�n de un elemento dentro de la jerarqu�a
 * geogr�fica.
 */
public interface NodoGeografico {

	/**
	 * Devuelve el c�digo. Si no tiene c�digo asociado se devuelve nulo.
	 * 
	 * @return C�digo.
	 */
	public String getCodigo();

	/**
	 * Devuelve el nombre del nodo.
	 * 
	 * @return Nombre del nodo.
	 */
	public String getNombre();
}
