package descripcion.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.db.IDBEntity;

import descripcion.vos.CampoFechaVO;

/**
 * Interfaz de comportamiento para la entidad de acceso a los campos de tipo
 * fecha. <br>
 * Entidad: <b>ADVCFECHACF</b> <br>
 * Entidad: <b>ADVCFECHAUDOCRE</b>
 */
public interface IFechaDBEntity extends IDBEntity {
	/**
	 * Obtiene la lista de valores de tipo fecha de la ficha.
	 * 
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @return Lista de valores.
	 */
	public abstract List getValues(String idElementoCF, int tipoElemento);

	/**
	 * Obtiene la lista de valores de tipo fecha de la ficha.
	 * 
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param idCampo
	 *            Identificador del campo.
	 * @return Lista de valores.
	 */
	public List getValues(String idElementoCF, String idCampo, int tipoElemento);

	/**
	 * Obtiene la lista de valores de tipo fecha de la ficha.
	 * 
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param listaCamposIgnorar
	 * @return Lista de valores.
	 */
	public List getValues(String idElementoCF, int tipoElemento,
			ArrayList listaCamposIgnorar);

	/**
	 * Obtiene el valor de la ficha.
	 * 
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param idCampo
	 *            Identificador del campo.
	 * @param orden
	 *            Orden del valor.
	 * @return Valor de la ficha.
	 */
	public CampoFechaVO getValue(String idElementoCF, String idCampo,
			int orden, int tipoElemento);

	/**
	 * Inserta un valor de tipo fecha.
	 * 
	 * @param value
	 *            Valor de tipo fecha a insertar.
	 * @return Valor de tipo fecha insertado.
	 */
	public abstract CampoFechaVO insertValue(final CampoFechaVO value);

	/**
	 * Modifica un valor de tipo fecha.
	 * 
	 * @param value
	 *            Informaci�n del campo de tipo fecha.
	 */
	public abstract void updateValue(final CampoFechaVO value);

	/**
	 * Elimina un valor de tipo fecha.
	 * 
	 * @param idElementoCF
	 *            Identificador del elemento del cuadro de clasificaci�n.
	 * @param idCampo
	 *            Identificador del campo.
	 * @param orden
	 *            Orden del valor.
	 */
	public abstract void deleteValue(String idElementoCF, String idCampo,
			String orden, int tipoElemento);

	/**
	 * Elementos todos los valores de fecha que pertenezcan al elementoCF pasado
	 * como parametro
	 * 
	 * @param idElementoCF
	 */
	public abstract void deleteValueXIdElemento(String idElementoCF,
			int tipoElemento);

	/*
	 * Obtiene la fecha m�xima de las unidades documentales incluidas en una
	 * serie cuyo idCampo es el pasado como par�metro correspondiente se indica
	 * como par�metro
	 * 
	 * @param idSerie Identificador de la serie
	 * 
	 * @param idCampo Identificador del campo de fecha correspondiente
	 * 
	 * @return Fecha m�xima
	 */
	public Date getFechaMaximaUDocs(String idSerie, String idCampo);

	/*
	 * Obtiene la fecha m�nima de las unidades documentales incluidas en una
	 * serie cuyo idCampo es el pasado como par�metro correspondiente se indica
	 * como par�metro
	 * 
	 * @param idSerie Identificador de la serie
	 * 
	 * @param idCampo Identificador del campo de fecha correspondiente
	 * 
	 * @return Fecha m�xima
	 */
	public Date getFechaMinimaUDocs(String idSerie, String idCampo);

	public List getFechasByIdsElementosCF(String[] idsElementosCF);

	/**
	 * Obtiene el m�ximo orden
	 * 
	 * @param idCampo
	 * @param idUdocRe
	 * @return
	 */
	public int getMaxOrden(String idElemento, String idCampo);

}