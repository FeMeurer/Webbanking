var transactionIndex = 0;

function showTransaction(index) {
	transactionIndex = index;
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlung: " + index;
	
    fetch('/transaction/' + index)
        .then(readTransactionData)
        .then(readTransactionJson)
}

function readTransactionData(data) {
    var json = data.json();
    return json;
}

function readTransactionJson(json) {
    var transactionDiv = document.createElement("div");
    transactionDiv.id = "transaction";
    
	var date = createDateString(json.date);
    var textElement = document.createTextNode("Datum: " + date); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));
    
    var textElement = document.createTextNode("Empfänger: " + json.receiver); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));
    
    var textElement = document.createTextNode("IBAN: " + json.iban); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));

    var textElement = document.createTextNode("BIC: " + json.bic); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));

    var textElement = document.createTextNode("Betrag: " + parseFloat(json.amount).toFixed(2) + "€"); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));

    var textElement = document.createTextNode("Verwendungszweck: " + json.purpose); 
    transactionDiv.appendChild(textElement);
    transactionDiv.appendChild(document.createElement("br"));
    
    document.getElementById("content").appendChild(transactionDiv);
    
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Löschen";
    button.addEventListener("click", function(){removeTransaction(transactionIndex)});
    
    document.getElementById("content").appendChild(button);
    
    var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Ändern";
    button.addEventListener("click", function(){editTransaction(json, transactionIndex)});
    
    document.getElementById("content").appendChild(button);
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
	
	var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Hinzufügen";
    button.addEventListener("click", executeAddTransaction);
    document.getElementById("content").appendChild(button);
}
    
function executeAddTransaction() {  
	var data = {
		id: document.getElementById("id").value,
		receiver: document.getElementById("receiver").value,
		iban: document.getElementById("iban").value,
		bic: document.getElementById("bic").value,
		amount: document.getElementById("amount").value,
		purpose: document.getElementById("purpose").value
	}
	
	var json = JSON.stringify(data);
	
	var method = {
		method: 'POST',
		headers: new Headers({'content-type': 'application/json'}),
		body: json
	}
		
    fetch('/transaction', method)
        .then(function(){fetchSuccess("Zahlung wurde hinzugefügt!")})
}

function editTransaction(json, index) {
	var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);
	
	createForm();
	document.getElementById("id").value = json.id;
	document.getElementById("receiver").value = json.receiver;
	document.getElementById("iban").value = json.iban;
	document.getElementById("bic").value = json.bic;
	document.getElementById("amount").value = json.amount;
	document.getElementById("purpose").value = json.purpose;
	
	var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Änderung speichern";
    button.addEventListener("click", function(){executeEditTransaction(index)});
    document.getElementById("content").appendChild(button);
}

function executeEditTransaction(index) {  
	var data = {
		id: document.getElementById("id").value,
		receiver: document.getElementById("receiver").value,
		iban: document.getElementById("iban").value,
		bic: document.getElementById("bic").value,
		amount: document.getElementById("amount").value,
		purpose: document.getElementById("purpose").value
	}
	
	var json = JSON.stringify(data);
	
	var method = {
		method: 'PUT',
		headers: new Headers({'content-type': 'application/json'}),
		body: json
	}
		
    fetch('/transaction/' + index, method)
        .then(function(){fetchSuccess("Zahlung wurde geändert!")})
}

function fetchSuccess(Text) {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);
    
    var textElement = document.createTextNode(Text);
	contentDiv.appendChild(textElement);
	
	var button = document.createElement("Button");
    button.type = "button";
    button.innerHTML = "Zurück";
    button.addEventListener("click", showTransactionList);
    
    document.getElementById("content").appendChild(button);
}

function createForm() {
	var divForm = document.createElement("div");
	divForm.class = "form-transaction";
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "ID: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "number";
	inputFormParam.class = "form-field";
	inputFormParam.id = "id";
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "Empfänger: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.class = "form-field";
	inputFormParam.id = "receiver";
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "IBAN: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.class = "form-field";
	inputFormParam.id = "iban";
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "BIC: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.class = "form-field";
	inputFormParam.id = "bic";
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "Betrag: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "number";
	inputFormParam.step = "0.01"
	inputFormParam.class = "form-field";
	inputFormParam.id = "amount"
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
	
	var divFormParam = document.createElement("div");
	divFormParam.class = "form-transaction-parameter";
	var labelFormParam = document.createElement("label");
	labelFormParam.innerHTML = "Verwendungszweck: ";
	var inputFormParam = document.createElement("input");
	inputFormParam.type = "text";
	inputFormParam.class = "form-field";
	inputFormParam.id = "purpose"
	divFormParam.appendChild(labelFormParam);
	divFormParam.appendChild(inputFormParam);
	divForm.appendChild(divFormParam);
    
    document.getElementById("content").appendChild(divForm);
}
