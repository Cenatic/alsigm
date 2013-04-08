package descripcion.actions;

import descripcion.model.xml.card.TipoFicha;

/**
 * Acci�n para la gesti�n de las fichas ISAD(G) de las unidades documentales en
 * divisi�n de fracci�n de serie
 */
public class ISADGUDocFSAction extends FichaBaseAction {

	/**
	 * Obtiene el tipo de ficha.
	 * 
	 * @return Tipo de ficha {@link TipoFicha}.
	 */
	protected int getTipoFicha() {
		return TipoFicha.FICHA_UDOCFS;
	}

}