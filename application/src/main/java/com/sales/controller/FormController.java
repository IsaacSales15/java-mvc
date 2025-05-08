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

        System.out.println("Nome: " + name);
        System.out.println("Matrícula: " + registration);
        System.out.println("Setor: " + section);
    }
}
