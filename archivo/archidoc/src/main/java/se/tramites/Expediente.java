package se.tramites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Interfaz para la informaci�n de un expediente.
 */
public interface Expediente extends Serializable {

	/**
	 * Devuelve la informaci�n b�sica de un expediente.
	 * 
	 * @return Informaci�n b�sica de un expediente.
	 */
	public InfoBExpediente getInformacionBasica();

	/**
	 * Devuelve la fecha de inicio del expediente.
	 * 
	 * @return Fecha de inicio del expediente.
	 */
	public Date getFechaInicio();

	/**
	 * Devuelve la fecha de finalizaci�n del expediente.
	 * 
	 * @return Fecha de finalizaci�n del expediente.
	 */
	public Date getFechaFinalizacion();

	/**
	 * Devuelve el identificador del �rgano productor.
	 * 
	 * @return Identificador del �rgano productor.
	 */
	public String getIdOrgProductor();

	/**
	 * Devuelve el nombre del �rgano productor.
	 * 
	 * @return Nombre del �rgano productor.
	 */
	public String getNombreOrgProductor();

	/**
	 * Devuelve el asunto del expediente.
	 * 
	 * @return Asunto del expediente.
	 */
	public String getAsunto();

	/**
	 * Devuelve la lista de documentos f�sicos del expediente.
	 * 
	 * @return Lista de documentos f�sicos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link DocFisico}.
	 *         </p>
	 */
	public List getDocumentosFisicos();

	/**
	 * Devuelve la lista de documentos electr�nicos del expediente.
	 * 
	 * @return Lista de documentos electr�nicos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link DocElectronico}.
	 *         </p>
	 */
	public List getDocumentosElectronicos();

	/**
	 * Devuelve la lista de interesados asociados al expediente.
	 * 
	 * @return Lista de interesados.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link Interesado}.
	 *         </p>
	 */
	public List getInteresados();

	/**
	 * Devuelve la lista de emplazamientos del expediente.
	 * 
	 * @return Lista de emplazamientos.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link Emplazamiento}.
	 *         </p>
	 */
	public List getEmplazamientos();

}
