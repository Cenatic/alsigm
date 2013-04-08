----------------
-- SECUENCIAS --
----------------

CREATE SEQUENCE sgl_sq_id_obras_menores AS INTEGER NO CACHE ORDER;
CREATE SEQUENCE sgq_sq_id_quejas AS INTEGER NO CACHE ORDER;
CREATE SEQUENCE sgs_sq_id_subvenciones AS INTEGER NO CACHE ORDER;


--
-- Tablas de los pilotos
--
CREATE TABLE sgl_obras_menores (
    id INTEGER NOT NULL,
    numexp VARCHAR(30),
    tipo_objeto VARCHAR(15),
    tipo_localizador VARCHAR(15),
    localizador VARCHAR(15),
    actuacion_casco_historico VARCHAR(2),
    tipo_finca VARCHAR(15),
    tipo_suelo VARCHAR(15),
    ubicacion_inmueble VARCHAR(512),
    referencia_catastral VARCHAR(20),
    localizacion VARCHAR(15),
    descripcion CLOB,
    presupuesto_total NUMERIC(15,2),
    fecha_inicio TIMESTAMP,
    fecha_terminacion TIMESTAMP,
    ocupacion_via_publica VARCHAR(2)
);
CREATE TABLE sgq_quejas (
    id INTEGER NOT NULL,
    numexp VARCHAR(30),
    id_organo_objeto VARCHAR(64),
    organo_objeto VARCHAR(512),
    tipo_objeto VARCHAR(10),
    localizador_objeto VARCHAR(64),
    asunto CLOB,
    tipo_organo_destino VARCHAR(8),
    id_organo_informe VARCHAR(64),
    organo_informe VARCHAR(512)
);
CREATE TABLE sgs_subvenciones (
    id INTEGER NOT NULL,
    numexp VARCHAR(30),
    id_pcd INTEGER,
    anio_presupuestario NUMERIC(4,0),
    tipo_subvencion VARCHAR(8),
    fecha_convocatoria TIMESTAMP,
    denominacion_proyecto VARCHAR(120),
    resumen_proyecto CLOB,
    fecha_inicio_ejecucion TIMESTAMP,
    fecha_fin_ejecucion TIMESTAMP,
    duracion_proyecto NUMERIC(2,0),
    colectivo_destino VARCHAR(64),
    importe_solicitado NUMERIC(13,2),
    importe_concedido NUMERIC(13,2),
    prevision_gastos CLOB,
    importe_gastos NUMERIC(10,2),
    total_gastos NUMERIC(10,2),
    aportacion_ayto NUMERIC(13,2),
    aportacion_entidad NUMERIC(13,2),
    otras_aportaciones NUMERIC(13,2),
    total_aportaciones NUMERIC(13,2),
    finalidad_subvencion CLOB,
    observaciones CLOB
);

--
-- Claves primarias
--
ALTER TABLE sgl_obras_menores
    ADD CONSTRAINT pk_sgl_obras_meno PRIMARY KEY (id);
ALTER TABLE sgq_quejas
    ADD CONSTRAINT pk_sgq_quejas PRIMARY KEY (id);
ALTER TABLE sgs_subvenciones
    ADD CONSTRAINT pk_sgs_subv PRIMARY KEY (id);




