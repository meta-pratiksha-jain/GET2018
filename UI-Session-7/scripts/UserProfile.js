window.addEventListener('load', createChilds);

function createChilds(event) {
    var userData = JSON.parse(localStorage.getItem("user"));
    for (var index = 0; index < userData.length; index++) {
        createRow(userData[index]);
    }
}

function createRow(rowObject) {
    var userDataDiv = document.getElementById("user_data_div");
    var newRow = document.createElement("div");

    var label = document.createElement("label");
    label.setAttribute("class", "info_label");
    var labelText = document.createTextNode(rowObject["label"]);
    label.appendChild(labelText);
    newRow.appendChild(label);

    var detail = document.createElement("label");
    detail.setAttribute("class", "info_value");
    var detailText = document.createTextNode(rowObject["value"]);
    detail.appendChild(detailText);
    newRow.appendChild(detail);
    userDataDiv.appendChild(newRow);
}
