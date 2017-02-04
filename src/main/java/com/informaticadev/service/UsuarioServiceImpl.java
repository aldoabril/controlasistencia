/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.repository.UsuarioRepository;
import com.informaticadev.util.Criterio;
import com.informaticadev.util.EncryptUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer>
        implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository UsuarioRepository) {
        super(UsuarioRepository);
    }

    @Override
    public void guardarUsuario(UsuarioDTO UsuarioDTO) throws BusinessException {
        if (IsValid(UsuarioDTO)) {
            Persona persona = UsuarioDTO.getPersona();
            System.out.println(persona.toString());
            personaService.save(persona);
            Usuario u = new Usuario();
            u.setIdpersona(persona);
            u.setRol(UsuarioDTO.getRol());
            u.setUsername(UsuarioDTO.getUsername());
            u.setPassword(EncryptUtil.md5(UsuarioDTO.getPassword()));
            System.out.println(u.toString());
            UsuarioRepository.save(u);
        }
    }

    private boolean IsValid(UsuarioDTO UsuarioDTO) throws BusinessException {
        if (BuscarUsuarioUsername(UsuarioDTO.getUsername()) != null) {
            throw new BusinessException("Ya existe un Usuario con ese Username: " + UsuarioDTO.getUsername());
        }
        if ((personaService.ObtenerPersona(UsuarioDTO.getDni())) != null) {
            throw new BusinessException("Ya existe Usuario con ese DNI ");
        }
        return true;
    }

    @Override
    public Usuario BuscarUsuarioUsername(String username) {
        Criterio criterio = Criterio.forClass(Usuario.class);
        criterio.add(Restrictions.eq("username", username));
        List<Usuario> users = UsuarioRepository.searchForCriteria(criterio);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

}
