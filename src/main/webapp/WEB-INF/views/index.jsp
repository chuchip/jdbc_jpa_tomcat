<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo conexion JDBC y JPA con Hibernate</title>
    </head>

    <body>        
        <p><A href="jdbc">Recoger un Usuario JDBC Template </a></p>
        <p><A href="todosusuarios">Recoger Todos los Usuarios con JDBC Template </a></p>        
        <p><A href="jpa">Conectar usando JPA + Hibernate </a></p>
        <p>Buscar por nombre de usuario<br/>
        <form action="todosPorNombre">
            <input type="text" name="nombre" value="profe">
            <input type="submit" value="Aceptar">
        </form>
        </p>
    </body>
</html>
