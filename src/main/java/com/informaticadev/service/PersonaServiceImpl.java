/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Usuario;
import com.informaticadev.repository.PersonaRepository;
import com.informaticadev.repository.UsuarioRepository;
import com.informaticadev.util.Criterio;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Integer>
        implements PersonaService {
    
    @Autowired
    private PersonaRepository PersonaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personarepository) {
        super(personarepository);
    }

    @Override
    public Persona ObtenerPersona(String dni) {
        Criterio criterio = Criterio.forClass(Persona.class);
        criterio.add(Restrictions.eq("dni", dni));
        List<Persona> p = PersonaRepository.searchForCriteria(criterio);
        if (p != null && !p.isEmpty()) {
            return p.get(0);
        }
        return null;
    }

}
