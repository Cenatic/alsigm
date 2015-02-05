
/******************************************************************************************************
 * Versi�n 2.0.1																																						            *
 ******************************************************************************************************/

-- Eliminar indices �nicos de productores de serie y crear los �ndices sin unicidad

	DROP INDEX ASGFPRODSERIE1 ON ASGFPRODSERIE;
	DROP INDEX ASGFPRODSERIE2 ON ASGFPRODSERIE;

	CREATE INDEX ASGFPRODSERIE1 ON ASGFPRODSERIE (IDSERIE);
	CREATE INDEX ASGFPRODSERIE2 ON ASGFPRODSERIE (IDSERIE, IDPROCEDIMIENTO);

/******************************************************************************************************
 * Versi�n 2.1																																						            *
 ******************************************************************************************************/
 
 -- A�adir un nuevo campo documental en ADDESCRIPTOR con el nombre del descriptor
 

	-- A�adir un id documental �nico
	ALTER TABLE addescriptor ADD IDDOCUMENTAL  BIGINT IDENTITY (1, 1) NOT NULL ;
	GO

	-- Definici�n de b�squeda documental sobre la tabla ADDESCRIPTOR
	CREATE UNIQUE INDEX ID_ADDESCRIPTOR ON ADDESCRIPTOR(IDDOCUMENTAL);
	execute sp_fulltext_table 'ADDESCRIPTOR','create','ARCHIVOCTLG','ID_ADDESCRIPTOR'; 
	execute sp_fulltext_column 'ADDESCRIPTOR', 'NOMBRE', 'add', '3082';  
	execute sp_fulltext_table 'ADDESCRIPTOR','start_change_tracking'; 
	execute sp_fulltext_table 'ADDESCRIPTOR','start_background_updateindex';  

	 -- Crear una tabla de informaci�n del sistema
	CREATE TABLE dbo.AGINFOSISTEMA ( 
		ID 	VARCHAR (16) NOT NULL,
		VALOR VARCHAR (16) NOT NULL,
		FECHAACTUALIZACION DATETIME NOT NULL
	);
	
 	-- Crear un �ndice �nico en el id
 	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(ID);
  
	  
 	-- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.2',getdate());

/******************************************************************************************************
 * Versi�n 2.1.1																																					            *
 ******************************************************************************************************/

	-- Modificar la tabla de informaci�n del sistema para guardar hist�rico de versiones
	ALTER TABLE AGINFOSISTEMA ADD AUTID int IDENTITY(1,2);
	GO
	
	-- Eliminar �ndice de la tabla	
	DROP INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA;
	
	-- Crear un �ndice �nico en el id autonum�rico
	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(AUTID);

	-- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.1.1',getdate());

