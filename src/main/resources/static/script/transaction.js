function showTransaction() {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlung: " + this.id;
	
    fetch('/transaction/' + this.id)
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
}