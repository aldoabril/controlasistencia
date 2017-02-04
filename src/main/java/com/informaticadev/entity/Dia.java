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
@Table(name = "dia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dia.findAll", query = "SELECT d FROM Dia d"),
    @NamedQuery(name = "Dia.findById", query = "SELECT d FROM Dia d WHERE d.id = :id"),
    @NamedQuery(name = "Dia.findByNombre", query = "SELECT d FROM Dia d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dia.findByHoraEn", query = "SELECT d FROM Dia d WHERE d.horaEn = :horaEn"),
    @NamedQuery(name = "Dia.findByHoraSa", query = "SELECT d FROM Dia d WHERE d.horaSa = :horaSa"),
    @NamedQuery(name = "Dia.findByHoraRen", query = "SELECT d FROM Dia d WHERE d.horaRen = :horaRen"),
    @NamedQuery(name = "Dia.findByHoraRsa", query = "SELECT d FROM Dia d WHERE d.horaRsa = :horaRsa"),
    @NamedQuery(name = "Dia.findByFecha", query = "SELECT d FROM Dia d WHERE d.fecha = :fecha")})
public class Dia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaEn")
    @Temporal(TemporalType.TIME)
    private Date horaEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaSa")
    @Temporal(TemporalType.TIME)
    private Date horaSa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_ren")
    @Temporal(TemporalType.TIME)
    private Date horaRen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_rsa")
    @Temporal(TemporalType.TIME)
    private Date horaRsa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dia1")
    private List<Registro> registroList;
    @JoinColumn(name = "horario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Horario horario;

    public Dia() {
    }

    public Dia(Integer id) {
        this.id = id;
    }

    public Dia(Integer id, String nombre, Date horaEn, Date horaSa, Date horaRen, Date horaRsa, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.horaEn = horaEn;
        this.horaSa = horaSa;
        this.horaRen = horaRen;
        this.horaRsa = horaRsa;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHoraEn() {
        return horaEn;
    }

    public void setHoraEn(Date horaEn) {
        this.horaEn = horaEn;
    }

    public Date getHoraSa() {
        return horaSa;
    }

    public void setHoraSa(Date horaSa) {
        this.horaSa = horaSa;
    }

    public Date getHoraRen() {
        return horaRen;
    }

    public void setHoraRen(Date horaRen) {
        this.horaRen = horaRen;
    }

    public Date getHoraRsa() {
        return horaRsa;
    }

    public void setHoraRsa(Date horaRsa) {
        this.horaRsa = horaRsa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
        if (!(object instanceof Dia)) {
            return false;
        }
        Dia other = (Dia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Dia[ id=" + id + " ]";
    }
    
}
