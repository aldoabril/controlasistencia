/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.util.Paginado;

public interface UsuarioService extends BaseService<Usuario, Integer> {

    public Usuario BuscarUsuarioUsername(String username);

    public Paginado getPaginationList(Integer page, Integer size, String search);

    public void guardarUsuario(UsuarioDTO UsuarioDTO) throws BusinessException;

    public void actualizarUsuario(UsuarioDTO UsuarioDTO) throws BusinessException;
    
    public void eliminarUsuario(Integer id);
}
