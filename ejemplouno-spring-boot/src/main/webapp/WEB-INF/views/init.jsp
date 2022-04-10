<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${mensaje}" /> </h1>
	<form action="/kakato/recive.do" method="post">
		<input type="text" name="apellido" />
		<button type="submit" value="enviar">enviar</button>
	</form>
	
</body>
</html>