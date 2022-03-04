function login() {
    var newTransactionDiv = document.getElementById("gotoNewTransaction");
    if (newTransactionDiv != null) {
        newTransactionDiv.remove();
    }

    document.getElementById("gotoIndex").addEventListener('click', login);

    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Login";

    var transactionDiv = document.createElement("div");
    transactionDiv.id = "flex-container-login";
    document.getElementById("content").appendChild(transactionDiv);

    var divElement = document.createElement("div");
    divElement.className = "login-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Benutzername: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "username";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);

    var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Registrieren";
    button.id = "btn_register";
    //button.addEventListener("click", showTransactionList);
    
    divButtons.appendChild(button);

    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Anmelden";
    button.className = "btn_functions";
    button.addEventListener("click", queryUser);
    
    divButtons.appendChild(button);
}

function queryUser() {
    fetch('/customer/' + document.getElementById("username").value)
    .then(response => {
        if (response.ok) {
            return getJsonData(response);
        }
        else {
            alert("Benutzername exisitert nicht");
            return Promise.reject('error 404');
        }
    })
    .then(saveUsersession)
    .catch(error => console.log(error))
}

function saveUsersession(json) {
    userSession = json;
    showTransactionList();
}