ALTER TABLE SN_PROCEDIMIENTO ADD ALTA_ASUNTO_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD ALTA_MENSAJE_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD ALTA_MENSAJE_SMS VARCHAR(160);
ALTER TABLE SN_PROCEDIMIENTO ADD BAJA_ASUNTO_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD BAJA_MENSAJE_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD BAJA_MENSAJE_SMS VARCHAR(160);
ALTER TABLE SN_PROCEDIMIENTO ADD MODIF_ASUNTO_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD MODIF_MENSAJE_EMAIL VARCHAR(4000);
ALTER TABLE SN_PROCEDIMIENTO ADD MODIF_MENSAJE_SMS VARCHAR(160);

ALTER TABLE SN_NOTIFICACION ADD ACUSE_RECIBO BYTEA;

UPDATE sn_tipo_correspondencia SET tipo_correspondencia='NOT1' WHERE tipo_correspondencia='NOTSIGEM';
UPDATE sn_tipo_correspondencia SET tipo_correspondencia='NOT1CIFR' WHERE tipo_correspondencia='COMSIGEM';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-4' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Subvenci�n' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Subvenci�n' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-4' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Subvenci�n' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Subvenci�n' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-4' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Subvenci�n' WHERE cod_procedimiento='PCD-4';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Subvenci�n' WHERE cod_procedimiento='PCD-4';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 013' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Solicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Solicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 013' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Solicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja olicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 013' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Solicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Solicitud de Tarjeta de Estacionamiento para Min�svalidos' WHERE cod_procedimiento='013';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-3' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-3' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-3' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Solicitud de Reclamaci�n, queja y sugerencias' WHERE cod_procedimiento='PCD-3';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-11' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-11' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-11' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Solicitud de Certificado Urban�stico' WHERE cod_procedimiento='PCD-11';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-15' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-15' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-15' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Solicitud de Acometida de Agua' WHERE cod_procedimiento='PCD-15';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-16' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-16' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-16' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Reclamaci�n Tributos' WHERE cod_procedimiento='PCD-16';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 023' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Licencia de Vado' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Licencia de Vado' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 023' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Licencia de Vado' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Licencia de Vado' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 023' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Licencia de Vado' WHERE cod_procedimiento='023';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Licencia de Vado' WHERE cod_procedimiento='023';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-5' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-5' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-5' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Licencia de Obra Menor' WHERE cod_procedimiento='PCD-5';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 024' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 024' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 024' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='024';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 026' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Licencia de Apertura de Actividad No Clasificada' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 026' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Licencia de Apertura de Actividad Clasificada' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Licencia de Apertura de Actividad Clasificada' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 026' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Licencia de Apertura de Actividad Clasificada' WHERE cod_procedimiento='026';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Licencia de Apertura de Actividad Clasificada' WHERE cod_procedimiento='026';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 019' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Expediente Sancionador' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Expediente Sancionador' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 019' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Expediente Sancionador' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Expediente Sancionador' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 019' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Expediente Sancionador' WHERE cod_procedimiento='019';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Expediente Sancionador' WHERE cod_procedimiento='019';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento PCD-10' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Contrato Negociado' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Contrato Negociado' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento PCD-10' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Contrato Negociado' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Contrato Negociado' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento PCD-10' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Contrato Negociado' WHERE cod_procedimiento='PCD-10';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Contrato Negociado' WHERE cod_procedimiento='PCD-10';

UPDATE sn_procedimiento SET ALTA_ASUNTO_EMAIL='Alta procedimiento 025' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET ALTA_MENSAJE_EMAIL='Alta de suscripci�n a procedimiento Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET ALTA_MENSAJE_SMS='Alta Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET BAJA_ASUNTO_EMAIL='Baja procedimiento 025' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET BAJA_MENSAJE_EMAIL='Baja de suscripci�n a procedimiento Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET BAJA_MENSAJE_SMS='Baja Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET MODIF_ASUNTO_EMAIL='Modificaci�n procedimiento 025' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET MODIF_MENSAJE_EMAIL='Modificaci�n de suscripci�n a procedimiento Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';
UPDATE sn_procedimiento SET MODIF_MENSAJE_SMS='Modificaci�n Cambio de Titularidad de Licencia de Apertura' WHERE cod_procedimiento='025';


