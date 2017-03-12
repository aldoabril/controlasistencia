/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.EmpleadoAgencia;
import com.informaticadev.repository.EmpleadoAgenciaRepository;
import com.informaticadev.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class EmpleadoAgenciaServiceImpl extends BaseServiceImpl<EmpleadoAgencia, Integer>
        implements EmpleadoAgenciaService {
    
     @Autowired
    public EmpleadoAgenciaServiceImpl(EmpleadoAgenciaRepository EmpleadoAgenciaRepository) {
        super(EmpleadoAgenciaRepository);
    }
    
}
