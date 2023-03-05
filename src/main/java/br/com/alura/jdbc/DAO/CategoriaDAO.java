package br.com.alura.jdbc.DAO;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insereCategoria(Categoria categoria) throws SQLException {
        String query = "INSERT INTO CATEGORIA (NOME) VALUES (?)";
        try (PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, categoria.getNome());
            pstm.execute();
            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    categoria.setId(rst.getInt(1));
                }
                System.out.println(categoria);
            }
        }
    }

    public void deletaCategoriaById(Integer Id) throws SQLException {
        String query = "DELETE FROM CATEGORIA WHERE ID = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, Id);
            pstm.execute();
            Integer linhasModificadas = pstm.getUpdateCount();
            System.out.println("Total linhas modificadas: " + linhasModificadas);
        }
    }

    public List<Categoria> listaCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String query = "SELECT ID, NOME FROM CATEGORIA";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                    categorias.add(categoria);
                }
            }
        }
        return categorias;
    }

    public List<Categoria> listaCategoriasComProdutos() throws SQLException {
        Categoria ultima = null;
        List<Categoria> categorias = new ArrayList<>();
        String query = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN"
                + " PRODUTO P ON C.ID = P.CATEGORIA_ID";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    if(ultima == null || !ultima.getNome().equals(rst.getString(2))) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        categorias.add(categoria);
                        ultima = categoria;
                    }
                    Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adiciona(produto);
                }
            }
        }
        return categorias;
    }
}
