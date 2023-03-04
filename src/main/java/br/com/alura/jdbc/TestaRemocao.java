package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperaConexao()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE ID > ?");
            stm.setInt(1, 2);
            stm.execute();

            Integer linhasModificadas = stm.getUpdateCount();

            System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
        }


    }

}
