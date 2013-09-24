--/***************************/
--/* Versi�n 4.2             */
--/***************************/

    -- Insertar la versi�n actual de bd
    INSERT INTO AGINFOSISTEMA (AUTID,NOMBRE,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','4.0->4.2',SYSDATE);

    -- Establecer el id de motivo en consultas como nulo
    ALTER TABLE ASGPCONSULTA MODIFY IDMOTIVO VARCHAR2(32) NULL;

    -- Establecer el motivo en consultas como nulo
    ALTER TABLE ASGPCONSULTA MODIFY MOTIVO VARCHAR2(32) NULL;

    -- Establecer el id de motivo en pr�stamos como nulo
    ALTER TABLE ASGPPRESTAMO MODIFY IDMOTIVO VARCHAR2(32) NULL;
COMMIT;