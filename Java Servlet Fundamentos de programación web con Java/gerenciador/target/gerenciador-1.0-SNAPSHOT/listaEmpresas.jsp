<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/eliminarEmpresa" var="linkServletEliminarEmpresa"/>
<c:url value="/mostrarEmpresa" var="linkServletModificarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:if test="${not empty empresa }">
		Empresa ${ empresa } registrada! <br/>
	</c:if>
	Lista de empresas: <br />
	
	<ul>
	
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${ empresa.nombre } - <fmt:formatDate value="${empresa.fechaAbertura }" pattern="dd/MM/yyyy"/>
				<a href="${linkServletModificarEmpresa}?id=${empresa.id}">Modificar</a>
				<a href="${linkServletEliminarEmpresa}?id=${empresa.id}">Eliminar</a>
			</li>
		</c:forEach>
	
	</ul>

</body>
</html>