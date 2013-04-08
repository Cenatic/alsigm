package ieci.tdw.applets.idocscan.helpers;

import ieci.tdw.applets.idocscan.Messages;
import ieci.tdw.applets.idocscan.exceptions.InstallerException;

import java.io.File;

import javax.swing.JOptionPane;

/**
 * Utilidad para la instalaci�n de librer�as en Windows.
 *
 */
public class WindowsHelper extends InstallerHelper {

	/** 
	 * Constructor.
	 * 
	 */ 
	protected WindowsHelper() {
		super();
	}

	/**
	 * Obtiene el directorio de las librer�as compartidas.
	 * @return directorio de las librer�as compartidas.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public File getLibraryDir() {
		return new File(EnvHelper.getEnvVarIgnoreCase("SystemRoot"));
	}

	/**
	 * Obtiene el nombre del zip con las librer�as.
	 * @return nombre del zip con las librer�as.
	 */
    public String getLibrariesZipName() {
        return "win32libraries.zip";
    }

	/**
	 * Obtiene la ruta completa de la librer�a.
	 * @param libFileName Nombre del fichero de la librer�a.
	 * @return Ruta completa del fichero.
	 */
	public File getLibFile(String libFileName) {
		File file = null;
		
		File libDir = getLibraryDir();
		if (libDir.exists()) {
			file = new File(libDir, libFileName);
			if (!file.exists()) {
				file = null;
			}
		}
	
		return file;
	}

	/**
	 * M�todo que se ejecuta despu�s de la instalaci�n.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public void doAfterInstallation() {
		JOptionPane.showMessageDialog(null,
				Messages.getString("applet.windows.afterInstallation.message"));
	}

}