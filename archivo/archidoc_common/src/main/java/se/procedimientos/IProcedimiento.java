package se.procedimientos;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz para la informaci�n de un procedimiento.
 */
public interface IProcedimiento extends Serializable {
	public static final int AUTOMATICO = 1;
	public static final int NO_AUTOMATICO = 2;
	public static final int EXTERNO = 3;

	/**
	 * Devuelve la informaci�n b�sica de un procedimiento.
	 *
	 * @return informaci�n b�sica de un procedimiento.
	 */
	public InfoBProcedimiento getInformacionBasica();

	/**
	 * Devuelve el objeto del procedimiento.
	 *
	 * @return Objeto del procedimiento.
	 */
	public String getObjeto();

	/**
	 * Devuelve los tr�mites de un procedimiento.
	 *
	 * @return Tr�mites de un procedimiento.
	 */
	public String getTramites();

	/**
	 * Devuelve la normativa de un procedimiento.
	 *
	 * @return Normativa de un procedimiento.
	 */
	public String getNormativa();

	/**
	 * Devuelve los documentos b�sicos de un procedimiento.
	 *
	 * @return Documentos b�sicos de un procedimiento.
	 */
	public String getDocumentosBasicos();

	/**
	 * Devuelve la lista de �rganos productores del procedimiento.
	 *
	 * @return Lista de �rganos productores del procedimiento.
	 *         <p>
	 *         Los objetos de la lista tienen que implementar el interface
	 *         {@link IOrganoProductor}.
	 *         </p>
	 */
	public List getOrganosProductores();

}
