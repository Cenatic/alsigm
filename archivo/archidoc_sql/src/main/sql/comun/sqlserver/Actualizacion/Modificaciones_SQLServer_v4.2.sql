-- /***************************/
-- /* Actualizaci�n 4.0->4.2  */
-- /***************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (NOMBRE,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','4.0->4.2',getdate());
	GO

	-- Establecer el id de motivo en consultas como nulo
	ALTER TABLE ASGPCONSULTA ALTER COLUMN IDMOTIVO VARCHAR(32) NULL;
	GO

	-- Establecer el motivo en consultas como nulo
	ALTER TABLE ASGPCONSULTA ALTER COLUMN MOTIVO VARCHAR(32) NULL;
	GO

	-- Establecer el id de motivo en pr�stamos como nulo
	ALTER TABLE ASGPPRESTAMO ALTER COLUMN IDMOTIVO VARCHAR(32) NULL;
	GO