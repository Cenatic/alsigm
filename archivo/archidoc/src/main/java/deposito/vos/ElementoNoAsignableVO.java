package deposito.vos;

/**
 * Value Object en el que mantener la informaci�n referente a los elementos no
 * asignables que integran el dep�sito f�sico gestionado por el sistema
 */
public class ElementoNoAsignableVO extends ElementoVO {

	public boolean isAsignable() {
		return false;
	}
}
