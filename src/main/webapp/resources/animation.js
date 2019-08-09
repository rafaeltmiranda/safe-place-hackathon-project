
var id = setInterval(frame, 5);
/*
function frame() {
    if (/* test for finished *//*) {
        clearInterval(id);
    } else {
       /* code to change the element style *//*
    }
}
*/

function myMove() {
    var elem = document.getElementById("m");
    var pos = 0;
    var id = setInterval(frame, 10);
    function frame() {
        if (pos == 350) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.top = pos + 'px';
            elem.style.left = pos + 'px';
        }
    }
}

function myMove() {
    var elem = document.getElementById("m");
    var pos = 0;
    var id = setInterval(frame, 20);
    function frame() {
        if (pos == 350) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.top = pos + 'px';
            elem.style.left = pos + 'px';
        }
    }
}