package ieci.tecdoc.sgm.registro.ws.server;

import ieci.tecdoc.sgm.core.services.dto.RetornoServicio;

/**
 * Bean con la informaci�n de un documento adjunto a la solicitud de registro.
 *
 * @author IECISA
 *
 */
public class PeticionDocumento extends RetornoServicio
{
   private String code;
   private String location;
   private String extension;
   private String fileName;
   private StringB64 fileContent;

   public PeticionDocumento()
   {
      code = null;
      location = null;
      extension = null;
      fileName = null;
      fileContent = null;
   }

   /**
    * Establece el c�digo del documento.
    * @param code C�digo del documento.
    */
   public void setCode(String code)
   {
      this.code = code;
   }

   /**
    * Establece la ruta a la ubicaci�n en el sistema de archivos del documento
    * antes de ser dado de alta en Invesdoc.
    * @param location Ruta en el sistema de archivos del servidor.
    */
   public void setLocation(String location)
   {
        this.location = location;
   }

   /**
    * Establece la extensi�n del documento.
    * @param extension Extensi�n del documento.
    */
   public void setExtension(String extension)
   {
      this.extension = extension;
   }

   /**
    * Establece el nombre del fichero local del documento.
    * @param fileName Nombre en local del documento.
    */
   public void setFileName(String fileName) {
      this.fileName = fileName;
   }

   /**
    * Devuelve el c�digo del documento.
    * @return String C�digo del documento.
    */
   public String getCode()
   {
      return code;
   }

   /**
    * Devuelve la ruta temporal del documento en el sistema de archivos antes de
    * ser dado de alta en Invesdoc.
    * @return String Ruta temporal del documento.
    */
   public String getLocation()
   {
      return location;
   }

   /**
    * Devuelve la extensi�n del documento.
    * @return String Extensi�n del documento.
    */
   public String getExtension()
   {
      return extension;
   }

   /**
    * Devuelve el nombre del fichero local del documento.
    * @return String Nombre del documento en local.
    */
   public String getFileName() {
       return fileName;
   }

public StringB64 getFileContent() {
	return fileContent;
}

public void setFileContent(StringB64 fileContent) {
	this.fileContent = fileContent;
}

}