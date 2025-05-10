package com.sales.controller;

import com.sales.model.Employee;

import javafx.scene.control.Alert;

public class EmployeeController {
    public void registerEmployeeController(String name, String registration, String section) {
        if((name != null && !name.isEmpty()) && (registration != null && !registration.isEmpty()) && (section != null && !section.isEmpty())) {
            Employee employee = new Employee(0, name, registration, section);
            employee.registerEmployeeDAO(employee);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Digite corretamente todos os campos!");
            alert.showAndWait();
        }
    }
}
