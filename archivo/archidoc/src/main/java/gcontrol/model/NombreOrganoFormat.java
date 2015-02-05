package gcontrol.model;

import java.util.List;

import org.apache.log4j.Logger;

import se.instituciones.InfoOrgano;

import common.Constants;

/**
 * Utilidad para la obtenci�n de datos de �rgano
 */
public class NombreOrganoFormat {

	private static final Logger logger = Logger
			.getLogger(NombreOrganoFormat.class);

	/**
	 * Obtener el nombre largo de un �rgano.
	 * 
	 * @param organoUsuario
	 *            �rgano.
	 * @param organosAntecesores
	 *            Lista de �rganos antecesores.
	 * @return Nombre largo del �rgano.
	 */
	public static final String formatearNombreLargo(InfoOrgano organoUsuario,
			List organosAntecesores) {
		StringBuffer nombreLargo = new StringBuffer();

		// A�adir el nombre del �rgano del usuario
		if (organoUsuario != null) {
			nombreLargo.append(organoUsuario.getNombre());
		}

		// A�adir el nombre de los �rganos antecesores
		if (organosAntecesores != null) {
			InfoOrgano antecesor;
			for (int i = organosAntecesores.size() - 1; i >= 0; i--) {
				antecesor = (InfoOrgano) organosAntecesores.get(i);
				nombreLargo.append(Constants.SEPARADOR_ANTECESORES_ORGANO);
				nombreLargo.append(antecesor.getNombre());
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Nombre largo del \u00F3rgano: "
					+ nombreLargo.toString());
		return nombreLargo.toString();

	}
}