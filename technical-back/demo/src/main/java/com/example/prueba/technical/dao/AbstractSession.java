package com.example.prueba.technical.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractSession {
	
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}