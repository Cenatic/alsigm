package ieci.tecdoc.sgm.admsistema.proceso.clonar;

import ieci.tecdoc.sgm.admsistema.proceso.IProcessManager;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Clonar implements Runnable {
	
	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = Logger.getLogger(Clonar.class);

	/**
	 * Par�metros de exportaci�n
	 */
	private Map parameters = null;

	/**
	 * Gestor de clonaci�n de entidades
	 */
	private IProcessManager cloneProcess = null;

	/**
	 * Constructor
	 * @param params Par�metros de clonaci�n
	 */
	public Clonar(Map params) {
		super();
		setParameters(params);
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("admon-entidades-context.xml"));
		cloneProcess = (IProcessManager) beanFactory.getBean("cloneProcess");
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}
	
	public void run() {

		try {
			
			if (cloneProcess != null) {
				cloneProcess.execute(parameters);
			} else {
				logger.error("No se ha especificado el gestor de clonaci�n de entidades");
			}
	
		} catch (Throwable t) {
			logger.error("Error en el proceso de clonaci�n", t);
		}
	}

	public static boolean clonar(Map params) {
		
		Thread process = new Thread(new Clonar(params));
		process.start();

	    return true;
	}
}
