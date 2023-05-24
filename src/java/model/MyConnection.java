package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/formulario.davi",
                "root",
                ""
        );
        System.out.println("conexão ok");
        return conn;
    }
}
