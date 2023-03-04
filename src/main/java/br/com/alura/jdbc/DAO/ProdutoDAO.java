package br.com.alura.jdbc.DAO;

import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvaProduto(Produto produto) throws SQLException {
        String query = "INSERT INTO produto (NAME, DESCRICAO) VALUES (?, ?)";
        try (
                PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.execute();
            try (ResultSet rst = pstm.getGeneratedKeys()) {
                System.out.println(rst);
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
                System.out.println(produto); // calls automatically the ".toString()" method.
            }
        }
    }

    public List<Produto> listaProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();
        String query = "SELECT id, name, descricao FROM produto";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while(rst.next()) {
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

}
