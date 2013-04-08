package ieci.tecdoc.sgm.admsistema.proceso.borrar;

import ieci.tecdoc.sgm.admsistema.proceso.IProcessManager;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Borrar implements Runnable {
	
	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = Logger.getLogger(Borrar.class);
	
	/**
	 * Par�metros de exportaci�n
	 */
	private Map parameters = null;

	/**
	 * Gestor de eliminaci�n de entidades
	 */
	private IProcessManager deleteProcess = null;

	/**
	 * Constructor
	 * @param params Par�metros de clonaci�n
	 */
	public Borrar(Map params) {
		super();
		setParameters(params);
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("admon-entidades-context.xml"));
		deleteProcess = (IProcessManager) beanFactory.getBean("deleteProcess");
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public void run() {

		try {
			
			if (deleteProcess != null) {
				deleteProcess.execute(parameters);
			} else {
				logger.error("No se ha especificado el gestor de eliminaci�n de entidades");
			}
	
		} catch (Throwable t) {
			logger.error("Error en el proceso de eliminaci�n de entidades", t);
		}
	}

	public static boolean borrar(Map params) {
		
		Thread process = new Thread(new Borrar(params));
		process.start();

	    return true;
	}

}
