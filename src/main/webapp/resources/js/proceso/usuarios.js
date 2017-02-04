/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $(".buscarDni").click(function () {

        if (!isTextValid($("#dni").val())) {
            showError("Debe ingresar el DNI.");
        } else
            BuscarUsuario($("#dni").val());
    });

    $("#body-form").submit(function (e) {
        e.preventDefault();
        GuardarUsuario();
    });

});

function isFormValid() {

    if (!isTextValid($("#dni").val())) {
        showError("Debe ingresar el DNI.");
        return false;
    }

    if (!isTextLengthValid($("#dni").val(), 8)) {
        showError("El DNI debe tener 8 digitos.");
        return false;
    }

    if (!isTextValid($("#username").val())) {
        showError("Debe ingresar un username.");
        return false;
    }

    if (!isTextValid($("#password").val())) {
        showError("Debe ingresar una password.");
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

    if (!isTextValid($("#direccion").val())) {
        showError("Debe ingresar la dirección.");
        return false;
    }
    return true;
}

function BuscarUsuario(dni) {
    $.get(path + "obtenerDatosPersona/" + dni + ".json", null, function (data) {
        if (data) {
            alert("DNI ENCONTRADO");
            fillForm(data);
        } else
            alert("DNI NO REGISTRADO");
    });
}

function fillForm(data) {
    $("#apellidoPat").val(data.apellidoPat);
    $("#apellidoMat").val(data.apellidoMat);
    $("#nombres").val(data.nombres);
    $("#fechanac").val(data.fechanac);
    $("#direccion").val(data.direccion);
}

function GuardarUsuario() {
    if (isFormValid()) {
        var form = $("#body-form").jsonify();
        $.ajax({
            url: path + "guardar" + ".json",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(form),
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                if (data.status === "success") {
                    alert("::EXITO:: Usuario Guardado.");
                    window.location.reload(true);
                }

                if (data.status === "error") {
                    alert(data.msg);
                }
            }
        });
    }
}

