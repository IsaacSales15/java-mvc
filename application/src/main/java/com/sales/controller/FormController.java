package com.sales.controller;

import com.sales.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FormController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField registrationField;
    @FXML
    private TextField sectionField;

    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, Integer> idColumn;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> registrationColumn;
    @FXML private TableColumn<Employee, String> sectionColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        registrationColumn.setCellValueFactory(new PropertyValueFactory<>("registration"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));

        loadEmployeesIntoTable();
    }

    // Registra os dados
    @FXML
    private void handleSave() {

        String name = nameField.getText();
        String registration = registrationField.getText();
        String section = sectionField.getText();

        EmployeeController employeeController = new EmployeeController();
        employeeController.registerEmployeeController(name, registration, section);

        nameField.clear();
        registrationField.clear();
        sectionField.clear();

        loadEmployeesIntoTable();
    }

    // Atualiza a tabela
    private void loadEmployeesIntoTable() {
        ArrayList<Employee> employeeList = EmployeeController.listEmployeesController();
        ObservableList<Employee> data = FXCollections.observableArrayList(employeeList);
        employeeTable.setItems(data);
    }
}


