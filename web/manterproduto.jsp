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
        <title>Manter Produto</title>
    </head>
    <body>
        <h1>Manter Produto</h1>
        <form action="ManterProduto" method="POST">
            <input type="submit" name="operacao" value="Cadastrar">   
            <input type="submit" name="operacao" value="Deletar">   
            <input type="submit" name="operacao" value="Alterar">   
            <input type="submit" name="operacao" value="Consultar por id"> 
            <input type="submit" name="operacao" value="Consultar todos"> 
        </form>
        
    </body>
</html>
