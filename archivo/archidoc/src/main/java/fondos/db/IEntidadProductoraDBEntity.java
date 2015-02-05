package fondos.db;

import java.util.List;

import common.db.IDBEntity;

import fondos.vos.EntidadProductoraVO;

/**
 * M�todos de acceso a datos referentes a entidades productoras de los fondos
 * del cuadro de clasificaci�n. <br>
 * Entidad: <b>ASGFENTPRODUCTORA</b>
 */
public interface IEntidadProductoraDBEntity extends IDBEntity {

	public abstract EntidadProductoraVO getEntidadXCodigo(final String codigo);

	public abstract EntidadProductoraVO getEntidadXNombre(final String nombre);

	public abstract List getEntidadesXNombre(final String nombre);

	public abstract EntidadProductoraVO getEntidadXIddescr(final String idDescr);

	/**
	 * Recupera la entidad productora constituida por la instituci�n a la que
	 * pertence un �rgano
	 * 
	 * @param idOrgano
	 *            Identificador de �rgano
	 * @return Entidad productora
	 */
	public abstract EntidadProductoraVO getEntidadXOrgano(String idOrgano);

	public abstract void insertEntidad(final EntidadProductoraVO entidadVO);

	public abstract void updateEntidadProductora(EntidadProductoraVO entidadVO);

	public abstract EntidadProductoraVO getEntidadProductoraVO(String qual);

	public abstract void deleteEntidad(String id);

	/**
	 * Unifica el campo <b>ASGFENTPRODUCTORA.IDDESCR</b> con el idDescriptor de
	 * todos los idsAReemplazar
	 * 
	 * @param idDescriptor
	 *            Identificador del descriptor
	 * @param idsAReemplazar
	 *            Identificadores de los descriptores a reemplazar
	 */
	public void unificarDescriptor(String idDescriptor, String[] idsAReemplazar);

}