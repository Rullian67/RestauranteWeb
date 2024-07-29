<%-- 
    Document   : home
    Created on : 23 de jul. de 2024, 20:20:38
    Author     : rulli
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Bem-vindo, ${sessionScope.usuario.username}!</h1>
    <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
</body>
</html>

