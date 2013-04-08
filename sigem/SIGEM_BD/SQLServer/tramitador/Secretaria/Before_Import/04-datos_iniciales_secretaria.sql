-------------------------
-- DECLARACION DE VARIABLES
-------------------------
DECLARE @sequence_vars_id int;
DECLARE @sequence_sec_contador_id int;
DECLARE @sequence_tbl_002_id int;
DECLARE @sequence_tbl_004_id int;
DECLARE @sequence_tbl_007_id int;
DECLARE @sequence_ctreglas_id int;
DECLARE @sequence_ctentidades_id int;
DECLARE @sequence_ctentidades_resources_id int;
DECLARE @sequence_vldtbl_organo_gobierno_id int;
DECLARE @sequence_vldtbl_cargo_organo_id int;
DECLARE @sequence_vldtbl_area_gobierno_id int;
DECLARE @sequence_ct_jerarquias_id int;
DELCARE @sequence_pub_sq_id_acciones int;

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_CNV_SP','NOT_CNV_SP','C�digo del tipo documental Notificacion convocatoria Sesion plenaria');


UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_CNV_CI','NOT_CNV_CI','C�digo del tipo documental Notificacion convocatoria Comisi�n Informativa');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_CERT_A_SP','CERT_A_SP','C�digo del tipo documental Certificado Acuerdo Sesion plenaria');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_A_SP','NOT_A_SE','C�digo del tipo documental Notificaci�n Acuerdo ');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_A_JG','NOT_A_SE','C�digo del tipo documental Notificaci�n Acuerdo ');


UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PLANTDOC_NOT_A_SP','NOT_A_SP','C�digo de la plantilla Notificaci�n Acuerdo Sesion plenaria');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_ACTA_SP','ACT_SP','C�digo del tipo documental Acta Sesi�n Plenaria');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_C_ERROR_SP','DCE_SP','C�digo del tipo documental Correci�n ErroR Acta Sesi�n Plenaria');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_LIBRO_ACTAS_SP','LIB_ACT','C�digo del tipo documental Libro de Actas');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_JUNTA_GOBIERNO','G007','C�digo del procedimiento Junta Gobierno');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_SESIONES_PLENARIAS','G010','C�digo del procedimiento Sesiones plenarias');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_GESTION_INTEGRANTES','G005','C�digo del procedimiento Gesti�n Integrantes');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_TRAMITACION_DECRETOS','G003','Codigo del PCD de Tramitaci�n Decretos');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_CNV_JG','NOT_CNV_JG','C�digo del tipo documental Notificacion convocatoria Junta Gobierno');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PLANTDOC_NOT_A_JG','NOT_A_JG','C�digo de la plantilla Notificaci�n Acuerdo Junta Gobierno');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_LIBRO_ACTAS_JG','LIB_ACT_JG','C�digo del tipo documental Libro de Actas Junta Gobierno');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_LIBRO_ACTAS_JG','G008','Codigo del PCD de Libro Actas JG');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_C_ERROR_DEC','DCE_DEC','C�digo del tipo documental correcci�n error decreto');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_DEC','DEC','C�digo del tipo documental modelo decreto');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_NOT_DEC','NOT_DEC','C�digo del tipo documental notificaci�n decreto');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_DILIGENCIA_APERTURA','DIL_APE','C�digo del tipo documental de la diligencia de apertura');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_DILIGENCIA_CIERRE','DIL_CIE','C�digo del tipo documental de la diligencia de cierre');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_LIBRO_DECRETOS','LIB_DEC','C�digo del tipo documental del libro decretos');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_PROP_DEC','PRO_DEC','C�digo del tipo documental propuesta decreto');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_TPDOC_CERT_DEC','CER_DEC','C�digo del tipo documental certificaci�n decreto');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'COD_PCD_GESTION_PROPUESTAS','G006','Codigo del PCD de Gestion Propuestas');


UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'VALUE_RELACION_ENVIO_SESION','Sesi�n Plenaria/Propuesta','Relacion entre la propuesta y la SP');

UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'VALUE_RELACION_ENVIO_JUNTA','Junta Gobierno/Propuesta','Relacion entre la propuesta y la JG');



--- DECRETOS ---
-- Avisos de documentos firmados
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_DOCFIRMADO_EMAIL_FROM','user@server.es','Remitente email de los avisos de documentos firmados');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_DOCFIRMADO_EMAIL_SUBJECT','Documento firmado expediente ${NUMEXP}','Asunto email de los avisos de documentos firmados');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_DOCFIRMADO_EMAIL_CONTENT','El documento ${DOCUMENT_NAME} en referencia al expediente n�mero ${NUMEXP} se ha firmado con fecha ${DOCUMENT_DATE_SIGN}','Contenido email de los avisos de documentos firmados');

