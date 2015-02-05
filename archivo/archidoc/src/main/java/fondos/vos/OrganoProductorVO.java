package fondos.vos;

import descripcion.vos.DescriptorVO;

/**
 * �rganos incorporados al sistema como posibles productores de documentaci�n
 */
public class OrganoProductorVO extends DescriptorVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador de la entidad productora que corresponde a la instituci�n a
	 * la que pertenece el �rgano Productor
	 */
	String idEntProdInst = null;
	String idOrgano = null;

	public OrganoProductorVO() {
	}

	public String getIdEntProdInst() {
		return this.idEntProdInst;
	}

	public void setIdEntProdInst(String idEntProdInst) {
		this.idEntProdInst = idEntProdInst;
	}

	public String getIdOrgano() {
		return idOrgano;
	}

	public void setIdOrgano(String idOrgano) {
		this.idOrgano = idOrgano;
	}
}
