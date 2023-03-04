package br.com.alura.jdbc;

import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComModelo {

    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto("Comoda", "Comoda Vertical");

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try (Connection con = connectionFactory.recuperaConexao()) {
            String query = "INSERT INTO produto (NAME, DESCRICAO) VALUES (?, ?)";
            try (
                    PreparedStatement pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
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

    }

}
