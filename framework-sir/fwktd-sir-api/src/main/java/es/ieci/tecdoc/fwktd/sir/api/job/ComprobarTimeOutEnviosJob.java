package es.ieci.tecdoc.fwktd.sir.api.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import es.ieci.tecdoc.fwktd.sir.core.service.ServicioIntercambioRegistral;

/**
 * Job que comprueba el time-out de la recepci�n de mensajes de ACK o ERROR en los env�os
 * de ficheros de datos de intercambio.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class ComprobarTimeOutEnviosJob extends QuartzJobBean {

	private static Logger logger = LoggerFactory
			.getLogger(ComprobarTimeOutEnviosJob.class);

	/**
	 * Servicio de intercambio registral.
	 */
	private ServicioIntercambioRegistral servicioIntercambioRegistral = null;

	/**
	 * Constructor.
	 */
	public ComprobarTimeOutEnviosJob() {
		super();
	}

	public ServicioIntercambioRegistral getServicioIntercambioRegistral() {
		return servicioIntercambioRegistral;
	}

	public void setServicioIntercambioRegistral(
			ServicioIntercambioRegistral servicioIntercambioRegistral) {
		this.servicioIntercambioRegistral = servicioIntercambioRegistral;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		logger.info("Inicio del job para la comprobaci�n del time-out en los env�os");

		try {

			// Procesar los ficheros
			getServicioIntercambioRegistral().comprobarTimeOutEnvios();

			context.setResult("Ok");

		} catch (Throwable e) {
			logger.error("Error al lanzar la comprobaci�n del time-out en los env�os", e);
			context.setResult("Error al lanzar la comprobaci�n del time-out en los env�os: "
					+ e.toString());
			throw new JobExecutionException(
					"Error al lanzar la comprobaci�n del time-out en los env�os", e);
		} finally {
			logger.info("Fin del job para la comprobaci�n del time-out en los env�os");
		}
	}

}