-- Avisos de notificaciones firmadas
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_NOTIFICACIONES_FIRMADAS_EMAIL_FROM','user@server.es','Remitente email de los avisos de notificaciones firmadas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_NOTIFICACIONES_FIRMADAS_SUBJECT','Notificaciones expediente ${NUMEXP}','Asunto email de los avisos de notificaciones firmadas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_NOTIFICACIONES_FIRMADAS_EMAIL_CONTENT','Notificaciones firmadas para el expediente ${NUMEXP}','Contenido email de los avisos de notificaciones firmadas');

--- SESIONES PLENARIAS ---
-- Avisos de Sesi�n Plenaria Convocada
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_SP_EMAIL_FROM','user@server.es','Remitente email de los avisos de notificaciones sesi�n plenaria convocada');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_SP_EMAIL_SUBJECT','Notificaci�n Convocatoria Sesi�n plenaria ${NUMEXP}','Asunto email de los avisos de notificaciones sesi�n plenaria convocada');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_SP_EMAIL_CONTENT','Notificaci�n Convocatoria para la Sesi�n plenaria del expediente ${NUMEXP}','Contenido email de los avisos de notificaciones sesi�n plenaria convocada');

-- Avisos de Certificados Acuerdos Propuesta Sesi�n Plenaria
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_SP_EMAIL_FROM','user@server.es','Remitente email de los avisos de Certificaci�n Acuerdo Sesi�n Plenaria');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_SP_EMAIL_SUBJECT','Certificado Acuerdo Sesi�n plenaria ${NUMEXP}','Asunto email de los avisos de Certificaci�n Acuerdo Sesi�n Plenaria');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_SP_EMAIL_CONTENT','Certificado del Acuerdo de la Sesi�n plenaria ${NUMEXP}','Contenido email de los avisos de Certificaci�n Acuerdo Sesi�n Plenaria');

--- JUNTAS DE GOBERNO ---
-- Avisos de Sesi�n de Xunta de Goberno Convocada
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_JG_EMAIL_FROM','user@server.es','Remitente email de los avisos de notificaciones sesi�n plenaria convocada');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_JG_EMAIL_SUBJECT','Notificaci�n Convocatoria Sesi�n Xunta de Goberno ${NUMEXP}','Asunto email de los avisos de notificaciones sesi�n de Xunta de Goberno convocada');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CNV_JG_EMAIL_CONTENT','Notificaci�n Convocatoria para la Sesi�n de Xunta de Goberno del expediente ${NUMEXP}','Contenido email de los avisos de notificaciones sesi�n de Xunta de Goberno convocada');

-- Avisos de Certificados Acuerdos Propuesta Sesi�n Junta de Goberno
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_JG_EMAIL_FROM','user@server.es','Remitente email de los avisos de Certificaci�n Acuerdo Sesi�n de Xunta de Goberno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_JG_EMAIL_SUBJECT','Certificado Acuerdo Sesi�n de Xunta de Goberno ${NUMEXP}','Asunto email de los avisos de Certificaci�n Acuerdo Sesi�n de Xunta de Goberno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vars_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_VARS';
INSERT INTO SPAC_VARS (id, nombre, valor, descripcion) VALUES(@sequence_vars_id,'AVISO_CAP_JG_EMAIL_CONTENT','Certificado del Acuerdo de la Sesi�n de Xunta de Goberno ${NUMEXP}','Contenido email de los avisos de Certificaci�n Acuerdo Sesi�n de Xunta de Goberno');









---CONTADOR PARA DECRETOS-- (Tipo 1)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2012,0,1,'$NM$/$YR$');
---CONTADOR PARA SESIONES PLENARIAS -- (Tipo 2)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2012,0,2,'$YR$/$NM$');
---CONTADOR PARA Juntas de Gobierno -- (Tipo 3)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2012,0,3,'$YR$/$NM$');

---CONTADOR PARA DECRETOS-- (Tipo 1)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2013,0,1,'$NM$/$YR$');
---CONTADOR PARA SESIONES PLENARIAS -- (Tipo 2)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2013,0,2,'$YR$/$NM$');
---CONTADOR PARA Juntas de Gobierno -- (Tipo 3)
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_sec_contador_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SEC_SQ_ID_CONTADORES';
INSERT INTO SEC_CONTADORES (ID, ANIO, CONTADOR, TIPO, FORMATO)VALUES(@sequence_sec_contador_id,2013,0,3,'$YR$/$NM$');

