/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $(".datepicker").datepicker({
        format: 'dd-mm-yyyy'
    });
});

function showError(msg) {
    var errorMessage = $("#error-message");
    errorMessage.html(msg);
    errorMessage.fadeIn();
    setTimeout(function () {
        errorMessage.fadeOut();
    }, 5000);
}

function isTextValid(text) {
    return text && text.trim() !== "";
}

function isTextLengthValid(text, length) {
    return text && text.length === length;
}

function isNumber(text) {
    return text && !isNaN(text);
}