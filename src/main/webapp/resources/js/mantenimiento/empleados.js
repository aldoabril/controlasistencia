/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $(".ver").click(function () {

        var idEmpleado = $(this).attr("regId");

        $.get(path + "obtener/" + idEmpleado + ".json", null, function (data) {
            if (data) {
                fillForm(data);
                OnlyRead();
                formhide($(".btnguardar"));
            }
        });
    });

    $(".editar").click(function () {
        var idEmpleado = $(this).attr("regId");

        $.get(path + "obtener/" + idEmpleado + ".json", null, function (data) {
            if (data) {
                fillForm(data);
                ReadAndWrite();
                formshow($(".btnguardar"));
            }
        });
    });

    $(".deleted").click(function () {
        var r = confirm("Esta seguro de eliminar este Empleado?");
        if (r) {
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function (data) {
                if (data.status === "success") {
                    alert("::EXITO:: EMPLEADO :: Eliminado.");
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
        ActualizarEmpleado();
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
    $("#cargo").val(data.cargo);

    //$("#agencia").val(data.agencia.id);


    $("#example").modal('show');
}

function OnlyRead() {

    $("#dni").attr("readonly", "readonly");
    $("#apellidoPat").attr("readonly", "readonly");
    $("#apellidoMat").attr("readonly", "readonly");
    $("#nombres").attr("readonly", "readonly");
    $("#fechanac").attr("readonly", "readonly");
    $("#cargo").prop('disabled', true);
    //$("#agencia").prop('disabled', true);
}

function ReadAndWrite() {

    $("#dni").removeAttr("readonly");
    $("#apellidoPat").removeAttr("readonly");
    $("#apellidoMat").removeAttr("readonly");
    $("#nombres").removeAttr("readonly");
    $("#fechanac").removeAttr("readonly");
    $("#cargo").prop('disabled', false);
    //$("#agencia").prop('disabled', false);
}

function formshow(nameform) {
    $(nameform).css("display", "inline");
}

function formhide(nameform) {
    $(nameform).css("display", "none");
}

function ActualizarEmpleado() {

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
                        alert("::EXITO:: EMPLEADO :: Datos Modificados.");
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