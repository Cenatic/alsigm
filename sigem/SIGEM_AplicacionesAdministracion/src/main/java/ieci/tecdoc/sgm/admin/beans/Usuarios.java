package ieci.tecdoc.sgm.admin.beans;

import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;
import ieci.tecdoc.sgm.admin.interfaces.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuarios implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList usuarios;

	   public Usuarios() {
		   usuarios = new ArrayList();
	   }
	   
	   /**
	    * Devuelve el n�mero de mime types de la colecci�n.
	    * @return int N�mero de mime types de la colecci�n.
	    */   
	   public int count(){
	      return usuarios.size();
	   }
	   
	   /**
	    * Devuelve el mime type de la posici�n indicada dentro de la colecci�n
	    * @param index Posici�n del mime type a recuperar.
	    * @return MimeType MimeType asociado a registro.
	    */   
	   public Usuario get(int index){
	      return (Usuario)usuarios.get(index);
	   }
	   /**
	    * A�ade un nuevo mime type a la colecci�n.
	    * @param mimeType Nuevo mime type a a�adir.
	    */   
	   public void add(Usuario mimeType) {
		   usuarios.add(mimeType);
	   }
	   
	   /**
	    * Devuelve una cadena XML con los datos de los mime types de la colecci�n.
	    * @param headline Indica si el XML debe llevar cabecera.
	    * @return String Cadena XML con los datos de los mime types.
	    */   
	   public String toXML(boolean headline) {
	      XmlTextBuilder bdr;
	      String tagName = "Aplicaciones";
	      Usuario mimeType;
	      
	      bdr = new XmlTextBuilder();
	      if (headline)
	         bdr.setStandardHeader();

	      bdr.addOpeningTag(tagName);

	      for (int i = 0; i < count(); i++){
	         mimeType = get(i);

	         bdr.addFragment(mimeType.toXML(false));
	      }

	      bdr.addClosingTag(tagName);
	      
	      return bdr.getText();
	   }

	   /**
	    * Devuelve una cadena con los datos de los mime types asociados a registro de la colecci�n.
	    * @return String Cadena XML con los datos de los mime types.
	    */
	    public String toString(){
	      return toXML(false);
	   }

}
