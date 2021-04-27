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
        <title>Deletar Produto</title>
    </head>
    <body>
        <h1>Deletar Produto</h1>
        <form action="DeletarProduto" method="POST">
            <br>
            Id.........: <input type="text" name="txId"> <br>
   
            <br>
            <input type="submit" name="operacao" value="Deletar">   
            <input type="submit" name="operacao" value="Voltar">   
        </form>
        
    </body>
</html>
