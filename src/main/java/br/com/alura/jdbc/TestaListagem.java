package br.com.alura.jdbc;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME , DESCRICAO FROM produto");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NAME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        System.out.println("Fechando conexão...");

        connection.close();

        System.out.println("Conexão encerrada.");

    }
}
