package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/lojavirtual",
                            "root",
                            "root");

            System.out.println("Fechando conexão...");

            con.close();

            System.out.println("Conexão encerrada.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}