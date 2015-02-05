package descripcion.actions;

import descripcion.model.xml.card.TipoFicha;

/**
 * Acci�n para la gesti�n de las fichas ISAD(G) de los elementos del cuadro de
 * clasificaci�n.
 */
public class ISADGAction extends FichaBaseAction {

	/**
	 * Obtiene el tipo de ficha.
	 * 
	 * @return Tipo de ficha {@link TipoFicha}.
	 */
	protected int getTipoFicha() {
		return TipoFicha.FICHA_ELEMENTO_CF;
	}

}