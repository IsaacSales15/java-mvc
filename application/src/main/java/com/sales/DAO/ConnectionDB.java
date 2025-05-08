package com.sales.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
        public Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./appdb", "sa", "");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS teste (id INT PRIMARY KEY, nome VARCHAR(50))");
            System.out.println("Conexão com H2 realizada com sucesso!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}