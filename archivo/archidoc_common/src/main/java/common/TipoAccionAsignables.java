package common;

public class TipoAccionAsignables {

	/**
	 * Creaci�n de los asignables (Baldas, Cajones, etc)
	 */
	public static final int NUEVO_ASIGNABLE = 1;
	/**
	 * Edici�n del Asignable (Balda, Cajon, etc)
	 */
	public static final int EDICION_ASIGNABLE = 2;
	/**
	 * Creaci�n del Elemento Asignable y sus huecos
	 */
	public static final int NUEVO_ASIGNABLE_CON_HUECOS = 3;
	/**
	 * Edici�n del Elemento Asignable para A�adir nuevos Huecos
	 */
	public static final int EDICION_ASIGNABLE_PARA_ANIADIR_HUECOS = 4;
	/**
	 * Edici�n del Elemento Asignable para Eliminar Huecos
	 */
	public static final int EDICION_ASIGNABLE_PARA_ELIMINAR_HUECOS = 5;
	/**
	 * Edici�n del Formato para Cambiarlo de Irregular a Regular
	 */
	public static final int EDICION_ASIGNABLE_CAMBIO_IRREGULAR_A_REGULAR = 6;
	/**
	 * Edici�n del Formato para cambiarlo de Regular a Irregular
	 */
	public static final int EDICION_ASIGNABLE_CAMBIO_REGULAR_A_IRREGULAR = 7;
	/**
	 * Edici�n del Elemento Asignable para Cambiarle el Formato sin cambiar el tipo de formato
	 */
	public static final int EDICION_ASIGNABLE_CAMBIO_FORMATO = 8;


	public static boolean isNuevoAsignable(Integer tipoAccion){
		return comprobacion(tipoAccion, NUEVO_ASIGNABLE);
	}
	
	public static boolean isEdicionAsignable(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE);
	}
	
	public static boolean isNuevoAsignableConHuecos(Integer tipoAccion){
		return comprobacion(tipoAccion, NUEVO_ASIGNABLE_CON_HUECOS);
	}

	public static boolean isEdicionAsignableParaAniadirHuecos(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE_PARA_ANIADIR_HUECOS);
	}
	
	public static boolean isEdicionAsignableParaEliminarHuecos(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE_PARA_ELIMINAR_HUECOS);
	}
	
	public static boolean isEdicionAsignableCambioIrregularToRegular(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE_CAMBIO_IRREGULAR_A_REGULAR);
	}
	
	public static boolean isEdicionAsignableCambioRegularToIrregular(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE_CAMBIO_REGULAR_A_IRREGULAR);
	}	

	public static boolean isEdicionAsignableCambioFormato(Integer tipoAccion){
		return comprobacion(tipoAccion, EDICION_ASIGNABLE_CAMBIO_FORMATO);
	}	

	
	private static boolean comprobacion(Integer tipoAccion, int tipoAccion2){
		boolean retorno= false;
		if(tipoAccion != null && tipoAccion.intValue() == tipoAccion2)
			retorno = true;
		return retorno;
	}
	
}
