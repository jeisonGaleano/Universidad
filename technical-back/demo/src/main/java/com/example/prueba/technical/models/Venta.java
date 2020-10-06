/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "\"Venta\"")
public class Venta implements Serializable{
    
    @Id
    @Column(name = "idDetalleVenta")
    private int idDetalleVenta;
    
    @Column(name = "idProducto")
    private int idProducto;
    
    @Column(name = "idVenta")
    private int idVenta;
    
}
