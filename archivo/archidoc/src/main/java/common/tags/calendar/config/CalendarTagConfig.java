package common.tags.calendar.config;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import common.Constants;

/**
 * Clase para representar un objeto de configuraci�n del calendario
 */
public class CalendarTagConfig {

	private String id = null;
	private Integer year = null;
	private String function = null;
	private String parameters = null;
	private Integer numMonths = null;
	private Integer month = null;

	private String[] monthNames = null;
	private String[] dayNames = null;

	private Map months = new HashMap();

	/**
	 * Constructor de la configuraci�n del calendario
	 */
	public CalendarTagConfig() {
		super();
	}

	/**
	 * Devuelve el a�o
	 * 
	 * @return a�o.
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Establece el a�o
	 * 
	 * @param year
	 *            a�o.
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Devuelve el map de meses
	 * 
	 * @return map de meses.
	 */
	public Map getMonths() {
		return months;
	}

	/**
	 * Establece el map de meses
	 * 
	 * @param dates
	 *            map de fechas.
	 */
	public void setMonths(Map months) {
		this.months = months;
	}

	/**
	 * Devuelve la funci�n a ejecutar
	 * 
	 * @return funci�n a ejecutar.
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * Establece la funci�n a ejecutar
	 * 
	 * @param function
	 *            funci�n a ejecutar.
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * Devuelve el id del calendario
	 * 
	 * @return id del calendario.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id del calendario
	 * 
	 * @param id
	 *            id del calendario.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el mes del calendario
	 * 
	 * @return mes del calendario.
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * Establece el mes del calendario
	 * 
	 * @param month
	 *            mes del calendario.
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * Devuelve el n�mero de meses por fila del calendario
	 * 
	 * @return n�mero de meses por fila del calendario.
	 */
	public Integer getNumMonths() {
		return numMonths;
	}

	/**
	 * Establece el n�mero de meses por fila del calendario
	 * 
	 * @param numMonths
	 *            n�mero de meses por fila del calendario.
	 */
	public void setNumMonths(Integer numMonths) {
		this.numMonths = numMonths;
	}

	/**
	 * Devuelve los par�metros de la funci�n
	 * 
	 * @return par�metros de la funci�n.
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * Establece los par�metros de la funci�n
	 * 
	 * @param parameters
	 *            par�metros de la funci�n.
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	/**
	 * Devuelve los textos de los d�as
	 * 
	 * @return textos de los d�as.
	 */
	public String[] getDayNames() {
		return dayNames;
	}

	/**
	 * Establece los textos de los d�as
	 * 
	 * @param dayNames
	 *            textos de los d�as.
	 */
	public void setDayNames(String[] dayNames) {
		this.dayNames = dayNames;
	}

	/**
	 * Devuelve los textos de los meses
	 * 
	 * @return textos de los meses.
	 */
	public String[] getMonthNames() {
		return monthNames;
	}

	/**
	 * Establece los textos de los meses
	 * 
	 * @param monthNames
	 *            Textos de los meses.
	 */
	public void setMonthNames(String[] monthNames) {
		this.monthNames = monthNames;
	}

	/**
	 * M�todo para comprobar si la configuraci�n del calendario es correcta
	 * 
	 * @return Indicador de configuraci�n correcta
	 */
	public boolean isOk() throws Exception {
		return (this.getId() != null)
				&& (this.getYear() != null)
				&& (this.getYear().intValue() > 0)
				&& (((this.getNumMonths() != null)
						&& (this.getNumMonths().intValue() >= 1) && (this
						.getNumMonths().intValue() <= 12)) || ((this.getMonth() != null)
						&& (this.getMonth().intValue() >= 1) && (this
						.getMonth().intValue() <= 12)))
				&& (this.getMonthNames() != null)
				&& (this.getMonthNames().length == 12)
				&& (this.getDayNames() != null)
				&& (this.getDayNames().length == 7)
				&& (this.getMonths() != null);
	}

	/**
	 * Permite obtener el c�digo para insertar una fecha en un Map
	 * 
	 * @param fecha
	 *            Fecha de la que se quiere obtener el c�digo
	 * @return c�digo de la fecha
	 * @throws Exception
	 */
	public static String getMapDateCode(Date fecha) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(fecha);

		String codigo = calendar.get(Calendar.DATE)
				+ Constants.SEPARATOR_CALENDAR_CODE
				+ (calendar.get(Calendar.MONTH) + 1)
				+ Constants.SEPARATOR_CALENDAR_CODE
				+ calendar.get(Calendar.YEAR);
		return codigo;
	}

	/**
	 * Permite obtener el c�digo para insertar una fecha en un Map
	 * 
	 * @param dia
	 *            D�a de la fecha
	 * @param mes
	 *            Mes de la fecha
	 * @param anio
	 *            A�o de la fecha
	 * @return c�digo de la fecha
	 * @throws Exception
	 */
	public static String getMapDateCode(int dia, int mes, int anio) {
		String codigo = dia + Constants.SEPARATOR_CALENDAR_CODE + (mes + 1)
				+ Constants.SEPARATOR_CALENDAR_CODE + anio;
		return codigo;
	}
}
