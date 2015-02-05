package ieci.tdw.ispac.ispacweb.session;

import ieci.tdw.ispac.api.ISchedulerAPI;
import ieci.tdw.ispac.api.impl.InvesflowAPI;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispacweb.scheduler.SchedulerTask;

import org.apache.log4j.Logger;

public class ISPACScheduler extends SchedulerTask {
	
	/**
	 * Logger de la clase.
	 */ 
	private static final Logger logger = Logger.getLogger(ISPACScheduler.class);

	public void run() {

		logger.info("Inicio de ejecuci�n de la tarea: " + this.getClass().getName());
		
		// Componer el contexto de cliente
		ClientContext ctx = new ClientContext();
		ctx.setAPI(new InvesflowAPI(ctx));
		
		runAll(ctx);
	}

	protected void runAll(ClientContext ctx) {

		notifyOutdatedTask(ctx);
		notifyOutdatedStages(ctx);
		notifyOutdatedProcess(ctx);
	}
	
	protected void notifyOutdatedTask(ClientContext ctx) {

		logger.info("Notificando los tr�mites caducados...");
		
		try {

			ISchedulerAPI schedulerAPI = ctx.getAPI().getSchedulerAPI();
			schedulerAPI.notifyOutdatedTask();
			
			logger.info("Notificaci�n de tr�mites caducados finalizada con �xito");

		} catch (Throwable e) {
			logger.error("Error al notificar los tr�mites caducados", e);
		}
	}

	protected void notifyOutdatedStages(ClientContext ctx) {

		logger.info("Notificando las fases caducadas...");
		
		try {

			ISchedulerAPI schedulerAPI = ctx.getAPI().getSchedulerAPI();
			schedulerAPI.notifyOutdatedStages();
			
			logger.info("Notificaci�n de fases caducadas finalizada con �xito");

		} catch (Throwable e) {
			logger.error("Error al notificar las fases caducadas", e);
		}
	}

	protected void notifyOutdatedProcess(ClientContext ctx) {

		logger.info("Notificando los procesos caducados...");
		
		try {

			ISchedulerAPI schedulerAPI = ctx.getAPI().getSchedulerAPI();
			schedulerAPI.notifyOutdatedProcess();
			
			logger.info("Notificaci�n de procesos caducados finalizada con �xito");

		} catch (Throwable e) {
			logger.error("Error al notificar los procesos caducados", e);
		}
	}
}