/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.models;

import com.example.prueba.technical.controller.MyUserDetails;
import com.example.prueba.technical.utils.Utils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author user
 */
//@Service
public class JwtRequestFilters extends OncePerRequestFilter{
    
    @Autowired
    private MyUserDetails myUserDetails;
    private final Utils jwtUtils = new Utils();
    
    
    
    public JwtRequestFilters() {
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest hsr, HttpServletResponse hsr1, FilterChain fc) throws ServletException, IOException {

        final String autorizathionHeader = hsr.getHeader("Authorization");
        String userName=null;
        String jwt=null;
        
        if (autorizathionHeader != null && autorizathionHeader.startsWith("Bearer ")) {
            jwt= autorizathionHeader.substring(7);
            userName=jwtUtils.extractUserName(jwt);
        }
        
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.myUserDetails.loadUserByUsername(userName);
            if (jwtUtils.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                        new UsernamePasswordAuthenticationToken(myUserDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(hsr));
                
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    }
}
