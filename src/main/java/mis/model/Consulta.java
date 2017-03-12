
package mis.model;

import com.informaticadev.controller.mysqlconexion;
import java.util.List;
import com.informaticadev.entity.Horario;
import java.sql.*;
import java.util.ArrayList;


public class Consulta {
    static String query;
    static Connection conexion=null;
    static Statement stm=null;
    static ResultSet rs=null;
    static PreparedStatement ps=null;
    
    public static List <Horario> MostrarHorario(){
        List <Horario> horario= new ArrayList <Horario>();
        try{
            query= "SELECT id,nombre,refrigerio,vigente FROM HORARIO";
            Connection conexion = mysqlconexion.Conexion();
            stm=conexion.createStatement();
            rs=stm.executeQuery(query);
            while(rs.next()){
                Horario hor = new Horario(rs.getInt("id"),rs.getString("nombre"),rs.getBoolean("refrigerio"),rs.getBoolean("vigente"));
                horario.add(hor);
            }
            conexion.close();
            return horario;
        }catch(SQLException ex){
            return null;
        }
    }
    
      
    public static boolean InsertarHorario(Horario hor) {
      
        boolean a = false;
        try{
        conexion= mysqlconexion.Conexion();
            ps = conexion.prepareStatement("INSERT INTO `horario` (nombre, refrigerio, vigente) VALUES (?,?,?)");
            conexion.setReadOnly(false);
//query = "INSERT INTO horario VALUES (null,?,?,?)";
        
        //ps=conexion.prepareStatement(query);
        System.out.print(hor.getRefrigerio()+"y"+hor.getVigente());
            System.out.println(conexion.isReadOnly());
        ps.setString(1,hor.getNombre());
        ps.setBoolean(2,hor.getRefrigerio());
        ps.setBoolean(3,hor.getVigente());
        ps.executeUpdate();
        conexion.close();
        a=true;
        }catch(SQLException ex){
            a=false;
            System.out.println(ex);
        }
        
        return a;
        
    }
    
        public static List<Dia> MostrarDias(int idhor){
        List <Dia> dia= new ArrayList <Dia>();
        try{
            query= "SELECT id,nombre,horaEn,horaSa,hora_ren,hora_rsa,fecha,horario FROM DIA WHERE horario='"+idhor+"'";
            Connection conexion = mysqlconexion.Conexion();
            stm=conexion.createStatement();
            rs=stm.executeQuery(query);
            System.out.println("queso");
            while(rs.next()){
                
                Dia d = new Dia(rs.getInt("id"),rs.getString("nombre").charAt(0),rs.getTime("horaEn"),rs.getTime("horaSa"),rs.getTime("hora_ren"),rs.getTime("hora_rsa"),rs.getDate("fecha"),rs.getInt("horario"));
                dia.add(d);
                
            }
            conexion.close();
            return dia;
        }catch(SQLException ex){
            System.out.println(ex);
            return null;
            
        }
   }
    
}
