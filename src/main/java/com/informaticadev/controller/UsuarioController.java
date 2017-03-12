/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.controller;

import com.informaticadev.dto.UsuarioDTO;
import com.informaticadev.entity.Rol;
import com.informaticadev.service.PersonaService;
import com.informaticadev.service.RolService;
import com.informaticadev.service.UsuarioService;
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
@RequestMapping({"/mantenimiento/usuarios", "/proceso/usuarios", "/consulta/usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private RolService RolService;

    @Autowired
    private PersonaService PersonaService;

    public static final String PREFIX1 = "mantenimiento/usuarios/";
    public static final String PREFIX2 = "proceso/usuarios/";
    public static final String PREFIX3 = "consulta/usuarios/";

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");
        List<Rol> rolItems = RolService.ListaRoles();
        mv.addObject("rolItems", rolItems);
        return mv;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView View(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "search", defaultValue = "") String search) {

        ModelAndView mv = new ModelAndView(PREFIX1 + "tablaUsuarios");
        Paginado paginado = UsuarioService.getPaginationList(page, size, search);
        mv.addObject("paginado", paginado);
        List<Rol> rolItems = RolService.ListaRoles();
        mv.addObject("rolItems", rolItems);
        return mv;
    }

    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public UsuarioDTO obtener(@PathVariable("id") Integer id) {
        UsuarioDTO UsuarioDTO = new UsuarioDTO(UsuarioService.get(id));
        return UsuarioDTO;
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
    
    @RequestMapping(value = "/actualizar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> actualizar(@RequestBody UsuarioDTO UsuarioDTO) {
        Map<String, Object> map = new HashMap();
        try {
            UsuarioService.actualizarUsuario(UsuarioDTO);
            map.put("status", "success");
        } catch (Exception e) {
            map.put("status", "error");
            map.put("msg", "Error al modificar el Usuario " + e.getMessage());
        }

        return map;
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id) {
        Map<String, Object> map = new HashMap();

        try {
            UsuarioService.eliminarUsuario(id);
            map.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", "error");
            map.put("msg", "Error al Eliminar el Cliente " + e.getMessage());
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
