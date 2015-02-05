package common.view.menu;

import net.sf.navigator.menu.MenuRepository;

/**
 * Extensi�n del repositorio de menus proporcionado por struts menu que nos
 * permite almacenar cual es la opci�n de men� activa en cada momento
 * 
 */
public class SelectableComponentMenuRepository extends MenuRepository {

	/** �ltima opci�n de men� que ha sido seleccionada */
	SelectableMenuComponent selectedMenu = null;

	public SelectableMenuComponent getSelectedMenu() {
		return selectedMenu;
	}

	/**
	 * Establece la opci�n de men� activa
	 * 
	 * @param selectedMenu
	 *            Opci�n de men� activa
	 */
	public void setSelectedMenu(SelectableMenuComponent selectedMenu) {
		SelectableMenuComponent aMenu = null;
		if (this.selectedMenu != null) {
			aMenu = this.selectedMenu;
			while ((aMenu = (SelectableMenuComponent) aMenu.getParent()) != null)
				aMenu.setCollapsed(true);
		}
		this.selectedMenu = selectedMenu;
		if (selectedMenu != null) {
			aMenu = this.selectedMenu;
			while ((aMenu = (SelectableMenuComponent) aMenu.getParent()) != null)
				aMenu.setCollapsed(false);
		}
	}
}