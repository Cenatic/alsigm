package ieci.tdw.ispac.ispaclib.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilidades sobre objetos Map.
 *
 */
public class MapUtils extends org.apache.commons.collections.MapUtils {

	/**
	 * Indica si un mapa es nulo o est� vac�o.
	 * @param map Mapa.
	 * @return true si el mapa es nulo o est� vac�o.
	 */
	public static boolean isEmpty(Map map){
		return (map == null || map.isEmpty());
	}

	/**
	 * Indica si un mapa no est� vac�o.
	 * @param map Mapa.
	 * @return true si el mapa no est� vac�o.
	 */
	public static boolean isNotEmpty(Map map){
		return !isEmpty(map);
	}

	public static Map toMap(Object[] array){
		Map map = new HashMap();
		if (!ArrayUtils.isEmpty(array)){
			for (int i = 0; i < array.length; i++) {
				map.put(array[i], array[i]);
			}
		}
		return map;
	}
	
}
