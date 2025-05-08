package com.sales.model;

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

    
}
