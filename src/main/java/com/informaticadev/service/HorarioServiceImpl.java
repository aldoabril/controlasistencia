/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.HorarioDTO;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Horario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.repository.HorarioRepository;
import com.informaticadev.util.Criterio;
import com.informaticadev.util.EncryptUtil;
import com.informaticadev.util.Paginado;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImpl extends BaseServiceImpl<Horario, Integer>
        implements HorarioService {

    @Autowired
    private HorarioRepository UsuarioRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    public HorarioServiceImpl(HorarioRepository HorarioRepository) {
        super(HorarioRepository);
    }

    @Override
    public void guardarHorario(HorarioDTO HorarioDTO) throws BusinessException {
        
            Horario h = new Horario();
            h.setNombre(HorarioDTO.getNombre());
            h.setRefrigerio(HorarioDTO.isRefrigerio());
            h.setVigente(HorarioDTO.isVigente());
            System.out.println(HorarioDTO.toString());
            UsuarioRepository.save(h);
        }
    

     

}
