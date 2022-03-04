var transactionIndex = 0;

function showTransaction(index) {
	transactionIndex = index;
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlung: " + index;
	
    fetch('/transaction/' + index)
        .then(getJsonData)
        .then(readTransactionJson)
}

function readTransactionJson(json) {
    var transactionDiv = document.createElement("div");
    transactionDiv.id = "flex-container";
    document.getElementById("content").appendChild(transactionDiv);
    
    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Datum:"
    var dataElement = document.createElement("div");
    var date = createDateString(json.creationdate);
    dataElement.innerHTML = date;
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Empfänger:"
    var dataElement = document.createElement("div");
    dataElement.innerHTML = json.receiver;
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
    transactionDiv.appendChild(divElement);
    
    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "IBAN:"
    var dataElement = document.createElement("div");
    dataElement.innerHTML = json.iban.iban;
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);

    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "BIC:"
    var dataElement = document.createElement("div");
    dataElement.innerHTML = json.iban.bic.bic;
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Betrag:"
    var dataElement = document.createElement("div");
    dataElement.innerHTML = parseFloat(json.amount).toFixed(2) + "€";
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);

    var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Verwendungszweck:"
    var dataElement = document.createElement("div");
    dataElement.innerHTML = json.purpose;
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
	var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.id = "btn_back";
    button.addEventListener("click", showTransactionList);
    
    divButtons.appendChild(button);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Löschen";
    button.className = "btn_functions";
    button.addEventListener("click", function(){removeTransaction(transactionIndex)});
    
    divButtons.appendChild(button);
    
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Ändern";
    button.className = "btn_functions";
    button.addEventListener("click", function(){editTransaction(json)});
    
    divButtons.appendChild(button);
}

function removeTransaction(index) {
	var method = {
		method: 'DELETE'
	}
	
    fetch('/transaction/' + index, method)
    	.then(function(){fetchSuccess("Zahlung wurde gelöscht!")})
}

function addTransaction() {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlung hinzufügen";
	
	createForm();
	
	var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.id = "btn_back";
    button.addEventListener("click", showTransactionList);
    
    divButtons.appendChild(button);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Erstellen";
    button.className = "btn_functions";
    button.addEventListener("click", executeAddTransaction);
    
    divButtons.appendChild(button);
}
    
function executeAddTransaction() {  
	var data = {
    	amount: document.getElementById("amount").value,
    	receiver: document.getElementById("receiver").value,
		customer: {
			id:	userSession.id
		},
	    iban: {
	      iban: document.getElementById("iban").value,
	      bic: {
	        bic: document.getElementById("bic").value,
	        institute: ""
	      }
	    },
	    purpose: document.getElementById("purpose").value,
	}
	
	var json = JSON.stringify(data);
	
	var method = {
		method: 'POST',
		headers: new Headers({'content-type': 'application/json'}),
		body: json
	}
		
    fetch('/transaction/', method)
        .then(function(){fetchSuccess("Zahlung wurde hinzugefügt!")})
}

function editTransaction(json) {
	var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);
	
	createForm();
	document.getElementById("receiver").value = json.receiver;
	document.getElementById("iban").value = json.iban.iban;
	document.getElementById("iban").disabled = "true";
	document.getElementById("bic").value = json.iban.bic.bic;
	document.getElementById("bic").disabled = "true";
	document.getElementById("amount").value = parseFloat(json.amount).toFixed(2);
	document.getElementById("purpose").value = json.purpose;
	
	var divButtons = document.createElement("div");
	divButtons.id = "button-container"
	document.getElementById("content").appendChild(divButtons);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.id = "btn_back";
    button.addEventListener("click", showTransactionList);
    
    divButtons.appendChild(button);
	
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Ändern";
    button.className = "btn_functions";
    button.addEventListener("click", function(){executeEditTransaction(json)});
    
    divButtons.appendChild(button);
}

function executeEditTransaction(json) {  
	var data = {
		id: json.id,
    	amount: document.getElementById("amount").value,
    	receiver: document.getElementById("receiver").value,
		customer: {
			id:	json.customer.id
		},
	    iban: {
		  id: json.iban.id,
	      iban: document.getElementById("iban").value,
	      bic: {
			id: json.iban.bic.id,
			bic: document.getElementById("bic").value,
	        institute: ""
	      }
	    },
	    purpose: document.getElementById("purpose").value,
	}
	
	var json = JSON.stringify(data);
	console.log(json);
	
	var method = {
		method: 'POST',
		headers: new Headers({'content-type': 'application/json'}),
		body: json
	}
		
    fetch('/transaction/', method)
        .then(function(){fetchSuccess("Zahlung wurde geändert!")})
}

function fetchSuccess(Text) {
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
    button.addEventListener("click", showTransactionList);
    divButtons.appendChild(button);
}

function createForm() {
    var transactionDiv = document.createElement("div");
    transactionDiv.id = "flex-container";
    document.getElementById("content").appendChild(transactionDiv);
	
	var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Empfänger: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "receiver";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
	var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "IBAN: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "iban";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
	var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "BIC: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "bic";
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
	var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Betrag: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "number";
	inputFormParam.step = "0.01"
	inputFormParam.className = "form-field";
	inputFormParam.id = "amount"
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
	
	var divElement = document.createElement("div");
    divElement.className = "transaction-property"
    var labelElement = document.createElement("div");
    labelElement.innerHTML = "Verwendungszweck: "
    var dataElement = document.createElement("div");
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.className = "form-field";
	inputFormParam.id = "purpose"
	dataElement.appendChild(inputFormParam);
	divElement.appendChild(labelElement);
	divElement.appendChild(dataElement);
	transactionDiv.appendChild(divElement);
}
