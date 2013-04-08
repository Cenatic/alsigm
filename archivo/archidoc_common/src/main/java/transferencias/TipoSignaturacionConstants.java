package transferencias;

import common.Constants;

public class TipoSignaturacionConstants {

	 private static int nextNumOrden = 1;

	   private final int identificador = nextNumOrden ++;
	   private final String nombre;

	   private static final String key =  Constants.TIPO_SIGNATURACION_KEY;

	   public static final TipoSignaturacionConstants[] tiposSignaturacion = new TipoSignaturacionConstants[2];

	   public TipoSignaturacionConstants() {
		  this.nombre = key + "." + String.valueOf(identificador);
	      tiposSignaturacion[identificador-1] = this;
	   }

	   /**
	    * Tipo de signaturaci�n independiente de hueco: la signaturaci�n se realiza durante el proceso de alta o transferencia en el paso
	    * de signaturar y es independiente del hueco al que va destinada la caja.
	    */
	   public static final TipoSignaturacionConstants SIGNATURACION_INDEPENDIENTE_DE_HUECO = new TipoSignaturacionConstants();

	   /**
	    * Tipo de signaturaci�n asociada a hueco: desaparece el paso de signaturar ya que la signatura de las cajas depender� del hueco exacto
	    * en el que se ubique cada caja de la relaci�n / alta, con lo que este valor se determinar� al ubicar la relaci�n de entrega y ser� la
	    * numeraci�n del hueco dentro del dep�sito calculado de forma secuencial seg�n el orden de creaci�n de elementos del dep�sito y teniendo
	    * en cuenta que esa numeraci�n, y por tanto la signatura, ser� �nica por archivo.
	    */
	   public static final TipoSignaturacionConstants SIGNATURACION_ASOCIADA_A_HUECO = new TipoSignaturacionConstants();

	   public int getIdentificador() {
	      return identificador;
	   }

	   public String getNombre(){
		   return nombre;
	   }

	   public static TipoSignaturacionConstants getTipoSignaturacion(int identificador) {
	      return tiposSignaturacion[identificador-1];
	   }

	   public boolean equals(Object otroObjeto) {
	      return identificador == ((TipoSignaturacionConstants)otroObjeto).getIdentificador();
	   }
}