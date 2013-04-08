package transferencias.db;

import gcontrol.vos.UsuarioVO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import transferencias.TipoTransferencia;
import transferencias.vos.BusquedaRelacionesVO;
import transferencias.vos.RelacionEntregaVO;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;
import common.pagination.PageInfo;

/**
 * M�todos de acceso a datos referentes a relaciones de entrega. Entidad:
 * <b>ASGTRENTREGA</b>
 */
public interface IRelacionEntregaDBEntity extends IDBEntity {
	/**
	 * Comprueba si existen relaciones creadas para una prevision de
	 * transferencia
	 *
	 * @param idPrevision
	 *            Identificador de la prevision
	 * @return true si se han creado relaciones de entrega sobre la prevision,
	 *         false en caso de no existir ninguna relacion para la prevision
	 */
	public boolean previsionTieneRelaciones(String idPrevision);

	/**
	 * Comprueba si se han creado relaciones de entrega con el formato indicado
	 * sobre una una linea de detalle de una previsi�n
	 *
	 * @param idDetallePrevision
	 *            Identificador de l�nea de detalle de previsi�n
	 * @param tipoDocumental
	 *            Tipo documental. Puede ser nulo.
	 * @return true si se han creado relaciones de entrega sobre la l�nea de
	 *         detalle y false en caso contrario
	 */
	public boolean detallePrevisionTieneRelaciones(String idDetallePrevision,
			String tipoDocumental);

	// /**
	// * Recupera de la base de datos las relaciones de entrega que tienen un
	// * determinado formato de unidad de instalacion y que se encuentran en
	// * alguno de los estados especificados
	// *
	// * @param estados
	// * Lista de estados de relacion de entrega. Puede ser nulo
	// * @param Identificador
	// * de formato de unidad de instalacion. Puede ser nulo
	// * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	// */
	// public Collection getRelacionXFormato(String idUbicacion, String
	// idFormato, int[] estados);

	/**
	 * Recupera las relaciones de entrega destinadas a un fondo y que se
	 * encuentren en alguno de los estados que se indican
	 *
	 * @param idFondo
	 *            Identificador de fondo en el cuadro de clasificaci�n de fondos
	 *            documentales. Puede ser nulo
	 * @param estados
	 *            Conjunto de estados de relaci�n de entrega. Puede ser nulo
	 * @return Lista de relaciones que verifican las condiciones
	 *         {@link RelacionEntregaVO}
	 */
	public Collection getRelacionXFondo(String idFondo, int[] estados);

	public int getCountRelacionesAReservar(String[] archivosCustodia);

	public Collection getRelacionesAReservar(String[] archivosCustodia);

	public int getCountRelacionesAUbicar(String[] archivosCustodia);

	public Collection getRelacionesAUbicar(String[] archivosCustodia);

	/**
	 * Recupera las relaciones enviadas por alguno de los �rganos indicados
	 *
	 * @param idOrgano
	 *            Conjundo de identificadores de �rgano remitente
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public Collection getRelacionesXOrganoRemitente(String[] idOrganismos);

	/**
	 * Recupera de la base de datos las relaciones que tienen como gestor en
	 * organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param excluirIngresosDirectos
	 *            Indicador de exclusi�n de los ingresos directos
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXGestorEnOrganoRemitente(String idUser,
			int[] estados, String ano, boolean excluirIngresosDirectos);

	/**
	 * Recupera de la base de datos el numero relaciones que tienen como gestor
	 * en organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param excluirIngresosDirectos
	 *            Indicador de exclusi�n de los ingresos directos
	 * @return Numero de relaciones de entrega
	 */
	public int getCountRelacionesXGestorEnOrganoRemitente(String idUser,
			int[] estados, String ano, boolean excluirIngresosDirectos);

	/**
	 * Recupera de la base de datos el numero relaciones que tienen como gestor
	 * en organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param excluirConErroresYCorreccionEnArchivo
	 *            Indicador de si se excluyen las que est�n con errores y est�n
	 *            marcadas para correci�n en archivo.
	 * @param excluirIngresosDirectos
	 *            Indicador de exclusi�n de los ingresos directos
	 * @return Numero de relaciones de entrega
	 */
	public int getCountRelacionesXGestorEnOrganoRemitente(String idUser,
			int[] estados, String ano,
			boolean excluirConErroresYCorreccionEnArchivo,
			boolean excluirIngresosDirectos);

