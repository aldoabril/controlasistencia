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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "perfilvacaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilvacaciones.findAll", query = "SELECT p FROM Perfilvacaciones p"),
    @NamedQuery(name = "Perfilvacaciones.findById", query = "SELECT p FROM Perfilvacaciones p WHERE p.id = :id"),
    @NamedQuery(name = "Perfilvacaciones.findByFechainicio", query = "SELECT p FROM Perfilvacaciones p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "Perfilvacaciones.findByFechafin", query = "SELECT p FROM Perfilvacaciones p WHERE p.fechafin = :fechafin")})
public class Perfilvacaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Vacaciones> vacacionesList;

    public Perfilvacaciones() {
    }

    public Perfilvacaciones(Integer id) {
        this.id = id;
    }

    public Perfilvacaciones(Integer id, Date fechainicio, Date fechafin) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public List<Vacaciones> getVacacionesList() {
        return vacacionesList;
    }

    public void setVacacionesList(List<Vacaciones> vacacionesList) {
        this.vacacionesList = vacacionesList;
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
        if (!(object instanceof Perfilvacaciones)) {
            return false;
        }
        Perfilvacaciones other = (Perfilvacaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Perfilvacaciones[ id=" + id + " ]";
    }
    
}
