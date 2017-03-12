

<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>


<div id="nuevo-empleado" class="container">
    <h3>Asignar Horario</h3>
    <hr>
    <div class="row">        
        <div id="data-serv" class="col-xs-offset-0 col-xs-12 body-container">
            <div id="form-new" class="panel panel-primary">
                <div class="panel-heading body-header"><center><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> FORMULARIO NUEVO HORARIO</center></div>
                <div class="panel-body">                    
                    <form id="body-form" class="form-horizontal">
                        
                            <label for="nombreh" class="control-label col-xs-3"> Nombre del Horario:</label>
                            <div class="col-xs-6">
                                <input type="text" id="nombreh" name="nombreh" class="form-control" autofocus required/>
                            </div>  
                            <a class="btn btn-info buscarHorario"><span class="glyphicon glyphicon-search"></span></a>
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