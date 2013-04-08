package ieci.tdw.ispac.ispacweb.tag;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.context.ClientContext;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * Etiqueta JSP que se encarga de mostrar un campo de texto
 * para seleccionar una fecha del calendario.
 */
public class HtmlTextCalendarTag extends HtmlTextTag {

    /**
     * Idioma en el que se mostrar� el formulario.
     */
    private String language = "es";

    /**
     * Flag que indica si es posible seleccionar una fecha anterior a la actual.
     */
    private boolean enablePast = false;

    /**
     * Coordenada X en la que se mostrar� el calendario.
     */
    private int fixedX = -1;

    /**
     * Coordenada Y en la que se mostrar� el calendario.
     */
    private int fixedY = -1;

    /**
     * Imagen que se muestra como icono del calendario.
     */
    private String image = "popcalendar.gif";

    /**
     * Patr�n en el se devolver� la fecha.
     */
    private String format;

    /**
     * Nombre del fichero javascript que recoge toda la l�gica del calendario.
     */
    private String scriptFile = "calendar.js";
    
    /**
     * Id. del formulario en el que se muestra el calendario.
     */
    private String formId = "defaultForm";

    /**
     * Guarda el nombre del fichero javascript que contiene la l�gica de negocio
     * del calendario.
     * 
     * @param scriptFile
     *            el nombre del fichero javascript que contiene la l�gica de
     *            negocio del calendario
     */
    public void setScriptFile(String scriptFile) {
        this.scriptFile = scriptFile;
    }

    /**
     * @return Devuelve el nombre del fichero javascript que contiene la l�gica de negocio
     * del calendario.
     */
    public String getScriptFile() {
        return scriptFile;
    }

    /**
     * Guarda el patr�n empleado para la visualizaci�n de la fecha seleccionada
     * en el calendario.
     * 
     * @param format
     *            el patr�n empleado para la visualizaci�n de la fecha
     *            seleccionada en el calendario
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Establece si se permite seleccionar una fecha anterior a la fecha actual.
     * 
     * @param enablePast
     *            flag que indica si es posible seleccionar una fecha anterior a
     *            la fecha actual
     */
    public void setEnablePast(boolean enablePast) {
        this.enablePast = enablePast;
    }

    /**
     * Guarda la coordenada X en la que se mostrar� el calendario.
     * 
     * @param fixedX
     *            la coordenada X en la que se mostrar� el calendario
     */
    public void setFixedX(int fixedX) {
        this.fixedX = fixedX;
    }

    /**
     * Guarda la coordenada Y en la que se mostrar� el calendario.
     * 
     * @param fixedY
     *            la coordenada Y en la que se mostrar� el calendario
     */
    public void setFixedY(int fixedY) {
        this.fixedY = fixedY;
    }

    /**
     * Guarda el nombre de la imagen que se mostrar� como icono del calendario.
     * 
     * @param image
     *            el nombre de la imagen que se mostrar� como icono del
     *            calendario
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    /**
     * @return Devuelve el nombre de la imagen que se mostrar� como icono
     * del calendario.
     */
    public String getImage() {
        return image;
    }

    /**
     * Guarda el idioma utilizado para la visualizaci�n del calendario.
     * 
     * @param language
     *            el idioma utilizado para la visualizaci�n del calendario
     */
    public void setLanguage(String language) {
        this.language = language;
    }

	/**
	 * @return Returns the formId.
	 */
	public String getFormId() {
		return formId;
	}

	/**
	 * @param formId The formId to set.
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/**
	 * @return Returns the enablePast.
	 */
	public boolean isEnablePast() {
		return enablePast;
	}

	/**
	 * @return Returns the fixedX.
	 */
	public int getFixedX() {
		return fixedX;
	}

	/**
	 * @return Returns the fixedY.
	 */
	public int getFixedY() {
		return fixedY;
	}

	/**
	 * @return Returns the format.
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @return Returns the language.
	 */
	public String getLanguage() {
		return language;
	}

	/**
     * Se encarga de escribir una etiqueta <code>img</code> con un enlace a un
     * m�todo javascript que se encarga de mostrar el calendario teniendo en
     * cuenta los par�metros de configuraci�n establecidos.
     * 
     * @return un c�digo que indica si el m�todo concluy� con �xito [EVAL_PAGE]
     * @throws JspException
     *             en caso de que se produzca alg�n error
     */
    public int doEndTag() throws JspException {

    	if (!getReadonly()) {
    	
    		try {
    			
	            JspWriter out = pageContext.getOut();
	            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	
	            // Ejecutar el calendario.
	            String  client = "document.forms[\"" + getFormId() + "\"].elements[\"" + getProperty() + "\"]";
	            
	            out.write("<span style=\"margin: 0px\" id=\"imgCalendar_" + getProperty().substring(getProperty().indexOf("(") + 1, getProperty().length() - 1)  + "\">");
	            
	            out.write("<img id='calgif' valign='middle' src='" + getImage() + "' ");
	            out.write("onclick='showCalendar(this, " + client + ", ");
	            int value = (isEnablePast()) ? 1 : 0;
	            out.write("\"" + getFormat() + "\",\"" + getLanguage(request) + "\"," + value + ","
	                     + getFixedX() + "," + getFixedY() + ")' />");
	            
	            out.write("</span>\n");
	        }
	        catch (IOException e) {
	            throw new JspException(e);
	        }
    	}

        return EVAL_PAGE;
    }
    
	public String getLanguage(HttpServletRequest request) {
		
		ClientContext cct = (ClientContext) request.getAttribute("ClientContext");
		if (cct != null) {
			
			try {
				return cct.getAppLanguage();
			}
			catch (ISPACException ie) {}
		}
		
		return getLanguage();
	}
    
}