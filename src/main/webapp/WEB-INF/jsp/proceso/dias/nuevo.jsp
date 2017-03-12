
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="mis.model.Consulta"%>
<%@page import="mis.model.Dia"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.informaticadev.controller.mysqlconexion"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>

    <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> FORMULARIO NUEVO HORARIO</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal" action="exitonuevo.html">
                        
                            <h2>Nombre del Horario: <%=request.getParameter("nombreh")%></h2>
                    <%
                        String d="";
                        if(request.getParameter("refrigerio").equalsIgnoreCase("false")){
                            d= "disabled";
                        }
                    %>
                    <h3>Seleccione los días: </h3>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="lunes">Lunes</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="martes">Martes</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="miercoles">Miercoles</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="jueves">Jueves</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="viernes">Viernes</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="sabado">Sabado</label>
                    <label class="checkbox-inline"><input type="checkbox" value="" name="domingo">Domingo</label> <br>
                    <br>
                    <label>Hora de Entrada: <input type="time" value="0" name="horaEn"></label><br>
                    <label>Hora de Salida: <input type="time" value="0" name="horaSa"></label><br>
                    <label>Hora de Entrada al Refrigerio: <input type="time" value="0" name="hora_ren" <%=d%>></label><br>
                    <label>Hora de Salida al Refrigerio: <input type="time" value="0" name="hora_rsa" <%=d%>></label>
                            </div>                                                           
                        </div>

                                                                                                                   
                        <hr>
                                                                               
                       
                        <div class="text-center">                                                       
                            <input type="reset" value="Limpiar" class=" btn btn-default"/>
                            <input type="submit" value="Guardar" class=" btn btn-danger"/>                           
                        </div>
                    
 <div class="container">
  <h2>Programación del Horario</h2>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Día</th>
        <th>Hora de Entrada</th>
        <th>Hora de Entrada REF</th>
        <th>Hora de Salida REF</th>
        <th>Hora de Salida</th>
        <th>Fecha</th>
      </tr>
    </thead>
    <tbody>
      <%
                            
                               List<Dia> dias= Consulta.MostrarDias(Integer.parseInt(request.getParameter("idhor")));
                               String ndia;
                               for (int i = 0; i < dias.size(); i++) {
                                   switch(dias.get(i).getNombre()){
                                       case '1':
                                           ndia="Lunes";
                                           break;
                                       case '2':
                                            ndia="Martes";
                                            break;
                                       case '3':
                                           ndia="Miercoles";
                                           break;
                                       case '4':
                                           ndia="Jueves";
                                           break;
                                       case '5':
                                           ndia="Viernes";
                                           break;
                                       case '6':
                                           ndia="Sábado";
                                           break;
                                       case '7':
                                           ndia="Domingo";
                                           break;
                                       default:
                                           ndia="No found";
                                           break;
                                   }
                                   %>
                                   <tr>
                                       <th><%=ndia%></th>
                                       <th><%=dias.get(i).getHoraEn()%></th>
                                       <th><%=dias.get(i).getHoraSa()%></th>
                                       <th><%=dias.get(i).getHoraren()%></th>
                                       <th><%=dias.get(i).getHorarsa()%></th>
                                       <th><%=dias.get(i).getFecha()%></th>
                                       </tr>
                                   <%                                        
                                   }%>
    </tbody>
  </table>
</div>

<%@include file="/WEB-INF/jsp/include/footer.jsp" %>

<script>
    var path = '${cp}/proceso/dias/';
</script>
<script src="${cp}/resources/js/proceso/dias.js"></script>
