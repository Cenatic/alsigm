-----------------------------------------------------------------
-- Actualizaci�n de recursos de las entidad de expedientes en ca
-----------------------------------------------------------------

-- Entidad EXPEDIENTES
UPDATE spac_ct_entidades_resources set valor='Data d''Apertura' where id_ent=1 AND idioma='ca' and clave='FAPERTURA';
UPDATE spac_ct_entidades_resources set valor='Data d''inici Termini' where id_ent=1 AND idioma='ca' and clave='FINICIOPLAZO';
UPDATE spac_ct_entidades_resources set valor='Forma de Terminaci�' where id_ent=1 AND idioma='ca' and clave='FORMATERMINACION';
UPDATE spac_ct_entidades_resources set valor='N�m. de Registre' where id_ent=1 AND idioma='ca' and clave='NREG';
UPDATE spac_ct_entidades_resources set valor='N�m. d''Expedient' where id_ent=1 AND idioma='ca' and clave='NUMEXP';
