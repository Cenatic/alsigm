package common.util.terceros;

/**
 * Interfaz para los formularios de b�squedas en terceros.
 */
public interface IThirdPartySearchForm {

	// =======================================================================
	// Constantes para los criterios de b�squeda
	// =======================================================================
	public static final int BUSQUEDA_POR_IF = 0;
	public static final int BUSQUEDA_POR_NOMBRE = 1;
	public static final int BUSQUEDA_POR_RAZON_SOCIAL = 2;

	public static final String[] TIPOS_BUSQUEDA = { "IF", "NOMBRE", "RSOCIAL" };

	// =======================================================================

	/**
	 * Obtiene el tipo de b�squeda en terceros.
    *
	 * @return Tipo de b�squeda en terceros.
	 */
	public String getThirdPartySearchType();

	/**
	 * Obtiene el nombre del tercero a buscar.
    *
	 * @return Nombre del tercero.
	 */
	public String getNameSearchToken();

	/**
	 * Obtiene el primer apellido del tercero a buscar.
    *
	 * @return Primer apellido del tercero.
	 */
	public String getSurname1SearchToken();

	/**
	 * Obtiene el segundo apellido del tercero a buscar.
    *
	 * @return Segundo apellido del tercero.
	 */
	public String getSurname2SearchToken();

	/**
	 * Obtiene la raz�n social del tercero a buscar.
    *
	 * @return Raz�n social del tercero.
	 */
	public String getCompanySearchToken();

	/**
	 * Obtiene la identificaci�n del tercero a buscar.
    *
	 * @return Identificaci�n del tercero.
	 */
	public String getIfSearchToken();


	public int getTipoNumeroIdentificacion();
}
