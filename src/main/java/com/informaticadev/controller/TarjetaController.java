/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.controller;

import com.informaticadev.dto.EmpleadoDTO;
import com.informaticadev.entity.Agencia;
import com.informaticadev.entity.Cargo;
import com.informaticadev.service.AgenciaService;
import com.informaticadev.service.CargoService;
import com.informaticadev.service.EmpleadoService;
import com.informaticadev.service.TarjetaService;
import com.informaticadev.util.Paginado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CARLOS
 */
@Controller
@RequestMapping({"/mantenimiento/tarjeta", "/proceso/tarjeta", "/consulta/tarjeta"})
public class TarjetaController {

       
//    @Autowired
//    private TarjetaService TarjetaService;
//
//    public static final String PREFIX1 = "mantenimiento/tarjeta/";
//    public static final String PREFIX2 = "proceso/tarjeta/";
//    public static final String PREFIX3 = "consulta/tarjeta/";
//
//    
//    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> guardar(@RequestBody TarjetaDTO t) {
//
//        Map<String, Object> map = new HashMap();
//
//        try {
//            TarjetaService.guardarTarjeta(t);
//            map.put("status", "success");
//
//        } catch (Exception ex) {
//            map.put("status", "error");
//            map.put("msg", "Error al registrar Tarjeta " + ex.getMessage());
//            ex.printStackTrace();
//        }
//
//        return map;
//    }

}

