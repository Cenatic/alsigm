package fondos.vos;

/**
 * M�todos de obtenci�n de los valores de los campos de una unidad documental
 * del cuadro de clasificaci�n de fondos documentales
 */
public interface UnidadDocumentalVO extends ElementoCuadroClasificacionVO {

	public String getCodSistProductor();

	public String getDenominacion();

	public String getIdElementocf();

	public String getIdSerie();

	public String getNumExp();

	public String getTipoDocumental();

	public int getMarcasBloqueo();

}
