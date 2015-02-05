/**
 *
 */
package common.bi;

import java.util.List;

import common.util.IntervalOptions;

import transferencias.exceptions.ParteUnidadDocumentalNoEliminable;
import transferencias.exceptions.RelacionEntregaConUDocsSinAsingarAUIException;
import transferencias.exceptions.RelacionEntregaNoEnviableUIsConVariasFSException;
import transferencias.exceptions.RelacionEntregaNoEnviableUIsConVariasUDocsException;
import transferencias.exceptions.UnidadDocumentalNoPermitidaDivisionException;
import transferencias.exceptions.UnidadInstalacionConUnidadesDocumentalesException;
import transferencias.vos.UDocEnUIReeaCRVO;
import transferencias.vos.UIReeaCRVO;

/**
 * Gestion de Relaciones Entre Archivos con Reencajado
 * 
 * @author Iecisa
 * @version $Revision$
 * 
 */
public interface GestionRelacionesEACRBI {

	/**
	 * Se encarga de crear las unidades de instalaci�n junto con las unidades
	 * documentales del reencajado con el nuevo formato seleccionado.
	 * 
	 * @param idRelEntrega
	 * @param listaUIs
	 * @param idFormato
	 */
	public void crearUIsReeaConReencajadoNoTransaccional(String idRelEntrega,
			List listaUIs, String idFormato);

	/**
	 * Activa El Reencajado
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idFormato
	 *            Identificador
	 */
	public void activarReencajado(String idRelEntrega, String idFormato);

	/**
	 * Cancela los cambios referentes al reencajado iniciando una transaccion
	 * 
	 * @param idRelEntrega
	 */
	public void cancelarReencajadoTransaccional(String idRelEntrega);

	/**
	 * Cancela los cambios referentes al reencajado sin iniciar transaccion se
	 * utiliza para cuando se llamao desde otro Servicio que ya tiene su propia
	 * transacci�n.a
	 * 
	 * @param idRelEntrega
	 */
	public void cancelarReencajadoNoTransaccional(String idRelEntrega);

	/**
	 * A�ade una nueva unidadad de instalaci�n a la pesta�a de reencajado.
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idFormato
	 *            Identificador del Formato Nuevo de la Caja.
	 */
	public UIReeaCRVO addUIReencajado(String idRelEntrega, String idFormato);

	/**
	 * Crea una unidad de instalaci�n vac�a en la transferencia entre archivos
	 * con reencajado.
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idFormatoRe
	 *            Identificador del Formato del Reencajado
	 * @param udocs
	 *            Identificadores de las unidades de instalaci�n
	 */
	public UIReeaCRVO crearNuevaUICR(String idRelEntrega, String idFormatoRe,
			String[] udocs);

	/**
	 * Elimina una unidad de instalaci�n vac�a en la transferencia entre
	 * archivos con reencajado.
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idUiReeaCR
	 *            Identificador de la Unidad de Instalaci�n con Reencajado.
	 * @throws UnidadInstalacionConUnidadesDocumentalesException
	 */
	public void eliminarUICRVacia(String idRelEntrega, String idUiReeaCR)
			throws UnidadInstalacionConUnidadesDocumentalesException;

	/**
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idUI
	 *            Identificador de la Unidad de Instalaci�n
	 * @param idsUdocs
	 *            Identificador de las Unidades Documentales Afectadas
	 */
	public void subirUdocsEnUIReeaCR(String idRelEntrega, String idUI,
			String[] idsUdocs);

	/**
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 * @param idUI
	 *            Identificador de la Unidad de Instalaci�n
	 * @param idsUdocs
	 *            Identificadores de las unidades docuementales.
	 */
	public void bajarUdocsEnUI(String idRelEntrega, String idUI,
			String[] idsUdocs);

	/**
	 * Obtiene las unidades documentales que est�n sin unidad de instalaci�n en
	 * una relaci�n de entrega entre archivos con reencajado.
	 * 
	 * @param idRelEntrega
	 *            Identificador de la relaci�n de entrega.
	 * @return Lista de {@link UDocEnUIReeaCRVO}
	 */
	public List getUDocsSinUIReeaCR(String idRelEntrega);

