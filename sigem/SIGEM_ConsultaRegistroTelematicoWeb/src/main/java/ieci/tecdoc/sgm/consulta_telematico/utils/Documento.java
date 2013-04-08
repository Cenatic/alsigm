package ieci.tecdoc.sgm.consulta_telematico.utils;

import ieci.tecdoc.sgm.core.services.telematico.RegistroDocumento;

public class Documento extends RegistroDocumento {
	
	public Documento() {
		extension = null;
		name = null;
	}
	
    /**
     * Devuelve el nombre del documento.
     * @return String Nombre del documento.
     */
	public String getName() {
		return name;
	}

    /**
     * Establece el nombre del documento.
     * @param name Nombre del documento.
     */   
	public void setName(String name) {
		this.name = name;
	}
	
    /**
     * Devuelve la extensi�n del documento.
     * @return String Extensi�n del documento.
     */
	public String getExtension() {
		return extension;
	}

    /**
     * Establece la extensi�n del documento.
     * @param extension Extensi�n del documento.
     */  
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	protected String name;
	protected String extension;

}
