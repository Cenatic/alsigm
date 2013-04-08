package configuracion.db;

import common.db.IDBEntity;
import common.vos.DatosGeograficosVO;
import common.vos.PaisesVO;

/**
 * Entidad: <b>AGINFOSISTEMA</b>
 * 
 * @author IECISA
 * 
 */
public interface IInfoSistemaDBEntity extends IDBEntity {

	/**
	 * Obtiene la Informaci�n de P�is Comunidad y Provincia.
	 * 
	 * @return
	 */
	public DatosGeograficosVO getDatosGeograficos();

	/**
	 * Obtiene Informaci�n de P�ises y Comunidades
	 * 
	 * @return
	 */
	public PaisesVO getMapPaises();

	String getManejadorIText();
}
