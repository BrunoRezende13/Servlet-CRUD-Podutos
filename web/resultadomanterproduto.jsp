<%-- 
    Document   : resultadomanterproduto
    Created on : 10/04/2021, 11:50:16
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado:</title>
    </head>
    <body>
        <h1>Resultado:</h1>
        <br>
        <% String message = (String) request.getAttribute("message"); %>
        <h2><%=message%></h2>
        <br> <br>
        <a href="manterproduto.jsp">
            <input type="submit" name="operacao" value="Voltar">
        </a>
    </body>
</html>
