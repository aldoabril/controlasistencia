/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.repository;

import com.informaticadev.entity.Cargo;
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
public class CargoRepositoryImpl extends BaseRepositoryImpl<Cargo, Integer>
        implements CargoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Cargo> listarTodosCargos() {        
        return getSession().createQuery("from Cargo").list();
    }

}
