package deposito.model;

import fondos.vos.BusquedaElementosVO;
import gcontrol.vos.ArchivoVO;
import ieci.core.exception.IeciTdException;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import solicitudes.prestamos.vos.DetallePrestamoVO;
import transferencias.vos.RelacionEntregaVO;
import valoracion.vos.HistoricoUDOCVO;

import common.exceptions.ActionNotAllowedException;
import common.exceptions.TooManyResultsException;
import common.util.CustomDateRange;
import common.util.IntervalOptions;
import common.vos.ResultadoRegistrosVO;

import deposito.db.ConcurrentModificationException;
import deposito.exceptions.DepositoElectronicoAlreadyExistsException;
import deposito.exceptions.DepositoElectronicoEnUsoException;
import deposito.exceptions.TipoElementoDepositoException;
import deposito.vos.BusquedaHistUInstDepositoVO;
import deposito.vos.BusquedaUIAnioSerieVO;
import deposito.vos.DepositoElectronicoVO;
import deposito.vos.DepositoVO;
import deposito.vos.ElementoAsignableVO;
import deposito.vos.ElementoNoAsignableVO;
import deposito.vos.ElementoVO;
import deposito.vos.FormatoHuecoVO;
import deposito.vos.HistUInstDepositoVO;
import deposito.vos.HuecoID;
import deposito.vos.HuecoVO;
import deposito.vos.InformeOcupacion;
import deposito.vos.OcupacionElementoDeposito;
import deposito.vos.ResumenOcupacionVO;
import deposito.vos.TipoElementoVO;
import deposito.vos.UDocEnUiDepositoVO;
import deposito.vos.UIAnioSerieVO;
import deposito.vos.UInsDepositoVO;

public interface GestorEstructuraDepositoBI {

	public ElementoVO eliminarElemento(String idElemento, String idTipoElemento)
			throws DepositoException;

	public HuecoVO getInfoHueco(HuecoID idHueco);

	public HuecoVO getHuecoUInstalacion(String unidadInstalacion);

	public ElementoVO getInfoElemento(String idElemento, String tipoElemento);

	public List getHijosElemento(String idElemento, String idTipoElemento);

	public ElementoVO getElementoPadre(String idElemento, String idTipoElemento);

	public List[] getHuecosUbicacionSinReservaSuficiente(
			String idAsignableDestino, String idTipoAsignableDestino,
			String idRelacion) throws NoAvailableSpaceException;

	public List[] getHuecosUbicacionConReservaSuficiente(
			String idRelacionEntrega);

	public ElementoAsignableVO getElementoAsignable(String idAsignable);

	public ElementoNoAsignableVO getElementoNoAsignable(String idNoAsignable);

	/**
	 * Obtiene los elementos no asignables que coincidan con el idPadre e
	 * idUbicacion
	 * 
	 * @param idPadre
	 * @param idUbicacion
	 * @return Lista de objetos {@link ElementoNoAsignableVO}
	 */
	public Collection getElementosNoAsignables(String idPadre,
			String idUbicacion);

	public List getFormatos();

	public List getFormatosVigentes();

	FormatoHuecoVO getFormatoByNombre(String nombre);

	public List getFormatosRegulares();

	public List getFormatosIrregulares();

	public List getHuecos(String idAsignable);

	public List getHuecos2(String idAsignable);

	public List getHuecosReservadosXIdRelacionEntrega(String idRelacionEntrega);

	public TipoElementoVO getTipoElementoSingleton(String idTipoElemento);

	public TipoElementoVO getTipoElemento(String idTipoElemento);

	/**
	 * Obtiene la lista de ubicaciones que componen el fondo f�sico manejado por
	 * el sistmea
	 * 
	 * @return Lista de ubicaciones {@link DepositoVO}
	 */
	public Collection getEdificios();

	public Collection getEdificios(String nombre);

	/**
	 * mueve uinstalacion de los huecos de origen(pasaran a estado libre) a los
	 * huecos destino(que deberan estar libres y pasarana estado ocupado)
	 * 
	 * @return Lista de elementos HuecoID, con los ids de los elementos
	 *         ubicados.
	 * @throws Exception
	 */
	public List reubicarUnidadesInstalacion(HuecoID[] huecosOrigen,
			ElementoVO elementoDestino) throws NoAvailableSpaceException,
			Exception;