---------------------------------------------------------
-- DATOS EXTRAIDOS DEL SCRIPT datos_iniciales  --
---------------------------------------------------------
--Tipos de documentos
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (1, 'Acuerdo Consejo de Gobierno', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (2, 'Admisi�n a tr�mite', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'SALIDA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (3, 'Alegaciones', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'ENTRADA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (4, 'Archivo del expediente', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (5, 'Comunicaci�n al interesado', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'SALIDA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (6, 'Comunicaci�n de apertura', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'SALIDA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (7, 'Decreto de concesi�n', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (9, 'Emisi�n oficio de respuesta', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (10, 'Emisi�n oficio no admisi�n', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (12, 'Notificaci�n oficio de respuesta', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'SALIDA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (13, 'Propuesta de resoluci�n', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', NULL, NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (14, 'Remisi�n documentaci�n', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-08 00:00:00', 'ENTRADA', NULL);
INSERT INTO spac_ct_tpdoc (id, nombre, cod_tpdoc, tipo, autor, descripcion, fecha, tiporeg, observaciones) VALUES (16, 'Notificaci�n resoluci�n', NULL, NULL, 'SYSSUPERUSER', NULL, '2007-10-09 00:00:00', 'SALIDA', NULL);

-- Tr�mites
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (1, 'Admisi�n a tr�mite', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (2, 'Alegaciones', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (3, 'Archivo del expediente', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (4, 'Comunicaci�n al interesado', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (5, 'Comunicaci�n de apertura', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (6, 'Decreto de concesi�n', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (8, 'Emisi�n oficio de respuesta', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (9, 'Emisi�n oficio no admisi�n', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (11, 'Notificaci�n oficio de respuesta', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (12, 'Propuesta de resoluci�n', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (13, 'Remisi�n documentaci�n', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (15, 'Acuerdo Consejo de Gobierno', NULL, NULL, NULL, NULL, NULL, '2007-10-08 00:00:00', 'SYSSUPERUSER');
INSERT INTO spac_ct_tramites (id, nombre, cod_tram, descripcion, tipo, ordenacion, observaciones, fcreacion, autor) VALUES (17, 'Notificaci�n resoluci�n', NULL, NULL, NULL, NULL, NULL, '2007-10-09 00:00:00', 'SYSSUPERUSER');

-- Tr�mites asociados a las fases
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (1, 1, 1);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (2, 1, 5);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (4, 2, 2);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (6, 2, 12);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (7, 2, 15);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (9, 2, 8);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (10, 2, 11);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (11, 3, 3);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (12, 3, 4);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (13, 3, 6);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (14, 3, 9);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (16, 3, 13);
INSERT INTO spac_ct_fstr (id, id_fase, id_tramite) VALUES (18, 3, 17);

--Tipos de documentos asociados a los tr�mites
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (1, 1, 2);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (2, 2, 3);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (3, 4, 5);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (5, 5, 6);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (6, 6, 7);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (8, 8, 9);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (9, 12, 13);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (10, 13, 14);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (12, 15, 1);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (13, 11, 12);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (14, 9, 10);
INSERT INTO spac_ct_trtd (id, id_tramite, id_tpdoc) VALUES (16, 17, 16);

--Plantillas
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (1, 2, '2007-10-08 18:46:19', 'Admisi�n a tr�mite', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (2, 6, '2007-10-08 18:48:10', 'Comunicaci�n de apertura', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (3, 9, '2007-10-08 18:49:49', 'Emisi�n oficio de respuesta', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (4, 12, '2007-10-08 18:52:06', 'Notificaci�n oficio de respuesta', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (6, 14, '2007-10-08 18:57:52', 'Remisi�n documentaci�n', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (7, 5, '2007-10-08 18:59:48', 'Comunicaci�n al interesado', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (8, 10, '2007-10-08 19:01:59', 'Emisi�n oficio no admisi�n', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (11, 13, '2007-10-09 09:32:51', 'Propuesta de resoluci�n', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (12, 1, '2007-10-09 09:34:00', 'Acuerdo Consejo de Gobierno', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (13, 3, '2007-10-09 09:38:39', 'Alegaciones', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (18, 7, '2007-10-09 13:41:07', 'Decreto de concesi�n', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (34, 8, '2007-10-09 16:37:13', 'Emisi�n informe t�cnico', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (35, 8, '2007-10-09 16:37:44', 'Emisi�n informe jur�dico', '', NULL, NULL, NULL);
INSERT INTO spac_p_plantdoc (id, id_tpdoc, fecha, nombre, expresion, mimetype, path, estacion) VALUES (38, 16, '2007-10-09 16:51:22', 'Notificaci�n resoluci�n', '', NULL, NULL, NULL);

-------------------
-- OBRAS MENORES --
-------------------

--
-- Tablas de validaci�n
--

-- Tabla de validaci�n para Tipos de Suelo
CREATE SEQUENCE spac_sq_spac_tbl_010 AS INTEGER NO CACHE ORDER;
CREATE TABLE spac_tbl_010 (
    id INTEGER NOT NULL,
    valor VARCHAR(8),
    sustituto VARCHAR(64),
    vigente SMALLINT,
	orden int
);
ALTER TABLE spac_tbl_010
    ADD CONSTRAINT pk_spac_tbl_010 PRIMARY KEY (id);
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion) VALUES (137, 3, 'SPAC_TBL_010', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Tipos de Suelo', 'SPAC_SQ_SPAC_TBL_010', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>8</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>64</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 137, 'es', 'SPAC_TBL_010', 'Tipos de Suelo');
INSERT INTO spac_tbl_010 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_010, '1', 'Urbanizable', 1, 1);
INSERT INTO spac_tbl_010 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_010, '2', 'No urbanizable', 1, 2);
INSERT INTO spac_tbl_010 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_010, '3', 'Urbano', 1, 3);



-- Tabla de validaci�n para Tipos de Finca
CREATE SEQUENCE spac_sq_spac_tbl_011 AS INTEGER NO CACHE ORDER;
CREATE TABLE spac_tbl_011 (
  	id INTEGER NOT NULL,
  	valor VARCHAR(8),
  	sustituto VARCHAR(64),
  	vigente SMALLINT,
	orden int
);
ALTER TABLE spac_tbl_011
    ADD CONSTRAINT pk_spac_tbl_011 PRIMARY KEY (id);
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion) VALUES (138, 3, 'SPAC_TBL_011', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Tipos de Finca', 'SPAC_SQ_SPAC_TBL_011', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>8</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>64</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 138, 'es', 'SPAC_TBL_011', 'Tipos de Finca');
INSERT INTO spac_tbl_011 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_011, '1', 'Unifamiliar', 1, 1);



-- Tabla de validaci�n para Localizaci�n de Obras
CREATE SEQUENCE spac_sq_spac_tbl_012 AS INTEGER NO CACHE ORDER;
CREATE TABLE spac_tbl_012 (
  	id INTEGER NOT NULL,
  	valor VARCHAR(8),
  	sustituto VARCHAR(64),
  	vigente SMALLINT,
	orden int
);
ALTER TABLE spac_tbl_012
    ADD CONSTRAINT pk_spac_tbl_012 PRIMARY KEY (id);
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion) VALUES (139, 3, 'SPAC_TBL_012', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Localizaci�n de Obras', 'SPAC_SQ_SPAC_TBL_012', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>8</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>64</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 139, 'es', 'SPAC_TBL_012', 'Localizaci�n de Obras');
INSERT INTO spac_tbl_012 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_012, '1', 'Exterior', 1, 1);
INSERT INTO spac_tbl_012 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_012, '2', 'Interior', 1, 2);

--
-- Entidad
--
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion, frm_jsp, fecha)
	VALUES (200, 1, 'SGL_OBRAS_MENORES', 'ID', 'NUMEXP', 'NUMEXP', NULL, 'Obra Menor', 'SGL_SQ_ID_OBRAS_MENORES', NULL, NULL, current timestamp);

UPDATE spac_ct_entidades SET definicion ='<entity version=''1.00''>
<editable>S</editable>
<dropable>S</dropable>
<status>0</status>
<fields>
	<field id=''1''>
		<physicalName>tipo_objeto</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''2''>
		<physicalName>tipo_localizador</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''3''>
		<physicalName>localizador</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''4''>
		<physicalName>actuacion_casco_historico</physicalName>
		<type>0</type>
		<size>2</size>
	</field>
	<field id=''5''>
		<physicalName>tipo_finca</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''6''>
		<physicalName>tipo_suelo</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''7''>
		<physicalName>ubicacion_inmueble</physicalName>
		<type>0</type>
		<size>512</size>
	</field>
	<field id=''8''>
		<physicalName>referencia_catastral</physicalName>
		<type>0</type>
		<size>20</size>
	</field>
	<field id=''9''>
		<physicalName>localizacion</physicalName>
		<type>0</type>
		<size>15</size>
	</field>
	<field id=''10''>
		<physicalName>descripcion</physicalName>
		<type>1</type>
	</field>
	<field id=''11''>
		<physicalName>presupuesto_total</physicalName>
		<type>4</type>
		<size>15</size>
		<precision>2</precision>
	</field>
	<field id=''12''>
		<physicalName>fecha_inicio</physicalName>
		<type>6</type>
	</field>
	<field id=''13''>
		<physicalName>fecha_terminacion</physicalName>
		<type>6</type>
	</field>
	<field id=''14''>
		<physicalName>ocupacion_via_publica</physicalName>
		<type>0</type>
		<size>2</size>
	</field>
	<field id=''15''>
		<physicalName>id</physicalName>
		<descripcion><![CDATA[Campos Clave de la entidad (Uso interno del sistema)]]></descripcion>
		<type>3</type>
	</field>
	<field id=''16''>
		<physicalName>numexp</physicalName>
		<descripcion><![CDATA[Campo que relaciona la entidad con un n�mero de expediente (Uso interno del sistema)]]></descripcion>
		<type>0</type>
		<size>30</size>
	</field>
</fields>
<validations>
	<validation id=''1''>
		<fieldId>9</fieldId>
		<table>SPAC_TBL_012</table>
		<tableType>3</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
	<validation id=''2''>
		<fieldId>5</fieldId>
		<table>SPAC_TBL_011</table>
		<tableType>3</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
	<validation id=''3''>
		<fieldId>6</fieldId>
		<table>SPAC_TBL_010</table>
		<tableType>3</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
	<validation id=''4''>
		<fieldId>4</fieldId>
		<table>SPAC_TBL_009</table>
		<tableType>2</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
	<validation id=''5''>
		<fieldId>14</fieldId>
		<table>SPAC_TBL_009</table>
		<tableType>2</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
</validations>
</entity>'
WHERE id = 200;

INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'SGL_OBRAS_MENORES', 'Obra Menor');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'DESCRIPCION', 'Descripci�n Obras');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'TIPO_OBJETO', 'Tipo de Objeto');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'TIPO_LOCALIZADOR', 'Tipo de Localizador');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'LOCALIZADOR', 'Localizador');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'UBICACION_INMUEBLE', 'Ubicaci�n inmueble');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'REFERENCIA_CATASTRAL', 'Referencia catastral');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'LOCALIZACION', 'Localizaci�n obras');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'TIPO_FINCA', 'Tipo de finca');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'TIPO_SUELO', 'Tipo de suelo');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'ACTUACION_CASCO_HISTORICO', 'Actuaci�n dentro del Casco Hist�rico');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'OCUPACION_VIA_PUBLICA', 'Necesidad ocupar v�a p�blica');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'PRESUPUESTO_TOTAL', 'Presupuesto total (sin IVA)');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'FECHA_INICIO', 'Fecha Inicio obras');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 200, 'es', 'FECHA_TERMINACION', 'Fecha Terminaci�n');

--
-- Formulario
--
INSERT INTO spac_ct_aplicaciones (id, nombre, descripcion, clase, pagina, parametros, formateador, ent_principal_id, ent_principal_nombre)
	VALUES (10, 'Obra Menor', 'Licencia para Obra Menor', 'ieci.tdw.ispac.ispaclib.app.GenericSecondaryEntityApp', '/forms/SGL_OBRAS_MENORES/Obra_Menor.jsp', '<?xml version=''1.0'' encoding=''ISO-8859-1''?><parameters><entity type=''VALIDATION''><table>SPAC_TBL_012</table><relation type=''FLD''><primary-field>LOCALIZACION</primary-field><secondary-field>VALOR</secondary-field></relation></entity><entity type=''VALIDATION''><table>SPAC_TBL_011</table><relation type=''FLD''><primary-field>TIPO_FINCA</primary-field><secondary-field>VALOR</secondary-field></relation></entity><entity type=''VALIDATION''><table>SPAC_TBL_010</table><relation type=''FLD''><primary-field>TIPO_SUELO</primary-field><secondary-field>VALOR</secondary-field></relation></entity></parameters>', NULL, 200, 'SGL_OBRAS_MENORES');
UPDATE spac_ct_entidades SET frm_edit = 10 WHERE id = 200;

UPDATE spac_ct_aplicaciones SET frm_jsp = '<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/ispac-util.tld" prefix="ispac" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<!-- DEFINICION DE LAS ANCLAS A LOS BLOQUES DE CAMPOS -->
<table border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="select" id="tdlink1" align="center">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:SGL_OBRAS_MENORES)" />
</nobr>
</td>
</tr>
</table>

<table width="100%" border="0" class="formtable" cellspacing="0" cellpadding="0">
<tr>
<td><img height="8" src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
<tr>
<td>

<!-- BLOQUE1 DE CAMPOS -->
<div style="display:block" id="block1">
<div id="dataBlock_SGL_OBRAS_MENORES" style="position: relative; height: 320px; width: 600px;">
<div id="label_SGL_OBRAS_MENORES:TIPO_OBJETO" style="position: absolute; top: 61px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:TIPO_OBJETO)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:TIPO_OBJETO" style="position: absolute; top: 58px; left: 150px;">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:TIPO_OBJETO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="25" maxlength="15" tabindex="102">
</ispac:htmlText>
</div>
<div id="label_SGL_OBRAS_MENORES:TIPO_LOCALIZADOR" style="position: absolute; top: 61px; left: 310px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:TIPO_LOCALIZADOR)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:TIPO_LOCALIZADOR" style="position: absolute; top: 58px; left: 440px;">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:TIPO_LOCALIZADOR)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="25" maxlength="15" tabindex="103">
</ispac:htmlText>
</div>
<div id="label_SGL_OBRAS_MENORES:LOCALIZADOR" style="position: absolute; top: 92px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:LOCALIZADOR)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:LOCALIZADOR" style="position: absolute; top: 89px; left: 150px;">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:LOCALIZADOR)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="25" maxlength="15" tabindex="104">
</ispac:htmlText>
</div>
<div id="label_SGL_OBRAS_MENORES:ACTUACION_CASCO_HISTORICO" style="position: absolute; top: 222px; left: 10px; width: 130px;" class="formsTitleB">
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:ACTUACION_CASCO_HISTORICO)" />:
</div>
<div id="data_SGL_OBRAS_MENORES:ACTUACION_CASCO_HISTORICO" style="position: absolute; top: 219px; left: 150px;">
<nobr>
<ispac:htmlTextImageFrame property="property(SGL_OBRAS_MENORES:ACTUACION_CASCO_HISTORICO)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="5" id="SEARCH_SGL_OBRAS_MENORES_ACTUACION_CASCO_HISTORICO" target="workframe" action="selectValue.do?entity=SPAC_TBL_009" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="110">
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_ACTUACION_CASCO_HISTORICO" id="property(SGL_OBRAS_MENORES:ACTUACION_CASCO_HISTORICO)" property="VALOR" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:TIPO_FINCA" style="position: absolute; top: 189px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:TIPO_FINCA)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:TIPO_FINCA" style="position: absolute; top: 186px; left: 150px;">
<html:hidden property="property(SGL_OBRAS_MENORES:TIPO_FINCA)" />
<nobr>
<ispac:htmlTextImageFrame property="property(TIPO_FINCA_SPAC_TBL_011:SUSTITUTO)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="18" id="SEARCH_SGL_OBRAS_MENORES_TIPO_FINCA" target="workframe" action="selectSubstitute.do?entity=SPAC_TBL_011" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="108">
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_TIPO_FINCA" id="property(SGL_OBRAS_MENORES:TIPO_FINCA)" property="VALOR" />
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_TIPO_FINCA" id="property(TIPO_FINCA_SPAC_TBL_011:SUSTITUTO)" property="SUSTITUTO" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:TIPO_SUELO" style="position: absolute; top: 189px; left: 310px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:TIPO_SUELO)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:TIPO_SUELO" style="position: absolute; top: 186px; left: 440px;">
<html:hidden property="property(SGL_OBRAS_MENORES:TIPO_SUELO)" />
<nobr>
<ispac:htmlTextImageFrame property="property(TIPO_SUELO_SPAC_TBL_010:SUSTITUTO)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="18" id="SEARCH_SGL_OBRAS_MENORES_TIPO_SUELO" target="workframe" action="selectSubstitute.do?entity=SPAC_TBL_010" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="109">
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_TIPO_SUELO" id="property(SGL_OBRAS_MENORES:TIPO_SUELO)" property="VALOR" />
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_TIPO_SUELO" id="property(TIPO_SUELO_SPAC_TBL_010:SUSTITUTO)" property="SUSTITUTO" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:UBICACION_INMUEBLE" style="position: absolute; top: 123px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:UBICACION_INMUEBLE)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:UBICACION_INMUEBLE" style="position: absolute; top: 120px; left: 150px;">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:UBICACION_INMUEBLE)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="83" maxlength="512" tabindex="105">
</ispac:htmlText>
</div>
<div id="label_SGL_OBRAS_MENORES:REFERENCIA_CATASTRAL" style="position: absolute; top: 155px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:REFERENCIA_CATASTRAL)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:REFERENCIA_CATASTRAL" style="position: absolute; top: 152px; left: 150px;">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:REFERENCIA_CATASTRAL)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="25" maxlength="20" tabindex="106">
</ispac:htmlText>
</div>
<div id="label_SGL_OBRAS_MENORES:LOCALIZACION" style="position: absolute; top: 155px; left: 310px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:LOCALIZACION)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:LOCALIZACION" style="position: absolute; top: 152px; left: 440px;">
<html:hidden property="property(SGL_OBRAS_MENORES:LOCALIZACION)" />
<nobr>
<ispac:htmlTextImageFrame property="property(LOCALIZACION_SPAC_TBL_012:SUSTITUTO)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="18" id="SEARCH_SGL_OBRAS_MENORES_LOCALIZACION" target="workframe" action="selectSubstitute.do?entity=SPAC_TBL_012" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="107">
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_LOCALIZACION" id="property(SGL_OBRAS_MENORES:LOCALIZACION)" property="VALOR" />
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_LOCALIZACION" id="property(LOCALIZACION_SPAC_TBL_012:SUSTITUTO)" property="SUSTITUTO" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:DESCRIPCION" style="position: absolute; top: 20px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:DESCRIPCION)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:DESCRIPCION" style="position: absolute; top: 17px; left: 150px;">
<ispac:htmlTextarea property="property(SGL_OBRAS_MENORES:DESCRIPCION)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="2" cols="82" tabindex="101">
</ispac:htmlTextarea>
</div>
<div id="label_SGL_OBRAS_MENORES:PRESUPUESTO_TOTAL" style="position: absolute; top: 254px; left: 10px; width: 120px;" class="formsTitleB">
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:PRESUPUESTO_TOTAL)" />:
</div>
<div id="data_SGL_OBRAS_MENORES:PRESUPUESTO_TOTAL" style="position: absolute; top: 251px; left: 150px;" class="formsTitleB">
<ispac:htmlText property="property(SGL_OBRAS_MENORES:PRESUPUESTO_TOTAL)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="18" maxlength="15" tabindex="112">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGL_OBRAS_MENORES:FECHA_INICIO" style="position: absolute; top: 289px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:FECHA_INICIO)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:FECHA_INICIO" style="position: absolute; top: 286px; left: 150px;">
<nobr>
<ispac:htmlTextCalendar property="property(SGL_OBRAS_MENORES:FECHA_INICIO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="14" maxlength="10" image=''<%= buttoncalendar %>'' format="dd/mm/yyyy" enablePast="true" tabindex="113">
</ispac:htmlTextCalendar>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:FECHA_TERMINACION" style="position: absolute; top: 289px; left: 310px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:FECHA_TERMINACION)" />:</nobr>
</div>
<div id="data_SGL_OBRAS_MENORES:FECHA_TERMINACION" style="position: absolute; top: 286px; left: 440px;">
<nobr>
<ispac:htmlTextCalendar property="property(SGL_OBRAS_MENORES:FECHA_TERMINACION)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="14" maxlength="10" image=''<%= buttoncalendar %>'' format="dd/mm/yyyy" enablePast="true" tabindex="114">
</ispac:htmlTextCalendar>
</nobr>
</div>
<div id="label_SGL_OBRAS_MENORES:OCUPACION_VIA_PUBLICA" style="position: absolute; top: 222px; left: 310px; width: 130px;" class="formsTitleB">
<bean:write name="defaultForm" property="entityApp.label(SGL_OBRAS_MENORES:OCUPACION_VIA_PUBLICA)" />:
</div>
<div id="data_SGL_OBRAS_MENORES:OCUPACION_VIA_PUBLICA" style="position: absolute; top: 219px; left: 440px;">
<nobr>
<ispac:htmlTextImageFrame property="property(SGL_OBRAS_MENORES:OCUPACION_VIA_PUBLICA)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="5" id="SEARCH_SGL_OBRAS_MENORES_OCUPACION_VIA_PUBLICA" target="workframe" action="selectValue.do?entity=SPAC_TBL_009" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="111">
<ispac:parameter name="SEARCH_SGL_OBRAS_MENORES_OCUPACION_VIA_PUBLICA" id="property(SGL_OBRAS_MENORES:OCUPACION_VIA_PUBLICA)" property="VALOR" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
</div>
</div>
</td>
</tr>
<tr>
<td height="15"><img src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
</table>'
, frm_version = 1
WHERE id = 10;

--
-- Reglas
--
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo) VALUES (20, 'InitObraMenorRule', 'Crea e inicializa los datos de una Obra Menor', 'ieci.tdw.ispac.api.rule.procedures.obras.InitObraMenorRule', 1);

--
-- Procedimiento
--
INSERT INTO spac_ct_procedimientos (id, cod_pcd, nombre, id_padre, titulo, objeto, asunto, act_func, mtrs_comp, sit_tlm, url, interesado, tp_rel, org_rsltr, forma_inic, plz_resol, unid_plz, finicio, ffin, efec_silen, fin_via_admin, recursos, fcatalog, autor, estado, nversion, observaciones, lugar_present, cnds_ecnmcs, ingresos, f_cbr_pgo, infr_sanc, calendario, dscr_tram, normativa, cnd_particip, documentacion, grupos_delegacion, cod_sistema_productor, mapeo_rt)
	VALUES (5, 'PCD-5', 'Obras menores', 1, 'Obras menores', NULL, 'Obras menores', NULL, NULL, NULL, NULL, NULL, 'INT', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fotocopia DNI
Descripci�n de la obra
Resguardo del pago de tasa', NULL, '04', '<?xml version="1.0" encoding="ISO-8859-1"?>
<procedure>
	<table name="SGL_OBRAS_MENORES">
		<mappings>
			<!-- Mapeos de los datos espec�ficos del expediente -->
			<field name="UBICACION_INMUEBLE" value="${xpath:/datos_especificos/ubicacion_inmueble}"/>
			<field name="DESCRIPCION" value="${xpath:/datos_especificos/descripcion_obras}"/>
		</mappings>
	</table>
</procedure>');

INSERT INTO spac_p_procedimientos (id, id_pcd_bpm, nversion, nombre, estado, id_group, ts_crt, ts_upd) 
	VALUES (5, '5', 1, 'Obras menores', 2, 5, current date, current date);

--
-- Nodos
--
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (14, '14', 5, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (15, '15', 5, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (16, '16', 5, 1, NULL);

--
-- Fases
--
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (14, 1, 5, 'Fase Inicio');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (15, 2, 5, 'Fase Instrucci�n');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (16, 3, 5, 'Fase Terminaci�n');

--
-- Flujos
--
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (18, '18', 5, 14, 15);
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (19, '19', 5, 15, 16);

--
-- Tr�mites
--
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (27, '27', 7, 5, 15, 'Emisi�n informe', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (32, '32', 3, 5, 16, 'Archivo del expediente', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (33, '33', 14, 5, 14, 'Solicitud subsanaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (34, '34', 12, 5, 15, 'Propuesta de resoluci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (35, '35', 10, 5, 15, 'Notificaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (36, '36', 2, 5, 15, 'Alegaciones', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (37, '37', 16, 5, 16, 'Resoluci�n expediente', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (38, '38', 17, 5, 16, 'Notificaci�n resoluci�n', 0, NULL, NULL, null);

--
-- Eventos
--
INSERT INTO spac_p_eventos (id_obj, tp_obj, evento, orden, id_regla) VALUES (5, 1, 32, 5, 20);

--
-- Entidades
--
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (19, 1, 5, 0, 1, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (20, 7, 5, 1, 3, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (21, 3, 5, 1, 4, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (22, 2, 5, 1, 23, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (23, 200, 5, 0, 2, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (26, 8, 5, 1, 5, NULL);

--
-- Permisos
--
--INSERT INTO spac_ss_permisos (id, id_pcd, uid_usr, permiso) VALUES (5, 5, '2-1', 1);


------------
-- QUEJAS --
------------

--
-- Entidad
--
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion, frm_jsp, fecha)
	VALUES (201, 1, 'SGQ_QUEJAS', 'ID', 'NUMEXP', 'NUMEXP', NULL, 'Datos espec�ficos', 'SGQ_SQ_ID_QUEJAS', NULL, NULL, current timestamp);

UPDATE spac_ct_entidades SET definicion ='<entity version=''1.00''>
<editable>S</editable>
<dropable>S</dropable>
<status>0</status>
<fields>
	<field id=''1''>
		<physicalName>id_organo_objeto</physicalName>
		<type>0</type>
		<size>64</size>
	</field>
	<field id=''2''>
		<physicalName>organo_objeto</physicalName>
		<type>0</type>
		<size>512</size>
	</field>
	<field id=''3''>
		<physicalName>tipo_objeto</physicalName>
		<type>0</type>
		<size>10</size>
	</field>
	<field id=''4''>
		<physicalName>localizador_objeto</physicalName>
		<type>0</type>
		<size>64</size>
	</field>
	<field id=''5''>
		<physicalName>asunto</physicalName>
		<type>1</type>
		<size>0</size>
	</field>
	<field id=''6''>
		<physicalName>tipo_organo_destino</physicalName>
		<type>0</type>
		<size>8</size>
	</field>
	<field id=''7''>
		<physicalName>id_organo_informe</physicalName>
		<type>0</type>
		<size>64</size>
	</field>
	<field id=''8''>
		<physicalName>organo_informe</physicalName>
		<type>0</type>
		<size>512</size>
	</field>
	<field id=''9''>
		<physicalName>id</physicalName>
		<descripcion><![CDATA[Campos Clave de la entidad (Uso interno del sistema)]]></descripcion>
		<type>3</type>
	</field>
	<field id=''10''>
		<physicalName>numexp</physicalName>
		<descripcion><![CDATA[Campo que relaciona la entidad con un n�mero de expediente (Uso interno del sistema)]]></descripcion>
		<type>0</type>
		<size>30</size>
	</field>
</fields>
</entity>'
WHERE id = 201;

INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'SGQ_QUEJAS', 'Datos espec�ficos');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'ASUNTO', 'Texto de la Reclamaci�n, Queja o Sugerencia');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'ID_ORGANO_OBJETO', '�rgano Destinatario');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'ORGANO_OBJETO', '�rgano Destinatario');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'TIPO_OBJETO', 'Tipo');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'LOCALIZADOR_OBJETO', 'Localizador');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'TIPO_ORGANO_DESTINO', 'Tipo del �rgano de Destino');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'ID_ORGANO_INFORME', 'Id. de �rgano del Informe');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 201, 'es', 'ORGANO_INFORME', '�rgano del Informe');

--
-- Formulario
--
INSERT INTO spac_ct_aplicaciones (id, nombre, descripcion, clase, pagina, parametros, formateador, ent_principal_id, ent_principal_nombre)
	VALUES (11, 'Queja', 'Reclamaci�n, Queja o Sugerencia', 'ieci.tdw.ispac.ispaclib.app.GenericSecondaryEntityApp', '/forms/SGQ_QUEJAS/Queja.jsp', NULL, NULL, 201, 'SGQ_QUEJAS');
UPDATE spac_ct_entidades SET frm_edit = 11 WHERE id = 201;

UPDATE spac_ct_aplicaciones SET frm_jsp = '<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/ispac-util.tld" prefix="ispac" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<!-- DEFINICION DE LAS ANCLAS A LOS BLOQUES DE CAMPOS -->
<table border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="select" id="tdlink1" align="center">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGQ_QUEJAS:SGQ_QUEJAS)" />
</nobr>
</td>
</tr>
</table>

<table width="100%" border="0" class="formtable" cellspacing="0" cellpadding="0">
<tr>
<td><img height="8" src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
<tr>
<td>

<!-- BLOQUE1 DE CAMPOS -->
<div style="display:block" id="block1">
<div id="dataBlock_SGQ_QUEJAS" style="position: relative; height: 235px; width: 600px;">
<div id="label_SGQ_QUEJAS:ID_ORGANO_OBJETO" style="position: absolute; top: 203px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGQ_QUEJAS:ID_ORGANO_OBJETO)" />:</nobr>
</div>
<div id="data_SGQ_QUEJAS:ID_ORGANO_OBJETO" style="position: absolute; top: 200px; left: 150px;">
<html:hidden property="property(SGQ_QUEJAS:ID_ORGANO_OBJETO)"/>
<nobr>
<ispac:htmlTextImageFrame property="property(SGQ_QUEJAS:ORGANO_OBJETO)"
			  readonly="true"
			  readonlyTag="false"
			  propertyReadonly="readonly"
			  styleClass="input"
			  styleClassReadonly="inputReadOnly"
			  size="46"
			  id="SELECT_SGQ_QUEJAS_ORGANO_OBJETO"
			  target="workframe"
			  action="viewUsersManager.do?captionkey=app.selectOrg.seleccionar&noviewusers=true&noviewgroups=true"
			  image="img/search-mg.gif"
			  showFrame="true" tabindex="102">
	<ispac:parameter name="SELECT_SGQ_QUEJAS_ORGANO_OBJETO" id="property(SGQ_QUEJAS:ID_ORGANO_OBJETO)" property="UID"/>
	<ispac:parameter name="SELECT_SGQ_QUEJAS_ORGANO_OBJETO" id="property(SGQ_QUEJAS:ORGANO_OBJETO)" property="NAME"/>
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGQ_QUEJAS:ASUNTO" style="position: absolute; top: 20px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGQ_QUEJAS:ASUNTO)" />:</nobr>
</div>
<div id="data_SGQ_QUEJAS:ASUNTO" style="position: absolute; top: 37px; left: 11px;">
<ispac:htmlTextarea property="property(SGQ_QUEJAS:ASUNTO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="12" cols="80" tabindex="101">
</ispac:htmlTextarea>
</div>
</div>
</div>
</td>
</tr>
<tr>
<td height="15"><img src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
</table>'
, frm_version = 1
WHERE id = 11;

--
-- Reglas
--
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo) VALUES (21, 'InitQuejaRule', 'Crea e inicializa los datos de una Queja, Reclamaci�n o Sugerencia', 'ieci.tdw.ispac.api.rule.procedures.quejas.InitQuejaRule', 1);

