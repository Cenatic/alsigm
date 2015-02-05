package fondos.actions;

import org.apache.commons.collections.Transformer;

import common.bi.ServiceRepository;

import fondos.vos.DivisionFraccionSerieVO;

/**
 * Utilidad para la transformaci�n de value objects de divisiones de fracci�n de
 * serie a componentes de presentaci�n
 */
public class DivisionFSToPOTransformer implements Transformer {

	ServiceRepository services = null;

	public DivisionFSToPOTransformer(ServiceRepository services) {
		this.services = services;
	}

	public Object transform(Object obj) {
		return new DivisionFraccionSeriePO((DivisionFraccionSerieVO) obj,
				services);
	}

	public static DivisionFSToPOTransformer getInstance(
			ServiceRepository services) {
		return new DivisionFSToPOTransformer(services);
	}
}
