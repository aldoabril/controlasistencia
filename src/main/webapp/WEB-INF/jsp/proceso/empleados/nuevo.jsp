<%-- 
    Document   : nuevo
    Created on : 15/03/2016, 12:22:50 PM
    Author     : CARLOS
--%>

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

                            <label for="direccion" class="control-label col-xs-1">Direccion:</label>
                            <div class="col-xs-4">
                                <input type="text" id="direccion" name="direccion" class="form-control" autofocus required/>
                            </div> 
                        </div>                                                                                            
                        <hr>

                        <div class="form-group has-error">                               
                            <label for="idCargo" class="control-label col-xs-1"> Cargo:</label>
                            <div class="col-xs-3">                                
                                <SELECT NAME="idCargo" id="idCargo" class="col-sm-12">
                                    <c:forEach var="c" items="${cargoItems}">
                                        <OPTION VALUE="${c.id}" class="form-control">${c.nombre}</OPTION>
                                        </c:forEach>
                                </SELECT> 
                            </div> 

                            <label for="idAgencia" class="control-label col-xs-1"> Agencia:</label>
                            <div class="col-xs-3">                                
                                <SELECT NAME="idAgencia" id="idAgencia" class="col-sm-12">
                                    <c:forEach var="a" items="${agenciaItems}">          
                                        <OPTION VALUE="${a.id}" class="form-control">${a.direccion}</OPTION>                                       
                                        </c:forEach>                               
                                </SELECT> 
                            </div> 

                            <label for="idTarjeta" class="control-label col-xs-1"> Tarjeta:</label>
                            <div class="col-xs-3">
                                <input type="text" id="idTarjeta" name="idTarjeta" class="form-control" autofocus required/>
                            </div>                                                           
                        </div>
                        <hr>
                        <div class="text-center">                                                       
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

