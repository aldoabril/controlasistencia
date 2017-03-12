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
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findById", query = "SELECT a FROM Asistencia a WHERE a.id = :id"),
    @NamedQuery(name = "Asistencia.findByEntrada", query = "SELECT a FROM Asistencia a WHERE a.entrada = :entrada"),
    @NamedQuery(name = "Asistencia.findBySalida", query = "SELECT a FROM Asistencia a WHERE a.salida = :salida"),
    @NamedQuery(name = "Asistencia.findByRefrigerioen", query = "SELECT a FROM Asistencia a WHERE a.refrigerioen = :refrigerioen"),
    @NamedQuery(name = "Asistencia.findByRefrigeriosa", query = "SELECT a FROM Asistencia a WHERE a.refrigeriosa = :refrigeriosa")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada")
    @Temporal(TemporalType.TIME)
    private Date entrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salida")
    @Temporal(TemporalType.TIME)
    private Date salida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refrigerioen")
    @Temporal(TemporalType.TIME)
    private Date refrigerioen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refrigeriosa")
    @Temporal(TemporalType.TIME)
    private Date refrigeriosa;
    @JoinColumn(name = "dia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dia dia;

    public Asistencia() {
    }

    public Asistencia(Integer id) {
        this.id = id;
    }

    public Asistencia(Integer id, Date entrada, Date salida, Date refrigerioen, Date refrigeriosa) {
        this.id = id;
        this.entrada = entrada;
        this.salida = salida;
        this.refrigerioen = refrigerioen;
        this.refrigeriosa = refrigeriosa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Date getRefrigerioen() {
        return refrigerioen;
    }

    public void setRefrigerioen(Date refrigerioen) {
        this.refrigerioen = refrigerioen;
    }

    public Date getRefrigeriosa() {
        return refrigeriosa;
    }

    public void setRefrigeriosa(Date refrigeriosa) {
        this.refrigeriosa = refrigeriosa;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
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
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Asistencia[ id=" + id + " ]";
    }
    
}
