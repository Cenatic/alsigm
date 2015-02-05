package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.OrganoDestinatarioDatos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Conetendor de �rganos destinatarios
 *
 */
public class OrganosDestinatarios implements Serializable
{
    private ArrayList addressees;

    /**
     * Constructor de la clase OrganosDestinatarios
     *
     */
    public OrganosDestinatarios()
    {
      addressees = new ArrayList();
    }

    /**
     * Devuelve el n�mero de �rganos destinatarios de la colecci�n
     * @return
     */
    public int count() {
       return addressees.size();
    }

    /**
     * Devuelve el �rgano destinatario que se encuentra en la posici�n indicada.
     * @param index Posici�n del �rgano destinatario dentro de la colecci�n.
     * @return DocumentExt Documento.
     */
    public OrganoDestinatario get(int index) {
       return (OrganoDestinatario) addressees.get(index);
    }

    /**
     * A�ade un nuevo �rgano destinatario a la colecci�n
     * @param document Nuevo �rgano destinatario a a�adir.
     */
    public void add(OrganoDestinatarioDatos addressee) {
      addressees.add(addressee);
    }
    
    /**
     * Devuelve una cadena XML con la informaci�n de los �rganos destinatarios contenidos en la colecci�n.
     * @param header Establece si el XML debe llevar cabecera.
     * @return String XML con la informaci�n.
     */   
    public String toXML(boolean header) {
       XmlTextBuilder bdr;
       String tagName = "Catalogo_Organos_Destinatarios";
       OrganoDestinatario addressee;

       bdr = new XmlTextBuilder();
       if (header)
          bdr.setStandardHeader();

       bdr.addOpeningTag(tagName);

       for (int i = 0; i < count(); i++) {
          addressee = get(i);
          bdr.addFragment(addressee.toXML(false));
       }

       bdr.addClosingTag(tagName);

       return bdr.getText();
    }

    /**
     * Devuelve la informaci�n de los �rganos destinatarios contenidos en la colecci�n.
     * @return String Cadena XML con la informaci�n de los documentos.
     */
    public String toString() {
       return toXML(false);
    }
}
