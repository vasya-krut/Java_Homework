package org.example.model;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
