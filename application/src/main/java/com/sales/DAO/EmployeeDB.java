package com.sales.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.sales.model.Employee;

public class EmployeeDB {

    public void saveEmployeeDB(Employee employee) throws SQLException {
        if (employee == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo");
        }

        String sql = "INSERT INTO employee (name, registration, section) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRegistration());
            stmt.setString(3, employee.getSection());
            stmt.executeUpdate();
        }
    }

    public ArrayList<Employee> listEmployeesDB() throws SQLException {
        String sql = "SELECT * FROM employee";
        ArrayList<Employee> listEmployees = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rst = stmt.executeQuery()) {

            while (rst.next()) {
                Employee employee = new Employee(
                        rst.getInt("id"),
                        rst.getString("name"),
                        rst.getString("registration"),
                        rst.getString("section")
                );
                listEmployees.add(employee);
            }
        }

        return listEmployees;
    }
}
