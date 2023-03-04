package org.example;

import java.sql.*;

public class TestaInsercaoComParametros {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaConexao()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (name, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {


                insereProduto("Smart TV", "45 polegadas", stm);
                insereProduto("Teclado", "Teclado sem fio", stm);

                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Rollback executado");
                connection.rollback();
            }
        }
    }

    private static void insereProduto(String nome, String descricao, PreparedStatement stm) throws SQLException, RuntimeException {

        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equals("Teclado")) {
            throw new RuntimeException("Teclado não deve ser adicionado.");
        }

        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                System.out.println(nome + " inserido com suceso. Id: " + rst.getInt(1));
            }
        }


    }

}
