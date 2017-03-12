/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "empleado_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoHorario.findAll", query = "SELECT e FROM EmpleadoHorario e"),
    @NamedQuery(name = "EmpleadoHorario.findById", query = "SELECT e FROM EmpleadoHorario e WHERE e.id = :id"),
    @NamedQuery(name = "EmpleadoHorario.findByFechacreado", query = "SELECT e FROM EmpleadoHorario e WHERE e.fechacreado = :fechacreado"),
    @NamedQuery(name = "EmpleadoHorario.findByFechaact", query = "SELECT e FROM EmpleadoHorario e WHERE e.fechaact = :fechaact")})
public class EmpleadoHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaact;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "horario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public EmpleadoHorario() {
    }

    public EmpleadoHorario(Integer id) {
        this.id = id;
    }

    public EmpleadoHorario(Integer id, Date fechacreado, Date fechaact) {
        this.id = id;
        this.fechacreado = fechacreado;
        this.fechaact = fechaact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechacreado() {
        return fechacreado;
    }

    public void setFechacreado(Date fechacreado) {
        this.fechacreado = fechacreado;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof EmpleadoHorario)) {
            return false;
        }
        EmpleadoHorario other = (EmpleadoHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.EmpleadoHorario[ id=" + id + " ]";
    }
    
}
