<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/ispac-util.tld" prefix="ispac" %>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Ayuda</title>
<meta http-equiv="" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href='<ispac:rewrite href="../../help/css/estilos.css"/>'/>
<script language="JavaScript" type="text/JavaScript">
<!--
function close_window() {
    window.close();
}
//-->
</script>
</head>
<body bgcolor="#ffffff">


<div align="center">
<table border="0" cellpadding="0" cellspacing="0" width="580">
  <tr>
   <td><img name="tabla_ayuda_r1_c1" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r1_c1.gif"/>' width="6" height="40" border="0" id="tabla_ayuda_r1_c1" alt="" /></td>
   <td><img name="tabla_ayuda_ico_ayuda" src='<ispac:rewrite href="../../help/img/tabla_ayuda_ico_ayuda.gif"/>' width="34" height="40" border="0" id="tabla_ayuda_ico_ayuda" alt="" /></td>
   <td width="502" height="40" background='<ispac:rewrite href="../../help/img/tabla_ayuda_encabezado.gif"/>'><span class="ayuda">FORMULARIO EXPEDIENTE</span></td>
   		<td><a href="#" onclick="close_window()"><img src='<ispac:rewrite href="../../help/img/tabla_ayuda_cerrar.gif"/>' alt="" name="tabla_ayuda_cerrar" width="32" height="40" border="0" id="tabla_ayuda_cerrar" /></a></td>
   <td><img name="tabla_ayuda_r1_c5" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r1_c5.gif"/>' width="6" height="40" border="0" id="tabla_ayuda_r1_c5" alt="" /></td>
  </tr>
  <tr>
   <td><img name="tabla_ayuda_r2_c1" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r2_c1.gif"/>' width="6" height="314" border="0" id="tabla_ayuda_r2_c1" alt="" /></td>
   		<td colspan="3" width="568" height="314">
			<div id="contenedor">


<p>La pantalla que se muestra es la del �expediente abierto�, es decir, es como si se abriera una carpeta f�sica con un expediente en formato papel y tuviera unos separadores por: <b>Expediente, Datos espec�ficos, Participantes y Documentos</b>.</p>
<p><ul><li><b>Expediente</b>: Se muestran los datos principales del expediente, en la zona superior, y del Interesado principal, en la zona inferior.</li>
<p><li><b>Datos espec�ficos</b>:se muestran los datos particulares del procedimiento que se est� tramitando.</li>
<p><li><b>Participantes</b>: se muestra el formulario para dar de alta o consultar los datos de las personas relacionadas con el Expediente.</li>
<p><li><b>Documentos</b>: consta de dos zonas, la superior donde se ven, en este caso los documentos con todos sus campos y se podr� acceder a abrir su imagen y la parte inferior en donde se muestran en formato tabla, todos los documentos del expediente.
<p>Los documentos se a�aden al expediente, generalmente, desde los tr�mites de cada fase, pero hay expedientes que se dise�an de manera que se le pueden a�adir documentos desde esta pesta�a de Documentos.</p>
<p>Para ver todos los campos de informaci�n de un documento y sus im�genes, se seleccionar� de la lista inferior, pulsando sobre su nombre. Se comprobar� que sus datos se muestran en la parte superior. Seleccionando el bot�n <b>Ver documento</b> (situado debajo de las pesta�as), se abrir� el documento.</p></li>
</ul>
<p>Desde el men� de la izquierda de la pantalla se podr�n realizar las siguientes acciones:</p>
<p><ul><li>Pulsando el bot�n <b>Acciones</b> se podr� <b>Delegar fase</b> o <b>Clonar expediente</b>.</li>
<p><li>Crear un <b>Nuevo tr�mite</b> pulsando el bot�n del mismo nombre.</li>
<p><li>Pulsar el bot�n <b>Avanzar fase</b> para que el expediente que hay en pantalla avance de fase.</li>
<p><li>Pulsar <a class="enlace" href='<ispac:onlinehelpHref fileName="taskDocs"/>'>Tr�mites</a> para visualizar los tr�mites por los que ha pasado el expediente.</li>
<p><li>Pulsar <b>Expedientes relacionados</b> para visualizar los expedientes relacionados.</li>
</ul>


			</div>			
			</td>
   <td><img name="tabla_ayuda_r2_c5" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r2_c5.gif"/>' width="6" height="314" border="0" id="tabla_ayuda_r2_c5" alt="" /></td>
  </tr>
  <tr>
   <td><img name="tabla_ayuda_r3_c1" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r3_c1.gif"/>' width="6" height="26" border="0" id="tabla_ayuda_r3_c1" alt="" /></td>
   <td colspan="3"><img name="tabla_ayuda_r3_c2" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r3_c2.gif"/>' width="568" height="26" border="0" id="tabla_ayuda_r3_c2" alt="" /></td>
   <td><img name="tabla_ayuda_r3_c5" src='<ispac:rewrite href="../../help/img/tabla_ayuda_r3_c5.gif"/>' width="6" height="26" border="0" id="tabla_ayuda_r3_c5" alt="" /></td>
  </tr>
</table>
</div>
</body>
</html>
