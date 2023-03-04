package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lojavirtual");
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
