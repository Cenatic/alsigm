package ieci.tecdoc.sgm.catalogo_tramites.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;
import ieci.tecdoc.sgm.catalogo_tramites.util.database.TipoConectorDatos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de tipos de conectores
 *
 */
public class TiposConectores implements Serializable
{
    private ArrayList hooktypes;

    /**
     * Constructor de la clase TiposConectores
     *
     */
    public TiposConectores()
    {
      hooktypes = new ArrayList();
    }

    /**
     * Devuelve el n�mero de tipos de conectores de la colecci�n
     * @return
     */
    public int count() {
       return hooktypes.size();
    }

    /**
     * Devuelve el tipo de conector que se encuentra en la posici�n indicada.
     * @param index Posici�n del tipo de conector dentro de la colecci�n.
     * @return Hook Conector.
     */
    public TipoConector get(int index) {
       return (TipoConector) hooktypes.get(index);
    }

    /**
     * A�ade un nuevo tipo de conector a la colecci�n
     * @param hook Nuevo tipo de conector a a�adir.
     */
    public void add(TipoConectorDatos hookType) {
      hooktypes.add(hookType);
    }
    
    /**
     * Devuelve una cadena XML con la informaci�n de los tipos de conectores 
     *  contenidos en la colecci�n.
     * @param header Establece si el XML debe llevar cabecera.
     * @return String XML con la informaci�n.
     */   
    public String toXML(boolean header) {
       XmlTextBuilder bdr;
       String tagName = "Catalogo_TiposConector";
       TipoConector hookType;

       bdr = new XmlTextBuilder();
       if (header)
          bdr.setStandardHeader();

       bdr.addOpeningTag(tagName);

       for (int i = 0; i < count(); i++) {
         hookType = get(i);
         bdr.addFragment(hookType.toXML(false));
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

