/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Cargo;
import java.util.List;

/**
 *
 * @author CARLOS
 */
public interface CargoService extends BaseService<Cargo, Integer> {

    public List<Cargo> ListaCargos();

}