--
-- Procedimiento
--
INSERT INTO spac_ct_procedimientos (id, cod_pcd, nombre, id_padre, titulo, objeto, asunto, act_func, mtrs_comp, sit_tlm, url, interesado, tp_rel, org_rsltr, forma_inic, plz_resol, unid_plz, finicio, ffin, efec_silen, fin_via_admin, recursos, fcatalog, autor, estado, nversion, observaciones, lugar_present, cnds_ecnmcs, ingresos, f_cbr_pgo, infr_sanc, calendario, dscr_tram, normativa, cnd_particip, documentacion, grupos_delegacion, cod_sistema_productor, mapeo_rt) 
	VALUES (3, 'PCD-3', 'Reclamaciones, quejas y sugerencias', 1, 'Reclamaciones, quejas y sugerencias', NULL, 'Reclamaciones, quejas y sugerencias', NULL, NULL, NULL, NULL, NULL, 'INT', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fotocopia del DNI
Descripci�n de la reclamaci�n, queja o sugerencia
', NULL, '04', '<?xml version="1.0" encoding="ISO-8859-1"?>
<procedure>
	<table name="SGQ_QUEJAS">
		<mappings>
			<!-- Mapeos de los datos espec�ficos del expediente -->
			<field name="ASUNTO" value="${xpath:/datos_especificos/asunto_queja}"/>
			<field name="ID_ORGANO_OBJETO" value="${xpath:/datos_especificos/cod_organo}"/>
			<field name="ORGANO_OBJETO" value="${xpath:/datos_especificos/descr_organo}"/>
		</mappings>
	</table>
</procedure>');

INSERT INTO spac_p_procedimientos (id, id_pcd_bpm, nversion, nombre, estado, id_group, ts_crt, ts_upd) 
	VALUES (3, '3', 1, 'Reclamaciones, quejas y sugerencias', 2, 3, current date, current date);

--
-- Nodos
--
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (6, '6', 3, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (7, '7', 3, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (8, '8', 3, 1, NULL);

--
-- Fases
--
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (6, 1, 3, 'Fase Inicio');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (7, 2, 3, 'Fase Instrucci�n');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (8, 3, 3, 'Fase Terminaci�n');

--
-- Flujos
--
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (8, '8', 3, 6, 7);
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (9, '9', 3, 7, 8);

--
-- Tr�mites
--
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (5, '5', 1, 3, 6, 'Admisi�n a tr�mite', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (6, '6', 5, 3, 6, 'Comunicaci�n de apertura', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (7, '7', 8, 3, 7, 'Emisi�n oficio de respuesta', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (8, '8', 11, 3, 7, 'Notificaci�n oficio de respuesta', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (9, '9', 7, 3, 7, 'Emisi�n informe', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (10, '10', 13, 3, 8, 'Remisi�n documentaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (11, '11', 4, 3, 8, 'Comunicaci�n al interesado', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (12, '12', 9, 3, 8, 'Emisi�n oficio no admisi�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (13, '13', 10, 3, 8, 'Notificaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (14, '14', 3, 3, 8, 'Archivo del expediente', 0, NULL, NULL, null);

--
-- Eventos
--
INSERT INTO spac_p_eventos (id_obj, tp_obj, evento, orden, id_regla) VALUES (3, 1, 32, 7, 21);

--
-- Entidades
--
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (11, 1, 3, 0, 1, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (12, 7, 3, 1, 3, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (13, 3, 3, 1, 4, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (14, 2, 3, 1, 25, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (25, 201, 3, 0, 2, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (27, 8, 3, 1, 5, NULL);

--
-- Permisos
--
--INSERT INTO spac_ss_permisos (id, id_pcd, uid_usr, permiso) VALUES (3, 3, '2-1', 1);

------------------
-- SUBVENCIONES --
------------------

--
-- Tablas de validaci�n
--

-- Tabla de validaci�n para Tipos de Subvenci�n
CREATE SEQUENCE spac_sq_spac_tbl_013 AS INTEGER NO CACHE ORDER;
CREATE TABLE spac_tbl_013 (
  	id INTEGER NOT NULL,
  	valor VARCHAR(8),
  	sustituto VARCHAR(64),
  	vigente SMALLINT,
	orden int
);
ALTER TABLE spac_tbl_013
    ADD CONSTRAINT pk_spac_tbl_013 PRIMARY KEY (id);
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion) VALUES (140, 3, 'SPAC_TBL_013', 'ID', NULL, NULL, NULL, 'Tabla de validaci�n para Tipos de Subvenci�n', 'SPAC_SQ_SPAC_TBL_013', '<entity version=''1.00''><editable>S</editable><status>0</status><fields><field id=''1''><logicalName><![CDATA[id]]></logicalName><physicalName>id</physicalName><type>3</type></field><field id=''2''><logicalName><![CDATA[valor]]></logicalName><physicalName>valor</physicalName><type>0</type><size>8</size></field><field id=''3''><logicalName><![CDATA[sustituto]]></logicalName><physicalName>sustituto</physicalName><type>0</type><size>64</size></field><field id=''4''><logicalName><![CDATA[vigente]]></logicalName><physicalName>vigente</physicalName><type>2</type><size>1</size></field><field id=''5''><physicalName>orden</physicalName><descripcion><![CDATA[Indica el orden del valor]]></descripcion><type>2</type><size>10</size><nullable>S</nullable></field></fields></entity>');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 140, 'es', 'SPAC_TBL_013', 'Tipos de Subvenci�n');
INSERT INTO spac_tbl_013 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_013, 'INV', 'Investigaci�n', 1, 1);
INSERT INTO spac_tbl_013 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_013, 'TIC', 'Innovaci�n Tecnol�gica', 1, 2);
INSERT INTO spac_tbl_013 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_013, 'PRO', 'Actividad Promocional', 1, 3);
INSERT INTO spac_tbl_013 (id, valor, sustituto, vigente, orden) VALUES (NEXTVAL FOR spac_sq_spac_tbl_013, 'OBR', 'Obras Menores', 1, 4);

--
-- Entidad
--
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk, definicion, frm_jsp, fecha)
	VALUES (202, 1, 'SGS_SUBVENCIONES', 'ID', 'NUMEXP', 'NUMEXP', NULL, 'Subvenci�n', 'SGS_SQ_ID_SUBVENCIONES', NULL, NULL, current timestamp);

UPDATE spac_ct_entidades SET definicion ='<entity version=''1.00''>
<editable>S</editable>
<dropable>S</dropable>
<status>0</status>
<fields>
	<field id=''1''>
		<physicalName>id_pcd</physicalName>
		<type>3</type>
	</field>
	<field id=''2''>
		<physicalName>anio_presupuestario</physicalName>
		<type>2</type>
		<size>4</size>
	</field>
	<field id=''3''>
		<physicalName>tipo_subvencion</physicalName>
		<type>0</type>
		<size>8</size>
	</field>
	<field id=''4''>
		<physicalName>fecha_convocatoria</physicalName>
		<type>6</type>
	</field>
	<field id=''5''>
		<physicalName>denominacion_proyecto</physicalName>
		<type>0</type>
		<size>10</size>
	</field>
	<field id=''6''>
		<physicalName>resumen_proyecto</physicalName>
		<type>1</type>
	</field>
	<field id=''7''>
		<physicalName>fecha_inicio_ejecucion</physicalName>
		<type>6</type>
	</field>
	<field id=''8''>
		<physicalName>fecha_fin_ejecucion</physicalName>
		<type>6</type>
	</field>
	<field id=''9''>
		<physicalName>duracion_proyecto</physicalName>
		<type>2</type>
		<size>2</size>
	</field>
	<field id=''10''>
		<physicalName>colectivo_destino</physicalName>
		<type>0</type>
		<size>64</size>
	</field>
	<field id=''11''>
		<physicalName>importe_solicitado</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''12''>
		<physicalName>importe_concedido</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''13''>
		<physicalName>prevision_gastos</physicalName>
		<type>1</type>
	</field>
	<field id=''14''>
		<physicalName>importe_gastos</physicalName>
		<type>4</type>
		<size>10</size>
		<precision>2</precision>
	</field>
	<field id=''15''>
		<physicalName>total_gastos</physicalName>
		<type>4</type>
		<size>10</size>
		<precision>2</precision>
	</field>
	<field id=''16''>
		<physicalName>aportacion_ayto</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''17''>
		<physicalName>aportacion_entidad</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''18''>
		<physicalName>otras_aportaciones</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''19''>
		<physicalName>total_aportaciones</physicalName>
		<type>4</type>
		<size>13</size>
		<precision>2</precision>
	</field>
	<field id=''20''>
		<physicalName>finalidad_subvencion</physicalName>
		<type>1</type>
	</field>
	<field id=''21''>
		<physicalName>observaciones</physicalName>
		<type>1</type>
	</field>
	<field id=''22''>
		<physicalName>id</physicalName>
		<descripcion><![CDATA[Campos Clave de la entidad (Uso interno del sistema)]]></descripcion>
		<type>3</type>
	</field>
	<field id=''23''>
		<physicalName>numexp</physicalName>
		<descripcion><![CDATA[Campo que relaciona la entidad con un n�mero de expediente (Uso interno del sistema)]]></descripcion>
		<type>0</type>
		<size>30</size>
	</field>
</fields>
<validations>
	<validation id=''1''>
		<fieldId>3</fieldId>
		<table>SPAC_TBL_013</table>
		<tableType>3</tableType>
		<class/>
		<mandatory>N</mandatory>
	</validation>
</validations>
</entity>'
WHERE id = 202;

INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'SGS_SUBVENCIONES', 'Subvenci�n');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'ANIO_PRESUPUESTARIO', 'A�o presupuestario');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'FECHA_CONVOCATORIA', 'Fecha de convocatoria');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'TIPO_SUBVENCION', 'Tipo de subvenci�n');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'COLECTIVO_DESTINO', 'Colectivo destino');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'DENOMINACION_PROYECTO', 'Denominaci�n del proyecto');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'RESUMEN_PROYECTO', 'Resumen del proyecto');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'FECHA_INICIO_EJECUCION', 'Fecha inicio de ejecuci�n');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'FECHA_FIN_EJECUCION', 'Fecha fin de ejecuci�n');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'DURACION_PROYECTO', 'Duraci�n del proyecto');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'IMPORTE_SOLICITADO', 'Importe solicitado');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'IMPORTE_CONCEDIDO', 'Importe concedido');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'PREVISION_GASTOS', 'Gastos previstos');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'IMPORTE_GASTOS', 'Importe gastos');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'APORTACION_AYTO', 'Aportaci�n ayuntamiento');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'APORTACION_ENTIDAD', 'Aportaci�n entidad solicitante');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'OTRAS_APORTACIONES', 'Otras aportaciones');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'TOTAL_APORTACIONES', 'Total aportacion');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'FINALIDAD_SUBVENCION', 'Finalidad subvenci�n');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'OBSERVACIONES', 'Observaciones');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'ID_PCD', 'Id. de Procedimiento');
INSERT INTO spac_ct_entidades_resources (id, id_ent, idioma, clave, valor) VALUES (NEXTVAL FOR spac_sq_id_entidadesresources, 202, 'es', 'TOTAL_GASTOS', 'Total gastos');

