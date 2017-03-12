$(document).ready(function () {

     $("#body-form").submit(function (e) {
        e.preventDefault();
        GuardarHorario();
    });

});

function GuardarHorario() {
    
        var form = $("#body-form").jsonify();
        alert(JSON.stringify(form));
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
                    alert("::EXITO:: Dia Guardado.");
                    window.location.reload(true);
                }

                if (data.status === "error") {
                    alert(data.msg);
                }
            }
        });
    
}

