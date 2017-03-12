package com.informaticadev.controller;

import com.informaticadev.dto.DiasDTO;
import com.informaticadev.entity.Agencia;
import com.informaticadev.entity.Cargo;
import com.informaticadev.service.AgenciaService;
import com.informaticadev.service.CargoService;
import com.informaticadev.service.DiasService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping({"/mantenimiento/dias", "/proceso/dias", "/consulta/dias"})
public class DiasController {

    @Autowired
    private DiasService DiasService;
    
    @Autowired
    private CargoService CargoService;

    @Autowired
    private AgenciaService AgenciaService;

    public static final String PREFIX1 = "mantenimiento/dias/";
    public static final String PREFIX2 = "proceso/dias/";
    public static final String PREFIX3 = "consulta/dias/";

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");
        
        return mv;
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody DiasDTO h) {

        Map<String, Object> map = new HashMap();

        try {
            DiasService.guardarDia(h);
            map.put("status", "success");

        } catch (Exception ex) {
            map.put("status", "error");
            map.put("msg", "Error al registrar Dia " + ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }
}