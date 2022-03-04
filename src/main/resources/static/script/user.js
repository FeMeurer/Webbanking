function login() {
    var newTransactionDiv = document.getElementById("gotoNewTransaction");
    if (newTransactionDiv != null) {
        newTransactionDiv.remove();
    }

    var logoutDiv = document.getElementById("logout");
    if (logoutDiv != null) {
        logoutDiv.remove();
    }

    var userDataDiv = document.getElementById("userData");
    if (userDataDiv != null) {
        userDataDiv.remove();
    }

    document.getElementById("gotoIndex").addEventListener('click', login);

    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Login";

    var flexDiv = document.createElement("div");
    flexDiv.id = "flex-container-login";
    document.getElementById("content").appendChild(flexDiv);

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
	flexDiv.appendChild(divElement);

    var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Registrieren";
    button.id = "btn_register";
    button.addEventListener("click", register);
    
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

function logout() {
    userSession = null;
    login();
}

function register() {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Registrieren";

    var flexDiv = document.createElement("div");
    flexDiv.id = "flex-container-login";
    document.getElementById("content").appendChild(flexDiv);

    var divElement = document.createElement("div");
    divElement.className = "login-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Vorame: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "name";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	flexDiv.appendChild(divElement);

    var divElement = document.createElement("div");
    divElement.className = "login-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Nachname: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "surname";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	flexDiv.appendChild(divElement);

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
	flexDiv.appendChild(divElement);

    var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.id = "btn_back";
    button.addEventListener("click", login);
    
    divButtons.appendChild(button);   

    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Registrieren";
    button.className = "btn_functions";
    button.addEventListener("click", addUser);
    
    divButtons.appendChild(button);
}

function addUser() {
    var data = {
        name: document.getElementById("name").value,
        surname: document.getElementById("surname").value,
        username: document.getElementById("username").value,
    }

    var json = JSON.stringify(data);

    var method = {
		method: 'POST',
		headers: new Headers({'content-type': 'application/json'}),
		body: json
	}

    fetch('/customer', method)
        .then(function(){fetchSuccessCustomer("Konto wurde erstellt")})
}

function fetchSuccessCustomer(Text) {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);
    
    var divNotification = document.createElement("div");
	divNotification.className = "notification";
	divNotification.innerHTML = Text
	document.getElementById("content").appendChild(divNotification);
	
	var divButtons = document.createElement("div");
	divButtons.className = "notification-buttons"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.id = "btn_back";
    button.addEventListener("click", login);
    divButtons.appendChild(button);
}