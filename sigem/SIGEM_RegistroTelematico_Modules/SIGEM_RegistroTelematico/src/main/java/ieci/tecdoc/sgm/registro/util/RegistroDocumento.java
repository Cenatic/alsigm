package ieci.tecdoc.sgm.registro.util;


/**
 * Interfaz de comportamiento de un n�mero de secuencia de registro.
 * 
 * @author IECISA
 *
 */
public interface RegistroDocumento 
{

   /**
   * Devuelve el identificador �nico de documento.
   * @return String Identificador �nico de documento.
   */
   public abstract String getGuid();

   /**
   * Establece identificador �nico de documento.
   * @param guid Identificador �nico de documento.
   */   
   public abstract void setGuid(String guid);

   /**
   * Devuelve el n�mero del registro al que pertenece el documento.
   * @return String Identificador �nico de documento.
   */
   public abstract String getRegistryNumber();
 
   /**
    * Establece el n�mero del registro al que pertenece el documento.
    * @param registryNumber Identificador �nico de documento.
    */   
   public abstract void setRegistryNumber(String registryNumber); 

   /**
   * Devuelve c�digo de documento.
   * @return String Identificador �nico de documento.
   */
   public abstract String getCode();

   /**
   * Establece c�digo de documento.
   * @param code Identificador �nico de documento.
   */   
   public void setCode(String code);
   
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