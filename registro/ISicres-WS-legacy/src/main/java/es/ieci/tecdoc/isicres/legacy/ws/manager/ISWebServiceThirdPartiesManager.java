package es.ieci.tecdoc.isicres.legacy.ws.manager;

import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.ArrayOfWSPostalAddress;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.ArrayOfWSPostalAddressData;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.ArrayOfWSStakeholder;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.ArrayOfWSThirdPartyPhisical;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.Security;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSCitiesResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSCityResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadCities;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadCitiesResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadPostalAddressesByThirdParty;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadPostalAddressesByThirdPartyResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadProvinces;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSLoadProvincesResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSPostalAddressesResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSProvinceResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSStakeholder;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSStakeholderData;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSThirdPartyPhisical;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSThirdPartyPhisicalByDocumentNumber;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSThirdPartyPhisicalByDocumentNumberResponse;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSThirdPartyPhisicalData;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSUpdateThirdPartyPhisical;
import es.ieci.tecdoc.isicres.ws.legacy.service.thirdparties.WSUpdateThirdPartyPhisicalResponse;

public interface ISWebServiceThirdPartiesManager {

	/**
	 * Devuelve un listado de ciudades
	 * 
	 * @param parameters
	 * @param security
	 * @return
	 */
	public WSLoadCitiesResponse loadCities(WSLoadCities parameters, Security security);

	/**
	 * Devuelve una ciudad a partir de su c�digo
	 * 
	 * @param code
	 * @param security
	 * @return
	 */
	public WSCityResponse loadCityByCode(String code, Security security);

	/**
	 * A�ade direcciones postales a un tercero.
	 * 
	 * @param idThirdParty
	 * @param addressesToAdd
	 * @param security
	 * @return
	 */
	public WSPostalAddressesResponse addPostalAddresses(int idThirdParty,
			ArrayOfWSPostalAddressData addressesToAdd, Security security);

	/**
	 * Devuelve una ciudad a partir de su identificador
	 * 
	 * @param id
	 * @param security
	 * @return
	 */
	public WSCityResponse loadCityById(long id, Security security);

	/**
	 * Devuelve un listado de ciudades a partir del identificador de la
	 * provincia y nombre de la provincia
	 * 
	 * @param idProv
	 * @param nameProv
	 * @param initValue
	 * @param size
	 * @param security
	 * @return
	 */
	public WSCitiesResponse loadCityByIdProvNameProv(long idProv, String nameProv, int initValue,
			int size, Security security);
	
	/**
	 * Devuelve una ciudad a partir de su nombre
	 * 
	 * @param name
	 * @param security
	 * @return
	 */
	public WSCityResponse loadCityByName(String name, Security security);
	
	/**
	 * Devuelve un listado de Direcciones que est�n asociadas a un Tercero
	 * @param parameters
	 * @param security
	 * @return
	 */
	public WSLoadPostalAddressesByThirdPartyResponse loadPostalAddressesByThirdParty(
			WSLoadPostalAddressesByThirdParty parameters, Security security);
	
	
	/**
	 * Devuelve una provincia a partir de su c�digo
	 * 
	 * @param code
	 * @param security
	 * @return
	 */
	public WSProvinceResponse loadProvinceByCode(String code, Security security);
	
	
	/**
	 * Devuelve una provincia a partir de su identificador
	 * 
	 * @param id
	 * @param security
	 * @return
	 */
	public WSProvinceResponse loadProvinceById(long id, Security security);
	
	/**
	 * Devuelve una provincia a partir de su nombre
	 * 
	 * @param name
	 * @param security
	 * @return
	 */
	public WSProvinceResponse loadProvinceByName(String name, Security security);
	
	
	/**
	 * Devuelve un listado de todas las provincias
	 * 
	 * @param parameters Par�metros del listado
	 * @param security
	 * @return
	 */
	public WSLoadProvincesResponse loadProvinces(WSLoadProvinces parameters, Security security);
	
	public WSStakeholder addStakeholder(WSStakeholderData thirdPartyPhisicalToAdd,
			Security security) ;
	
	/**
	 * Devuelve un listado de Interesados para un libro y un directorio.
	 * 
	 * @param bookId
	 * @param folderId
	 * @param security
	 * @return
	 */
	public ArrayOfWSStakeholder loadStakeholders(long bookId, long folderId, Security security);
	
	/**
	 * Elimina un interesado a partir de su identificador
	 * @param idStakeholder
	 * @param security
	 * @return
	 */
	public long removeStakeholder(long idStakeholder, Security security);
	
	/**
	 * A�ade un t�rcero de tipo "F�sico", no "Jur�dico".
	 * 
	 * @param thirdPartyPhisicalToAdd
	 * @param security
	 * @return
	 */
	public WSThirdPartyPhisical addThirdPartyPhisical(
			WSThirdPartyPhisicalData thirdPartyPhisicalToAdd, Security security);
	
	
	/**
	 * 
	 * Devuelve un tercero de tipo f�sico a partir de su n�mero de documento
	 * 
	 * @param security
	 * @return
	 */
	public ArrayOfWSThirdPartyPhisical wsThirdPartyPhisicalByDocumentNumber(long tipoDocumento,
			String documentNumber, Security security);
	
	/**
	 * Actualiza la direcci�n de notificaci�n de un interesado
	 * 
	 * @param idStakeholder
	 * @param idAddress
	 * @param security
	 * @return
	 */
	public long updateNotifyAddressStakeholder(long idStakeholder, long idAddress,
			Security security);
	
	/**
	 * Actualiza un listado de direcciones postales
	 * 
	 * @param addressesToMod
	 * @param security
	 * @return
	 */
	public WSPostalAddressesResponse wsUpdatePostalAddresses(ArrayOfWSPostalAddress addressesToMod,
			Security security);
	
	/**
	 * Actualiza la direcci�n f�sica asociada a un tercero
	 * 
	 * @param thirdPartyPhisicalToAdd
	 * @param security
	 * @return
	 */
	WSThirdPartyPhisical updateThirdPartyPhisical(
			WSThirdPartyPhisical thirdPartyPhisicalToAdd, Security security);

}
