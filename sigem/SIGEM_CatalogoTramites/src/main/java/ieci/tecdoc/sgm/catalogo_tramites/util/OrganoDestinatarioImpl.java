package ieci.tecdoc.sgm.catalogo_tramites.util;

import java.io.Serializable;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

/**
 * Clase que implementa la clase OrganoDestinatario
 * @author x53492no
 *
 */
public class OrganoDestinatarioImpl implements OrganoDestinatario, Serializable
{
	/**
	 * Constructor de la clase OrganoDestinatario
	 *
	 */
  public OrganoDestinatarioImpl()
  {
     this.id = null;
     this.description = null;
  }
  
  /**
   * Constructor de la clase OrganoDestinatario a partir de datos
   * @param id Identificador del �rgano destinatario
   * @param description Descripci�n correspondiente al �rgano destinatario
   */
  public OrganoDestinatarioImpl(String id, String description)
  {
     this.id = id;
     this.description = description;
  }
  
  /**
   * Establece el identificador del �rgano destinatario.
   * @param String Identificador de �rgano destinatario.
   */   
  public void setId(String id)
  {
     this.id = id;
  }
  
  /**
   * Establece la descripci�n del �rgano destinatario.
   * @param description Descripci�n del �rgano destinatario.
   */   
  public void setDescription(String description)
  {
     this.description = description;
  }
  
  /**
   * Recupera el identificador del �rgano destinatario.
   * @return String identificador de �rgano destinatario.
   */   
  public String getId()
  {
     return id;
  }
  
  /**
   * Recupera la descripci�n del �rgano destinatario.
   * @return String descripci�n del �rgano destinatario.
   */   
  public String getDescription()
  {
     return description;
  }
  
  /**
   * Devuelve una cadena XMl con la informaci�n asociada al �rgano destinatario.
   * @param header Establece si el XML debe llevar cabecera.
   * @return String Cadena XML.
   */   
  public String toXML(boolean header) 
  {
     XmlTextBuilder bdr;
     String tagName = "Catalogo_Tramite";
     
     bdr = new XmlTextBuilder();
     if (header)
        bdr.setStandardHeader();

     bdr.addOpeningTag(tagName);
     
     bdr.addSimpleElement("Id", id);
     bdr.addSimpleElement("Description", description);

     bdr.addClosingTag(tagName);
     
     return bdr.getText();
  }

  /**
   * Devuelve una cadena con la informaci�n asociada a un �rgano destinatario.
   * @return String Cadena XML con la informaci�n del documento.
   */
    public String toString()
    {
     return toXML(false);
  }
  
  protected String id;
  protected String description;

}
