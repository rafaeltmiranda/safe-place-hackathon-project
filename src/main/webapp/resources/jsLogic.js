$(document).ready(function () {

    $.ajax({
        url: 'http://localhost:8080/api/' + id,
        async: true,
        success: successCallback,
        error: errorCallback
    });

    /*$.ajax({
        url: 'http://localhost:8080/api/' + id,
        type: 'POST',
        data: JSON.stringify({
            name: $('#btn').val(),
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });*/

    function successCallback() {

        console.log("Success!!!!!" + ('#btn').val())

    }

    function errorCallback() {

        console.log("Error!!!!!" + ('#btn').val())

    }

});







