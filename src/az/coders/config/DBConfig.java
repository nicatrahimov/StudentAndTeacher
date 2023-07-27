package az.coders.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        if (connection==null){
            return connection = DriverManager.getConnection(dbUrl,"postgres","1312");
        }else return connection;
    }
}
