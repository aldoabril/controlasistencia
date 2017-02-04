/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.repository;

import com.informaticadev.entity.Persona;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS
 */
@Repository
public class PersonaRepositoryImpl extends BaseRepositoryImpl<Persona, Integer>
        implements PersonaRepository {

}
