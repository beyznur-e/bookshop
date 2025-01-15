package com.example.bookstore.DTO;

public class Login_Dto {
    private String email;
    private String password;

    public Login_Dto(){}

    public Login_Dto(String email, String password) {
        this.email = email;
        this.password = password;
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
}