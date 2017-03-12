/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.DiasDTO;
import com.informaticadev.dto.HorarioDTO;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Dia;
import com.informaticadev.entity.Horario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.repository.DiasRepository;
import com.informaticadev.repository.HorarioRepository;
import com.informaticadev.util.Criterio;
import com.informaticadev.util.EncryptUtil;
import com.informaticadev.util.Paginado;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiasServiceImpl extends BaseServiceImpl<Dia, Integer>
        implements DiasService {

    @Autowired
    private DiasRepository DiasRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    public DiasServiceImpl(DiasRepository DiasRepository) {
        super(DiasRepository);
    }

    @Override
    public void guardarDia(DiasDTO DiasDTO) throws BusinessException {
            char c[] = new char [7];
            c=componerdias(DiasDTO);
            java.util.Date f = new Date();
            for (int i = 0; i < 7; i++) {
            Dia h = new Dia();
            if(!(c[i]=='0')){
              h.setNombre(c[i]);  
              h.setFecha(f);
            h.setHoraEn(DiasDTO.getHoraEn());
            h.setHoraSa(DiasDTO.getHoraSa());
            h.setHoraRen(DiasDTO.getHora_ren());
            h.setHoraRsa(DiasDTO.getHora_rsa());
            h.setHorario(DiasDTO.getH2());
            DiasRepository.save(h);
            }
        }
            
        }

    private char[] componerdias(DiasDTO DiasDTO) {
        char c[] = new char [7];
        for (int i = 0; i < 7; i++) {
            c[i]='0';
        }
        if(DiasDTO.getLunes()){
            c[0]='1';
        }
        if(DiasDTO.getMartes()){
            c[1]='2';
        }
        if(DiasDTO.getMiercoles()){
            c[2]='3';
        }
        if(DiasDTO.getJueves()){
            c[3]='4';
        }
        if(DiasDTO.getViernes()){
            c[4]='5';
        }
        if(DiasDTO.getSabado()){
            c[5]='6';
        }
        if(DiasDTO.getDomingo()){
            c[6]='7';
        }
        return c;
    }

    
    

     

}