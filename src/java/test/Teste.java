/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ProdutoDAO;
import model.Produto;

/**
 *
 * @author bruno
 */
public class Teste {
    
    public static void main(String[] args) {
             Produto produto = new Produto();
  
            produto.setDescricao("Teste");
            produto.setPreco(5);
            
            String message;
            
            try {
                ProdutoDAO dao = new ProdutoDAO();
                dao.cadastrar(produto);
                message = "Cadastrado com sucesso.";
            } catch(Exception e){
                message = "Erro no cadastrar: " + e.getMessage();
            }
            System.out.println(message);
    }
    
}
