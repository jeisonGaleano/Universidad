/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.prueba.technical.dao;

import com.example.prueba.technical.models.Client;
import java.util.List;

/**
 *
 * @author user
 */
public interface TClientDao {
    void saveTClient(Client tClient);

    void deleteTClientById(Integer tClient);

    void updateTClient(Client tClient);

    List<Client> findAllTClient();

    Client findById(Integer tClient);
}
