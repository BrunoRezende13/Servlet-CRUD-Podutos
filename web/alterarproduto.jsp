<%-- 
    Document   : manterproduto
    Created on : 10/04/2021, 10:49:11
    Author     : bruno
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
        <h1>Alterar Produto</h1>
        <form action="AlterarProduto" method="POST">
            <br>
            Id.........:  <%= ((Produto) request.getSession().getAttribute("produto")).getId() %><br>
            Descrição..: <input type="text" name="txDescricao"> <br>
            Preço......: <input type="number" name="txPreco"> <br>
            <br>
            <input type="submit" name="operacao" value="Alterar">   
            <input type="submit" name="operacao" value="Voltar">  
        </form>
        
    </body>
</html>