	/**
	 * Incorpora las unidades seleccionadas a la Unidad de Instalaci�n
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param udocs
	 *            Identificador de las unidades documentales
	 */
	public void incorporarUdocsAUIReeaCR(String idRelEntrega, String idUI,
			String[] udocs);

	/**
	 * Extrae las unidades documentales seleccionadas de la unidad de
	 * instalaci�n
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param idUDoc
	 *            Identificador de las unidades documentales seleccionadas.
	 */
	public void extraerUDocsDeUIReeaCR(String idRelEntrega, String idUI,
			String[] idUDoc);

	/**
	 * Divide una unidad documental
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param idUDoc
	 *            Identificador de la unidad documental
	 * @param idFormatoRe
	 *            Identificador del Formato del Reencajado.
	 * @throws UnidadDocumentalNoPermitidaDivisionException
	 */
	public void dividirUDocReeaCR(String idRelEntrega, String idUI,
			String idUDoc, String idFormatoRe)
			throws UnidadDocumentalNoPermitidaDivisionException;

	/**
	 * Elimina un parte de una unidad documental
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param idUDoc
	 *            Identificador de la unidad documental
	 * @throws ParteUnidadDocumentalNoEliminable
	 */
	public void eliminarPartesUDocReeaCR(String idUI, String[] idUDoc)
			throws ParteUnidadDocumentalNoEliminable;

	/**
	 * Comprueba si una relaci�n de entrega entre archivos con reencajado puede
	 * ser enviada. Se comprueba lo siguiente: - Todas las unidades documentales
	 * deber�n estar asociadas a una unidad de instalaci�n - Si el formato es no
	 * multidocumento, por cada unidad de instalaci�n solo deber� existir una
	 * unidad documental
	 * 
	 * @param idRelacion
	 *            Identificador de la Relaci�n de Entrega
	 * @return true si cumple los requisitos anteriores
	 */
	public void checkPermtirEnviarRelacionEACR(String idRelEntrega)
			throws RelacionEntregaNoEnviableUIsConVariasFSException,
			RelacionEntregaNoEnviableUIsConVariasUDocsException,
			RelacionEntregaConUDocsSinAsingarAUIException;

	/**
	 * Obtiene la lista de unidades de instalaci�n del reencajado para dicha
	 * relaci�n
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n de entrega entre archivos
	 * @return Lista de objetos de tipo {@link UIReeaCRVO}
	 */
	public List getUIsReencajado(String idRelEntrega);

	/**
	 * Obtiene la unidades de Instalaci�n de una relacion entre archivos con
	 * reencajado
	 * 
	 * @param idRelacionEntrega
	 *            Identificador de la relaci�n de entrega.
	 * @return Lista de {@link UnidadInstalacionReeaVO}
	 */
	public List getUIsReencajado(String idRelEntrega, IntervalOptions ordenes);

	/**
	 * Obtiene la lista de unidades documentales de la unidad de instalaci�n de
	 * reencajado
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @return Lista de objetos de tipo {@link UDocEnUIReeaCRVO}
	 */
	public List getUDocsByUIReencajado(String idUI);

	/**
	 * Obtiene la lista de unidades documentales de la relaci�n sin asignar a
	 * una caja
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n
	 * @return Lista de objetos de tipo {@link UDocEnUIReeaCRVO}
	 */
	public List getUDocsSinAsignarByIdRelacion(String idRelEntrega);

	/**
	 * Obtiene la lista de unidades documentales de la relaci�n de entrega
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n
	 * @return Lista de objetos de tipo {@link UDocEnUIReeaCRVO}
	 */
	public List getUDocsByIdRelacion(String idRelEntrega);

	/**
	 * Obtiene al unidad de instalaci�n del reencajado por su identificador
	 * 
	 * @param idUIReeacr
	 *            identificador de la unidad de instalaci�n de reencajado
	 * @return Objeto de tipo {@link UIReeaCRVO}
	 */
	public UIReeaCRVO getUIReencajadoById(String idUIReeacr);

	/**
	 * Obtiene el n�mero de unidades de instalaci�n de la relaci�n de entrega
	 * entre archivos con reencajado
	 * 
	 * @param idRelacion
	 *            Identificador de la relaci�n de entrega
	 * @return
	 */
	public int getCountUIs(String idRelacion);

