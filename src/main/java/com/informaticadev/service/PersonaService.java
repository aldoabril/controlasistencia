/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.entity.Persona;

/**
 *
 * @author CARLOS
 */
public interface PersonaService extends BaseService<Persona, Integer> {

    //public Paginado getPaginationList(Integer page, Integer size, String search);
    public Persona ObtenerPersona(String dni);
}
