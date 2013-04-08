package common.vos;

public class DatosGeograficosVO extends BaseVO {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * C�digo del Pa�s
	 */
	private String codigoPais;

	/**
	 * Nombre del Pa�s
	 */
	private String nombrePais;

	/**
	 * C�digo de Provincia
	 */
	private String codigoProvincia;

	/**
	 * Nombre de la Provincia
	 */
	private String nombreProvincia;

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
}