	/**
	 * Obtiene el n�mero de unidades de instalaci�n con estado pendiente de
	 * cotejo
	 * 
	 * @param idRelacion
	 * @return
	 */
	public int getCountUIsEstadoPendiente(String idRelacion);

	/**
	 * Obtiene la unidad documental de la caja de reencajado por su
	 * identificador
	 * 
	 * @param idUdocEnUI
	 *            Identificador de la unidad documental de la caja de reencajado
	 * @return Objeto de tipo {@link UDocEnUIReeaCRVO}
	 */
	public UDocEnUIReeaCRVO getUdocEnUIById(String idUdocEnUI);

	/**
	 * Obtiene el numero de unidades de instalaci�n de la relaci�n con
	 * reencajado
	 * 
	 * @param idRelEntrega
	 *            Identificador de la relaci�n
	 * @return Numero de unidades de instalacion
	 */
	public int getNumUIsReeaCr(String idRelEntrega);

	/**
	 * Actualiza la descripci�n de la unidad documental seleccionada
	 * 
	 * @param idUdoc
	 *            identificador de la unidad documental
	 * @param descripcion
	 *            Descripcion que se le asigna a la unidad documental
	 */
	public void updateDescripcionUdoc(String idUdoc, String descripcion);

	/**
	 * Actualiza la descripci�n de la unidad de instalaci�n seleccionada
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param descripcion
	 *            Descripci�n que se le asigna a la unidad de instalaci�n
	 */
	public void updateDescripcionUI(String idUI, String descripcion);

	/**
	 * Actualiza la signatura de la unidad de instalaci�n
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param signaturaUI
	 */
	public void updateSignaturaUI(String idUI, String signaturaUI);

	/**
	 * Actualiza la signatura de las unidades reencajadas de una unidad de
	 * instalacion
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalacion
	 */
	public void updateSignaturaUdocsByIdUinstalacion(String idUI);

	/**
	 * Actualiza el estado de cotejo de la unidad de instalaci�n
	 * 
	 * @param idUI
	 *            Identificador de la unidad de instalaci�n
	 * @param estado
	 *            Nuevo estado de cotejo
	 */
	public void updateEstadoCotejo(String idUI, int estado);

	/**
	 * A�ade las unidades de instalaci�n al reencajado
	 * 
	 * @param idRelEntrega
	 *            Identificador de la relaci�n de entrega
	 * @param idsUIs
	 *            Identficador de las Unidades de Instalaci�n.
	 * @param idFormatoRe
	 *            Identificador del Formato de Reencajado
	 */
	public void addUIReencajadoNoTransaccional(String idRelEntrega,
			List listaUIs, String idFormatoRe);

	/**
	 * Elmina las unidades de instalaci�n de una relaci�n entre archivos con
	 * reencajado
	 * 
	 * @param idRelEntrega
	 *            Identificador de la relaci�n de entrega
	 * @param idsUIS
	 *            Identificadores de las unidades de instalaci�n a eliminar.
	 */
	public void eliminarUIsReencajadoNoTransaccional(String idRelEntrega,
			String[] idsUIS);

	/**
	 * Crea los datos correspondientes en las siguientes tablas: -
	 * ASGDUINSTALACION - ASGDUDOCNEUI Actualiza los huecos ocupados por la
	 * relaci�n de entrega con el id correspondiente de la unidad de instalaci�n
	 * creada.
	 * 
	 * @param idRelEntrega
	 *            Identificador de la Relaci�n de Entrega
	 */
	public void crearDatosEnDepositoNoTransaccional(String idRelEntrega);

	/**
	 * Actualizar el estado de las unidades de instalaci�n
	 * 
	 * @param ids
	 *            Identificadores de las unidades de instalaci�n
	 */
	public void marcarUIsRevisadas(String[] ids);

	/**
	 * Obtiene las unidades de instalacion por los ordenes indicados.
	 * 
	 * @param idRelacionEntrega
	 * @param ordenes
	 * @return
	 */
	public List getUnidadesInstalacion(String idRelacionEntrega,
			IntervalOptions ordenes);

	/**
	 * Obtiene las unidades documentales de agrupadas por unidadoc
	 * 
	 * @param idRelacion
	 * @return
	 */
	public List getUDocsByIdRelacionGroupByUnidadDoc(String idRelacion);
}
