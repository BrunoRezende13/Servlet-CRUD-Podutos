/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.FabricaConexao;

/**
 *
 * @author bruno
 */
public class ProdutoDAO {
    
    public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection connection = FabricaConexao.getConexao();
        
        String sql = "INSERT INTO produtos (descricao, preco) VALUES (?, ?)";
        
        PreparedStatement comando = connection.prepareStatement(sql);
        
        comando.setString(1, produto.getDescricao());
        comando.setDouble(2, produto.getPreco());
        comando.execute();
        
        comando.close();
        connection.close();
    }
    
    public void alterar(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection connection = FabricaConexao.getConexao();
        
        String sql = "UPDATE produtos SET descricao = ?, preco = ? WHERE id = ?";
        
        PreparedStatement comando = connection.prepareStatement(sql);
        
        comando.setString(1, produto.getDescricao());
        comando.setDouble(2, produto.getPreco());
        comando.setInt(3, produto.getId());
        comando.execute();
        
        comando.close();
        connection.close();
    }
    
     public void remover(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection connection = FabricaConexao.getConexao();
        
        String sql = "DELETE FROM produtos WHERE id = ?";
        
        PreparedStatement comando = connection.prepareStatement(sql);
        
        comando.setInt(1, produto.getId());
        comando.execute();
        
        comando.close();
        connection.close();
    }
        
    public List<Produto> listarTodos() throws ClassNotFoundException, SQLException {

        Connection connection = FabricaConexao.getConexao();
        
        String sql = "SELECT * FROM produtos;";
        
        PreparedStatement comando = connection.prepareStatement(sql);
        
        ResultSet executeQuery = comando.executeQuery();
        
        List<Produto> listaProdutos = new ArrayList<>();
        
        while (executeQuery.next()) {
            Produto produto = new Produto();
            
            produto.setId(executeQuery.getInt("id"));
            produto.setDescricao(executeQuery.getString("descricao"));
            produto.setPreco(executeQuery.getDouble("preco"));
            
            listaProdutos.add(produto);
        }
        
        executeQuery.close();
        comando.close();
        connection.close();
        
        return listaProdutos;
    }
    
       public Produto consultarPorId(Produto produto) throws ClassNotFoundException, SQLException {

        Connection connection = FabricaConexao.getConexao();
        
        String sql = "SELECT * FROM produtos WHERE id = ?;";
        
        PreparedStatement comando = connection.prepareStatement(sql);
                
        comando.setInt(1, produto.getId());
        
        ResultSet executeQuery = comando.executeQuery();
                    
        Produto p = null;
        if (executeQuery.next()) {
            p = new Produto();
            p.setId(executeQuery.getInt("id"));
            p.setDescricao(executeQuery.getString("descricao"));
            p.setPreco(executeQuery.getDouble("preco"));
 
        }
        
        executeQuery.close();
        comando.close();
        connection.close();
        
        return p;
    }
    
}
