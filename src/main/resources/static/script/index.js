var flexbox = document.getElementById("flex-container");

function readData(data) {
    var json = data.json();
    return json;
}

function readJson(json) {
	console.log(json);
    json.transactions.forEach(element => {
        var transaction = element.receiver + " " + element.iban + " " + element.bic + " " + element.purpose + " " + element.amount;
        
        //var transaction = json.receiver + " " + json.iban + " " + json.bic + " " + json.purpose + " " + json.amount;
        var transactionElement = document.createElement("a");
        transactionElement.setAttribute("href", ("transaction.html?transaction=" + element.id));
       	var divElement = document.createElement("div");
        divElement.className = "transaction-select-container"
        var textElement = document.createTextNode(transaction) 
        
        
        divElement.appendChild(textElement);
        transactionElement.appendChild(divElement);
        flexbox.appendChild(transactionElement);
    });
    
}

fetch('/data/transactions.json')
    .then(readData)
    .then(readJson)