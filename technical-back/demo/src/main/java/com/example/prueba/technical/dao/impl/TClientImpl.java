/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.dao.impl;

import com.example.prueba.technical.dao.AbstractSession;
import com.example.prueba.technical.dao.TClientDao;
import com.example.prueba.technical.models.Client;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */

@Repository
@Transactional
public class TClientImpl extends AbstractSession implements TClientDao{
    
    @Override
    public void saveTClient(Client tClient) {
        // TODO Auto-generated method stub
        getSession().persist(tClient);
    }

    @Override
    public void deleteTClientById(Integer idClient) {
       Client client = findById(idClient);
        if (client != null) {
            getSession().delete(client);
        }
    }

    @Override
    public void updateTClient(Client tClient) {
        getSession().update(tClient);
        getSession().beginTransaction().commit();
    }

    @Override
    public List<Client> findAllTClient() {
        return getSession().createQuery("from Client").list();
    }

    @Override
    public Client findById(Integer idClient) {
        return (Client) getSession().get(Client.class, idClient);
    }
    
}
