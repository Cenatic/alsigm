package ieci.tdw.ispac.ispacweb.tag.context;

public interface IStaticContext {
	
	/**
	 * Obtiene la url base para los elementos est�ticos de la presentaci�n
	 * a partir del contexto de la aplicaci�n.
	 * 
	 * @param context Contexto de la aplicaci�n.
	 * @return Url base para los elementos est�ticos de la presentaci�n.
	 */
	public String getBaseUrl(String context);

}