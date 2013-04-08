package se.geograficos;

/**
 * Informaci�n de un municipio.
 */
public class Municipio extends Provincia {

	/** C�digo de la provincia. */
	private String codigoProvincia = null;

	/**
	 * Constructor.
	 */
	public Municipio() {
	}

	/**
	 * Constructor.
	 * 
	 * @param codigoPais
	 *            C�digo del pa�s.
	 * @param codigo
	 *            C�digo de la provincia.
	 * @param codigo
	 *            C�digo del municipio.
	 * @param nombre
	 *            Nombre del municipio.
	 */
	public Municipio(String codigoPais, String codigoProvincia, String codigo,
			String nombre) {
		setCodigoPais(codigoPais);
		setCodigoProvincia(codigoProvincia);
		setCodigo(codigo);
		setNombre(nombre);
	}

	/**
	 * Obtiene el c�digo de la provincia.
	 * 
	 * @return C�digo de la provincia.
	 */
	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	/**
	 * Establece el c�digo de la provincia.
	 * 
	 * @param codigoProvincia
	 *            C�digo de la provincia.
	 */
	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
}
