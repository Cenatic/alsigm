package deposito.actions.hueco;

import org.apache.commons.collections.Transformer;

import common.bi.ServiceRepository;
import common.view.POUtils;

/**
 * Utilidad para la transformaci�n de value objects con la informaci�n de
 * unidades documentales ubicadas en el dep�sito f�sico a objetos para su
 * presentaci�n
 */
public class UdocEnUIToPO implements Transformer {

	ServiceRepository services = null;

	UdocEnUIToPO(ServiceRepository services) {
		super();
		this.services = services;
	}

	public Object transform(Object obj) {
		UdocEnUIPO po = new UdocEnUIPO(services);
		POUtils.copyVOProperties(po, obj);
		return po;
	}

	public static UdocEnUIToPO getInstance(ServiceRepository services) {
		return new UdocEnUIToPO(services);
	}
}
