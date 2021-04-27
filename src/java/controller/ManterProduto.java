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
@WebServlet(name = "ManterProduto", urlPatterns = {"/ManterProduto"})
public class ManterProduto extends HttpServlet {

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

                if (operacao.equals("Cadastrar")) {
                    request.getRequestDispatcher("cadastrarproduto.jsp").forward(request, response);
                } else if (operacao.equals("Deletar")) {
                    request.getRequestDispatcher("deletarproduto.jsp").forward(request, response);
                } else if (operacao.equals("Alterar")) {
                    request.getSession().setAttribute("dispatcher", "alterarproduto.jsp");
                    request.getRequestDispatcher("pesquisaidproduto.jsp").forward(request, response);
                } else if (operacao.equals("Consultar por id")) {
                    request.getSession().setAttribute("dispatcher", "exibirproduto.jsp");
                    request.getRequestDispatcher("pesquisaidproduto.jsp").forward(request, response);
                } else if (operacao.equals("Consultar todos")) {
                    ProdutoDAO dao = new ProdutoDAO();

                    request.setAttribute("lista", dao.listarTodos());
                    request.getRequestDispatcher("listarproduto.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("manterproduto.jsp").forward(request, response);

                }

            } catch (Exception e) {
                request.setAttribute("erro", e.getMessage());
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
