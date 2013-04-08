package ieci.tecdoc.sgm.registro.util;
import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;
import ieci.tecdoc.sgm.registro.util.RegistroSecuencia;

/**
 * Bean con las propiedades de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroSecuenciaImpl implements RegistroSecuencia 
{
   public RegistroSecuenciaImpl()
   {
   }
   
	/**
	 * Devuelve el a�o del n�mero de secuencia.
	 * @return String A�o del n�mero de secuencia.
	 */      
   public String getYear()
   {
      return year;
   }
	
   /**
    * Devuelve la etiqueta del n�mero de secuencia.
    * @return String Etiqueta del n�mero de secuencia.
    */		   
   public String getLabel()
   {
      return label;
   }
		
   /**
    * N�mero de secuencia
    * @return int N�mero de secuencia.
    */   		   
   public int getSequence()
   {
      return sequence;
   }
	
   /**
    * Establece el a�o del n�mero de secuencia.
    * @param year A�o del n�mero de secuencia.
    */   	
   public void setYear(String year)
   {
      this.year = year;
   }
   
   /**
    * Establece la etiqueta del n�mero de secuencia.
    * @param label Etiqueta del n�mero de secuencia.
    */      
   public void setLabel(String label)
   {
      this.label = label;
   }

   /**
    * Establece el n�mero de secuencia.
    * @param sequence N�mero de secuencia.
    */   
   public void setSequence(int sequence)
   {
      this.sequence = sequence;
   }

   /**
    * Recoge los valores de la instancia en una cadena xml
    * @param header Si se incluye la cabecera
    * @return los datos en formato xml
    */   
   public String toXML(boolean header) {
      XmlTextBuilder bdr;
      String tagName = "Sequence";

      bdr = new XmlTextBuilder();
      if (header)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);

      bdr.addSimpleElement("Year", year);
      bdr.addSimpleElement("Label", label);
      bdr.addSimpleElement("Sequence", Integer.toString(sequence));

      bdr.addClosingTag(tagName);

      return bdr.getText();
   }

   /**
    * Devuelve los valores de la instancia en una cadena de caracteres.
    */
   public String toString() {
      return toXML(false);
   }

   protected String year;
   protected String label;
   protected int sequence;

   
}