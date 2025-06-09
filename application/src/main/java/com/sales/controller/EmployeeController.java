package com.sales.controller;

import com.sales.DAO.EmployeeDB;
import com.sales.model.Employee;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController {

    public void registerEmployeeController(String name, String registration, String section) {
        if (name != null && !name.isEmpty() &&
                registration != null && !registration.isEmpty() &&
                section != null && !section.isEmpty()) {

            Employee employee = new Employee(0, name, registration, section);
            EmployeeDB employeeDB = new EmployeeDB();

            try {
                employeeDB.saveEmployeeDB(employee);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Cadastro realizado com sucesso!");
                alert.showAndWait();
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao salvar no banco de dados.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Digite corretamente todos os campos!");
            alert.showAndWait();
        }
    }

    public ArrayList<Employee> listEmployeesController() {
        EmployeeDB employeeDB = new EmployeeDB();
        try {
            return employeeDB.listEmployeesDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao buscar os funcionários.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return new ArrayList<>();
        }
    }
}
