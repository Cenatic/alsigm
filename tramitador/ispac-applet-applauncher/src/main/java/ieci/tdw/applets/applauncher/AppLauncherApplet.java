package ieci.tdw.applets.applauncher;

import java.applet.Applet;

import javax.swing.JOptionPane;

/**
 * Applet para lanzar una aplicaci�n en el cliente.
 *
 */
public class AppLauncherApplet extends Applet {
	
	/** Indica si se est� en modo debug. */
	private boolean debug = false;

	
    /**
     * Inicia la ejecuci�n del applet.
     */
	public void init() {
		
		String docUrl = null;
		
		
		try {
			
			// Comprobar si se est� en modo debug
			debug = "TRUE".equalsIgnoreCase(getParameter("debug"));
			
			// Configuraci�n del applet
			AppLauncherAppletProperties props = new AppLauncherAppletProperties();
			if (debug) {
				log("---- AppLauncherAppletProperties begin");
				props.list(System.out);
				log("---- AppLauncherAppletProperties end");
			}

			// Recoger parametro de configuraci�n
			String config = getParameter("config");
			if ("true".equalsIgnoreCase(config)) {
				log("Modo Configuraci�n");
				AppConfigurationDialog.showDialog();
				return;
			}
			
			// Recoger URL del documento
			docUrl = getParameter("docUrl");
			if ( (docUrl == null) || (docUrl.trim().length() == 0) ) {
				JOptionPane.showMessageDialog(this, 
						AppLauncherMessages.getString(
								"appLauncherApplet.error.noDocument"), 
						AppLauncherMessages.getString(
								"appLauncherApplet.error.warning.title"), 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			log("docUrl: " + docUrl);
			
			// Obtener la extensi�n del documento
			String docExt = getDocExt(docUrl);
			log("docExt: " + docExt);

			// Obtener la aplicaci�n para abrir el documento
			String appPath = props.getProperty("app." + docExt);
			log("appPath: " + appPath);
			if ( (appPath == null) || (appPath.trim().length() == 0) ) {
				
				// Pedir la aplicaci�n para abrir el documento
				AppChooserDialog appPathDialog = AppChooserDialog.showDialog(docExt);
				if (appPathDialog.getResult() == AppChooserDialog.CANCEL) {
					return;
				}

				// Recuperar el path de la aplicaci�n
				appPath = appPathDialog.getAppPath(); 

				// Comprobar el path de la aplicaci�n
				if (AppLauncherAppletProperties.checkAppPath(appPath)) {
					
					// A�adir aplicaci�n al fichero de configuraci�n 
					props.put("app." + docExt, appPath);
					props.store();
					
				} else {
					JOptionPane.showMessageDialog(this,
							AppLauncherMessages.getString(
									"appLauncherApplet.error.invalidApp"),
							AppLauncherMessages.getString(
									"appLauncherApplet.error.error.title"),
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			// Componer la l�nea del comando
			String commandLine = getCommandLine(appPath, docUrl);
			log("commandLine: " + commandLine);
			
			// Ejecutar el comando
			Runtime.getRuntime().exec(commandLine);

		} catch (Throwable t) {
			JOptionPane.showMessageDialog(this, 
					AppLauncherMessages.getString(
							"appLauncherApplet.error.exception", 
							new String [] { t.toString() } ),
					AppLauncherMessages.getString(
							"appLauncherApplet.error.error.title"), 
					JOptionPane.ERROR_MESSAGE);
			logError("Error al lanzar la aplicaci�n: " + docUrl, t);
		}
	}
	
	protected static String getDocExt(String docUrl) {
		String ext = "";
		
		if ( (docUrl != null) && (docUrl.trim().length() > 0) ) {
			int dotIndex = docUrl.lastIndexOf(".");
			if (dotIndex > 0) {
				ext = docUrl.substring(dotIndex + 1);
			}
		}
		
		return ext;
	}
	
	protected static String getCommandLine(String appPath, String docUrl) {
		StringBuffer commandLine = new StringBuffer();
		
		if ( (appPath != null) && (appPath.trim().length() > 0)) {
			commandLine.append(appPath);

			if ( (docUrl != null) && (docUrl.trim().length() > 0)) {
				commandLine.append(" ").append(docUrl);
			}
		}
		
		return commandLine.toString();
	}
	
	protected void log(String msg) {
		if (debug) {
			System.out.println(msg);
		}
	}

	protected static void logError(String msg, Throwable t) {
		System.err.println(msg);
		t.printStackTrace();
	}

}
