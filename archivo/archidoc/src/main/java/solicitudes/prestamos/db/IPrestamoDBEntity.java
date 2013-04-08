package solicitudes.prestamos.db;

import gcontrol.vos.UsuarioVO;

import java.util.Collection;
import java.util.List;

import solicitudes.prestamos.vos.BusquedaVO;
import solicitudes.prestamos.vos.PrestamoVO;

import common.db.IDBEntity;
import common.exceptions.TooManyResultsException;

/**
 * Interface con los metodos de bd para prestamos. <br>
 * Entidad: <b>ASGPPRESTAMO</b>
 */
public interface IPrestamoDBEntity extends IDBEntity {
	/**
	 * Inserta un prestamo en la base de datos creado por el usuario del
	 * servicio.
	 * 
	 * @param userVO
	 *            Usuario que est� creando el pr�stamo.
	 * @param prestamoVO
	 *            Prestamo a insertar en la base de datos.
	 */
	public abstract void insertPrestamo(final PrestamoVO prestamo);

	/**
	 * Actualiza un prestamo.
	 * 
	 * @param prestamoVO
	 *            Prestamo que deseamos actualizar
	 */
	public abstract void updatePrestamo(final PrestamoVO prestamo);

	/**
	 * Obtiene un pr�stamo a partir de su identificador en la base de datos.
	 * 
	 * @param codprestamo
	 *            Identificador del pr�stamo en la base de datos
	 * @return Objeto {@link PrestamoVO} con los detalles del pr�stamo.
	 */
	public abstract PrestamoVO getPrestamo(String codigoPrestamo);

	/**
	 * Obtiene un listado de prestamos a partir de sus identificadores.
	 * 
	 * @param codigos
	 *            Listado de los identificadores de los prestamos que deseamo
	 *            recuperar
	 * @return Listado de los prestamos
	 */
	public abstract Collection getPrestamos(String[] codigos);

	/**
	 * Obtiene el n�mero de prestamos que se encuentran en alguno de los estados
	 * que se indican y que han sido elaborador por un usuario determinado.
	 * 
	 * @param idUsuario
	 *            identificador del usuario del que deseamos obtener los
	 *            prestamos
	 * @param estados
	 *            Conjunto de posibles estados de pr�stamo. Puede ser nulo
	 * @return N�mero de los prestamos del usuario en los que figura como
	 *         usuario gestor
	 */
	public int getCountPrestamosXUsuarioSolicitante(String idUsuario,
			int[] estados);

	/**
	 * Obtiene los prestamos que se encuentran en alguno de los estados que se
	 * indican y que han sido elaborador por un usuario determinado.
	 * 
	 * @param idUsuario
	 *            identificador del usuario del que deseamos obtener los
	 *            prestamos
	 * @param estados
	 *            Conjunto de posibles estados de pr�stamo. Puede ser nulo
	 * @return Un listado de los prestamos del usuario en los que figura como
	 *         usuario gestor
	 */
	public List getPrestamosXUsuarioSolicitante(String idUsuario, int[] estados);

	/**
	 * Obtiene el n�mero de prestamos para un usuario determinado.
	 * 
	 * @param idUsuario
	 *            identificador del usuario del que deseamos obtener los
	 *            prestamos
	 * @param estados
	 *            Estados de los que se buscan pr�stamos
	 * @return N�mero de prestamos del usuario
	 */
	public int getCountPrestamosXUsuarioSolicitanteBuscar(String idUsuario,
			String[] estados);

	/**
	 * Obtiene el n�mero de prestamos para un usuario determinado.
	 * 
	 * @param idUsuario
	 *            identificador del usuario del que deseamos obtener los
	 *            prestamos
	 * @param estados
	 *            Estados de los que se buscan pr�stamos
	 * @param idsArchivo
	 *            Identificadores de los archivos
	 * @return N�mero de prestamos del usuario
	 */
	public int getCountPrestamosXUsuarioSolicitanteBuscar(String idUsuario,
			String[] estados, String[] idsArchivo);

