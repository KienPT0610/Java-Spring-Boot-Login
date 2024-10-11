package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auth")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
        this.role = "user";
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = "user";
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }
}
