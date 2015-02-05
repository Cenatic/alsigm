package descripcion.actions;

import descripcion.model.xml.card.TipoFicha;

/**
 * Acci�n para la gesti�n de las fichas ISAAR de los descriptores.
 */
public class ISAARAction extends FichaBaseAction {

	/**
	 * Obtiene el tipo de ficha.
	 * 
	 * @return Tipo de ficha {@link TipoFicha}.
	 */
	protected int getTipoFicha() {
		return TipoFicha.FICHA_DESCRIPTOR;
	}

}