	/**
	 * Obtiene los prestamos para un usuario determinado.Utilizado para las
	 * busquedas
	 * 
	 * @param idUsuario
	 *            identificador del usuario del que deseamos obtener los
	 *            prestamos
	 * @param busqueda
	 *            Objeto con las restricciones de una busqueda
	 * @return Un listado de los prestamos del usuario
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public abstract List getPrestamosXUsuarioSolicitanteBuscar(
			String idUsuario, BusquedaVO busqueda)
			throws TooManyResultsException;

	/**
	 * Indica si un usuario tiene pr�stamos en los estados determinados.
	 * 
	 * @param idUsuario
	 *            Identificador de usuario.
	 * @param estados
	 *            Estados de los pr�stamos.
	 * @return true si el usuario tiene pr�stamos en curso.
	 */
	public boolean hasPrestamos(String idUsuario, String[] estados);

	/**
	 * Devuelve el n�mero de pr�stamos existentes para los estados indicados.
	 * 
	 * @param estados
	 *            Listado de los estados de los que deseamos obtener sus
	 *            pr�stamos.
	 * @return N�mero de pr�stamos cuyo estado se encuentra en alguno de los
	 *         indicados.
	 */
	public int getCountPrestamosXEstados(String[] estados, String[] idsArchivos);

	/**
	 * Muestra todos los pr�stamos existentes para los estados indicados.
	 * 
	 * @param estados
	 *            Listado de los estados de los que deseamos mostrar sus
	 *            pr�stamos.
	 * @param busqueda
	 *            Objeto con las restricciones de una busqueda
	 * @return Listado de los pr�stamos cuyo estado se encuentra en alguno de
	 *         los indicados.
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public List getPrestamosXEstados(String[] estados, BusquedaVO busqueda,
			String[] idsArchivo) throws TooManyResultsException;

	/**
	 * Obtiene el n�mero de prestamos de un usuario gestor dado por su
	 * identificador, adem�s de los de su organismo y de organismos
	 * dependientes.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario gestor del que deseamos obtener sus
	 *            prestamos.
	 * @param descendientes
	 *            Lista de identificadores de los organismo
	 *            dependientes(incluido el suyo propio)
	 * @return N�mero de prestamos para el usuario
	 */
	public int getCountPrestamosXUsuarioGestor(String idUsuarioSolicitante,
			String[] descendientes, String[] estados);

	public int getCountPrestamosXUsuarioGestor(String idUsuarioSolicitante,
			String[] descendientes, String[] estados, String[] idsArchivo);

	/**
	 * Obtiene los prestamos de un usuario gestor dado por su identificador,
	 * adem�s de los de su organismo y de organismos dependientes.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario gestor del que deseamos obtener sus
	 *            prestamos.
	 * @param descendientes
	 *            Lista de identificadores de los organismo
	 *            dependientes(incluido el suyo propio)
	 * @param busqueda
	 *            Objeto con las restricciones de una busqueda
	 * @return Listado de prestamos para el usuario
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public abstract List getPrestamosXUsuarioGestor(
			String idUsuarioSolicitante, String[] descendientes,
			BusquedaVO busqueda) throws TooManyResultsException;

	/**
	 * Obtiene un listado de los usuarios solicitantes de prestamo cuyo estado
	 * es NO ABIERTO y, en caso que este presente,cuyo organo sea alg�n �rgano
	 * de la lista(los que dependen del �rgano del usuario conectado)
	 * 
	 * @param organos
	 *            Lista de �rganos en los cuales debe estar presente el usuario
	 *            solicitante del prestamo
	 * @return Listado de los usuarios
	 */
	public abstract Collection getUsuariosBusquedaPrestamos(List organos);

	/**
	 * Realiza el env�o de los detalles de un prestamo
	 * 
	 * @param idPrestamo
	 *            Identificador del prestamo.
	 * @param tipoUsuario
	 *            Tipo del usuario que va realiza el envio
	 */
	public abstract void enviarPrestamo(PrestamoVO prestamoVO,
			String tipoUsuario);

	/**
	 * Realiza el borrado de un prestamo dado por su identificador.
	 * 
	 * @param idPrestamo
	 *            Identificador del prestamo.
	 */
	public abstract void deletePrestamo(String idPrestamo);

