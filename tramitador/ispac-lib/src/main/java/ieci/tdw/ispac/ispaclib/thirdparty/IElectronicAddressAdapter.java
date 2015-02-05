package ieci.tdw.ispac.ispaclib.thirdparty;

/**
 * Interfaz del adaptador para contener la informaci�n de la direcci�n electr�nica
 * de un tercero.
 *
 */
public interface IElectronicAddressAdapter {

	/**
	 * La direcci�n electr�nica es una direcci�n de correo electr�nico.
	 */
	public final int MAIL_TYPE = 1;
	
	/**
	 * La direcci�n electr�nica es un n�mero de tel�fono fijo.
	 */
	public final int PHONE_TYPE = 2; 

	/**
	 * La direcci�n electr�nica es un DEU.
	 */
	public final int DEU_TYPE = 3;
	
	/**
	 * La direcci�n electr�nica es un tel�fono m�vil.
	 */
	public final int MOBILE_PHONE_TYPE = 4;

	
	/**
	 * Obtiene el identificador de la direcci�n electr�nica.
	 * @return identificador de la direcci�n electr�nica.
	 */
	public String getId(); 
	
	/**
	 * Obtiene el tipo de direcci�n electr�nica.
	 * @return tipo de direcci�n electr�nica.
	 */
	public int getTipo();

	/**
	 * Obtiene la direcci�n electr�nica.
	 * @return direcci�n electr�nica.
	 */
	public String getDireccion();
	
}