--
-- Formulario
--
INSERT INTO spac_ct_aplicaciones (id, nombre, descripcion, clase, pagina, parametros, formateador, ent_principal_id, ent_principal_nombre)
	VALUES (12, 'Subvenci�n', 'Subvenci�n', 'ieci.tdw.ispac.ispaclib.app.GenericSecondaryEntityApp', '/forms/SGS_SUBVENCIONES/Subvenci�n.jsp', '<?xml version=''1.0'' encoding=''ISO-8859-1''?><parameters><entity type=''VALIDATION''><table>SPAC_TBL_013</table><relation type=''FLD''><primary-field>TIPO_SUBVENCION</primary-field><secondary-field>VALOR</secondary-field></relation></entity></parameters>', NULL, 202, 'SGS_SUBVENCIONES');
UPDATE spac_ct_entidades SET frm_edit = 12 WHERE id = 202;

UPDATE spac_ct_aplicaciones SET frm_jsp = '<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/ispac-util.tld" prefix="ispac" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<!-- DEFINICION DE LAS ANCLAS A LOS BLOQUES DE CAMPOS -->
<table border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="select" id="tdlink1" align="center">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:SGS_SUBVENCIONES)" />
</nobr>
</td>
</tr>
</table>

<table width="100%" border="0" class="formtable" cellspacing="0" cellpadding="0">
<tr>
<td><img height="8" src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
<tr>
<td>

