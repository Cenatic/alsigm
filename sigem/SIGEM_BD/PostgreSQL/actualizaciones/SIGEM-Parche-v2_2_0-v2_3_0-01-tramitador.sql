
--
-- Informaci�n de versi�n
--
INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (nextval('spac_sq_id_infosistema'), 'VERSIONBD', '6.3', current_timestamp);
INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (nextval('spac_sq_id_infosistema'), 'VERSIONAPP', '6.3', current_timestamp);

--
-- Creaci�n de tabla SPAC_CT_INFORMES_ORG 
--

CREATE SEQUENCE spac_sq_id_ctinformes_org INCREMENT BY 1 NO MAXVALUE NO MINVALUE CACHE 1;

CREATE TABLE spac_ct_informes_org
(
  id          integer                           NOT NULL,
  id_informe  integer,
  uid_usr     character varying(32)
);


ALTER TABLE ONLY spac_ct_informes_org
	ADD CONSTRAINT pk_spac_ct_informes_org PRIMARY KEY (id);

	

--
--Se a�ade campo parametros a SPAC_CT_INFORMES y campo visibilidad ,
--

ALTER TABLE SPAC_CT_INFORMES ADD COLUMN frm_params text;
ALTER TABLE SPAC_CT_INFORMES ADD COLUMN visibilidad smallint DEFAULT 0;

--
-- Para aquellos informes ya existentes se establecer� a p�blica
--
UPDATE SPAC_CT_INFORMES SET VISIBILIDAD=1;


---
--- Gestion de Ayudas
---

CREATE SEQUENCE spac_sq_id_ayudas INCREMENT BY 1 NO MAXVALUE NO MINVALUE CACHE 1;

CREATE TABLE spac_ayudas
(
	id 			integer 				NOT NULL,
	nombre		character varying(100),
	tipo_obj 	integer,
	id_obj 		integer,
	idioma 		character varying(5),
	contenido   text					
);

ALTER TABLE ONLY spac_ayudas
	ADD CONSTRAINT pk_spac_ayudas PRIMARY KEY (id);

--Se define spac_ayudas como entidad no visible , el id que utilizamos debe ser por debajo de 1000 y que no este ya en uso
INSERT INTO spac_ct_entidades (id, tipo, nombre, campo_pk, campo_numexp, schema_expr, frm_edit, descripcion, sec_pk) VALUES (120, 0, 'SPAC_AYUDAS', 'ID', NULL, NULL, NULL, 'AYUDAS', 'SPAC_SQ_ID_AYUDAS');


--Ayudas por defecto para el tramitador

INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Bandeja Entrada', 0, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Frm Busqueda por defecto', 1, -1, null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Estado Expediente', 2, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Procedimiento por defecto', 3, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Lista Tr�mite', 4, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Tr�mite', 5, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Plazos vencidos', 6, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Lista Registros distribuidos', 7, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Resultado Busqueda ES por defecto', 8, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Lista Avisos Electronicos', 9, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Registro Distribuido', 10, -1, null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Lista Expedientes', 11, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Circuito Firma', 12, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Iniciar Expediente', 13, -1, null,'');

--Ayudas  para el cat�logo
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Cat�logo Procedimientos', 31, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo procedimiento', 32, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Procedimiento > Fases', 33, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Procedimiento > Tr�mites', 34, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Procedimiento >Fases > Tr�mites', 35, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Procedimiento > Resumen', 36, -1,null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Procedimiento > Creado', 37, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Subproceso', 38, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo subproceso > Actividades', 39, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Subproceso > Resumen', 40, -1, null ,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Nuevo Subproceso > Creado', 41, -1, null,'');
INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Editor Gr�fico', 42, -1, null,'');





