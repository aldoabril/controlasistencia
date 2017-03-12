/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.EmpleadoDTO;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.util.Paginado;

/**
 *
 * @author CARLOS
 */
public interface EmpleadoService extends BaseService<Empleado, Integer> {

    public Persona BuscarEmpleadoDni(String dni);

    public Usuario ObtenerUserCreador(String username);

    public Paginado getPaginationList(Integer page, Integer size, String search);

    public void guardarEmpleado(EmpleadoDTO e) throws BusinessException;

    public void actualizarEmpleado(EmpleadoDTO EmpleadoDTO);

    public void eliminarEmpleado(Integer id);

}
