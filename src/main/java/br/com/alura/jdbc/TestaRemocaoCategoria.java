package br.com.alura.jdbc;

import br.com.alura.jdbc.DAO.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaRemocaoCategoria {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().recuperaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            categoriaDAO.deletaCategoriaById(6);
        }


    }
}
