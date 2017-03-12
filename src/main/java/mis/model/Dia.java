
package mis.model;
import java.sql.Date;
import java.sql.Time;

public class Dia {
    Integer id;
    Character nombre;
    Time horaEn;
    Time horaSa;
    Time horaren;
    Time horarsa;
    Date fecha;
    Integer horario;
    
    public Dia(Integer id, Character nombre, Time horaEn, Time horaSa, Time horaren, Time horarsa, Integer horario){
        this.id=id;
        this.nombre = nombre;
        this.horaEn = horaEn;
        this.horaSa = horaSa;
        this.horaren = horaren;
        this.horarsa = horarsa;
        this.horario = horario;
    }
    
       
    public Dia(Integer id, Character nombre, Time horaEn, Time horaSa, Time horaren, Time horarsa, Date fecha, Integer horario) {
        this.id = id;
        this.nombre = nombre;
        this.horaEn = horaEn;
        this.horaSa = horaSa;
        this.horaren = horaren;
        this.horarsa = horarsa;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getNombre() {
        return nombre;
    }

    public void setNombre(Character nombre) {
        this.nombre = nombre;
    }

    public Time getHoraEn() {
        return horaEn;
    }

    public void setHoraEn(Time horaEn) {
        this.horaEn = horaEn;
    }

    public Time getHoraSa() {
        return horaSa;
    }

    public void setHoraSa(Time horaSa) {
        this.horaSa = horaSa;
    }

    public Time getHoraren() {
        return horaren;
    }

    public void setHoraren(Time horaren) {
        this.horaren = horaren;
    }

    public Time getHorarsa() {
        return horarsa;
    }

    public void setHorarsa(Time horarsa) {
        this.horarsa = horarsa;
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
    
    
}
