package ieci.tecdoc.sgm.certificacion.bean;

/**
 * Clase que almacena los datos relativos a la fecha de la certificaci�n
 * @author Jos� Antonio Nogales
 */
public class Fecha {
	protected String fecha;
	protected String hora;
	
	/**
	 * Constructor de la clase
	 * @param fecha Fecha de creaci�n de la certificaci�n
	 * @param hora Hora de creaci�n de la certificaci�n
	 */
	public Fecha(String fecha, String hora) {
		this.fecha = fecha;
		this.hora = hora;
	}
	
	/**
	 * M�todos get y set de la clase
	 */
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
