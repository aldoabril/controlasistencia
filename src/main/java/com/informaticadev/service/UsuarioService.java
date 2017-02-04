/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;

/**
 *
 * @author CARLOS
 */
public interface UsuarioService extends BaseService<Usuario, Integer> {

    public Usuario BuscarUsuarioUsername(String username);

    public void guardarUsuario(UsuarioDTO UsuarioDTO) throws BusinessException;
}
