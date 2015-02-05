package deposito.db;

import deposito.vos.InformeOcupacion;
import deposito.vos.OcupacionElementoDeposito;

/**
 * Interface con los m�todos de acceso a datos referentes a la ocupaci�n de los
 * fondos f�sicos
 */
public interface IOcupacionDBEntity {
	/**
	 * Recupera los datos de ocupaci�n de una de las ubicaciones del fondo
	 * f�sico
	 * 
	 * @param idElementoAsignable
	 *            Identificador de la ubicaci�n
	 * @return Datos de ocupaci�n del elemento
	 */
	public InformeOcupacion getInformeOcupacionDeposito(String idDeposito);

	/**
	 * Recupera los datos de ocupaci�n de un elemento no asignable del fondo
	 * f�sico
	 * 
	 * @param idElementoAsignable
	 *            Identificador del elemento no asignable
	 * @return Datos de ocupaci�n del elemento
	 */
	public InformeOcupacion getInformeOcupacionElementoNoAsignable(
			String idNoAsignable);

	// /**
	// * Recupera los datos de ocupaci�n de un elemento asignable del fondo
	// f�sico
	// * @param idElementoAsignable Identificador del elemento asignable
	// * @return Datos de ocupaci�n del elemento
	// */
	// public InformeOcupacion getInformeOcupacionElementoAsignable(String
	// idAsignable);

	/**
	 * Recupera la ocupaci�n de los huecos del formato indicado para una
	 * ubicaci�n del fondo f�sico
	 * 
	 * @param idUbicacion
	 *            Identificador de ubicaci�n
	 * @param idFormato
	 *            Identificador de formato. Puede ser nulo
	 * @return Datos de ocupaci�n de la ubicaci�n
	 */
	public OcupacionElementoDeposito getOcupacionUbicacion(String idUbicacion,
			String idFormato);

	/**
	 * Recupera la ocupaci�n de los huecos del formato indicado para un elemento
	 * no asignable del fondo f�sico
	 * 
	 * @param idUbicacion
	 *            Identificador de elemento no asignable
	 * @param tipoElemento
	 *            Tipo de elemento no asignable
	 * @param idFormato
	 *            Identificador de formato. Puede ser nulo
	 * @return Datos de ocupaci�n del elemento no asignable
	 */
	public OcupacionElementoDeposito getOcupacionElementoNoAsignable(
			String idElemento, String tipoElemento, String idFormato);

	/**
	 * Recupera la ocupaci�n de los huecos del formato indicado para un elemento
	 * asignable del fondo f�sico
	 * 
	 * @param idElementoAsignable
	 *            Identificador de elemento asignable
	 * @param tipoElemento
	 *            Tipo de elemento asignable
	 * @param idFormato
	 *            Identificador de formato. Puede ser nulo
	 * @return Datos de ocupaci�n del elemento asignable
	 */
	public OcupacionElementoDeposito getOcupacionElementoAsignable(
			String idElementoAsignable, String tipoElemento, String idFormato);

}