package common.bi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import valoracion.vos.IUnidadDocumentalEliminacionVO;
import valoracion.vos.ValoracionSerieVO;
import deposito.vos.UDocEnUiDepositoVO;
import fondos.vos.INivelCFVO;
import fondos.vos.SerieVO;
import fondos.vos.TablaTemporalFondosVO;
import fondos.vos.UnidadDocumentalVO;
import gcontrol.model.NivelAcceso;

/**
 * Interface del servicio de gesti�n de unidades documentales
 */
public interface GestionUnidadDocumentalBI {

	/**
	 * Incorpora una unidad documental al cuadro de clasificaci�n de fondos
	 * documentales
	 * 
	 * @param serie
	 *            Serie del cuadro de clasificaci�n en la que ser� incorporada
	 *            la unidad documental
	 * @param valoracion
	 *            Valoraci�n dictaminada de la serie
	 * @param nivelEnCuadroClasificacion
	 *            Identificador del nivel en el cuadro de clasifciaci�n de la
	 *            unidad docuemental
	 * @param codigoUdoc
	 *            C�digo que debe ser asignado a la unidad documental
	 * @param unidadDocumental
	 *            Datos de la unidad documental transferida que se quiere
	 *            incorporar al cuadro de clasificaci�n
	 * @param sistemaProductor
	 *            C�digo y nombre del sistema productor de la unidad documental
	 * @param tipoDocumental
	 *            Tipo documental de la unidad
	 * @param idLCAPref
	 *            Id de lista de acceso preferente
	 * @param idArchivo
	 *            Id del archivo
	 * @param comprobarPermisos
	 *            Indica si se comprueban o no los permisos
	 * @return Unidad documental en el cuadro de clasificaci�n de fondos
	 *         documentales
	 */
	public UnidadDocumentalVO crearUnidadDocumental(SerieVO serie,
			ValoracionSerieVO valoracion,
			INivelCFVO nivelEnCuadroClasificacion, String codigoUdoc,
			transferencias.vos.UnidadDocumentalVO unidadDocumental,
			Map.Entry sistemaProductor, String tipoDocumental,
			String idLCAPref, String idArchivo, boolean comprobarPermisos,
			boolean isUnidadElectronica);

	/**
	 * Obtiene la unidad documental que se corresponde con un n�mero de
	 * expediente
	 * 
	 * @param numeroExpediente
	 *            N�mero de expediente
	 * @return Datos de unidad documental
	 */
	public UnidadDocumentalVO getUdocByNumeroExpediente(String numeroExpediente);

	/**
	 * Obtiene las unidades documentales constituidas por los expedientes cuyos
	 * n�meros se indican
	 * 
	 * @param numeroExpediente
	 *            Conjunto de n�meros de expediente
	 * @return Lista de unidades documentales {@link UnidadDocumentalVO}
	 */
	public List getUdocsByNumeroExpediente(String[] numeroExpediente);

	/**
	 * Obtiene la informaci�n de la unidad documental.
	 * 
	 * @param idElemento
	 *            Identificador de la unidad documental en el cuadro de
	 *            clasificaci�n.
	 * @return Unidad documental.
	 */
	public UnidadDocumentalVO getUnidadDocumental(String idElemento);

	UnidadDocumentalVO getTuplaUnidadDocumental(String idElemento);

	HashMap getUINumPartesUdocs(TablaTemporalFondosVO tablaTemporalFondosVO);

	HashMap getUdocNumCambiosVolumenSerie(List idsUdocs);

	/**
	 * 
	 * @param idElemento
	 *            : Id de la Udoc, es el mismo en la tabla elementoCF que en la
	 *            tabla UdocEnUi
	 * @return Lista de unidades documentales
	 */
	public List getUnidadDocumental(String[] idsElemento);

	/**
	 * Obtiene el conjunto de signaturas en las que se descompone una unidad
	 * documental
	 * 
	 * @param idUnidadDocumental
	 *            Identificador de unidad documental
	 * @return Lista de signaturas {@link UDocEnUiDepositoVO}
	 */
	public List getSignaturasUdoc(String id);

	/**
	 * Elimina una unidad documental dada
	 * 
	 * @param udoc
	 *            Unidad documental
	 */
	public void eliminarUdoc(IUnidadDocumentalEliminacionVO udoc);

	/**
	 * Obtiene un listado de las unidades documentales que est�n en una unidad
	 * de instalacion(que tienen una entrada en la tabla)
	 * 
	 * @param idUnidadDocumental
	 *            Identificador de la udoc
	 * @return Listado de {@link deposito.vos.UDocEnUiDepositoVO}
	 */
	public List getUdocsEnUI(String idUnidadDocumental);

