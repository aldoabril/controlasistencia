/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.DiasDTO;
import com.informaticadev.entity.Dia;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.util.Paginado;

public interface DiasService extends BaseService<Dia, Integer> {

 

    public void guardarDia(DiasDTO DiasDTO) throws BusinessException;

   
}