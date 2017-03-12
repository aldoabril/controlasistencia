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
@Table(name = "empleado_agencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoAgencia.findAll", query = "SELECT e FROM EmpleadoAgencia e"),
    @NamedQuery(name = "EmpleadoAgencia.findById", query = "SELECT e FROM EmpleadoAgencia e WHERE e.id = :id"),
    @NamedQuery(name = "EmpleadoAgencia.findByFechacreacion", query = "SELECT e FROM EmpleadoAgencia e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "EmpleadoAgencia.findByFechaact", query = "SELECT e FROM EmpleadoAgencia e WHERE e.fechaact = :fechaact")})
public class EmpleadoAgencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaact;
    @JoinColumn(name = "agencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agencia agencia;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public EmpleadoAgencia() {
    }

    public EmpleadoAgencia(Integer id) {
        this.id = id;
    }

    public EmpleadoAgencia(Integer id, Date fechacreacion, Date fechaact) {
        this.id = id;
        this.fechacreacion = fechacreacion;
        this.fechaact = fechaact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        if (!(object instanceof EmpleadoAgencia)) {
            return false;
        }
        EmpleadoAgencia other = (EmpleadoAgencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.EmpleadoAgencia[ id=" + id + " ]";
    }
    
}
