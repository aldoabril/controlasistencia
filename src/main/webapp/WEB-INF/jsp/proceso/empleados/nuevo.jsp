

<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>


<div id="nuevo-empleado" class="container">
    <h3>Registrar Nuevo Empleado</h3>
    <hr>
    <div class="row">        
        <div id="data-serv" class="col-xs-offset-0 col-xs-12 body-container">
            <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> FORMULARIO NUEVO EMPLEADO</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal">
                        <div class="form-group has-error">    
                            <input type="hidden" id="usercreador" name="usercreador" value="<sec:authentication property="principal.username"/>"/>                            
                            <label for="apellidoPat" class="control-label col-xs-1"> Ap.Paterno:</label>
                            <div class="col-xs-2">
                                <input type="text" id="apellidoPat" name="apellidoPat" class="form-control" autofocus required/>
                            </div> 

                            <label for="apellidoMat" class="control-label col-xs-1"> Ap.Materno:</label>
                            <div class="col-xs-2">
                                <input type="text" id="apellidoMat" name="apellidoMat" class="form-control" autofocus required/>
                            </div>

                            <label for="nombres" class="control-label col-xs-1"> Nombres:</label>
                            <div class="col-xs-4">
                                <input type="text" id="nombres" name="nombres" class="form-control" autofocus required/>
                            </div>                                                           
                        </div>

                        <div class="form-group has-error">
                            <label for="dni" class="control-label col-xs-1">DNI:</label>
                            <div class="col-xs-2">
                                <input type="text" id="dni" name="dni" class="form-control" maxlength="8" autofocus required/>
                            </div> 

                            <label for="fechanac" class="control-label col-xs-1">Fech-Nac:</label>
                            <div class="col-xs-2">
                                <input type="text" id="fechanac" name="fechanac" class="form-control datepicker" onfocus="ConFocus()" onblur="SinFocus()" />
                            </div> 

                            <label for="perscod" class="control-label col-xs-1">Cod.Pers</label>
                            <div class="col-xs-4">
                                <input type="text" id="perscod" name="perscod" class="form-control" autofocus required/>
                            </div> 
                        </div>                                                                                            
                        <hr>

                        <div class="form-group has-error">                               
                            <label for="cargo" class="control-label col-xs-1"> Cargo:</label>
                            <div class="col-xs-4">                                
                                <SELECT NAME="cargo" id="cargo" class="col-sm-12">
                                    <c:forEach var="c" items="${cargoItems}">
                                        <OPTION VALUE="${c.id}" class="form-control">${c.nombre}</OPTION>
                                        </c:forEach>
                                </SELECT> 
                            </div> 

                            <label for="agencia" class="control-label col-xs-1"> Agencia:</label>
                            <div class="col-xs-4">                                
                                <SELECT NAME="agencia" id="agencia" class="col-sm-12">
                                    <c:forEach var="a" items="${agenciaItems}">          
                                        <OPTION VALUE="${a.id}" class="form-control">${a.direccion}</OPTION>                                       
                                        </c:forEach>                               
                                </SELECT> 
                            </div>                                  

                        </div>
                        <hr>
                        <div class="text-center" id="btns-guardarEmpleado">                                                       
                            <input type="reset" value="Limpiar" class=" btn btn-default"/>
                            <input type="submit" value="Guardar" class=" btn btn-danger"/>                           
                        </div>
                    </form>
                    <br>
                    <p id="error-message" class="alert alert-danger" style="display: none;"></p>
                </div>
            </div>
        </div>   
    </div>
</div>                     
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/proceso/empleados/';
</script>
<script src="${cp}/resources/js/proceso/empleados.js"></script>
