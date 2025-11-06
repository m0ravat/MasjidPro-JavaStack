package com.m0ravat.models;

import jakarta.persistence.*;

// ---------- Account ----------
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;
    private String username;
    private String password;

    // Getters & Setters
    public Integer getAccountID() { return accountID; }
    public void setAccountID(Integer accountID) { this.accountID = accountID; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
