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
@Table(name = "\"DetalleVenta\"")
public class DetalleVenta implements Serializable{
    
    
    
    @Id
    @Column(name = "idDetalleVenta")
    private int idDetalleVenta;
    
    @Column(name = "idProducto")
    private int idProducto;
    
    @Column(name = "idVenta")
    private int idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int idProducto, int idVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
    }
    
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    
}