---Actualizamos el campo contenido para todas las ayudas

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>BANDEJA ENTRADA</h4></div><p>La pantalla que se muestra es la pantalla principal o Bandeja de Entrada para la 
Gesti�n de Expedientes.</p><p>Se podr�n realizar las siguientes acciones:<p><ul><li>Acceder a expedientes de los que es responsable, para continuar
su ramitaci�n (<b>bandeja de entrada: Expedientes en su lista de trabajo</b>)</li><p><li>Realizar tr�mites concretos de un expediente, del que 
es responsable (<b>bandeja de entrada: Tr�mites abiertos en sus expedientes</b>)</li><p><li>Localizar expedientes que est�n o no en tramitaci�n
o no sean responsabilidad suya, pero tenga derecho de consulta sobre ellos, mediante el men� de la izquierda: <b>B�squeda Avanzada</b></li>
<p><li>Iniciar un Expediente: men� de la izquierda: <B>Iniciar Expediente</B></li><p><li>Realizar utilidades relacionadas con el Portafirmas.
Desde el men� de la izquierda: <b>Portafirmas</b></li><p><li>Consultar los avisos electr�nicos de tramitaci�n (<b>bandeja de entrada: 
Informaci�n de sucesos que le afectan</b>)</li><p><li>Consultar los plazos vencidos (<b>bandeja de entrada: Tiene n plazos vencidos de su 
inter�s</b></li></ul>'
where IDIOMA IS NULL AND TIPO_OBJ=0;


update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion">
<h4>B�SQUEDA AVANZADA</h4>
</div>
<P>Desde esta pantalla se pueden realizar b�squedas sobre los expedientes sobre los que usted tiene permisos.
<P>Pueden existir varios formularios de b�squeda distintos. Permiten buscar por diferentes campos de los expedientes.
<P>Para cambiar de formulario de b�squeda seleccionarlo en el combo contiguo a <B> ''Formularios de consulta''</B>.
<P>Una vez seleccionado el formulario deseado, cumplimentar los datos conocidos a buscar. En algunos campos se puede seleccionar el operador de b�squeda entre los siguientes:
<p><center>
<table border "2">
<tr><td>></td>
<td>Mayor que</td> </tr>
<tr><td><</td><td>Menor que</td></tr>
<tr><td>>=</td><td>Mayor o igual que</td></tr>
<tr><td><=</td><td>Menor o igual que</td></tr>
<tr><td>=</td><td>Igual que</td></tr>
</table>
</center>
<p>Si el campo a buscar es un texto y no se conoce el texto exacto, se puede introducir el car�cter <b>*</B> como car�cter comod�n.
<p>Ejemplo:
<p>Si buscamos sobre el campo asunto el siguiente texto, el resultado ser� el siguiente:
<p><center>
<table border "2">
<tr><td>Subvenci�n*</td>
<td>Asuntos que comiencen con la palabra Subvenci�n</td> </tr>
<tr><td>*Subvenci�n</td><td>Asuntos que finalicen con la palabra Subvenci�n</td></tr>
<tr><td>*subvenci�n*</td><td>Asuntos que contengan la palabra Subvenci�n</td></tr>
</table>
</center>
<p>Una vez introducidos los criterios de b�squeda, hacer clic en la opci�n buscar. La aplicaci�n mostrar� una lista con los expedientes encontrados.' 
where IDIOMA IS NULL AND TIPO_OBJ=1;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion">
<h4>DISE�ADOR GR�FICO</h4>
</div>
El <b>Dise�ador Gr�fico</b> es la herramienta que se proporciona para visualizar los procedimientos y facilitar la tarea al dise�ador. Esta herramienta permite a los responsables de procesos y m�todos de la organizaci�n 
	crear y mantener el conjunto de <b>procedimientos administrativos</b> que se desean automatizar con la herramienta.
	<br><br>
	
	Desde la tramitaci�n podremos observar el grado de avance del expediente comprobando que fases hemos
	ya realizado en cual estamos y las que nos quedan por realizar , en las fases ya realizadas o en la actual
	se podr� consultar los tramites que se han realizado asi como el detalle de cada una de las instancias de los
	tr�mites, y en caso de ser un subproceso podremos navegar hasta el mismo.
	<h6>Barra de herramientas</h6>
		<div>
		 Nombre del procedimiento : Estado  
		 Leyenda con el significado de los colores que puede tener cada una de las fases
		 Imagen de una impresora que nos permite imprimir lo que en ese momento tengamos en la pantalla
		 Icono de ayuda 
		</div>
	
	<br/><br/>
	
	<h6>Editor de condiciones </h6>
	<div>
	 Un flujo puede tener asociado una condici�n para ello se mostrar� sobre el flujo un icono con un ?, pulsado sobre la flecha con el 
	 bot�n derecho del rat�n se visualizar� un listado de las condiciones Java (Reglas) como sobre BBDD (SQL) que el usuario haya asociado
	 al flujo , una condicion sql se podr� visualizar, pulsando sobre el nombre de la misma.'
where IDIOMA IS NULL AND TIPO_OBJ=2;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion">
<h4>FORMULARIO EXPEDIENTE</h4></div>
<p>La pantalla que se muestra es la del &#147;expediente abierto&#148;, es decir, es como si se abriera una carpeta f�sica 
con un expediente en formato papel y tuviera unos separadores por: <b>Expediente, Datos espec�ficos, Participantes y Documentos</b>.</p>
<p><ul><li><b>Expediente</b>: Se muestran los datos principales del expediente, en la zona superior, y del Interesado principal, en la zona
 inferior.</li><p><li><b>Datos espec�ficos</b>:se muestran los datos particulares del procedimiento que se est� tramitando.</li>
<p><li><b>Participantes</b>: se muestra el formulario para dar de alta o consultar los datos de las personas relacionadas con el Expediente.
</li><p><li><b>Documentos</b>: consta de dos zonas, la superior donde se ven, en este caso los documentos con todos sus campos y se podr� 
acceder a abrir su imagen y la parte inferior en donde se muestran en formato tabla, todos los documentos del expediente.
<p>Los documentos se a�aden al expediente, generalmente, desde los tr�mites de cada fase, pero hay expedientes que se dise�an de manera que 
se le pueden a�adir documentos desde esta pesta�a de Documentos.</p><p>Para ver todos los campos de informaci�n de un documento y sus im�genes, se seleccionar� de la lista inferior, pulsando sobre su nombre. Se comprobar� que sus datos se muestran en la parte superior. Seleccionando el bot�n <b>Ver documento</b> (situado debajo de las pesta�as), se abrir� el documento.</p></li>
</ul><p>Desde el men� de la izquierda de la pantalla se podr�n realizar las siguientes acciones:</p>
<p><ul><li>Pulsando el bot�n <b>Acciones</b> se podr� <b>Delegar fase</b> o <b>Clonar expediente</b>.</li>
<p><li>Crear un <b>Nuevo tr�mite</b> pulsando el bot�n del mismo nombre.</li>
<p><li>Pulsar el bot�n <b>Avanzar fase</b> para que el expediente que hay en pantalla avance de fase.</li>
<p><li>Pulsar <b> Tr�mites</b>  para visualizar los tr�mites por los que ha pasado el expediente.</li>
<p><li>Pulsar <b>Expedientes relacionados</b> para visualizar los expedientes relacionados.</li>
</ul><div class="titulo_ayuda"><label class="popUpInfo" >Informaci�n del tr�mite</label></div>
<p>Debajo de la etiqueta <b>Tr�mite/Documento</b>, hay una l�nea informativa en donde se visualiza: el nombre del tr�mite actual y la fecha 
interna de iniciaci�n.<p>Debajo de esa l�nea se encuentran los siguientes campos del Tr�mite:
<p><ul><li><b>Departamento responsable</b>:campo que rellena la aplicaci�n con el valor del departamento que realiza el tr�mite</li>
<p><li><b>Tramitador responsable</b>:campo que rellena la aplicaci�n, con el nombre del usuario que lo realiza</li>
<p><li><b>Fecha inicio plazo</b>:campo que rellenar� el usuario, seleccionando una fecha desde el  icono calendario</li>
<p><li><b>Plazo</b>:un n�mero de unidades: d�as, meses, a�os para el plazo</li>
<p><li><b>Unidades de Plazo</b>:se seleccionar� el icono Lupa y se mostrar�n en una nueva ventana, las distintas unidades de plazo existentes, 
de las cuales se seleccionar� el valor correspondiente</li><p><li><b>Fecha Alarma</b>:este campo lo cumplimenta la aplicaci�n y ser� el que se
 utilice para avisar al usuario tramitador, que le vence un plazo</li></ul><p>En la parte inferior de la pantalla,bajo la etiqueta: <B>DOCUMENTOS ADJUNTOS</b>, se encuentra la zona de documentos del tr�mite, en donde se visualizar�n los documentos del tr�mite si los hubiera.
<p>Desde esta pantalla se podr�n realizar las siguientes acciones para <b>Generar documentos</b>:<p><ul><li>Pulsar <b>Desde plantilla</b>
 para seleccionar una plantilla de la lista de plantillas asociadas al tr�mite<p>El usuario pulsar� sobre la que corresponda y se mostrar� el 
documento normalizado, con los datos del expediente incluidos en �l
<p>Este documento, a no ser que se defina en el tr�mite de otra manera, es modificable, por si se quiere complementar con alg�n dato, 
cambiar una expresi�n, etc.</li><p><li>Pulsar <b>Anexar fichero</b> para selecci�n del tipo de documento que se va a anexar en el tr�mite</li>
</ul><p>Tanto si se genera un documento desde una plantilla o anexando un fichero, en la parte inferior de la pantalla de tr�mites se muestra 
el tr�mite con el fichero anexado y en la parte izquierda el nuevo tr�mite en la lista de tr�mites.<p>Para borrar un documento, en un tr�mite
 abierto, si se ha generado o anexado por error. Se seleccionar� en la pantalla anterior el documento que se quiera borrar y se pulsar� 
<b>Borrar documento</b>.<p>Para finalizar el tr�mite se pulsar� <b>Terminar tr�mite</b>.
<p>Un tr�mite se puede eliminar siempre que se encuentre abierto, una vez realizado, no es ni modificable. Para borrar un tr�mite, 
se seleccionar� el bot�n de la pantalla de realizaci�n de tr�mites: <b>Eliminar tr�mite</b>.
<p>Para delegar un tr�mite se pulsar� el bot�n <b>Delegar</b> y se seleccionar� el Destinatario.' 
where IDIOMA IS NULL AND TIPO_OBJ=3;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion">
<h4>LISTA DE TR�MITES</h4></div><P>Muestra la lista de tr�mites de un tipo que se encuentran sin terminar. En la lista se puede ver
 el expediente y el procedimiento al que pertenecen, as� como la fecha de inicio del tr�mite y la fecha l�mite si la tiene.
<P>Para situarse sobre el tr�mite hacer clic sobre el nombre del tr�mite. Abrir� el expediente que lo contiene y situar� el
 contexto de la aplicaci�n en el tr�mite.<P>La lista de tr�mites se puede exportar a ficheros de tipo: Excell, pdf, XML o csv. 
Para ello simplemente pulsar sobre el link correspondiente en la parte inferior de la lista. Este fichero no queda almacenado 
en el sistema, pero usted tiene la opci�n de guardar una copia del documento en su ordenador pulsando en la opci�n <b>''Guardar''</b> 
de la aplicaci�n correspondiente en cada caso.'
where  IDIOMA IS NULL AND TIPO_OBJ=4;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO TR�MITE</h4></div><p>En esta pantalla se muestra la lista de tr�mites que se pueden realizar 
en la fase actual en el expediente con el que est� trabajando.</p><p>La �ltima columna de la derecha muestra si ya se han creado 
tr�mites de ese tipo en el expediente.</p><p>Para crear un tr�mite nuevo hacer clic sobre el nombre del tr�mite.</p>'
where IDIOMA IS NULL AND TIPO_OBJ=5;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>PLAZOS</h4></div>
<P>Desde esta pantalla se puede realizar un seguimiento de los plazos vencidos. Muestra la lista de expedientes que tienen un plazo vencido.
Por cada uno de ellos muestra el n�mero de expediente, tipo de procedimiento, tipo de plazo y fecha de vencimiento.<P>Para moverse al
expediente, hacer clic sobre el n�mero de expediente.<P>Un plazo asociado a un tr�mite, dejar� de aparecer en esta lista al terminar 
el tr�mite.<P>Desde esta pantalla se pueden buscar los plazos que vencieron o vencer�n entre dos fechas. Para ello introducir la fecha
 inicial y final en la parte superior y hacer clic sobre <B>''Consultar''</B>. La fecha se ha de introducir en formato <B>dd/mm/aaaa</B>, o
 bien se puede seleccionar del calendario pulsando en el icono contiguo al campo fecha.<P>La lista de plazos se puede exportar a ficheros
 de tipo: Excell, pdf, XML o csv. Para ello simplemente pulsar sobre el link correspondiente en la parte inferior de la lista. 
Este fichero no queda almacenado en el sistema, pero usted tiene la opci�n de guardar una copia del documento en su ordenador pulsando 
en la opci�n ''Guardar como'' de la aplicaci�n correspondiente en cada caso.' 
where IDIOMA IS NULL AND TIPO_OBJ=6;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>LISTA DE REGISTROS DISTRIBUIDOS</h4></div><P>Muestra la lista de registros distribuidos
 accesibles por el usuario tramitador.<P>Para situarse sobre el registro distribuido hacer clic sobre el n�mero de registro.
<P>La lista de registros distribuidos se puede exportar a ficheros de tipo: Excel, PDF, XML o CSV. Para ello simplemente pulsar sobre
 el link correspondiente en la parte inferior de la lista. Este fichero no queda almacenado en el sistema, pero usted tiene la opci�n de
 guardar una copia del documento en su ordenador pulsando en la opci�n <B>''Guardar como''</B> de la aplicaci�n correspondiente en cada caso.' 
where IDIOMA IS NULL AND TIPO_OBJ=7;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion">
<h4>LISTA DE EXPEDIENTES</h4>
</div>
<p>Muestra una lista de expedientes seg�n el criterio de b�squeda seleccionado, a trav�s de un formulario de b�squeda.</p>
<p>Cada fila de la lista se corresponde a un expediente, y muestra una informaci�n b�sica de este, como es el n�mero, interesado principal,
 estado administrativo en el que se encuentra, etc�tera.</p>
<P>Para entrar dentro de un expediente, hacer clic sobre el n�mero de expediente. </p>
<P>La lista de expedientes se puede exportar a ficheros de tipo: Excell, pdf, XML o csv. Para ello simplemente pulsar sobre el link
 correspondiente en la parte inferior de la lista. Este fichero no queda almacenado en el sistema, pero usted tiene la opci�n de guardar 
una copia del documento en su ordenador pulsando en la opci�n ''Guardar como'' de la aplicaci�n correspondiente en cada caso.</p>' 
where IDIOMA IS NULL AND TIPO_OBJ=8;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>LISTA DE EXPEDIENTES</h4></div><P>Esta pantalla le muestra una lista con los avisos 
electr�nicos relacionados con expedientes de nuestra lista de trabajo. Estos avisos pueden provenir de otras aplicaciones, o por ejemplo 
nos puede indicar que se ha creado un expediente nuevo proveniente de registro telem�tico.<P>En la parte superior de la pantalla, se 
indica el n�mero de avisos totales de su bandeja, justo debajo le indica los mensajes que se est�n mostrando en la pantalla actual. Desde
 esta misma fila, se pude mover por las distintas p�ginas de avisos, as� como ir a la primera y �ltima p�gina.
<P>Un aviso puede tener tres estados: pendiente, en curso o finalizado. La lista s�lo muestra los avisos pendientes (sin leer) o en curso.
<P>Para cambiar el estado de un aviso, de pendiente a en curso, hacer clic sobre la opci�n <B>''Recibir''</B>.
<P>Para cambiar el estado de un aviso a finalizado, pulsar sobre la opci�n <B>''Finalizar''</B>. Un aviso al pasar a este estado, 
desaparecer� de nuestra bandeja de avisos.<P>Los avisos est�n relacionados siempre con un expediente de nuestra lista de trabajo. 
Para que la aplicaci�n nos mueva al expediente, pulsar sobre el n�mero de expediente en la lista de avisos.<P>La lista de avisos
 se puede exportar a ficheros de tipo: Excell, pdf, XML o csv. Para ello simplemente pulsar sobre el link correspondiente en la parte
 inferior de la lista. Este fichero no queda almacenado en el sistema, pero usted tiene la opci�n de guardar una copia del documento 
en su ordenador pulsando en la opici�n ''Guardar como'' de la aplicaci�n correspondiente en cada caso.' 
where IDIOMA IS NULL AND TIPO_OBJ=9;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>REGISTRO DISTRIBUIDO</h4></div><P>Muestra la informaci�n de un registro distribuido
 dividida en dos pesta�as: Distribuci�n y Registro de Entrada.<P>En la pesta�a "Distribuci�n", se muestra la informaci�n referente al
 registro distribuido en s�:<ul><li><b>Estado:</b> Estado del registro distribuido.</li><li><b>Fecha distribuci�n:</b> Fecha de
 distribuci�n del registro de entrada.</li><li><b>Mensaje:</b> Mensaje de la distribuci�n.</li></ul><P>En la pesta�a 
"Registro de Entrada", se muestra la informaci�n referente al registro de entrada relacionado con la distribuci�n:
<ul><li><b>N�mero registro:</b> N�mero de registro de entrada.</li><li><b>Remitente:</b> Remitente del registro de entrada.</li>
<li><b>Asunto:</b> Asunto del registro de entrada.</li></ul><P>Las acciones que se pueden realizar sobre el registro distribuido 
dependen del estado del mismo:<ul><li>Si el estado es <b>pendiente</b>, las acciones que se muestran son:<ul><li><b>Aceptar</b>: Acepta
 el registro distribuido para seguir trabajando con �l.</li><li><b>Rechazar</b>: Rechaza el registro distribuido.</li></ul></li><li>
Si el estado es <b>aceptado</b>, las acciones ser�n:<ul><li><b>Archivar</b>: Archiva el registro distribuido.</li>
<li><b>Iniciar Expediente</b>: Muestra la lista de procedimientos para iniciar un expediente a partir de la informaci�n del registro
 distribuido.</li><li><b>Anexar Expediente</b>: Muestra un formulario de b�squeda para seleccionar un expediente donde anexar los 
documentos del registro distribuido.</li></ul></li></ul>' 
where IDIOMA IS NULL AND TIPO_OBJ=10;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>LISTA EXPEDIENTES</h4></div><P>En esta pantalla se visualizar�n los expedientes
 que se encuentren en una fase, para un procedimiento determinado.<p>Para visualizar los datos de un expediente se pulsar� sobre
 el <b>N�mero de expediente</b> correspondiente.<p>La lista de expedientes podr� ser exportada a <b>cvs, Excel, xml y pdf</b> 
<p>Seleccionando uno o varios expedientes marcando los checks correspondientes de la izquierda de cada n�mero de expediente 
y pulsando sobre <b>Acciones</b> del men� de la izquierda de la pantalla se podr�:<p><li><b>Terminar fases</b></li>
<p><li><b>Delegar fases</b></li><p><li><b>Iniciar tramitaci�n agrupada</b></li>' 
where IDIOMA IS NULL AND TIPO_OBJ=11;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>PORTAFIRMAS</h4></div><P>Muestra una lista con los documentos pendientes de firmar
 electr�nicamente. Por cada documento indica el expediente al que pertenece, el autor y el estado.<P>Para firmar uno o varios 
documentos desde esta pantalla, selecci�nelos en la parte izquierda de la lista, luego pulsar en la opci�n <B>''Acciones''</B> del men� de
 la izquierda de la aplicaci�n, y dentro de este, en la opci�n <B>''Firmar''</B>.<P>Siga las indicaciones de pantalla para realizar la firma 
correctamente.'
where IDIOMA IS NULL AND TIPO_OBJ=12;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>INICIAR EXPEDIENTE</h4></div><p>Esta pantalla muestra la lista de procedimientos
 sobre los cuales se pueden crear nuevos expedientes.<p><p>Para crear un nuevo expediente, hacer clic sobre el nombre del 
procedimiento.<p><p>Si considera que no aparece en la lista alg�n procedimiento, h�galo saber a su administrador de sistemas, 
es probable que no tenga asignados permisos sobre �l.<p>' 
where IDIOMA IS NULL AND TIPO_OBJ=13;

update SPAC_AYUDAS
set CONTENIDO='<a class="enlace" name="inicio"></a><div class="cabecera_seccion"><h4>CAT�LOGO DE PROCEDIMIENTOS</h4></div>
<div class="titulo_ayuda"><label class="popUpInfo" >Informaci�n del cat�logo de procedimientos</label></div>
<p>El <b>Cat�logo de Procedimientos</b> es la herramienta de administraci�n de procedimientos administrativos 
que proporciona SIGEM. Esta herramienta permite a los responsables de procesos y m�todos de la organizaci�n 
crear y mantener el conjunto de <b>procedimientos administrativos</b> que se desean automatizar con la herramienta.</p>
<p>El cat�logo est� compuesto  por el conjunto de <b>entidades</b> que identifican y caracterizan los procedimientos 
administrativos de la organizaci�n; as� como por el conjunto de objetos que permiten estructurar y modelar 
dichos procesos siguiendo un modelo conceptual basado en <b>esquemas de tramitaci�n</b> que se articulan con <b>fases, 
tr�mites y documentos</b>, conformando flujos semireglados.</p>
<p>El Cat�logo contiene adicionalmente por cada objeto informaci�n de inter�s recogida en <b>fichas catalogr�ficas</b>. 
Por ejemplo para un procedimiento administrativo se podr� recoger informaci�n de la legislaci�n aplicable, 
�rgano  o departamento que resuelve, plazos de resoluci�n, forma de iniciaci�n, efecto del silencio 
administrativo, etc. </p>
<p>Las principales funciones que permite el cat�logo de procedimientos son:</p><ul> 
<li>Creaci�n y mantenimiento de los elementos que conforman los procedimientos:
<ul> <li><a class="enlace" href="#ctstagesList">Fases</a>, <a class="enlace" href="#cttasksList">Tr�mites</a>,
<a class="enlace" href="#cttpdocsList">Tipos de documentos</a>,<a class="enlace" href="#plantillas">Plantillas</a>,
<a class="enlace" href="#batchSign">Procesos de Firma</a>, etc.</li> </ul> </li> <br/>
<li>Construcci�n y mantenimiento de <a class="enlace" href="#ctproceduresTree">Procedimientos</a>:
<ul><li>Alta de nuevos procedimientos por creaci�n o clonaci�n.</li> <li>Modificaci�n de procedimientos existente.</li> 
<li>Mantenimiento de las fichas catalogr�ficas.</li></ul></li><br/><li>Creaci�n y mantenimiento de entidades de negocio
 asociadas a los procedimientos: <ul> <li><a class="enlace" href="#entities">Entidades</a>, <a class="enlace" href="#validationTables">
Tablas de Validaci�n</a>,<a class="enlace" href="#rules">Reglas</a><a class="enlace" href="#searchForms">Formularios de B�squeda</a>,
<a class="enlace" href="#calendars">Calendarios</a>,<a class="enlace" href="#reports">Informes</a>,<a class="enlace" href="#varSystem">
Variables del sistema</a>,y <a class="enlace" href="#helps">Ayudas</a>.</li></ul></li> <br/>
<li>Gesti�n del componente de <a class="enlace" href="#publisher">publicaci�n</a>.</li></ul> <div id="ctstagesList">
<br/><a class="enlace" href="#inicio">Inicio</a><br/><br/><div class="titulo_ayuda"><label class="popUpInfo" >Inventario >> Fases</label>
</div><br/>En el inventario de fases se pueden ver todas las fases dadas de alta en el sistema.<br><br>Pulsando sobre el <b>nombre</b> 
de la fase se pueden ver las <b>propiedades</b> de �sta:<br><br><br>El nombre de la fase ser� el que vea el tramitador de un procedimiento
 desde la herramienta de tramitaci�n.<br><br>Mediante el bot�n ''<b>Tr�mites asociados</b>'' de la parte superior del formulario se
 pueden ver los tr�mites que se han asociado a la fase mediante el cat�logo. Desde esta opci�n se pueden asociar nuevos tr�mites a la fase.
<br><br>Para asociar tr�mites a una fase en un procedimiento en concreto, previamente esos tr�mites han de estar asociados a la fase en el 
inventario.<br><br>Desde la opci�n ''<b>Ver uso</b>'' se ver�n los procedimientos que hacen uso de la fase actual.<br><br>
Se pueden modificar los datos de una fase mediante el formulario visto en la pantalla anterior. <br><br>Pulsando ''Aceptar'' estos cambios 
se guardan en el sistema.<br/></div><div id="cttasksList"><br/><a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda">
<label class="popUpInfo" >Inventario >> Tr�mites</label></div><br/>En el inventario de tr�mites pueden ver todos los tr�mites dados de alta 
en el sistema.<br><br>Pulsando sobre el <b>nombre</b> del tr�mite se pueden ver las propiedades del mismo:<br><br><br>
De los campos del tr�mite cabe destacar el nombre. Se corresponde con la etiqueta que ver� el usuario desde el tramitador de expedientes.
<br><br>Se describen a continuaci�n las opciones de la parte superior del formulario del tr�mite:<br><br><li><b>Aceptar</b>: guarda en base
 de datos los cambios que se introduzcan en el formulario.<br><br><li><b>Cancelar</b>: cancela los cambios, en caso de existir, y vuelve
 a la pantalla de inventario de tr�mites.<br><br><li><b>Documentos asociados</b>: muestra la relaci�n de documentos asociados al tr�mite actual. 
Desde la pantalla de documentos asociados se pueden adem�s asociar nuevos tipos de documentos al tr�mite.<br><br><br>
Para que un tipo de documento se vea desde un procedimiento dentro de un tr�mite, dicho tr�mite ha de tener el documento asociado desde 
esta opci�n.<br><br><li><b>Ver uso</b>: muestra la lista de procedimientos que tienen el tr�mite asociado, as� como la fase en la que est�n.
<br><br><li><b>Eliminar</b>: permite eliminar un tr�mite del cat�logo de tr�mites. No permitir� borrar tr�mites que se encuentren en uso.
<br/></div><div id="cttpdocsList"><br/><a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda">
<label class="popUpInfo" >Inventario >> Tipos de documentos</label></div><br>En el inventario de tipos de documentos se pueden ver todos 
los tipos de documentos dados de alta en el sistema.<br><br>Pulsando sobre el <b>nombre</b> del tipo de documento se pueden ver las 
propiedades del mismo.<br><br><br>Se detallan a continuaci�n las opciones de la parte superior del formulario de edici�n de un tipo de 
documento:<br><br><li><b>Aceptar</b>: guarda en base de datos los cambios realizados en el formulario.<br><br><li><b>Cancelar</b>: 
cancela los cambios realizados en el formulario, si se han producido, y vuelve a la pantalla de lista de tipos de documentos.
<br><br><li><b>Plantillas</b>: desde esta opci�n se pueden ver las plantillas asociadas a un tipo de documento, as� como asociar plantillas 
nuevas. <br><br><br>Las plantillas asociadas desde esta opci�n, se ver�n desde todos los procedimientos que tengan asociados los tr�mites que 
contengan el tipo de documento actual. Para asociar un tipo de documento a un procedimiento en concreto se usar� la opci�n ''Crear plantilla''
dentro del contexto del procedimiento.<br><br><li><b>Ver uso</b>: muestra los tr�mites que tienen asociado este tipo de documento.
<br><br><li><b>Eliminar</b>: permite eliminar el tipo de documento. No permitir� borrar tipos de documento que est�n en uso. 
<br><br><div class="aviso">Al borrar un tipo de documento borrar� las plantillas asociadas a este.</div></div><div id="plantillas">
<br/><a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda"><label class="popUpInfo" >Inventario >> Plantillas</label>
</div><br/>En el inventario de <b>Plantillas de documentos</b> se puede ver la lista de todas  las plantillas de documentos dadas de alta en 
el sistema, independientemente del tipo documental al que est�n asociadas.En el listado se indica, para cada plantilla, el tipo de documento 
al que esta asociada, y si es espec�fica o no. Desde esta pantalla se podr�n crear nuevas plantillas (s�lo de tipo  gen�rico), modificar las
existentes, o eliminarlas.Para ver la ficha de una plantilla se debe pulsar sobre el <b>nombre</b>.
Las opciones de esta pantalla son similares a las descritas en <a class="enlace" href="#cttpdocsList">Tipos de documentos</a><br/><br/>
</div><div id="ctsubprocesosList"><br/><a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda"><label class="popUpInfo" >
Inventario >> Subprocesos</label></div><br/>En el inventario de <br>Subprocesos</b> se puede ver la lista de subprocesos dados de alta en el 
sistema.Se podr�n crear nuevos subprocesos, modificar los existentes, o eliminar aquellos que no est�n en uso.Pulsando sobre el <b>nombre</b> 
de un subproceso, podremos acceder al mismo.Las acciones que se pueden realizar sobre un subproceso son:<ul><li><b>Editor gr�fico</b>: 
Permite visualizar el subproceso con sus actividades y flujos.</li><li><b>Mostrar informaci�n extendida</b>: Recarga la parte izquierda de la
 ventana mostrando informaci�n acerca del flujo existente entre las actividades.</li><li><b>Clonar</b>: Crea un nuevo subproceso a partir del 
actual.</li><li><b>A�adir actividad</b>: En el caso de que el subproceso est� en estado borrador se ofrece la posibilidad de a�adir nuevas 
actividades. </li></ul>En caso contrario esta opci�n no estar�a visible.</li>Para poder asociar un subproceso a un tr�mite, debe estar en 
estado vigente.En la pesta�a de ficha podremos realizar las siguientes acciones:<ul><li><b>Eliminar Borrador</b>: Se eliminar� la versi�n 
actual del subproceso, volviendo a una versi�n anterior,si es que existiera o eliminando definitivamente el subproceso en caso contrario. 
</li><li><b>Pasar a vigente</b>: Para asociar un subproceso a un tr�mite es necesario que est� en estado vigente,si a�n est� en estado borrador
 mediante esta opci�n se pasa a vigente.</li><li><b>Eliminar</b>: Cuando un subproceso est� en estado vigente lo podremos eliminar siempre y 
cuando no este asociado a ning�n tr�mite.</li></ul>En la pesta�a de propiedades se muestra el listado de versiones del subproceso e informaci�n 
del subproceso.El nombre del subproceso ser� lo que ver� el usuario en la selecci�n del subproceso asociado a un tr�mite.En la pesta�a de 
eventos se muestra el listado de eventos asociados al subproceso.</div><div id="batchSign"><br/><a class="enlace" href="#inicio">Inicio</a>
<br/><div class="titulo_ayuda"><label class="popUpInfo" >Inventario >> Procesos de firma</label></div><br/>En el <b>inventario de procesos de 
firma</b> se pueden ver todos los procesos de firma dados de alta en el sistema.Estos procesos ser�n usados en el sistema tramitador para 
establecer el circuito de firma que deben seguir determinados documentos.<br/><br/>Para definir un proceso de firma, deberemos seleccionar 
los <b>firmantes</b>, y establecer su orden concreto en el circuito; podremos a�adir, eliminar o sustituir firmantes.Un firmante ser� un 
elemento de la <b>organizaci�n</b> del sistema: usuario, departamento...</div><div id="ctproceduresTree"><a class="enlace" href="#inicio">
Inicio</a><div class="titulo_ayuda"><label class="popUpInfo" >Inventario >> Procedimientos</label></div><br/>En la parte central de la 
pantalla muestra el �rbol de procedimientos, organizado por familias de procedimientos. Desde esta pantalla se podr�n crear nuevas familias, 
o acceder a la informaci�n de cada procedimiento.<br/><br/>Pulsando sobre el nombre del procedimiento se accede a la siguiente informaci�n:
<br/><ul> <li><a class="enlace" href="#pcdFlow">Esquema de tramitaci�n</a>:<br/><br/><ul> <li>Fases, Tr�mites, Tipos de documentos y 
Plantillas</li></ul></li><br/><li>Informaci�n espec�fica de cada elemento del esquema de tramitaci�n:<br/><br/><ul><li><a class="enlace" 
href="#pcdCard">Procedimiento</a></li><br/><li><a class="enlace" href="#stgCard">Fase</a></li><br/><li><a class="enlace" href="#tskCard">
Tr�mite</a></li><br/><li><a class="enlace" href="#tpdcCard">Tipo de documento</a></li><br/><li><a class="enlace" href="#tmpltCard">Plantilla</a>
</li><br/></ul></li></ul><br/><br/></div><div id="entities"><a class="enlace" href="#inicio">Inicio</a><div class="titulo_ayuda"><label 
class="popUpInfo" >Componentes >> Entidades</label><br/>Para la parametrizaci�n de procedimientos administrativos se cuenta con 
<b>Entidades</b>, que permiten almacenar informaci�n estructurada de los distintos expedientes.<br><br>Existen una serie de entidades 
precargadas que son comunes a todos los procedimientos, aunque adicionalmente se pueden crear nuevas entidades para cubrir los datos 
espec�ficos de de cada caso.<br><br>En el <b>cat�logo de Entidades</b> se muestran todas las entidades dadas de alta en el sistema.
<br><br>Al <b>crear</b> una entidad desde el cat�logo de procedimientos se crear� una tabla en base de datos, con los campos introducidos
 por el usuario, m�s una serie de campos de control requeridospor el sistema.<br><br>Pulsando sobre el <b>nombre</b> de la entidad, se 
accede a las <b>propiedades</b> de la misma:<br><br><ul><li><b>Datos generales de la entidad</b>:</li><br><br><ul>
<li>Nombre: Nombre que se utilizar� en SIGEM para hacer referencia a la entidad.<li>Tabla BD</li>: Indica el nombre de la tabla en la 
base de datos.<li>Descripci�n: Objetivo de la entidad.</ul><br><br>
<li><b>Campos de la entidad</b>: en esta ventana se visualizan los distintos campos de la entidad. Para crear uno nuevo pulsar la opci�n 
''A�adir''.<br><br><ul><li>Etiqueta</li>: Nombre que tendr� el dato en los formularios <li>Columna BD</li>: Nombre que tendr� la columna en 
la base de datos.<li>Descripci�n</li>: Objetivo del campo. <li>Tipo</li>: Tipo de campo, seleccionable de una lista de valores disponibles.
<li>Tama�o</li>: Tama�o del campo, en caso de seleccionar un campo de tipo texto o decimal <li>Precisi�n</li>: Precisi�n del campo, en caso 
de seleccionar un campo de tipo decimal</ul><br><br><li><b>�ndices de entidad</b>: si se desea se pueden crear �ndices para algunos de los 
campos creados en el apartado anterior. Ser� interesante crear un �ndice sobre un campo cuando este se utilice mucho en las b�squedas y est�
 previsto que el volumen de datos de la entidad sea elevado.<br><br><ul><li>Clave �nica</li>: indica que el valor de un campo no se pueda
 repetir.</ul><br><br><li><b>Validaciones de la entidad</b>: se utiliza esta opci�n cuando el valor de un campo est� validado contra una serie
 de valores normalizados, en lugar de permitir que el usuario lo introduzca a mano. La validaci�n se realiza contra tablas de validaci�n, 
creadas y mantenidas en el propio sistema:<br><br><ul><li>Tabla</li>: se indica la tabla sobre la que se realizar� la validaci�n
</ul><br>Se ha de indicar adem�s si es obligatorio que el campo tenga alg�n valor, o si porel contrario puede estar vac�o.
<br><br><br><li><b>Formularios de la entidad</b>:Los formularios son empleados en el tramitador para que el usuario visualice e introduzca 
datos para una o varias entidades.<br><br>Un formulario inicialmente tiene una entidad principal, y se crea asociado a la misma, 
aunque puede combinar datos de varias de ellas.<br><br>Pulsando sobre el <b>nombre</b> de un formulario se pueden ver las <b>propiedades</b> 
de �sta:<br><br><ul><li>Nombre</li>: nombre con que se identificar� el formulario<br><br><li>Descripci�n</li>: nombre que ver� el usuario en el
 tramitador de expedientes en la pesta�a correspondiente al formulario.<br><br><li>Clase</li>: este campo viene cumplimentado por el sistema,
 aunque se permite cambiar. Indica la clase que va a implementar el formulario.<br><br><li>Par�metros</li>: Se pueden indicar, por ejemplo, 
entidades secundarias para el formulario o validaciones sobre los campos de la entidad, necesarias para la clase definida anteriormente.
<br><br>Por defecto vienen definidas las validaciones usadas en los campos validados de la entidad, para que en la visualizaci�n del formulario 
se muestren los controles de validaci�n correspondientes.<br><br><li>Formateador</li>: este campo permite definir qu� campos se van a 
visualizar cuando se muestren listas de entidades. Las listas de entidades se muestran cuando la relaci�n de la entidad con el expediente es 
de n a 1.<br><br><li>Ubicaci�n en servidor</li>: Indica la ruta donde se almacena el formulario en el servidor; se deber�
modificar este valor si se desea almancenarlo en otra ubicaci�n.</ul><br>Al crear una entidad, autom�ticamente se crea un <b>formulario por
 defecto</b> o <b>formulario de entidad</b>que muestra todos los campos de esta, y que se podr� utilizar desde los procedimientos. <br><br>
Todo formulario se puede modificar, y se pueden crear cuantos formularios se deseen por entidad;que se basar�n en el ''formulario de entidad''
 creado por defecto.<br><br><div class="aviso">Si se hacen cambios en la estructura de la entidad (nuevos campos o validaciones), se deber� 
regenerar el formulario de la entidad, y posteriormente regenerar los formularios creados a partir del mismo; si se han hecho cambios de dise�o
 o c�digo se perder�n, por lo que se recomienda guardar el dise�o y/o c�digo de los mismos para volver a introducir los cambios en los 
formularios regenerados.</div><br>Para <b>modificar un formulario</b>, desde la lista de formularios de una entidad, se pulsa sobre la 
<b>ruta del formulario</b>. Se mostrar� una ventana que permite descargar el formulario, tanto su dise�o .html como su c�digo .jsp, a un 
directorio local.<br><br><div class="aviso">Sobre el dise�o del formulario en formato .html, se podr� editar y modificar con cualquier editor
 de formularios, el aspecto de los campos, incluso introducir nuevos elementos, pero no se pueden cambiar los nombres ni tipos de los campos 
existentes.<br>Igualmente se podr� modificar el c�digo .jsp, para por ejemplo, introducir nuevos controles en el formulario, o validaciones 
javascript.</div><br>Una vez modificado el formulario, se puede <b>actualizar</b> en el cat�logo desde la misma ventana que se descarg�. 
Se pulsar� ''Examinar'' para localizar el formulario en el disco duro local, y ''Actualizar'' para subirlo al servidor y sustituir el 
existente. El sistema notificar� con una alarma si se han modificado datos de la estructura y no puede actualizar correctamente el formulario.
<br><br>Una vez hechos los cambios, el formulario estar� disponible para ser usado en el tramitador.</ul></div></div><div id="validationTables">
<a class="enlace" href="#inicio">Inicio</a><div class="titulo_ayuda"><label class="popUpInfo" >Componentes >> Tablas de validaci�n</label>
</div><br/>En el <b>cat�logo de Tablas de Validaci�n</b> se muestran todas las tablas de validaci�n dadas de alta en el sistema. Las tablas de 
validaci�n se usar�n en las entidades, para garantizar que los valores de un determinado campo ser�n elegidos entre unos determinados, 
definidos en dicha tabla de 	validaci�n. <br><br>Al crear una tabla de validaci�n, se crear� en base da datos la tabla f�sica 
correspondiente.<br><br><br>Hay disponibles dos tipos de tablas de validaci�n: <b>simples</b> y <b>con sustituto</b>: <br><br>
Las <b>tablas de validaci�n simples</b> son listas de valores posibles para un campo.<br><br>Las <b>tablas de validaci�n con sustituto</b> 
recogen pares valor-sustituto; el campo valor ser� almacenado en base de datos, mientras que en los formularios aparecer� el sustituto 
correspondiente,para un campo con este tipo de validaci�n.<br><br>Al dar de alta una tabla de validaci�n se pedir� la siguiente informaci�n:
<br><br><ul><li><b>Tabla</b>: nombre de la tabla en base de datos</li><br><br><li><b>Nombre</b>: nombre en la aplicaci�n para la tabla de 
validaci�n . Para crear uno nuevo pulsar la opci�n ''A�adir''.<br><br><li><b>Tipo</b>: simple o con sustituto. <br><br>	<li><b>Tama�o campo
 VALOR</b>: tama�o de dicho campo, por defecto ser� un texto de 10 caract�res.	<br><br>		<li><b>Tama�o campo SUSTITUTO</b>: tama�o de 
dicho campo, en las tablas con sustituto.	<br><br>	</ul>	Una vez creada una tabla, se puede visualizar su informaci�n, y a�adir, 
modificar o eliminar <b>valores</b>	a la misma, as� como marcar un valor como <b>vigente</b>. Un valor no vigente no se visualizar�	entre los 
disponibles para la validaci�n de un campo.	</div>	<div id="rules">		<a class="enlace" href="#inicio">Inicio</a>		
<div class="titulo_ayuda">			<label class="popUpInfo" >Componentes >> Reglas</label>		</div>		<br/>		
En el <b>cat�logo de Reglas</b> se muestran todas las reglas dadas de alta en el sistema.	<br>		
Una regla es una <b>clase java</b> que implementa el interfaz <b>IRule</b>, definido en la documentaci�n del sistema.	<br><br>	
Para dar de alta una regla, anteriormente hay que <b>implementar</b> su clase java de acuerdo a la estructura definida en la documentaci�n, 
y almacenarla en una ruta accesible desde el servidor de aplicaciones.	<br><br>		Una vez realizado esto, desde el cat�logo de reglas, 
pulsar <b>Nueva regla</b>, que mostrar� una pantalla 	donde se solicitar� la siguiente informaci�n:	<br><br>	<ul>
<li><b>Nombre</b>:</li> nombre de la regla. No puede tener espacios en blanco, ya que ser� 	invocada desde los tag de documento.
<br><br>	<li><b>Descripci�n</b>: indicaciones de la funcionalidad.	<br><br><li><b>Clase</b>: indica la ruta donde se ha dejado la clase
 en el servidor. 	<br><br>	</ul>	<br>		<div class="aviso">	Se debe consultar el manual de usuario del Cat�logo de Procedimientos
 para obtener la definici�n del interfaz IRule.	</div><br>	</div>	<div id="searchForms">		<a class="enlace" href="#inicio">Inicio</a>			<div class="titulo_ayuda">			<label class="popUpInfo" >Componentes >> Formularios de b�squeda</label>		</div>		<br/>		En el <b>cat�logo de Formularios de b�squeda</b> se muestran todas los formularios de b�squeda 	dados de alta en el sistema. Estos formularios se podr�n seleccionar en el sistema tramitador	para realizar las b�squedas, y en ellos definiremos sobre qu� campos de las entidades de los	procedimientos queremos aplicar los criterios.	<br><br>	
Para crear un formulario de b�squeda deberemos importar un xml con su <b>definici�n</b>, o bien	incorporarla directamente en el campo de texto correspondiente.	<br><br>	</div>			<div id="calendars">		<a class="enlace" href="#inicio">Inicio</a>			<div class="titulo_ayuda">			<label class="popUpInfo" >Componentes >> Calendarios</label>		</div>		<br/>		Para el c�lculo de plazos de ejecuci�n de los distintos elementos de la tramitaci�n (expediente, fase y tr�mite), 		cuando sea necesario descontar los d�as inh�biles, es necesario hacer uso del calendario correspondiente asociado		al �rgano de tramitaci�n. Para ello se proporciona una gesti�n de d�as considerados no laborables de la semana y		d�as festivos anuales agrupados en un calendario. 		La creaci�n de un nuevo calendario es posible realizarle desde cero, a�adiendo los festivos e identificando los		d�as no laborables de la semana o clonando un calendario ya existente. 
En cualquier de estos casos, una vez creado		se pueden a�adir los considerados festivos fijos, que son aquellos d�as que se consideran que 
son festivos para 		todos los a�os y para todas las provincias, localidades, etc.	</div>			<div id="reports">		
<a class="enlace" href="#inicio">Inicio</a>			<div class="titulo_ayuda">	<label class="popUpInfo" >Componentes >> Informes</label>	
</div>		<br/>		En el <b>cat�logo de Infomes</b> se muestra el listado de informes dados de alta en el sistema.	Los informes podr�n 
ser de cuatro tipos:		<ul>		<li>Espec�ficos: informes que, para estar disponibles, han de asociarse expl�citamente a un 
procedimiento, bien a nivel general, o bien en el contexto de una de sus fases o tr�mites. </li><li>Gen�ricos: informes que estar�n 
disponibles en todos los procedimientos, desde cualquiera 		de sus fases y tr�mites.</li><li>Globales: informes que estar�n disponibles
 en la p�gina inicial del tramitador.</li>		<li>B�squeda: informes que estar�n disponibles al mostrar el resultado de la b�squeda, si el
 informe ha sido asociado al formulario de b�squeda.</li>		Los informes se dar�n de alta para su posterior uso en la definici�n de los 
procedimientos, 		formulario de b�squeda o en la bandeja de entrada.</div><div id="varSystem"><a class="enlace" href="#inicio">Inicio</a>
<div class="titulo_ayuda">			<label class="popUpInfo" >Componentes >> Componentes >> Variables Sistema</label></div><br/>
En el <b> cat�logo de variables de sistema</b>, se definen las variables que  almacenar�n informaci�n de configuraci�n para el correcto
 funcionamiento del sistema	</div><div id="helps"><a class="enlace" href="#inicio">Inicio</a><div class="titulo_ayuda">	<label 
class="popUpInfo" >Componentes >> Ayudas</label></div><br/>En el <b>cat�logo de Ayudas</b> se muestra el listado de ayudas dadas de alta en 
el sistema.		Pulsando sobre el <b>nombre</b> de la ayuda se pueden ver las propiedades del mismo:<br><br><br>De los campos de la ayuda el 
m�s destacado es <b>Contenido</b> ya que el texto que aqu� se indique		ser� el que el usuario visualize cuando pulse sobre el icono de 
ayuda.	</div>	<div id="pcdFlow"><a class="enlace" href="#inicio">Inicio</a><div class="titulo_ayuda"><label class="popUpInfo" >
Procedimiento >> Esquema de tramitaci�n</label></div><br/>El esquema de tramitaci�n de un procedimiento se conforma con una serie de fases 
secuenciales, cada una	con unos determinados tr�mites asociados. Esta informaci�n se define en el momento de la creaci�n del 	procedimiento; 
no as� los tipos de documentos que son gen�ricos por tr�mite. Las plantillas para cada	tipo de documento pueden ser gen�ricas (creadas a 
trav�s del inventario), o espec�ficas para uno o varios	procedimientos.	<br><br>		Seleccionando un elemento del esquema de tramitaci�n, 
veremos su informaci�n espec�fica (ficha catalogr�fica,	propiedades...) desplegada en la parte derecha de la pantalla; as� como las acciones 
posibles para cada contexto:	<br><br>		<li><b>Procedimiento</b></li>: 	<br><br>	<b>Clonar procedimiento</b>	<br><br>
Se crear� un procedimiento clonado del actual, pudiendo en el proceso modificarse la asociaci�n	de fases y tr�mites. As� mismo se
puede definir si el nuevo procedimiento conformar� una nueva 	familia, o ser� hermano o hijo del actual.	<br><br><li><b>Fase</b></li>
<br><br><b>A�adir tr�mite</b><br><br>Se permite a�adir un tr�mite a la fase actual, seleccionando entre aquellos definidos en el	
inventario para dicha fase.	<br><br>		<li><b>Tr�mite</b></li>	<br><br>	<b>Eliminar tr�mite</b>	<br><br>Se permite desasociar el 
tr�mite actual de su fase correspondiente dentro del contexto del procedimiento. 	Esta acci�n no implica la eliminaci�n del tr�mite, que
 quedar� asociado a la misma fase en el inventario.	<br><br>		<li><b>Tipo de documento</b></li>	<br><br>	
En el �rbol del procedimiento se ver�n las plantillas dependiendo del tipo de documento seleccionado: 	se mostrar�n tanto las gen�ricas 
como las espec�ficas al procedimiento. <br><br>		<b>Crear plantillas asociadas a un procedimiento</b>	<br><br>		
Para crear plantillas asociadas a un procedimiento, hay que situarse en el �rbol del 	procedimiento, en un tipo de documento concreto, 
y pulsar ''Crear plantilla''. 	<br><br>		Esta acci�n crear� una plantilla accesible �nicamente desde el procedimiento actual, 
aunque	se podr� gestionar desde el inventario de tipos de documentos, y asociar a otros procedimientos	a trav�s de la opci�n 
"A�adir plantilla".	<br><br>		<b>A�adir a un procedimiento una plantilla existente</b><br><br>Adem�s de poder crear plantillas 
espec�ficas para un procedimiento tambi�n se pueden asociar otras 	ya existentes en otros procedimientos.<br><br>Para ello desde el �rbol 
del procedimiento, pulsar sobre el tipo de documento. En la parte superior 	pulsar la opci�n ''A�adir plantilla''.<br><br>El sistema mostrar�
 las plantillas asociadas a ese tipo de documento en otros procedimientos. 	Seleccionarndo el deseado se a�adir� al prodecimiento actual.<br>
<br>	<div class="aviso">		Al asociar una plantilla a varios procedimientos, hay que tener en cuenta que cualquier modificaci�n a dicha
 plantilla afectar� a todos los procedimientos implicados.	</div><br>	<li><b>Plantilla</b></li><br><br><b>Eliminar Plantilla</b><br><br>
Para las plantillas espec�ficas, se permite eliminar la asociaci�n al procedimiento actual.	<br><br><div class="aviso">	Si se elimina una 
plantilla asociada �nicamente a un procedimiento, esta plantilla se borrar�		f�sicamente.	</div><br>	</div>	<div id="pcdCard"><br/>
<a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda"><label class="popUpInfo" >Esquema del Procedimiento >> Fichas>> Procedimiento
</label></div><br/>Seleccionando un elemento del esquema de tramitaci�n, veremos su informaci�n espec�fica (ficha catalogr�fica,
propiedades...) desplegada en la parte derecha de la pantalla; dicha informaci�n se clasifica en funci�n de	su naturaleza en distintas 
apartados que describiremos a continuaci�n.<br><br><ul><li><b>Procedimiento</b>: <br><br><ul><li><b>Ficha</b></li><br><br>El procedimiento 
tiene un formulario asociado con los datos de �ste. Estos datos se corresponden en su mayor�a a 	datos normativos y de clasificaci�n. 
Cabe destacar de cara a la tramitaci�n:	<br><br>		<ul>	<li><b>Datos Normativos -> Documentaci�n a aportar</b></li>: se trata de un 
campo en el que cada l�nea se 	corresponde con un documento que el ciudadano ha de aportar para solicitar un expediente de este 	
tipo de procedimiento. Esta informaci�n permite que el tramitador realice la subsanaci�n de forma sencilla.	<br><br>	</ul>	
Un procedimiento en estado <b>Borrador</b> deber� ser <b>pasado a Vigente</b> para poder ser usado	desde el tramitador de expedientes. 
Si por el contrario no se desea conservar el procedimiento, 	podr� ser eliminado siempre que est� en estado de borrador.
<br><br>Para un procedimiento <b>Vigente</b>, podremos crear un borrador que posteriormente podremos modificar	y a su vez pasar a vigente: 
la versi�n actual pasar�a en ese caso a ser <b>hist�rica</b>.	<br><br>		<li><b>Propiedades</b></li>	<br><br>
Se deber� establecer el responsable de un procedimiento para, al iniciar un expediente desde el tramitador, poder establecer la persona,
 grupo o departamento responsable de su tramitaci�n.	<br><br>		Desde esta pantalla podremos acceder a las distintas versiones 
existentes del procedimiento actual.	<br><br>	<li><b>Eventos</b></li>	<br><br>	Mediante la pesta�a <b>Eventos</b>, 
se podr�n asociar reglas a distintos momentos de la tramitaci�n. 	Las reglas a asociar se dan de alta en el propio cat�logo, 
Componentes >> Reglas. <br><br>	Los eventos posibles de un expediente son los siguientes:	<br><br>	<ul>	<li><b>Iniciar</b></li>: 
se dispara este evento cuando se inicia un expediente	<br><br>		<li><b>Terminar</b></li>: al cerrar la �ltima fase del expediente.	
<br><br>		<li><b>Reubicar</b></li>: al devolver una fase.	<br><br>		<li><b>Expirar plazo</b></li>: cuando se vence el plazo de 
resoluci�n del expediente.	<br><br>		<li><b>Calcular responsable</b></li>: se lanza al crear el expediente cuando calcula el 
responsable.	<br><br>	<li><b>Calcular n�mero de expediente</b></li>: al iniciar el expediente en la acci�n de calcular el n�mero 
de expediente.	<br><br>	</ul>	 Se podr� indicar el orden de ejecuci�n de las reglas, as� como borrar la asociaci�n de eventos y reglas
al procedimiento.<br><br><li><b>Entidades</b></li><br><br>Si el procedimiento necesita datos de negocio espec�ficos, se han de crear las 
entidades necesarias, 	y asociarlas una vez creado el procedimiento mediante la opci�n <b>Agregar</b>.<br><br>Por defecto el procedimiento
 incluir� las entidades: expedientes, tr�mites, intervinientes y documentos. 	Si el procedimiento se ha clonado a partir de otro, adem�s
 incluir� las entidades espec�ficas que tuviera �ste.	<br><br>	A cada una de las entidades se le debe asignar un formulario que ser� 
usado en la visualizaci�n de un 	expediente de este tipo en la tramitaci�n. Al agregar una entidad, se le asigna el formulario por 	
defecto correspondiente, pudiendo ser modificado por el usuario.	<br><br>	<li><b>Permisos</b></li><br><br>Para que un procedimiento
 sea instanciable en el tramitador por un usuario o grupo de usuarios, hay que 	darles el permiso correspondiente. <br><br> Esto se gestiona
 desde la pesta�a ''Permisos'': 	la pantalla muestra los permisos que ya est�n asignados (el caso de crear el procedimiento a partir de 	otro, 
heredar� los permisos del procedimiento original), y permite eliminarlos o a�adir nuevos.<br><br>Para asignar nuevos permisos se debe pulsar
 la opci�n <b>Asignar permisos</b>:	<br><br>	Desde aqu� se pueden asignar permisos a departamentos, grupos y usuarios. Pulsando sobre
 <b>''Organizaci�n''</b>	se accede a los departamentos de la organizaci�n.	<br><br>		Pulsando "<b>Grupos</b>", se accede a los
 grupos de la organizaci�n. 	<br><br>		En ambos casos, para bajar a un nivel inferior, se debe pulsar sobre el nombre del 
grupo/departamento. 	Cuando se haya situado en el deseado, se debe pulsar ''Seleccionar'', y seleccionar la opci�n "Iniciar 	expedientes".
	<br><br>		<li><b>Plazos</b></li>	<br><br>	Indica el plazo de resoluci�n de un expediente. Esto har� que el tramitador env�e 
alarmas cuando el 	expediente se exceda del plazo de resoluci�n.	<br><br>	Se puede definir el plazo bien sobre la fecha de inicio de
 un expediente, bien sobre el valor de una fecha 	concreta elegida entre las fechas de las entidades asociadas al procedimiento, o sobre 
una fecha 	obtenida a partir de una regla.	<br><br>		</ul>	</li>	</ul>	</div>	<div id="stgCard">		<br/>		
<a class="enlace" href="#inicio">Inicio</a>		<br/>			<div class="titulo_ayuda">			<label class="popUpInfo" >
Esquema del Procedimiento >> Fichas >> Fase</label>		</div>		<br/>		Seleccionando un elemento del esquema de tramitaci�n, 
veremos su informaci�n espec�fica (ficha catalogr�fica,	propiedades...) desplegada en la parte derecha de la pantalla; dicha informaci�n 
se clasifica en funci�n de	su naturaleza en distintas apartados que describiremos a continuaci�n. 	<br><br>		<ul>	<li><b>Fase</b>: 
	<br><br>	<ul>	<li><b>Ficha</b></li>	<br><br>	Se muestran los datos identificativos de la fase, recogidos del inventario de fases.
	<br><br>		<li><b>Propiedades</b></li>	<br><br>	Se podr� indicar el responsable de la fase para, al iniciarse en el tramitador	
esta fase para un expediente, se establezca una persona, grupo o departamento 	como responsable de la tramitaci�n.	<br><br><li><b>Eventos</b>
</li>	<br><br>	Mediante la pesta�a <b>Eventos</b>, se podr�n asociar reglas a distintos momentos de la tramitaci�n. Las reglas a asociar
 se dan de alta en el propio cat�logo, Componentes >> Reglas. <br><br>	Los eventos posibles para una fase son los siguientes:	<br><br>	
<ul>	<li><b>Iniciar</b></li>: se dispara este evento cuando se inicia la fase	<br><br>		<li><b>Terminar</b></li>: 
al cerrar la fase	<br><br>		<li><b>Reubicar</b></li>: al devolver una fase.	<br><br>		<li><b>Expirar plazo</b></li>: 
cuando se vence el plazo de resoluci�n del expediente.	<br><br>		<li><b>Calcular responsable</b></li>: se lanza, al crear la fase, 
cuando se calcula el responsable.	<br><br>	<li><b>Utilizar plantilla</b></li>: al utilizar una plantilla para un documento.<br><br><li>
<b>Crear documento</b></li>: al crear un documento.	<br><br></ul>Se podr� indicar el orden de ejecuci�n de las reglas, as� como borrar la 
asociaci�n de eventos y reglas	 a la fase.	<br><br>		<li><b>Plazos</b></li>	<br><br>	Indica el plazo de resoluci�n de un expediente.
Esto har� que el tramitador env�e alarmas cuando el 	expediente se exceda del plazo de resoluci�n.<br><br>Se puede definir el plazo bien 
sobre la fecha de inicio de la fase, bien sobre el valor de una fecha 	concreta elegida entre las fechas de las entidades asociadas al 
procedimiento, o sobre una fecha 	obtenida a partir de una regla.	<br><br>		</ul>	</li>	</ul>	</div>	<div id="tskCard"><br/>	
<a class="enlace" href="#inicio">Inicio</a>	<br/><div class="titulo_ayuda">	<label class="popUpInfo" >
Esquema del Procedimiento >> Fichas >> Tr�mite</label></div><br/>Seleccionando un elemento del esquema de tramitaci�n, veremos su 
informaci�n espec�fica (ficha catalogr�fica,	propiedades...) desplegada en la parte derecha de la pantalla; dicha informaci�n se 
clasifica en funci�n de	su naturaleza en distintas apartados que describiremos a continuaci�n. 	<br><br><ul><li><b>Tr�mite</b>: 
<br><br><ul><li><b>Ficha</b></li><br><br>Se muestran los datos identificativos del tr�mite, recogidos del inventario de tr�mites.
<br><br>		<li><b>Propiedades</b></li>	<br><br>		Se podr� modificar el nombre del tr�mite en el contexto del procedimiento
 actual; este	nombre se ver� como etiqueta del tr�mite dentro del tramitador.	<br><br>	Se podr� indicar el responsable del tr�mite para,
 al iniciarse en el tramitador	este tr�mite para un expediente, se establezca una persona, grupo o departamento 	como responsable de la 
tramitaci�n.	<br><br>		<li><b>Eventos</b></li>	<br><br>	Mediante la pesta�a <b>Eventos</b>, se podr�n asociar reglas a distintos 
momentos de la tramitaci�n. 	Las reglas a asociar se dan de alta en el propio cat�logo, Componentes >> Reglas. <br><br>	Los eventos 
posibles para un tr�mite son los siguientes:	<br><br>	<ul>	<li><b>Iniciar</b></li>: se dispara este evento cuando se inicia el 
tr�mite	<br><br>		<li><b>Terminar</b></li>: al cerrar el tr�mite	<br><br>		<li><b>Expirar plazo</b></li>: cuando se vence el 
plazo de resoluci�n del expediente.	<br><br>		<li><b>Calcular responsable</b></li>: se lanza, al crear la fase, cuando se calcula el
responsable.	<br><br>	<li><b>Utilizar plantilla</b></li>: al utilizar una plantilla para un documento.	<br><br>	<li><b>Crear
 documento</b></li>: al crear un documento.	<br><br>	</ul>	 Se podr� indicar el orden de ejecuci�n de las reglas, as� como borrar la
 asociaci�n de eventos y reglas	 al tr�mite.	<br><br>		<li><b>Plazos</b></li>	<br><br>	Indica el plazo de resoluci�n de un 
expediente. Esto har� que el tramitador env�e alarmas cuando el 	expediente se exceda del plazo de resoluci�n.	<br><br>	Se puede
 definir el plazo bien sobre la fecha de inicio del tr�mite, bien sobre el valor de una fecha 	concreta elegida entre las fechas de las 
entidades asociadas al procedimiento, o sobre una fecha 	obtenida a partir de una regla.	<br><br>		</ul>	</li>	</ul>	</div>
	<div id="tpdcCard">		<br/>		<a class="enlace" href="#inicio">Inicio</a>		<br/>			<div class="titulo_ayuda">			
<label class="popUpInfo" >Esquema del Procedimiento >> Fichas >> Tipo Documento</label>		</div>		<br/>		Seleccionando un 
elemento del esquema de tramitaci�n, veremos su informaci�n espec�fica (ficha catalogr�fica,	propiedades...) desplegada en la parte 
derecha de la pantalla; dicha informaci�n se clasifica en funci�n de	su naturaleza en distintas apartados que describiremos a continuaci�n.
 	<br><br>		<ul>	<li><b>Tipo de documento</b>: 	<br><br>	<ul>	<li><b>Ficha</b></li>	<br><br>	Se muestran los datos 
identificativos del tipo de documento, recogidos del inventario de tipos.<br><br></ul></li></ul></div><div id="tmpltCard"><br/>	
<a class="enlace" href="#inicio">Inicio</a><br/><div class="titulo_ayuda"><label class="popUpInfo" >
Esquema del Procedimiento >> Fichas >> Plantilla</label></div><br/>Seleccionando un elemento del esquema de tramitaci�n, veremos su informaci�n
 espec�fica (ficha catalogr�fica,	propiedades...) desplegada en la parte derecha de la pantalla; dicha informaci�n se clasifica en funci�n
 de	su naturaleza en distintas apartados que describiremos a continuaci�n. 	<br><br>		<ul>	<li><b>Plantilla</b>: <br><br><ul><li><b>
Ficha</b></li>	<br><br>	Se muestran los datos identificativos de la plantilla, recogidos del inventario de plantillas.	<br><br>Se podr� 
editar la plantilla para introducir cambios en la misma.		</ul>	</li>	</ul>	</div><div id="publisher">	<br/>	<a class="enlace" 
href="#inicio">Inicio</a>	<br/>	<div class="titulo_ayuda">	<label class="popUpInfo" >Publicador</label>	</div>	<br/>	SIGEM 
dispone de un componente denominado <b>Publicador</b>, encargado de comunicarse con sistemas externos	de forma as�ncrona. Un uso com�n de 
dicho publicador es el env�o de informaci�n de la tramitaci�n de un	expediente a un sistema externo, por ejemplo un sistema de informaci�n al 
ciudadano.	<br><br>	La l�gica de dicho publicador se recoge en <b>reglas</b>, que recogen la acci�n que se ejecutar�, para un evento 
de tramitaci�n determinado si se cumple una determinada condici�n. Tanto acciones como condiciones son	clases java que se han de implementar
 y posteriormente dar de alta en el cat�logo.<br><br>El publicador se compone de los siguientes elementos:<ul><li><b>Acciones</b></li><br><br>
	Son clases java que realizan una acci�n concreta, que ir�n asociadas a determinadas reglas, y que ejecutar� el publicador si se dispara una
 de dichas reglas.	<br><br>	<li><b>Condiciones</b></li><br><br>	Son clases de java que realizan una comprobaci�n, y que determinar�n si se
 ejecuta o no	la acci�n de la regla disparada.	<br><br>		<li><b>Aplicaciones</b></li><br><br>	Contexto o sistema externo destino 
de la publicaci�n de una regla y que recoger� la informaci�n 	publicada; las reglas se clasificar�n en funci�n de dicha aplicaci�n.<br><br>
	<li><b>Reglas</b></li><br><br>	Una regla recoge la acci�n que se desea ejecutar para un evento determinado. La regla vendr�	asociado a 
un contexto Procedimiento/Fase/Tr�mite/Tipo de documento, y su ejecuci�n vendr� deteminada por el cumplimiento de una determinada condici�n. 
	<br><br>	Se deber� indicar para cada regla:	<br><br>	<ul>	<li><b>Procedimiento</b>: procedimiento sobre el que se aplica la regla.
 Este campo es obligatorio.	</li><br>	<li><b>Fase</b>: fase sobre la que se aplica la regla.	</li><br>	<li><b>Tr�mite</b>: tr�mite sobre 
el que se aplica la regla.	</li><br>		<li><b>Tipo de documento</b>: tipo de documento sobre el que se aplica la regla.	</li><br>	
	<li><b>Evento</b>: momento en el que se disparar� la ejecuci�n de la regla. Este campo es obligatorio.</li><br><li><b>Info</b>: Informaci�n
 adicional sobre determinados eventos.	</li><br>			<li><b>Acci�n</b>: acci�n que se ejecutar� al disparar la regla, seleccionada
 entre las definidas en	el sistema.	</li><br>			<li><b>Condici�n</b>: condici�n que se ejecutar� para determinar si se dispara la 
regla, seleccionada 	entre las definidas en el sistema.	</li><br>			<li><b>Atributos</b>: xml de configuraci�n para la clase 
java que implementa la acci�n de la regla.	Para m�s detalle consultar la documentaci�n t�cnica.	</li><br>			<li><b>Aplicaci�n</b>:
 aplicaci�n contexto de la regla, seleccionada entre las definidas en el sistema.	</li><br></ul><br><li><b>Hitos err�neos</b></li>
<br><br>Desde esta opci�n se permite realizar el seguimientos de los errores que se han producido en la publicaci�n.Un hito err�neo podr�
 ser reactivado para que el publicador vuelva a tratarlo.	</div>'
where IDIOMA IS NULL AND TIPO_OBJ=31;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO</h4></div>Aparece una ventana emergente que le ir� guiando en la creaci�n
 del procedimiento.<br><br>En la primera pantalla debe introducir el nombre del procedimiento. 	<br><br>	Pulsar ''Siguiente'' para continuar
<br><br>'
where IDIOMA IS NULL AND TIPO_OBJ=32;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO > SELECCI�N DE FASES</h4></div>Seleccionar las fases que va a tener el 
procedimiento, en el listado de Fases disponibles, y luego pulsar la opci�n ''A�adir''.<br><br>El orden de las fases se puede modificar mediante
 las opciones ''Subir'' y ''Bajar''. <br><br>Para continuar pulsar ''Siguiente'''
where IDIOMA IS NULL AND TIPO_OBJ=33;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO > FASES > TR�MITES POR FASE</h4></div>Por cada una de las fases habr� que
 asociar los tr�mites. <br>Para ello pulsar en la opci�n ''Asignar tr�mites''. <br><br>Una vez completados todos los tr�mites de todas las fases, 
pulsar ''Siguiente''. ' 
where IDIOMA IS NULL AND TIPO_OBJ=34;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO > FASES > SELECCI�N DE TR�MITES POR FASE</h4></div>
Seleccionar los tr�mites que va a tener la fase, en el listado de Tr�mites disponibles, y luego pulsar la opci�n ''A�adir''.
<br><br>	El orden de los tr�mites se puede modificar mediante las opciones ''Subir'' y ''Bajar''. <br><br>Una vez
 seleccionados todos los tr�mites de la fase, pulsar ''Volver'' para situarse en la pantalla anterior.' 
where IDIOMA IS NULL AND TIPO_OBJ=35;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO > RESUMEN CREACI�N</h4></div>El sistema muestra una pantalla resumen de 
las fases y tr�mites del procedimiento. 	<br><br>	Si todo es correcto, pulsar ''Crear procedimiento''.'
where IDIOMA IS NULL AND TIPO_OBJ=36;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO PROCEDIMIENTO > RESULTADO CREACI�N</h4></div>El sistema informa del resultado de la 
creaci�n del procedimiento. 	<br><br>	Para consultar y editar el nuevo procedimiento creado, pulsar ''Ver nuevo procedimiento''.'
where IDIOMA IS NULL AND TIPO_OBJ=37;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO SUBPROCESO</h4></div>Aparece una ventana emergente que le ir� guiando en la creaci�n
 del subproceso. <br><br>En la primera pantalla debe introducir el nombre del subproceso. <br><br>Pulsar ''Siguiente'' para continuar<br><br>'
where IDIOMA IS NULL AND TIPO_OBJ=38;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO SUBPROCESO > SELECCI�N DE ACTIVIDADES</h4></div>Seleccionar las actividades que va a 
tener el subproceso, en el listado de Actividades disponibles, y luego pulsar la opci�n ''A�adir''.<br><br>El orden de las actividades se puede
 modificar mediante las opciones ''Subir'' y ''Bajar''. <br><br>Para continuar pulsar ''Siguiente''.'
where IDIOMA IS NULL AND TIPO_OBJ=39;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO SUBPROCESO > RESUMEN CREACI�N</h4></div>El sistema muestra una pantalla resumen de las
 actividades del subproceso. <br><br>.Si todo es correcto, pulsar ''Crear subproceso''.' 
where IDIOMA IS NULL AND TIPO_OBJ=40;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>NUEVO SUBPROCESO > RESULTADO CREACI�N</h4></div>El sistema informa del resultado de la
 creaci�n del subproceso. 	<br><br>	Para consultar y editar el nuevo subproceso creado, pulsar ''Ver nuevo subproceso''.'
where IDIOMA IS NULL AND TIPO_OBJ=41;

update SPAC_AYUDAS
set CONTENIDO='<div class="cabecera_seccion"><h4>DISE�ADOR GR�FICO</h4></div>El <b>Dise�ador Gr�fico</b> es la herramienta que proporciona
 SIGEM para visualizar los procedimientos y facilitar la tarea al dise�ador. Esta herramienta permite a los responsables de procesos y 
m�todos de la organizaci�n 	crear y mantener el conjunto de <b>procedimientos administrativos</b> que se desean automatizar con la herramienta.	
<br><br><h3>Barra de herramientas</h3><div>Nombre del procedimiento : Estado Si Estado=Borrador, se le permitir� al usuario:Insertar una nueva
 <b>Fase</b>, arrastrando la imagen  que tiene una F .Insertar un nuevo <b>nodo de sincronizaci�n de tipo And</b>, arrastrando la imagen con
 que tiene una Y. Insertar un nuevo <b>nodo de sincronizaci�n de tipo Or</b>, arrastando la imagen que tiene una O .Insertar nuevos
 <b>flujos</b>, haciendo click sobre la imagen de la punta de flecha , si se hace click con el bot�n izquierdo s�lo estar� habilitado 
para realizar una conexi�n, si se hace click con el bot�n derecho del rat�n se crearan todos los flujos que el usuario desee hasta que se 
pulse con un click sobre la imagen de la punta de flecha.Para realizar una conexi�n una vez hayamos habilitado la flecha seleccionaremos 
con un click la pareja de elementos que formen parte del nuevo flujo.La imagen de una impresora que nos permite imprimir lo que en ese momento 
tengamos en la pantalla.El icono de ayuda nos muestra la ayuda del dise�ador gr�fico</div><br/><br/><h3>Editor de condiciones </h3>	<div>
Un flujo puede tener asociado una condici�n para ello se mostrar� sobre el flujo un icono con un ?, pulsado sobre la flecha con el 
bot�n derecho del rat�n se visualizar� un listado de las condiciones Java (Reglas) como sobre BBDD (SQL) que el usuario haya asociado
 al flujo , una condicion sql se podr� visualizar, pulsando sobre el nombre de la misma.Para modificar la condici�n el procedimiento 
deber� estar en estado borrador y se podr�n a�adir y eliminar condiciones o modificar una condici�n sql.Estructura de una condici�n:
 <ul><li>	 Nombre de la condici�n: Nombre que el usuario quiere darle a la condici�n SQL</li><li>	 Cuerpo de la condici�n: Se representa
 con una tabla que tendr� cada una de las condiciones simples que en su conjunto forman el cuerpo de la condici�n.</li><li>	 Condici�n simple:
 <ul><li>Selector parentesis</li><li>Selector de condici�n: Siempre y cuando no sea la primera condici�n simple.</li><li>	
 Operando 1: Esta compuesto de dos selectores uno se corresponde con las entidades definidas para el procedimiento en el que estamos, 
cuando seleccionamos una entidad se carga en el otro selector los campos que tiene la entidad seleccionada.	 	
Operador:  Selector con el que indicaremos la operaci�n a realizar en la condici�n simple, en funci�n del selector seleccionado se	 
mostrar�n los operandos o no.</li><li>Operando 2: Por defecto se mostrar� un checkbox sin chequear y una caja de 
texto para que el usuario la rellene si desea realizar la comprobaci�n con un dato introducido por �l, en caso contrario,
 es decir que se quiera realizar la comprobaci�n contra un campo de la bbdd se chequear� el checkbox y aparecer�n dos 
selectores, siendo el primero una lista de las entidades,una vez que el usuario seleccione una, se cargar� los campos de 
la entidad seleccionada y que se correspondan en tipo con el campo del operando1 seleccionado, si no hay se ha seleccionado nada en el
 operando 1 , no se cargar� ning�n campo.<li></li>Operando 3: Mismo funcionamiento que el operando 2. </li></ul></li></ul></div>'
where IDIOMA IS NULL AND TIPO_OBJ=42;

INSERT INTO spac_ayudas( id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Procedimiento de Reclamaciones, quejas y sugerencias', 3, 3, NULL, '');
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FORMULARIO EXPEDIENTE</h4></div><p>La pantalla que se muestra es la del &#147;expediente abierto&#148;, es decir, es como si se abriera una carpeta f�sica con un expediente en formato papel y tuviera unos separadores por: <b>Expediente, Datos espec�ficos, Participantes y Documentos</b>.</p><p><ul><li><b>Expediente</b>: Se muestran los datos principales del expediente, en la zona superior, y del Interesado principal, en la zona inferior.</li><p><li><b>Datos espec�ficos</b>:se muestran los datos particulares del procedimiento que se est� tramitando.</li><p><li><b>Participantes</b>: se muestra el formulario para dar de alta o consultar los datos de las personas relacionadas con el Expediente.</li><p><li><b>Documentos</b>: consta de dos zonas, la superior donde se ven, en este caso los documentos con todos sus campos y se podr� acceder a abrir su imagen y la parte inferior en donde se muestran en formato tabla, todos los documentos del expediente.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<p>Los documentos se a�aden al expediente, generalmente, desde los tr�mites de cada fase, pero hay expedientes que se dise�an de manera que se le pueden a�adir documentos desde esta pesta�a de Documentos.</p><p>Para ver todos los campos de informaci�n de un documento y sus im�genes, se seleccionar� de la lista inferior, pulsando sobre su nombre. Se comprobar� que sus datos se muestran en la parte superior. Seleccionando el bot�n <b>Ver documento</b> (situado debajo de las pesta�as), se abrir� el documento.</p></li></ul><p>Desde el men� de la izquierda de la pantalla se podr�n realizar las siguientes acciones:</p><p><ul><li>Pulsando el bot�n <b>Acciones</b> se podr� <b>Delegar fase</b> o <b>Clonar expediente</b>.</li><p><li>Crear un <b>Nuevo tr�mite</b> pulsando el bot�n del mismo nombre.</li><p><li>Pulsar el bot�n <b>Avanzar fase</b> para que el expediente que hay en pantalla avance de fase.</li><p><li>Pulsar <b> Tr�mites</b>  para visualizar los tr�mites por los que ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'ha pasado el expediente.</li><p><li>Pulsar <b>Expedientes relacionados</b> para visualizar los expedientes relacionados.</li></ul><div class="titulo_ayuda"><label class="popUpInfo" >Informaci�n del tr�mite</label></div><p>Debajo de la etiqueta <b>Tr�mite/Documento</b>, hay una l�nea informativa en donde se visualiza: el nombre del tr�mite actual y la fecha interna de iniciaci�n.<p>Debajo de esa l�nea se encuentran los siguientes campos del Tr�mite:<p><ul><li><b>Departamento responsable</b>:campo que rellena la aplicaci�n con el valor del departamento que realiza el tr�mite</li><p><li><b>Tramitador responsable</b>:campo que rellena la aplicaci�n, con el nombre del usuario que lo realiza</li><p><li><b>Fecha inicio plazo</b>:campo que rellenar� el usuario, seleccionando una fecha desde el  icono calendario</li><p><li><b>Plazo</b>:un n�mero de unidades: d�as, meses, a�os para el plazo</li><p><li><b>Unidades de Plazo</b>:se seleccionar� el icono Lupa y se mostrar�n en una ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'nueva ventana, las distintas unidades de plazo existentes, de las cuales se seleccionar� el valor correspondiente</li><p><li><b>Fecha Alarma</b>:este campo lo cumplimenta la aplicaci�n y ser� el que se utilice para avisar al usuario tramitador, que le vence un plazo</li></ul><p>En la parte inferior de la pantalla,bajo la etiqueta: <B>DOCUMENTOS ADJUNTOS</b>, se encuentra la zona de documentos del tr�mite, en donde se visualizar�n los documentos del tr�mite si los hubiera.<p>Desde esta pantalla se podr�n realizar las siguientes acciones para <b>Generar documentos</b>:<p><ul><li>Pulsar <b>Desde plantilla</b> para seleccionar una plantilla de la lista de plantillas asociadas al tr�mite<p>El usuario pulsar� sobre la que corresponda y se mostrar� el documento normalizado, con los datos del expediente incluidos en �l<p>Este documento, a no ser que se defina en el tr�mite de otra manera, es modificable, por si se quiere complementar con alg�n dato, cambiar una expresi�n, etc.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'</li><p><li>Pulsar <b>Anexar fichero</b> para selecci�n del tipo de documento que se va a anexar en el tr�mite</li></ul><p>Tanto si se genera un documento desde una plantilla o anexando un fichero, en la parte inferior de la pantalla de tr�mites se muestra el tr�mite con el fichero anexado y en la parte izquierda el nuevo tr�mite en la lista de tr�mites.<p>Para borrar un documento, en un tr�mite abierto, si se ha generado o anexado por error. Se seleccionar� en la pantalla anterior el documento que se quiera borrar y se pulsar�<b>Borrar documento</b>.<p>Para finalizar el tr�mite se pulsar� <b>Terminar tr�mite</b>.<p>Un tr�mite se puede eliminar siempre que se encuentre abierto, una vez realizado, no es ni modificable. Para borrar un tr�mite, se seleccionar� el bot�n de la pantalla de realizaci�n de tr�mites: <b>Eliminar tr�mite</b>.<p>Para delegar un tr�mite se pulsar� el bot�n <b>Delegar</b> y se seleccionar� el Destinatario.</p>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FICHA DEL PROCEDIMIENTO</h4></div><table><tr><td colspan=4><b>DATOS T�CNICOS DEL PROCEDIMIENTO</B></td></tr><tr><td><b>FASES</b></td><td><b>Inicio</b></td><td>Tr�mites</td><td>Admisi�n a Tr�mite</td></tr><tr><td colspan=3></td><td>Comunicaci�n de apertura</td></tr><tr><td></td><td><b>Instrucci�n</b></td><td>Tr�mites</td><td>Emisi�n Oficio de Respuesta</td></tr><tr><td colspan=3></td><td>Notificaci�n Oficio de Respuesta</td></tr><tr><td colspan=3></td><td>Emisi�n Informe</td></tr><tr><td></td><td><b>Terminaci�n</b></td><td>Tr�mites</td><td>Remisi�n Documentaci�n</td></tr><tr><td colspan=3></td><td>Comunicaci�n al interesado</td></tr><tr><td colspan=3></td><td>Emisi�n Oficio No Admisi�n</td></tr><tr><td colspan=3></td><td>Notificaci�n</td></tr><tr><td colspan=3></td><td>Archivo de Expediente</td></tr><tr><td colspan=3><b>Resoluci�n</b></td><td>Responsable �rea de Atenci�n al Cliente</td></tr><tr><td colspan=3><b>Plazo m�ximo de Notificaci�n</b></td><td>3 meses ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'desde la entrada de la Solicitud en el Registro</td></tr><tr><td colspan=3><b>Tipo de Tramitaci�n</b></td><td>Presencial y Telem�tica</td></tr><tr><td colspan=3><b>Efectos del Silencio Administrativo</b></td><td>Estimatorio, excepto que su concesi�n sea contraria a la legislaci�n urban�stica o se concedan al solicitante o a terceros facultades relativas al dominio o al servicio p�blico</td></tr><tr><td colspan=3><b>Documentaci�n Requerida</b></td><td>Solicitud de la Reclamaci�n, Queja o Sugerencia</td></tr><tr><td colspan=4><b>NORMATIVA APLICABLE</b></td></tr><tr><td><b>T�tulo</b></td><td colspan=3>Ejemplo: Plan General o Ley </td></tr><tr><td><b>�mbito</b></td><td colspan=3></td></tr><tr><td><b>Fecha Vigor</b></td><td></td><td><b>Fecha publicaci�n</b></td><td></td></table>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=3;

INSERT INTO spac_ayudas (id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Procedimiento de Concesi�n de subvenci�n', 3, 4, NULL, '');
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FORMULARIO EXPEDIENTE</h4></div><p>La pantalla que se muestra es la del &#147;expediente abierto&#148;, es decir, es como si se abriera una carpeta f�sica con un expediente en formato papel y tuviera unos separadores por: <b>Expediente, Datos espec�ficos, Participantes y Documentos</b>.</p><p><ul><li><b>Expediente</b>: Se muestran los datos principales del expediente, en la zona superior, y del Interesado principal, en la zona inferior.</li><p><li><b>Datos espec�ficos</b>:se muestran los datos particulares del procedimiento que se est� tramitando.</li><p><li><b>Participantes</b>: se muestra el formulario para dar de alta o consultar los datos de las personas relacionadas con el Expediente.</li><p><li><b>Documentos</b>: consta de dos zonas, la superior donde se ven, en este caso los documentos con todos sus campos y se podr� acceder a abrir su imagen y la parte inferior en donde se muestran en formato tabla, todos los documentos del expediente.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<p>Los documentos se a�aden al expediente, generalmente, desde los tr�mites de cada fase, pero hay expedientes que se dise�an de manera que se le pueden a�adir documentos desde esta pesta�a de Documentos.</p><p>Para ver todos los campos de informaci�n de un documento y sus im�genes, se seleccionar� de la lista inferior, pulsando sobre su nombre. Se comprobar� que sus datos se muestran en la parte superior. Seleccionando el bot�n <b>Ver documento</b> (situado debajo de las pesta�as), se abrir� el documento.</p></li></ul><p>Desde el men� de la izquierda de la pantalla se podr�n realizar las siguientes acciones:</p><p><ul><li>Pulsando el bot�n <b>Acciones</b> se podr� <b>Delegar fase</b> o <b>Clonar expediente</b>.</li><p><li>Crear un <b>Nuevo tr�mite</b> pulsando el bot�n del mismo nombre.</li><p><li>Pulsar el bot�n <b>Avanzar fase</b> para que el expediente que hay en pantalla avance de fase.</li><p><li>Pulsar <b> Tr�mites</b>  para visualizar los tr�mites por los que ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'ha pasado el expediente.</li><p><li>Pulsar <b>Expedientes relacionados</b> para visualizar los expedientes relacionados.</li></ul><div class="titulo_ayuda"><label class="popUpInfo" >Informaci�n del tr�mite</label></div><p>Debajo de la etiqueta <b>Tr�mite/Documento</b>, hay una l�nea informativa en donde se visualiza: el nombre del tr�mite actual y la fecha interna de iniciaci�n.<p>Debajo de esa l�nea se encuentran los siguientes campos del Tr�mite:<p><ul><li><b>Departamento responsable</b>:campo que rellena la aplicaci�n con el valor del departamento que realiza el tr�mite</li><p><li><b>Tramitador responsable</b>:campo que rellena la aplicaci�n, con el nombre del usuario que lo realiza</li><p><li><b>Fecha inicio plazo</b>:campo que rellenar� el usuario, seleccionando una fecha desde el  icono calendario</li><p><li><b>Plazo</b>:un n�mero de unidades: d�as, meses, a�os para el plazo</li><p><li><b>Unidades de Plazo</b>:se seleccionar� el icono Lupa y se mostrar�n en una ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'nueva ventana, las distintas unidades de plazo existentes, de las cuales se seleccionar� el valor correspondiente</li><p><li><b>Fecha Alarma</b>:este campo lo cumplimenta la aplicaci�n y ser� el que se utilice para avisar al usuario tramitador, que le vence un plazo</li></ul><p>En la parte inferior de la pantalla,bajo la etiqueta: <B>DOCUMENTOS ADJUNTOS</b>, se encuentra la zona de documentos del tr�mite, en donde se visualizar�n los documentos del tr�mite si los hubiera.<p>Desde esta pantalla se podr�n realizar las siguientes acciones para <b>Generar documentos</b>:<p><ul><li>Pulsar <b>Desde plantilla</b> para seleccionar una plantilla de la lista de plantillas asociadas al tr�mite<p>El usuario pulsar� sobre la que corresponda y se mostrar� el documento normalizado, con los datos del expediente incluidos en �l<p>Este documento, a no ser que se defina en el tr�mite de otra manera, es modificable, por si se quiere complementar con alg�n dato, cambiar una expresi�n, etc.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'</li><p><li>Pulsar <b>Anexar fichero</b> para selecci�n del tipo de documento que se va a anexar en el tr�mite</li></ul><p>Tanto si se genera un documento desde una plantilla o anexando un fichero, en la parte inferior de la pantalla de tr�mites se muestra el tr�mite con el fichero anexado y en la parte izquierda el nuevo tr�mite en la lista de tr�mites.<p>Para borrar un documento, en un tr�mite abierto, si se ha generado o anexado por error. Se seleccionar� en la pantalla anterior el documento que se quiera borrar y se pulsar�<b>Borrar documento</b>.<p>Para finalizar el tr�mite se pulsar� <b>Terminar tr�mite</b>.<p>Un tr�mite se puede eliminar siempre que se encuentre abierto, una vez realizado, no es ni modificable. Para borrar un tr�mite, se seleccionar� el bot�n de la pantalla de realizaci�n de tr�mites: <b>Eliminar tr�mite</b>.<p>Para delegar un tr�mite se pulsar� el bot�n <b>Delegar</b> y se seleccionar� el Destinatario.</p>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FICHA DEL PROCEDIMIENTO</h4></div><table><tr><td colspan=2><b>Nombre</b></td><td colspan=2><b>Descripci�n</b></td></tr><tr><td colspan=2>TSUB</td><td colspan=2>Subvenci�n gen�rica</td></tr><tr><td colspan=2><b>Familia de Procedimientos</b></td><td colspan=2><b>Descripci�n</b></td></tr><tr><td colspan=2>Subvenciones</td><td colspan=2>Procedimiento de concesi�n de una Subvenci�n</td></tr><tr><td colspan=2><b>Organismo al que pertenece</b></td><td colspan=2>Unidad organizativa concesionaria de la Subvenci�n</td></tr><tr><td colspan=2><b>Organismo competente</b></td><td colspan=2>�rea de Concesi�n de Subvenciones</td></tr><tr><td colspan=2><b>Organismo que tramita</b></td><td colspan=2>�rea de Concesi�n de Subvenciones</td></tr><tr><td colspan=2><b>Organismo que resuelve</b></td><td colspan=2>�rea de Concesi�n de Subvenciones</td></tr><tr><td colspan=2><b>Objeto</b></td>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<td colspan=2>Procedimiento administrativo para la concesi�n de una Subvenci�n</td></tr><tr><td colspan=4><b>DATOS T�CNICOS DEL PROCEDIMIENTO</b></td></tr><tr><td><b>FASES</b></td><td><b>Inicio</b></td><td>Tr�mites</td><td>Solicitud Subsanaci�n</td></tr><tr><td></td><td><b>Instrucci�n</b></td><td>Tr�mites</td><td>Propuesta de Resoluci�n</td></tr><tr><td colspan=3></td><td>Acuerdo Consejo Gobierno</td></tr><tr><td colspan=3></td><td>Notificaci�n</td></tr><tr><td colspan=3></td><td>Alegaciones</td></tr><tr><td></td><td><b>Terminaci�n</b></td><td>Tr�mites</td><td>Decreto de concesi�n</td></tr><tr><td colspan=3></td><td>Notificaci�n</td></tr><tr><td colspan=3></td><td>Archivo de Expediente</td></tr><tr><td colspan=3><b>Resoluci�n</b></td><td>Responsable �rea de Atenci�n al Cliente</td></tr><tr><td colspan=3><b>Plazo m�ximo de Notificaci�n</b></td><td>3 meses desde la entrada de la Solicitud en el Registro</td></tr>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<tr><td colspan=3><b>Tipo de Tramitaci�n</b></td><td>Presencial y Telem�tica</td></tr><tr><td colspan=3><b>fectos del Silencio Administrativo</b></td><td>Estimatorio, excepto que su concesi�n sea contraria a la legislaci�n urban�stica o se concedan al solicitante o a terceros facultades relativas al dominio o al servicio p�blico</td></tr><tr><td colspan=3><b>Documentaci�n Requerida</b></td><td>Solicitud de la Subvenci�n</td></tr><tr><td colspan=3></td><td>Documentos relativos a la Subvenci�n </td></tr><tr><td colspan=4><b>NORMATIVA APLICABLE</b></td></tr><tr><td><b>T�tulo</b></td><td colspan=3>Ejemplo: Plan General o Ley </td></tr><tr><td><b>�mbito</b></td><td colspan=3></td></tr><tr><td><b>Fecha Vigor</b></td><td></td><td><b>Fecha publicaci�n</b></td><td></td></table>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=4;

INSERT INTO spac_ayudas (id, nombre, tipo_obj, id_obj, idioma, contenido) VALUES (nextval('spac_sq_id_ayudas'), 'Procedimiento de Obras menores', 3, 5, NULL, '');
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FORMULARIO EXPEDIENTE</h4></div><p>La pantalla que se muestra es la del &#147;expediente abierto&#148;, es decir, es como si se abriera una carpeta f�sica con un expediente en formato papel y tuviera unos separadores por: <b>Expediente, Datos espec�ficos, Participantes y Documentos</b>.</p><p><ul><li><b>Expediente</b>: Se muestran los datos principales del expediente, en la zona superior, y del Interesado principal, en la zona inferior.</li><p><li><b>Datos espec�ficos</b>:se muestran los datos particulares del procedimiento que se est� tramitando.</li><p><li><b>Participantes</b>: se muestra el formulario para dar de alta o consultar los datos de las personas relacionadas con el Expediente.</li><p><li><b>Documentos</b>: consta de dos zonas, la superior donde se ven, en este caso los documentos con todos sus campos y se podr� acceder a abrir su imagen y la parte inferior en donde se muestran en formato tabla, todos los documentos del expediente.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<p>Los documentos se a�aden al expediente, generalmente, desde los tr�mites de cada fase, pero hay expedientes que se dise�an de manera que se le pueden a�adir documentos desde esta pesta�a de Documentos.</p><p>Para ver todos los campos de informaci�n de un documento y sus im�genes, se seleccionar� de la lista inferior, pulsando sobre su nombre. Se comprobar� que sus datos se muestran en la parte superior. Seleccionando el bot�n <b>Ver documento</b> (situado debajo de las pesta�as), se abrir� el documento.</p></li></ul><p>Desde el men� de la izquierda de la pantalla se podr�n realizar las siguientes acciones:</p><p><ul><li>Pulsando el bot�n <b>Acciones</b> se podr� <b>Delegar fase</b> o <b>Clonar expediente</b>.</li><p><li>Crear un <b>Nuevo tr�mite</b> pulsando el bot�n del mismo nombre.</li><p><li>Pulsar el bot�n <b>Avanzar fase</b> para que el expediente que hay en pantalla avance de fase.</li><p><li>Pulsar <b> Tr�mites</b>  para visualizar los tr�mites por los que ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'ha pasado el expediente.</li><p><li>Pulsar <b>Expedientes relacionados</b> para visualizar los expedientes relacionados.</li></ul><div class="titulo_ayuda"><label class="popUpInfo" >Informaci�n del tr�mite</label></div><p>Debajo de la etiqueta <b>Tr�mite/Documento</b>, hay una l�nea informativa en donde se visualiza: el nombre del tr�mite actual y la fecha interna de iniciaci�n.<p>Debajo de esa l�nea se encuentran los siguientes campos del Tr�mite:<p><ul><li><b>Departamento responsable</b>:campo que rellena la aplicaci�n con el valor del departamento que realiza el tr�mite</li><p><li><b>Tramitador responsable</b>:campo que rellena la aplicaci�n, con el nombre del usuario que lo realiza</li><p><li><b>Fecha inicio plazo</b>:campo que rellenar� el usuario, seleccionando una fecha desde el  icono calendario</li><p><li><b>Plazo</b>:un n�mero de unidades: d�as, meses, a�os para el plazo</li><p><li><b>Unidades de Plazo</b>:se seleccionar� el icono Lupa y se mostrar�n en una ' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'nueva ventana, las distintas unidades de plazo existentes, de las cuales se seleccionar� el valor correspondiente</li><p><li><b>Fecha Alarma</b>:este campo lo cumplimenta la aplicaci�n y ser� el que se utilice para avisar al usuario tramitador, que le vence un plazo</li></ul><p>En la parte inferior de la pantalla,bajo la etiqueta: <B>DOCUMENTOS ADJUNTOS</b>, se encuentra la zona de documentos del tr�mite, en donde se visualizar�n los documentos del tr�mite si los hubiera.<p>Desde esta pantalla se podr�n realizar las siguientes acciones para <b>Generar documentos</b>:<p><ul><li>Pulsar <b>Desde plantilla</b> para seleccionar una plantilla de la lista de plantillas asociadas al tr�mite<p>El usuario pulsar� sobre la que corresponda y se mostrar� el documento normalizado, con los datos del expediente incluidos en �l<p>Este documento, a no ser que se defina en el tr�mite de otra manera, es modificable, por si se quiere complementar con alg�n dato, cambiar una expresi�n, etc.' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'</li><p><li>Pulsar <b>Anexar fichero</b> para selecci�n del tipo de documento que se va a anexar en el tr�mite</li></ul><p>Tanto si se genera un documento desde una plantilla o anexando un fichero, en la parte inferior de la pantalla de tr�mites se muestra el tr�mite con el fichero anexado y en la parte izquierda el nuevo tr�mite en la lista de tr�mites.<p>Para borrar un documento, en un tr�mite abierto, si se ha generado o anexado por error. Se seleccionar� en la pantalla anterior el documento que se quiera borrar y se pulsar�<b>Borrar documento</b>.<p>Para finalizar el tr�mite se pulsar� <b>Terminar tr�mite</b>.<p>Un tr�mite se puede eliminar siempre que se encuentre abierto, una vez realizado, no es ni modificable. Para borrar un tr�mite, se seleccionar� el bot�n de la pantalla de realizaci�n de tr�mites: <b>Eliminar tr�mite</b>.<p>Para delegar un tr�mite se pulsar� el bot�n <b>Delegar</b> y se seleccionar� el Destinatario.</p>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<div class="cabecera_seccion"><h4>FICHA DEL PROCEDIMIENTO</h4></div><table><tr><td colspan=2><b>Nombre</b></td><td colspan=2><b>Descripci�n</b></td></tr><tr><td colspan=2>TLOM</td><td colspan=2>Licencia de Obra Menor</td></tr><tr><td colspan=2><b>Familia de Procedimientos</b></td><td colspan=2><b>Descripci�n</b></td></tr><tr><td colspan=2>Urbanismo</td><td colspan=2>Procedimiento de Urbanismo y �rea T�cnica</td></tr><tr><td colspan=2><b>Organismo al que pertenece</b></td><td colspan=2>Urbanismo y �rea T�cnica</td></tr><tr><td colspan=2><b>Organismo competente</b></td><td colspan=2>Urbanismo y �rea T�cnica</td></tr><tr><td colspan=2><b>Organismo que tramita</b></td><td colspan=2>Urbanismo y �rea T�cnica</td></tr><tr><td colspan=2><b>Organismo que resuelve</b></td><td colspan=2>Urbanismo y �rea T�cnica</td></tr><tr><td colspan=2><b<Objeto</b></td><td colspan=2>Procedimiento administrativo para la concesi�n de Licencia de Obra Menor</td></tr>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<tr><td colspan=4><b>DATOS T�CNICOS DEL PROCEDIMIENTO</b></td></tr><tr><td><b>FASES</b></td><td><b>Inicio</b></td><td>Tr�mites</td><td>Solicitud subsanaci�n</td></tr><tr><td></td><td><b>Instrucci�n</b></td><td>Tr�mites</td><td>Emisi�n informe</td></tr><tr><td colspan=3></td><td>Propuesta de resoluci�n</td></tr><tr><td colspan=3></td><td>Notificaci�n</td></tr><tr><td colspan=3></td><td>Alegaciones</td></tr><tr><td></td><td><b>Terminaci�n</b></td><td>Tr�mites</td><td>Archivo del expediente</td></tr><tr><td colspan=3></td><td>Resoluci�n expediente</td></tr><tr><td colspan=3></td><td>Notificaci�n resoluci�n</td></tr><tr><td colspan=3><b>Resoluci�n</b></td><td>TTE. Alcalde delegado de Urbanismo por delegaci�n del Alcalde-Presidente</td></tr><tr><td colspan=3><b>Plazo m�ximo de Notificaci�n</b></td><td>3 meses desde la entrada de la Solicitud en el Registro</td></tr><tr><td colspan=3><b>Tipo de Tramitaci�n</b></td><td>Presencial y Telem�tica</td></tr>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;
UPDATE SPAC_AYUDAS set CONTENIDO=CONTENIDO||'<tr><td colspan=3><b>Efectos del Silencio Administrativo</b></td><td>Estimatorio, excepto que su concesi�n sea contraria a la legislaci�n urban�stica o se concedan al solicitante o a terceros facultades relativas al dominio o al servicio p�blico</td></tr><tr><td colspan=3><b>Documentaci�n Requerida</b></td><td>Solicitud de la Licencia de Obra Menor</td></tr><tr><td colspan=3></td><td>Nota Simple Registral o</td></tr><tr><td colspan=3></td><td>Certificado de la Comisi�n Local de Casco Hist�rico (vivienda en casco hist�rico)</td></tr><tr><td colspan=4><b>NORMATIVA APLICABLE</b></td></tr><tr><td><b>T�tulo</b></td><td colspan=3>Ejemplo: Plan General o Ley </td></tr><tr><td><b>�mbito</b></td><td colspan=3>de Ordenaci�n Urbana de ...</td></tr><tr><td><b>Fecha Vigor<b></td><td></td><td><b>Fecha publicaci�n</b></td><td></td></table>' where IDIOMA IS NULL AND TIPO_OBJ=3 AND ID_OBJ=5;


--Se amplia el tama�o del campo NREG a 64
ALTER TABLE spac_dt_documentos ALTER COLUMN nreg TYPE character varying(64);
ALTER TABLE spac_expedientes ALTER COLUMN nreg TYPE character varying(64);


--Se a�ade una columna m�s a spac_procesos para indicar la fecha de eliminacion
ALTER TABLE SPAC_PROCESOS ADD COLUMN fecha_eliminacion timestamp without time zone;

--Se a�ade una columna m�s a spac_procesos spac_fases y spac_tramites para guardar el estado anterior 
ALTER TABLE SPAC_PROCESOS ADD COLUMN estado_anterior smallint;
ALTER TABLE SPAC_FASES ADD COLUMN estado_anterior smallint;
ALTER TABLE SPAC_TRAMITES ADD COLUMN estado_anterior smallint;

--
-- Se a�aden dos columnas m�s a spac_procesos spac_fases y spac_tramites para guardar el nombre del responsable 
-- y el nombre del responsable secundario.
--
ALTER TABLE SPAC_PROCESOS ADD COLUMN RESP CHARACTER VARYING(250);
ALTER TABLE SPAC_FASES ADD COLUMN RESP CHARACTER VARYING (250);
ALTER TABLE SPAC_TRAMITES ADD COLUMN RESP CHARACTER VARYING (250);
ALTER TABLE SPAC_PROCESOS ADD COLUMN RESP_SEC CHARACTER VARYING(250);
ALTER TABLE SPAC_FASES ADD COLUMN RESP_SEC CHARACTER VARYING (250);
ALTER TABLE SPAC_TRAMITES ADD COLUMN RESP_SEC CHARACTER VARYING (250);


--
-- Actualizaci�n de la vista de plazos
--

CREATE OR REPLACE VIEW spac_deadline AS 
SELECT obj.numexp, obj.fecha_limite, procedimiento.nombre AS nombre_pcd, obj.id_resp, obj.id AS ID_OBJETO, 'Resoluci�n Expediente' AS descripcion, 1 AS tipo
   FROM spac_procesos obj, spac_ct_procedimientos procedimiento
  WHERE obj.id_pcd = procedimiento.id AND obj.estado = 1 AND obj.fecha_limite IS NOT NULL
UNION 
 SELECT obj.numexp, obj.fecha_limite, procedimiento.nombre AS nombre_pcd, obj.id_resp, obj.id AS ID_OBJETO, 'Resoluci�n Fase' AS descripcion, 2 AS tipo
   FROM spac_fases obj, spac_ct_procedimientos procedimiento
  WHERE obj.id_pcd = procedimiento.id AND obj.estado = 1 AND obj.tipo=1 AND obj.fecha_limite IS NOT NULL
UNION 
 SELECT obj.numexp, obj.fecha_limite, procedimiento.nombre AS nombre_pcd, obj.id_resp, obj.id AS ID_OBJETO, obj.nombre AS descripcion, 3 AS tipo
   FROM spac_tramites obj, spac_ct_procedimientos procedimiento
  WHERE obj.id_pcd = procedimiento.id AND obj.estado = 1 AND obj.fecha_limite IS NOT NULL
UNION 
 SELECT obj.numexp, obj.fecha_limite, procedimiento.nombre AS nombre_pcd, obj.id_resp, obj.id AS ID_OBJETO, 'Resoluci�n Actividad' AS descripcion, 4 AS tipo
   FROM spac_fases obj, spac_p_procedimientos procedimiento
  WHERE obj.id_pcd = procedimiento.id AND obj.estado = 1 AND obj.tipo=2 AND obj.fecha_limite IS NOT NULL;


--
-- Creaci�n de �ndices
--

CREATE INDEX spac_expedientes_ix_numexp ON spac_expedientes (numexp);
CREATE INDEX spac_dt_documentos_ix_numexp ON spac_dt_documentos (numexp);
CREATE INDEX spac_dt_tramites_ix_numexp ON spac_dt_tramites (numexp);
CREATE INDEX spac_dt_tramites_ix_idtramexp ON  spac_dt_tramites (id_tram_exp);
CREATE INDEX spac_dt_int_ix_numexp ON  spac_dt_intervinientes (numexp);

CREATE INDEX spac_procesos_ix_numexp ON spac_procesos (numexp);
CREATE INDEX spac_procesos_ix_idresp ON spac_procesos (id_resp);
CREATE INDEX spac_fases_ix_numexp ON spac_fases (numexp);
CREATE INDEX spac_fases_ix_idresp ON spac_fases (id_resp);
CREATE INDEX SPAC_tramites_ix_numexp ON SPAC_tramites (numexp);
CREATE INDEX SPAC_tramites_ix_idresp ON SPAC_tramites (id_resp);


