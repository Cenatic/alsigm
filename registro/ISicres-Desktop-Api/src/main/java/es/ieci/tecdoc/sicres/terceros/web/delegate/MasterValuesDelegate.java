package es.ieci.tecdoc.sicres.terceros.web.delegate;

import java.util.List;

import es.ieci.tecdoc.isicres.terceros.business.vo.CiudadVO;
import es.ieci.tecdoc.isicres.terceros.business.vo.PaisVO;
import es.ieci.tecdoc.isicres.terceros.business.vo.ProvinciaVO;
import es.ieci.tecdoc.isicres.terceros.business.vo.TipoDireccionTelematicaVO;
import es.ieci.tecdoc.isicres.terceros.business.vo.TipoDocumentoIdentificativoTerceroVO;
import es.ieci.tecdoc.isicres.terceros.business.vo.search.SearchType;

/**
 *
 * @author IECISA
 *
 */
public interface MasterValuesDelegate {

	/**
	 *
	 * @return
	 */
	public List<TipoDocumentoIdentificativoTerceroVO> getTiposDocumentoIdentificativo();

	/**
	 *
	 * @param type
	 * @return
	 */
	public List<TipoDocumentoIdentificativoTerceroVO> getTiposDocumentoIdentificativo(
			SearchType type);

	/**
	 *
	 * @return
	 */
	public List<TipoDireccionTelematicaVO> getTiposDireccionesTelematicas();

	/**
	 *
	 * @return
	 */
	public List<CiudadVO> getCiudades();

	/**
	 * Devuelve las ciudades pertenecientes a la provincia que se recibe por
	 * par�metro
	 *
	 * @param provincia
	 * @return
	 */
	public List<CiudadVO> getCiudades(ProvinciaVO provincia);

	/**
	 * Devuelve una instancia de <code>CiudadVO</code> en funci�n del c�digo de
	 * ciudad que se pasa como par�metro.
	 *
	 * @param codigo
	 * @return
	 */
	public CiudadVO getCiudad(String codigo);

	/**
	 *
	 * @return
	 */
	public List<ProvinciaVO> getProvincias();

	/**
	 * Devuelve una instancia de <code>Provincia</code> en funci�n del c�digo de
	 * provincia que se pasa como par�metro.
	 *
	 * @param codigo
	 * @return
	 */
	public ProvinciaVO getProvincia(String codigo);

	/**
	 *
	 * @return
	 */
	public List<PaisVO> getPaises();

	/**
	 * Devuelve una instancia de <code>PaisVO</code> en funci�n del c�digo de
	 * pa�s que se pasa como par�metro.
	 *
	 * @param codigo
	 * @return
	 */
	public PaisVO getPais(String codigo);
}
