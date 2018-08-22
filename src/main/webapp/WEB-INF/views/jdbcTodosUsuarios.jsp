<%-- 
    Document   : login
    Created on : 16-ago-2018, 21:48:30
    Author     : chuchip
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Recogiendo TODOS los  usuarios usando JDBC</h1>
        <h2>Estos son los usuarios</h2>
        <table border="1">
            <tr>
            <th>Usuario</th>   
            <th>Nombre</th>   
            </tr>
            <c:forEach var="usuario" items="${listadeUsuarios}">
                <tr>
                    <td>${usuario.login}</td>
                    <td>${usuario.nombre}</td>
                </tr>
            </c:forEach>
            <tr>
        </table>
        
    </body>
</html>
