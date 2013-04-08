package se.usuarios;

/**
 * Factor�a de interfaces remotos a la gesti�n de usuarios de la aplicaci�n.
 */
public class AppUserRIFactory {
	/**
	 * Obtiene un interfaz remoto de gesti�n de usuarios.
	 * 
	 * @return Interfaz remoto de gesti�n de usuarios.
	 */
	public static AppUserRI createAppUserRI() {
		return new AppUserRIImpl();
	}
}
