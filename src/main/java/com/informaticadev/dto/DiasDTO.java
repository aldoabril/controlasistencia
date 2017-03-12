
package com.informaticadev.dto;

import java.util.Date;
import com.informaticadev.entity.Horario;


public class DiasDTO {
    private Integer id;
    private Character n;
    private Boolean lunes;
    private Boolean martes;
    private Boolean miercoles;
    private Boolean jueves;
    private Boolean viernes;
    private Boolean sabado;
    private Boolean domingo;
    private Date horaEn;
    private Date horaSa;
    private Date hora_ren;
    private Date hora_rsa;
    private Date fecha;
    private Integer horario;
    private Horario h2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getN() {
        return n;
    }

    public void setN(Character n) {
        this.n = n;
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

    public Date getHora_ren() {
        return hora_ren;
    }

    public void setHora_ren(Date hora_ren) {
        this.hora_ren = hora_ren;
    }

    public Date getHora_rsa() {
        return hora_rsa;
    }

    public void setHora_rsa(Date hora_rsa) {
        this.hora_rsa = hora_rsa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getHorario() {
        return horario;
    }

    public void setHorario(Integer horario) {
        this.horario = horario;
    }

    public Horario getH2() {
       Horario r = new Horario();
        r.setId(horario);
        return r;
    }

    public void setH2(Horario h2) {
        this.h2 = h2;
    }
    

    public DiasDTO(Integer id, Character n, Date horaEn, Date horaSa, Date hora_ren, Date hora_rsa, Date fecha, Integer horario) {
        this.id = id;
        this.n = n;
        this.horaEn = horaEn;
        this.horaSa = horaSa;
        this.hora_ren = hora_ren;
        this.hora_rsa = hora_rsa;
        this.fecha = fecha;
        this.horario = horario;
    }
    
    public DiasDTO(Integer id, boolean lunes, boolean martes,boolean miercoles,boolean jueves,boolean viernes,
    boolean sabado,boolean domingo , Date horaEn, Date horaSa, Date hora_ren, Date hora_rsa, Date fecha, Integer horario) {
        this.id = id;
        this.lunes=lunes;
        this.martes=martes;
        this.miercoles=miercoles;
        this.jueves=jueves;
        this.viernes=viernes;
        this.sabado=sabado;
        this.domingo=domingo;
        this.horaEn = horaEn;
        this.horaSa = horaSa;
        this.hora_ren = hora_ren;
        this.hora_rsa = hora_rsa;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Boolean getLunes() {
        return lunes;
    }

    public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

    public Boolean getMartes() {
        return martes;
    }

    public void setMartes(Boolean martes) {
        this.martes = martes;
    }

    public Boolean getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

    public Boolean getJueves() {
        return jueves;
    }

    public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

    public Boolean getViernes() {
        return viernes;
    }

    public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }
    
    
}
