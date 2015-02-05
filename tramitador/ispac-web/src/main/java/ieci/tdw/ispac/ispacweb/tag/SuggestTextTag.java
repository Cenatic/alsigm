package ieci.tdw.ispac.ispacweb.tag;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispacweb.tag.context.StaticContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.Globals;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.TextTag;

/**
 * Clase que renderiza la etiqueta <ispac:suggestText>.
 * Recibe como par�metros obligatorios el nombre de una acci�n de Struts, un identificador �nico
 * y el nombre de par�metro que ser� enviado con el texto para el filtrado. 
 * 
 * La p�gina JSP que incorpore este tag necesita incluir las librer�as:
 * - Prototype.js.
 * - scriptaculous.js
 * - controls.js -> versi�n extendida que incorpora la clase: Ajax.IspacAutocompleter
 * 
 * La acci�n de struts debe devolver c�digo html con la forma:
 * <code>
 * <ul>
 * 	<li><Elemento no seleccionable de la lista</li> 
 * 	<li><div class="selectme"><Elemento seleccionable de la lista></div></li>
 * </ul>
 * </code>
 * 
 * La acci�n de struts recibir� un par�metro en la request con el nombre especificado
 * en el par�metro paramName con el valor del campo de texto.
 * 
 * Si se necesita pasar el valor de otro input del formulario se puede utilizar el 
 * par�metro extraParam.
 * 
 * Si se establece la propiedad showButton, se a�adir� a la derecha del campo de texto
 * un bot�n con el que simular el comportamiento de un combo box con filtro. La imagen
 * a utilizar se debe especificar en el par�metro imageButton.
 * 
 * El par�metro numRows ser� pasado tambi�n en la request con el nombre numRows y servir�
 * para acotar los resultados de la b�squeda.
 * 
 * El par�metro suggestStyleClass, sirve para especificar los estilos a utilizar mediante css.
 * 
 * @author cnavas
 * @see org.apache.struts.taglib.html.TextTag
 * 
 */
public class SuggestTextTag extends TextTag {

	/**
	 * Acci�n de struts que se encargar� de generar
	 * la lista de autocompletado.
	 */
	protected String suggestAction = null;
	
	/**
	 * Nombre del par�metro que llegar� a la acci�n
	 * de struts con el filtro a aplicar.
	 */
	protected String paramName = null;
	
	/**
	 * N�mero de filas m�ximo a mostrar en la lista.
	 */
	protected String numRows = null;
	
	/** 
	 * Mostrar o no el bot�n para desplegar la lista.
	 */
	protected boolean showButton = false;
	
	/**
	 * Imagen para el boton de despliegue.
	 */
	protected String imageButton = null;
	
	/**
	 * Clase css para el div que contiene la lista.
	 */
	protected String suggestListStyleClass = null;
	
	/**
	 * N�mero de caracteres m�nimo para realizar la petici�n
	 * de actualizaci�n de la lista.
	 */
	protected String minChars = null;
	
	/**
	 * Nombre de otro campo input asociado. Su valor se 
	 * pasar� tambi�n como par�metro al action de struts.
	 * �til para realizar b�squedas cruzadas.
	 */
	protected String extraParam = null;
	
	public SuggestTextTag() {
		super();
	}
	
