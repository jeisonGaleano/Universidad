/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.controller;

import com.example.prueba.technical.models.Authentication;
import com.example.prueba.technical.models.AuthenticationResponse;
import com.example.prueba.technical.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController
//@RequestMapping("resource")
public class ResourceController {
    
    @Autowired
    private AuthenticationManager authenticationManager;    
    
    @Autowired
    private MyUserDetails myUserDetails;
    
    private final Utils jwtUtil = new Utils();
    
    @GetMapping("statusServices")
    public ResponseEntity<Object>  responseWeb(){
        return new ResponseEntity<>("Servicio Habilitado",HttpStatus.OK);
    }
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken (@RequestBody Authentication authentication) throws  Exception {
        try {
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                        (authentication.getUserName(), authentication.getPassword()));
        } catch (BadCredentialsException e) {
            throw  new Exception("Verifique usuario o contraseña", e);
        }
       final UserDetails userDetails = myUserDetails.loadUserByUsername(authentication.getUserName());
       
       final String jwt = jwtUtil.generateToken(userDetails);
       
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
 
}
