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
            <% Produto produto = (Produto) request.getSession().getAttribute("produto");%>
            Id.........:  <%= produto.getId() %><br>
            Descrição..: <%= produto.getDescricao() %><br>
            Preço......: <%= produto.getPreco() %> <br>
            <br>
            <input type="submit" name="operacao" value="Voltar">  
        </form>
        
    </body>
</html>