	/**
	 * Actualiza la signatura del hueco seleccionado
	 * 
	 * @param archivoVO
	 * @param unHueco
	 * @param valorSignatura
	 * @throws Exception
	 */
	public void actualizarSignaturaHueco(ArchivoVO archivoVO, HuecoVO unHueco,
			String valorSignatura) throws Exception;

	public List searchNHuecosLibres(String idElementoDestino,
			String idTipoElementoDestino, int nHuecos, String idElementoOrigen,
			String idTipoElementoOrigen, String idTipoFormatoElementoOrigen)
			throws NoAvailableSpaceException;

	/**
	 * Busca los huecos libres a partir de un elemento especificado. Permitiendo
	 * recorrer todos los dep�sitos
	 * 
	 * @param idElementoDestino
	 * @param idTipoElementoDestino
	 * @param nHuecos
	 * @param idElementoOrigen
	 * @param idTipoElementoOrigen
	 * @param idTipoFormatoElementoOrigen
	 * @param recorrerDepositos
	 *            Si se le pasa true, busca huecos en todas la ubicaci�n. Si se
	 *            le pasa false, solo busca en el dep�sito seleccionado. Este
	 *            par�metro solo tiene validez si el elemento idTipoElemento no
	 *            es un ubicaci�n.
	 * @return
	 * @throws NoAvailableSpaceException
	 */
	public List searchNHuecosLibres(String idElementoDestino,
			String idTipoElementoDestino, int nHuecos, String idElementoOrigen,
			String idTipoElementoOrigen, String idTipoFormatoElementoOrigen,
			boolean recorrerDepositos) throws NoAvailableSpaceException;

	public List getHuecosLibresAsignable(String idElemento);

	public void reservarHuecos(List huecosAReservar,
			RelacionEntregaVO relacionEntrega) throws ActionNotAllowedException;

	public void rechazarReserva(RelacionEntregaVO relacionVO)
			throws ActionNotAllowedException;

	public DepositoVO getUbicacion(String idUbicacion);

	public ElementoNoAsignableVO getNoAsignable(String idNoAsignable);

	/**
	 * M�todo para ubicar una Relaci�n con una transacci�n ya creada, el m�todo
	 * que lo llama deber�a estar dentro de una transacci�n
	 * 
	 * @param relacionBI
	 *            Servicio de relaciones
	 * @param gestionFondos
	 *            Servicio de fondos
	 * @param relacionEntregaVO
	 *            Relaci�n de entrega
	 * @param huecosReservadosAOcupar
	 *            Huecos a ocupar
	 * @param huecosReservadorALiberar
	 *            Huecos a liberar
	 * @param huecosLibresAOcupar
	 *            Huecos libres a ocupar
	 * @param idElementoDestino
	 *            Id del elemento destino
	 * @param tipoElementoDestino
	 *            Tipo del elemento destino
	 * @throws ConcurrentModificationException
	 * @throws ActionNotAllowedException
	 */
	public void ubicarRelacionConTransact(String idRelacionEntrega,
			List huecosReservadosAOcupar, List huecosReservadorALiberar,
			List huecosLibresAOcupar, String idElementoDestino,
			String tipoElementoDestino) throws ConcurrentModificationException,
			ActionNotAllowedException;

	/**
	 * Ubica las unidades de instalacion de una relacion de entrega en el
	 * deposito fisico
	 * 
	 * @param idRelacionEntrega
	 *            Identificador de la relacion de entrega a ubicar
	 * @param detalleUbicacionHuecosReservadosAOcupar
	 *            Huecos reservados que deben ser ocupados durante la ubicacion
	 * @param detalleUbicacionHuecosReservadosALiberar
	 *            Huecos reservados a liberar durante la ubicacion
	 * @param detalleUbicacionHuecosLibresAOcupar
	 *            Huecos libres que seran ocupados en la ubicacion
	 * @param idDestino
	 *            Identificador del elemento del deposito elegido como punto de
	 *            partida para la seleccion de los huecos a ocupar
	 * @param idTipoDestino
	 *            Tipo de elemento del deposito elegido como punto de partida
	 *            para la seleccion de los huecos a ocupar
	 * @throws ActionNotAllowedException
	 * @throws Exception
	 */
	public void ubicarRelacion(String idRelacionEntrega,
			List detalleUbicacionHuecosReservadosAOcupar,
			List detalleUbicacionHuecosReservadosALiberar,
			List detalleUbicacionHuecosLibresAOcupar, String idDestino,
			String idTipoDestino) throws ConcurrentModificationException,
			ActionNotAllowedException;

	public int countHuecosEnDepositoXEstadoYFormato(String idDeposito,
			String idFormato, String[] estados);

