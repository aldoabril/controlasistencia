/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Cargo;
import com.informaticadev.repository.CargoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class CargoServiceImpl extends BaseServiceImpl<Cargo, Integer>
        implements CargoService {

    @Autowired
    private CargoRepository CargoRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository CargoRepository) {
        super(CargoRepository);
    }

    @Override
    public List<Cargo> ListaCargos() {
        return CargoRepository.listarTodosCargos();
    }
}
