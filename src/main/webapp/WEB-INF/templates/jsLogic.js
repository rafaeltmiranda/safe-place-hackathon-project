$(document).ready(function () {

    $('#btn').click(function(){

        $.ajax({
            url: 'http://localhost:8080/safeplace/api/',
            type: 'POST',
            data: JSON.stringify({
                name: $('#bar').val(),
            }),
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback
        });
        
    });

    function successCallback(request) {
       window.location.href = "safeplace/start" + request.id;
       
    }

    function errorCallback() {
        alert(Error);

    }

});







