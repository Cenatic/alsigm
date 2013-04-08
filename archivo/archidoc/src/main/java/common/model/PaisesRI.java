package common.model;

import java.util.List;

import common.vos.ComunidadVO;
import common.vos.PaisVO;

/**
 * Interfaz a trav�s del que obtener los paises y comunidades aut�nomas a las
 * que se permite asociar los fondos documentales gestionados por el sistema
 */
public interface PaisesRI {
	/**
	 * Obtiene la lista con los paises a los que se pueden asociar los fondos
	 * documentales gestionados por el sistema
	 * 
	 * @return Lista de paises {@link PaisVO}
	 */
	public List getAllPaises();

	/**
	 * Obtiene los datos de un determinado pais
	 * 
	 * @param idPais
	 *            Identificador del pais
	 */
	public PaisVO getPaisXId(String id);

	/**
	 * Obtiene los datos de una comunidad a la que se pueden asociar los fondos
	 * documentales gestionados por el sistema.
	 * 
	 * @param codPais
	 *            C�digo del pais al que pertenece la comunidad
	 * @param codComunidad
	 *            C�dico de la comunidad
	 */
	public ComunidadVO getComunidad(String codPais, String codComunidad);
}