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
        document.getElementById(cellId).value = "";
    } else if(parseInt(element) > 9) {
        document.getElementById(cellId).value = element[0];
    }
}

function solvePuzzle() {
    var Http = new XMLHttpRequest();
    const url = 'http://localhost:8080/SudokuSolver_war/rest/solve';
    Http.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let response = JSON.parse(this.responseText);
            fillTable(response);
        }
    }
    Http.open("POST", url, true);
    Http.setRequestHeader("Content-type", "application/json")
    Http.send(getTableContent());
}

function fillTable(answer) {
    for(var id = 0; id < 81; id++) {
        if(document.getElementById(id).value == "") {
            document.getElementById(id).classList.add("blue-text");
        } else {
            document.getElementById(id).classList.add("black-text");
        }

        document.getElementById(id).value = answer[id];
    }
}

function clearBoard() {
    for(var id = 0; id < 81; id++) {
        document.getElementById(id).classList.remove("blue-text");
        document.getElementById(id).classList.remove("black-text");
        document.getElementById(id).value = "";
    }
}

function getTableContent() {
    var jsonContent = "{";
    for (var i = 0; i < 9; i++) {
        for (var j = 0; j < 9; j++) {
            var id = i*9+j;
            var value = document.getElementById(id).value;
            if(value == '') {
                value = 0;
            }
            jsonContent += '"' + id + '":"' + value + '",';
        }
    }
    jsonContent.substring(0, jsonContent.length - 1);
    jsonContent += '}';
    return jsonContent;
}