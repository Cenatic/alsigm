package common.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;

import org.apache.log4j.Logger;

import se.usuarios.AppUser;
import util.StringOwnTokenizer;

import common.ConfigConstants;
import common.Constants;
import common.util.StringUtils;
import common.view.menu.SelectableComponentMenuRepository;
import common.view.menu.SelectableMenuComponent;

/**
 * Utilidad para configurar el men� de la aplicaci�n en funci�n de los permisos
 * del usuario.
 */
public class MenuConfigurator {

	/** Logger de la clase. */
	protected static Logger logger = Logger.getLogger(MenuConfigurator.class);

	/** Configuraci�n del men� para el usuario. */
	private MenuRepository userMenuRepository = new MenuRepository();

	/** Lista de los men�s principales. */
	private Map userTopMenus = new HashMap();

	// /** Lista de men�s principales. */
	// private static final String [] TOP_MENU_NAMES = new String [] {
	// "MenuFondos",
	// "MenuDescripcion",
	// /**"MenuDigitalizaci�n",**/
	// "MenuDeposito",
	// "MenuSolicitudes",
	// "MenuTransferencias",
	// "MenuAdministracion"};

	/**
	 * Constructor.
	 */
	protected MenuConfigurator() {
		userMenuRepository = new SelectableComponentMenuRepository();
		userTopMenus = new HashMap();
	}

	/**
	 * Obtiene la configuraci�n del men� para el usuario.
	 * 
	 * @return Configuraci�n del men� para el usuario.
	 */
	protected MenuRepository getUserMenuRepository() {
		return userMenuRepository;
	}

	/**
	 * Obtiene la lista de los men�s principales.
	 * 
	 * @return Lista de los men�s principales.
	 */
	protected Map getUserTopMenus() {
		return userTopMenus;
	}

	/**
	 * Configura el men� que va a ver el usuario.
	 * 
	 * @param originalMenuRepository
	 *            Men� original.
	 * @param user
	 *            Informaci�n del usuario.
	 */
	protected void configureMenu(MenuRepository originalMenuRepository,
			AppUser user) {
		MenuComponent mc, mcFinal;

		// Copiar los displayers del men� original
		userMenuRepository
				.setDisplayers(originalMenuRepository.getDisplayers());

		List topMenus = originalMenuRepository.getTopMenus();
		if (topMenus != null) {
			int nTopMenus = topMenus.size();
			// Comprobar la visibilidad de cada men� principal
			for (int i = 0; i < nTopMenus; i++) {
				mc = (MenuComponent) topMenus.get(i);
				boolean isMenuVisible = (mc != null) && isVisible(mc, user);
				if (isMenuVisible
						&& (!mc.getName().equals(Constants.MENU_DOC_VITALES))) {

					mcFinal = createMenuComponent(mc, user);
					if (mcFinal != null && mcFinal.getMenuComponents() != null
							&& mcFinal.getMenuComponents().length > 0) {
						userMenuRepository.addMenu(mcFinal);
						userTopMenus.put(mc.getName(), mc);
					}
				} else {
					// Comprobar si se ha de mostrar o no el men� de documentos
					// vitales
					ConfigConstants config = ConfigConstants.getInstance();

					if (isMenuVisible && config.getMostrarDocVitales()) {
						mcFinal = createMenuComponent(mc, user);
						if (mcFinal != null) {
							userMenuRepository.addMenu(mcFinal);
							userTopMenus.put(mc.getName(), mc);
						}
					}
				}
			}
		}
	}

