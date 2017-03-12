/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Rol;
import com.informaticadev.entity.Usuario;
import com.informaticadev.repository.RolRepository;
import com.informaticadev.util.Criterio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class RolServiceImpl extends BaseServiceImpl<Rol, Integer>
        implements RolService {

    @Autowired
    private RolRepository RolRepository;

    @Autowired
    public RolServiceImpl(RolRepository RolRepository) {
        super(RolRepository);
    }

    @Override
    public List<Rol> ListaRoles() {
        Criterio criterio = Criterio.forClass(Rol.class);
        List<Rol> roles = RolRepository.searchForCriteria(criterio);
        return roles;
    }

}
