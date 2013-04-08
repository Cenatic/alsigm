/**
 * 
 */
package es.ieci.tecdoc.fwktd.audit.core.vo;

/**
 * @author IECISA
 * @version $Revision$
 *
 */
public class AppAuditoriaVO {
	
	/**
	 * Identificador de la aplicaci�n registrada. Se utilizar� al generar las trazas. 
	 * Debe de ser �nico.
	 */
	private Long appId;
	
	/**
	 * Descripci�n de la aplicaci�n registrada. Se utilizar� al generar las trazas. 
	 * Debe de ser �nico.
	 */
	private String appDescription;
	/**
	 * @return el appId
	 */
	public Long getAppId() {
		return appId;
	}
	/**
	 * @param appId el appId a fijar
	 */
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	/**
	 * @return el appDescription
	 */
	public String getAppDescription() {
		return appDescription;
	}
	/**
	 * @param appDescription el appDescription a fijar
	 */
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	
	
	

}
