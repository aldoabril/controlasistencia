<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>

<%@page import="java.util.List"%>
<%@page import="mis.model.Consulta"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.informaticadev.controller.mysqlconexion"%>
<%@page import="com.informaticadev.entity.Horario"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>



<div id="nuevo" class="container">
    
    <h3>Registrar Nuevo Horario</h3>
    <hr>
    <div class="row">        
        <div id="data-serv" class="col-xs-offset-0 col-xs-12 body-container">
            <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> FORMULARIO NUEVO HORARIO</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal">
                        
                        
                        
                            <label for="nombre" class="control-label col-xs-3"> Nombre del Horario:</label>
                            <div class="col-xs-6">
                                <input type="text" id="nombreh" name="nombre" class="form-control" autofocus required/>
                            </div>                                                           
                        
                                                                                                                  
                        <hr>
                        
                        <div class="checkbox">
                            <label><input type="checkbox" value="true" name="refrigerio">Refrigerio</label>
                        </div> 
                        
                        <div class="text-center">                                                       
                            <input type="reset" value="Limpiar" class=" btn btn-default"/>
                            <input type="submit" value="Guardar" class=" btn btn-danger"/>                           
                        </div>
                     </form>
            </div>
            <br>
            <div class="container">
                <div id="form-new" class="panel panel-primary" >
                <h2>Horarios Registrados</h2>
                 
  <p>Estos Son Todos Los Horarios Registros A La Fecha</p>                                                                                      
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Refrigerio</th>
        <th>Vigencia</th>
      </tr>
    </thead>
     <tbody>
       <%
      
                               List<Horario> horarios= Consulta.MostrarHorario();
                               for (int i = 0; i < horarios.size(); i++) {
                                   String r="No",v="No";
                                   if(horarios.get(i).getRefrigerio()){
                                       r="Si";
                                   }
                                   if(horarios.get(i).getVigente()){
                                       v="Si";
                                   }
                                   %>
                                   <tr>
                                       <th><%=horarios.get(i).getNombre()%></th>
                                       <th><%=r%></th>
                                       <th><%=v%></th>
                                       
                                       <th><a href="${cp}/proceso/dias/nuevo.html?idhor=<%=horarios.get(i).getId()%>&&nombreh=<%=horarios.get(i).getNombre()%>&&refrigerio=<%=horarios.get(i).getRefrigerio()%>" class="btn btn-default btn-lg" role="button">Agregar Días</a></th>
                                        
                                       </tr>
                                   <%                                        
                                   }%>
    </tbody>
  </table>
  </div>
</div>
                </div>
                        
                    </form>
                    <br>
                    <p id="error-message" class="alert alert-danger" style="display: none;"></p>
                </div>
            </div>
        </div> 
    </div>
                       
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/proceso/horarios/';
</script>
<script src="${cp}/resources/js/proceso/horario.js"></script>
