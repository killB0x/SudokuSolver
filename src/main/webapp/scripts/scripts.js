loadTable();

function loadTable() {
    var element = document.getElementById("board");
    var content = "<table class = \"center\" id = \"boardTable\">";
    for(let i = 0; i < 9; i++) {
        if(i % 3 == 2) {
            content += "<tr class=\"borderBot\">";
        } else {
            content += "<tr>";
        }
        for(let j = 0; j < 9; j++) {
            let id = i * 9 + j;
            if(j % 3 == 2) {
                content += '<th class = "borderRight"><input  id = "'+ id + '" class = "cell" type="text" oninput = checkDigit('+ id +')></th>';
            } else {
                content += '<th><input  id = "'+ id + '" class = \"cell\" type=\"text\" oninput = checkDigit('+ id + ')></th>';
            }
        }
        content += "</tr>";
    }
    content += "</table>";
    element.innerHTML += content;
}

function checkDigit(cellId) {
    let element = document.getElementById(cellId).value;
    if(isNaN(parseInt(element)) || parseInt(element) < 1) {
        console.log(isNaN(parseInt(element)));
        document.getElementById(cellId).value = "";
    } else if(parseInt(element) > 9) {
        document.getElementById(cellId).value = element[0];
    }
}