    /**
     * Process the end of this tag.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {
    	
    	TagUtils.getInstance().write(this.pageContext, this.renderAjaxElement());
    	
        return (EVAL_PAGE);
    }
	
    /**
     * Renders a fully formed &lt;input&gt; element.
     * @throws JspException
     * @since Struts 1.2
     */
    protected String renderAjaxElement() throws JspException {
    	
        StringBuffer results = new StringBuffer("");
        HttpServletResponse response =
            (HttpServletResponse) this.pageContext.getResponse();

        if(showButton){
        	if(this.getImageButton() == null){
        		throw new JspException("Si la propiedad showButton es true, debe indicarse el nombre del archivo de imagen.");
        	}
        	minChars = "1";
        	results.append("\n <script type=\"text/javascript\" language=\"javascript\" charset=\"utf-8\">");
        	results.append("\n function actualizeAjaxIspacId" + this.getStyleId() + "(){");
        	results.append("\n var field = $('" + this.getStyleId() + "');");
        	results.append("\n field.focus();");
        	results.append("\n objectAutocomp" + this.getStyleId() + ".changed = false;");
        	results.append("\n objectAutocomp" + this.getStyleId() + ".hasFocus = true;");
        	results.append("\n objectAutocomp" + this.getStyleId() + ".getUpdatedChoices();");
        	results.append("\n }");
        	results.append("\n </script>");
        	results.append("<a href=\"javascript:actualizeAjaxIspacId" + this.getStyleId() + "();\">");
        	results.append("<img src=\"" + getImageIspacURL() + "\" border=\"0\"/>");
        	results.append("</a>");
        }
        
        results.append("<div id=\"" + this.getStyleId() + "Div2Update\" ");
        if(this.getSuggestListStyleClass() != null){
        	results.append(" class=\"" + this.getSuggestListStyleClass() + "\"");
        }
        results.append("></div>");
        results.append("<script type=\"text/javascript\" language=\"javascript\" charset=\"utf-8\">");
        results.append("\n// <![CDATA[");
        results.append("\nvar objectAutocomp" + this.getStyleId() + " = ");
        results.append("new Ajax.IspacAutocompleter(");
        results.append("'" + this.getStyleId() + "'" + ", ");
        results.append("'" + this.getStyleId() + "Div2Update" + "', ");
        results.append("'" + response.encodeURL(TagUtils.getInstance().getActionMappingURL(this.getSuggestAction(), this.pageContext)) + "', ");
        results.append("{select: 'selectme', ");
        results.append("paramName: '" + this.getParamName() + "', ");
        if(minChars == null) {
        	minChars = "1";
        }
        results.append("minChars: " + this.getMinChars());
        
        if(this.getNumRows() != null){
        	results.append(", numRows: " + this.getNumRows());
        }
        if(this.getExtraParam() != null){
        	results.append(", extraParam: '" + this.getExtraParam() + "'");
        }
        results.append("});");
        results.append("\n// ]]>");
        results.append("</script>");

        return results.toString();
    }

	/**
	 * @return Returns the suggestAction.
	 */
	public String getSuggestAction() {
		return suggestAction;
	}
	/**
	 * @param suggestAction The suggestAction to set.
	 */
	public void setSuggestAction(String suggestAction) {
		this.suggestAction = suggestAction;
	}

	/**
	 * @return Returns the paramName.
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * @param paramName The paramName to set.
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @return Returns the numRows.
	 */
	public String getNumRows() {
		return numRows;
	}
	/**
	 * @param numRows The numRows to set.
	 */
	public void setNumRows(String numRows) {
		this.numRows = numRows;
	}

	/**
	 * @return Returns the showButton.
	 */
	public boolean isShowButton() {
		return showButton;
	}
	/**
	 * @param showButton The showButton to set.
	 */
	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}

	/**
	 * @return Returns the imageButton.
	 */
	public String getImageButton() {
		return imageButton;
	}
	/**
	 * @param imageButton The imageButton to set.
	 */
	public void setImageButton(String imageButton) {
		this.imageButton = imageButton;
	}

	/**
	 * @return Returns the suggestListStyleClass.
	 */
	public String getSuggestListStyleClass() {
		return suggestListStyleClass;
	}
	/**
	 * @param suggestListStyleClass The suggestListStyleClass to set.
	 */
	public void setSuggestListStyleClass(String suggestListStyleClass) {
		this.suggestListStyleClass = suggestListStyleClass;
	}

	/**
	 * @return Returns the minChars.
	 */
	public String getMinChars() {
		return minChars;
	}
	/**
	 * @param minChars The minChars to set.
	 */
	public void setMinChars(String minChars) {
		this.minChars = minChars;
	}

	/**
	 * @return Returns the extraParam.
	 */
	public String getExtraParam() {
		return extraParam;
	}
	/**
	 * @param extraParam The extraParam to set.
	 */
	public void setExtraParam(String extraParam) {
		this.extraParam = extraParam;
	}
	
	private String getImageIspacURL() throws JspException {
		
	    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
	    String context = request.getContextPath();
		
	    String baseurl;
	    try {
	    	baseurl = StaticContext.getInstance().getBaseUrl(context);
	    }
	    catch (ISPACException ie) {
	        pageContext.setAttribute(Globals.EXCEPTION_KEY, ie, PageContext.REQUEST_SCOPE);
	        throw new JspException(ie.getMessage());
	    }
	 
	    // Href que incluya el ispacbase junto con el skin
	    return StaticContext.rewriteHref(pageContext, baseurl, this.getImageButton());
		
		/*
		String ispacbase =(String)pageContext.getServletContext().getAttribute("ispacbase");
        String skin =(String)pageContext.getServletContext().getAttribute("skin");

        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

        String baseurl = request.getContextPath();
        if (ispacbase == null || ispacbase.equalsIgnoreCase(""))
            return baseurl += "/" + skin + "/" + this.getImageButton();

        return baseurl += "/" + ispacbase + "/" + skin + "/" + this.getImageButton();
        */
	}
	
}