<%-- 
    Document   : respuesta
    Created on : Jul 24, 2013, 5:42:57 PM
    Author     : hector
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Mensaje: ${mensaje}</p>
        <a href="${link}">Regresar</a>
    </body>
</html>