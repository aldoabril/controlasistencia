<%-- 
    Document   : datos
    Created on : 25/01/2017, 02:52:02 PM
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>

<div id="consulta" class="container">
    <h3>Consulta Empleados</h3>
    <hr />
    <div class="row">

        <div class="col-md-offset-1 col-md-10">
            <form id="form-filtrar">
                <div class="input-group has-error">
                    <input id="search" type="text" class="form-control" placeholder="DNI, APELLIDOS O NOMBRES para filtrar búsqueda." value="${paginado.search}">
                    <span class="input-group-btn">
                        <button class="btn buscar"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </form>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="info">
                            <th>DNI</th>                            
                            <th>Nombres</th>
                            <th>Apellidos</th>                                                                                    
                            <th>Cargo</th>
                            <th>Agencia</th>
                            <th>Op(Id)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${paginado.items}">    
                            <tr>
                                <td>${e[2].dni}</td>                                
                                <td>${e[2].nombres}</td>                                
                                <td>${e[2].apellidop} ${e[2].apellidom}</td>                                                                
                                <td>${e[1].cargo.nombre}</td>
                                <td>${e[0].direccion}</td>                                                                

                                <td class="text-center pointer">
                                    <span regId="${e[1].id}" class="glyphicon glyphicon-search ver" title="Ver"></span>
                                    <sec:authorize access="hasAnyRole('ADMINISTRADOR')">
                                        <span regId="${e[1].id}" class="glyphicon glyphicon-edit editar" title="Editar"></span>
                                        <span regId="${e[1].id}" class="glyphicon glyphicon-remove deleted" title="Eliminar"></span>
                                    </sec:authorize>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
                <div class="text-center">
                    <nav>
                        <ul class="pager">
                            <li>
                                <a class="refresh" href="javascript:void(0);" style="float: left;">
                                    <span class="glyphicon glyphicon-refresh"></span>
                                </a>
                            </li>  
                            <li>
                                <a id="inicio" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-fast-backward"></span>
                                </a>
                            </li>
                            <li>
                                <a id="anterior" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-backward"></span>
                                </a>
                            </li>
                            <li>
                                <span class="page-text">&nbsp; ${paginado.page} / ${paginado.totalPage} páginas &nbsp;</span>
                            </li>
                            <li>
                                <a id="siguiente" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-forward"></span>
                                </a>
                            </li>
                            <li>
                                <a id="fin" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-fast-forward"></span>
                                </a>
                            </li>
                            <li>
                                <a class="refresh" href="javascript:void(0);" style="float: right;">
                                    <span class="glyphicon glyphicon-refresh"></span>
                                </a>
                            </li>  
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>                          

<div id="example" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel"><span class="glyphicon glyphicon-wrench"></span>&nbsp; Mantenimiento Empleado</h4>
            </div>
            <div id="dialog-content-servicio" class="modal-body">

                <form class="form-horizontal" id="form-edicion">
                    <input id="id" type="hidden" name="id" />
                    <div class="form-group">
                        <label for="dni" class="control-label col-xs-4">DNI:</label>
                        <div class="col-xs-6">
                            <input type="text" id="dni" name="dni"  maxlength="8" class="form-control" autofocus required/>
                        </div> 
                    </div>

                    <div class="form-group">
                        <label for="apellidoPat" class="control-label col-xs-4">Apellido.Pat</label>
                        <div class="col-xs-6">
                            <input type="text" id="apellidoPat" name="apellidoPat" class="form-control" autofocus required/>
                        </div> 
                    </div>

                    <div class="form-group">
                        <label for="apellidoMat" class="control-label col-xs-4">Apellido.Mat</label>
                        <div class="col-xs-6">
                            <input type="text" id="apellidoMat" name="apellidoMat" class="form-control" autofocus required/>
                        </div> 
                    </div>                                                      

                    <div class="form-group">
                        <label for="nombres" class="control-label col-xs-4">Nombres:</label>
                        <div class="col-xs-6">
                            <input type="text" id="nombres" name="nombres" class="form-control" autofocus required/>
                        </div> 
                    </div>

                    <div class="form-group">
                        <label for="fechanac" class="control-label col-xs-4">Fecha.Nac:</label>
                        <div class="col-xs-6">
                            <input type="text" id="fechanac" name="fechanac" class="form-control datepicker" onfocus="ConFocus()" onblur="SinFocus()" autofocus required/>
                        </div> 
                    </div>

                    <div class="form-group">
                        <label for="cargo" class="control-label col-xs-4">Cargo:</label>
                        <div class="col-xs-6">
                            <SELECT NAME="cargo" id="cargo" class="col-sm-12">
                                <c:forEach var="c" items="${cargoItems}">
                                    <OPTION VALUE="${c.id}" class="form-control">${c.nombre}</OPTION>
                                    </c:forEach>                                           
                            </SELECT>   
                        </div> 
                    </div>         

                    <div class="modal-footer">                
                        <input type="submit" value="Guardar" class=" btn btn-danger btnguardar"/>                        
                        <a data-dismiss="modal" class="btn btn-default">Cerrar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/empleados/';
    var paginacion = {
        page: ${paginado.page},
        size: ${paginado.size},
        search: '${paginado.search}',
        totalPage: ${paginado.totalPage}
    };
</script>
<script src="${cp}/resources/js/mantenimiento/empleados.js"></script>


