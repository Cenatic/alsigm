package ieci.tecdoc.sgm.registro.form.loaders;

import ieci.tecdoc.sgm.core.services.LocalizadorServicios;
import ieci.tecdoc.sgm.core.services.catalogo.OrganoDestinatario;
import ieci.tecdoc.sgm.core.services.catalogo.OrganosDestinatarios;
import ieci.tecdoc.sgm.core.services.catalogo.ServicioCatalogoTramites;
import ieci.tecdoc.sgm.core.services.dto.Entidad;
import ieci.tecdoc.sgm.registro.form.loaders.vo.PropertyValue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SelectOptionsOrganismosLoader extends SelectOptionsLoaderBase {

	private static final Logger logger = Logger
			.getLogger(SelectOptionsOrganismosLoader.class);

	public SelectOptionsOrganismosLoader(String entidad, String language) {
		super(entidad, language);
	}

	/**
	 * Carga los datos de propiedad-valor para las �rganos destinatarios.
	 *
	 * @return Lista de propiedad-valor con los �rganos destinatarios.
	 */
	@Override
	public List<PropertyValue> loadOptions() {

		// Se cargan todos los �rganos destinatarios
		// ya que para cada tr�mite no existe una lista determinada de destinos
		return loadOptions(null);
	}

	/**
	 * Carga los datos de propiedad-valor para las �rganos destinatarios.
	 *
	 * @param tableName
	 *            C�digo del tr�mite, que se podr�a utilizar para filtrar los
	 *            �rganos destinatarios a cargar.
	 * @return Lista de propiedad-valor con los �rganos destinatarios.
	 */
	@Override
	public List<PropertyValue> loadOptions(String tableName) {

		List<PropertyValue> options = new ArrayList<PropertyValue>();

		try {
			ServicioCatalogoTramites servicioCatalogoTramites = LocalizadorServicios
					.getServicioCatalogoTramites();

			Entidad oEntidad = new Entidad();
			oEntidad.setIdentificador(getEntidad());

			// Obtener todos los �rganos destinatarios
			OrganosDestinatarios organosDestinatarios = servicioCatalogoTramites
					.getAddressees(oEntidad);
			if ((organosDestinatarios != null)
					&& (organosDestinatarios.count() > 0)) {

				PropertyValue option = null;
				for (int i = 0; i < organosDestinatarios.count(); i++) {

					OrganoDestinatario organo = organosDestinatarios.get(i);
					option = new PropertyValue(organo.getDescription(), organo
							.getId());
					options.add(option);
				}
			}
		} catch (Exception e) {
			logger.error("Error al cargar las opciones de seleccion", e);
		}

		return options;
	}

}