	public List getUDocsHueco(HuecoID idHueco);

	public UInsDepositoVO getUinsEnDeposito(String idUinsEnDeposito);

	public EstructuraDeposito getEstructuraDeposito();

	/**
	 * Metodo para poder obtener la vista en arbol a partir de un nodo.
	 */
	EstructuraDeposito getEstructuraDeposito(String subtreeNode);

	/**
	 * Realiza el borrado de una unidad de instalacion por su identificador.
	 * 
	 * @param idArchivo
	 *            Identificador del Archivo
	 * @param idUInstaEnDeposito
	 *            Identificador de la unidad.
	 * @param motivo
	 *            Motivo de la eliminacion
	 * @throws Exception
	 *             Si se produce un error durante el proceso
	 */
	public abstract void deleteUInstDeposito(String idArchivo,
			UInsDepositoVO unidadInstalacion, Integer motivo) throws Exception;

	/**
	 * Realiza la liberacion de una unidad de instalacion poniendo su estado a
	 * libre 'L' y a nulo el campo IDUINSTALACION
	 * 
	 * @param conn
	 *            Conexion a la base de datos
	 * @param idUnidadInstalacion
	 *            Identificador de la unidad a liberar
	 * @throws Exception
	 *             Si se produce un error durante el proceso
	 */
	public abstract void liberaUnidadInstalacion(String idUnidadInstalacion);

	/**
	 * Obtiene los datos de ocupaci�n de una de las ubicaciones del fondo f�sico
	 * 
	 * @param idUbicacion
	 *            Identificador de ubicaci�n
	 * @return Datos de ocupaci�n de la ubicaci�n
	 */
	public InformeOcupacion getInformeOcupacionDeposito(String idUbicacion);

	/**
	 * Obtiene los datos de ocupaci�n de una de los elementos no asignables del
	 * fondo f�sico
	 * 
	 * @param idUbicacion
	 *            Identificador de elemento no asignable
	 * @return Datos de ocupaci�n de la ubicaci�n
	 */
	public InformeOcupacion getInformeOcupacionElementoNoAsignable(
			String idElementoNoAsignable);

	/**
	 * Obtiene los datos de ocupaci�n en el formato indicado de un elemento del
	 * fondo f�sico
	 * 
	 * @param idElemento
	 *            Identificador de elemento del fondo f�sico
	 * @param tipoElemento
	 *            Tipo de elemento del fondo f�sico
	 * @param formato
	 *            Identificador de formato
	 * @return Datos de ocupaci�n con numero de huecos libres, ocupados y
	 *         porcentajes de ocupaci�n de huecos del formato indicado en el
	 *         elemento del fondo f�sico
	 */
	public OcupacionElementoDeposito getDatosOcupacion(String idElemento,
			String tipoElemento, String formato);

	/**
	 * Obtiene el n�mero de huecos de un determinado formato disponibles en una
	 * ubicaci�n del fondo f�sico manejado por el sistema
	 * 
	 * @param idDeposito
	 *            Identificador de ubicaci�n
	 * @param idFormato
	 *            Formato de hueco
	 * @return Numero de huecos disponibles en la ubicaci�n
	 */
	public int getNumeroHuecosDisponibles(String idDeposito, String idFormato);

	/**
	 * Libera los huecos que han sido reservados para ubicar una relaci�n de
	 * entrega
	 * 
	 * @param idRelacion
	 *            Identificador de relaci�n de entrega
	 */
	public void liberarReserva(String idRelacion);

	/**
	 * Obtiene una unidad documental instalada en una determinada posici�n
	 * dentro de una unidad de instalacion
	 * 
	 * @param idUInstalacion
	 *            Identificador de unidad de instalaci�n instalada en un hueco
	 *            del dep�sito f�sico
	 * @param posUdoc
	 *            Posici�n de unidad documental dentro de la unidad de
	 *            instalaci�n
	 * @return Datos de unidad documental instalada en el dep�sito f�sico
	 */
	public UDocEnUiDepositoVO abrirUdocEnUI(String idUInstalacion, int posUdoc)
			throws ActionNotAllowedException;

	/**
	 * Incorpora una nueva ubicaci�n a la estructura del dep�sito f�sico
	 * gestionado por el sistema
	 * 
	 * @param ubicacion
	 *            Datos de ubicaci�n a guardar
	 */
	public void guardarUbicacion(DepositoVO ubicacion)
			throws ActionNotAllowedException;

