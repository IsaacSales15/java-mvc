package com.sales.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sales.model.Employee;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmployeeDB {

    public void saveEmployeeDB(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Employee não pode ser nulo");
        }

        String sql = "INSERT INTO employee ( name, registration, section) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRegistration());
            stmt.setString(3, employee.getSection());
            stmt.execute();
            conn.commit();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Cadastro realizado com sucesso!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao cadastrar!");
            alert.showAndWait();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao fechar o statement!");
                alert.showAndWait();
            }
        }
        try {

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao fechar a conexão!");
            alert.showAndWait();
        }
    }
}
