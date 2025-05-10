package com.sales.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.sales.model.Employee;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmployeeDB {

    public void saveEmployeeDB(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Employee não pode ser nulo");
        }

        String sql = "INSERT INTO employee (name, registration, section) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRegistration());
            stmt.setString(3, employee.getSection());
            stmt.execute();

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
        }
    }

    public ArrayList<Employee> listEmployeesDB() {
        String sql = "SELECT * FROM employee";
        ArrayList<Employee> listEmployees = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rst = stmt.executeQuery()) {

            while (rst.next()) {
                Employee employee = new Employee();
                employee.setId(rst.getInt("id"));
                employee.setName(rst.getString("name"));
                employee.setRegistration(rst.getString("registration"));
                employee.setSection(rst.getString("section"));
                listEmployees.add(employee);
            }

            System.out.println("Successfully collected data");

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao listar os funcionários!");
            alert.showAndWait();
        }

        return listEmployees;
    }
}
