/******************************************************************************************************
 * Versi�n 2.0.1*
 ******************************************************************************************************/

-- Eliminar indices �nicos de productores de serie y crear los �ndices sin unicidad

	DROP INDEX ASGFPRODSERIE1;
        DROP INDEX ASGFPRODSERIE2;

        CREATE INDEX ASGFPRODSERIE1 ON ASGFPRODSERIE (IDSERIE);
	CREATE INDEX ASGFPRODSERIE2 ON ASGFPRODSERIE (IDSERIE, IDPROCEDIMIENTO);


/******************************************************************************************************
 * Versi�n 2.1*
 ******************************************************************************************************/

 -- A�adir un nuevo campo documental en ADDESCRIPTOR con el nombre del descriptor

	-- Definici�n de b�squeda documental sobre la tabla ADDESCRIPTOR
	ALTER TABLE ADDESCRIPTOR ADD COLUMN idxnombre tsvector;

	UPDATE ADDESCRIPTOR SET idxnombre=to_tsvector('default_spanish', "nombre");
	VACUUM FULL ANALYZE;

	CREATE INDEX idxnombre_addescriptor_idx ON ADDESCRIPTOR USING gist(idxnombre);
	VACUUM FULL ANALYZE;

	CREATE TRIGGER idxnombre_addescriptor_trigger BEFORE UPDATE OR INSERT ON ADDESCRIPTOR
	FOR EACH ROW EXECUTE PROCEDURE tsearch2(idxnombre,"nombre");

 -- Crear una tabla de informaci�n del sistema
	CREATE TABLE AGINFOSISTEMA (
		ID 	VARCHAR (16) NOT NULL,
		VALOR VARCHAR (16) NOT NULL,
		FECHAACTUALIZACION TIMESTAMP NOT NULL
	);

 -- Crear un �ndice �nico en el id
	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(ID);


 -- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.1',now());

/******************************************************************************************************
 * Versi�n 2.1.1*
 ******************************************************************************************************/

-- Modificar la tabla de informaci�n del sistema para guardar hist�rico de versiones
	CREATE SEQUENCE SEQ_INFO
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 100000000000
	START 1;

	ALTER TABLE AGINFOSISTEMA ADD COLUMN AUTID INTEGER DEFAULT nextval('SEQ_INFO'::regclass);

	DROP INDEX AGINFOSISTEMA1;

    -- Crear un �ndice �nico en el id autonum�rico
	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(AUTID);

 -- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.1.1',now());