	/**
	 * Obtiene los datos de uno de los formatos de hueco admitidos por el
	 * sistema
	 * 
	 * @param idFormatoHueco
	 *            Identificador del formato
	 * @return Datos de formato de hueco
	 */
	public FormatoHuecoVO getFormatoHueco(String idFormatoHueco);

	/**
	 * 
	 * @param idFormatoHueco
	 * @return True si un formato es eliminable
	 */
	public boolean isFormatoHuecoEliminable(String idFormatoHueco);

	/**
	 * 
	 * @param idFormatoHueco
	 * @return True si un formato es modificable
	 */
	public boolean isFormatoHuecoModificable(String idFormatoHueco);

	public List crearElementosAsignables(ElementoNoAsignableVO elementoPadre,
			TipoElementoVO tipoElementos, String idFormato, double longitud,
			int numeroHuecos, int numero) throws ActionNotAllowedException;

	List crearElementosAsignables(ElementoNoAsignableVO elementoPadre,
			TipoElementoVO tipoElementos, String idFormato, double longitud,
			int numeroHuecos, int numero, HashMap numeracionPos)
			throws ActionNotAllowedException;

	/**
	 * Crea elementos no asignables en deposito
	 * 
	 * @param padreIsUbicacion
	 *            indica si el padre es una ubicacion
	 * @param elementoPadre
	 *            identificador del elemento padre
	 * @param tipoElementos
	 *            tipo de los elementos a crear
	 * @param numero
	 *            numero de orden a crear
	 * @return Lista de {@link ElementoNoAsignableVO}
	 * @throws ActionNotAllowedException
	 */
	public List crearElementosNoAsignables(boolean padreIsUbicacion,
			ElementoNoAsignableVO elementoPadre, TipoElementoVO tipoElementos,
			int numero) throws ActionNotAllowedException;

	/**
	 * Obtiene un resumen de la ocupaci�n de un elemento del dep�sito f�sico
	 * gestionado por el sistema
	 * 
	 * @param elementoDeposito
	 *            Elemento del deposito para el que se calcula la ocupaci�n.
	 *            Caso de ser nulo se calcula la ocupaci�n del conjunto del
	 *            dep�sito
	 * @return Resumen de ocupaci�n en el que se indica la cantidad de huecos
	 *         libres, reservados, ocupados e inutilizados.
	 */
	public ResumenOcupacionVO getResumenOcupacion(ElementoVO elementoDeposito);

	/**
	 * Obtiene un resumen de la ocupaci�n de un filtrando por ubicaciones. por
	 * el sistema
	 * 
	 * @param elementoDeposito
	 *            Elemento del deposito para el que se calcula la ocupaci�n.
	 *            Caso de ser nulo se calcula la ocupaci�n del conjunto del
	 *            dep�sito
	 * @return Resumen de ocupaci�n en el que se indica la cantidad de huecos
	 *         libres, reservados, ocupados e inutilizados.
	 */
	public ResumenOcupacionVO getResumenOcupacionByUbicaciones(List listaIds);

	public List getSubtiposTipoElemento(String idTipoElemento, String[] exclude);

	/**
	 * @param asignable
	 */
	public void guardarAsignable(ElementoAsignableVO asignable,
			ElementoNoAsignableVO padre) throws ActionNotAllowedException;

	public void atachUdocToElementoCF(String idUnidadDocumental,
			String idElmentoCF);

	/**
	 * @param idAsignable
	 * @param numeroOrdenHueco
	 * @param estadoAEstablecer
	 * @param estadoHuecoEsperado
	 */
	public void setEstadoHuecos(String idAsignable, int[] numeroOrdenHueco,
			String estadoAEstablecer, String estadoHuecoEsperado)
			throws ActionNotAllowedException;

	/**
	 * Obtiene los huecos cuyos identificadores se suministran
	 * 
	 * @param idHuecosAMover
	 *            Lista de identificadores de hueco {@link HuecoID}
	 * @return Lista de huecos {@link HuecoVO}
	 */
	public List getHuecos(HuecoID[] idHuecosAMover);

	// =======================================================================
	// DEP�SITOS ELECTR�NICOS
	// =======================================================================

	/**
	 * Obtiene la lista de dep�sitos electr�nicos.
	 * 
	 * @return Lista de dep�sitos electr�nicos ({@link DepositoElectronicoVO}).
	 */
	public List getDepositosElectronicos();

