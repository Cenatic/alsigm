package ieci.tecdoc.sgm.tram.secretaria.rules.libro;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tecdoc.sgm.tram.secretaria.helper.SecretariaConstants;



/**
 *Establece el n�mero de hojas de la correcci�n Error de las sesiones
 *
 */
public class SetNumHojasCorreccionErrorActaRule extends SetNumHojasRule {


	public String getIdTpDoc() throws ISPACException {

		return ctx.getAPI().getCatalogAPI().getIdTpDocByCode(SecretariaConstants.COD_TPDOC_C_ERROR_SP);
	}

	/**
	 * Indica si es un documento asociado a nivel de entidad
	 * @return
	 */
	public boolean isDocReg(){return true;}

	public String getKeyMessage(){
		return "aviso.cant.close.diligenciaCorreccionError.sinFirma";
	}


}