	/**
	 * Recupera de la base de datos las relaciones que tienen como gestor en
	 * organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param excluirConErroresYCorreccionEnArchivo
	 *            Indicador de si se excluyen las que est�n con errores y est�n
	 *            marcadas para correci�n en archivo.
	 * @param excluirIngresosDirectos
	 *            Indicador de exclusi�n de los ingresos directos
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXGestorEnOrganoRemitente(String idUser,
			int[] estados, String ano,
			boolean excluirConErroresYCorreccionEnArchivo,
			boolean excluirIngresosDirectos);

	/**
	 * Recupera de la base de datos el n�mero de relaciones que tienen como
	 * gestor en organo remitente el indicado, se encuentran en alguno de los
	 * estados solicitados, pertenecen al a�o indicado y son de determinados
	 * tipos
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param tipos
	 *            Tipos de transferencia
	 * @return N�mero de relaciones de entrega
	 */
	public int getCountRelacionesXGestorYTipoEnOrganoRemitente(String idUser,
			int[] estados, String ano, int[] tipos);

	/**
	 * Recupera de la base de datos las relaciones que tienen como gestor en
	 * organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados, pertenecen al a�o indicado y son de determinados tipos
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param tipos
	 *            Tipos de transferencia
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXGestorYTipoEnOrganoRemitente(String idUser,
			int[] estados, String ano, int[] tipos);

	/**
	 * Recupera de la base de datos las relaciones que tienen como gestor en
	 * organo remitente el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param tipo
	 *            Tipo de la relaci�n
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @param idArchivo
	 *            Identificador del archivo
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXGestorYTipoYArchivoEnOrganoRemitente(
			String idUser, int[] estados, String ano, int tipo, String idArchivo);

	/**
	 * Recupera de la base de datos el n�mero de relaciones que tienen como
	 * gestor en archivo receptor el indicado, se encuentran en alguno de los
	 * estados solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @return N�mero de relaciones de entrega
	 */
	public int getCountRelacionesXGestorEnArchivo(String idUser, int[] estados,
			String ano);

	/**
	 * Recupera de la base de datos las relaciones que tienen como gestor en
	 * archivo receptor el indicado, se encuentran en alguno de los estados
	 * solicitados y pertenecen al a�o indicado
	 *
	 * @param idUser
	 *            Identificador de usuario
	 * @param estados
	 *            Conjunto de estados de relacion de entrega. Puede ser nulo
	 * @param ano
	 *            A�o. Puede ser nulo
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXGestorEnArchivo(String idUser, int[] estados,
			String ano);

	public Collection getRelacionesXIds(String[] ids);

	/**
	 * Recupera el n�mero de relaciones destinadas a un conjundo de archivos,
	 * que se encuentren en los estados indicados y que correspondan al a�o que
	 * se especifica
	 *
	 * @param idArchReceptor
	 *            Lista de identificadores de archivos
	 * @param estados
	 *            Lista de estados de relacion de entrega
	 * @param ano
	 *            A�o
	 * @return N�mero de relaciones de entrega
	 */
	public int getCountRelacionesXArchivoReceptor(String[] idArchReceptor,
			int[] estados, String ano);

	/**
	 * Recupera la relaciones destinadas a un conjundo de archivos, que se
	 * encuentren en los estados indicados y que correspondan al a�o que se
	 * especifica
	 *
	 * @param idArchReceptor
	 *            Lista de identificadores de archivos
	 * @param estados
	 *            Lista de estados de relacion de entrega
	 * @param ano
	 *            A�o
	 * @return Lista de relaciones de entrega {@link RelacionEntregaVO}
	 */
	public List getRelacionesXArchivoReceptor(String[] idArchReceptor,
			int[] estados, String ano);

	public List getRelacionesXPrevision(String idPrevision, String idDetalle);

	List getRelacionesXPrevisionYEstado(String idPrevision, String idDetalle,
			int[] estados);