	/**
	 * Desinstala una unidad documental de la ubicaci�n que ocupa en el dep�sito
	 * f�sico
	 * 
	 * @param idUdoc
	 *            Identificador de unidad documental
	 */
	public void desinstalarUnidadDocumental(String idUdoc);

	public void updateNumeroExpediente(String idUnidadDocumental,
			String numExpediente);

	public List getRangosUdoc(String idUDoc, String idCampoInicial,
			String idCampoFinal);

	/**
	 * Obtiene el n�mero de unidades documentales que han sido producidas por un
	 * determinado productor
	 * 
	 * @param descriptorProductor
	 *            Descriptor del productor
	 * @return N�mero de unidades documentales
	 */
	public int getNumUdocByProductor(String descriptorProductor);

	/**
	 * Obtiene las unidades documentales que contiene una unidad de instalaci�n.
	 * 
	 * @param idUInstalacion
	 *            Identificador de la unidad de instalaci�n
	 * @return Listado de {@link deposito.vos.UDocEnUiDepositoVO}
	 */
	public List getUdocsEnUnidadInstalacion(String idUInstalacion);

	List getIdsUIPartesUdoc(String idUnidadDocumental);

	/**
	 * Obtiene la unidad documental en el cuadro de clasificacion en la que se
	 * ha integrado la unidad documental proveniente de relacion de entrega que
	 * se indica
	 * 
	 * @param idUdocEnRelacionEntrega
	 *            Identificador de unidad documental
	 * @return Datos de unidad documental {@link UnidadDocumentalVO}
	 */
	public UnidadDocumentalVO getUdocXUdocEnTransferencia(
			String idUdocEnRelacionEntrega);

	/**
	 * Publica las unidades documentales con acceso restringido que han
	 * sobrepasado la fecha de restricci�n.
	 */
	public void publicarUnidadesDocumentales();

	/**
	 * Elimina las unidades documentales prestadas que no han sido devueltas
	 * tras dos reclamaciones.
	 */
	public void eliminarUnidadesDocumentalesPrestadasNoDevueltas()
			throws Exception;

	public void modificarSignaturaUDoc(UnidadDocumentalVO unidadDocumentalVO,
			String nuevaSignatura);

	public int getNumUdocsUISerie(String idSerie, String idUnidadInstalacion);

	/**
	 * Obtiene las n�meros de expediente que est�n en el cuadro de clasificaci�n
	 * de entre la lista que se pasa como par�metro
	 * 
	 * @param numerosExpedientes
	 *            Conjunto de n�meros de expediente
	 * @return Lista de n�meros de expediente
	 */
	public List findNumerosExpediente(String[] numerosExpediente);

	/**
	 * Actualiza los campos de la tabla de Unidades Documentales en el cuadro de
	 * clasificaci�n que es necesario modificar durante la validaci�n
	 * 
	 * @param idUnidadDocumental
	 * @param columnsToUpdate
	 */
	public void updateFieldsUDocCFVEA(UnidadDocumentalVO uDoc);

	/**
	 * Obtiene las Marcas de Bloqueo de la Unidad Documental Electr�nica.
	 * 
	 * @param idElementoCF
	 * @return
	 */
	public int getMarcasBloqueo(String idElementoCF);

	/**
	 * Obtiene el nivel de acceso de la unidad documental.
	 * 
	 * @param udoc
	 *            Informaci�n de la unidad documental.
	 * @param valoracion
	 *            Valoraci�n dictaminada de la serie.
	 * @return Nivel de acceso ({@link NivelAcceso}).
	 */
	public int getNivelAcceso(transferencias.vos.UnidadDocumentalVO udoc,
			ValoracionSerieVO valoracion);

	/**
	 * Obtiene la unidad documental en divisi�n de fracci�n de serie cuando ya
	 * est� ubicada en el dep�sito
	 * 
	 * @param idUdocEnDivisionFS
	 * @return
	 */
	public UnidadDocumentalVO getUdocXUdocEnDivisionFS(String idUdocEnDivisionFS);

	/**
	 * Elimina el identificador de la eliminaci�n donde se conserv� la unidad
	 * documental
	 * 
	 * @param ids
	 *            Array de cadenas que contiene los identificadores de las
	 *            unidades documentales a tratar.
	 */
	public void eliminarMarcaConservadaUdocsSerie(String[] ids);
}
