package fondos.actions;

import deposito.model.GestorEstructuraDepositoBI;
import deposito.vos.HuecoVO;
import deposito.vos.UDocEnUiDepositoVO;

/**
 * Datos de presentaci�n de una signatura de unidad documental. Pueden existir
 * varias signaturas para una misma unidad documental bien porque la unidad
 * documental tenga un tama�o que obligue a dividirla en varias unidades de
 * instalaci�n o bien porque parte de la documentaci�n haya sido incoporada
 * mediante una ampliaci�n de documentaci�n.
 */
public class SignaturaUdocPO extends UDocEnUiDepositoVO {
	GestorEstructuraDepositoBI depositoBI = null;

	SignaturaUdocPO(GestorEstructuraDepositoBI depositoBI) {
		this.depositoBI = depositoBI;
	}

	public HuecoVO getUbicacionFisica() {
		HuecoVO huecoUdoc = null;
		try {
			huecoUdoc = depositoBI.getHuecoUInstalacion(getIduinstalacion());
		} catch (Exception e) {
		}
		return huecoUdoc;
	}
}