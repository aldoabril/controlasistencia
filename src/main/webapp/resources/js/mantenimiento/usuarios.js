/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $(".ver").click(function () {
        var idUser = $(this).attr("regId");

        $.get(path + "obtener/" + idUser + ".json", null, function (data) {
            if (data) {
                fillForm(data);
                OnlyRead();
                formhide($(".btnguardar"));
            }
        });
    });

    $(".editar").click(function () {
        var idUser = $(this).attr("regId");

        $.get(path + "obtener/" + idUser + ".json", null, function (data) {
            if (data) {
                fillForm(data);
                ReadAndWrite();
                formshow($(".btnguardar"));
            }
        });
    });

    $(".deleted").click(function () {
        var r = confirm("Esta seguro de eliminar este Usuario?");
        if (r) {
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function (data) {
                if (data.status === "success") {
                    alert("::EXITO:: USUARIO :: Eliminado.");
                    window.location.reload(true);
                }
                if (data.status === "error") {
                    alert(data.msg);
                }
            });
        }
    });

    $("#form-edicion").submit(function (e) {
        e.preventDefault();
        ActualizarUsuario();
    });

    $(".ChangeValAtrib").html(function (buscayreemplaza, reemplaza) {
        if (reemplaza === 'false')
            return reemplaza.replace('false', 'Activo');
        else
            return reemplaza.replace('true', 'Inactivo');
    });


// Paginacion
    $("#inicio").click(function () {
        if (paginacion.page > 1) {
            window.location.search = "page=1&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });

    $("#anterior").click(function () {
        if ((paginacion.page - 1) > 0) {
            paginacion.page--;
            window.location.search = "page=" + paginacion.page + "&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });

    $("#siguiente").click(function () {
        if ((paginacion.page + 1) <= paginacion.totalPage) {
            paginacion.page++;
            window.location.search = "page=" + paginacion.page + "&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });

    $("#fin").click(function () {
        if (paginacion.page < paginacion.totalPage) {
            window.location.search = "page=" + paginacion.totalPage + "&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });

    $(".refresh").click(function (e) {
        e.preventDefault();
        window.location.href = path + "index.html";
    });

    $("#form-filtrar").submit(function (e) {
        e.preventDefault();
        window.location.search = "page=1&size=" + paginacion.size + "&search=" + $("#search").val();
    });

});

function fillForm(data) {
    $("#id").val(data.id);
    $("#dni").val(data.dni);
    $("#apellidoPat").val(data.apellidoPat);
    $("#apellidoMat").val(data.apellidoMat);
    $("#nombres").val(data.nombres);
    $("#fechanac").val(data.fechanac);
    $("#username").val(data.username);
    $("#password").val(data.password);
    $("#rol").val((data.rol.id));

    $("#example").modal('show');
}

function OnlyRead() {

    $("#dni").attr("readonly", "readonly");
    $("#apellidoPat").attr("readonly", "readonly");
    $("#apellidoMat").attr("readonly", "readonly");
    $("#nombres").attr("readonly", "readonly");
    $("#fechanac").attr("readonly", "readonly");
    $("#username").attr("readonly", "readonly");
    //$("#password").attr("readonly", "readonly");
    formhide($("#div-password"));
    $("#rol").prop('disabled', true);
}

function ReadAndWrite() {

    $("#dni").removeAttr("readonly");
    $("#apellidoPat").removeAttr("readonly");
    $("#apellidoMat").removeAttr("readonly");
    $("#nombres").removeAttr("readonly");
    $("#fechanac").removeAttr("readonly");
    $("#username").attr("readonly", "readonly");
    //$("#password").removeAttr("readonly");
    formshow($("#div-password"));
    $("#rol").prop('disabled', false);
}

function formshow(nameform) {
    $(nameform).css("display", "inline");
}

function formhide(nameform) {
    $(nameform).css("display", "none");
}

function ActualizarUsuario() {

    if (isFormValid()) {
        if (confirm("?Desea guardar cambios?")) {
            var form = $("#form-edicion").jsonify();
            //alert(JSON.stringify(form));
            $.ajax({
                url: path + "actualizar.json",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(form),
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    if (data.status === "success") {
                        alert("::EXITO:: USUARIO :: Datos Modificados.");
                        window.location.reload(true);
                    }

                    if (data.status === "error") {
                        alert(data.msg);
                    }
                }
            });
        }
    }
}


function isFormValid() {

    if (!isTextValid($("#dni").val())) {
        showError("Debe ingresar DNI.");
        return false;
    }
    if (!isTextValid($("#nombres").val())) {
        showError("Debe ingresar nombres.");
        return false;
    }

    if (!isTextValid($("#apellidoPat").val())) {
        showError("Debe ingresar los apellidos.");
        return false;
    }
    if (!isTextValid($("#apellidoMat").val())) {
        showError("Debe ingresar los apellidos.");
        return false;
    }

    if (!isTextValid($("#fechanac").val())) {
        showError("Debe ingresar la fecha de nacimiento.");
        return false;
    }

    if (!isTextValid($("#username").val())) {
        showError("Debe ingresar username");
        return false;
    }
    return true;
}


function ConFocus() {
    fechanac = $("#fechanac").val();
}

function SinFocus() {

    if ($("#fechanac").val() === "") {
        $("#fechanac").val(fechanac);
    }
}