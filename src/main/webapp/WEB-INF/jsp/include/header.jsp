
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" scope="application" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%=new java.util.Date()%>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Control de asistencias ::</title>
        <link rel="stylesheet" href="${cp}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${cp}/resources/css/bootstrap-datepicker3.min.css">
        <link rel="stylesheet" href="${cp}/resources/css/bootstrap-timepicker.min.css">
        <link rel="stylesheet" href="${cp}/resources/css/main.css">
        <link rel="stylesheet" href="${cp}/resources/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div>                        
                        <a class="navbar-brand" href="${cp}/index.html" style="display: inline; float: right; position: relative;">&nbsp;:. Control System .:</a>                    
                    </div>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Mantenimiento <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${cp}/mantenimiento/empleados/index.html">Empleados</a></li>
                                <li><a href="${cp}/mantenimiento/horarios/index.html">Horarios</a></li>
                                
                                    <sec:authorize access="hasAnyRole('ADMIN')">
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${cp}/mantenimiento/usuarios/index.html">Usuarios</a></li>
                                    </sec:authorize>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Procesos<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${cp}/proceso/empleados/nuevo.html">Registrar Empleado</a></li>
                                <li><a href="${cp}/proceso/horarios/nuevo.html">Registrar Horario</a></li>                                
                                
                                    <sec:authorize access="hasAnyRole('ADMIN')">
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${cp}/proceso/usuarios/nuevo.html">Registrar Usuario</a></li>
                                    </sec:authorize>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Consultas <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${cp}/consulta/empleados/ver.html">Empleados</a></li>
                                <li><a href="${cp}/consulta/horarios/ver.html">Horarios</a></li>
                                                                
                                    <sec:authorize access="hasAnyRole('ADMIN')">
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${cp}/consulta/usuarios/ver.html">Usuarios</a></li>
                                    </sec:authorize>                       
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Reportes <span class="caret"></span></a>
                            <ul class="dropdown-menu">                                
                                <li><a href="${cp}/reporte/empleados/reportes.html">Empleados</a></li>
                                <li><a href="${cp}/reporte/horarios/reportes.html">Horarios</a></li>
                                    
                                    <sec:authorize access="hasAnyRole('ADMIN')">
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${cp}/reporte/usuarios/reporte.html">Usuarios</a></li>
                                    </sec:authorize> 
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ayuda<span class="caret"></span></a>
                            <ul class="dropdown-menu">                                                                
                                <li><a href="${cp}/ayuda/manual/index.html">Manual de uso</a></li>
                            </ul>
                        </li>                       
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <!--   <li>                                    
                               <embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-174-2.swf width=200 height=45 wmode=transparent type=application/x-shockwave-flash></embed> 
                          </li>
                        -->                                                                            
                        <li><a href="${cp}/logout">Salir <span class="glyphicon glyphicon-log-out" /></a></li>                      
                    </ul>                                        

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

