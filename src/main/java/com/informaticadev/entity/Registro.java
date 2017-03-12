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
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findById", query = "SELECT r FROM Registro r WHERE r.id = :id"),
    @NamedQuery(name = "Registro.findByFecha", query = "SELECT r FROM Registro r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Registro.findByDia", query = "SELECT r FROM Registro r WHERE r.dia = :dia"),
    @NamedQuery(name = "Registro.findByHoraEnReal", query = "SELECT r FROM Registro r WHERE r.horaEnReal = :horaEnReal"),
    @NamedQuery(name = "Registro.findByHoraSaReal", query = "SELECT r FROM Registro r WHERE r.horaSaReal = :horaSaReal"),
    @NamedQuery(name = "Registro.findByHoraRenReal", query = "SELECT r FROM Registro r WHERE r.horaRenReal = :horaRenReal"),
    @NamedQuery(name = "Registro.findByHoraRsaReal", query = "SELECT r FROM Registro r WHERE r.horaRsaReal = :horaRsaReal")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    private int dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_en_real")
    @Temporal(TemporalType.TIME)
    private Date horaEnReal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_sa_real")
    @Temporal(TemporalType.TIME)
    private Date horaSaReal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_ren_real")
    @Temporal(TemporalType.TIME)
    private Date horaRenReal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_rsa_real")
    @Temporal(TemporalType.TIME)
    private Date horaRsaReal;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Registro() {
    }

    public Registro(Integer id) {
        this.id = id;
    }

    public Registro(Integer id, Date fecha, int dia, Date horaEnReal, Date horaSaReal, Date horaRenReal, Date horaRsaReal) {
        this.id = id;
        this.fecha = fecha;
        this.dia = dia;
        this.horaEnReal = horaEnReal;
        this.horaSaReal = horaSaReal;
        this.horaRenReal = horaRenReal;
        this.horaRsaReal = horaRsaReal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getHoraEnReal() {
        return horaEnReal;
    }

    public void setHoraEnReal(Date horaEnReal) {
        this.horaEnReal = horaEnReal;
    }

    public Date getHoraSaReal() {
        return horaSaReal;
    }

    public void setHoraSaReal(Date horaSaReal) {
        this.horaSaReal = horaSaReal;
    }

    public Date getHoraRenReal() {
        return horaRenReal;
    }

    public void setHoraRenReal(Date horaRenReal) {
        this.horaRenReal = horaRenReal;
    }

    public Date getHoraRsaReal() {
        return horaRsaReal;
    }

    public void setHoraRsaReal(Date horaRsaReal) {
        this.horaRsaReal = horaRsaReal;
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
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Registro[ id=" + id + " ]";
    }
    
}