--Valores tbl de validaci�n de producto
---==============================================================================




UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_002_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_002';
INSERT INTO SPAC_TBL_002 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_002_id, 'TLD', 'TRASLADO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_002));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_002_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_002';
INSERT INTO SPAC_TBL_002 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_002_id, 'TRA', 'TRAMITADOR' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_002));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_002_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_002';
INSERT INTO SPAC_TBL_002 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_002_id, 'NOT', 'NOTIFICADO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_002));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_002_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_002';
INSERT INTO SPAC_TBL_002 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_002_id, 'TRP', 'TRAMITADOR-PROPUESTA' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_002));




UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'CNV', 'CONVOCADA' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'PLN', 'EN PLENO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'XGB', 'EN JUNTA GOBIERNO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'DFT', 'DECRETO FIRMADO Y TRASLADADO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'ENS', 'ESPERANDO NOTIFICACIONES' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_004_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_004';
INSERT INTO SPAC_TBL_004 (ID, VALOR, SUSTITUTO, VIGENTE, ORDEN)VALUES(@sequence_tbl_004_id, 'DNT', 'DECRETO NOTIFICADO' , 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_004));




UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_007_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_007';
INSERT INTO SPAC_TBL_007 (ID, VALOR, VIGENTE, ORDEN)VALUES(@sequence_tbl_007_id, 'Sesi�n/Propuesta', 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_007));
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_tbl_007_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_SPAC_TBL_007';
INSERT INTO SPAC_TBL_007 (ID, VALOR, VIGENTE, ORDEN)VALUES(@sequence_tbl_007_id, 'Junta Gobierno/Propuesta', 1, (SELECT MAX(ID)+1 FROM SPAC_TBL_007));


--Tags de documentos
---==============================================================================


UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetDiligenciaInformativa', 'Datos de la diligencia Informativa asociada al tr�mite','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetDiligenciaInformativaRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetNumHojasLibroDecretos', 'Obtiene la hoja final del libro sin tener en cuenta la diligencia de cierre','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetNumHojasLibroDecretosRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetInfoNotificacionAcuerdosPropuestaSesion','Info Acuerdos Notif Propuesta sesion','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetInfoNotificacionAcuerdosPropuestaSesionRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetRecursosPropuestaSesion', 'Obtiene los recursos del participante de la propuesta','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetRecursosPropuestaSesionRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'CheckActaSPNotSigned', 'No permite llevar a cabo la operaci�n si el acta de la SP est� firmada','ieci.tecdoc.sgm.tram.secretaria.rules.sesiones.plenarias.CheckActaSPNotSignedRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'CheckActaJGNotSigned', 'No permite llevar a cabo la operaci�n si el acta de la JG est� firmada','ieci.tecdoc.sgm.tram.secretaria.rules.sesiones.juntas.CheckActaJGNotSignedRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetInfoAcuerdosPropuestaSesion','Info Acuerdos Notif Propuesta sesion','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetInfoAcuerdosPropuestaSesionRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetNumHojasLibroActas', 'Obtiene la hoja final del libro sin tener en cuenta la diligencia de cierre','ieci.tecdoc.sgm.tram.secretaria.rules.libro.GetNumHojasLibroActasRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'GetOrdenDelDia','Lista de propuestas a tratar','ieci.tecdoc.sgm.tram.secretaria.rules.documentos.tags.GetOrdenDelDiaRule',1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctreglas_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTREGLAS';
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo)  VALUES(@sequence_ctreglas_id ,'SetNumDecretoRule', 'Si firma Alcald�a se asigna el n�mero de decreto','ieci.tecdoc.sgm.tram.secretaria.rules.signcircuit.SetNumDecretoRule',1);



UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_VLDTBL_ORGANO_GOBIERNO', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para organo de gobierno', 'SPAC_SQ_661291693', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>3</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>250</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_VLDTBL_CARGO_ORGANO', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Cargo �rgano', 'SPAC_SQ_562949042', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>3</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>250</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_VLDTBL_AREA_GOBIERNO', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para �rea de gobierno', 'SPAC_SQ_660930754', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>3</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>250</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_VLDTBL_CARGO_AREA', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Cargo �rea', 'SPAC_SQ_1765192511', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>3</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>250</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_TBL_VIEW_SESION_P', 'ID', NULL, NULL, NULL, 'Vista Sesi�n / Propuesta', '<SIN SECUENCIA>', '<entity version=''1.00''><editable>N</editable><dropable>S</dropable><status>0</status><fields><field id=''1''><physicalName>id</physicalName><descripcion><![CDATA[Identificador inequ�voco del valor]]></descripcion><type>3</type><nullable>N</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''2''><physicalName>valor</physicalName><descripcion><![CDATA[Valor que se almacena en el campo validado]]></descripcion><type>0</type><size>6</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''3''><physicalName>sustituto</physicalName><descripcion><![CDATA[Texto que se muestra en la lista de selecci�n]]></descripcion><type>0</type><size>30</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''4''><physicalName>vigente</physicalName><descripcion><![CDATA[Indica si el valor est� en vigencia para ser seleccionado]]></descripcion><type>2</type><size>1</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field></fields></entity>');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTENTIDADES';
INSERT INTO SPAC_CT_ENTIDADES (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion)
	VALUES (@sequence_ctentidades_id, 3, 'SEC_TBL_VIEW_PROPUESTA', 'ID', NULL, NULL, NULL, 'Vista Propuesta', '<SIN SECUENCIA>', '<entity version=''1.00''><editable>N</editable><dropable>S</dropable><status>0</status><fields><field id=''1''><physicalName>id</physicalName><descripcion><![CDATA[Identificador inequ�voco del valor]]></descripcion><type>3</type><nullable>N</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''2''><physicalName>valor</physicalName><descripcion><![CDATA[Valor que se almacena en el campo validado]]></descripcion><type>0</type><size>6</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''3''><physicalName>sustituto</physicalName><descripcion><![CDATA[Texto que se muestra en la lista de selecci�n]]></descripcion><type>0</type><size>256</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''4''><physicalName>vigente</physicalName><descripcion><![CDATA[Indica si el valor est� en vigencia para ser seleccionado]]></descripcion><type>2</type><size>1</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable><documentarySearch>N</documentarySearch><multivalue>N</multivalue></field></fields></entity>');




UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_ORGANO_GOBIERNO'), 'es', 'SEC_VLDTBL_ORGANO_GOBIERNO', '�rgano gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_ORGANO_GOBIERNO'), 'gl', 'SEC_VLDTBL_ORGANO_GOBIERNO', '�rgano gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_ORGANO_GOBIERNO'), 'eu', 'SEC_VLDTBL_ORGANO_GOBIERNO', '�rgano gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_ORGANO_GOBIERNO'), 'ca', 'SEC_VLDTBL_ORGANO_GOBIERNO', '�rgano gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_ORGANO'), 'es', 'SEC_VLDTBL_CARGO_ORGANO', 'Cargo �rgano');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_ORGANO'), 'gl', 'SEC_VLDTBL_CARGO_ORGANO', 'Cargo �rgano');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_ORGANO'), 'eu', 'SEC_VLDTBL_CARGO_ORGANO', 'Cargo �rgano');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_ORGANO'), 'ca', 'SEC_VLDTBL_CARGO_ORGANO', 'Cargo �rgano');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_AREA_GOBIERNO'), 'es', 'SEC_VLDTBL_AREA_GOBIERNO', '�rea gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_AREA_GOBIERNO'), 'gl', 'SEC_VLDTBL_AREA_GOBIERNO', '�rea gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_AREA_GOBIERNO'), 'eu', 'SEC_VLDTBL_AREA_GOBIERNO', '�rea gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_AREA_GOBIERNO'), 'ca', 'SEC_VLDTBL_AREA_GOBIERNO', '�rea gobierno');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_AREA'), 'es', 'SEC_VLDTBL_CARGO_AREA', 'Cargo �rea');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_AREA'), 'gl', 'SEC_VLDTBL_CARGO_AREA', 'Cargo �rea');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_AREA'), 'eu', 'SEC_VLDTBL_CARGO_AREA', 'Cargo �rea');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_VLDTBL_CARGO_AREA'), 'ca', 'SEC_VLDTBL_CARGO_AREA', 'Cargo �rea');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_PROPUESTA'), 'es', 'SEC_TBL_VIEW_PROPUESTA', 'Vista Propuestas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_PROPUESTA'), 'gl', 'SEC_TBL_VIEW_PROPUESTA', 'Vista Propuestas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_PROPUESTA'), 'eu', 'SEC_TBL_VIEW_PROPUESTA', 'Vista Propuestas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id,(SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_PROPUESTA'), 'ca', 'SEC_TBL_VIEW_PROPUESTA', 'Vista Propuestas');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_SESION_P'), 'es', 'SEC_TBL_VIEW_SESION_P', 'Vista Sesi�n / Propuesta');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_SESION_P'), 'gl', 'SEC_TBL_VIEW_SESION_P', 'Vista Sesi�n / Propuesta');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_SESION_P'), 'eu', 'SEC_TBL_VIEW_SESION_P', 'Vista Sesi�n / Propuesta');
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_ctentidades_resources_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_ENTIDADESRESOURCES';
INSERT INTO SPAC_CT_ENTIDADES_RESOURCES (id, id_ent, idioma, clave, valor) VALUES ( @sequence_ctentidades_resources_id, (SELECT ID FROM SPAC_CT_ENTIDADES WHERE NOMBRE='SEC_TBL_VIEW_SESION_P'), 'ca', 'SEC_TBL_VIEW_SESION_P', 'Vista Sesi�n / Propuesta');







UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vldtbl_organo_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_661291693';
INSERT INTO SEC_vldtbl_organo_gobierno (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_organo_gobierno_id, '01', 'Pleno de Gobierno', 1, 1);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vldtbl_organo_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_661291693';
INSERT INTO SEC_vldtbl_organo_gobierno (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_organo_gobierno_id, '02', 'Junta de Gobierno', 1, 2);






UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_cargo_organo_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_562949042';
INSERT INTO SEC_VLDTBL_CARGO_ORGANO (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_cargo_organo_id, '01', 'Sr. Presidente', 1, 1);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_cargo_organo_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_562949042';
INSERT INTO SEC_VLDTBL_CARGO_ORGANO (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_cargo_organo_id, '02', 'Sr. Interventor', 1, 2);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_cargo_organo_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_562949042';
INSERT INTO SEC_VLDTBL_CARGO_ORGANO (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_cargo_organo_id, '03', 'Sr. Secretario', 1, 3);
UPDATE SPAC_SQ_SEQUENCES
SET  @sequence_vldtbl_cargo_organo_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_562949042';
INSERT INTO SEC_VLDTBL_CARGO_ORGANO (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_cargo_organo_id, '04', 'Sr. Jefe Servicio', 1, 4);





UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_660930754';
INSERT INTO SEC_vldtbl_area_gobierno (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id, '01', '�rea Gobierno 1', 1, 1);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_660930754';
INSERT INTO SEC_vldtbl_area_gobierno (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id, '02', '�rea Gobierno 2', 1, 2);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_660930754';
INSERT INTO SEC_vldtbl_area_gobierno (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id, '03', '�rea Gobierno 3', 1, 3);






UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_1765192511';
INSERT INTO SEC_VLDTBL_CARGO_AREA (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id, '01', 'Cargo �rea1', 1, 1);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_1765192511';
INSERT INTO SEC_VLDTBL_CARGO_AREA (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id,  '02', 'Cargo �rea2', 1, 2);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_1765192511';
INSERT INTO SEC_VLDTBL_CARGO_AREA (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id,  '03', 'Cargo �rea3', 1, 3);
UPDATE SPAC_SQ_SEQUENCES
SET @sequence_vldtbl_area_gobierno_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_1765192511';
INSERT INTO SEC_VLDTBL_CARGO_AREA (id, valor, sustituto, vigente, orden) VALUES (@sequence_vldtbl_area_gobierno_id,  '04', 'Cargo �rea4', 1, 4);


UPDATE SPAC_SQ_SEQUENCES
SET @sequence_pub_sq_id_acciones = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='PUB_SQ_ID_ACCIONES';
INSERT INTO PUB_ACCIONES  (id, nombre, clase, activa, descripcion, tipo) VALUES(@sequence_pub_sq_id_acciones,'EnvioMailDocAction','ieci.tdw.ispac.ispacpublicador.business.action.mensajesCortos.EnvioMailDocAction',1,'Mensajes Cortos - Env�o email con adjuntos',1);




UPDATE SPAC_SQ_SEQUENCES
SET @sequence_ct_jerarquias_id = sequence_id = sequence_id + 1
WHERE SEQUENCE_NAME='SPAC_SQ_ID_CTJERARQUIAS';
  INSERT INTO SPAC_CT_JERARQUIAS (ID, ID_ENTIDAD_PADRE, ID_ENTIDAD_HIJA, NOMBRE , DESCRIPCION , TIPO)
VALUES(
	@sequence_ct_jerarquias_id,
	(select id from spac_ct_entidades where nombre='SEC_TBL_VIEW_SESION_P'),
	(select id from spac_ct_entidades where nombre='SEC_TBL_VIEW_PROPUESTA'),
	'Sesion-Propuesta',
	'Propuestas a tratar en la sesi�n',
	2);


---Jerarqu�a
---====================================================
exec  createViewJerarquiaByName 'Sesion-Propuesta', 1;