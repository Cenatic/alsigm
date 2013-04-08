package common;



/**
 * Clase para Convertir tipos de Datos
 * @author lucas
 *
 */
public class Conversor {

	/**
	 * Convierte el n�mero especificado
	 * @param numero N�mero a Convertir
	 * @return N�mero convertido a int
	 */
	public static int toInt(String numero) throws Exception {
		try {
			int retorno = Integer.parseInt(numero);
			return retorno;
		}
		catch(Exception e) {
			throw e;
		}
	}

}
