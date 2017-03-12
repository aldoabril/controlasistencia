package com.informaticadev.controller;
import com.informaticadev.dto.HorarioDTO;
import com.informaticadev.entity.Agencia;
import com.informaticadev.entity.Cargo;
import com.informaticadev.service.AgenciaService;
import com.informaticadev.service.CargoService;
import com.informaticadev.service.HorarioService;
import com.informaticadev.service.HorarioService;
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
@RequestMapping({"/mantenimiento/horarios", "/proceso/horarios", "/consulta/horarios"})
public class HorariosController {
    
    @Autowired
    private HorarioService HorarioService;

    @Autowired
    private CargoService CargoService;

    @Autowired
    private AgenciaService AgenciaService;

    public static final String PREFIX1 = "mantenimiento/horarios/";
    public static final String PREFIX2 = "proceso/horarios/";
    public static final String PREFIX3 = "consulta/horarios/";

    @RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
    public ModelAndView New() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "nuevo");
        
        return mv;
    }
    
    @RequestMapping(value = "/asignar.html", method = RequestMethod.GET)
    public ModelAndView Asignar() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "asignar");
        
        return mv;
    }
    
    @RequestMapping(value = "/exitonuevo.html", method = RequestMethod.GET)
    public ModelAndView Exitonuevo() {
        ModelAndView mv = new ModelAndView(PREFIX2 + "exitonuevo");
        
        return mv;
    }
    
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody HorarioDTO h) {

        Map<String, Object> map = new HashMap();

        try {
            HorarioService.guardarHorario(h);
            map.put("status", "success");

        } catch (Exception ex) {
            map.put("status", "error");
            map.put("msg", "Error al registrar Horario " + ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }
    
   

}