package ieci.tecdoc.sgm.admsistema.proceso.importacion;

import ieci.tecdoc.sgm.admsistema.proceso.clonar.CloneProcessImpl;

import java.util.Map;

/** 
 * @author Iecisa 
 * @version $Revision$ 
 *
 */
public class ImportProcessImpl extends CloneProcessImpl {

	/**
	 * Constructor.
	 */
	public ImportProcessImpl() {
		super();
	}

	/**
	 * Realiza la importaci�n del repositorio documental de una entidad
	 * @param options Par�metros para la importaci�n
	 * @return true si la importaci�n se ha realizado con �xito. 
	 * @throws Exception si ocurre alg�n error.
	 */
	public boolean execute(Map options) throws Exception {

		try {
			executeImport(options);
			
			if (isOk()) {
				getImportLogger().info("[FIN] Proceso de importaci�n ha finalizado correctamente");
			} else  {
				getImportLogger().warn("[FIN] Proceso de importaci�n ha finalizado con ERRORES");
			}
		} finally {
			releaseLogger(getImportLogger());
		}
		
		return isOk();
	}

}
