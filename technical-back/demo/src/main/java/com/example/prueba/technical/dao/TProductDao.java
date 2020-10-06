/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.dao;

import com.example.prueba.technical.models.Product;
import java.util.List;

/**
 *
 * @author user
 */
public interface TProductDao {
    void saveTProduct(Product tProduct);

    void deleteTProductById(Integer idProduct);

    void updateTProduct(Product tProduct);

    List<Product> findAllTProduct();

    Product findById(Integer idProduct);
}