	/**
	 * Obtiene la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param id
	 *            Identificador del dep�sito electr�nico.
	 * @return Dep�sito electr�nico.
	 */
	public DepositoElectronicoVO getDepositoElectronico(String id);

	/**
	 * Obtiene la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param idExt
	 *            Identificador externo del dep�sito electr�nico.
	 * @return Dep�sito electr�nico.
	 */
	public DepositoElectronicoVO getDepositoElectronicoByIdExt(String idExt);

	/**
	 * Crea un dep�sito electr�nico.
	 * 
	 * @param deposito
	 *            Informaci�n del dep�sito electr�nico.
	 * @return Dep�sito electr�nico creado.
	 * @throws DepositoElectronicoAlreadyExistsException
	 *             si ya existe un dep�sito electr�nico con el mismo
	 *             identificador externo.
	 */
	public DepositoElectronicoVO insertDepositoElectronico(
			DepositoElectronicoVO deposito)
			throws DepositoElectronicoAlreadyExistsException;

	/**
	 * Modifica la informaci�n de un dep�sito electr�nico.
	 * 
	 * @param deposito
	 *            Informaci�n del dep�sito electr�nico.
	 * @throws DepositoElectronicoAlreadyExistsException
	 *             si ya existe un dep�sito electr�nico con el mismo
	 *             identificador externo.
	 */
	public void updateDepositoElectronico(DepositoElectronicoVO deposito)
			throws DepositoElectronicoAlreadyExistsException;

	/**
	 * Elimina un dep�sito electr�nico.
	 * 
	 * @param id
	 *            Identificador del dep�sito electr�nico.
	 * @throws DepositoElectronicoEnUsoException
	 *             si el dep�sito est� en uso.
	 */
	public void deleteDepositoElectronico(String id)
			throws DepositoElectronicoEnUsoException;

	/**
	 * Elimina una lista de dep�sitos electr�nicos.
	 * 
	 * @param ids
	 *            Lista de identificadores de dep�sitos electr�nicos.
	 * @return Informaci�n de la eliminaci�n.
	 */
	public ResultadoRegistrosVO deleteDepositosElectronicos(String[] ids);

	/**
	 * 
	 * @param idUInstalacion
	 * @return Las unidades documentales que se encuentran en una unidad de
	 *         instalacion
	 */
	public List getUDocsEnUInstalacion(String idUInstalacion);

	/**
	 * 
	 * @param idUInstalacion
	 * @return Las unidades documentales validadas que se encuentran en una
	 *         unidad de instalacion
	 */
	public List getUDocsValidadasEnUInstalacion(String idUInstalacion);

	/**
	 * Devuelve la lista de huecos que pueden ser destino de la udocumental de
	 * valor en el campo identificacion el pasado por parametro, y que se
	 * encuentran en el asignable indicado por parametro
	 * 
	 * @param idAsignableDestino
	 * @return
	 */
	public List getHuecosParaReubicarUdocs(
			String identificacionUnidadDocumental, String idAsignableDestino);

	public List getUDocsById(String[] idUdocs);

	/**
	 * Obtiene las Unidades Documentales por id y signatura
	 * 
	 * @param idUdocs
	 *            Ids de las unidades documentales
	 * @param signaturas
	 *            Singnaturas
	 * @return Lista de {@link UDocEnUiDepositoVO}
	 */
	public List getUDocsById(String[] idUdocs, String[] signaturas);

	/**
	 * Reubica las unidades documentales pasadas por parametro a la unidad de
	 * instalacion destino cuyo id es pasado por parametro
	 * 
	 * @param unidadesDocumentales
	 *            a reubicar
	 * @param idUInstalacionDestino
	 * @return Lista de UDocEnUiDepositoVO
	 * @throws Exception
	 */
	public List reubicarUnidadesDocumentales(String idArchivo,
			List unidadesDocumentales, String idUInstalacionDestino,
			HuecoID huecoID, FormatoHuecoVO formatoHuecoDestino, Integer motivo)
			throws DepositoException, Exception;

	public void validateHuecoDestinoParaReubicarUdoc(HuecoID huecoDestinoID,
			UDocEnUiDepositoVO primeraUDocEnUi,
			FormatoHuecoVO formatoHuecoDestino) throws DepositoException;

	public FormatoHuecoVO insertarFormato(FormatoHuecoVO formato);

	public void modificarFormato(FormatoHuecoVO formato);

	/**
	 * @param formatosSeleccionados
	 */
	public void deleteFormatos(String[] idsFormato) throws DepositoException;

