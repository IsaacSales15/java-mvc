package com.sales.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./appdb", "sa", "");
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), registration VARCHAR(100), section VARCHAR(100))";
            stmt.execute(sql);
            System.out.println("Conexão com H2 realizada com sucesso!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
