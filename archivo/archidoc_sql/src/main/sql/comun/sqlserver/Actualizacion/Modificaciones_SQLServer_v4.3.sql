-- /***************************/
-- /* Actualizaci�n 4.2->4.3  */
-- /***************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (NOMBRE,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','4.2->4.3',getdate());
	GO

	--A�adir columna MARCASBLOQUEO
	ALTER TABLE ASGTUNIDADDOCRE ADD MARCASBLOQUEO INT NOT NULL DEFAULT 0;
	GO

	--A�adir columna MARCASBLOQUEO
	ALTER TABLE ASGFUNIDADDOC ADD MARCASBLOQUEO INT NOT NULL DEFAULT 0;
	GO