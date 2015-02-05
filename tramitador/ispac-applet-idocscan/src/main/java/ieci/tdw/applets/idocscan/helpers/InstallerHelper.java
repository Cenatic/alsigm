package ieci.tdw.applets.idocscan.helpers;

import ieci.tdw.applets.idocscan.exceptions.InstallerException;
import ieci.tdw.applets.idocscan.exceptions.PlatformNotSupportedException;

import java.io.File;

/**
 * Utilidad para la instalaci�n de librer�as.
 *
 */
public abstract class InstallerHelper {

	/**
	 * Constructor.
	 */
	protected InstallerHelper() {
		super();
	}

	/**
	 * Instancia un objeto de la clase.
	 * @return Instancia de la clase.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public static InstallerHelper getInstance() throws InstallerException {
		
		InstallerHelper helper = null;

		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("windows") >= 0) {
			helper = new WindowsHelper();
		} else {
			throw new PlatformNotSupportedException(osName);
		}
		
		return ((InstallerHelper) (helper));
	}

	/**
	 * Obtiene el directorio de las librer�as compartidas.
	 * @return directorio de las librer�as compartidas.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public abstract File getLibraryDir() throws InstallerException;

	/**
	 * Obtiene la ruta completa de la librer�a.
	 * @param libFileName Nombre del fichero de la librer�a.
	 * @return Ruta completa del fichero.
	 */
	public abstract File getLibFile(String libFileName);
	
	/**
	 * Obtiene el nombre del zip con las librer�as.
	 * @return nombre del zip con las librer�as.
	 */
	public abstract String getLibrariesZipName();

	/**
	 * M�todo que se ejecuta antes de la instalaci�n.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public void doBeforeLibrariesInstallation() throws InstallerException {}

	/**
	 * M�todo que se ejecuta despu�s de la instalaci�n.
	 * @throws InstallerException si ocurre alg�n error.
	 */
	public void doAfterInstallation() throws InstallerException {}
	
}