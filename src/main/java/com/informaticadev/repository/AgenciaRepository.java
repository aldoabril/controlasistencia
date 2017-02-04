/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.repository;

import com.informaticadev.entity.Agencia;
import java.util.List;

/**
 *
 * @author CARLOS
 */
public interface AgenciaRepository extends BaseRepository<Agencia, Integer> {

    public List<Agencia> listarTodasAgencias();

}
