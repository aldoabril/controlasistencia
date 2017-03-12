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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "huella")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Huella.findAll", query = "SELECT h FROM Huella h"),
    @NamedQuery(name = "Huella.findById", query = "SELECT h FROM Huella h WHERE h.id = :id"),
    @NamedQuery(name = "Huella.findByFechacrea", query = "SELECT h FROM Huella h WHERE h.fechacrea = :fechacrea"),
    @NamedQuery(name = "Huella.findByFechaact", query = "SELECT h FROM Huella h WHERE h.fechaact = :fechaact"),
    @NamedQuery(name = "Huella.findByCodigo", query = "SELECT h FROM Huella h WHERE h.codigo = :codigo")})
public class Huella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Huella() {
    }

    public Huella(Integer id) {
        this.id = id;
    }

    public Huella(Integer id, Date fechacrea, Date fechaact, String codigo) {
        this.id = id;
        this.fechacrea = fechacrea;
        this.fechaact = fechaact;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(Date fechacrea) {
        this.fechacrea = fechacrea;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof Huella)) {
            return false;
        }
        Huella other = (Huella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Huella[ id=" + id + " ]";
    }
    
}
