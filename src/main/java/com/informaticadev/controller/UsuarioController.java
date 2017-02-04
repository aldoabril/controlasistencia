/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.controller;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.service.PersonaService;
import com.informaticadev.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CARLOS
 */
@Controller
@RequestMapping({"/mantenimiento/usuarios", "/proceso/usuarios", "/consulta/usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private PersonaService PersonaService;

    public static final String PREFIX1 = "mantenimiento/usuarios/";
    public static final String PREFIX2 = "proceso/usuarios/";
    public static final String PREFIX3 = "consulta/usuarios/";

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");
        return mv;
    }

    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody UsuarioDTO u) {

        Map<String, Object> map = new HashMap();

        try {
            UsuarioService.guardarUsuario(u);
            map.put("status", "success");

        } catch (Exception ex) {
            map.put("status", "error");
            map.put("msg", "Error al registrar el Usuario " + ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/obtenerDatosPersona/{dni}.json", method = RequestMethod.GET)
    @ResponseBody
    public UsuarioDTO obtenerDatosPersona(@PathVariable("dni") String dni) {
        UsuarioDTO UsuarioDTO = null;
        try {
            UsuarioDTO = new UsuarioDTO(PersonaService.ObtenerPersona(dni));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return UsuarioDTO;
    }
}
