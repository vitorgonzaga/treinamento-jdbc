package br.com.alura.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        // configurações adicionais
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexao() throws SQLException {
/*
        // utilização sem a configuração de um Pool de conexões
        return DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/lojavirtual",
                        "root",
                        "root");
*/

        return this.dataSource.getConnection();

    }
}
