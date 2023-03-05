package br.com.alura.jdbc;

import br.com.alura.jdbc.DAO.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercaoCategoria {

    public static void main(String[] args) throws SQLException {

        Categoria categoria = new Categoria("ELETRODOMESTICOS");

        try(Connection connection = new ConnectionFactory().recuperaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            categoriaDAO.insereCategoria(categoria);
        }

    }
}
