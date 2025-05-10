package com.sales.model;

import com.sales.DAO.EmployeeDB;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private String registration;
    private String section;

    public Employee(int id, String name, String registration, String section) {
        this.id = id;
        this.name = name;
        this.registration = registration;
        this.section = section;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return id == other.id;
    }

    public void registerEmployeeDAO(Employee employee) {
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.saveEmployeeDB(employee);
    }

    public ArrayList<Employee> listEmployeeDAO() {
        return new EmployeeDB().listEmployeesDB();
    }
    
}
