package ieci.tecdoc.sgm.autenticacion.util;

import ieci.tecdoc.sgm.autenticacion.util.Solicitante;

import java.util.Date;

/**
 * Clas que representa una sesi�n de un usario solicitante
 * @author x53492no
 *
 */
public class SesionSolicitante {

   private String sessionId;
   private String hookId;
   private String loginDate;
   private Solicitante sender;

   /**
    * Obtiene el identificador de sesi�n
    * @return String Identificador de sesi�n
    */
   public String getSessionId() {
      return this.sessionId;
   }
   
   /**
    * Obtiene el identificador de conector
    * @return String Identificador del conector de sesi�n
    */
   public String getHookId(){
      return this.hookId;
   }
   
   /**
    * Obtiene la fecha de inicio de sesi�n del usuario
    * @return String Fecha de inicio de desi�n
    */
   public String getLoginDate(){
      return this.loginDate;
   }
   
   /**
    * Obtiene los datos del solicitante al que pertenece la sesi�n
    * @return Solicitante Datos del solicitante
    */
   public Solicitante getSender(){
      return this.sender;
   }

   /**
    * Establece el identificador de sesi�n
    * @param sessionId Identificador de sesi�n
    */
   public void setSessionId(String sessionId){
      this.sessionId = sessionId;
   }
   
   /**
    * Etablece el identificador de conector de sesi�n
    * @param hookId Identificador del conector de sesi�n
    */
   public void setHookId(String hookId){
   	  this.hookId = hookId;
   }
   
   /**
    * Establece la fecha de inicio de sesi�n
    * @param loginDate Fecha de inicio
    */
   public void setLoginDate(String loginDate){
   	  this.loginDate = loginDate;
   }
   
   /**
    * Establece los datos del solicitante
    * @param sender Datos del solicitante
    */
   public void setSender(Solicitante sender){
   	  this.sender = sender;
   }
}