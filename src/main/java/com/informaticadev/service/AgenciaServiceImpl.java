/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Agencia;
import com.informaticadev.entity.Cargo;
import com.informaticadev.repository.AgenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class AgenciaServiceImpl extends BaseServiceImpl<Agencia, Integer>
        implements AgenciaService {

    @Autowired
    private AgenciaRepository AgenciaRepository;

    @Autowired
    public AgenciaServiceImpl(AgenciaRepository AgenciaRepository) {
        super(AgenciaRepository);
    }

    @Override
    public List<Agencia> ListaAgencias() {
        System.out.println("AgenciaServiceImpl");
        return AgenciaRepository.listarTodasAgencias();
    }

}
