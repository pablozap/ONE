<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificando Empresa</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="post">
	
		Nombre empresa: <input type="text" name="nombre" value="${empresa.nombre}"/>
		Fecha Abertura: <input type="text" name="fecha" value=" <fmt:formatDate value="${empresa.fechaAbertura }" pattern="dd/MM/yyyy"/>"/>
		<input name="id" type="hidden" value="${empresa.id}">
		<input name="accion" type="hidden" value="ModificarEmpresa">

		<input type="submit"/>
	
	</form>
</body>
</html>