	public void deleteFormato(String idFormato) throws DepositoException;

	public List getHijosElementoMayorQueOrden(ElementoVO elementoVO,
			TipoElementoVO tipoElementoVO, int numOrden);

	public List getHijosElementoMayorIgualQueOrden(ElementoVO elementoVO,
			TipoElementoVO tipoElementoVO, int numOrden);

	public ElementoVO getPrimerHijoElemento(ElementoVO elementoVO,
			TipoElementoVO tipoElementoVO);

	/**
	 * Obtiene el Dep�sito de al que pertenece un elemento asignable.
	 * 
	 * @param idElemento
	 *            IdElemento
	 * @param idTipoElemento
	 *            IdElemento
	 * @return El depo�sito al que pertenece el elemento Posicion 0:
	 *         idElementoDeposito; Posicion 1: idTipoElementoDeposito; null si
	 *         es una ubicaci�n
	 */
	public ElementoVO getDeposito(String idElemento, String idTipoElemento);

	public List getUbicacionesXIdsArchivo(String[] idsArchivo);

	/**
	 * Devuelve la lista de huecos libres u ocupados pero no bloqueados del
	 * elementoAsignable
	 * 
	 * @param String
	 *            idElementoAsignable, id del elemento asignable al que
	 *            pertenecen los huecos devueltos
	 * @return Lista de huecos
	 */
	public List getHuecosNoBloqueados(String idElementoAsignable);

	/**
	 * Obtiene los datos de ocupaci�n en el formato indicado de un elemento del
	 * fondo f�sico entre archivos
	 * 
	 * @param idElemento
	 *            Identificador de elemento del fondo f�sico
	 * @param tipoElemento
	 *            Tipo de elemento del fondo f�sico
	 * @param formato
	 *            Identificador de formato
	 * @return Datos de ocupaci�n con numero de huecos libres, ocupados y
	 *         porcentajes de ocupaci�n de huecos del formato indicado en el
	 *         elemento del fondo f�sico
	 */
	public OcupacionElementoDeposito getDatosOcupacionEntreArchivos(
			String idElemento, String tipoElemento, String formato);

	/**
	 * Obtiene todos los DetallePrestamoVO que tengan como identificador de la
	 * unidad documental alguno de la lista de idsUDocs pasada por par�metro y
	 * cuyo estado sea alguno de los pasados por par�metro
	 * 
	 * @param idsUDocs
	 *            , Lista de identificadores de unidades documentales
	 * @param estados
	 * @return una lista de {@link DetallePrestamoVO}
	 */
	public List getUDocsEnPrestamoByEstado(List idsUDocs, int[] estados);

	/**
	 * Devuelve el numero de huecos no libres de un dep�sito
	 * 
	 * @param String
	 *            id del dep�sito
	 * @return int con el n�mero de huecos no libres de un dep�sito
	 */
	public int getNumHuecosNoLibres(String idDeposito);

	/**
	 * Comprueba si una unidad de Instalaci�n contiene unidades documentales que
	 * est�n prestadas o en alguna solicitud, y por ello no se puede a�adir a
	 * una relaci�n de entrega.
	 * 
	 * @param idUinstalacion
	 * @return Lista de DetalleVO
	 * @author Lucas Alvarez
	 */
	public List getUdocsNoDisponiblesParaRelacion(String idUinstalacion);

	/**
	 * Actualiza la posiciones, identificaci�n y signatura de las unidades
	 * documentales dentro de la caja Solo modificar�n las unidades documentales
	 * cuyo orden no coincida con el de la lista.
	 * 
	 * @param listaUDocs
	 *            Lista de Unidades Documentales a Ordenar.
	 */
	public void organizarUDocsEnUInst(List listaUDocs,
			List listaUDocsEliminadas, String signaturaCaja);

	List getUnidsInstalacion(List listaIds,
			BusquedaElementosVO busquedaElementosVO);

	List getIdsUnidsInstalacion(String idUbicacion, String[] idsAmbitos,
			String like_sig, String signatura, String idFondo,
			String idFormato, int numMaxResults, CustomDateRange rangoFechas)
			throws TooManyResultsException;

	List getIdsUnidsInstalacion(String idUbicacion, String like_sig,
			String signatura, String idFondo, String idFormato,
			int numMaxResults, CustomDateRange rangoFechas)
			throws TooManyResultsException;

	public boolean isBloqueada(String idUnidadDocumental);

	public double getVolumenHuecosIrregularesXIdRelEntrega(String idRelEntrega);

