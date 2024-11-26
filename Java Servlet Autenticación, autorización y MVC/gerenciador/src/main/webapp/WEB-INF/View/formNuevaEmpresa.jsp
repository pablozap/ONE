<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Empresa</title>
</head>
<body>
	<form action="${linkServlet}" method="post">
		Nombre empresa: <input type="text" name="nombre"/>
		Fecha Abertura: <input type="text" name="fecha"/>
		<input type="hidden" name="accion" value="NuevaEmpresa">
		<input type="submit"/>
	</form>
	<c:import url="logout-parcial.jsp"/>
</body>
</html>