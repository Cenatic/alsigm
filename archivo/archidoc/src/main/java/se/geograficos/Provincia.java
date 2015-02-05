package se.geograficos;

/**
 * Informaci�n de una provincia.
 */
public class Provincia extends Pais {

	/** C�digo del pa�s. */
	private String codigoPais = null;

	/**
	 * Constructor.
	 */
	public Provincia() {
	}

	/**
	 * Constructor.
	 * 
	 * @param codigoPais
	 *            C�digo del pa�s.
	 * @param codigo
	 *            C�digo de la provincia.
	 * @param nombre
	 *            Nombre de la provincia.
	 */
	public Provincia(String codigoPais, String codigo, String nombre) {
		setCodigoPais(codigoPais);
		setCodigo(codigo);
		setNombre(nombre);
	}

	/**
	 * Obtiene el c�digo del pa�s.
	 * 
	 * @return C�digo del pa�s.
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Establece el c�digo del pa�s.
	 * 
	 * @param codigoPais
	 *            C�digo del pa�s.
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
}
