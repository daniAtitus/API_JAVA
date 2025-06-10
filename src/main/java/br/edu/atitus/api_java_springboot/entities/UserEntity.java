package br.edu.atitus.api_java_springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class UserEntity {

    private UUID id;
    private String username;
    private  String email;
    @JsonIgnore
    private String password;
    private UserType type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
