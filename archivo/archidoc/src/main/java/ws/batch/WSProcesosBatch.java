package ws.batch;

/**
 * Interfaz del servicio web de acceso a los procesos batch.
 */
public interface WSProcesosBatch {

	/**
	 * Cierra las previsiones que hayan caducado.
	 * 
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void cerrarPrevisiones() throws Exception;

	/**
	 * Publica las unidades documentales con acceso restringido que han
	 * sobrepasado la fecha de restricci�n.
	 * 
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void publicarUnidadesDocumentales() throws Exception;

	/**
	 * Elimina las unidades documentales prestadas que no han sido devueltas
	 * tras dos reclamaciones.
	 * 
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void eliminarUnidadesDocumentalesPrestadasNoDevueltas()
			throws Exception;

	/**
	 * Comprueba la validez de los documentos vitales vigentes y los pasa a
	 * hist�rico si han caducado.
	 * 
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void pasarAHistoricoDocumentosVitalesCaducados() throws Exception;

	/**
	 * Elimina los documentos vitales hist�ricos que no est�n referenciados en
	 * ning�n expediente.
	 * 
	 * @throws Exception
	 *             si ocurre alg�n error.
	 */
	public void eliminarDocumentosVitalesObsoletos() throws Exception;

}