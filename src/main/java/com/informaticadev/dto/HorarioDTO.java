
package com.informaticadev.dto;


public class HorarioDTO {
    private Integer id;
    private String nombre;
    private boolean refrigerio;
    private boolean vigente;

    public HorarioDTO(Integer id) {
        this.id = id;
    }
    
    public HorarioDTO(){
        
    }
    
    public HorarioDTO(Integer id, String nombre, boolean refrigerio) {
        this.id = id;
        this.nombre = nombre;
        this.refrigerio = refrigerio;
        this.vigente = true;
    }

    public HorarioDTO(Integer id, String nombre, boolean refrigerio, boolean vigente) {
        this.id = id;
        this.nombre = nombre;
        this.refrigerio = refrigerio;
        this.vigente = true;
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

    public boolean isRefrigerio() {
        return refrigerio;
    }

    public void setRefrigerio(boolean refrigerio) {
        this.refrigerio = refrigerio;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return "HorarioDTO{" + "id=" + id + ", nombre=" + nombre + ", refrigerio=" + refrigerio + ", vigente=" + vigente + '}';
    }
    
    
    
    
}
