package fondos.actions;

import org.apache.commons.collections.Transformer;

import common.view.POUtils;

import deposito.model.GestorEstructuraDepositoBI;

/**
 * Transformer para la obtenci�n de los datos de presentaci�n de signatura de
 * unidad documental
 */
public class SignaturaUdoc2PO implements Transformer {
	GestorEstructuraDepositoBI depositoBI = null;

	SignaturaUdoc2PO(GestorEstructuraDepositoBI depositoBI) {
		this.depositoBI = depositoBI;
	}

	public Object transform(Object vo) {
		SignaturaUdocPO po = new SignaturaUdocPO(depositoBI);
		POUtils.copyVOProperties(po, vo);
		return po;
	}
}
