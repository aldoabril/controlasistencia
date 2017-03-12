/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.service;

import com.informaticadev.dto.EmpleadoDTO;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.EmpleadoAgencia;
import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Tarjeta;
import com.informaticadev.entity.Usuario;
import com.informaticadev.exception.BusinessException;
import com.informaticadev.repository.EmpleadoAgenciaRepository;
import com.informaticadev.repository.EmpleadoRepository;
import com.informaticadev.repository.PersonaRepository;
import com.informaticadev.repository.UsuarioRepository;
import com.informaticadev.util.Criterio;
import com.informaticadev.util.Paginado;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Integer>
        implements EmpleadoService {

    @Autowired
    private EmpleadoRepository EmpleadoRepository;

    @Autowired
    private PersonaRepository PersonaRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EmpleadoAgenciaRepository EmpleadoAgenciaRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository EmpleadoRepository) {
        super(EmpleadoRepository);
    }

    @Override
    public void guardarEmpleado(EmpleadoDTO EmpleadoDTO) throws BusinessException {
        if (IsValid(EmpleadoDTO)) {
            Date date = new Date();
            Persona persona = EmpleadoDTO.getPersona();
            personaService.save(persona);

            Empleado e = new Empleado();
            e.setCargo(EmpleadoDTO.getCargoObj());
            e.setPerscod(EmpleadoDTO.getPerscod());
            e.setFechaactualizacion(date);
            e.setFechacreacion(date);
            e.setVigente(true);
            e.setIdpersona(persona);
            e.setUsuariocreador(ObtenerUserCreador(EmpleadoDTO.getUsercreador()));
            EmpleadoRepository.save(e);

            EmpleadoAgencia ea = new EmpleadoAgencia();
            ea.setAgencia(EmpleadoDTO.getAgenciaObj());
            ea.setEmpleado(e);
            ea.setFechacreacion(date);
            ea.setFechaact(date);
            EmpleadoAgenciaRepository.save(ea);
        }
    }

    private boolean IsValid(EmpleadoDTO EmpleadoDTO) throws BusinessException {
        if (BuscarEmpleadoDni(EmpleadoDTO.getDni()) != null) {
            throw new BusinessException("Ya existe un Usuario con ese DNI: " + EmpleadoDTO.getDni());
        }
        return true;
    }

    @Override
    public Persona BuscarEmpleadoDni(String dni) {
        Criterio criterio = Criterio.forClass(Persona.class);
        criterio.add(Restrictions.eq("dni", dni));
        List<Persona> empleds = PersonaRepository.searchForCriteria(criterio);
        if (empleds != null && !empleds.isEmpty()) {
            return empleds.get(0);
        }
        return null;
    }

    @Override
    public Paginado getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(EmpleadoAgencia.class, "empleadoagencia");
        criterio.createAlias("empleadoagencia.agencia", "agencia");//0
        criterio.createAlias("empleadoagencia.empleado", "empleado");//1
        criterio.createAlias("empleado.idpersona", "persona");//2        
        criterio.add(Restrictions.disjunction()
                .add(Restrictions.ilike("persona.dni", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.nombres", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.apellidop", search, MatchMode.ANYWHERE))
                .add(Restrictions.ilike("persona.apellidom", search, MatchMode.ANYWHERE))
        );

        Long totalRows = EmpleadoRepository.countResultForCriteria(criterio);

        criterio.setFirstResult(size * (page - 1));
        criterio.setMaxResults(size);

        List<Empleado> items = EmpleadoRepository.searchForCriteria(criterio);

        return Paginado.build(page, size, search, totalRows, items);
    }

    @Override
    public Usuario ObtenerUserCreador(String username) {
        Criterio criterio = Criterio.forClass(Usuario.class);
        criterio.add(Restrictions.eq("username", username));
        List<Usuario> users = UsuarioRepository.searchForCriteria(criterio);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public void actualizarEmpleado(EmpleadoDTO EmpleadoDTO) {
        Empleado e = EmpleadoRepository.get(EmpleadoDTO.getId());
        e.setCargo(EmpleadoDTO.getCargoObj());

        EmpleadoAgencia ea = ObtenerEmpleadoAgencia(EmpleadoDTO.getId());
        ea.setAgencia(ea.getAgencia());
        ea.setEmpleado(e);
        EmpleadoAgenciaRepository.update(ea);

        Persona persona = personaService.get(e.getIdpersona().getId());
        EmpleadoDTO.passValuesForUpdate(persona);
        personaService.update(persona);

        EmpleadoRepository.update(e);
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        Empleado e = EmpleadoRepository.get(id);
        Persona persona = e.getIdpersona();
        EmpleadoAgencia ea=ObtenerEmpleadoAgencia(e.getId());

        EmpleadoRepository.delete(e);
        personaService.delete(persona);
        EmpleadoAgenciaRepository.delete(ea);
    }

    public EmpleadoAgencia ObtenerEmpleadoAgencia(Integer id) {
        Criterio criterio = Criterio.forClass(EmpleadoAgencia.class);
        criterio.add(Restrictions.eq("empleado.id", id));
        List<EmpleadoAgencia> ea = EmpleadoAgenciaRepository.searchForCriteria(criterio);
        if (ea != null && !ea.isEmpty()) {
            return ea.get(0);
        }
        return null;
    }

}
