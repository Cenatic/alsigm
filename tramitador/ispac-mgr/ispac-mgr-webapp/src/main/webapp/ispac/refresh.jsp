<%@ taglib uri="/WEB-INF/ispac-util.tld" prefix="ispac" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
<body>
<link rel="stylesheet" href='<ispac:rewrite href="css/estilos.css"/>'/>
			<!--[if lte IE 5]>
		<link rel="stylesheet" type="text/css" href='<ispac:rewrite href="css/estilos_ie5.css"/>'/>
	<![endif]-->

	<!--[if IE 6]>
		<link rel="stylesheet" type="text/css" href='<ispac:rewrite href="css/estilos_ie6.css"/>'>
	<![endif]-->

	<!--[if gte IE 7]>
		<link rel="stylesheet" type="text/css" href='<ispac:rewrite href="css/estilos_ie7.css"/>'>
	<![endif]-->
	<script type="text/javascript" src='<ispac:rewrite href="../scripts/jquery-1.3.2.min.js"/>'></script>
  	<script type="text/javascript" src='<ispac:rewrite href="../scripts/jquery-ui-1.7.2.custom.min.js"/>'></script>
 	<script type="text/javascript" src='<ispac:rewrite href="../scripts/jquery.alerts.js"/>'></script>


<bean:define id="refresh" name="refresh" type="java.lang.String" />

<script>

	function hideFrameNoRefresh() {
		top.hideFrame('workframe','<ispac:rewrite page="wait.jsp"/>');
	}

	if (window.name == 'ParentWindow') {

		// Si la p�gina principal lanza una excepci�n -> Refrescar la p�gina principal
		refresh='<%=refresh%>';
		if (refresh != 'false') {
			top.ispac_needToConfirm = false;
			// URL de refresco en el refresh
			top.document.location.href = '<ispac:rewrite action='<%=refresh%>'/>'
		}
		else {
			// Salvo refresh a false -> Cerrar el frame sin refrescar la p�gina principal
			hideFrameNoRefresh();
		}
	}
	else if (typeof top.hideFrame != 'undefined') {

		// Si la p�gina abierta en el frame lanza una excepci�n -> Mostrar el mensaje y cerrar el frame sin refrescar la p�gina principal
		window.document.location.href = '<ispac:rewrite page="noRefresh.jsp"/>';
	}

</script>

</body>
</html>