<!-- BLOQUE1 DE CAMPOS -->
<div style="display:block" id="block1">
<div id="dataBlock_SGS_SUBVENCIONES" style="position: relative; height: 550px; width: 640px;">
  <div id="label_SGS_SUBVENCIONES:ANIO_PRESUPUESTARIO" style="position: absolute; top: 23px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:ANIO_PRESUPUESTARIO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:ANIO_PRESUPUESTARIO" style="position: absolute; top: 20px; left: 190px;">
<ispac:htmlText property="property(SGS_SUBVENCIONES:ANIO_PRESUPUESTARIO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="10" maxlength="4" tabindex="101">
</ispac:htmlText>
</div>
<div id="label_SGS_SUBVENCIONES:TIPO_SUBVENCION" style="position: absolute; top: 53px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:TIPO_SUBVENCION)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:TIPO_SUBVENCION" style="position: absolute; top: 50px; left: 190px;">
<html:hidden property="property(SGS_SUBVENCIONES:TIPO_SUBVENCION)" />
<nobr>
<ispac:htmlTextImageFrame property="property(TIPO_SUBVENCION_SPAC_TBL_013:SUSTITUTO)" readonly="true" readonlyTag="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="50" id="SEARCH_SGS_SUBVENCIONES_TIPO_SUBVENCION" target="workframe" action="selectSubstitute.do?entity=SPAC_TBL_013" image="img/search-mg.gif" titleKeyLink="title.link.data.selection" imageDelete="img/borrar.gif" titleKeyImageDelete="title.delete.data.selection" styleClassDeleteLink="tdlink" confirmDeleteKey="msg.delete.data.selection" showDelete="true" showFrame="true" width="640" height="480" tabindex="103">
<ispac:parameter name="SEARCH_SGS_SUBVENCIONES_TIPO_SUBVENCION" id="property(SGS_SUBVENCIONES:TIPO_SUBVENCION)" property="VALOR" />
<ispac:parameter name="SEARCH_SGS_SUBVENCIONES_TIPO_SUBVENCION" id="property(TIPO_SUBVENCION_SPAC_TBL_013:SUSTITUTO)" property="SUSTITUTO" />
</ispac:htmlTextImageFrame>
</nobr>
</div>
<div id="label_SGS_SUBVENCIONES:FECHA_CONVOCATORIA" style="position: absolute; top: 23px; left: 352px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:FECHA_CONVOCATORIA)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:FECHA_CONVOCATORIA" style="position: absolute; top: 20px; left: 490px;">
<nobr>
<ispac:htmlTextCalendar property="property(SGS_SUBVENCIONES:FECHA_CONVOCATORIA)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="14" maxlength="10" image=''<%= buttoncalendar %>'' format="dd/mm/yyyy" enablePast="true" tabindex="102">
</ispac:htmlTextCalendar>
</nobr>
</div>
<div id="label_SGS_SUBVENCIONES:DENOMINACION_PROYECTO" style="position: absolute; top: 113px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:DENOMINACION_PROYECTO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:DENOMINACION_PROYECTO" style="position: absolute; top: 110px; left: 190px;">
<ispac:htmlText property="property(SGS_SUBVENCIONES:DENOMINACION_PROYECTO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="80" maxlength="120" tabindex="105">
</ispac:htmlText>
</div>
<div id="label_SGS_SUBVENCIONES:RESUMEN_PROYECTO" style="position: absolute; top: 143px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:RESUMEN_PROYECTO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:RESUMEN_PROYECTO" style="position: absolute; top: 140px; left: 190px;">
<ispac:htmlTextarea property="property(SGS_SUBVENCIONES:RESUMEN_PROYECTO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="2" cols="80" tabindex="106">
</ispac:htmlTextarea>
</div>
<div id="label_SGS_SUBVENCIONES:FECHA_INICIO_EJECUCION" style="position: absolute; top: 183px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:FECHA_INICIO_EJECUCION)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:FECHA_INICIO_EJECUCION" style="position: absolute; top: 180px; left: 190px;">
<nobr>
<ispac:htmlTextCalendar property="property(SGS_SUBVENCIONES:FECHA_INICIO_EJECUCION)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="14" maxlength="10" image=''<%= buttoncalendar %>'' format="dd/mm/yyyy" enablePast="true" tabindex="107">
</ispac:htmlTextCalendar>
</nobr>
</div>
<div id="label_SGS_SUBVENCIONES:FECHA_FIN_EJECUCION" style="position: absolute; top: 183px; left: 354px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:FECHA_FIN_EJECUCION)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:FECHA_FIN_EJECUCION" style="position: absolute; top: 180px; left: 490px;">
<nobr>
<ispac:htmlTextCalendar property="property(SGS_SUBVENCIONES:FECHA_FIN_EJECUCION)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="14" maxlength="10" image=''<%= buttoncalendar %>'' format="dd/mm/yyyy" enablePast="true" tabindex="108">
</ispac:htmlTextCalendar>
</nobr>
</div>
<div id="label_SGS_SUBVENCIONES:DURACION_PROYECTO" style="position: absolute; top: 213px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:DURACION_PROYECTO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:DURACION_PROYECTO" style="position: absolute; top: 210px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:DURACION_PROYECTO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="5" maxlength="2" tabindex="109">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.months"/>
</div>
<div id="label_SGS_SUBVENCIONES:COLECTIVO_DESTINO" style="position: absolute; top: 83px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:COLECTIVO_DESTINO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:COLECTIVO_DESTINO" style="position: absolute; top: 80px; left: 190px;">
<ispac:htmlText property="property(SGS_SUBVENCIONES:COLECTIVO_DESTINO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="80" maxlength="64" tabindex="104">
</ispac:htmlText>
</div>
<div id="label_SGS_SUBVENCIONES:IMPORTE_SOLICITADO" style="position: absolute; top: 243px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:IMPORTE_SOLICITADO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:IMPORTE_SOLICITADO" style="position: absolute; top: 240px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:IMPORTE_SOLICITADO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="17" tabindex="110">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:IMPORTE_CONCEDIDO" style="position: absolute; top: 243px; left: 372px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:IMPORTE_CONCEDIDO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:IMPORTE_CONCEDIDO" style="position: absolute; top: 240px; left: 490px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:IMPORTE_CONCEDIDO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="17" tabindex="111">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:PREVISION_GASTOS" style="position: absolute; top: 273px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:PREVISION_GASTOS)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:PREVISION_GASTOS" style="position: absolute; top: 270px; left: 190px;">
<ispac:htmlTextarea property="property(SGS_SUBVENCIONES:PREVISION_GASTOS)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="2" cols="80" tabindex="112">
</ispac:htmlTextarea>
</div>
<div id="label_SGS_SUBVENCIONES:IMPORTE_GASTOS" style="position: absolute; top: 313px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:IMPORTE_GASTOS)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:IMPORTE_GASTOS" style="position: absolute; top: 310px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:IMPORTE_GASTOS)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="13" tabindex="113">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:APORTACION_AYTO" style="position: absolute; top: 343px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:APORTACION_AYTO)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:APORTACION_AYTO" style="position: absolute; top: 340px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:APORTACION_AYTO)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="17" tabindex="114">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:APORTACION_ENTIDAD" style="position: absolute; top: 373px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:APORTACION_ENTIDAD)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:APORTACION_ENTIDAD" style="position: absolute; top: 370px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:APORTACION_ENTIDAD)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="17" tabindex="115">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:OTRAS_APORTACIONES" style="position: absolute; top: 403px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:OTRAS_APORTACIONES)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:OTRAS_APORTACIONES" style="position: absolute; top: 400px; left: 190px;" class="formsTitleB">
<ispac:htmlText property="property(SGS_SUBVENCIONES:OTRAS_APORTACIONES)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" size="15" maxlength="17" tabindex="116">
</ispac:htmlText>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:TOTAL_APORTACIONES" style="position: absolute; top: 433px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:TOTAL_APORTACIONES)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:TOTAL_APORTACIONES" style="position: absolute; top: 430px; left: 190px;" class="formsTitleB">
<logic:empty name="defaultForm" property="property(SGS_SUBVENCIONES:TOTAL_APORTACIONES)">0</logic:empty>
<logic:notEmpty name="defaultForm" property="property(SGS_SUBVENCIONES:TOTAL_APORTACIONES)">
	<bean:write name="defaultForm" property="property(SGS_SUBVENCIONES:TOTAL_APORTACIONES)" />