/******************************************************************************************************
 * Versi�n 2.2																																					            *
 ******************************************************************************************************/

	-- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.2',getdate());

	-------------------------------------------
	-- TIPOS DE ELEMENTOS
	-------------------------------------------

	--A�adir el Campo CARACTERORDEN para componer la ordenaci�n de los huecos. 
	ALTER TABLE ASGDTIPOELEMENTO ADD CARACTERORDEN CHAR(1) NOT NULL DEFAULT ' ';
	GO

	--Inicializar el valor del campo CARACTERORDEN con la primera letra del campo NOMBRE
	UPDATE ASGDTIPOELEMENTO SET CARACTERORDEN = LEFT(NOMBRE,1);

	--A�adir el Campo TIPOORD a la tabla de tipos de elemento
	ALTER TABLE ASGDTIPOELEMENTO ADD TIPOORD SMALLINT NOT NULL DEFAULT 1;
	GO

	--Actualizar el tipo de elemento balda para que tenga la ordenaci�n jer�rquica
	UPDATE ASGDTIPOELEMENTO SET TIPOORD=2 WHERE ID='00000000000000000000000000000004';
	
	-------------------------------------------
	-- ELEMENTOS NO ASIGNABLES
	-------------------------------------------

	--A�adir la columna CODORDEN
	ALTER TABLE ASGDELEMNOASIG ADD CODORDEN VARCHAR(50) NOT NULL DEFAULT ' ';
	GO

	-- Actualizar los elementos no asignables con el CODORDEN que les corresponde
	DECLARE @separador VARCHAR(1);
	DECLARE @numPosiciones INT;
	
	SET @separador = '_';
	SET @numPosiciones = 4;
	
	DECLARE @caracter CHAR(1);
	DECLARE @tipoElemento VARCHAR(32);
	
	
	--02 Dep�sito
	SET @tipoElemento = '00000000000000000000000000000002';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	UPDATE ASGDELEMNOASIG SET CODORDEN = @caracter + REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(NUMORDEN)))) +LTRIM(STR(NUMORDEN)) FROM ASGDELEMNOASIG WHERE IDTIPOELEMENTO = @tipoElemento;
	
	
	--03 Estanter�a
	SET @tipoElemento = '00000000000000000000000000000003';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMNOASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento AND
		  ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;
	
	
	--07 Cuerpo
	SET @tipoElemento = '00000000000000000000000000000007';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMNOASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento AND
		  ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;
	
	
	--05 Planero
	SET @tipoElemento = '00000000000000000000000000000005';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMNOASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento AND
		  ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;	
	
	
	--08 Armario Fichero
	SET @tipoElemento = '00000000000000000000000000000008';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMNOASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento AND
		  ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;	

	-- Crear el �ndice necesario
	CREATE UNIQUE INDEX ASGDELEMNOASIG3 ON ASGDELEMNOASIG (CODORDEN, IDDEPOSITO);

	-------------------------------------------
	-- ELEMENTOS ASIGNABLES
	-------------------------------------------

	-- Actualizar los elementos asignables con el CODORDEN que les corresponde

	--A�adir la columna CODORDEN
	ALTER TABLE ASGDELEMASIG ADD CODORDEN VARCHAR(50) NOT NULL DEFAULT ' ';
	GO
	
	DECLARE @separador VARCHAR(1);
	DECLARE @numPosiciones INT;
	DECLARE @caracter CHAR(1);
	DECLARE @tipoElemento VARCHAR(32);
	
	SET @separador = '_';
	SET @numPosiciones = 4;
	
	
	--04 Balda
	SET @tipoElemento = '00000000000000000000000000000004';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;

	
	UPDATE ASGDELEMASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDELEMNAPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento 
		 AND ASGDELEMASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;
	
	
	-- 06 Caj�n Planero
	SET @tipoElemento = '00000000000000000000000000000006';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDELEMNAPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento 
		 AND ASGDELEMASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;
	
	
	-- 09 FICHERO
	SET @tipoElemento = '00000000000000000000000000000009';
	SELECT @caracter = CARACTERORDEN FROM ASGDTIPOELEMENTO WHERE ID=@tipoElemento;
	
	UPDATE ASGDELEMASIG SET CODORDEN =
	(SELECT padre.CODORDEN +
		   @separador + @caracter + 
		   REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(elemento.NUMORDEN)))) +LTRIM(STR(elemento.NUMORDEN))
	FROM ASGDELEMASIG elemento, ASGDELEMNOASIG padre
	WHERE elemento.IDELEMNAPADRE = padre.ID AND
		  elemento.IDTIPOELEMENTO = @tipoElemento 
		 AND ASGDELEMASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO = @tipoElemento;

	-- Crear el �ndice necesario
	CREATE UNIQUE INDEX ASGDELEMASIG4 ON ASGDELEMASIG (CODORDEN, IDDEPOSITO);

	-------------------------------------------
	-- HUECOS
	-------------------------------------------

	--A�adir el Campo TIPOORD a la tabla de huecos.
	ALTER TABLE ASGDHUECO ADD TIPOORD SMALLINT NOT NULL DEFAULT 1;
	GO

	--Actualizar todos los huecos de baldas para que tengan la ordenaci�n jer�rquica
	UPDATE ASGDHUECO SET TIPOORD=2 WHERE IDELEMAPADRE IN (
		SELECT h.IDELEMAPADRE FROM ASGDHUECO h, ASGDELEMASIG e
			WHERE e.IDTIPOELEMENTO='00000000000000000000000000000004' AND
		 	e.id=h.IDELEMAPADRE);

	--A�adir el Campo CODORDEN a la tabla de HUECOS
	ALTER TABLE ASGDHUECO ADD CODORDEN VARCHAR(50) NOT NULL DEFAULT ' ';
	GO

	DECLARE @separador VARCHAR(1);
	DECLARE @numPosiciones INT;
	DECLARE @caracter CHAR(1);
	DECLARE @tipoElementoBalda VARCHAR(32);
	
	Set @caracter = 'H';
	SET @separador= '_';
	set @numPosiciones = 4;
	set @tipoElementoBalda = '00000000000000000000000000000004';
	
	--Obtenci�n del C�digo de orden para los elementos con ordenaci�n 1
	UPDATE ASGDHUECO SET CODORDEN =
	(
	SELECT padre.CODORDEN + @separador + @caracter  
			+REPLICATE('0',@numPosiciones-LEN(LTRIM(STR(hueco.NUMORDEN)))) +LTRIM(STR(hueco.NUMORDEN))
	FROM ASGDHUECO hueco, ASGDELEMASIG padre
	WHERE hueco.IDELEMAPADRE = padre.ID AND
		  ASGDHUECO.IDELEMAPADRE = hueco.IDELEMAPADRE AND
		  ASGDHUECO.NUMORDEN = hueco.NUMORDEN 
	)
	WHERE IDELEMAPADRE IN 
	(	
		SELECT ID FROM ASGDELEMASIG WHERE IDTIPOELEMENTO != @tipoElementoBalda
	)
	
	--Obtenci�n de C�digo de Orden de los Huecos que tienen ordenaci�n 2
	UPDATE ASGDHUECO SET CODORDEN =
	(
	SELECT 	LEFT(abuelo.CODORDEN,
				LEN(abuelo.CODORDEN)-@numPosiciones -1) +
			RIGHT(padre.CODORDEN,
				@numPosiciones +1
				) +
		    RIGHT(abuelo.CODORDEN,
				@numPosiciones +2
				) + @separador +
			@caracter + REPLICATE('0',@numPosiciones - LEN(hueco.NUMORDEN)) + LTRIM(STR(hueco.NUMORDEN))
	FROM	ASGDELEMNOASIG abuelo
			,ASGDELEMASIG padre,
			ASGDHUECO hueco 
	WHERE 
			abuelo.ID = padre.IDELEMNAPADRE AND
			padre.ID = hueco.IDELEMAPADRE AND
			ASGDHUECO.IDELEMAPADRE = hueco.IDELEMAPADRE AND
			ASGDHUECO.NUMORDEN = hueco.NUMORDEN 
	)
	WHERE IDELEMAPADRE IN 
	(	
		SELECT ID FROM ASGDELEMASIG WHERE IDTIPOELEMENTO = @tipoElementoBalda
	)

	-- Crear los �ndices necesarios
	CREATE INDEX ASGDHUECO7 ON ASGDHUECO (CODORDEN, TIPOORD);
	CREATE UNIQUE INDEX ASGDHUECO8 ON ASGDHUECO (CODORDEN, IDDEPOSITO);

	-------------------------------------------
	-- RELACIONES DE ENTREGA
	-------------------------------------------

	--A�adir el campo de tipo de elemento.
	ALTER TABLE ASGTRENTREGA ADD IDTIPOELMTODRESERVA VARCHAR(32);
	GO

	-- Actualizar el valor del tipo
	UPDATE ASGTRENTREGA 
	SET IDTIPOELMTODRESERVA = (
		SELECT elemento.IDTIPOELEMENTO	
		FROM ASGDELEMNOASIG elemento
		WHERE elemento.ID = ASGTRENTREGA.IDENARESERVA
	);

	--Renombrar el nombre de la Columna
	EXEC sp_rename 
		@objname = 'ASGTRENTREGA.IDENARESERVA', 
		@newname = 'IDELMTODRESERVA', 
		@objtype = 'COLUMN';
		
		
	
