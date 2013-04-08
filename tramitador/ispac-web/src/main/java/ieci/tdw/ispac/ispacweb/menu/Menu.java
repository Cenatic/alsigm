package ieci.tdw.ispac.ispacweb.menu;

import ieci.tdw.ispac.ispaclib.bean.ActionBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clase Men�.
 */
public class Menu {

    // Atributos ---------------------------------------------------------------
    /** Items */
    private List/*ActionBean*/ mItems = new ArrayList();

    /** Etiqueta del men� */
    private String msLabel;

    /** Nombre del par�metro que pasamos queryString */
    private String msNameParameter;

    /** Nombre de la propiedad del identificador*/
    private String msPropertyId;

    /** Nombre de la propiedad del titulo*/
	private String msPropertyTitle;

    private ActionBean msActionBean;
    
    private String target = null;
    
    private String jscond = null;
    

    // M�todos -----------------------------------------------------------------
    /**
     * Constructor de la clase <code>Menu</code>.
     * @param label Etiqueta del men�.
     */
    public Menu(String label) {
        this.msLabel = label;
    }

    /**
     * Constructor de la clase <code>Menu</code>.
     * @param label Etiqueta del men�.
     * @param propertyTitle Nombre de la propiedad t�tulo.
     */
    public Menu(String label, String propertyTitle) {
        this.msLabel = label;
        this.msPropertyTitle = propertyTitle;
    }

    /**
     * Constructor de la clase <code>Menu</code>.
     * @param label Etiqueta del men�.
     * @param nameParameter Nombre del par�metro a pasar por queryString.
     * @param propertyId Nombre de la propiedad identificador.
     */
    public Menu(String label, String nameParameter, String propertyId) {
        this.msLabel = label;
        this.msNameParameter = nameParameter;
        this.msPropertyId = propertyId;
    }

    /**
     * Constructor de la clase <code>Menu</code>.
     * @param label Etiqueta del men�.
     * @param propertyTitle Nombre de la propiedad t�tulo.
     * @param nameParameter Nombre del par�metro a pasar por queryString.
     * @param propertyId Nombre de la propiedad identificador.
     */
    public Menu(String label, String propertyTitle, String nameParameter, String propertyId) {
        this.msLabel = label;
        this.msNameParameter = nameParameter;
        this.msPropertyId = propertyId;
        this.msPropertyTitle = propertyTitle;
    }

    /**
     * A�ade un item a la lista.
     * @param item
     */
    public void addItem(ActionBean item) {
        this.mItems.add(item);
    }

    /**
     * A�ade una lista de items a la lista.
     * @param item
     */
    public void addItems(Collection/*<ActionBean>*/ items) {
        this.mItems.addAll(items);
    }

    /**
     * @return Devuelve el valor de <code>items</code>.
     */
    public List getItems() {
        return this.mItems;
    }

    /**
     * Establece el valor de <code>items</code>.
     * @param items
     */
    public void setItems(List items) {
        this.mItems = items;
    }

	/**
	 * @return Devuelve el valor de la etiqueta del men�..
	 */
	public String getLabel()
	{
		return msLabel;
	}

	/**
	 * @param label Etiqueta del men�.
	 */
	public void setLabel(String label)
	{
		this.msLabel = label;
	}

	/**
	 * @return Devuelve el nombre del par�metro.
	 */
	public String getNameParameter()
	{
		return msNameParameter;
	}

	/**
	 * @param nameParameter Nombre del par�metro que se concatena con el enlace.
	 */
	public void setNameParameter(String nameParameter)
	{
		this.msNameParameter = nameParameter;
	}
	/**
	 * @return Devuelve el nombre de la propiedad del identificador.
	 */
	public String getPropertyId()
	{
		return msPropertyId;
	}
	/**
	 * @param propertyId Nombre de la propiedad del identificador.
	 */
	public void setPropertyId(String propertyId)
	{
		this.msPropertyId = propertyId;
	}
	/**
	 * @return Devuelve el nombre de la propiedad del t�tulo.
	 */
	public String getPropertyTitle()
	{
		return msPropertyTitle;
	}
	/**
	 * @param propertyTitle Nombre de la propiedad del t�tulo.
	 */
	public void setPropertyTitle(String propertyTitle)
	{
		this.msPropertyTitle = propertyTitle;
	}

    public ActionBean getMsActionBean()
    {
        return msActionBean;
    }

    public void setMsAction(ActionBean msActionBean)
    {
        this.msActionBean = msActionBean;
    }

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getJscond() {
		return jscond;
	}

	public void setJscond(String jscond) {
		this.jscond = jscond;
	}
}
