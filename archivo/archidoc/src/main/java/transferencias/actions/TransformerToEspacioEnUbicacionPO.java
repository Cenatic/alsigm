package transferencias.actions;

import org.apache.commons.collections.Transformer;

import common.bi.ServiceRepository;

import deposito.vos.DepositoVO;

/**
 * Utilidad para la transformaci�n de los value objects para elemento del fondo
 * f�sico de tipo Ubicaci�n en sus correspondientes objetos de presentaci�n
 */
public class TransformerToEspacioEnUbicacionPO implements Transformer {

	ServiceRepository services = null;
	String formato = null;

	public TransformerToEspacioEnUbicacionPO(ServiceRepository services,
			String formato) {
		this.services = services;
		this.formato = formato;
	}

	public Object transform(Object obj) {
		return new EspacioEnUbicacionPO(services, (DepositoVO) obj, formato);
	}

	public static TransformerToEspacioEnUbicacionPO getInstance(
			ServiceRepository services, String formato) {
		return new TransformerToEspacioEnUbicacionPO(services, formato);
	}
}
