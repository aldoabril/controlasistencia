/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.HorarioDTO;
import com.informaticadev.entity.Horario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.util.Paginado;

public interface HorarioService extends BaseService<Horario, Integer> {

 

    public void guardarHorario(HorarioDTO HorarioDTO) throws BusinessException;

   
}
