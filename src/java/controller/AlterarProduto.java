/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author bruno
 */
@WebServlet(name = "AlterarProduto", urlPatterns = {"/AlterarProduto"})
public class AlterarProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            try {
                String operacao = request.getParameter("operacao");
                if (operacao.equals("Alterar")) {

                    Produto produtoAttribute = (Produto) request.getSession().getAttribute("produto");
                    double preco = Double.parseDouble(request.getParameter("txPreco"));
                    String descricao = request.getParameter("txDescricao");

                    Produto produto = new Produto();
                    produto.setId(produtoAttribute.getId());
                    produto.setPreco(preco);
                    produto.setDescricao(descricao);

                    ProdutoDAO dao = new ProdutoDAO();
                    dao.alterar(produto);

                    request.setAttribute("message", "Alterado com sucesso.");
                    request.getRequestDispatcher("resultadomanterproduto.jsp").forward(request, response);

                } else if (operacao.equals("Voltar")) {
                    request.getRequestDispatcher("manterproduto.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Ocorreu um erro ao alterar o produto.");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