/******************************************************************************************************
 * Versi�n 2.2.1																																					            *
 ******************************************************************************************************/
	-- Insertar la versi�n actual de bd
	DROP INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA;
	DROP INDEX AGINFOSISTEMA2 ON AGINFOSISTEMA;
	ALTER TABLE AGINFOSISTEMA DROP COLUMN AUTID;	
	ALTER TABLE AGINFOSISTEMA ADD AUTID int IDENTITY(1,2);
	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(AUTID);
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.2.1',getdate());
	
	--Modificado el tama�o de la columna para coincida con ASGTUDOCENUI
	ALTER TABLE ASGDUDOCENUI ALTER COLUMN DESCRIPCION VARCHAR(254);	
	GO
	
	--Modificado el tama�o de DESCRIPCION de la tabla ASCALISTCA
	ALTER TABLE ASCALISTCA ALTER COLUMN DESCRIPCION VARCHAR(512);	
	GO
	
	--Modificada la tabla de valoraciones para a�adir la columna de informaci�n de la serie en el momento de fin de ciclo de vida de la valoraci�n
	ALTER TABLE ASGFVALSERIE ADD INFOSERIE TEXT;
	GO
	
/******************************************************************************************************/
/* Versi�n 2.3 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.3',getdate());
	GO
	
	-- Crear la tabla de niveles de archivo
	CREATE TABLE dbo.AGNIVELARCHIVO(
	   ID VARCHAR(32) NOT NULL,
	   NOMBRE VARCHAR(64) NOT NULL,
	   DESCRIPCION VARCHAR(254),
	   ORDEN SMALLINT NOT NULL);
	GO
	   
	-- Crear los �ndices de la tabla de niveles de archivo
	CREATE UNIQUE INDEX AGNIVELARCHIVO01 ON AGNIVELARCHIVO(ID);
	CREATE INDEX AGNIVELARCHIVO02 ON AGNIVELARCHIVO(ORDEN);
	
	-- A�adir columna IDNIVEL en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD IDNIVEL  VARCHAR(32);
	GO
	
	-- A�adir columna IDRECEPTORDEFECTO en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD IDRECEPTORDEFECTO VARCHAR(32);
	GO
	
	-- Inserci�n del Nivel de Archivo Central.
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN) 
        VALUES ('00000000000000000000000000000001', 'Central','Archivo Central',1);
	GO
	        
        -- Actualizaci�n del Archivo de la Aplicaci�n para que tenga nivel Principal.
	UPDATE AGARCHIVO SET IDNIVEL = '00000000000000000000000000000001' WHERE ID='o0000000000000000000000010003916';
	GO
		
	-- La columna IDNIVEL en AGARCHIVO no puede ser nula.
	ALTER TABLE AGARCHIVO ALTER COLUMN IDNIVEL VARCHAR(32) NOT NULL;
	GO
	
    	-- A�adir el campo IDARCHIVO en la tabla ASGDDEPOSITO
    	ALTER TABLE ASGDDEPOSITO ADD IDARCHIVO VARCHAR(32);
    	GO
    	
    	--Actualizar los dep�sitos existentes al archivo por defecto
    	UPDATE ASGDDEPOSITO SET IDARCHIVO = 'o0000000000000000000000010003916';
	GO
	    
    	--Poner la columna IDARCHIVO para que no pueda ser nula.
	ALTER TABLE ASGDDEPOSITO ALTER COLUMN IDARCHIVO VARCHAR(32) NOT NULL;
	GO
	
	-- Rellenar los datos nulos de la columna FECHAESTADO de la tabla ASGFSERIE
	UPDATE ASGFSERIE SET FECHAESTADO = CONVERT(datetime,'2001-01-01',120) WHERE FECHAESTADO IS NULL;
	GO
		
	-- Modificar el campo FECHAESTADO de la tabla ASGFSERIE para que no pueda tener valor nulo
	ALTER TABLE ASGFSERIE ALTER COLUMN FECHAESTADO DATETIME NOT NULL;	
	GO
	
	-- A�adir columna IDARCHIVO en ASGTNSEC
	ALTER TABLE ASGTSNSEC ADD IDARCHIVO  VARCHAR(32);
	GO
	
	--Eliminado el Indice unico de ASGTSNSEC1 para modificarlo
	DROP INDEX ASGTSNSEC1 ON ASGTSNSEC;
	GO
	
    	--Actualizar en la tabla ASGTSNSEC el id de archivo
    	UPDATE ASGTSNSEC SET IDARCHIVO = 'o0000000000000000000000010003916';
	GO

	--Poner la columna IDARCHIVO para que no pueda ser nula.
	ALTER TABLE ASGTSNSEC ALTER COLUMN IDARCHIVO VARCHAR(32) NOT NULL;
	GO
		
	--Creado el �ndice de nuevo para meter el IDARCHIVO
	CREATE UNIQUE INDEX ASGTSNSEC1 ON ASGTSNSEC (TIPO, ANO, IDARCHIVO);	
	GO
	
	-- Crear la tabla ASGTUINSTALACIONREEA
	CREATE TABLE dbo.ASGTUINSTALACIONREEA(
	   IDUIDEPOSITO VARCHAR(32) NOT NULL,
	   IDRELENTREGA VARCHAR(32) NOT NULL,
	   ORDEN SMALLINT NOT NULL,
	   IDFORMATO VARCHAR(32) NOT NULL,
	   ESTADOCOTEJO SMALLINT NOT NULL,
	   NOTASCOTEJO VARCHAR(254),
	   DEVOLUCION CHAR(1) NOT NULL,
	   PATHDEPOSITOORIGEN VARCHAR(512) NOT NULL);
	GO
	
	-- Crear los �ndices para ASGTUINSTALACIONREEA
	CREATE INDEX ASGTUINSTALACIONREEA1 ON ASGTUINSTALACIONREEA (IDUIDEPOSITO);
	CREATE INDEX ASGTUINSTALACIONREEA2 ON ASGTUINSTALACIONREEA (IDRELENTREGA);
		   
	-- A�adir columna IDARCHIVOREMITENTE en ASGTPREVISION
	ALTER TABLE ASGTPREVISION ADD IDARCHIVOREMITENTE VARCHAR(32);
	GO
		
	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTPREVISION
	EXEC sp_rename 
		@objname = 'ASGTPREVISION.IDFONDO', 
		@newname = 'IDFONDODESTINO', 
		@objtype = 'COLUMN';
	GO		
		
	-- A�adir columna IDSERIEORIGEN en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD IDSERIEORIGEN VARCHAR(32);
	GO
	
	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTDETALLEPREV
	EXEC sp_rename 
		@objname = 'ASGTDETALLEPREV.IDSERIE', 
		@newname = 'IDSERIEDESTINO', 
		@objtype = 'COLUMN';
	GO
		
	-- A�adir columna INFO en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD INFO VARCHAR(1024);		
	GO
		
	-- A�adir columna IDARCHIVOREMITENTE en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD IDARCHIVOREMITENTE VARCHAR(32);
	GO
		
	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTRENTREGA
	EXEC sp_rename 
		@objname = 'ASGTRENTREGA.IDFONDO', 
		@newname = 'IDFONDODESTINO', 
		@objtype = 'COLUMN';	
	GO
		
	-- Renombrar columna IDUSRGESTORARCHIVO a IDUSRGESTORARCHIVOREC en ASGTRENTREGA
	EXEC sp_rename 
		@objname = 'ASGTRENTREGA.IDUSRGESTORARCHIVO', 
		@newname = 'IDUSRGESTORARCHIVOREC', 
		@objtype = 'COLUMN';	
	GO
	
	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTRENTREGA
	EXEC sp_rename 
		@objname = 'ASGTRENTREGA.IDSERIE', 
		@newname = 'IDSERIEDESTINO', 
		@objtype = 'COLUMN';		
	GO
	
	-- A�adir columna IDFONDOORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD IDFONDOORIGEN VARCHAR(32);
	GO
		
	-- A�adir columna IDSERIEORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD IDSERIEORIGEN VARCHAR(32);	
	GO
		
	-- A�adir columna MARCASBLOQUEO en ASGDUINSTALACION
	ALTER TABLE ASGDUINSTALACION ADD MARCASBLOQUEO INT DEFAULT 0;
	GO
	
	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que contenga el valor 0
	UPDATE ASGDUINSTALACION SET MARCASBLOQUEO = 0;
	GO
	
	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que no sea nulable	
	ALTER TABLE ASGDUINSTALACION ALTER COLUMN MARCASBLOQUEO INT NOT NULL;
	GO
		
	-- A�adir columna IDARCHIVO en ASGTNSECUI
	ALTER TABLE ASGTSNSECUI ADD IDARCHIVO VARCHAR(32);
	GO
	
	-- A�adir columna SIGNATURAUI en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD SIGNATURAUI VARCHAR(16);	
	GO
		
	-- A�adir columna IDARCHIVO en ASGFELIMSERIE
	ALTER TABLE ASGFELIMSERIE ADD IDARCHIVO VARCHAR(32);	
	GO
		
	-- Actualizar las eliminaciones al archivo por defecto
    	UPDATE ASGFELIMSERIE SET IDARCHIVO = 'o0000000000000000000000010003916';
	GO
	    
    	--Poner la columna IDARCHIVO en ASGFELIMSERIE para que no pueda ser nula.
    	ALTER TABLE ASGFELIMSERIE ALTER COLUMN IDARCHIVO VARCHAR(32) NOT NULL;		
	GO    		

	-- Eliminar el �ndice �nico de identificaci�n en ASGDUINSTALACION
	DROP INDEX ASGDUINSTALACION3 ON ASGDUINSTALACION;
	CREATE INDEX ASGDUINSTALACION3 ON ASGDUINSTALACION (IDENTIFICACION);
	GO
	
	-- Eliminar el �ndice �nico de identificaci�n en ASGDUDOCENUI	
	DROP INDEX ASGDUDOCENUI1 ON ASGDUDOCENUI;
	CREATE INDEX ASGDUDOCENUI1 ON ASGDUDOCENUI (IDENTIFICACION);	
	GO

	-- A�adir columnas identificativas del hueco origen de la unidad instalaci�n incluida en una relaci�n de entrega entre archivos
	ALTER TABLE ASGTUINSTALACIONREEA ADD IDELEMAPADREHUECOORIGEN VARCHAR(32) NOT NULL,
									NUMORDENHUECOORIGEN SMALLINT NOT NULL;
	GO

	-- Crear tabla para el n�mero secuencial de unidad documental
	CREATE TABLE dbo.ASGTSNSECUDOC( 
	  NUMSEC  INT NOT NULL
	) ; 
	GO

	-- A�adir columna SIGNATURAUIORIGEN en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD SIGNATURAUIORIGEN VARCHAR(16);	
	GO

/******************************************************************************************************/
/* Versi�n 2.3.1 */
/******************************************************************************************************/
	
	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.3.1',getdate());
	GO

	--A�adido Campo de Nombre Corto al Archivo, para las cartelas de los informes
	ALTER TABLE AGARCHIVO ADD NOMBRECORTO VARCHAR(25);
	GO
	
	--Se Actualiza el valor del NOMBRECORTO a ARCHIVO GENERAL ya que era como estaba en fichero de resources.
	UPDATE AGARCHIVO SET NOMBRECORTO='ARCHIVO GENERAL';

	--Modificaci�n de la column NOMBRECORTO para que no sea nula.
	ALTER TABLE AGARCHIVO ALTER COLUMN NOMBRECORTO VARCHAR(25) NOT NULL;
	GO

	--Poner como decimal la longitud del formato
	ALTER TABLE AGFORMATO ALTER COLUMN LONGITUD FLOAT;

	--Poner como decimal la longitud del elemento asignable
	ALTER TABLE ASGDELEMASIG ALTER COLUMN LONGITUD FLOAT NOT NULL;

	-- Crear un �ndice en ADVCREFCF para acelerar b�squedas	
	CREATE INDEX ADVCREFCF5   ON ADVCREFCF (IDOBJREF );
	