	public double getLongitudHuecosIrregularesXIdUInstalacion(
			String idUInstalacion);

	public double getVolumenHuecosIrregularesXIdRelEntregaEntreArchivos(
			String idRelacionEntrega);

	public void actualizarFormato(ElementoAsignableVO infoAsignable)
			throws ActionNotAllowedException;

	/**
	 * Permite obtener los padres de un hueco
	 * 
	 * @param hueco
	 *            Hueco del que se desea obtener los padres
	 * @return Lista de padres de un hueco comenzando desde el primer nivel y
	 *         finalizando en el hueco
	 */
	public LinkedList getListaPadresHueco(HuecoVO hueco);

	/**
	 * Devuelve el hueco en el que se encuentra la unidad de instalaci�n pasada
	 * como par�metro dentro de las ubicaciones del archivo indicado
	 * 
	 * @param idUInstalacion
	 * @param idArchivo
	 * @return HuecoVO
	 */
	public HuecoVO getHuecoUInstalacionXArchivo(String idUInstalacion,
			String idArchivo);

	/**
	 * Comprueba si existe alg�n hueco para alguno de los dep�sitos
	 * pertenecientes al archivo pasado como parametro en cuyo caso no ser�a
	 * posible editar el campo tipo signaturaci�n.
	 * 
	 * @param idArchivo
	 * @return
	 */
	public boolean isEditableTipoSignaturacion(String idArchivo);

	/**
	 * Obtiene el HuecoVO perteneciente a un deposito del archivo cuya
	 * numeracion coincide con la pasada como parametro. En caso de no ser as�
	 * se devolvera NULL.
	 * 
	 * @param idArchivo
	 * @param numeracion
	 * @return
	 */
	public HuecoVO getHuecoAsociadoNumeracion(String idArchivo,
			String numeracion);

	int countHuecosAsociadoNumeracion(String idArchivo, String numeracion);