	/**
	 * Obtiene las relaciones de entrega asociadas a un fondo.
	 *
	 * @param idFondo
	 *            Identificador del fondo.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Relaciones de entrega.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getRelacionesXFondo(String idFondo, PageInfo pageInfo)
			throws TooManyResultsException;

	/**
	 * Obtiene las relaciones de entrega asociadas a un clasificador de series.
	 *
	 * @param idClfSeries
	 *            Identificador del clasificador de series.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Relaciones de entrega.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getRelacionesXClasificadorSeries(String idClfSeries,
			PageInfo pageInfo) throws TooManyResultsException;

	/**
	 * Obtiene las relaciones de entrega asociadas a una serie.
	 *
	 * @param idSerie
	 *            Identificador de la serie.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Relaciones de entrega.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getRelacionesXSerie(String idSerie, PageInfo pageInfo)
			throws TooManyResultsException;

	/**
	 * Obtiene las relaciones de entrega asociadas a una unidad documental.
	 *
	 * @param idUdoc
	 *            Identificador de la unidad documental.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Relaciones de entrega.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getRelacionesXUdoc(String idUdoc, PageInfo pageInfo)
			throws TooManyResultsException;

	public RelacionEntregaVO getRelacionXId(String idRelacion);

	public void insertRelacion(final RelacionEntregaVO relacion);

	public void updateRelacionEntrega(RelacionEntregaVO relacionVO);

	public void updateUsrGestorArchivo(String[] relaciones, String idNewUser);

	public void updateUbicacion(String idRelacion, boolean uiEndeposito,
			String idDeposito);

	/**
	 * Actualiza la ubicaci�n del fondo f�sico en la que ser� depositada la
	 * documentaci�n incluida en la relaci�n entrega al concluir el proceso de
	 * transferencia.
	 *
	 * @param idRelacion
	 *            Identificador de relaci�n de entrega
	 * @param idUbicacion
	 *            Identificador de ubicaci�n del fondo f�sico gestionado por el
	 *            sistema
	 */
	public void updateUbicacion(String idRelacion, String idUbicacion);

	public void updateUsrGestorRem(String[] idsRelaciones, String idNewUserGRem);

	// public void
	// updateEstado_fechaEstado_FechaRecepcion_UsrGestorArch_regEntrada_idDeposito_idENADReserva_estadoReserva(
	// String[] idsRelaciones, int estado, Date fechaEstado, Date
	// fechaRecepcion,
	// String idUsrGestorArchivo, String regEntrada, String idDeposito,
	// String idNoAsignableReserva, int estadoReservaDeposito);

	public void updateEstado(String idRelacion, int estado, Date fechaEstado,
			Boolean devolucionCajas);

	public void updateEstado(String idRelacion, int estado, Date fechaEstado,
			Boolean devolucionCajas, Boolean sindocsfisicos);

	public void updateIdDescrorgproductor(String idRelacion,
			String idDescrorgproductor);

	public void deleteRelacion(final String idRelacion);

	/**
	 * Actualiza la reserva de espacio para una relaci�n de entrega
	 *
	 * @param idRelacionEntrega
	 *            Identificador de relaci�n de entrega
	 * @param estadoReserva
	 *            Estado de la reserva de espacio para la relaci�n
	 * @param depositoReserva
	 *            Identificador del elemento del fondo f�sico en el que se
	 *            efectua la reserva
	 */
	public int updateEstadoReserva(String idRelacionEntrega, int estadoReserva,
			String depositoReserva, String idTipoDepositoReserva);

	/**
	 * Recupera las relaciones de entrega destinadas a ser ubicadas en una
	 * ubicacion
	 *
	 * @param idUbicacion
	 *            Identificador de ubicaci�n
	 * @param estadosRelacion
	 *            Cojunto de estados de relacion. Puede ser nulo.
	 * @param formato
	 *            Identificador de formato. Puede ser nulo
	 * @param uisEnDeposito
	 *            <b>true </b> para obtener relaciones cuyas unidades de
	 *            instalaci�n se encuentren ya ubicadas en el deposito y
	 *            <b>false </b> para obtener relaciones no ubicadas
	 * @return Relaciones de entrga {@link RelacionEntregaVO}
	 */
	public List getRelacionXUbicacion(String idUbicacion,
			int[] estadosRelacion, String formato, boolean uisEnDeposito);

