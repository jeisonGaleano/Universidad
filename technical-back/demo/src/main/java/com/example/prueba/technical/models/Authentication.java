/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.models;

/**
 *
 * @author user
 */
public class Authentication {
    
    private String userName;
    private String password;

    public Authentication(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Authentication() {
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
