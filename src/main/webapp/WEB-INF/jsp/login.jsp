
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cp" scope="application" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso Control de Asistencias</title>
        <link rel="stylesheet" href="${cp}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${cp}/resources/css/login.css">
    </head>
    <body>
        <div class="login-container jumbotron container-fluid">
            <h1 class="text-center" id="text-center">Login</h1>
            <hr>
            
            <form method="POST" action="j_spring_security_check">
                <div class="form-group">
                    <label for="usuario" class="">Usuario</label>
                    <input id="usuario" type="text" name="j_username" class="form-control" autofocus required/>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label">Password</label>
                    <input id="password" type="password" name="j_password" class="form-control" required /><br>
                </div>
                <div class="text-center">
                    <input type="submit" value="Ingresar" class="btn btn-success" />
                    <input type="reset" value="Limpiar" class="btn btn-primary" />                    
                </div>
            </form>
        </div>
        <c:if test="${not empty error}">
            <div class="row">
                <div class="col-md-offset-4 col-md-4">
                    <div class="alert alert-danger text-center">
                        ${error}
                    </div>
                </div>
            </div>
        </c:if>

        <script src="${cp}/resources/js/jquery.min.js"></script>
        <script src="${cp}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
