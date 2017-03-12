/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"),
    @NamedQuery(name = "Empleado.findByPerscod", query = "SELECT e FROM Empleado e WHERE e.perscod = :perscod"),
    @NamedQuery(name = "Empleado.findByFechacreacion", query = "SELECT e FROM Empleado e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Empleado.findByFechaactualizacion", query = "SELECT e FROM Empleado e WHERE e.fechaactualizacion = :fechaactualizacion"),
    @NamedQuery(name = "Empleado.findByVigente", query = "SELECT e FROM Empleado e WHERE e.vigente = :vigente")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perscod")
    private String perscod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaactualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigente")
    private boolean vigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EmpleadoAgencia> empleadoAgenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<HoraExtra> horaExtraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Registro> registroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Huella> huellaList;
    @JoinColumn(name = "cargo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cargo cargo;
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "usuariocreador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuariocreador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Vacaciones> vacacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EmpleadoHorario> empleadoHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Tarjeta> tarjetaList;

    public Empleado() {
    }

    public Empleado(Integer id) {
        this.id = id;
    }

    public Empleado(Integer id, String perscod, Date fechacreacion, Date fechaactualizacion, boolean vigente) {
        this.id = id;
        this.perscod = perscod;
        this.fechacreacion = fechacreacion;
        this.fechaactualizacion = fechaactualizacion;
        this.vigente = vigente;
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

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @XmlTransient
    public List<EmpleadoAgencia> getEmpleadoAgenciaList() {
        return empleadoAgenciaList;
    }

    public void setEmpleadoAgenciaList(List<EmpleadoAgencia> empleadoAgenciaList) {
        this.empleadoAgenciaList = empleadoAgenciaList;
    }

    @XmlTransient
    public List<HoraExtra> getHoraExtraList() {
        return horaExtraList;
    }

    public void setHoraExtraList(List<HoraExtra> horaExtraList) {
        this.horaExtraList = horaExtraList;
    }

    @XmlTransient
    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    @XmlTransient
    public List<Huella> getHuellaList() {
        return huellaList;
    }

    public void setHuellaList(List<Huella> huellaList) {
        this.huellaList = huellaList;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario getUsuariocreador() {
        return usuariocreador;
    }

    public void setUsuariocreador(Usuario usuariocreador) {
        this.usuariocreador = usuariocreador;
    }

    @XmlTransient
    public List<Vacaciones> getVacacionesList() {
        return vacacionesList;
    }

    public void setVacacionesList(List<Vacaciones> vacacionesList) {
        this.vacacionesList = vacacionesList;
    }

    @XmlTransient
    public List<EmpleadoHorario> getEmpleadoHorarioList() {
        return empleadoHorarioList;
    }

    public void setEmpleadoHorarioList(List<EmpleadoHorario> empleadoHorarioList) {
        this.empleadoHorarioList = empleadoHorarioList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Empleado[ id=" + id + " ]";
    }
    
}
