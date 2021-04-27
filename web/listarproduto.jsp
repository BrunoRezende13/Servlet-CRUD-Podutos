<%-- 
    Document   : resultadomanterproduto
    Created on : 10/04/2021, 11:50:16
    Author     : bruno
--%>

<%@page import="model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar todos os produtos</title>
    </head>
    <body>
        <h1>Listar todos os produtos</h1>
        <br>
        <table border="1">
            <tr><th>Id</th><th>Descrição</th><th>Preço</th></tr>

            <%
                List<Produto> list = (List<Produto>) request.getAttribute("lista");
                
                for (Produto cliente : list) {
            %>

            <tr>
                <td><%= cliente.getId()%></td>
                <td><%= cliente.getDescricao()%></td>
                <td><%= cliente.getPreco()%></td>
            </tr>

            <% }%>
        </table>
        <br>
        <a href="manterproduto.jsp">
            <input type="submit" name="operacao" value="Voltar">
        </a>
    </body>
</html>
