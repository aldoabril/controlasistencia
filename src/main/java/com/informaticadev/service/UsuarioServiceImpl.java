/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.repository.UsuarioRepository;
import com.informaticadev.util.Criterio;
import com.informaticadev.util.EncryptUtil;
import com.informaticadev.util.Paginado;
import java.util.List;
import org.hibernate.criterion.MatchMode;
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

            if (UsuarioDTO.getIdpersona() == null) {
                personaService.save(persona);
            }
            Usuario u = new Usuario();
            u.setIdpersona(persona);
            u.setRol(UsuarioDTO.getRol());
            u.setUsername(UsuarioDTO.getUsername());
            u.setPassword(EncryptUtil.md5(UsuarioDTO.getPassword()));
            UsuarioRepository.save(u);
        }
    }

    private boolean IsValid(UsuarioDTO UsuarioDTO) throws BusinessException {
        if (BuscarUsuarioUsername(UsuarioDTO.getUsername()) != null) {
            throw new BusinessException("Ya existe un Usuario con ese Username: " + UsuarioDTO.getUsername());
        }
        if (UserPersona(UsuarioDTO.getIdpersona()) != null) {
            throw new BusinessException("Ya existe un Usuario asignado a esta Persona");
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

    public Usuario UserPersona(Integer id) {
        Criterio criterio = Criterio.forClass(Usuario.class);
        criterio.add(Restrictions.like("idpersona.id", id));
        List<Usuario> users = UsuarioRepository.searchForCriteria(criterio);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public Paginado getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Usuario.class, "usuario");
        criterio.createAlias("usuario.idpersona", "persona");
        criterio.add(Restrictions.disjunction()
                .add(Restrictions.ilike("persona.dni", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.nombres", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.apellidop", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.apellidom", search, MatchMode.ANYWHERE))
        );

        Long totalRows = UsuarioRepository.countResultForCriteria(criterio);

        criterio.setFirstResult(size * (page - 1));
        criterio.setMaxResults(size);

        List<Usuario> items = UsuarioRepository.searchForCriteria(criterio);

        return Paginado.build(page, size, search, totalRows, items);
    }

    @Override
    public void actualizarUsuario(UsuarioDTO UsuarioDTO) throws BusinessException {
        Usuario u = UsuarioRepository.get(UsuarioDTO.getId());
        u.setRol(UsuarioDTO.getRol());
        Persona persona = personaService.get(u.getIdpersona().getId());
        UsuarioDTO.passValuesForUpdate(persona);
        personaService.update(persona);
        if (!u.getPassword().equals(UsuarioDTO.getPassword())) {
            u.setPassword(EncryptUtil.md5(UsuarioDTO.getPassword()));
        }
        UsuarioRepository.update(u);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        Usuario u = UsuarioRepository.get(id);
        Persona persona = u.getIdpersona();

        UsuarioRepository.delete(u);
        personaService.delete(persona);
    }

}
