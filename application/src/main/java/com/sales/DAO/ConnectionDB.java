package com.sales.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./appdb", "sa", "");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS employee (\"\r\n" + //
                    "+ \"id INT PRIMARY KEY, \"\r\n" + //
                    "+ \"name VARCHAR(100), \"\r\n" + //
                    "+ \"registration VARCHAR(100), \"\r\n" + //
                    "+ \"section VARCHAR(100)\"\r\n" + //
                    "+ \")");
            System.out.println("Conexão com H2 realizada com sucesso!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
