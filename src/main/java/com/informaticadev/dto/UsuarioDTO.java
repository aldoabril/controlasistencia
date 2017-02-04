/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.dto;

import com.informaticadev.entity.Persona;
import com.informaticadev.entity.Rol;
import com.informaticadev.entity.Usuario;
import com.informaticadev.util.Helper;

/**
 *
 * @author CARLOS
 */
public class UsuarioDTO {

    private Integer id;
    private String dni;
    private String username;
    private String password;
    private Integer rol;
    private Integer idpersona;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String direccion;
    private String fechanac;
    private String nombrerol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario u) {
        this.id = u.getId();
        this.dni = u.getIdpersona().getDni();
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.rol = u.getRol().getId();
        this.idpersona = u.getIdpersona().getId();
        this.nombres = u.getIdpersona().getNombres();
        this.apellidoPat = u.getIdpersona().getApellidop();
        this.apellidoMat = u.getIdpersona().getApellidom();
        this.direccion = u.getIdpersona().getDireccion();
        this.fechanac = Helper.formatDate(u.getIdpersona().getFechanac());
    }

    public UsuarioDTO(Persona p) {
        this.dni = p.getDni();
        this.nombres = p.getNombres();
        this.apellidoPat = p.getApellidop();
        this.apellidoMat = p.getApellidom();
        this.direccion = p.getDireccion();
        this.fechanac = Helper.formatDate(p.getFechanac());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdrol() {
        return rol;
    }

    public void setIdrol(Integer rol) {
        this.rol = rol;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public Persona getPersona() {
        Persona persona = new Persona();
        persona.setDni(dni);
        persona.setApellidop(apellidoPat);
        persona.setApellidom(apellidoMat);
        persona.setNombres(nombres);
        persona.setDireccion(direccion);
        persona.setFechanac(Helper.parseDate(fechanac));
        return persona;
    }

    public Rol getRol() {
        Rol r = new Rol();
        r.setId(rol);
        r.setNombre(nombrerol);
        return r;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", dni=" + dni + ", username=" + username + ", password=" + password + ", idrol=" + rol + ", idpersona=" + idpersona + ", nombres=" + nombres + ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", direccion=" + direccion + ", fechanac=" + fechanac + ", nombrerol=" + nombrerol + '}';
    }

}
