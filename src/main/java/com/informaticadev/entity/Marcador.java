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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "marcador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcador.findAll", query = "SELECT m FROM Marcador m"),
    @NamedQuery(name = "Marcador.findById", query = "SELECT m FROM Marcador m WHERE m.id = :id"),
    @NamedQuery(name = "Marcador.findByNombre", query = "SELECT m FROM Marcador m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Marcador.findByIp", query = "SELECT m FROM Marcador m WHERE m.ip = :ip")})
public class Marcador implements Serializable {
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
    @Size(min = 1, max = 50)
    @Column(name = "ip")
    private String ip;
    @JoinColumn(name = "agencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agencia agencia;

    public Marcador() {
    }

    public Marcador(Integer id) {
        this.id = id;
    }

    public Marcador(Integer id, String nombre, String ip) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
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
        if (!(object instanceof Marcador)) {
            return false;
        }
        Marcador other = (Marcador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informaticadev.entity.Marcador[ id=" + id + " ]";
    }
    
}
