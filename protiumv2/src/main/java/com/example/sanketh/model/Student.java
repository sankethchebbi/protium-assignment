package com.example.sanketh.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String email;

    // Default constructor
    public Student() {
    }

    // Getter and setter methods for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
