<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	Usuario logueado: ${loginUsuario.login}
	<br>
	<c:if test="${not empty empresa }">
		Empresa ${ empresa } registrada! <br/>
	</c:if>
	Lista de empresas: <br />
	<ul>
	
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${ empresa.nombre } - <fmt:formatDate value="${empresa.fechaAbertura }" pattern="dd/MM/yyyy"/>
				<a href="${linkServlet}?accion=MostrarEmpresa&id=${empresa.id}">Modificar</a>
				<a href="${linkServlet}?accion=EliminarEmpresa&id=${empresa.id}">Eliminar</a>
			</li>
		</c:forEach>
	
	</ul>
	<c:import url="logout-parcial.jsp"/>
</body>
</html>