	ArchivoVO getArchivoXIdElemento(ElementoVO elemento);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deposito.model.GestorEstructuraDepositoBI#hasChildsAsignables(java.lang
	 * .String)
	 */
	public boolean hasChildsAsignables(String idTipoElemento);

	long getNsecSigNumericaHuecos(String idArchivo);

	/**
	 * Comprueba si el deposito en el nos encontramos permite editar la
	 * numeracion de sus huecos. Esto ocurre siempre que pertenecezca a un
	 * archivo cuyo tipo de signaturacion sea asociada a hueco.
	 * 
	 * @param idDeposito
	 * @return
	 */
	public boolean isEditableNumeracion(String idDeposito);

	/**
	 * Obtiene la menor numeraci�n existente para el elemento padre pasado como
	 * parametro
	 * 
	 * @param idElemAPadre
	 * @return
	 */
	public long getMenorNumeracionHueco(String idElemAPadre);

	/**
	 * Obtiene la mayor numeraci�n existente para el elemento padre pasado como
	 * parametro
	 * 
	 * @param idElemAPadre
	 * @return
	 */
	public long getMayorNumeracionHueco(String idElemAPadre);

	/**
	 * Se encarga de llevar a cabo la renumeraci�n de los huecos siempre que sea
	 * posible.
	 * 
	 * @param huecoID
	 * @param nuevaNumeracion
	 * @param renumerar
	 */
	public void renumerarHuecos(final HuecoID huecoID,
			final String nuevaNumeracion, final boolean renumerar)
			throws DepositoException;

	/**
	 * Obtiene la menor numeraci�n existente para el elemento padre pasado como
	 * parametro
	 * 
	 * @param idElemAPadre
	 * @return
	 */
	public String getMenorNumeracionOrdenHueco(String idElemAPadre);

	/**
	 * Obtiene la mayor numeraci�n existente para el elemento padre pasado como
	 * parametro
	 * 
	 * @param idElemAPadre
	 * @return
	 */
	public String getMayorNumeracionOrdenHueco(String idElemAPadre);

	int getNumOrden(ElementoNoAsignableVO elementoPadre, String tipoAsignable);

	/**
	 * Obtiene el numero total de huecos numericos que tiene un determinado
	 * elemento.
	 * 
	 * @param idElementoPadre
	 * @return
	 */
	public int getNumHuecosNumericos(String idElementoPadre);

	/**
	 * Comprueba si es posible editar el archivo al que pertenece una ubicacion.
	 * 
	 * @param idArchivo
	 * @return
	 */
	public boolean isEditableArchivoUbicacion(String idUbicacion);

	/**
	 * Busca el Hist�rico de Unidades Documentales en Dep�sito.
	 * 
	 * @param busquedaHistUInstDepositoVO
	 *            Par�metros de la B�squeda
	 * @return Lista de {@link HistUInstDepositoVO}
	 */
	public List buscarHistoricoUnidadesInstalacionDeposito(
			BusquedaHistUInstDepositoVO busquedaHistUInstDepositoVO);

	/**
	 * Obtiene el Historico de Unidad de Instalaci�n en Dep�sito
	 * 
	 * @param id
	 *            Identificador del Hist�rico
	 * @return {@link HistoricoUDOCVO}
	 */
	public HistUInstDepositoVO obtenerHistoricoUnidadInstalacionDeposito(
			String id);

	public void actualizarDescripcion(UDocEnUiDepositoVO udocEnUi);

	public List getPartesUdocEnUIDeposito(String idUnidadDocumental);

	public void eliminarCajaVacia(String idArchivo, String idUIOrigen,
			Integer motivo) throws Exception;

	/**
	 * Obtiene la lista de huecos del elemento NO asignable a partir de las
	 * signaturas indicadas y el formato
	 * 
	 * @param idElementoNoAsignable
	 *            Identificador del elemento No Asignable
	 * @param idUbicacion
	 *            Identificador de la ubicaci�n
	 * @param idFormato
	 *            Identificador del formato de los huecos
	 * @param options
	 *            Signaturas indicadas para la b�squeda
	 * @return
	 */
	public List getHuecosPorSignaturas(String idElementoNoAsignable,
			String idUbicacion, String idFormato, IntervalOptions options)
			throws IeciTdException, TooManyResultsException;

	/**
	 * Obtiene la lista de unidades de instalaci�n para el informe de Consulta
	 * de Unidades de Instalaci�n por A�o y Serie.
	 * 
	 * @param busquedaUIAnioSerieVO
	 *            Par�metros de la B�squeda
	 * @return Lista de {@link UIAnioSerieVO}
	 * @throws IeciTdException
	 */
	public List getUnidadesInstalacionPorAnioYSerie(
			BusquedaUIAnioSerieVO busquedaUIAnioSerieVO)
			throws IeciTdException, TooManyResultsException;

	/**
	 * Obtiene el path padre de un elemento No Asignable de deposito
	 * 
	 * @param idElemNoAsig
	 *            Identificador del elemento No Asignable
	 * @return String con el path
	 */
	public String getPathPadre(String idElemNoAsig);

	/**
	 * Guarda los datos del elemento no asignable de deposito
	 * 
	 * @param elementoNoAsignable
	 * @throws ActionNotAllowedException
	 */
	public void guardarElementoNoAsignable(
			ElementoNoAsignableVO elementoNoAsignable)
			throws ActionNotAllowedException;

	/**
	 * Obtiene los tipos de elementos
	 * 
	 * @param idTipoElementoPadre
	 * @param exclude
	 *            Identificadores de los tipos a excluir
	 * @return
	 */
	public List getTiposElemento(String idTipoElementoPadre, String[] exclude);

	/**
	 * Actualiza los tipos de Elementos
	 * 
	 * @param tipoElementoVO
	 * @throws TipoElementoDepositoException
	 */
	public void actualizarTipoElemento(TipoElementoVO tipoElementoVO)
			throws TipoElementoDepositoException;

	/**
	 * Elimina los tipos de Elementos
	 * 
	 * @param idTipoElemento
	 *            Identificador del Tipo de Elemento
	 * @param asignable
	 *            Indicador de si el tipo de elemento es asignable o no
	 */
	public void eliminarTipoElemento(String idTipoElemento)
			throws TipoElementoDepositoException;

	/**
	 * Inserta el tipo de Elemento
	 * 
	 * @param tipoElementoVO
	 */
	public void insertarTipoElemento(TipoElementoVO tipoElementoVO)
			throws TipoElementoDepositoException;

	/**
	 * Comprueba si el tipo de Elemento de dep�sito est� siendo utilizado
	 * 
	 * @param idTipoElemento
	 *            Identificador del tipo de Elemento
	 * @param asignable
	 *            Indicador de si el tipo es asignable o no.
	 * @return
	 */
	public boolean isTipoElementoReferenciado(String idTipoElemento);

	/**
	 * Comprueba si tiene hijos.
	 * 
	 * @param idTipoElemento
	 * @return
	 */
	public boolean hasChilds(String idTipoElemento);

}