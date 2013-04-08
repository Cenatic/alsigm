package ieci.tecdoc.sgm.registro.util;

/**
 * Interfaz de comportamiento de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public interface RegistroSecuencia 
{

	/**
	 * Devuelve el a�o del n�mero de secuencia.
	 * @return String A�o del n�mero de secuencia.
	 */
   public abstract String getYear();
   
   /**
    * Devuelve la etiqueta del n�mero de secuencia.
    * @return String Etiqueta del n�mero de secuencia.
    */   
   public abstract String getLabel();
   
   /**
    * N�mero de secuencia
    * @return int N�mero de secuencia.
    */   
   public abstract int getSequence();
	
   /**
    * Establece el a�o del n�mero de secuencia.
    * @param year A�o del n�mero de secuencia.
    */	
   public abstract void setYear(String year);
   
   /**
    * Establece la etiqueta del n�mero de secuencia.
    * @param label Etiqueta del n�mero de secuencia.
    */   
   public abstract void setLabel(String label);
   
   /**
    * Establece el n�mero de secuencia.
    * @param sequence N�mero de secuencia.
    */   
   public abstract void setSequence(int sequence);

   /**
    * Recoge los valores de la instancia en una cadena xml
    * @param header Si se incluye la cabecera
    * @return los datos en formato xml
    */
   public abstract String toXML(boolean header);

   /**
    * Devuelve los valores de la instancia en una cadena de caracteres.
    */
   public abstract String toString();

}