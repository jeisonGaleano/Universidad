/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.configuration;

import com.example.prueba.technical.controller.SecurityConfigure;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author user
 */
@Configuration
public class CustomConfig {
    
    
    public SecurityConfigure securityConfigure(){
        return new SecurityConfigure();
    }
}
