/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.dto;

import com.informaticadev.entity.Agencia;
import com.informaticadev.entity.Cargo;
import com.informaticadev.entity.Empleado;
import com.informaticadev.entity.Persona;
import com.informaticadev.util.Helper;

/**
 *
 * @author CARLOS
 */
public class EmpleadoDTO {

    private Integer id;
    private String dni;
    private Integer idpersona;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String fechanac;
    private Integer cargo;
    private String nombrecargo;
    private Integer agencia;
    private String direccionagencia;
    private String perscod;
    private String usercreador;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Empleado e) {
        this.id = e.getId();
        this.dni = e.getIdpersona().getDni();
        this.idpersona = e.getIdpersona().getId();
        this.nombres = e.getIdpersona().getNombres();
        this.apellidoPat = e.getIdpersona().getApellidop();
        this.apellidoMat = e.getIdpersona().getApellidom();
        this.fechanac = Helper.formatDate(e.getIdpersona().getFechanac());
        this.cargo = e.getCargo().getId();
        this.perscod = e.getPerscod();
        this.usercreador = e.getUsuariocreador().getUsername();
    }

    public EmpleadoDTO(Persona p) {
        this.dni = p.getDni();
        this.nombres = p.getNombres();
        this.apellidoPat = p.getApellidop();
        this.apellidoMat = p.getApellidom();
        this.fechanac = Helper.formatDate(p.getFechanac());
    }

    public Persona getPersona() {
        Persona persona = new Persona();
        persona.setDni(dni);
        persona.setApellidop(apellidoPat);
        persona.setApellidom(apellidoMat);
        persona.setNombres(nombres);
        persona.setFechanac(Helper.parseDate(fechanac));
        return persona;
    }

    public void passValuesForUpdate(Persona persona) {
        persona.setDni(dni);
        persona.setApellidop(apellidoPat);
        persona.setApellidom(apellidoMat);
        persona.setNombres(nombres);
        persona.setFechanac(Helper.parseDate(fechanac));

    }

    public Agencia getAgenciaObj() {
        Agencia a = new Agencia();
        a.setId(agencia);
        a.setDireccion(direccionagencia);
        return a;
    }

    public Cargo getCargoObj() {
        Cargo c = new Cargo();
        c.setId(cargo);
        c.setNombre(nombrecargo);
        return c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerscod() {
        return perscod;
    }

    public void setPerscod(String perscod) {
        this.perscod = perscod;
    }

    public String getUsercreador() {
        return usercreador;
    }

    public void setUsercreador(String usercreador) {
        this.usercreador = usercreador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public String getNombrecargo() {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo) {
        this.nombrecargo = nombrecargo;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getDireccionagencia() {
        return direccionagencia;
    }

    public void setDireccionagencia(String direccionagencia) {
        this.direccionagencia = direccionagencia;
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "id=" + id + ", dni=" + dni + ", idpersona=" + idpersona + ", nombres=" + nombres + ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", fechanac=" + fechanac + ", cargo=" + cargo + ", nombrecargo=" + nombrecargo + ", agencia=" + agencia + ", direccionagencia=" + direccionagencia + ", perscod=" + perscod + ", usercreador=" + usercreador + '}';
    }

}
