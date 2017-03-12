
<%@page import="mis.model.Consulta"%>
<%@page import="com.informaticadev.entity.Horario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html>
<html>
    <head >
        <meta http-equiv="refresh" content="0;url=nuevo.html">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
        <title>Exito</title>
    </head>
    <body>
        <%
            //if(request.getParameter("nombre")!=null&&request.getParameter("refrigerio")!=null
             //       &&request.getParameter("vigente")!=null){
                
                //if(request.getParameter("refrigerio").equalsIgnoreCase("")){
                  //  out.print("queso");
                //}
                
                boolean r=false, v=false;
                if(request.getParameter("refrigerio")!=null){
                   r=true;
                }
                
                if(request.getParameter("vigente")!=null){
                   r=true;
                }
                
               Horario hor = new Horario(request.getParameter("nombreh"),r,v);
               boolean respuesta= Consulta.InsertarHorario(hor);
               
               if(respuesta){
                   out.println("Datos Ingresados");
               }else{
                   out.print("Datos No Ingresados");
               }

            %>
            
    </body>
</html>