	/**
	 * Crea un nuevo componente de men� con la informaci�n de uno existente.
	 * 
	 * @param mc
	 *            Componente de men�.
	 * @param user
	 *            Informaci�n del usuario.
	 * @return Componente de men�.
	 */
	protected MenuComponent createMenuComponent(MenuComponent mc, AppUser user) {
		MenuComponent menu = copyMenuComponent(mc);

		// Obtener los submen�s del men� actual
		MenuComponent[] childMenus = mc.getMenuComponents();
		if (childMenus != null) {
			MenuComponent childMenu = null;
			for (int i = 0; i < childMenus.length; i++) {
				childMenu = childMenus[i];

				// A�adir el submen� si es visible
				boolean isMenuVisible = (childMenu != null)
						&& (isVisible(childMenu, user));
				if (isMenuVisible
						&& (!childMenu.getName().equals(
								Constants.MENU_ADM_DOC_VITALES))
						&& (!childMenu.getName().equals(
								Constants.MENU_BUSQUEDA_AVANZADA))
						&& (!childMenu.getName().equals(
								Constants.MENU_FONDOS_INGRESO_DIRECTO))
						&& (!childMenu.getName().equals(
								Constants.MENU_DESCRIPCION_ARCHIVISTICA))
						&& (!childMenu.getName().equals(
								Constants.MENU_CAMBIO_GESTOR_INGRESO_DIRECTO))
						&& (!childMenu.getName().equals(
								Constants.MENU_ADMINISTRACION_ORGANIZACION))
						&& (!childMenu.getName().equals(Constants.MENU_ARCHIVO))
						&& (!childMenu.getName().equals(
								Constants.MENU_SALAS_CONSULTA))
						&& (!childMenu.getName().equals(
								Constants.MENU_SERVICIO_SALAS))) {
					childMenu = createMenuComponent(childMenu, user);
					menu.addMenuComponent(childMenu);
					userMenuRepository.addMenu(childMenu);
				} else {
					// Comprobar si se ha de mostrar o no el men� de
					// administraci�n de documentos vitales
					ConfigConstants config = ConfigConstants.getInstance();

					boolean mostrarMenu = false;
					if (isMenuVisible) {
						if (childMenu.getName().equals(
								Constants.MENU_ADM_DOC_VITALES)) {
							if (config.getMostrarDocVitales()) {
								mostrarMenu = true;
							}
						} else if (childMenu.getName().equals(
								Constants.MENU_FONDOS_INGRESO_DIRECTO)) {
							if (config
									.getPermitirAltaDirectaUnidadesDocumentales()) {
								mostrarMenu = true;
							}
						} else if (childMenu.getName().equals(
								Constants.MENU_DESCRIPCION_ARCHIVISTICA)
								|| childMenu.getName().equals(
										Constants.MENU_BUSQUEDA_AVANZADA)) {

							if (config.getMostrarBusquedaAvanzada()) {
								mostrarMenu = true;
							} else {
								if (user.isUsuarioArchivo()) {
									mostrarMenu = true;
								}
							}
						} else if (childMenu.getName().equals(
								Constants.MENU_CAMBIO_GESTOR_INGRESO_DIRECTO)) {
							if (config
									.getPermitirAltaDirectaUnidadesDocumentales())
								mostrarMenu = true;
						} else if (childMenu.getName().equals(
								Constants.MENU_ARCHIVO)) {
							if (config.getPermitirTransferenciasEntreArchivos())
								mostrarMenu = true;
						} else if (childMenu.getName().equals(
								Constants.MENU_ADMINISTRACION_ORGANIZACION)) {
							if (config.getMostrarAdministracionOrganizacion())
								mostrarMenu = true;
						} else if (Constants.MENU_SALAS_CONSULTA
								.equals(childMenu.getName())
								|| Constants.MENU_SERVICIO_SALAS
										.equals(childMenu.getName())) {
							if (config.getMostrarSalas())
								mostrarMenu = true;
						}

						if (mostrarMenu) {
							childMenu = createMenuComponent(childMenu, user);
							menu.addMenuComponent(childMenu);
							userMenuRepository.addMenu(childMenu);
						}
					}

				}
			}
		}

		return menu;
	}

	/**
	 * Realiza una copia del componente del men�.
	 * 
	 * @param mc
	 *            Componente del men�.
	 * @return Copia del componente del men�.
	 */
	protected MenuComponent copyMenuComponent(MenuComponent mc) {
		MenuComponent menuComponent = new SelectableMenuComponent();

		menuComponent.setAction(mc.getAction());
		menuComponent.setAltImage(mc.getAltImage());
		menuComponent.setDescription(mc.getDescription());
		menuComponent.setForward(mc.getForward());
		menuComponent.setImage(mc.getImage());
		menuComponent.setLocation(mc.getLocation());
		menuComponent.setName(mc.getName());
		menuComponent.setPage(mc.getPage());
		// menuComponent.setParent(mc.getParent());
		menuComponent.setTitle(mc.getTitle());
		menuComponent.setToolTip(mc.getToolTip());
		menuComponent.setUrl(mc.getUrl());

		return menuComponent;
	}

	/**
	 * Comprueba si el componente del men� es visible para el usuario.
	 * 
	 * @param mc
	 *            Componente del men�.
	 * @param user
	 *            Informaci�n del usuario.
	 * @return si el componente del men� es visible.
	 */
	protected boolean isVisible(MenuComponent mc, AppUser user) {
		boolean isVisible = false;

		if (StringUtils.isNotBlank(mc.getRoles())) {
			StringOwnTokenizer tok = new StringOwnTokenizer(mc.getRoles(), ",");
			while (!isVisible && tok.hasMoreTokens())
				isVisible = user.hasPermission(tok.nextToken());
		}

		return isVisible;
	}

	/**
	 * Configura el men� del usuario.
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param context
	 *            {@link ServletContext}
	 */
	public static void configureUserMenu(HttpServletRequest request,
			ServletContext context) {
		// Informaci�n del usuario
		final AppUser user = (AppUser) request.getSession().getAttribute(
				Constants.USUARIOKEY);

		// Configuraci�n original del men�
		final MenuRepository originalMenuRepository = (MenuRepository) context
				.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);

		// Configurar el men� para el usuario
		final MenuConfigurator mc = new MenuConfigurator();
		mc.configureMenu(originalMenuRepository, user);

		request.getSession().setAttribute(MenuRepository.MENU_REPOSITORY_KEY,
				mc.getUserMenuRepository());
		request.getSession().setAttribute(Constants.USER_AVAILABLE_MENUS,
				mc.getUserTopMenus());
	}
}
