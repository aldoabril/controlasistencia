/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Tarjeta;
import com.informaticadev.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta, Integer>
        implements TarjetaService {

    @Autowired
    public TarjetaServiceImpl(TarjetaRepository TarjetaRepository) {
        super(TarjetaRepository);
    }
}