	/**
	 * Busca las relaciones que cumplan unos criterios concretos.
	 *
	 * @param vo
	 *            Criterios de la b�squeda.
	 * @return Lista de relaciones.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public List getRelaciones(BusquedaRelacionesVO vo)
			throws TooManyResultsException;

	/**
	 * Obtiene la lista de gestores en archivo con relaciones de entrega.
	 *
	 * @return Lista de Gestores ({@link UsuarioVO}).
	 */
	public List getGestoresArchivoConRelaciones();

	/**
	 * Obtiene la lista de gestores en �rgano remitente con relaciones de
	 * entrega.
	 *
	 * @param idOrgano
	 *            Identificador del �rgano del gestor.
	 * @param tiposTransferencia
	 *            Tipo de transferencia ({@link TipoTransferencia}).
	 * @return Lista de Gestores ({@link UsuarioVO}).
	 */
	public List getGestoresOrgRemitenteConRelaciones(String idOrgano,
			int[] tiposTransferencia);

	/**
	 * Obtiene la lista de gestores en �rgano remitente con relaciones de
	 * entrega.
	 *
	 * @param idOrgano
	 *            Identificador del �rgano del gestor.
	 * @param tiposTransferencia
	 *            Tipo de transferencia ({@link TipoTransferencia}).
	 * @param idsExcluir
	 *            Ids de gestores a excluir
	 * @return Lista de Gestores ({@link UsuarioVO}).
	 */
	public List getGestoresOrgRemitenteConRelaciones(String idOrgano,
			int[] tiposTransferencia, String[] idsExcluir);

	/**
	 *
	 * @param idFormato
	 * @return El numero de relaciones existentes con el formato pasado por
	 *         parametro
	 */
	public int countRelacionesXFormato(String idFormato);

	/**
	 *
	 * @param idFormato
	 * @return El numero de relaciones No Validadas existentes con el formato
	 *         pasado por parametro
	 */
	public int countRelacionesNoValidadasXFormato(String idFormato,
			int[] estados);

	/**
	 *
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param idArchivoEmisor
	 * @param idPadre
	 * @param idFormato
	 * @param idCampoFechaExtremaFinal
	 * @return
	 */
	public List getUInstXArchivoYSerieConFechas(Date fechaInicial,
			Date fechaFinal, String idArchivoEmisor, String idPadre,
			String idFormato, String idCampoFechaExtremaFinal);

	/**
	 *
	 * @param idsUnidadesDocumentales
	 * @param idUnidadInstalacion
	 * @return Lista de UDocEnUiDepositoVO
	 */
	public List getUInstUdocsXUdocsCompletasYNoCompletas(
			List idsUnidadesDocumentales, String idUnidadInstalacion);

	/**
	 * Obtiene las Unidades Documentales Especificadas en los Ids.
	 *
	 * @param idsUnidadesDocumentales
	 *            Lista de Ids de Unidades Documentales
	 * @return Lista de UDocEnUiDepositoVO
	 */
	public List getUdocsCompletasYNoCompletas(List idsUnidadesDocumentales);

	/**
	 * Obtiene las unidades documentales por comprendidades cuyo rango de fechas
	 * finales est�n comprendidas entre los rangos y que pertenecen un archivo y
	 * serie
	 *
	 * @param fechaFinDesde
	 *            Fecha Final Desde
	 * @param fechaFinHasta
	 *            Fecha Final Hasta
	 * @param idArchivoEmisor
	 *            Identificador del Archivo Emisor
	 * @param idSerie
	 *            Identificador de la serie
	 * @return Lista de ElementoCuadroClasificacion
	 */
	public List getUDocsXArchivoYSerieYFormatoConFechas(Date fechaFinDesde,
			Date fechaFinHasta, String idArchivoEmisor, String idSerie,
			String idFormato, String idNivelDocumental);

