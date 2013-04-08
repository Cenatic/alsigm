package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.ConectorDatos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de conectores
 *
 */
public class Conectores implements Serializable
{
    private ArrayList hooks;

    /**
     * Constructor de la clase conectores
     *
     */
    public Conectores()
    {
      hooks = new ArrayList();
    }

    /**
     * Devuelve el n�mero de conectores de la colecci�n
     * @return
     */
    public int count() {
       return hooks.size();
    }

    /**
     * Devuelve el conector que se encuentra en la posici�n indicada.
     * @param index Posici�n del conector dentro de la colecci�n.
     * @return Hook Conector.
     */
    public Conector get(int index) {
       return (Conector) hooks.get(index);
    }

    /**
     * A�ade un nuevo conector a la colecci�n
     * @param hook Nuevo conector a a�adir.
     */
    public void add(ConectorDatos hook) {
      hooks.add(hook);
    }
    
    /**
     * Devuelve una cadena XML con la informaci�n de los conectores contenidos en la colecci�n.
     * @param header Establece si el XML debe llevar cabecera.
     * @return String XML con la informaci�n.
     */   
    public String toXML(boolean header) {
       XmlTextBuilder bdr;
       String tagName = "Catalogo_Conectores";
       Conector hook;

       bdr = new XmlTextBuilder();
       if (header)
          bdr.setStandardHeader();

       bdr.addOpeningTag(tagName);

       for (int i = 0; i < count(); i++) {
         hook = get(i);
          bdr.addFragment(hook.toXML(false));
       }

       bdr.addClosingTag(tagName);

       return bdr.getText();
    }

    /**
     * Devuelve la informaci�n de los conectores contenidos en la colecci�n.
     * @return String Cadena XML con la informaci�n de los documentos.
     */
    public String toString() {
       return toXML(false);
    }
}

