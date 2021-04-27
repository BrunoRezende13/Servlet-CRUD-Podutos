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
        <title>Pesquisa Produto</title>
    </head>
    <body>
        <h1>Digite o id do produto</h1>
        <form action="PesquisaPorIdProduto" method="POST">
            <br>
            Id.........: <input type="text" name="txId" required> <br>
   
            <br>
            <input type="submit" name="operacao" value="Pesquisar">   
            <input type="submit" name="operacao" value="Voltar">   
        </form>
        
    </body>
</html>
