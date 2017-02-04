/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "vacaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacaciones.findAll", query = "SELECT v FROM Vacaciones v"),
    @NamedQuery(name = "Vacaciones.findById", query = "SELECT v FROM Vacaciones v WHERE v.id = :id"),
    @NamedQuery(name = "Vacaciones.findByEstado", query = "SELECT v FROM Vacaciones v WHERE v.estado = :estado")})
public class Vacaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "perfil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Perfilvacaciones perfil;

    public Vacaciones() {
    }

    public Vacaciones(Integer id) {
        this.id = id;
    }

    public Vacaciones(Integer id, short estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Perfilvacaciones getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfilvacaciones perfil) {
        this.perfil = perfil;
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
        if (!(object instanceof Vacaciones)) {
            return false;
        }
        Vacaciones other = (Vacaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Vacaciones[ id=" + id + " ]";
    }
    
}
