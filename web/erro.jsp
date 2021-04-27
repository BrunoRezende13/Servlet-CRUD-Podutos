<%-- 
    Document   : manterproduto
    Created on : 10/04/2021, 10:49:11
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ocorreu um erro</title>
    </head>
    <body>
        <h1><%= request.getAttribute("erro") %> </h1>
        <br><br>
        <a href="manterproduto.jsp">
            <input type="submit" name="operacao" value="Voltar">
        </a>
    </body>
</html>
