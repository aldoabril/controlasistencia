<%-- 
    Document   : nuevo
    Created on : 15/03/2016, 12:22:50 PM
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>


<div id="nuevo-empleado" class="container">
    <h3>Registrar Nuevo Empleado</h3>
    <hr />
    <div class="row">        
        <div id="data-serv" class="col-xs-offset-0 col-xs-12 body-container">
            <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> DATOS PERSONALES</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal">
                        <div class="form-group has-error">
                            <label for="idempleado" class="control-label col-xs-4">Id Empleado</label>
                            <div class="col-xs-6">
                                <input type="text" id="idempleado" name="idempleado" class="form-control" autofocus required/>
                            </div> 
                        </div>
                        <div class="form-group has-error">
                            <label for="nombres" class="control-label col-xs-4">Nombres:</label>
                            <div class="col-xs-6">
                                <input type="text" id="nombres" name="nombres" class="form-control" autofocus required/>
                            </div> 
                        </div>
                        <div class="form-group has-error">
                            <label for="apellidoPat" class="control-label col-xs-4">Apellido Paterno:</label>
                            <div class="col-xs-6">
                                <input type="text" id="apellidoPat" name="apellidoPat" class="form-control" autofocus required/>
                            </div> 
                        </div>
                        <div class="form-group has-error">
                            <label for="apellidoMat" class="control-label col-xs-4">Apellido Materno:</label>
                            <div class="col-xs-6">
                                <input type="text" id="apellidoMat" name="apellidoMat" class="form-control" autofocus required/>
                            </div> 
                        </div>
                        <div class="form-group has-error">
                            <label for="dni" class="control-label col-xs-4">DNI:</label>
                            <div class="col-xs-6">
                                <input type="text" id="dni" name="dni" class="form-control" maxlength="8" autofocus required/>
                            </div> 
                        </div>                    
                                                
                        <div class="form-group has-error">
                            <label for="fechanac" class="control-label col-xs-4">Fech-Nac:</label>
                            <div class="col-xs-6">
                                <input type="text" id="fechanac" name="fechanac" class="form-control datepicker" onfocus="ConFocus()" onblur="SinFocus()" />
                            </div> 
                        </div>

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