	/**
	 * Obtiene el n�mero de detalles que est�n asociados a un determinado
	 * pr�stamo.
	 * 
	 * @param idPrestamo
	 *            Identificador del prestamo del que deseamos conocer su numero
	 *            de detalles asociados.
	 * @return Numero de detalles de prestamo asociados al prestamo.
	 */
	public abstract int numeroDetallesPrestamo(final String idPrestamo);

	/**
	 * Obtiene un listado de los prestamos que tiene abiertos por el nombre de
	 * usuario solicitante.
	 * 
	 * @param nombreUsuarioSolicitante
	 *            Nombre del usuario solicitante.
	 * @return Listado de los prestamos abierto por el usuario
	 */
	public abstract Collection getPrestamosXUsuarioSolicitanteAbiertos(
			String nombreUsuario);

	/**
	 * Obtiene un listado de los prestamos que tiene abiertos por el id de
	 * usuario solicitante.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario solicitante.
	 * @return Listado de los prestamos abierto por el usuario
	 */
	public abstract Collection getPrestamosXIdUsuarioSolicitanteAbiertos(
			String idUsuario);

	/**
	 * Obtiene un listado de los prestamos que estan en elaboracion por el id de
	 * usuario solicitante o usuario gestor
	 * 
	 * @param idUsuario
	 *            Identificador del usuario solicitante.
	 * @return Listado de los prestamos abierto por el usuario
	 */
	public abstract Collection getPrestamosEnElaboracionXIdUsuario(
			String idUsuario);

	/**
	 * Obtiene un listado de los prestamos que tiene abiertos como gestor un
	 * determinado usuario.
	 * 
	 * @param idUsuario
	 *            Identificador en la base de datos del usuario.
	 * @return Listado de los prestamos abierto por el usuario
	 */
	public abstract Collection getPrestamosXUsuarioGestorAbiertos(
			String idUsuario);

	/**
	 * Obtiene un listado de los prestamos que pertenecen a un determinado
	 * organo
	 * 
	 * @param idOrgano
	 *            Identificador del organo del que deseamos obtener los
	 *            prestamos.
	 * @return Listado de los prestamos
	 */
	public abstract Collection getPrestamosXOrganoSolicitante(String idOrgano);

	/**
	 * Obtiene un listado de los prestamos externos (que no tienen un
	 * identificador de organo solicitante establecido)
	 * 
	 * @return Listado de los prestamos
	 */
	public abstract Collection getPrestamosExternos();

	/**
	 * Obtiene la lista de gestores con pr�stamos.
	 * 
	 * @param idOrgano
	 *            Identificador del �rgano del gesto.
	 * @return Lista de Gestores ({@link UsuarioVO}).
	 */
	public List getGestoresConPrestamos(String idOrgano);

	/**
	 * Obtiene la lista de pr�stamos que cumplan los criterios especificados.
	 * 
	 * @param vo
	 *            Criterios de b�squeda.
	 * @return Lista de pr�stamos ({@link PrestamoVO}).
	 * @throws TooManyResultsException
	 *             si el n�mero de resultados es excesivo.
	 */
	public List getPrestamos(BusquedaVO vo, String[] idsArchivo)
			throws TooManyResultsException;

	/**
	 * Actualiza las observacioens de la Consulta.
	 */
	public void updateObservaciones(String id, String observaciones);

	public int getCountPrestamosByIdMotivo(String idMotivo);

	/**
	 * Obtiene los pr�stamos filtrados por idArchivo, idUsuarioGestor y estados
	 * 
	 * @param idArchivo
	 * @param idUsuarioGestor
	 * @param estados
	 * @return Lista de PrestamoVO
	 */
	public abstract List getPrestamosByIdarchivoAndIdUsuarioGestor(
			String idArchivo, String idUsuarioGestor, String[] estados);

	/**
	 * Cuenta los pr�stamos en elaboracion para usuario gestor o usuario
	 * solicitante.
	 * 
	 * @param idUsuario
	 * @return
	 */
	public abstract int getCountPrestamosEnElaboracionXIdUsuario(
			String idUsuario);
}