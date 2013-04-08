package ieci.tecdoc.sgm.certificacion.pdf.bean;

/**
 * Clase qie almacena todos los datos relacionados con la configuraci�n de datos del PDF
 * @author Jos� Antonio Nogales
 */
public class DatosPropiedades {
	String titulo;
	DatosCabecera cabecera;
	DatosCertificacion certificacion;
	DatosCentrales centro;
	Imagenes imagenes;
	
	/**
	 * Constructor de la clase
	 * @param titulo T�tulo del bloque de datos
	 * @param cabecera Datos pertenecientes a la cabecera
	 * @param certificacion Datos pertenecientes a la certificaci�n
	 * @param centro Datos pertenecientes a la parte central
	 * @param imagenes Datos pertenecientes a las im�genes
	 */
	public DatosPropiedades(String titulo, DatosCabecera cabecera, DatosCertificacion certificacion, DatosCentrales centro, Imagenes imagenes) {
		this.titulo = titulo;
		this.cabecera = cabecera;
		this.certificacion = certificacion;
		this.centro = centro;
		this.imagenes = imagenes;
	}
	
	/**
	 * Constructor de la clase sin par�metros
	 */
	public DatosPropiedades() {
		this.titulo = null;
		this.cabecera = null;
		this.certificacion = null;
		this.centro = null;
		this.imagenes = null;
	}

	/**
	 * M�todos get y set de la clase
	 */
	public DatosCabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(DatosCabecera cabecera) {
		this.cabecera = cabecera;
	}

	public DatosCentrales getCentro() {
		return centro;
	}

	public void setCentro(DatosCentrales centro) {
		this.centro = centro;
	}

	public Imagenes getImagenes() {
		return imagenes;
	}

	public void setImagenes(Imagenes imagenes) {
		this.imagenes = imagenes;
	}

	public DatosCertificacion getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(DatosCertificacion certificacion) {
		this.certificacion = certificacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