	/**
	 * Obtiene las unidades documentales por comprendidades cuyo rango de fechas
	 * finales est�n comprendidas entre los rangos y que pertenecen un archivo y
	 * serie
	 *
	 * @param fechaFinDesde
	 *            Fecha Final Desde
	 * @param fechaFinHasta
	 *            Fecha Final Hasta
	 * @param idArchivoEmisor
	 *            Identificador del Archivo Emisor
	 * @param idSerie
	 *            Identificador de la serie
	 * @return Lista de ElementoCuadroClasificacion
	 */
	public List getUDocsElectronicasXArchivoYSerieConFechas(
			Date fechaFinalDesde, Date fechaFinalHasta, String idArchivoEmisor,
			String idSerie);

	/**
	 * Cuenta las unidades documentales por comprendidades cuyo rango de fechas
	 * finales est�n comprendidas entre los rangos y que pertenecen un archivo y
	 * serie
	 *
	 * @param fechaFinDesde
	 *            Fecha Final Desde
	 * @param fechaFinHasta
	 *            Fecha Final Hasta
	 * @param idArchivoEmisor
	 *            Identificador del Archivo Emisor
	 * @param idSerie
	 *            Identificador de la serie
	 * @return Lista de ElementoCuadroClasificacion
	 */
	public int getCountUDocsElectronicasXArchivoYSerieConFechas(
			Date fechaFinalDesde, Date fechaFinalHasta, String idArchivoEmisor,
			String idSerie);

	/**
	 * Actualiza el valor del indicador de correcci�n en archivo.
	 *
	 * @param correccionenarchivo
	 *            Valor del campo correcionenarchivo
	 */
	public void updateIndicadorCorreccionEnArchivo(String idRelacion,
			String correccionenarchivo);

	/**
	 * Obtiene las Unidades Electr�nicas que pertenecen a una Relaci�n de
	 * Entrega entre Archivos.
	 *
	 * @param idRelacion
	 *            Identificador de la Relaci�n de Entrega
	 * @return Lista de {@link UdocElectronicaVO}
	 */
	public List getUDocsElectronicasByIdRelacionEntreArhivos(String idRelacion);

	/**
	 * Obtiene las relaciones de entrega asociadas a una divisi�n de una
	 * fracci�n de serie.
	 *
	 * @param idFSEnREntrega
	 *            Identificador de la fracci�n de serie en la relaci�n de
	 *            entrega de la que proviene.
	 * @param pageInfo
	 *            Informaci�n de la paginaci�n.
	 * @return Relaciones de entrega.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados excede el m�ximo.
	 */
	public List getRelacionesXIdFSEnREntrega(String idFSEnREntrega,
			PageInfo pageInfo) throws TooManyResultsException;

	/**
	 * Unifica el campo <b>ASGTRENTREGA.IDDESCRORGPRODUCTOR</b> con el
	 * idDescriptor de todos los idsAReemplazar
	 *
	 * @param idDescriptor
	 *            Identificador del descriptor
	 * @param idsAReemplazar
	 *            Identificadores de los descriptores a reemplazar
	 */
	public void unificarDescriptor(String idDescriptor, String[] idsAReemplazar);

	/**
	 * Obtiene el n�mero de relaciones que tiene el usuario
	 *
	 * @param idUser
	 *            Identificador del usuario
	 * @return N�mero de relaciones
	 */
	public int getCountRelacionesByIdUser(String idUser);

	/**
	 * Actualiza los valores del reencajado.
	 *
	 * @param conReencajado
	 *            Indicador del Reencajado
	 * @param idFormatoRe
	 *            Identificador del Nuevo Formato de Reencajado.
	 */
	public void updateReencajado(String idRelacion, String conReencajado,
			String idFormatoRe);

	/**
	 * Obtiene la relaci�n de entrega por el registro de entrada.
	 *
	 * @param regEntrada
	 *            Cadena que contiene el registro
	 * @return
	 */
	public List getRelacionesByRegEntrada(String regEntrada);

	/**
	 * Obtiene la relaci�n de entrega
	 * @param relacionEntregaVO
	 * @return
	 */
	public RelacionEntregaVO getRelacionVO(RelacionEntregaVO relacionEntregaVO);
}