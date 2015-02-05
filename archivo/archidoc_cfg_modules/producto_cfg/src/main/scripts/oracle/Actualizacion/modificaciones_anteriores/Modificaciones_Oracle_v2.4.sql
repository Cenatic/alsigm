/******************************************************************************************************/
/* Versi�n 2.01 */
/******************************************************************************************************/

-- Eliminar indices �nicos de productores de serie y crear los �ndices sin unicidad

	DROP INDEX ASGFPRODSERIE1;
        DROP INDEX ASGFPRODSERIE2;

	CREATE INDEX ASGFPRODSERIE1 ON ASGFPRODSERIE (IDSERIE) TABLESPACE &1;
	CREATE INDEX ASGFPRODSERIE2 ON ASGFPRODSERIE (IDSERIE, IDPROCEDIMIENTO) TABLESPACE &1;

/******************************************************************************************************/
/* Versi�n 2.1 */
/******************************************************************************************************/
 
 -- A�adir un nuevo campo documental en ADDESCRIPTOR con el nombre del descriptor
 
 	execute archivo.createkey( 'ADDESCRIPTOR', 'ID');
	execute archivo.createPolicy('ADDESCRIPTOR','NOMBRE','ID','','-/',0);	
	execute archivo.OptimizePolicy('ADDESCRIPTOR','NOMBRE');

 -- Crear una tabla de informaci�n del sistema
	CREATE TABLE AGINFOSISTEMA ( 
  		   ID VARCHAR2 (16) NOT NULL,
  		   VALOR VARCHAR2 (16) NOT NULL,
  		   FECHAACTUALIZACION DATE NOT NULL
    ) ;
	
 -- Crear un �ndice �nico en el id
 	CREATE UNIQUE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(ID) TABLESPACE &1;
  
	  
 -- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (ID,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','2.1',SYSDATE);

/******************************************************************************************************/
/* Versi�n 2.1.1 */
/******************************************************************************************************/
	
	CREATE SEQUENCE SEQ_INFO
	INCREMENT BY 1
	MINVALUE 1 
	MAXVALUE 100000000000
	START WITH 1;

	ALTER TABLE AGINFOSISTEMA ADD (AUTID NUMBER); 

	DROP INDEX AGINFOSISTEMA1;
	
	-- Crear un �ndice �nico en el id autonum�rico
 	CREATE INDEX AGINFOSISTEMA1 ON AGINFOSISTEMA(AUTID) TABLESPACE &1;

	-- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.1.1',SYSDATE);

/******************************************************************************************************/
/* Versi�n 2.2 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
  	INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.2',SYSDATE);

	-------------------------------------------
	-- TIPOS DE ELEMENTOS
	-------------------------------------------

	--A�adir el Campo CARACTERORDEN para componer la ordenaci�n de los huecos. 
	ALTER TABLE ASGDTIPOELEMENTO ADD CARACTERORDEN CHAR(1) DEFAULT ' ' NOT NULL ;

	--A�adir el Campo TIPOORD a la tabla de tipos de elemento
	ALTER TABLE ASGDTIPOELEMENTO ADD TIPOORD NUMBER(5)  DEFAULT 1 NOT NULL;

	--Inicializar el valor del campo CARACTERORDEN con la primera letra del campo NOMBRE
	UPDATE ASGDTIPOELEMENTO SET CARACTERORDEN = SUBSTR(NOMBRE,1,1);

	-------------------------------------------
	-- ELEMENTOS NO ASIGNABLES
	-------------------------------------------

	--A�adir la columna CODORDEN
	ALTER TABLE ASGDELEMNOASIG ADD CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL; 

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
	ALTER TABLE ASGDELEMASIG ADD CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL  ;

	
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
	ALTER TABLE ASGDHUECO ADD  TIPOORD NUMBER(5) DEFAULT 1 NOT NULL;

	--A�adir el Campo CODORDEN a la tabla de HUECOS
	ALTER TABLE ASGDHUECO ADD CODORDEN VARCHAR(50) DEFAULT ' ' NOT NULL;

	
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
	CREATE INDEX ASGDHUECO7 ON ASGDHUECO (CODORDEN, TIPOORD) TABLESPACE &1;
	CREATE UNIQUE INDEX ASGDHUECO8 ON ASGDHUECO (CODORDEN, IDDEPOSITO) TABLESPACE &1;

	-------------------------------------------
	-- RELACIONES DE ENTREGA
	-------------------------------------------

	--A�adir el campo de tipo de elemento.
	ALTER TABLE ASGTRENTREGA ADD IDTIPOELMTODRESERVA VARCHAR(32);

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
	INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.2.1',SYSDATE);
	
	--Modificado el tama�o de la columna para coincida con ASGTUDOCENUI
	ALTER TABLE ASGDUDOCENUI MODIFY DESCRIPCION VARCHAR2(254);

	--Modificado el tama�o de la columna DESCRIPCION de la tabla ASCALISTCA
	ALTER TABLE ASCALISTCA MODIFY DESCRIPCION VARCHAR2(512);

	--Modificada la tabla de valoraciones para a�adir la columna de informaci�n de la serie en el momento de fin de ciclo de vida de la valoraci�n
	ALTER TABLE ASGFVALSERIE ADD INFOSERIE CLOB;

	-- Crear un �ndice para acelerar la b�squeda de los nodos padre en ASGFELEMENTOCF
	CREATE INDEX ASGFELEMENTOCF11 ON ASGFELEMENTOCF (NVL(IDPADRE,'nulo')) TABLESPACE &1;

/******************************************************************************************************/
/* Versi�n 2.3 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.3',SYSDATE);
	
	-- Crear la tabla de niveles de archivo
	CREATE TABLE AGNIVELARCHIVO(
	   ID VARCHAR2(32) NOT NULL,
	   NOMBRE VARCHAR2(64) NOT NULL,
	   DESCRIPCION VARCHAR2(254),
	   ORDEN NUMBER NOT NULL);
	   
	-- Crear los �ndices de la tabla de niveles de archivo
	CREATE UNIQUE INDEX AGNIVELARCHIVO01 ON AGNIVELARCHIVO(ID) TABLESPACE &1;
	CREATE INDEX AGNIVELARCHIVO02 ON AGNIVELARCHIVO(ORDEN) TABLESPACE &1;
	
	-- A�adir columna IDNIVEL en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD (IDNIVEL  VARCHAR2(32));
	
	-- A�adir columna IDRECEPTORDEFECTO en AGARCHIVO
	ALTER TABLE AGARCHIVO ADD (IDRECEPTORDEFECTO VARCHAR2(32));
	
	-- Inserci�n del Nivel de Archivo Central.
	INSERT INTO AGNIVELARCHIVO (ID, NOMBRE, DESCRIPCION, ORDEN) 
        VALUES ('00000000000000000000000000000001', 'Central','Archivo Central',1);
        
        -- Actualizaci�n del Archivo de la Aplicaci�n para que tenga nivel Principal.
	UPDATE AGARCHIVO SET IDNIVEL = '00000000000000000000000000000001' WHERE ID='00000000000000000000000000000001';
	
	-- La columna IDNIVEL en AGARCHIVO no puede ser nula.
	ALTER TABLE AGARCHIVO MODIFY(IDNIVEL  NOT NULL);
	
    	-- A�adir el campo IDARCHIVO en la tabla ASGDDEPOSITO
    	ALTER TABLE ASGDDEPOSITO ADD IDARCHIVO VARCHAR2(32);
    
    	--Actualizar los dep�sitos existentes al archivo por defecto
    	UPDATE ASGDDEPOSITO SET IDARCHIVO = '00000000000000000000000000000001';
    
    	--Poner la columna IDARCHVO para que no pueda ser nula.
    	ALTER TABLE ASGDDEPOSITO MODIFY(IDARCHIVO NOT NULL);

	-- Rellenar los datos nulos de la columna FECHAESTADO de la tabla ASGFSERIE
	UPDATE ASGFSERIE SET FECHAESTADO = TO_DATE('01/01/2001','dd/MM/yyyy') WHERE FECHAESTADO IS NULL;
	
	-- Modificar el campo FECHAESTADO de la tabla ASGFSERIE para que no pueda tener valor nulo
	ALTER TABLE ASGFSERIE MODIFY FECHAESTADO NOT NULL;
	
	-- A�adir columna IDARCHIVO en ASGTNSEC
	ALTER TABLE ASGTSNSEC ADD (IDARCHIVO  VARCHAR2(32));
	
	--Eliminado el Indice unico de ASGTSNSEC1 para modificarlo
	DROP INDEX ASGTSNSEC1;

        --Actualizar al archivo por defecto en la tabla ASGTSNSEC
        UPDATE ASGTSNSEC SET IDARCHIVO = '00000000000000000000000000000001';

    	--Poner la columna IDARCHIVO para que no pueda ser nula.
	ALTER TABLE ASGTSNSEC MODIFY IDARCHIVO NOT NULL;
	
	--Creado el �ndice de nuevo para meter el IDARCHIVO
	CREATE UNIQUE INDEX ASGTSNSEC1 ON ASGTSNSEC (TIPO, ANO, IDARCHIVO) TABLESPACE &1;	
		
	-- Crear la tabla ASGTUINSTALACIONREEA
	CREATE TABLE ASGTUINSTALACIONREEA(
	   IDUIDEPOSITO VARCHAR2(32) NOT NULL,
	   IDRELENTREGA VARCHAR2(32) NOT NULL,
	   ORDEN NUMBER NOT NULL,
	   IDFORMATO VARCHAR2(32) NOT NULL,
	   ESTADOCOTEJO NUMBER NOT NULL,
	   NOTASCOTEJO VARCHAR2(254),
	   DEVOLUCION VARCHAR2(1) NOT NULL,
	   PATHDEPOSITOORIGEN VARCHAR2(512) NOT NULL);

	-- Crear los �ndices para ASGTUINSTALACIONREEA
	CREATE INDEX ASGTUINSTALACIONREEA1 ON ASGTUINSTALACIONREEA (IDUIDEPOSITO) TABLESPACE &1;
	CREATE INDEX ASGTUINSTALACIONREEA2 ON ASGTUINSTALACIONREEA (IDRELENTREGA) TABLESPACE &1;
		   
	-- A�adir columna IDARCHIVOREMITENTE en ASGTPREVISION
	ALTER TABLE ASGTPREVISION ADD (IDARCHIVOREMITENTE VARCHAR2(32));

	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTPREVISION
	ALTER TABLE ASGTPREVISION RENAME COLUMN IDFONDO TO IDFONDODESTINO;
	
	-- A�adir columna IDSERIEORIGEN en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD (IDSERIEORIGEN VARCHAR2(32));

	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV RENAME COLUMN IDSERIE TO IDSERIEDESTINO;
	
	-- A�adir columna INFO en ASGTDETALLEPREV
	ALTER TABLE ASGTDETALLEPREV ADD (INFO VARCHAR2(1024));
	
	-- A�adir columna IDARCHIVOREMITENTE en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD (IDARCHIVOREMITENTE VARCHAR2(32));
	
	-- Renombrar columna IDFONDO a IDFONDODESTINO en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDFONDO TO IDFONDODESTINO;
	
	-- Renombrar columna IDUSRGESTORARCHIVO a IDUSRGESTORARCHIVOREC en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDUSRGESTORARCHIVO TO IDUSRGESTORARCHIVOREC;

	-- Renombrar columna IDSERIE a IDSERIEDESTINO en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA RENAME COLUMN IDSERIE TO IDSERIEDESTINO;

	-- A�adir columna IDFONDOORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD (IDFONDOORIGEN VARCHAR2(32));
	
	-- A�adir columna IDSERIEORIGEN en ASGTRENTREGA
	ALTER TABLE ASGTRENTREGA ADD (IDSERIEORIGEN VARCHAR2(32));
	
	-- A�adir columna MARCASBLOQUEO en ASGDUINSTALACION
	ALTER TABLE ASGDUINSTALACION ADD (MARCASBLOQUEO NUMBER(10) DEFAULT 0);

	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que contenga el valor 0
	UPDATE ASGDUINSTALACION SET MARCASBLOQUEO = 0;

	-- Actualizaci�n de columna MARCASBLOQUEO de ASGDUINSTALACION para que no sea nulable	
	ALTER TABLE ASGDUINSTALACION MODIFY(MARCASBLOQUEO NOT NULL);

	-- A�adir columna IDARCHIVO en ASGTNSECUI
	ALTER TABLE ASGTSNSECUI ADD (IDARCHIVO VARCHAR2(32));

	-- A�adir columna SIGNATURAUI en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD (SIGNATURAUI VARCHAR2(16));	
	
	-- A�adir columna IDARCHIVO en ASGFELIMSERIE
	ALTER TABLE ASGFELIMSERIE ADD (IDARCHIVO VARCHAR2(32));	
	
	-- Actualizar las eliminaciones al archivo por defecto
    	UPDATE ASGFELIMSERIE SET IDARCHIVO = '00000000000000000000000000000001';
    
    	--Poner la columna IDARCHIVO en ASGFELIMSERIE para que no pueda ser nula.
    	ALTER TABLE ASGFELIMSERIE MODIFY(IDARCHIVO NOT NULL);	
    	
	-- Eliminar el �ndice �nico de identificaci�n en ASGDUINSTALACION
	DROP INDEX ASGDUINSTALACION3;
	CREATE INDEX ASGDUINSTALACION3 ON ASGDUINSTALACION (IDENTIFICACION) TABLESPACE &1;

	-- Eliminar el �ndice �nico de identificaci�n en ASGDUDOCENUI	
	DROP INDEX ASGDUDOCENUI1;
	CREATE INDEX ASGDUDOCENUI1 ON ASGDUDOCENUI (IDENTIFICACION) TABLESPACE &1;    	

	-- A�adir las columnas necesarias para la identificaci�n de un hueco a la tabla de unidades de instalaci�n en relaciones de entrega entre archivos
	ALTER TABLE ASGTUINSTALACIONREEA ADD (IDELEMAPADREHUECOORIGEN VARCHAR2(32) NOT NULL,
                                      		NUMORDENHUECOORIGEN NUMBER NOT NULL);

	-- Crear tabla para el n�mero secuencial de unidad documental
	CREATE TABLE ASGTSNSECUDOC
	(
	  NUMSEC  NUMBER NOT NULL
	);

	-- A�adir columna SIGNATURAUIORIGEN en ASGTUINSTALACIONREEA
	ALTER TABLE ASGTUINSTALACIONREEA ADD (SIGNATURAUIORIGEN VARCHAR2(16));

/******************************************************************************************************/
/* Versi�n 2.3.1 */
/******************************************************************************************************/
    
    -- Insertar la versi�n actual de bd
    INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.3.1',SYSDATE);

    --A�adido Campo de Nombre Corto al Archivo, para las cartelas de los informes
    ALTER TABLE AGARCHIVO ADD NOMBRECORTO VARCHAR2(25);
    
    --Se Actualiza el valor del NOMBRECORTO a ARCHIVO GENERAL ya que era como estaba en fichero de resources.
    UPDATE AGARCHIVO SET NOMBRECORTO='ARCHIVO GENERAL';

    --Modificaci�n de la column NOMBRECORTO para que no sea nula.
    ALTER TABLE AGARCHIVO MODIFY(NOMBRECORTO NOT NULL);

    --Poner como decimal la longitud del formato
    ALTER TABLE AGFORMATO MODIFY(LONGITUD NUMBER(8,2));

    --Poner como decimal la longitud del elemento asignable
    ALTER TABLE ASGDELEMASIG MODIFY(LONGITUD NUMBER(8,2));

    -- Crear un �ndice en ADVCREFCF para acelerar b�squedas
    CREATE INDEX ADVCREFCF5   ON ADVCREFCF (IDOBJREF ) TABLESPACE &1;
    
/******************************************************************************************************/
/* Versi�n 2.4 */
/******************************************************************************************************/

	-- Insertar la versi�n actual de bd
	INSERT INTO AGINFOSISTEMA (AUTID,ID,VALOR,FECHAACTUALIZACION) VALUES (SEQ_INFO.NextVal,'VERSIONBD','2.4',SYSDATE);

	-- A�adir las columnas de tipo de entrega, datos de usuario autorizado y datos de solicitante a las tablas de pr�stamo y consulta
	ALTER TABLE ASGPCONSULTA ADD (TIPOENTREGA VARCHAR2(254) NULL);
	ALTER TABLE ASGPCONSULTA ADD (DATOSAUTORIZADO VARCHAR2(254) NULL);
	ALTER TABLE ASGPCONSULTA ADD (DATOSSOLICITANTE VARCHAR2(512) NULL);

	ALTER TABLE ASGPPRESTAMO ADD (TIPOENTREGA VARCHAR2(254) NULL);
	ALTER TABLE ASGPPRESTAMO ADD (DATOSAUTORIZADO VARCHAR2(254) NULL);
	ALTER TABLE ASGPPRESTAMO ADD (DATOSSOLICITANTE VARCHAR2(512) NULL);

	-- Insertar tabla de validaci�n y lista de valores para los tipos de entrega de pr�stamos y consultas
	INSERT INTO ADCTLGTBLVLD (ID, NOMBRE, DESCRIPCION, USOINTERNO ) 
	VALUES ('ID_TBLVLD_TIPOS_ENTREGA', 'Tipo de entrega', null, 'S');

	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('135','Fax', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('136','CD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('137','DVD', 'ID_TBLVLD_TIPOS_ENTREGA');
	INSERT INTO ADTEXTTBLVLD ( ID, VALOR, IDTBLVLD ) VALUES ('138','Originales', 'ID_TBLVLD_TIPOS_ENTREGA');	
		
	-- Insertar en la tabla ASGTRENTREGA el campo CORRECCIONENARCHIVO
	ALTER TABLE ASGTRENTREGA ADD CORRECCIONENARCHIVO VARCHAR2(1) DEFAULT 'N' NOT NULL;
	
	-- Insertar en la tabla ASGFPRODSERIE el campo MARCAS
	ALTER TABLE ASGFPRODSERIE ADD MARCAS NUMBER(10) DEFAULT 0;    