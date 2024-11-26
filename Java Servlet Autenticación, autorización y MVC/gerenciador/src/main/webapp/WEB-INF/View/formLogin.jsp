<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServlet"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${linkServlet}" method="post">
		Login: <input type="text" name="login"/>
		Contrasena: <input type="text" name="password"/>
		<input type="hidden" name="accion" value="Login">
		<input type="submit"/>
	</form>
</body>
</html>