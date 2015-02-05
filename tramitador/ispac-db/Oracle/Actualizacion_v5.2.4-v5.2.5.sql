-----------------------------------
-- Actualizaci�n de v5.2.4 a v5.2.5
-----------------------------------

--
-- Informaci�n de versi�n
--

INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (SPAC_SQ_ID_INFOSISTEMA.NEXTVAL, 'VERSIONBD', '5.2.5', current_timestamp);
INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (SPAC_SQ_ID_INFOSISTEMA.NEXTVAL, 'VERSIONAPP', '5.2.5', current_timestamp);


--
-- �� ATENCI�N !!
--
-- En los scripts de instalaci�n de la base de datos nueva, se han
-- actualizado los formularios de las entidades de EXPEDIENTES e
-- INTERVINIENTES en la tabla SPAC_CT_APLICACIONES.
--
-- Como las sentencias de actualizaci�n dan error por ser el texto
-- demasiado grande, habr� que hacer una actualizaci�n de estos
-- dos formularios a mano: 
--
-- Formulario para expedientes
--
--     Actualizacion_v5.2.4-v5.2.5_Files\expedientForm.jsp 
--         --> SPAC_CT_APLICACIONES.FRM_JSP cuando id=1;
--
-- Formulario para intervinientes
--
--     Actualizacion_v5.2.4-v5.2.5_Files\thirdForm.jsp
--         --> SPAC_CT_APLICACIONES.FRM_JSP cuando id=3;
--