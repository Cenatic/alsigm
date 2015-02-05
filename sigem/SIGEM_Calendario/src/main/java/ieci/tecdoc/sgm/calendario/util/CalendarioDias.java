package ieci.tecdoc.sgm.calendario.util;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contenedor de dias del calendario
 *
 */
public class CalendarioDias implements Serializable
{
    private ArrayList dias;

    /**
     * Constructor de la clase calendarioDias
     *
     */
    public CalendarioDias()
    {
      dias = new ArrayList();
    }

    /**
     * Devuelve el n�mero de dias de la colecci�n
     * @return
     */
    public int count() {
       return dias.size();
    }

    /**
     * Devuelve el dia que se encuentra en la posici�n indicada.
     * @param index Posici�n del dia dentro de la colecci�n.
     * @return CalendarioDia Dia del calendario.
     */
    public CalendarioDia get(int index) {
       return (CalendarioDia) dias.get(index);
    }

    /**
     * A�ade un nuevo dia a la colecci�n
     * @param dia Nuevo dia a a�adir.
     */
    public void add(CalendarioDia dia) {
    	dias.add(dia);
    }
    
    /**
     * Devuelve una cadena XML con la informaci�n de los dias contenidos en la colecci�n.
     * @param header Establece si el XML debe llevar cabecera.
     * @return String XML con la informaci�n.
     */   
    public String toXML(boolean header) {
       XmlTextBuilder bdr;
       String tagName = "Dias_Festivos";
       CalendarioDia dia;

       bdr = new XmlTextBuilder();
       if (header)
          bdr.setStandardHeader();

       bdr.addOpeningTag(tagName);

       for (int i = 0; i < count(); i++) {
    	   dia = get(i);
    	   bdr.addFragment(dia.toXML(false));
       }

       bdr.addClosingTag(tagName);

       return bdr.getText();
    }

    /**
     * Devuelve la informaci�n de los dias contenidos en la colecci�n.
     * @return String Cadena XML con la informaci�n de los documentos.
     */
    public String toString() {
       return toXML(false);
    }
}

