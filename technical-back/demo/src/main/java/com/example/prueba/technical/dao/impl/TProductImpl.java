/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.dao.impl;

import com.example.prueba.technical.dao.AbstractSession;
import com.example.prueba.technical.dao.TProductDao;
import com.example.prueba.technical.models.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class TProductImpl extends AbstractSession implements TProductDao{
    
    @Override
    public void saveTProduct(Product tProduct) {
        // TODO Auto-generated method stub
        getSession().persist(tProduct);
    }

    @Override
    public void deleteTProductById(Integer idProduct) {
       Product product = findById(idProduct);
        if (product != null) {
            getSession().delete(product);
        }
    }

    @Override
    public void updateTProduct(Product tProduct) {
        getSession().update(tProduct);
        getSession().beginTransaction().commit();
    }

    @Override
    public List<Product> findAllTProduct() {
        return getSession().createQuery("from Product").list();
    }

    @Override
    public Product findById(Integer idProduct) {
        return (Product) getSession().get(Product.class, idProduct);
    }
 
    
}
