<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>


<div id="nuevo-empleado" class="container">
    <h3>Registrar Nuevo Usuario</h3>
    <hr>
    <div class="row">        
        <div id="data-serv" class="col-xs-offset-0 col-xs-12 body-container">
            <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> FORMULARIO NUEVO USUARIO</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal">
                        <div class="form-group has-error">
                            <input type="hidden" id="idpersona" name="idpersona"/>
                            <label for="dni" class="control-label col-xs-offset-2 col-xs-3">DNI:</label>                           
                            <div class="col-xs-2">
                                <input type="text" id="dni" name="dni" class="form-control" maxlength="8" autofocus required/>
                            </div>                             
                            <a class="btn btn-info buscarDni"><span class="glyphicon glyphicon-search"></span></a>                            
                        </div>
                        <hr>
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
                            <label for="fechanac" class="control-label col-xs-1">Fech-Nac:</label>
                            <div class="col-xs-2">
                                <input type="text" id="fechanac" name="fechanac" class="form-control datepicker"/>
                            </div> 

                        </div>                                                                                            
                        <hr>

                        <div class="form-group has-error">                               
                            <label for="rol" class="control-label col-xs-1"> Rol:</label>
                            <div class="col-xs-3">                                
                                <SELECT NAME="rol" id="rol" class="col-sm-12">
                                    <c:forEach var="r" items="${rolItems}">
                                        <OPTION VALUE="${r.id}" class="form-control">${r.nombre}</OPTION>
                                        </c:forEach>                                           
                                </SELECT>                                                               
                            </div>                                                                                    

                            <label for="username" class="control-label col-xs-1"> Username:</label>
                            <div class="col-xs-3">
                                <input type="text" id="username" name="username" class="form-control" autofocus required/>
                            </div>

                            <label for="password" class="control-label col-xs-1"> Password:</label>
                            <div class="col-xs-3">
                                <input type="password" id="password" name="password" class="form-control" autofocus required/>
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
<script>
    var path = '${cp}/proceso/usuarios/';
</script>
<script src="${cp}/resources/js/proceso/usuarios.js"></script>