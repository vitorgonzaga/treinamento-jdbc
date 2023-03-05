package br.com.alura.jdbc;

import br.com.alura.jdbc.DAO.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoComModelo {

    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto("COMODA", "COMODA VERTICAL", 8);

        try(Connection connection = new ConnectionFactory().recuperaConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvaProduto(produto);
            // System.out.println(produtoDAO.listaProduto());
            List<Produto> listaProdutos = produtoDAO.listaProdutos();
            listaProdutos.stream().forEach(prod -> System.out.println(prod));
        }

    }

}
