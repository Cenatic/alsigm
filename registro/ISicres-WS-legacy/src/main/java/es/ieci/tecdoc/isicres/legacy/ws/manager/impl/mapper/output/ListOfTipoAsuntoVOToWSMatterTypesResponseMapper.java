package es.ieci.tecdoc.isicres.legacy.ws.manager.impl.mapper.output;

import java.util.List;

import org.springframework.util.Assert;

import es.ieci.tecdoc.isicres.api.business.vo.TipoAsuntoVO;
import es.ieci.tecdoc.isicres.legacy.ws.manager.impl.mapper.Mapper;
import es.ieci.tecdoc.isicres.ws.legacy.service.matters.ArrayOfWSMatterType;
import es.ieci.tecdoc.isicres.ws.legacy.service.matters.WSMatterType;
import es.ieci.tecdoc.isicres.ws.legacy.service.matters.WSMatterTypesResponse;

/**
 * Instancia de <code>Mapper</code> que transforma una <code>List</code> de
 * <code>TipoAsuntoVO</code> en un objeto de tipo
 * <code>WSMatterTypesResponse</code>.
 * 
 * @see TipoAsuntoVO
 * @see WSMatterTypesResponse
 * 
 * @author IECISA
 * 
 */
public class ListOfTipoAsuntoVOToWSMatterTypesResponseMapper implements Mapper {

	/**
	 * Constructor con par�metros de la clase.
	 * 
	 * @param aTotal
	 *            n�mero total de tipos de asunto sin tener en cuenta
	 *            restricciones de b�squeda
	 */
	public ListOfTipoAsuntoVOToWSMatterTypesResponseMapper(int aTotal) {
		setTotal(aTotal);
	}

	@SuppressWarnings("unchecked")
	public Object map(Object obj) {
		Assert.isInstanceOf(List.class, obj);

		List<TipoAsuntoVO> tipos = (List<TipoAsuntoVO>) obj;

		WSMatterTypesResponse result = new WSMatterTypesResponse();
		result.setList(new ArrayOfWSMatterType());

		for (TipoAsuntoVO tipo : tipos) {
			result.getList().getWSMatterType().add(
					(WSMatterType) new TipoAsuntoVOToWSMatterTypeMapper()
							.map(tipo));
		}

		result.setTotal(getTotal());

		return result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// Members
	protected int total;

}
