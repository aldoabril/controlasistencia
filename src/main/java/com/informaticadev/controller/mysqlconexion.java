package com.informaticadev.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class mysqlconexion {
    static String url = "jdbc:mysql://localhost:3307/control-asistencias-bd";
    static String usuario="root";
    static String password="123456";

    public static Connection Conexion() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            
            return conexion;
        }catch(ClassNotFoundException ex){
            return null;
        }
    }


}
