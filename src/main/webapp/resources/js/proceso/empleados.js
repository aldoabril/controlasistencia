/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $("#body-form").submit(function (e) {
        e.preventDefault();
        GuardarEmpleado();
    });

});

function GuardarEmpleado() {
    var form = $("#body-form").jsonify();
    //alert(JSON.stringify(form));
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
                alert("::EXITO:: Empleado Guardado.");
                window.location.reload(true);                
            }

            if (data.status === "error") {
                alert(data.msg);
            }
        }
    });
}