/******************************************************************************************************
 * Versi�n 2.2*
 ******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.2',now());

	-------------------------------------------
	-- TIPOS DE ELEMENTOS
	-------------------------------------------

	--A�adir el Campo CARACTERORDEN para componer la ordenaci�n de los huecos.
	ALTER TABLE ASGDTIPOELEMENTO ADD COLUMN CARACTERORDEN CHAR(1) NOT NULL DEFAULT ' ';

	--Inicializar el valor del campo CARACTERORDEN con la primera letra del campo NOMBRE
	UPDATE ASGDTIPOELEMENTO SET CARACTERORDEN = LPAD(NOMBRE,1);

	--A�adir el Campo TIPOORD a la tabla de tipos de elemento
	ALTER TABLE ASGDTIPOELEMENTO ADD COLUMN TIPOORD SMALLINT NOT NULL DEFAULT 1;

	-------------------------------------------
	-- ELEMENTOS NO ASIGNABLES
	-------------------------------------------

	--A�adir la columna CODORDEN
	ALTER TABLE ASGDELEMNOASIG ADD COLUMN CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL;

	-- 02 Dep�sito
	UPDATE ASGDELEMNOASIG SET CODORDEN = 'D' || LPAD(NUMORDEN,4,'0') WHERE IDTIPOELEMENTO= '00000000000000000000000000000002';


	--03 M�dulo
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN || '_' || 'M' || LPAD(elemento.NUMORDEN,4,'0')
	FROM ASGDELEMNOASIG padre, ASGDELEMNOASIG elemento
	WHERE elemento.IDTIPOELEMENTO= '00000000000000000000000000000003' AND
     padre.ID = elemento.IDPADRE AND
     ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO ='00000000000000000000000000000003';

	-- 05 Planero
	UPDATE ASGDELEMNOASIG SET CODORDEN =
	(SELECT padre.CODORDEN || '_' || 'P' || LPAD(elemento.NUMORDEN,4,'0')
	FROM ASGDELEMNOASIG padre, ASGDELEMNOASIG elemento
	WHERE elemento.IDTIPOELEMENTO= '00000000000000000000000000000005' AND
     padre.ID = elemento.IDPADRE AND
     ASGDELEMNOASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO ='00000000000000000000000000000005';

	-------------------------------------------
	-- ELEMENTOS ASIGNABLES
	-------------------------------------------

	-- Actualizar los elementos asignables con el CODORDEN que les corresponde

	--A�adir la columna CODORDEN
	ALTER TABLE ASGDELEMASIG ADD COLUMN CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL  ;


	--04 Balda
	UPDATE ASGDELEMASIG SET CODORDEN =
	(SELECT padre.CODORDEN || '_' || 'B' || LPAD(elemento.NUMORDEN,4,'0')
	FROM ASGDELEMNOASIG padre, ASGDELEMASIG elemento
	WHERE elemento.IDTIPOELEMENTO= '00000000000000000000000000000004' AND
     padre.ID = elemento.IDELEMNAPADRE AND
     ASGDELEMASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO ='00000000000000000000000000000004';


	--06 Caj�n Planero
	UPDATE ASGDELEMASIG SET CODORDEN =
	(SELECT padre.CODORDEN || '_' || 'C' || LPAD(elemento.NUMORDEN,4,'0')
	FROM ASGDELEMNOASIG padre, ASGDELEMASIG elemento
	WHERE elemento.IDTIPOELEMENTO= '00000000000000000000000000000006' AND
     padre.ID = elemento.IDELEMNAPADRE AND
     ASGDELEMASIG.ID = elemento.ID
	)
	WHERE IDTIPOELEMENTO ='00000000000000000000000000000006';

	-------------------------------------------
	-- HUECOS
	-------------------------------------------

	--A�adir el Campo TIPOORD a la tabla de huecos.
	ALTER TABLE ASGDHUECO ADD COLUMN TIPOORD SMALLINT DEFAULT 1 NOT NULL;

	--A�adir el Campo CODORDEN a la tabla de HUECOS
	ALTER TABLE ASGDHUECO ADD COLUMN CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL;


	--Obtenci�n del C�digo de orden para los elementos con ordenaci�n 1
	-- Huecos
	UPDATE ASGDHUECO SET CODORDEN =
	(SELECT padre.CODORDEN || '_' || 'H' || LPAD(hueco.NUMORDEN,4,'0')
	FROM ASGDELEMASIG padre, ASGDHUECO hueco
	WHERE
			padre.ID = hueco.IDELEMAPADRE AND
			ASGDHUECO.IDELEMAPADRE = hueco.IDELEMAPADRE AND
           ASGDHUECO.NUMORDEN = hueco.NUMORDEN
	);


	-- Crear los �ndices necesarios
	CREATE INDEX ASGDHUECO7 ON ASGDHUECO (CODORDEN, TIPOORD);
	CREATE UNIQUE INDEX ASGDHUECO8 ON ASGDHUECO (CODORDEN, IDDEPOSITO);

	-------------------------------------------
	-- RELACIONES DE ENTREGA
	-------------------------------------------

	--A�adir el campo de tipo de elemento.
	ALTER TABLE ASGTRENTREGA ADD COLUMN IDTIPOELMTODRESERVA VARCHAR(32);

	--Renombrar el nombre de la Columna
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDENARESERVA TO IDELMTODRESERVA;

	-- Actualizar el valor del tipo
	UPDATE ASGTRENTREGA
	SET IDTIPOELMTODRESERVA = (
		SELECT elemento.IDTIPOELEMENTO
		FROM ASGDELEMNOASIG elemento
		WHERE elemento.ID = ASGTRENTREGA.IDELMTODRESERVA
	);


/******************************************************************************************************/
/* Versi�n 2.2.1 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.2.1',now());

	--Modificado el tama�o de la columna para coincida con ASGTUDOCENUI
	ALTER TABLE ASGDUDOCENUI ALTER DESCRIPCION TYPE VARCHAR(254);

	--Modificado el tama�o de la columna DESCRIPCION de la tabla ASCALISTCA
	ALTER TABLE ASCALISTCA ALTER DESCRIPCION TYPE VARCHAR(512);

	--Modificada la tabla de valoraciones para a�adir la columna de informaci�n de la serie en el momento de fin de ciclo de vida de la valoraci�n
	ALTER TABLE ASGFVALSERIE ADD COLUMN INFOSERIE TEXT;

	-- Crear un �ndice para acelerar la b�squeda de los nodos padre en ASGFELEMENTOCF
	CREATE INDEX ASGFELEMENTOCF11 ON ASGFELEMENTOCF (COALESCE(IDPADRE,'nulo'));


/******************************************************************************************************/
/* Versi�n 2.3 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.3',now());

	-- Crear la tabla de niveles de archivo
	CREATE TABLE AGNIVELARCHIVO(
      ID VARCHAR(32) NOT NULL,
      NOMBRE VARCHAR(64) NOT NULL,
      DESCRIPCION VARCHAR(254),
      ORDEN INTEGER NOT NULL);

	-- Crear los �ndices de la tabla de niveles de archivo
	CREATE UNIQUE INDEX AGNIVELARCHIVO01 ON AGNIVELARCHIVO(ID);
	CREATE INDEX AGNIVELARCHIVO02 ON AGNIVELARCHIVO(ORDEN);

	-- A�adir columna IDNIVEL en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD COLUMN IDNIVEL  VARCHAR(32);

	-- A�adir columna IDRECEPTORDEFECTO en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD COLUMN IDRECEPTORDEFECTO VARCHAR(32);

	-- Inserci�n del Nivel de Archivo Central.
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN)
        VALUES ('00000000000000000000000000000001', 'Central','Archivo Central',1);

   -- Actualizaci�n del Archivo de la Aplicaci�n para que tenga nivel Principal.
	UPDATE AGARCHIVO SET IDNIVEL = '00000000000000000000000000000001' WHERE ID='00000000000000000000000000000001';

	-- La columna IDNIVEL en AGARCHIVO no puede ser nula.
	ALTER TABLE AGARCHIVO ALTER COLUMN IDNIVEL SET NOT NULL;

  -- A�adir el campo IDARCHIVO en la tabla ASGDDEPOSITO
  ALTER TABLE ASGDDEPOSITO ADD COLUMN IDARCHIVO VARCHAR(32);

  --Actualizar los dep�sitos existentes al archivo por defecto
  UPDATE ASGDDEPOSITO SET IDARCHIVO = '00000000000000000000000000000001';

  --Poner la columna IDARCHVO para que no pueda ser nula.
	ALTER TABLE ASGDDEPOSITO ALTER COLUMN IDARCHIVO SET NOT NULL;

	-- Rellenar los datos nulos de la columna FECHAESTADO de la tabla ASGFSERIE
	UPDATE ASGFSERIE SET FECHAESTADO = TO_DATE('01/01/2001','dd/MM/yyyy') WHERE FECHAESTADO IS NULL;

	-- Modificar el campo FECHAESTADO de la tabla ASGFSERIE para que no pueda tener valor nulo
	ALTER TABLE ASGFSERIE ALTER COLUMN FECHAESTADO SET NOT NULL;

	-- A�adir columna IDARCHIVO en ASGTNSEC
	ALTER TABLE ASGTSNSEC ADD COLUMN IDARCHIVO  VARCHAR(32);

	--Eliminado el Indice unico de ASGTSNSEC1 para modificarlo
	DROP INDEX ASGTSNSEC1;

  --Actualizar al archivo por defecto en la tabla ASGTSNSEC
  UPDATE ASGTSNSEC SET IDARCHIVO = '00000000000000000000000000000001';

		--Poner la columna IDARCHIVO para que no pueda ser nula.
	ALTER TABLE ASGTSNSEC ALTER COLUMN IDARCHIVO SET NOT NULL;

	--Creado el �ndice de nuevo para meter el IDARCHIVO
	CREATE UNIQUE INDEX ASGTSNSEC1 ON ASGTSNSEC (TIPO, ANO, IDARCHIVO);

	-- Crear la tabla ASGTUINSTALACIONREEA
	CREATE TABLE ASGTUINSTALACIONREEA(
      IDUIDEPOSITO VARCHAR(32) NOT NULL,
      IDRELENTREGA VARCHAR(32) NOT NULL,
      ORDEN INTEGER NOT NULL,
      IDFORMATO VARCHAR(32) NOT NULL,
      ESTADOCOTEJO INTEGER NOT NULL,
      NOTASCOTEJO VARCHAR(254),
      DEVOLUCION VARCHAR(1) NOT NULL,
      PATHDEPOSITOORIGEN VARCHAR(512) NOT NULL);

	-- Crear los �ndices para ASGTUINSTALACIONREEA
	CREATE INDEX ASGTUINSTALACIONREEA1 ON ASGTUINSTALACIONREEA (IDUIDEPOSITO);
	CREATE INDEX ASGTUINSTALACIONREEA2 ON ASGTUINSTALACIONREEA (IDRELENTREGA);

	-- A�adir columna IDARCHIVOREMITENTE en ASGTPREVISION
	ALTER TABLE ASGTPREVISION ADD COLUMN IDARCHIVOREMITENTE VARCHAR(32);

	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTPREVISION
	ALTER TABLE ASGTPREVISION RENAME COLUMN IDFONDO TO IDFONDODESTINO;

	-- A�adir columna IDSERIEORIGEN en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD COLUMN IDSERIEORIGEN VARCHAR(32);

	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV RENAME COLUMN IDSERIE TO IDSERIEDESTINO;

	-- A�adir columna INFO en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD COLUMN INFO VARCHAR(1024);

	-- A�adir columna IDARCHIVOREMITENTE en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD COLUMN IDARCHIVOREMITENTE VARCHAR(32);

	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDFONDO TO IDFONDODESTINO;

	-- Renombrar columna IDUSRGESTORARCHIVO a IDUSRGESTORARCHIVOREC en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDUSRGESTORARCHIVO TO IDUSRGESTORARCHIVOREC;

	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDSERIE TO IDSERIEDESTINO;

	-- A�adir columna IDFONDOORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD COLUMN IDFONDOORIGEN VARCHAR(32);

	-- A�adir columna IDSERIEORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD COLUMN IDSERIEORIGEN VARCHAR(32);

	-- A�adir columna MARCASBLOQUEO en ASGDUINSTALACION
	ALTER TABLE ASGDUINSTALACION ADD COLUMN MARCASBLOQUEO INTEGER DEFAULT 0;

	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que contenga el valor 0
	UPDATE ASGDUINSTALACION SET MARCASBLOQUEO = 0;

	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que no sea nulable
	ALTER TABLE ASGDUINSTALACION ALTER COLUMN MARCASBLOQUEO SET NOT NULL;

	-- A�adir columna IDARCHIVO en ASGTNSECUI
	ALTER TABLE ASGTSNSECUI ADD COLUMN IDARCHIVO VARCHAR(32);

	-- A�adir columna SIGNATURAUI en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD COLUMN SIGNATURAUI VARCHAR(16);

	-- A�adir columna IDARCHIVO en ASGFELIMSERIE
	ALTER TABLE ASGFELIMSERIE ADD COLUMN IDARCHIVO VARCHAR(32);

	-- Actualizar las eliminaciones al archivo por defecto
  UPDATE ASGFELIMSERIE SET IDARCHIVO = '00000000000000000000000000000001';

  --Poner la columna IDARCHIVO en ASGFELIMSERIE para que no pueda ser nula.
  ALTER TABLE ASGFELIMSERIE ALTER COLUMN IDARCHIVO SET NOT NULL;

	-- Eliminar el �ndice �nico de identificaci�n en ASGDUINSTALACION
	DROP INDEX ASGDUINSTALACION3;
	CREATE INDEX ASGDUINSTALACION3 ON ASGDUINSTALACION (IDENTIFICACION);

	-- Eliminar el �ndice �nico de identificaci�n en ASGDUDOCENUI
	DROP INDEX ASGDUDOCENUI1;
	CREATE INDEX ASGDUDOCENUI1 ON ASGDUDOCENUI (IDENTIFICACION);

	-- A�adir las columnas necesarias para la identificaci�n de un hueco a la tabla de unidades de instalaci�n en relaciones de entrega entre archivos
	ALTER TABLE ASGTUINSTALACIONREEA ADD COLUMN IDELEMAPADREHUECOORIGEN VARCHAR(32) NOT NULL,
   ADD COLUMN NUMORDENHUECOORIGEN INTEGER NOT NULL;

	-- Crear tabla para el n�mero secuencial de unidad documental
	CREATE TABLE ASGTSNSECUDOC
	(
     NUMSEC  INTEGER NOT NULL
	);

	-- A�adir columna SIGNATURAUIORIGEN en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD COLUMN SIGNATURAUIORIGEN VARCHAR(16);

/******************************************************************************************************/
/* Versi�n 2.3.1 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.3.1',now());

	--A�adido Campo de Nombre Corto al Archivo, para las cartelas de los informes
	ALTER TABLE AGARCHIVO ADD COLUMN NOMBRECORTO VARCHAR(25);

	--Se Actualiza el valor del NOMBRECORTO a ARCHIVO GENERAL ya que era como estaba en fichero de resources.
	UPDATE AGARCHIVO SET NOMBRECORTO='ARCHIVO GENERAL';

	--Modificaci�n de la column NOMBRECORTO para que no sea nula.
	ALTER TABLE AGARCHIVO ALTER COLUMN NOMBRECORTO SET NOT NULL;

	--Poner como decimal la longitud del formato
	ALTER TABLE AGFORMATO ALTER COLUMN LONGITUD TYPE FLOAT;

	--Poner como decimal la longitud del elemento asignable
	ALTER TABLE ASGDELEMASIG ALTER COLUMN LONGITUD TYPE FLOAT;

	-- Crear un �ndice en ADVCREFCF para acelerar b�squedas
	CREATE INDEX ADVCREFCF5   ON ADVCREFCF (IDOBJREF);

/******************************************************************************************************/
/* Versi�n 2.4 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.4',now());

	-- A�adir las columnas de tipo de entrega, datos de usuario autorizado y datos de solicitante a las tablas de pr�stamo y consulta
	ALTER TABLE ASGPCONSULTA ADD COLUMN TIPOENTREGA VARCHAR(254) NULL;
	ALTER TABLE ASGPCONSULTA ADD COLUMN DATOSAUTORIZADO VARCHAR(254) NULL;
	ALTER TABLE ASGPCONSULTA ADD COLUMN DATOSSOLICITANTE VARCHAR(512) NULL;

	ALTER TABLE ASGPPRESTAMO ADD COLUMN TIPOENTREGA VARCHAR(254) NULL;
	ALTER TABLE ASGPPRESTAMO ADD COLUMN DATOSAUTORIZADO VARCHAR(254) NULL;
	ALTER TABLE ASGPPRESTAMO ADD COLUMN DATOSSOLICITANTE VARCHAR(512) NULL;

	-- Insertar tabla de validaci�n y lista de valores para los tipos de entrega de pr�stamos y consultas
	INSERT INTO ADCTLGTBLVLD (ID, NOMBRE, DESCRIPCION, USOINTERNO )
	VALUES ('ID_TBLVLD_TIPOS_ENTREGA', 'Tipo de entrega', null, 'S');

	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('135','Fax', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('136','CD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('137','DVD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('138','Originales', 'ID_TBLVLD_TIPOS_ENTREGA');

	-- Insertar en la tabla ASGTRENTREGA el campo CORRECCIONENARCHIVO
	ALTER TABLE ASGTRENTREGA ADD COLUMN CORRECCIONENARCHIVO VARCHAR(1) DEFAULT 'N' NOT NULL;

	-- Insertar en la tabla ASGFPRODSERIE el campo MARCAS
	ALTER TABLE ASGFPRODSERIE ADD COLUMN MARCAS INTEGER DEFAULT 0;
