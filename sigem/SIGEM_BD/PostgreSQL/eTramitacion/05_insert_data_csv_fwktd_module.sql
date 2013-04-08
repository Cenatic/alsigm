--
-- Alta de aplicaci�n para el Registro Telem�tico
--

INSERT INTO csv_aplicaciones(id, codigo, nombre, info_conexion)
	VALUES (nextval('csv_apps_seq'), 'SGM_REG_TEL', 'SIGM - Registro Telem�tico', '<?xml version=''1.0'' encoding=''UTF-8''?><connection-config><connector>SIGEM_WEB_SERVICE</connector><parameters><parameter name="WSDL_LOCATION">http://localhost:8080/SIGEM_RegistroTelematicoWS/services/AplicacionExternaCSVConnectorWS?wsdl</parameter></parameters></connection-config>');


--
-- Alta de aplicaci�n para la Tramitaci�n de Expedientes
--

INSERT INTO csv_aplicaciones(id, codigo, nombre, info_conexion)
	VALUES (nextval('csv_apps_seq'), 'SGM_TRAM_EXP', 'SIGM - Tramitaci�n de Expedientes', '<?xml version=''1.0'' encoding=''UTF-8''?><connection-config><connector>SIGEM_WEB_SERVICE</connector><parameters><parameter name="WSDL_LOCATION">http://localhost:8080/SIGEM_TramitacionWS/services/AplicacionExternaCSVConnectorWS?wsdl</parameter></parameters></connection-config>');