</logic:notEmpty>
&nbsp;<bean:message key="common.message.currency"/>
</div>
<div id="label_SGS_SUBVENCIONES:FINALIDAD_SUBVENCION" style="position: absolute; top: 463px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:FINALIDAD_SUBVENCION)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:FINALIDAD_SUBVENCION" style="position: absolute; top: 460px; left: 190px;">
<ispac:htmlTextarea property="property(SGS_SUBVENCIONES:FINALIDAD_SUBVENCION)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="2" cols="80" tabindex="117">
</ispac:htmlTextarea>
</div>
<div id="label_SGS_SUBVENCIONES:OBSERVACIONES" style="position: absolute; top: 503px; left: 10px;" class="formsTitleB">
<nobr>
<bean:write name="defaultForm" property="entityApp.label(SGS_SUBVENCIONES:OBSERVACIONES)" />:</nobr>
</div>
<div id="data_SGS_SUBVENCIONES:OBSERVACIONES" style="position: absolute; top: 500px; left: 190px;">
<ispac:htmlTextarea property="property(SGS_SUBVENCIONES:OBSERVACIONES)" readonly="false" propertyReadonly="readonly" styleClass="input" styleClassReadonly="inputReadOnly" rows="2" cols="80" tabindex="118">
</ispac:htmlTextarea>
</div>
</div>
</div>
</td>
</tr>
<tr>
<td height="15"><img src=''<ispac:rewrite href="img/pixel.gif"/>''/></td>
</tr>
</table>'
, frm_version = 1
WHERE id = 12;