/******************************************************************************************************/
/* Versi�n 2.4 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.4',getdate());
	GO

	-- A�adir las columnas de tipo de entrega, datos de usuario autorizado y datos de solicitante a las tablas de pr�stamo y consulta
	ALTER TABLE ASGPCONSULTA ADD TIPOENTREGA VARCHAR(254) NULL;
	ALTER TABLE ASGPCONSULTA ADD DATOSAUTORIZADO VARCHAR(254) NULL;
	ALTER TABLE ASGPCONSULTA ADD DATOSSOLICITANTE VARCHAR(512) NULL;
	GO

	ALTER TABLE ASGPPRESTAMO ADD TIPOENTREGA VARCHAR(254) NULL;
	ALTER TABLE ASGPPRESTAMO ADD DATOSAUTORIZADO VARCHAR(254) NULL;
	ALTER TABLE ASGPPRESTAMO ADD DATOSSOLICITANTE VARCHAR(512) NULL;
	GO

	-- Insertar tabla de validaci�n y lista de valores para los tipos de entrega de pr�stamos y consultas
	INSERT INTO ADCTLGTBLVLD (ID, NOMBRE, DESCRIPCION, USOINTERNO ) VALUES ('ID_TBLVLD_TIPOS_ENTREGA', 'Tipo de entrega', null, 'S');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('135','Fax', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('136','CD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('137','DVD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('138','Originales', 'ID_TBLVLD_TIPOS_ENTREGA');
	GO

	--A�adir Campo que indica si se corrigen los errores en archivo.
	ALTER TABLE ASGTRENTREGA ADD CORRECCIONENARCHIVO CHAR(1) NOT NULL DEFAULT 'N';
	GO

 	-- Insertar en la tabla ASGFPRODSERIE el campo MARCAS
  	ALTER TABLE ASGFPRODSERIE ADD MARCAS INT DEFAULT 0;
  
  
	UPDATE AGARCHIVO SET CODIGO ='AACF',
					NOMBRE='SECCI�N DE GESTION DEL PATRIMONIO DOCUMENTAL',
					IDNIVEL='00000000000000000000000000000003',
					IDRECEPTORDEFECTO=NULL,	
					NOMBRECORTO = 'ARCHIVO GENERAL'
	WHERE ID = 'o0000000000000000000000010003916'
	
	UPDATE AGNIVELARCHIVO SET 
						NOMBRE = 'Oficina',
						DESCRIPCION = 'Archivo de Oficina',
						ORDEN = 1
	WHERE ID = '00000000000000000000000000000001'
	
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN) VALUES ('00000000000000000000000000000002', 'Central','Archivo Central',2);
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN) VALUES ('00000000000000000000000000000003', 'General','Archivo General',3);
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN) VALUES ('00000000000000000000000000000004', 'Hist�rico','Archivo Hist�rico',4);
	
	UPDATE ASCAGRUPO SET NOMBRE =  'Personal de archivo GENERAL',
						IDARCHIVO = 'o0000000000000000000000010003916',
						DESCRIPCION = 'Grupo para el personal de archivo GENERAL'
	WHERE ID = 'g0000000000000000000000000000001';
