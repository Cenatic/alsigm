package ieci.tecdoc.sgm.admsistema.proceso.exportacion;

import ieci.tecdoc.sgm.admsistema.proceso.clonar.CloneProcessImpl;

import java.util.Map;

/** 
 * @author Iecisa 
 * @version $Revision$ 
 *
 */

public class ExportProcessImpl extends CloneProcessImpl {

	/**
	 * Constructor.
	 */
	public ExportProcessImpl() {
		super();
	}
		
	/**
	 * Realiza la exportaci�n del repositorio documental de una entidad
	 * @param options Par�metros para la exportaci�n
	 * @return true si la exportaci�n se ha realizado con �xito. 
	 * @throws Exception si ocurre alg�n error.
	 */
	public boolean execute(Map options) throws Exception {

		try {
			executeExport(options);
			
			if (isOk()) {
				getExportLogger().info("[FIN] Proceso de exportaci�n ha finalizado correctamente");
			} else  {
				getExportLogger().warn("[FIN] Proceso de exportaci�n ha finalizado con ERRORES");
			}
		} finally {
			releaseLogger(getExportLogger());
		}
		
		return isOk();
	}

}
