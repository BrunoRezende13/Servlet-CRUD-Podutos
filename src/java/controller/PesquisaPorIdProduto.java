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
import javax.servlet.http.HttpSession;
import model.Produto;

/**
 *
 * @author bruno
 */
@WebServlet(name = "PesquisaPorIdProduto", urlPatterns = {"/PesquisaPorIdProduto"})
public class PesquisaPorIdProduto extends HttpServlet {

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

                if (operacao.equals("Pesquisar")) {
                    int id = Integer.parseInt(request.getParameter("txId"));

                    Produto produto = new Produto();
                    produto.setId(id);

                    ProdutoDAO dao = new ProdutoDAO();
                    Produto consultarPorId = dao.consultarPorId(produto);

                    if (consultarPorId == null) {

                        request.setAttribute("erro", "Produto não encontrado.");
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    } else {
                        HttpSession session = request.getSession();

                        session.setAttribute("produto", consultarPorId);

                        String requestDispatcher = (String) session.getAttribute("dispatcher");
                        request.getRequestDispatcher(requestDispatcher).forward(request, response);
                    }

                } else if (operacao.equals("Voltar")) {
                    request.getRequestDispatcher("manterproduto.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("erro", "Ocorreu um erro ao pesquisar o produto.");
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
