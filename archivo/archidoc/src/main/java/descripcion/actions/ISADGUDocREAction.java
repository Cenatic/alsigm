package descripcion.actions;

import descripcion.model.xml.card.TipoFicha;

/**
 * Acci�n para la gesti�n de las fichas ISAD(G) de las unidades documentales en
 * relaci�n de entrega
 */
public class ISADGUDocREAction extends FichaBaseAction {

	/**
	 * Obtiene el tipo de ficha.
	 * 
	 * @return Tipo de ficha {@link TipoFicha}.
	 */
	protected int getTipoFicha() {
		return TipoFicha.FICHA_UDOCRE;
	}

}