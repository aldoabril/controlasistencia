/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.repository;

import com.informaticadev.entity.Agencia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS
 */
@Repository
public class AgenciaRepositoryImpl extends BaseRepositoryImpl<Agencia, Integer>
        implements AgenciaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Agencia> listarTodasAgencias() {
        System.out.println("AgenciaRepositoryImpl");
        return getSession().createQuery("from Agencia").list();
    }
}
