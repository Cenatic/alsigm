package se.geograficos;

/**
 * Informaci�n de una poblaci�n.
 */
public class Poblacion extends Municipio implements Comparable {

	/** C�digo del municipio. */
	private String codigoMunicipio = null;

	/**
	 * Constructor.
	 */
	public Poblacion() {
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
	 * @param codigo
	 *            C�digo de la poblaci�n.
	 * @param nombre
	 *            Nombre de la poblaci�n.
	 */
	public Poblacion(String codigoPais, String codigoProvincia,
			String codigoMunicipio, String codigo, String nombre) {
		setCodigoPais(codigoPais);
		setCodigoProvincia(codigoProvincia);
		setCodigoMunicipio(codigoMunicipio);
		setCodigo(codigo);
		setNombre(nombre);
	}

	/**
	 * Obtiene el c�digo del municipio.
	 * 
	 * @return C�digo del municipio.
	 */
	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	/**
	 * Establece el c�digo del municipio.
	 * 
	 * @param codigoMunicipio
	 *            C�digo del municipio.
	 */
	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	/**
	 * Compara este objeto con el objeto especificado.
	 * 
	 * @return N�mero negativo, cero o positivo si este objeto es menor, igual o
	 *         mayor que el especificado, respectivamente.
	 */
	public int compareTo(Object poblacion) {
		return getNombre().compareTo(((Poblacion) poblacion).getNombre());
	}
}
