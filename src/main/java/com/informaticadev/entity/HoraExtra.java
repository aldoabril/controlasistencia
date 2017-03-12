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
@Table(name = "hora_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraExtra.findAll", query = "SELECT h FROM HoraExtra h"),
    @NamedQuery(name = "HoraExtra.findById", query = "SELECT h FROM HoraExtra h WHERE h.id = :id"),
    @NamedQuery(name = "HoraExtra.findByTiempoextr", query = "SELECT h FROM HoraExtra h WHERE h.tiempoextr = :tiempoextr")})
public class HoraExtra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempoextr")
    @Temporal(TemporalType.TIME)
    private Date tiempoextr;
    @JoinColumn(name = "dia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dia dia;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public HoraExtra() {
    }

    public HoraExtra(Integer id) {
        this.id = id;
    }

    public HoraExtra(Integer id, Date tiempoextr) {
        this.id = id;
        this.tiempoextr = tiempoextr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTiempoextr() {
        return tiempoextr;
    }

    public void setTiempoextr(Date tiempoextr) {
        this.tiempoextr = tiempoextr;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
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
        if (!(object instanceof HoraExtra)) {
            return false;
        }
        HoraExtra other = (HoraExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.HoraExtra[ id=" + id + " ]";
    }
    
}
