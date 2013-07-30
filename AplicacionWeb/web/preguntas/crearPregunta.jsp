<%-- 
    Document   : crearPregunta
    Created on : Jul 28, 2013, 3:40:22 PM
    Author     : hector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@include file="../conexionBD.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script>
            function validarUnicaRespuesta(check){
                for (var i=1;i<=4;i++){
                    var a = "";
                    var checkBox = document.getElementById(a.concat("checkbox",i));
                    if ((checkBox.checked==true) && (checkBox!=check)){
                        checkBox.checked = false;
                        checkBox.value = "NULL";
                        check.value ="'SI'";
                        }
                        
                }
            }
        </script>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/CrearPreguntaServlet">
            <label>Enunciado: </label><textarea name="enunciado"></textarea>
            <select name="topicos">
                 <sql:query dataSource="${localSource}" 
	           sql="SELECT id, nombre, categoria FROM topicos" 
	           var="result" />
        
        <c:forEach var="row" items="${result.rows}">
           
            <option value="${row.id}">${row.categoria}: ${row.nombre} </option>
	</c:forEach>
            </select>
        <label>Opcion: </label><input type="text" name="opcion1"/>¿Respuesta correcta?<input type="checkbox" name="checkbox1" id="checkbox1" onclick="validarUnicaRespuesta(checkbox1)"/>
        <label>Opcion: </label><input type="text" name="opcion2"/>¿Respuesta correcta?<input type="checkbox" name="checkbox2" id="checkbox2" onclick="validarUnicaRespuesta(checkbox2)"/>
        <label>Opcion: </label><input type="text" name="opcion3"/>¿Respuesta correcta?<input type="checkbox" name="checkbox3" id="checkbox3" onclick="validarUnicaRespuesta(checkbox3)"/>
        <label>Opcion: </label><input type="text" name="opcion4"/>¿Respuesta correcta?<input type="checkbox" name="checkbox4" id="checkbox4" onclick="validarUnicaRespuesta(checkbox4)"/>
        <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>