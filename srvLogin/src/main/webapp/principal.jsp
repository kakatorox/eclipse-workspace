<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Usuario Conectado<c:out value="${sessionScope.usuarioConectado}"></c:out> </h1>

	<form action="/srvLogin/srvLogOut.srv" method="get">
		<input type="submit" value="Login" class="btn float-right login_btn">
	</form>

</body>
</html>