--
-- Reglas
--
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo) VALUES (22, 'InitSubvencionRule', 'Crea e inicializa los datos de una Subvenci�n', 'ieci.tdw.ispac.api.rule.procedures.subvenciones.InitSubvencionRule', 1);
INSERT INTO spac_ct_reglas (id, nombre, descripcion, clase, tipo) VALUES (23, 'StoreSubventionRule', 'Calcula el total de una Subvenci�n cuando se guarda', 'ieci.tdw.ispac.api.rule.procedures.subvenciones.StoreSubventionRule', 1);

--
-- Procedimiento
--
INSERT INTO spac_ct_procedimientos (id, cod_pcd, nombre, id_padre, titulo, objeto, asunto, act_func, mtrs_comp, sit_tlm, url, interesado, tp_rel, org_rsltr, forma_inic, plz_resol, unid_plz, finicio, ffin, efec_silen, fin_via_admin, recursos, fcatalog, autor, estado, nversion, observaciones, lugar_present, cnds_ecnmcs, ingresos, f_cbr_pgo, infr_sanc, calendario, dscr_tram, normativa, cnd_particip, documentacion, grupos_delegacion, cod_sistema_productor, mapeo_rt) 
	VALUES (4, 'PCD-4', 'Concesi�n de subvenci�n', 1, 'Concesi�n de subvenci�n', NULL, 'Concesi�n de subvenci�n
', NULL, NULL, NULL, NULL, NULL, 'INT', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fotocopia DNI
Instancia de solicitud', NULL, '04', '<?xml version="1.0" encoding="ISO-8859-1"?>
<procedure>
	<table name="SGS_SUBVENCIONES">
		<mappings>
			<!-- Mapeos de los datos espec�ficos del expediente -->
			<field name="TIPO_SUBVENCION" value="${xpath:/datos_especificos/tipo_subvencion}"/>
			<field name="RESUMEN_PROYECTO" value="${xpath:/datos_especificos/resumen_proyecto}"/>
		</mappings>
	</table>
</procedure>');

INSERT INTO spac_p_procedimientos (id, id_pcd_bpm, nversion, nombre, estado, id_group, ts_crt, ts_upd) 
VALUES (4, '4', 1, 'Concesi�n de subvenci�n', 2, 4, current date, current date);

--
-- Nodos
--
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (10, '10', 4, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (11, '11', 4, 1, NULL);
INSERT INTO spac_p_nodos (id, id_nodo_bpm, id_pcd, tipo, g_info) VALUES (12, '12', 4, 1, NULL);

--
-- Fases
--
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (10, 1, 4, 'Fase Inicio');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (11, 2, 4, 'Fase Instrucci�n');
INSERT INTO spac_p_fases (id, id_ctfase, id_pcd, nombre) VALUES (12, 3, 4, 'Fase Terminaci�n');

--
-- Flujos
--
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (13, '13', 4, 10, 11);
INSERT INTO spac_p_flujos (id, id_flujo_bpm, id_pcd, id_origen, id_destino) VALUES (14, '14', 4, 11, 12);

--
-- Tr�mites
--
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (15, '15', 14, 4, 10, 'Solicitud subsanaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (16, '16', 12, 4, 11, 'Propuesta de resoluci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (17, '17', 15, 4, 11, 'Acuerdo Consejo de Gobierno', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (18, '18', 10, 4, 11, 'Notificaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (19, '19', 2, 4, 11, 'Alegaciones', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (20, '20', 6, 4, 12, 'Decreto de concesi�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (21, '21', 10, 4, 12, 'Notificaci�n', 0, NULL, NULL, null);
INSERT INTO spac_p_tramites (id, id_tramite_bpm, id_cttramite, id_pcd, id_fase, nombre, libre, id_resp, id_resp_sec, id_pcd_sub) VALUES (22, '22', 3, 4, 12, 'Archivo del expediente', 0, NULL, NULL, null);

--
-- Eventos
--
INSERT INTO spac_p_eventos (id_obj, tp_obj, evento, orden, id_regla) VALUES (4, 1, 32, 10, 22);
INSERT INTO spac_p_eventos (id_obj, tp_obj, evento, orden, id_regla) VALUES (24, 5, 12, 12, 23);

--
-- Entidades
--
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (15, 1, 4, 0, 1, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (16, 7, 4, 1, 3, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (17, 3, 4, 1, 4, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (18, 2, 4, 1, 24, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (24, 202, 4, 0, 2, NULL);
INSERT INTO spac_p_entidades (id, id_ent, id_pcd, tp_rel, orden, frm_edit) VALUES (28, 8, 4, 1, 5, NULL);

--
-- Permisos
--
--INSERT INTO spac_ss_permisos (id, id_pcd, uid_usr, permiso) VALUES (4, 4, '2-1', 1);


---------------------------
-- ACTUALIZAR SECUENCIAS --
---------------------------

ALTER SEQUENCE spac_sq_id_ctentidades RESTART WITH 203;
ALTER SEQUENCE spac_sq_id_ctaplicaciones RESTART WITH 13;
ALTER SEQUENCE spac_sq_id_ctreglas RESTART WITH 24;
ALTER SEQUENCE spac_sq_id_pprocedimientos RESTART WITH 6;
ALTER SEQUENCE spac_sq_id_pnodos RESTART WITH 17;
--ALTER SEQUENCE spac_sq_id_pfases RESTART WITH 17;
ALTER SEQUENCE spac_sq_id_pflujos RESTART WITH 20;
ALTER SEQUENCE spac_sq_id_ptramites RESTART WITH 39;
ALTER SEQUENCE spac_sq_id_peventos RESTART WITH 100;
ALTER SEQUENCE spac_sq_id_pentidades RESTART WITH 50;
ALTER SEQUENCE spac_sq_id_sspermisos RESTART WITH 6;
