/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.controller;

import java.util.HashMap;
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
@RequestMapping({"/mantenimiento/empleados", "/proceso/empleados", "/consulta/empleados"})
public class EmpleadoController {

    public static final String PREFIX1 = "mantenimiento/empleados/";
    public static final String PREFIX2 = "proceso/empleados/";
    public static final String PREFIX3 = "consulta/empleados/";

    

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");           
        return mv;
    }

    
}
