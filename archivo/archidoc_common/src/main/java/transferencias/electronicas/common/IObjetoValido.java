package transferencias.electronicas.common;


public interface IObjetoValido {

	/**
	 * Comprueba si un objeto es v�lido.
	 * @return
	 */
	public void validate();

	public boolean isConErrores();
}
