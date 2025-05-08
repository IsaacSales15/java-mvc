package com.sales.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FormController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField registrationField;
    @FXML
    private TextField sectionField;

    @FXML
    private void handleSave() {

        String name = nameField.getText();
        String registration = registrationField.getText();
        String section = sectionField.getText();

        EmployeeController employeeController = new EmployeeController();
        employeeController.registerEmployeeController(name, registration, section);
    }
}
