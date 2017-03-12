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

@Controller
@RequestMapping({"/mantenimiento/empleados", "/proceso/empleados", "/consulta/empleados"})
public class EmpleadoController {

    @Autowired
    private CargoService CargoService;

    @Autowired
    private AgenciaService AgenciaService;

    @Autowired
    private EmpleadoService EmpleadoService;

    public static final String PREFIX1 = "mantenimiento/empleados/";
    public static final String PREFIX2 = "proceso/empleados/";
    public static final String PREFIX3 = "consulta/empleados/";

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");
        List<Cargo> cargoItems = CargoService.ListaCargos();
        mv.addObject("cargoItems", cargoItems);
        List<Agencia> agenciaItems = AgenciaService.ListaAgencias();
        mv.addObject("agenciaItems", agenciaItems);
        return mv;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView View(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "search", defaultValue = "") String search) {

        ModelAndView mv = new ModelAndView(PREFIX1 + "tablaEmpleados");
        Paginado paginado = EmpleadoService.getPaginationList(page, size, search);
        mv.addObject("paginado", paginado);
        List<Cargo> cargoItems = CargoService.ListaCargos();
        mv.addObject("cargoItems", cargoItems);
        List<Agencia> agenciaItems = AgenciaService.ListaAgencias();
        mv.addObject("agenciaItems", agenciaItems);

        return mv;
    }

    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public EmpleadoDTO obtener(@PathVariable("id") Integer id) {
        EmpleadoDTO EmpleadoDTO = new EmpleadoDTO(EmpleadoService.get(id));
        return EmpleadoDTO;
    }

    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody EmpleadoDTO e) {

        Map<String, Object> map = new HashMap();

        try {
            EmpleadoService.guardarEmpleado(e);
            map.put("status", "success");

        } catch (Exception ex) {
            map.put("status", "error");
            map.put("msg", "Error al registrar el Empleado " + ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/actualizar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> actualizar(@RequestBody EmpleadoDTO EmpleadoDTO) {
        Map<String, Object> map = new HashMap();
        try {
            EmpleadoService.actualizarEmpleado(EmpleadoDTO);
            map.put("status", "success");
        } catch (Exception e) {
            map.put("status", "error");
            map.put("msg", "Error al modificar el Empleado " + e.getMessage());
        }

        return map;
    }

    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id) {
        Map<String, Object> map = new HashMap();

        try {
            EmpleadoService.eliminarEmpleado(id);
            map.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", "error");
            map.put("msg", "Error al Eliminar el Cliente " + e.getMessage());
        }

        return map;
    }

}
