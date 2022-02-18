var transactionDiv = document.getElementById("transaction");
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const urlTransaction = urlParams.get('transaction');
console.log(queryString);
console.log(urlParams);
console.log(urlTransaction);

function readData(data) {
    var json = data.json();
    return json;
}

function readJson(json) {
		var br = document.createElement("br");
	
        var textElementReceiver = document.createTextNode("Empfänger: " + json.receiver) 
        transactionDiv.appendChild(textElementReceiver);
        var br1 = document.createElement("br");
		transactionDiv.appendChild(br1);
        var textElementIban = document.createTextNode("IBAN: " + json.iban)
        transactionDiv.appendChild(textElementIban);
        var br2 = document.createElement("br");
		transactionDiv.appendChild(br2);
        var textElementBic = document.createTextNode("BIC: " + json.bic)
        transactionDiv.appendChild(textElementBic);
        var br3 = document.createElement("br");
		transactionDiv.appendChild(br3);
        var textElementPurpose = document.createTextNode("Verwendungszweck: " + json.purpose)
        transactionDiv.appendChild(textElementPurpose);
        var br4 = document.createElement("br");
		transactionDiv.appendChild(br4);
        var textElementAmount = document.createTextNode("Betrag: " + parseFloat(json.amount).toFixed(2));
        transactionDiv.appendChild(textElementAmount); 
        var br5 = document.createElement("br");
		transactionDiv.appendChild(br5);
}

fetch('/data/' + urlTransaction + '/oneTransaction.json')
    .then(readData)
    .then(readJson)